package org.csvfiletomysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/imdb_top_1000_movies";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {

        String fileName = "src/main/java/org/csvfiletomysql/imdb_top_1000.csv";

        List<Movie> movies = readCsvFile(fileName);


        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO `movies`(`movie_poster_link`, `movie_series_title`, `movie_released_year`, `movie_certificate`, `movie_runtime`, `movie_genre`, `movie_imdb_rating`, `movie_overview`, `movie_meta_score`, `movie_director`, `movie_star1`, `movie_star2`, `movie_star3`, `movie_star4`, `movie_no_of_votes`, `movie_gross`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            for (Movie movie : movies) {
                statement.setString(1, movie.getPoster_link());
                statement.setString(2, movie.getSeries_title());
                statement.setInt(3, movie.getReleased_year());
                statement.setString(4,movie.getCertificate());
                statement.setString(5,movie.getRuntime());
                statement.setString(6,movie.getGenre());
                statement.setFloat(7,movie.getImdb_rating());
                statement.setString(8,movie.getOverview());
                statement.setInt(9,movie.getMeta_score());
                statement.setString(10,movie.getDirector());
                statement.setString(11,movie.getStar1());
                statement.setString(12,movie.getStar2());
                statement.setString(13,movie.getStar3());
                statement.setString(14,movie.getStar4());
                statement.setLong(15,movie.getNo_of_votes());
                statement.setString(16,movie.getGross());

                statement.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static List<Movie> readCsvFile(String fileName) {
        List<Movie> movies = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine(); // skip the header line

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                List<String> evalColumns = List.of(columns);
                if(columns.length >= 16 && !evalColumns.contains("")){
                    try {
                        Movie movie = new Movie();
                        movie.setPoster_link(columns[0]);
                        movie.setSeries_title(columns[1]);
                        movie.setReleased_year(Integer.parseInt(columns[2]));
                        movie.setCertificate(columns[3]);
                        movie.setRuntime(columns[4]);
                        movie.setGenre(columns[5]);
                        movie.setImdb_rating(Float.parseFloat(columns[6]));
                        movie.setOverview(columns[7]);
                        movie.setMeta_score(Integer.parseInt(columns[8]));
                        movie.setDirector(columns[9]);
                        movie.setStar1(columns[10]);
                        movie.setStar2(columns[11]);
                        movie.setStar3(columns[12]);
                        movie.setStar4(columns[13]);
                        movie.setNo_of_votes(Long.parseLong(columns[14]));
                        movie.setGross(columns[15]);
                        movies.add(movie);
                    } catch (NumberFormatException e) {
                        System.out.println("");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movies;
    }
}
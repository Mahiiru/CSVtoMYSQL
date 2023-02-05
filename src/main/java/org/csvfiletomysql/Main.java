package org.csvfiletomysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/movies";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String fileName = "movies.csv";

        List<Movie> movies = readCsvFile(fileName);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO movies (title, year, rating) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            for (Movie movie : movies) {
                statement.setString(1, movie.getTitle());
                statement.setInt(2, movie.getYear());
                statement.setDouble(3, movie.getRating());

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
                String[] columns = line.split(",");

                Movie movie = new Movie();
                movie.setTitle(columns[0]);
                movie.setYear(Integer.parseInt(columns[1]));
                movie.setRating(Double.parseDouble(columns[2]));

                movies.add(movie);
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
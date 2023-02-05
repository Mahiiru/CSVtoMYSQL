package org.csvfiletomysql;


public class Movie {
    private String poster_link;
    private String series_title;
    private int released_year;
    private String certificate;
    private String runtime;
    private String genre;
    private float imdb_rating;
    private String overview;
    private int meta_score;
    private String director;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private long no_of_votes;
    private String gross;

    public String getPoster_link() {
        return poster_link;
    }

    public void setPoster_link(String poster_link) {
        this.poster_link = poster_link;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    public int getReleased_year() {
        return released_year;
    }

    public void setReleased_year(int released_year) {
        this.released_year = released_year;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(float imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getMeta_score() {
        return meta_score;
    }

    public void setMeta_score(int meta_score) {
        this.meta_score = meta_score;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar1() {
        return star1;
    }

    public void setStar1(String star1) {
        this.star1 = star1;
    }

    public String getStar2() {
        return star2;
    }

    public void setStar2(String star2) {
        this.star2 = star2;
    }

    public String getStar3() {
        return star3;
    }

    public void setStar3(String star3) {
        this.star3 = star3;
    }

    public String getStar4() {
        return star4;
    }

    public void setStar4(String star4) {
        this.star4 = star4;
    }

    public long getNo_of_votes() {
        return no_of_votes;
    }

    public void setNo_of_votes(long no_of_votes) {
        this.no_of_votes = no_of_votes;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "poster_link='" + poster_link + '\'' +
                ", series_title='" + series_title + '\'' +
                ", released_year=" + released_year +
                ", certificate='" + certificate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", imdb_rating=" + imdb_rating +
                ", overview='" + overview + '\'' +
                ", meta_score=" + meta_score +
                ", director='" + director + '\'' +
                ", star1='" + star1 + '\'' +
                ", star2='" + star2 + '\'' +
                ", star3='" + star3 + '\'' +
                ", star4='" + star4 + '\'' +
                ", no_of_votes=" + no_of_votes +
                ", gross='" + gross + '\'' +
                '}';
    }
}

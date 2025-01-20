package server.model;


import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Movie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Rated")
    private String rated;


    @SerializedName("Released")
    private String released;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Language")
    private String language;

    @SerializedName("Country")
    private String country;

    @SerializedName("Awards")
    private String awards;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +  '\n' +
                ", year='" + year + '\'' + '\n' +
                ", runtime='" + runtime + '\'' + '\n' +
                ", genre='" + genre + '\'' + '\n' +
                ", director='" + director + '\'' + '\n' +
                ", plot='" + plot + '\'' + '\n' +
                ", poster='" + poster + '\'' + '\n' +
                ", rated='" + rated + '\'' + '\n' +
                ", released='" + released + '\'' + '\n' +
                ", actors='" + actors + '\'' + '\n' +
                ", language='" + language + '\'' + '\n' +
                ", country='" + country + '\'' + '\n' +
                ", awards='" + awards + '\'' + '\n' +
                '}';
    }
}


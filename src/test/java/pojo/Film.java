package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {

    private String title;
    private List<String> charactersHTTP;
    private String url;

    public Film() {}

    @JsonCreator
    public Film(@JsonProperty("title") String title, @JsonProperty("characters") List<String> charactersHTTP,
                @JsonProperty("url") String url) {
        this.title = title;
        this.charactersHTTP = charactersHTTP;
        this.url = url;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("characters")
    public List<String> getCharacters() {
        return charactersHTTP;
    }

    public void setCharacters(List<String> characters) {
        this.charactersHTTP = characters;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "The Film is '" + title + '\'' + ", charactersHTTP=" + this.getCharacters().toString() +
                ", url='" + url + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return title.equals(film.title) && charactersHTTP.equals(film.charactersHTTP) && url.equals(film.url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.getTitle() == null ? 0 : this.getTitle().hashCode()));
        result = prime * result + ((this.getCharacters().isEmpty() ? 0 : this.getCharacters().hashCode()));
        result = prime * result + ((this.getUrl() == null ? 0 : this.getUrl().hashCode()));
        return result;
    }
}

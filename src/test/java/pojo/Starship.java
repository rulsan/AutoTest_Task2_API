package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship {
    private String name;
    private String starship_class;
    private List<String> pilotsHTTP;
    private String url;

    public Starship() {}

    @JsonCreator
    public Starship(@JsonProperty("name") String name, @JsonProperty("starship_class") String starship_class,
                    @JsonProperty("pilots") List<String> pilotsHTTP, @JsonProperty("url") String url) {
        this.name = name;
        this.starship_class = starship_class;
        this.pilotsHTTP = pilotsHTTP;
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("starship_class")
    public String getStarship_class() {
        return starship_class;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
    }

    @JsonProperty("pilots")
    public List<String> getPilots() {
        return pilotsHTTP;
    }

    public void setPilots(List<String> pilots) {
        this.pilotsHTTP = pilots;
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
        return "The Starship is " + name + '\'' + ", starship_class='" + starship_class + '\'' + ", pilotsHTTP=" + this.getPilots().toString() + ", url='" + url + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starship starship = (Starship) o;
        return name.equals(starship.name) && starship_class.equals(starship.starship_class) && pilotsHTTP.equals(starship.pilotsHTTP) && url.equals(starship.url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.getName() == null ? 0 : this.getName().hashCode()));
        result = prime * result + ((this.getStarship_class() == null ? 0 : this.getStarship_class().hashCode()));
        result = prime * result + ((this.getPilots().isEmpty() ? 0 : this.getPilots().hashCode()));
        result = prime * result + ((this.getUrl() == null ? 0 : this.getUrl().hashCode()));
        return result;
    }
}

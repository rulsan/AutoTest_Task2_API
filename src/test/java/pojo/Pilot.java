package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pilot {
    private String name;
    private List<String> starshipsHTTP;
    private String url;

    public Pilot() {}

    @JsonCreator
    public Pilot(@JsonProperty("name") String name, @JsonProperty("starships") List<String> starshipsHTTP,
                 @JsonProperty("url") String url) {
        this.name = name;
        this.starshipsHTTP = starshipsHTTP;
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("starships")
    public List<String> getStarships() {
        return starshipsHTTP;
    }

    public void setStarships(List<String> starships) {
        this.starshipsHTTP = starships;
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
        return "The Pilot is '" + name + '\'' + ", starshipsHTTP=" + getStarships().toString() + ", url='" + url + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return name.equals(pilot.name) && starshipsHTTP.equals(pilot.starshipsHTTP) && url.equals(pilot.url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.getName() == null ? 0 : this.getName().hashCode()));
        result = prime * result + ((this.getStarships().isEmpty() ? 0 : this.getStarships().hashCode()));
        result = prime * result + ((this.getUrl() == null ? 0 : this.getUrl().hashCode()));
        return result;
    }
}

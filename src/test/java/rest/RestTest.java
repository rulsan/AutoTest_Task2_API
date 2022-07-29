package rest;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.junit.jupiter.api.Test;
import pojo.Pilot;
import pojo.Film;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {

    public ExtractableResponse getObj(String http){
        return given().when().get(http).then().contentType(ContentType.JSON).extract();
    }

    public List<Film> getFilms(){
        return getObj("https://swapi.dev/api/films").jsonPath().getList("results", Film.class);
    }

    public List<Pilot> getPilots(){
        return getObj("https://swapi.dev/api/people").jsonPath().getList("results", Pilot.class);
    }

    public Pilot getPilot(String http){
        return getObj(http).as(Pilot.class);
    }

    @Test
    public void RestTest(){

        String LukeSkywalkerPilot = getPilots().stream()
                .filter(f -> f.getName().equals("Luke Skywalker"))
                .map(p -> p.getUrl()).findFirst().get();

        System.out.println("Luke Skywalker is " + LukeSkywalkerPilot);

        String XWingShipHTTP =  getFilms().stream()
                .filter(f -> f.getTitle().equals("A New Hope")).findFirst().get()
                .getCharacters().stream()
                .filter(p -> getPilot(p).getName().equals("Biggs Darklighter"))
                .map(p -> getPilot(p).getStarships().get(0)).findFirst().get();

        System.out.println("Starship is " + XWingShipHTTP);

        given().when().get(XWingShipHTTP).then()
                .assertThat()
                .body("starship_class", is("Starfighter"))
                .body("pilots", hasItem(LukeSkywalkerPilot));
    }
}

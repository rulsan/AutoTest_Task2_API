package rest;

import actions.Actions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class RestTest {

    public String FirstPilot = "Luke Skywalker";
    public String SecondPilot = "Biggs Darklighter";
    public String Film = "A New Hope";
    public String StarshipClass = "Starfighter";

    @Test
    public void RestTest(){

        String LukeSkywalkerPilot = Actions.getPilotFromList(FirstPilot);
        System.out.println(FirstPilot + " is " + LukeSkywalkerPilot);

        String XWingShipHTTP =  Actions.getFilms().stream()
                .filter(f -> f.getTitle().equals(Film)).findFirst().get()
                .getCharacters().stream()
                .filter(p -> Actions.getPilot(p).getName().equals(SecondPilot))
                .map(p -> Actions.getPilot(p).getStarships().get(0)).findFirst().get();

        System.out.println("In '" + Film + "' film the pilot '" + SecondPilot + "' piloted " + XWingShipHTTP + " starship");

        given().when().get(XWingShipHTTP).then()
                .assertThat()
                .body("starship_class", is(StarshipClass))
                .body("pilots", hasItem(LukeSkywalkerPilot));
    }
}

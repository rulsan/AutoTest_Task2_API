package services;

// основные классы для того, чтобы осуществить запрос;
// методы возвращают Response,
// никакой обработки ответа в этом слое не происходит

// один класс соответствует определённой группе эндпоинтов
// (авторизация отдельно, операции с заказами отдельно,
// регистрация пользователя отдельно и т.п.)

import io.restassured.response.ExtractableResponse;
import static io.restassured.RestAssured.given;
import static requests.Request.requestSpec;

public class Service {

    public static ExtractableResponse getObj(String http){
        return given()
                    .spec(requestSpec).
                when()
                    .get(http).
                then()
                    .extract();
    }
}

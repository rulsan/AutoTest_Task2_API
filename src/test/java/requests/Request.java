package requests;

// подготовка реквеста,
// классы с методами для создания query/body/headers и так далее

// один класс соответствует определённой группе эндпоинтов
// (авторизация отдельно, операции с заказами отдельно,
// регистрация пользователя отдельно и т.п.)

// Можно выделить общие классы для построения базовых запросов
// (getWithBody(String url, Object body){...})
// - это будет по сути обёртка над методами RA, можно её опустить

// Для общих Request/ResponseSpecifications

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Request {

    public static RequestSpecification requestSpec = given()
                                                            .baseUri("https://swapi.dev/api")
                                                            .contentType(ContentType.JSON) ;

}

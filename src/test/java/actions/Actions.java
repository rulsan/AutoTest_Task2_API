package actions;

//слой для более высокоуровневых действий,
// например, сделать запрос, получить ответ (опционально - как-то провалидировать),
// из ответа вытащить какие-то данные (например, создать некий заказ в приложении
// и получить его номер, чтобы когда-то потом иметь возможность его отменить)

// один класс соответствует определённой группе эндпоинтов
// (авторизация отдельно, операции с заказами отдельно,
// регистрация пользователя отдельно и т.п.)

import pojo.Film;
import pojo.Pilot;
import services.Service;

import java.util.List;

public class Actions {

    public static List<Film> getFilms(){
        return Service.getObj("/films").jsonPath().getList("results", Film.class);
    }

    public static List<Pilot> getPilots(){
        return Service.getObj("/people").jsonPath().getList("results", Pilot.class);
    }

    public static Pilot getPilot(String http){
        return Service.getObj(http).as(Pilot.class);
    }

    public static String getPilotFromList(String pilot){
        return Actions.getPilots().stream()
                .filter(f -> f.getName().equals(pilot))
                .map(p -> p.getUrl()).findFirst().get();
    }


}

package projet1;

import projet1.dao.*;
import projet1.model.*;
import projet1.model.Character;

import java.util.List;

public class Application {

    public static void main(String[] args){
        UserDao userDAO = new UserDaoImpl();
        CharacterDao characterDAO = new CharacterDaoImpl();
        LevelElementDao levelElementDao = new LevelElementDaoImpl();

        userDAO.create(new User("alaeannassi@gmail.com", "alae"));
        User user1 = userDAO.findUserByEmail("alaeannassi@gmail.com");
        if (user1 != null) {
            characterDAO.create(new Orc("user1", user1));
        } else {
            System.out.println("user is null");
        }

        List<Character> user1Orc = characterDAO.findCharactersByName("user1");

        Item item1 = new Item(new LevelElementId("item1", 10), 10, Color.BLUE);
        levelElementDao.create(item1);
        item1 = (Item) levelElementDao.findById(new LevelElementId("item1", 10));
        if (!user1Orc.isEmpty()) {
            Character orc = user1Orc.get(0);
            orc.setHealth(10);
            characterDAO.update(orc);
            item1.getCharacters().clear();
            item1.getCharacters().add(orc);
            levelElementDao.update(item1);
        }

        EntityManagerFactorySingleton.getInstance().close();
    }
}

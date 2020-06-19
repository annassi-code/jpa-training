package projet1.dao;

import projet1.model.Character;

import java.util.List;

public interface CharacterDao extends GenericDao<Character, Long> {
    List<Character> findCharactersByName(String name);
}

package World.Games;

import World.Civilization.Gender;
import World.Civilization.Human;
import World.World;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    public Game(int days, int professionalPlayers, int tributePlayers )
    {
        this.days = days;
        AssignPlayers(professionalPlayers, Human.Role.PROFESSIONAL);
        AssignPlayers(professionalPlayers, Human.Role.TRIBUTE);
    }
    private int days;

    private List<Human> players = new ArrayList<Human>();

    private void  AssignPlayers ( int amount, Human.Role role)
    {
        for(int i = 0; i < amount; i++)
            players.add(new Human(Gender.values()[World.getRandomInt(0,1)], role));
    }

    public List<Human> getPlayers()
    {
        return players;
    }
}

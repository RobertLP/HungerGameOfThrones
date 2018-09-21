package World.Games;
import World.World;

import java.util.ArrayList;
import java.util.List;

public class GameController
{
    private List<Game> playedGames = new ArrayList<>();
    private int eventCount;
    private boolean active;

    public void newGame()
    {   // Start game
        Game game = new Game(30, 25, 75);
        playedGames.add(game);
        active = true;
    }

    private Game getRecentGame()
    {
        return playedGames.get(playedGames.size() -1 );
    }

    public boolean isActive()
    {
        return active;
    }
}

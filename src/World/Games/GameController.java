package World.Games;
import World.World;

import java.util.ArrayList;
import java.util.List;

public class GameController
{
    private List<Game> playedGames = new ArrayList<>();
    private int eventCount;

    private boolean active = true;

    public boolean isActive()
    {
        return active;
    }

    public void newGame()
    {   // Start game
        Game game = new Game();
        playedGames.add(game);
    }

    public void nextEvent()
    {
        eventCount++;
        //System.out.println(eventCount + "   " + System.currentTimeMillis());
    }

    public void stop()
    {   // Stop game
        eventCount = 0;
    }
}

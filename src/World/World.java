package World;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import World.Civilization.District;
import World.Games.Game;
import World.Games.GameController;

public class World
{
    // singleton implementation
    private static World instance;
    private World(){}
    public static synchronized World getInstance()
    {
        if(instance == null)
            instance = new World();
        return instance;
    }
    // end

    public static final int DISTRICT_COUNT = 7;
    private static final Random random = new Random();

    private enum TimeSpecification{ DAY_TIME, NIGHT_TIME };
    private TimeSpecification timeSpecification;

    private GameController gameController = new GameController();
    private List<District> districts = new ArrayList<District>();

    public void start()
    {
        gameController.newGame();
        createDistricts(DISTRICT_COUNT);
    }

    private void createDistricts(int amount)
    {
        for(int i = 0; i < amount; i++)
            districts.add((new District(i)));
    }

    public District getDistrict(int districtNr)
    {
        return districts.get(districtNr);
    }

    public static int getRandomInt(int min, int max)
    {
        int random = World.random.nextInt(min + max);
        return random + min > min ? random - min : min;
    }

}

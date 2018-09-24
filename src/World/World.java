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
    private static final int WORLD_HEIGHT = 10;
    private static final int WORLD_WIDTH = 10;

    private static final Random random = new Random();

    private enum TimeSpecification{ DAY_TIME, NIGHT_TIME };
    private TimeSpecification timeSpecification;

    private GameController gameController = new GameController();
    private List<District> districts = new ArrayList<District>();

    private WorldTile[][] worldMap;
    private PerlinNoiseGenerator perlinGenerator;

    private boolean active = true;

    public enum PrintOutOption{TYPE, VALUE, SYMBOL, EFFICIENCY}

    public void start()
    {
        createDistricts(DISTRICT_COUNT);
        gameController.newGame();
        populateWorldMap();
        printOutWorldMap(PrintOutOption.SYMBOL);
        run();
    }

    private void run()
    {
        while(active)
        {
            active = false; // temp shutdown
        }
    }

    private void populateWorldMap()
    {   // new world map for each population
        PerlinNoiseGenerator noiseGen = new PerlinNoiseGenerator(getRandomInt(0, Integer.MAX_VALUE));
        worldMap = new WorldTile[WORLD_WIDTH][WORLD_HEIGHT];
        for(int x = 0; x < WORLD_WIDTH; x++)
            for(int y = 0; y < WORLD_HEIGHT; y++)
                worldMap[x][y] = new WorldTile(x, y, noiseGen);
    }


    public void printOutWorldMap(PrintOutOption option)
    {
        String ln = "";
        for(int y = 0; y < WORLD_HEIGHT; y++)
        {
            for (int x = 0; x < WORLD_WIDTH; x++)
            {
                switch (option) {
                    case VALUE:
                        ln += printOutValue(x, y);
                        break;
                    case TYPE:
                        ln += printOutType(x, y);
                        break;
                    case SYMBOL:
                        ln += printOutSymbol(x, y);
                        break;
                    case EFFICIENCY:
                        ln += printOutEfficiency(x, y);
                        break;
                }
            }
            System.out.println(ln);
            ln = "";
        }
    }
    private String printOutValue(int x, int y)
    {
        double value = worldMap[x][y].getPerlinValue();
        String toPrint = Double.toString(value);
        return toPrint.substring(0, toPrint.indexOf('.')+2) + " ";
    }
    private String printOutType(int x, int y)
    {
       return worldMap[x][y].getType().getShortHand() + " ";
    }

    private String printOutSymbol(int x, int y)
    {
        return worldMap[x][y].getType().getSymbol() + " ";
    }

    private String printOutEfficiency(int x, int y)
    {
        return worldMap[x][y].getType().getEfficiency() + " ";
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
package World;

import World.Games.Game;
import World.Games.GameController;

public class World {
    public static final float interfallTime = 0.00002f; // placeholder for real fps
    public static final float dayInterval = 10f; // time in seconds

    public GameController gameController = new GameController();
    public void start()
    {
        gameController.newGame();
        run();
    }

    private void run()
    {
        float intervalTimer = 0f;
        long last_time = System.nanoTime();
        while(gameController.isActive())
        {
            long time = System.nanoTime();
            int delta_time = (int) ((time - last_time) / 1000000);
            last_time = time;

            gameController.nextEvent();
            while(intervalTimer < World.dayInterval)
            {
                intervalTimer += interfallTime;
            }
            System.out.println(intervalTimer);
            intervalTimer = 0;
        }
    }
}

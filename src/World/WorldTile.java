package World;

import World.Civilization.Human;
import World.Items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WorldTile
{
    public WorldTile(int x, int y, PerlinNoiseGenerator noiseGen)
    {
        _x = x;
        _y = y;
        this.perlinValue = Mathf.NormalizeValue(
                noiseGen.improvedNoise(x+0.5,y+0.5,0),
                -1.0, 1.0
        );
        this.type = Terrain.findTerrainType( this.perlinValue );
    }
    private int _x, _y;
    private double perlinValue;
    private Terrain type;
    private HashSet<Human> humans = new HashSet<Human>();
    private List<Item> items = new ArrayList<Item>();
    public int x()
    {
        return _x;
    }
    public int y()
    {
        return _y;
    }
    public double getPerlinValue()
    {
        return perlinValue;
    }
    public Terrain getType() {
        return type;
    }
}

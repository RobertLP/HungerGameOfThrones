package World;

public enum Terrain
{
    WATER(0.25f, 'W'), SLUDGE( 0.5f, 'S'), PLAIN(0.75f, 'P'), FORREST(1f, 'F'), INVALID(-1f, 'I');

    Terrain(float value, char shortHand)
    {
        this.value = value;
        this.shortHand = shortHand;
    }
    private float value;
    private char shortHand;

    public float getValue() {
        return value;
    }

    public char getShortHand() {
        return shortHand;
    }

    public static Terrain findTerrainType(double value)
    {
        for(Terrain type : Terrain.values())
        {
            if(value > type.value)
                continue;
            return type;
        }
        return null;
    }
}

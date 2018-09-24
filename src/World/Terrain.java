package World;

public enum Terrain
{
    WATER(0.25f, 0.2f, 'W', '#'), SLUDGE( 0.5f, 0.6f, 'S', '%'), PLAIN(0.75f, 1, 'P', '-'),
    FORREST(1f, 0.8f, 'F', '|'), INVALID(-1f, 0, 'I', '!');

    Terrain(float value, float efficiency, char shortHand, char symbol)
    {
        this.value = value;
        this.efficiency = efficiency;
        this.shortHand = shortHand;
        this.symbol = symbol;
    }
    private float value;
    private float efficiency;
    private char shortHand;
    private char symbol;

    public float getValue() {
        return value;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public char getShortHand() {
        return shortHand;
    }

    public char getSymbol() {
        return symbol;
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

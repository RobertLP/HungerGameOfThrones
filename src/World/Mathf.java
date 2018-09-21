package World;

public class Mathf
{
    public static float NormalizeValue(float value, float min, float max)
    {
        return (value - min) / (max - min);
    }
    public static double NormalizeValue(double value, double min, double max)
    {
        return (value - min) / (max - min);
    }
}

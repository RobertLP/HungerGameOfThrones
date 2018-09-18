package World.Items;

import World.Civilization.Human;

public abstract class Item
{
    public enum SlotType
    {
        EDIBLE, BLUNT_OBJ, SHARP_OBJ, CONNECTOR,
    }
    public Item(String name)
    {
        this.name = name;
    }
    private String name;
    public abstract void use(Human human);
}

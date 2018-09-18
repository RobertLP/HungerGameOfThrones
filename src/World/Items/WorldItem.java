package World.Items;

import World.Civilization.Human;
import World.World;

public class WorldItem extends Item
{
    public static final int EDIBLE_HEAL_MIN = 15;
    public static final int EDIBLE_HEAL_MAX = 45;
    public SlotType slotType;
    public WorldItem(String name)
    {
        super(name);
        slotType = SlotType.values()[World.getRandomInt(0, SlotType.values().length)];
    }
    @Override
    public void use(Human user)
    {
        switch (slotType)
        {
            case EDIBLE:
                user.heal(World.getRandomInt(EDIBLE_HEAL_MIN, EDIBLE_HEAL_MAX));
                break;
            case BLUNT_OBJ:
            case CONNECTOR:
            case SHARP_OBJ:
            default:
                user.craft();
                break;
        }
    }
}

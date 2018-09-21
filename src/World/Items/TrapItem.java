package World.Items;

import World.Civilization.Human;

public class TrapItem extends Item
{
    private float damageAmount;
    public TrapItem(String name, float damageAmount) {
        super(name);
        this.damageAmount = damageAmount;
    }

    @Override
    public void use(Human human) {
        human.damage(damageAmount);
    }
}
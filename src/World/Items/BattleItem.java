package World.Items;

import World.Civilization.Human;

public class BattleItem extends Item
{
    public BattleItem(String name, ItemType itemType, int attackPower, int defense, int weight)
    {
        super(name);
        this.attackPower = attackPower;
        this.defense = defense;
        this.weight = weight;
        this.itemType = itemType;
    }

    public enum ItemType{ RANGED, MELEE, DEFENSE}
    public ItemType itemType;

    private int attackPower;
    private int defense;
    private int weight;

    @Override
    public void use(Human user)
    {

    }

    public int getAttackPower(){ return attackPower; }
    public int getDefense(){ return defense; }
    public int getWeight(){ return weight; }
}

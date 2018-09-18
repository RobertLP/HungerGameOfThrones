package World.Civilization;

import World.Items.Item;
import World.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human {
    // constants
    public enum Role{TRIBUTE, PROFESSIONAL}
    private static final int STAT_MIN = 1;
    private static final int STAT_MAX = 10;
    private static final float START_HEALTH = 100f;
    // constructor with call to onInstance setup method
    public Human(Gender gender, Role role) // TODO: give a chance indicator for better stats
    {
        this.role = role;
        this.gender = gender;
        onInstance();
    }
    private District district;
    private Role role;
    private Gender gender;
    // stats
    private float health = START_HEALTH;
    private int strength;
    private int agility;
    private int luck;
    private int intellect;
    private float carryCapacity;

    private List<Item> items = new ArrayList<Item>();

    private void onInstance()
    {   // init random numbers for human here
        assignDistrict();
        generateStats();
        carryCapacity = calcCarryCapacity(strength, agility);
    }

    private void generateStats()
    {
        strength = World.getRandomInt(STAT_MIN, STAT_MAX);
        agility = World.getRandomInt(STAT_MIN, STAT_MAX);
        luck = World.getRandomInt(STAT_MIN, STAT_MAX);
        intellect = World.getRandomInt(STAT_MIN, STAT_MAX);
    }

    private float calcCarryCapacity(int strength, int agility)
    {
        return (1.2f * strength) + (0.5f * agility);
    }

    private void assignDistrict()
    {
         district = World.getInstance().getDistrict( World.getRandomInt(0, World.DISTRICT_COUNT) );
    }

    public void heal( float amount )
    {
        health += amount;
        health = health > 100 ? 100 : health;
    }

    public void damage( float amount )
    {
        health -= amount;
        if(health <= 0)
        {
            // TODO: Destroy and remove
        }
    }

    public void craft()
    {
        // TODO: Crafting will be attempted here
    }

    public void tryItems()
    {
        for(int i = 0; i < items.size(); i++)
            items.get(i).use(this);
    }

    public int getStrength(){ return strength; }
    public int getAgility(){ return agility; }
    public int getLuck(){ return luck; }
    public int getIntellect(){ return intellect; }
    public int getDistrict(){ return district.getNumber(); }
    public float getCarryCapacity(){ return carryCapacity; }
    public float getHealth(){ return health; };
    public Role getRole(){ return role; }
    public Gender getGender(){ return gender; }

}

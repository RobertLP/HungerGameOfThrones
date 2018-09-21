package World.Civilization;

public enum Gender { MALE, FEMALE;

    public enum StatModifier{ STRENGTH, AGILITY, LUCK, INTELLECT }
    public float getModifier(StatModifier statModifier)
    {
        switch (this)
        {
            default:
            case MALE:
                return getMaleModifier(statModifier);
            case FEMALE:
                return getFemaleModifier(statModifier);
        }
    }

    private float getMaleModifier(StatModifier statModifier)
    {
        switch (statModifier)
        {
            default:
            case STRENGTH:
                return 1f;
            case LUCK:
                return 0.85f;
            case AGILITY:
                return 0.8f;
            case INTELLECT:
                return 0.95f;
        }
    }

    private float getFemaleModifier(StatModifier statModifier)
    {
        switch (statModifier)
        {
            case STRENGTH:
                return 0.8f;
            case LUCK:
                return 0.95f;
            default:
            case AGILITY:
                return 1f;
            case INTELLECT:
                return 0.85f;
        }
    }
}

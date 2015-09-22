package lab3;

import java.util.Random;

public class CuteCreature
{
    private String species;
    private int level, hitPoints, maxHitPoints, attackDamage, experiencePoints,
            experienceValue;
    
    

    /* ########## Getters and Setters ########## */
    
    /**
     * @return the species
     */
    public String getSpecies()
    {
        return species;
    }

    /**
     * @param species = the species to set
     */
    public void setSpecies(String species)
    {
        this.species = species;
    }

    /**
     * @return the level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * @param level = the level to set
     */
    public void setLevel(int level)
    {
        this.level = level;
    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints()
    {
        return hitPoints;
    }

    /**
     * @param hitPoints = the hitPoints to set
     */
    public void setHitPoints(int newHitPoints)
    {
        if(newHitPoints > this.getMaxHitPoints())
        {
            this.hitPoints = this.getMaxHitPoints();
        }
        else if (newHitPoints < 0)
        {
            this.hitPoints = 0;
        }
        else
        {
            this.hitPoints = newHitPoints;
        }
    }

    /**
     * @return the maxHitPoints
     */
    public int getMaxHitPoints()
    {
        return maxHitPoints;
    }

    /**
     * @param maxHitPoints = the maxHitPoints to set
     */
    public void setMaxHitPoints(int maxHitPoints)
    {
        this.maxHitPoints = maxHitPoints;
    }

    /**
     * @return the attackDamage
     */
    public int getAttackDamage()
    {
        return attackDamage;
    }

    /**
     * @param attackDamage = the attackDamage to set
     */
    public void setAttackDamage(int attackDamage)
    {
        this.attackDamage = attackDamage;
    }

    /**
     * @return the experiencePoints
     */
    public int getExperiencePoints()
    {
        return experiencePoints;
    }

    /**
     * @param experiencePoints = the experiencePoints to set
     */
    public void setExperiencePoints(int experiencePoints)
    {
        this.experiencePoints = experiencePoints;
    }

    /**
     * @return the experienceValue
     */
    public int getExperienceValue()
    {
        return experienceValue;
    }

    /**
     * @param experienceValue = the experienceValue to set
     */
    public void setExperienceValue(int experienceValue)
    {
        this.experienceValue = experienceValue;
    }
    
    /* ####### End of Getters and Setters ####### */
    
    
    
    public CuteCreature(String speciesName, int maxHPValue, int attackDamageValue, int experienceValueOnDeath)
    {
        this.setSpecies(speciesName);
        this.setMaxHitPoints(maxHPValue);
        this.setAttackDamage(attackDamageValue);
        this.setExperienceValue(experienceValueOnDeath);
        this.setLevel(1);
        this.setExperiencePoints(0);
        this.setHitPoints(this.getMaxHitPoints());
    }
    
    public void takeDamage(int dmg)
    {
        // Handled negative numbers in the setHitPoints() method
        this.setHitPoints(this.getHitPoints() - dmg);
    }
    
    private void levelUp()
    {
        this.setLevel(this.getLevel() + 1);
        this.setMaxHitPoints(this.getMaxHitPoints() + 5);
        this.setHitPoints(this.getHitPoints() + 5);
        this.setAttackDamage(this.getAttackDamage() + 3);
        this.setExperienceValue(this.getExperienceValue() + 15);
        
        this.gainExp(-150);
    }
    
    public void gainExp(int exp)
    {
        this.setExperiencePoints(this.getExperiencePoints() + exp);
        
        if (this.getExperiencePoints() > 150)
        {
            this.levelUp();
        }
    }
    
    public void attack(CuteCreature c)
    {
        System.out.println(this.getSpecies() + " attacks " + c.getSpecies() + " (might miss!)");
        Random roll = new Random();
        if (roll.nextInt(100) > 67)
        {
            c.takeDamage(this.getAttackDamage());
        }
        
        if (c.getHitPoints() == 0)
        {
            this.gainExp(c.getExperienceValue());
        }
    }
    
    @Override
    public String toString()
    {
        return "Level "  + this.getLevel() + " " + this.getSpecies() + "\r\n"
                + "----------------\r\n"
                + "HP: " + this.getHitPoints() + "/" + this.getMaxHitPoints() + "\r\n"
                + "Attack Dmg: " + this.getAttackDamage() + "\r\n"
                + "XP: " + this.getExperiencePoints() + "/150\r\n"
                + "XP Value: " + this.getExperienceValue() + "\r\n";
    }
}

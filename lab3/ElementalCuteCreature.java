package lab3;

/**
 * A Toy class for testing basic inheritance in java (Child)
 * 
 * @author Riley Redd
 * @version 1.0.0
 */
public class ElementalCuteCreature extends CuteCreature
{
    private String elementalAlignment;
    
    /**
     * @return the element
     */
    public String getElement()
    {
        return elementalAlignment;
    }

    /**
     * @param newElement the element to set
     */
    public void setElement(String newElement)
    {
        this.elementalAlignment = newElement;
    }
    
    
    /**
     * Same as parent class's constructor (save for elementalAlignment)
     * 
     * @param speciesName
     * @param maxHPValue
     * @param attackDamageValue
     * @param experienceValueOnDeath
     * @param elementalAlignmentName
     */
    public ElementalCuteCreature(String speciesName, int maxHPValue, int attackDamageValue, int experienceValueOnDeath,
                                 String elementalAlignmentName)
    {
        super(speciesName, maxHPValue, attackDamageValue, experienceValueOnDeath);
        
        this.setElement(elementalAlignmentName);
    }
    
    @Override
    public void attack(CuteCreature c)
    {
        //Except for the elemental part, this is all the same as the parent class's version
        if (Math.random()*100 > 67)
        {
            if (c instanceof ElementalCuteCreature)
            {
                String enemyElement = ( (ElementalCuteCreature) c).getElement();
                
                //This switch statement deals out elemental damage as called for by the assignment
                switch (this.getElement())
                {
                case "Earth":
                    if (enemyElement.equals("Fire"))
                        c.takeDamage(this.getAttackDamage());
                    if (enemyElement.equals("Water"))
                        c.takeDamage(2 * this.getAttackDamage());
                    if (enemyElement.equals("Air"))
                        c.takeDamage(this.getAttackDamage());
                    break;
                case "Water":
                    if (enemyElement.equals("Air"))
                        c.takeDamage(this.getAttackDamage());
                    if (enemyElement.equals("Fire"))
                        c.takeDamage(2 * this.getAttackDamage());
                    if (enemyElement.equals("Earth"))
                        c.takeDamage(this.getAttackDamage());
                    break;
                case "Air":
                    if (enemyElement.equals("Water"))
                        c.takeDamage(this.getAttackDamage());
                    if (enemyElement.equals("Earth"))
                        c.takeDamage(2 * this.getAttackDamage());
                    if (enemyElement.equals("Fire"))
                        c.takeDamage(this.getAttackDamage());
                    break;
                case "Fire":
                    if (enemyElement.equals("Earth"))
                        c.takeDamage(this.getAttackDamage());
                    if (enemyElement.equals("Air"))
                        c.takeDamage(2 * this.getAttackDamage());
                    if (enemyElement.equals("Water"))
                        c.takeDamage(this.getAttackDamage());
                    break;
                }
            }
            else
                c.takeDamage(this.getAttackDamage());
            
            if (c.getHitPoints() == 0)
            {
                this.gainExp(c.getExperienceValue());
            }
        }
    }
}

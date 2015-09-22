package lab3;

public class Client
{
    public static void main(String[] args)
    {
        CuteCreature picashoo = new CuteCreature("Picashoo", 40, 5, 70);
        CuteCreature magitrout = new CuteCreature("Magitrout", 10, 1, 15);
        CuteCreature dueses = new CuteCreature("Dueses", 50, 10, 75);
        CuteCreature alltehexp = new CuteCreature("Alltehexp", 0, 0, 500);
        ElementalCuteCreature blastyomama = new ElementalCuteCreature("Blastyomama", 60, 10, 10, "Water");
        ElementalCuteCreature charhisyard = new ElementalCuteCreature("Charhisyard", 60, 10, 10, "Fire");
        ElementalCuteCreature iveyoursword = new ElementalCuteCreature("Iveyoursword", 60, 10, 10, "Earth");
        ElementalCuteCreature spareme = new ElementalCuteCreature("Spareme", 60, 10, 10, "Air");
        ElementalCuteCreature aWaterElement = new ElementalCuteCreature("WaterElemental-0001", 60, 10, 10, "Water");
        
        System.out.println(picashoo);
        
        // Basic Attack
        System.out.println(dueses);
        System.out.println(magitrout);
        blastyomama.attack(magitrout);
        System.out.println(dueses);
        System.out.println(magitrout);
        
        // Guaranteed Experience
        System.out.println(picashoo);
        System.out.println(alltehexp);
        blastyomama.attack(alltehexp);
        System.out.println(picashoo);
        System.out.println(alltehexp);
        
        // Water vs Water
        System.out.println(blastyomama);
        System.out.println(aWaterElement);
        blastyomama.attack(aWaterElement);
        System.out.println(blastyomama);
        System.out.println(aWaterElement);

        // Water vs Fire
        System.out.println(blastyomama);
        System.out.println(charhisyard);
        blastyomama.attack(charhisyard);
        System.out.println(blastyomama);
        System.out.println(charhisyard);
        
        // Water vs Air
        System.out.println(blastyomama);
        System.out.println(spareme);
        blastyomama.attack(spareme);
        System.out.println(blastyomama);
        System.out.println(spareme);
        
        // Water vs Earth
        System.out.println(blastyomama);
        System.out.println(iveyoursword);
        blastyomama.attack(iveyoursword);
        System.out.println(blastyomama);
        System.out.println(iveyoursword);
        
        // Earth vs Normal
        System.out.println(iveyoursword);
        System.out.println(picashoo);
        iveyoursword.attack(picashoo);
        System.out.println(iveyoursword);
        System.out.println(picashoo);
    }
}

package lab9;

public class RecursiveStringReverse
{
    private static String reverse(String s)
    {
        if (s.length() <= 1)
            return s;
        else
        {
            return (s.charAt(s.length() - 1) 
                  + reverse(s.substring(0, s.length() - 1)));
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(reverse("Building"));
        System.out.println(reverse("Treaty"));
        System.out.println(reverse("Onomatopeia"));
        System.out.println(reverse("dad"));
        System.out.println(reverse("3L173N00B"));
    }
}

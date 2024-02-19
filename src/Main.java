import java.util.ArrayList;
public class Main
{

    public static void hitPlayer()
    {

        Card.infocarte ObPlayer = Card.randomOneCard(); // creation d'une nvl  instance pour avoir une carte aleatoire
        int Print_ValueCardPly = ObPlayer.getvalCarte();
        String Print_TypeCardPly = ObPlayer.getcarteType();
        Player.TotalValPlay +=ObPlayer.getvalCarte();
        System.out.println("[ " + Print_TypeCardPly + " ]" + " value : " + "[ " +Print_ValueCardPly+ " ]");

    }

    public static void hitCroupier()
    {
        Card.infocarte ObCroupier = Card.randomOneCard();
        int Print_ValueCardCrou =ObCroupier.getvalCarte();
        String Print_TypeCardCrou = ObCroupier.getcarteType();
        Croupier.totalValCroup += ObCroupier.getvalCarte();
        System.out.println("[ " + Print_TypeCardCrou + " ]" + " value : " + "[ " +Print_ValueCardCrou+ " ]");
    }

    public static void hitHiddenCard()
    {
        Card.infocarte ObCroupier = Card.randomOneCard();
        int Print_ValueCardCrou =ObCroupier.getvalCarte();
        String Print_TypeCardCrou = ObCroupier.getcarteType();
        Croupier.totalValCroup += ObCroupier.getvalCarte();

    }
}





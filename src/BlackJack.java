
public class BlackJack
{


    //turn the string value into  int value

    public static int getValueAsNumber(String value) { // convertisseur du carte ace
        if (value.equals("Ace"))
        {
            if((Player.TotalValPlay + 11) > 21 || (Croupier.totalValCroup + 11) > 21)
            {
                return 1;
            }
            else
            {
                return 11;
            }
        } else if (value.equals("JACK") || value.equals("KING") || value.equals("QUEEN")) {
            return 10;
        } else {
            return Integer.parseInt(value);
        }
    }

    public static void PlayerWin()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Vous avez gagné  :" + " <Total> "+"( "+Player.TotalValPlay + " )");// scan que le joueur gagne affiche le total du joueur
        System.out.println("Croupier perd  :" + " <Total> "+"( "+Croupier.totalValCroup + " )");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       // reinitialisation de total pour jouer a nv
        Player.TotalValPlay =0;
        Croupier.totalValCroup = 0;

    }
    public  static void CroupierWin()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Vous avez perdu  :" + " <Total> "+"( "+Player.TotalValPlay+" )"); // scan que le joueur perd affiche le total du joueur
        System.out.println("CROUPIER Win :" + " <Total> "+"( "+Croupier.totalValCroup + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Player.TotalValPlay =0;
        Croupier.totalValCroup = 0;

    }
    public static void TheBlackJack()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------BlackJack------------------------------------------------");
        System.out.println("Vous avez gagné :" + " <Total> "+"( "+Player.TotalValPlay+" )");
        System.out.println("CROUPIER  :" + " <Total> "+"( "+Croupier.totalValCroup + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Player.TotalValPlay =0;
        Croupier.totalValCroup = 0;

    }

    public static  void PartieNull(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------Partie NULL------------------------------------------------");// scan que la partie jouée est nulle affiche le total du joueur
        System.out.println("Totat:" + " <Total> "+"( "+Player.TotalValPlay+" )");
        System.out.println("CROUPIER  :" + " <Total> "+"( "+Croupier.totalValCroup + " )");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Player.TotalValPlay =0;
        Croupier.totalValCroup = 0;

    }


}



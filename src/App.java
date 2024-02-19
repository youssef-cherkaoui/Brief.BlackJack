import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in); // utilisation d'un nv ob pour lire les entrées de l'utilisateur
        int Key; // stocker le choix de l'utilisateur
        int myBet; // stocker le montant du pari du utilisateur

        do {
            System.out.println("1-Commencez à jouer");
            System.out.println("2-Consulter mon solde");
            System.out.println("3-Quitter");

            if (scan.hasNextInt()) { // verifie si l'entrée d'utilisteur suiv est un entier
                Key = scan.nextInt();
                switch (Key) {

                    case 1:
                        System.out.println("Placez votre pari : ");
                        if (scan.hasNextInt())
                        {
                            myBet = scan.nextInt();
                            if (myBet > Player.coins) {
                                System.out.println("Vous n'avez pas assez de jeton");
                            }
                            else if (Player.coins <= 0)
                            {
                                System.out.println("Vous avez perdu tout votre jeton");
                                Key = 0;
                            }
                            else
                            {
                                System.out.println("************* Le joueur prend 2 cartes : ****************");
                                Main.hitPlayer();
                                Main.hitPlayer();
                                System.out.println("Main du joueur  : " + "< " + Player.TotalValPlay + " >");

                                System.out.println("************* Croupier prend 2 cartes : ****************");
                                System.out.println(" Carte cachée ");
                                Main.hitHiddenCard();
                                Main.hitCroupier();
                                System.out.println("********************************************************");

                                if (Player.TotalValPlay == 21) {
                                    BlackJack.TheBlackJack();
                                    Player.coins += 2 * myBet;
                                    Key = 0;
                                }

                                boolean isPlaying = true;
                                int PlayKey;
                                do {
                                    System.out.println("1-Hit");
                                    System.out.println("2-Stand");
                                    PlayKey = scan.nextInt();
                                    switch (PlayKey) {


                                        //hit
                                        case 1:
                                            System.out.println("************* Joueur : ****************");
                                            Main.hitPlayer();
                                            System.out.println("valeur : "+ Player.TotalValPlay);
                                            System.out.println("*********************************************");
                                            if (Player.TotalValPlay == 21 && Croupier.totalValCroup < 21)
                                            {
                                                BlackJack.PlayerWin();// gagné la partie
                                                Player.coins += myBet;// ajouter le montant du pari aux jetons du joueur
                                                isPlaying = false; // jeu terminer
                                            }
                                            else if (Player.TotalValPlay == 21 && Croupier.totalValCroup > 21)
                                            {
                                                BlackJack.PlayerWin();// gagné la partie
                                                Player.coins += myBet;//ajouter le montant du pari aux jetons du joueur
                                                isPlaying = false;// jeu terminer
                                            }
                                            else if (Player.TotalValPlay > 21 && Croupier.totalValCroup <= 21)
                                            {
                                                BlackJack.CroupierWin();// Croupier gagne
                                                Player.coins -= myBet;//Le montant du pari est soustrait des jetons du joueur
                                                isPlaying = false;// jeu terminer
                                            }
                                            else if (Player.TotalValPlay < 21 && Croupier.totalValCroup == 21)
                                            {
                                                BlackJack.CroupierWin();//Croupier gagne
                                                Player.coins -= myBet;//Le montant du pari est soustrait des jetons du joueur
                                                isPlaying = false;//jeu terminer
                                            }
                                            else if (Player.TotalValPlay == 21 && Croupier.totalValCroup == 21)
                                            {
                                                BlackJack.PartieNull();
                                                isPlaying = false;
                                            }
                                            break;

                                        //Stand
                                        case 2:
                                            while (Croupier.totalValCroup <= 17)
                                            {
                                                System.out.println("************* Croupier: ****************");
                                                Main.hitCroupier();
                                            }

                                            if (Croupier.totalValCroup > 21) {
                                                BlackJack.PlayerWin(); // joueur gagne
                                                Player.coins += myBet;//ajouter le montant du pari aux jetons du joueur
                                                isPlaying = false;
                                            }
                                            else if (Croupier.totalValCroup >= Player.TotalValPlay) {
                                                BlackJack.CroupierWin();//Croupier gagne
                                                Player.coins -= myBet;//Le montant du pari est soustrait des jetons du joueur
                                                isPlaying = false;
                                            }
                                            else
                                            {
                                                BlackJack.PlayerWin();
                                                Player.coins += myBet;
                                                isPlaying = false;
                                            }

                                            break;


                                        default:
                                            System.out.println("Choix invalide ");
                                            isPlaying = false;
                                            break;
                                    }
                                }
                                while (isPlaying);
                            }
                        }
                        else
                        {
                            System.out.println("Choix invalide.");
                            scan.next();
                        }
                        break;

                    case 2:
                        System.out.println(" Votre solde jeton est : " + Player.coins);
                        break;

                    default:
                        System.out.println("===================Quitter le jeu====================");
                        break;
                }
            } else
            {
                System.out.println("Choix invalide.");
                scan.next();
                Key = -1; // acces à l'utilisateur pour saisir un choix invalide
            }
        } while (Key != 3);

    }
}
import java.util.Random;

public class Card
{
    public static Random random = new Random();
    public static String[] typeArr = {"Coeur", "Pique", "Carreau", "Trefle"};
    public static String[] valeurArr = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "KING", "QUEEN"};

    public static class infocarte // attributs
    {
        private int valCarte;
        private String carteType;
    // constructeur
        public infocarte(int valCarte, String carteType) {
            this.valCarte = valCarte;
            this.carteType = carteType;
        }
    // getters pour l'acces aux val et type du carte
        public int getvalCarte() {
            return valCarte;
        }

        public String getcarteType() {
            return carteType;
        }

    }


    public static infocarte randomOneCard() {
        int typeRandom = random.nextInt(typeArr.length); // selectionner un type aleatoire d'une carte
        int valueRandom = random.nextInt(valeurArr.length); // selectionner une val aleatoire d'une carte
        int cardValue = BlackJack.getValueAsNumber(valeurArr[valueRandom]);//utilisation du mthde 'getValueAsNumbere' pour obtenir la val associée a la valeur de carte sélectionnée aléatoirement
        String cardType = typeArr[typeRandom];//récupèration du type de carte aléatoirement dans 'typeArr'
        return new infocarte(cardValue, cardType);
    }
}

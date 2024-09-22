import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cards {
  public List<Integer> cardValues;
  public List<String> cardNames;
  public List<Integer> cardValuesShuff;
  public List<String> cardNamesShuff;

  public cards() {
    cardValues = new ArrayList<>();
    cardNames = new ArrayList<>();
  }

  public void initializeDeck() {
    // Add card values and names for one whole deck
    for (int j = 1; j <= 4; j++) {
      for (int i = 1; i <= 13; i++) {
        if (i == 1) {
          cardNames.add("Ace");
          cardValues.add(1);
        } else if (i == 11) {
          cardValues.add(10);
          cardNames.add("Jack");
        } else if (i == 12) {
          cardValues.add(10);
          cardNames.add("Queen");
        } else if (i == 13) {
          cardValues.add(10);
          cardNames.add("King");
        } else {
          cardNames.add(String.valueOf(i));
          cardValues.add(i);
        }
      }
    }
  }

  public void showDeck() {
    for (int i = 0; i < cardValues.size(); i++) {
      System.out.println(cardNames.get(i) + " " + cardValues.get(i));
    }
  }

  public void shuffleDeck() {
    cardValuesShuff = new ArrayList<>();
    cardNamesShuff = new ArrayList<>();

    int listLeng = cardValues.size();
    for (int i = 0; i < listLeng; i++) {
      //Getting a random value to get from the list to add to a temporary list to shuffle the original list
      Random rand = new Random();
      int shuffleIndex = rand.nextInt(0, cardNames.size());

      // Addinf the value of the card value at the index of the random number
      cardValuesShuff.add(cardValues.get(shuffleIndex));
      //removing the value so it cant come up again at the deck
      cardValues.remove(shuffleIndex);

      // adding hte value of the card name at the index of the random number
      cardNamesShuff.add(cardNames.get(shuffleIndex));
      //removing the value so it cant come up agiain in the deck
      cardNames.remove(shuffleIndex);
    }
    cardValues = cardValuesShuff;
    cardNames = cardNamesShuff;
    //System.out.println(cardNames);
    //System.out.println(cardValues);

  }

  public int dealVal() {
    int card = cardValues.get(0);
    cardValues.remove(0);

    return card;
  }

  public String dealName() {
    String card = cardNames.get(0);
    cardNames.remove(0);

    return card;
  }
}

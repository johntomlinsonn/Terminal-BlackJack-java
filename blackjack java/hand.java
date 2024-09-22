import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hand {
  public List<Integer> cardValues;
  public List<String> cardNames;
  public boolean dealer;

  public hand(boolean d) {
    cardValues = new ArrayList<>();
    cardNames = new ArrayList<>();
    dealer = d;
  }

  public void addCardVal(int cardValue) {
    //add card to a hand
    cardValues.add(cardValue);
  }

  public void addCardName(String cardName) {
    //add card to a hand
    cardNames.add(cardName);
  }

  public String showHand() {
    String outputBuilder = "You have the cards ";
    int valBuilder = 0;
    if (dealer == true) {
      outputBuilder = "The dealer is showing the card ";
      outputBuilder += cardNames.get(0);

      outputBuilder += " that has a value of " + cardValues.get(0);
    } else {
      for (int i = 0; i < cardValues.size(); i++) {
        outputBuilder += cardNames.get(i) + " and ";

        valBuilder += cardValues.get(i);
      }

      outputBuilder += "that add up to the value " + valBuilder;
    }

    return outputBuilder;
  }

  public void aceLogic(hand obj, Scanner objscanner) {
    if (cardNames.contains("Ace")) {
      if (dealer == false) {
        String otherCard = "";
        int aceIndex = cardNames.indexOf("Ace");

        for (int i = 0; i < cardValues.size(); i++) {
          if (i != aceIndex){
            otherCard += cardNames.get(i) + " and ";
          }
          
  
        }

        System.out.print("You have an ace and your other cards are " + otherCard);
        System.out.println(", would you like it to be a 1 or 11?");

        //Scanner myObj = new Scanner(System.in);
        int aceChoice = objscanner.nextInt();
        obj.changeAce(aceIndex,aceChoice);
      }
 
  }
  }

  public void changeAce(int aceindex ,int aceVal) {

    cardValues.set(aceindex, aceVal);
  }

  public boolean checkBust() {
    int valBuilder = 0;
    for (int i = 0; i < cardValues.size(); i++) {
      valBuilder += cardValues.get(i);
    }
    if (valBuilder > 21) {
      return true;
    } else {
      return false;
    }
  }

  public String dealerReveal() {
    String outputBuilder = "The dealer has the cards ";
    int valBuilder = 0;
    for (int i = 0; i < cardValues.size(); i++) {
      outputBuilder += cardNames.get(i) + " and ";

      valBuilder += cardValues.get(i);
    }

    outputBuilder += "that add up to the value " + valBuilder;
    return outputBuilder;
  }

  public int getCardVal() {
    int valBuilder = 0;
    for (int i = 0; i < cardValues.size(); i++) {
      valBuilder += cardValues.get(i);
    }
    return valBuilder;
  }
  public void delaerAceLogic(hand obj){
    int cardVal =  obj.getCardVal();
    if (cardNames.contains("Ace")) {
      int aceIndex = cardNames.indexOf("Ace");
      if (cardVal + 10 >= 17) {
        if (cardVal + 10 <= 21){

        obj.changeAce(aceIndex,11);

      }
    }
    if (cardVal == 11){
      if (cardVal > 21){
        obj.changeAce(aceIndex,1);
      } 
      
    }

  }
  }
}

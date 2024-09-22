import java.util.Scanner;

public class Game {

  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);
    //create a players hand object
    hand player = new hand(false);

    //create a dealers hand object
    hand dealer = new hand(true);

    //create a deck object
    cards deck = new cards();
    deck.initializeDeck();
    //deck.showDeck();

    //shuffle the deck
    deck.shuffleDeck();

    //deal the cards to the player and dealer
    for (int i = 0; i < 2; i++) {
      player.addCardName(deck.dealName());
      player.addCardVal(deck.dealVal());

      dealer.addCardName(deck.dealName());
      dealer.addCardVal(deck.dealVal());
    }

    //print players hand
    player.aceLogic(player, myObj);
    dealer.delaerAceLogic(dealer);

    

    System.out.println(player.showHand());

    //print dealers first card and keep the second hidden
    System.out.println(dealer.showHand());

    //ask the player if they want to hit or stand
    // Intializing the player choice
    String playerChoice = "";
    Scanner hit = new Scanner(System.in);

    // The while loop will run until the player stands


    while (playerChoice.equals("stand") == false) {

      
      System.out.println("Do you want to hit or stand?");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {}

      //setting the player choice to be their input
      playerChoice = hit.nextLine();
      
      if (playerChoice.equals("hit")) {

        System.out.println("You hit and your new hand is...");


        //sleeping the program for 2 seconds
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {}


        //adding card to hand
        player.addCardName(deck.dealName());
        player.addCardVal(deck.dealVal());

        //if player had ace asking if they wanted to change the value of the ace

        //logic error every time a player has ace
        //acelogic stops the loop for some reason
        player.aceLogic(player, myObj);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}

        //showing the hand
        System.out.println(player.showHand());

        //checking if the player busted
          
        if (player.checkBust() == true) {
          System.out.println("You busted, the dealer wins");
          System.exit(0);
          break;
        }
      } else {
        System.out.println("Ok, now it is the dealers turn");
        playerChoice = "stand";
      }
    }
    // if hit add a card to the players hand and ask again if they want to hit or stand

    //if player busted end game and dealer wins

    // if player did not bust the dealer reveals second card
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {}

    System.out.println(dealer.dealerReveal());

    //if dealer has less than 17 they must hit
    while (dealer.getCardVal() < 17) {
      System.out.println("The dealer hits...");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {}
      dealer.addCardName(deck.dealName());
      dealer.addCardVal(deck.dealVal());
      dealer.delaerAceLogic(dealer);

      System.out.println(dealer.dealerReveal());

      if (dealer.checkBust() == true) {
        System.out.println("The dealer busted, you win");
        System.exit(0);
      }
    }

    // who ever has the most points wins
    player.dealerReveal();
    dealer.dealerReveal();
    if (player.getCardVal() > dealer.getCardVal()) {
      System.out.println("You win");
    } else if (player.getCardVal() < dealer.getCardVal()) {
      System.out.println("The dealer wins");
    } else {
      System.out.println("Its a push!");
    }
    // ask the player if they want to play again
  }
}

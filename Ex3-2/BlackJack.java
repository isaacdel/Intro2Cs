
import intro.blackjack.*;
public class BlackJack {	

	public static boolean CompWin;
	public static int bet;
	public static boolean Draw;
	public static boolean AnotherGame;


	//
	public static void GameStart(BlackjackUI gameUI,Player user,Player comp){					
		user.addCoins(1000);
		comp.addCoins(1000);
		gameUI.updateUserBalance(user.getBalance());
		gameUI.updateCompBalance(comp.getBalance());
		int PlayerBalance=user.getBalance();
		int CompBalance=comp.getBalance();
		for(int i=0;;i++){
			bet=gameUI.askNumber("Please enter the bet value for this round:");				

			if (bet<=0){

				gameUI.displayErrorMessage("Your bet value must be greater than zero!");
				continue;


			}
			if (bet>PlayerBalance || bet>CompBalance){

				gameUI.displayErrorMessage("You cannot bet on a value greater than your or the computer's balance!");

				continue;
			}
			else {
				gameUI.setBet(bet);

				break;
			}
		}	

		Card newCardUser1=new Card();
		Card newCardUser2=new Card();
		user.addCard(newCardUser1);
		user.addCard(newCardUser2);
		gameUI.addUserCard(newCardUser1);
		gameUI.addUserCard(newCardUser2);
		Card newCardComp1=new Card();
		Card newCardComp2=new Card();
		gameUI.addCompCard(newCardComp1);
		gameUI.addCompCard(newCardComp2);
		comp.addCard(newCardComp1);
		comp.addCard(newCardComp2);											
	}

	public static void RunGameUser(BlackjackUI gameUI,Player user/*,Player comp*/){

		for(int i=0;;i++){
			//if player hold ace and passed 21
			if (user.getCardsSum()>21){
				user.changeAceHighToLow();
			}
			if ((user.getCardsSum())<21){

				boolean AnotherCard=gameUI.askYesNo("Do you want another card?");

				if (AnotherCard==true){
					Card newCardUserExtra=new Card();
					user.addCard(newCardUserExtra);
					gameUI.addUserCard(newCardUserExtra);
					//System.out.print("user sum"+user.getCardsSum()+"  comp sum"+comp.getCardsSum());



				}									
				else {

					break;
				}
				//continue;

			}
			else {//GO TO COMP WIN
				//CompWin=true;

				break;
			}

		}

	}

	public static void RunGameComp(BlackjackUI gameUI,Player user,Player comp){
		int NumberOfAces=comp.getNumberOfHighAces();//max 1 at this point
		for (int i=0;;i++){
			if (comp.getCardsSum()>16){
				comp.changeAceHighToLow();
			}

			if (comp.getCardsSum()<16){
				Card newCardCompExtra=new Card();
				comp.addCard(newCardCompExtra);
				gameUI.addCompCard(newCardCompExtra);
			}
			else {
				break;
			}
		}

	}
	//asks user if wants another game
	public static void StartAgain(BlackjackUI gameUI,Player user,Player comp){
		if (user.getBalance()>0 && comp.getBalance()>0){
			AnotherGame=gameUI.askYesNo("Do you want another game?");
			if (AnotherGame==true){
				user.clearCards();
				comp.clearCards();
				gameUI.clearBet();
				gameUI.clearCards();

			}
			else {
				gameUI.displayMessage("You finished your session with "+user.getBalance()+" coins");
			}

		}

	}

	//in case someone wins
	public static void Winner(boolean compState,BlackjackUI gameUI,Player user,Player comp,int betDisplay){

		if (compState){
			gameUI.displayMessage("You lost the game!");
			user.deductCoins(betDisplay);
			comp.addCoins(betDisplay);
			gameUI.updateUserBalance(user.getBalance());
			gameUI.updateCompBalance(comp.getBalance());

		}
		else {
			gameUI.displayMessage("You won the game!");
			comp.deductCoins(betDisplay);
			user.addCoins(betDisplay);
			gameUI.updateUserBalance(user.getBalance());
			gameUI.updateCompBalance(comp.getBalance());
		}


	}

	public static void main(String[] args) {

		BlackjackUI gameUI=new BlackjackUI();
		Player user=new Player();
		Player comp=new Player();
		do {
			GameStart(gameUI,user,comp);
			RunGameUser(gameUI,user);
			if (user.getCardsSum()>21){
				gameUI.displayMessage("You lost the game!");
				user.deductCoins(bet);
				comp.addCoins(bet);
				gameUI.updateUserBalance(user.getBalance());
				gameUI.updateCompBalance(comp.getBalance());
				StartAgain(gameUI, user, comp);
			}
			else {
				RunGameComp(gameUI, user,comp);
				//System.out.print("user sum"+user.getCardsSum()+"  comp sum"+comp.getCardsSum());

				if ((comp.getCardsSum()==user.getCardsSum())&& comp.getCardsSum()<=21 && user.getCardsSum()<=21){
					gameUI.displayMessage("This game ends with a draw.");
					StartAgain(gameUI, user, comp);
				}
				if (comp.getCardsSum()<=21 && comp.getCardsSum()>user.getCardsSum() && user.getCardsSum()<21){
					gameUI.displayMessage("You lost the game!");
					user.deductCoins(bet);
					comp.addCoins(bet);
					gameUI.updateUserBalance(user.getBalance());
					gameUI.updateCompBalance(comp.getBalance());
					StartAgain(gameUI, user, comp);
				}
				if (user.getCardsSum()<=21 /*&& comp.getCardsSum()<21*/) {
					gameUI.displayMessage("You won the game!");
					comp.deductCoins(bet);
					user.addCoins(bet);
					gameUI.updateUserBalance(user.getBalance());
					gameUI.updateCompBalance(comp.getBalance());
					StartAgain(gameUI, user, comp);
				}

			}
		} while (AnotherGame==true);

	}






}

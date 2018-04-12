/*FINAL ASSIGNMENT - BATTLESHIP GAME
 * 
 *NAME:  Leopoldo F. Medeiros
 *ID:    2017288
 *Email: leopoldof.medeiros@gmail.com 
 * 
 */

import java.util.Scanner;

public class BattleshipGame {
	
	private boolean isFinished;
	private Player[] myArrayOfPlayers;
	
	
	/* GAME RULES:
	 * -----------
	 * 
	 * 1) SIZE GRID: 
	 * YOU CAN CHOOSE A GRID SIZE( MINIMUM 10x10, CAN BE ANY SIZE UP TO A MAXOF 20x20).
	 * 
	 * 2) PERMISSIONS:
	 *  RETANGULAR GRID(e.g. 10x12, OR 12x16, ETC). THE MINIMUM FOR EACH SIDE IS 10(e.g. 10x16, BUT NOT 13x6 FOR EXAMPLE.
	 *  
	 * 3) NOTE: 
	 * FOR A ONE PLAYER GAME, THE COMPUTER DOES NOT PLAY – IT UST SETS UP THE GAME AND KEEPS SCORE.
	 *
	 * 4) LABEL TO IDENTIFY ACTIONS ON THE GRID DURING THE GAME:
	 * H = HITS
	 * * = MISSES
	 */
	
	
	
	//CONSTRUCTOR
	BattleshipGame(){
		
		welcome();
		isFinished = false;
		myArrayOfPlayers = playerSetUp();
		
		
		Grid g = setUpGrid();
		
		g.showGrid();
		
		int shipRevealedCoordinate = 0;
		
		// LOOPING CREATED IN ORDER TO THE GAME KEEPING GOES ON IN CASE IT'S NOT FINISHED
		while(!isFinished) {
			
			for(int i = 0; i<myArrayOfPlayers.length; i++) {
				System.out.println("It is a player "+myArrayOfPlayers[i].getName()+" turn");
				int row;
				int col;
				
				row = inputToInt("Choose a row value for the shot");
				col = inputToInt("Choose a column value for the shot");
				
				int [] coordinate = myArrayOfPlayers[i].SelectRowAndCol(row,  col);
				
				
				// FROM THIS POINT IS POSSIBLE TO KNOW THE COORDINATE OF THE SHIP.
				g.revealCoordinate(coordinate[0], coordinate[1]);
				
				// IF YOU GET A HIT, THE SHIP'S COORDINATE WILL BE SHOWN.
				if(g.checkIfCoordinateHasShip(row,  col)) {
					shipRevealedCoordinate++;
					System.out.println(shipRevealedCoordinate);
					System.out.println("You've got a Swat! Congratulations warrior!");
					myArrayOfPlayers[i].incrementHit();
					
				// IF YOU GET A MISS, THE SHIP'S COORDINATE WILL BE SHOWN.
				}else{
					System.out.println("Oohh, you've got a miss. :(");
					System.out.println("Stop to crying like a baby, keep going warrior!!!");
					myArrayOfPlayers[i].incrementMisses();
				}
				
				
				g.showGrid();
			}
			
			if(shipRevealedCoordinate == g.getShip() .getLength()) {
				isFinished = true;
				break;
           
			}
			
			
		}	 
	
// ################### SCORE SECTION - FUNCTION #####################  |
//                                                                     |
//                                                                     |
        displayScore();//                                              |
//                                                                     |      
    }//                                                                |
//                                                                     |
//                                                                     |
    // FUNCTION TO SHOW THE SCORE                                      |
    public void displayScore () { //                                   |
        for(int i = 0; i < myArrayOfPlayers.length; i++){//            |
            System.out.println("*-----------------------*");//         |
            System.out.println(myArrayOfPlayers[i].getName());//       |
//                                                                     |
            int swat = myArrayOfPlayers[i].getSwats();//               |
            int miss = myArrayOfPlayers[i].getMiss();//                |
            int score = (swat-miss*2);//                               |
            System.out.println("swatts: "+ swat);//                    |
            System.out.println("miss: "+ miss);//                      |
            System.out.println("FINAL SCORE: "+score);//               |
            System.out.println("*-----------------------*");//         |
//                                                                     |		
        }//                                                            |
//                                                                     |			
	}//                                                            |
// ####################################################################|
    
    
	// SETTING UP THE GRID
	Grid setUpGrid() {
		int row, col;
		
		boolean valid;
		
		do {
			row = inputToInt("Enter Rows");
			col = inputToInt("Enter Cols");
			
			valid = (row>=10 && row<=20) && (col>=10 && col<=20);
			if(!valid) {
				System.out.println("The grid size is not valid. Please enter a size between 10 and 20 for rows and columns");	
			}	
		}while(!valid);

	
	
	    return new Grid(row, col);
	
}
	// THIS INTEGER IS PRIVATED IN ORDER TO PROTECT THE PLAYER'S INTEGRATY.
	private int getAge(){

        int age;
        boolean valid;

        do{
            age = inputToInt("Type your age");
            valid = (age>=12 && age<=100);
            if(!valid){
                System.out.println("Sorry. You too young to join the war. The age cannot be under 12 years old and over 100 years old.");
            }
        // IF THE USER ENTER AN AGE UNDER 12 YEARS OLD OR ABOVE 100 YEARS, THE GAME SET UP WILL KEEP ASKING FOR A VALID AGE.
        }while(!valid);
        return age;

    }
	
	// THIS IS AN ARRAY TO SET UP A NUMBER OF PLAYERS THAT WILL JOIN THE GAME.
	public Player [] playerSetUp() {
		
		
		//IT'S STORING AN ARRAY OF PLAYERS INTO THE VARIABLES
		Player[] tempPlayer;
		
 // VALIDATING THE TOTAL OF PLAYERS ############################################################################## |
		int totalOfPlayers;//                                                                              |
		do {//                                                                                             |
			totalOfPlayers = inputToInt("Please, enter the number of players that will play the game");
			//                                                                                         |
			if(totalOfPlayers>4 || totalOfPlayers<1){//                                                |
				System.out.println("There is only 1 up to 4 players for the game.");//             |
			}//                                                                                        |
		}while (totalOfPlayers>4 || totalOfPlayers<1);//                                                   |
		//                                                                                                 |
		tempPlayer = new Player[totalOfPlayers];//######################################################## |
		
		for(int i = 0; i< tempPlayer.length; i++) {
			
			System.out.println("Setting up player"+String.valueOf(i+1));
			String name, email;
			int age;
			name = stringValidator( "Please, Enter your name","[a-zA-Z ]+", "only characters is allowed");
			
			email = stringValidator("Please, Enter your email","[a-zA-Z0-9]+[.a-zA-Z0-9!#$%&'*+-/=?^`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}+[.]+[a-zA-Z.]{2,6}","Please, type at least one dot and one @");
			
			age = getAge();
			
			tempPlayer[i] = new Player(name, age, email);
			
			if(i != totalOfPlayers-1) {
				System.out.println("Great! It's going to the next player");
			}
	
			
		}
		
		
		return tempPlayer;
					
	}
	
	public void welcome() {
		System.out.println("Welcome to the Battleship War warrior!");	
	}


	
    // HERE IS THE SECTION WHERE START THE INTERACTION BETWEEN THE USER AND GAME.
	public Scanner getInput(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in); 
		
		return sc;
	}
	
	public String stringValidator(String msg, String rules, String errorMSG) {
		String sc = "";
		do {
			sc = getInput(msg).nextLine();
			
			if(!sc.matches(rules)) {
				System.out.println(errorMSG);
			}
			
		}while(!sc.matches(rules));
		
		return sc;
	}
	
	public int inputToInt(String msg) {
		String text = stringValidator(msg, "[0-9]+", "Sorry, you didn't enter a number");
		//THIS IS TRANSFORMING STRING TO INTEGER
		return Integer.parseInt(text);
	}
	
	public static void main(String[] args) {
		// write your code here
		
		new BattleshipGame();

	}
	
}
	


      

    
 



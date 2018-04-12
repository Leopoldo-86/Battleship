/*FINAL ASSIGNMENT - BATTLESHIP GAME
 * 
 *NAME:  Leopoldo F. Medeiros
 *ID:    2017288
 *Email: leopoldof.medeiros@gmail.com 
 * 
 */

//INSTANCE VARIABLES ====================
public class Grid {//                    |
	private int row;//               |
	private int col;//               |
	public boolean[][] grid;//       |
	private Ship ships;//            |
//=======================================
	
// CONSTRUCTOR	
public Grid (int rows, int cols){
	this.row = rows;
	this.col = cols;
	this.ships = new Ship(this.row, this.col);
	
	this.grid = new boolean[this.row] [this.col];
	
  }

public Ship getShip() {
	return ships;				
}

public void showGrid() {
	for(int i= 0; i < this.row; i++) {
		
		for(int j = 0; j < this.col; j++) {
			String item = "";
			
			
			if(this.grid[i][j]){
				
				if(checkIfCoordinateHasShip(i, j)) {
					item = " H |";
				}else{
					item = " * |";
				}
			}else{
				item = "_ |";
			}
		
			
			System.out.print(item+ " ");
		}
		System.out.println();

   }
}
//IT'S CHECKING IF "row" AND "col" IS SHIP COORDINATE
public boolean checkIfCoordinateHasShip(int row, int col) {
	
	for(int i = 0; i < this.ships.getLength(); i++) {
		if(ships.getPosition()[i][0] == row && ships.getPosition() [i][1] == col) {
			return true;
		}
	}
	return false;
}

// THAT'S TO SHOW WHERE THE SHIP IS.
public void revealCoordinate(int row, int col) {
	this.grid[row][col] = true;
	
}

}

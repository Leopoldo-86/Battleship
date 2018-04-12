/*FINAL ASSIGNMENT - BATTLESHIP GAME
 * 
 *NAME:  Leopoldo F. Medeiros
 *ID:    2017288
 *Email: leopoldof.medeiros@gmail.com 
 * 
 */

import java.util.Random;

public class Ship {
	
	// TO SHOW HOW MANY PAIRS OF COORDINATES ARE ON THE GRID.
	private int[][] position;
	private int length;
	private boolean isVertical;
	
	// IT SHOWS THE LENGTH OF THE SHIP, SO THAT IS WHY THERES IS ONLY "int col" AND THE "int row", IT DOES NOT MATTER IN THIS CASE.
	public Ship(int row, int col){
		
		isVertical = new Random().nextBoolean();
		// RANDONLY: 1/3 of the WIDTH of the grid.
		length = Math.round(col/3);
		
		generatePosition(row, col);
	
	}
	
	public int[][] getPosition() {
		return this.position;
	}
	
	
	
	private void generatePosition(int gridRow, int gridCol) {
		
		// STARTING POSITIONS
		int row = this.length;
		int col = 2;
		
		int [][] positionTemp = new int[row][col];
		
		 Random rd = new Random();
		
		
		// WORIKING ON THE STARTING POINT #############################################################|
		//                                                                                             |
		positionTemp[0] = new int[] {rd.nextInt(gridRow), rd.nextInt(gridCol)};//                      |
		//                                                                                             |
		// THIS " if statement " IS HERE IN ORDER TO IDENTIFY THAT THE SHIP WON'T EXCEED THE GRID.     |
		if(this.isVertical) {//                                                                        |
			if(positionTemp[0][0] > gridRow-this.length) {//                                           |
			   positionTemp[0][0] = gridRow-this.length;//                                             |
			}//                                                                                        | 	
		}else{//                                                                                       |
			if(positionTemp[0][1] > gridCol-this.length) {//                                           |
				positionTemp[0][1] = gridCol-this.length;//                                            |
			}//                                                                                        |
		}//                                                                                            |
		 //                                                                                            |
		 //                                                                                            |
		System.out.println(positionTemp[0][0]+" , "+positionTemp[0][1]);//                             |
		//#############################################################################################|
		
		if(this.isVertical) {
			
			// THIS IS FOR THE FIRST NUMBER OF EACH LINE.
			for(int i = 1; i < row; i++) {
				
				positionTemp[i][0] = positionTemp[0][0]+i;
			    System.out.print(positionTemp[i][0]+" , ");
			    
			    // THIS IS FOR THE SECOND NUMBER OF EACH LINE.
			    for(int j = 1; j < col; j++) {
			    positionTemp[i][j] = positionTemp[0][1];
			    System.out.print(positionTemp[i][j]);
			    }
				System.out.println();
			
			}	
			
		}else{
			// HORIZONTAL 
			for(int i = 1; i < row; i++) {
				positionTemp[i][0] = positionTemp[0][0];
				System.out.print(positionTemp[i][0]+" , ");
				
			for (int j = 1; j < col; j++) {
				positionTemp[i][j] = positionTemp[0][1]+i;
				System.out.print(positionTemp[i][j]);
				}
				System.out.println();
				
			    
		
			}
			
			
		}
		
		this.position = positionTemp;
	}
	
	public boolean isVertical(){
		return this.isVertical;
	}
	public  int getLength(){
		return this.length;
	}


	}


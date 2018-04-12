/*FINAL ASSIGNMENT - BATTLESHIP GAME
 * 
 *NAME:  Leopoldo F. Medeiros
 *ID:    2017288
 *Email: leopoldof.medeiros@gmail.com 
 * 
 */

public class Player {
	
	public String name;
	public int age;
	public String email;
	private int swats;
	private int misses;
	private int attacks;

    public Player(String name, int age, String email) {
    	this.name = name;
    	this.age = age;
    	this.email = email;
    	this.swats = 0;
    	this.misses = 0;
    	this.attacks = 0;
    	
    }
    
    public int[] SelectRowAndCol(int row, int col) {
    	    int[] coordinate = new int[2];
    	    
    	    coordinate[0] = row;
    	    coordinate[1] = col;
    	    
    	    return coordinate;
    	    //return new int[]{row,col}
    }	
    
    public void incrementMisses() {
    	misses++;
    	attacks++;
		
    }
    
    public void incrementHit() {
       swats = swats + 1;
    	swats++;
    	attacks++;
    	
    }
    
    ///GETTERS
    public int getSwats() {
    	return swats;
    }
    
    public String getName(){
        return this.name;
    }

    //GET MISS
    public int getMiss(){
        return this.misses;
    }


}

	


import java.util.Random;

public class Life {
	public static void main(String[] args) {
		
		//Create new grid object
		int gridSize = 200;
		int cellSize = 3;
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		grid.setDelay(10);
		
		//Set alive and dead colors
		int aliveColor = 1;
		int deadColor = 0;
		
		//Test
		for (int i = 25; i <= 75; i++) {
			grid.setPos(10, i, aliveColor);
		}
		grid.update();
		grid.clearGrid();
		
		//Initialize population
		Random r = new Random();
		
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (r.nextInt(100) < 49) {
					grid.setPos(i, j, aliveColor);
				}
				else {
					grid.setPos(i,  j,  deadColor);
				}
			}
		}
		grid.initialize();
		
		while (true) {
			//Updating population
			int liveCounter = 0;
			for (int i = 0; i < gridSize; i++) {
				for (int j = 0; j < gridSize; j++) {
					liveCounter = 0;
					
					//top left
					if (i > 0 && j > 0 && grid.getPos(i - 1,j - 1) == aliveColor)
						liveCounter++;
					//top middle
					if (i > 0 && grid.getPos(i - 1, j) == aliveColor)
						liveCounter++;
					//top right
					if (i > 0 && j < gridSize - 1 && grid.getPos(i - 1,j + 1) == aliveColor)
						liveCounter++;
					
					//middle left
					if (j > 0 && grid.getPos(i, j - 1) == aliveColor)
						liveCounter++;
					//middle right
					if (j < gridSize - 1 && grid.getPos(i, j + 1) == aliveColor)
						liveCounter++;
				
					//bottom left
					if (i < gridSize - 1 && j > 0 && grid.getPos(i + 1,j - 1) == aliveColor)
						liveCounter++;
					//bottom middle
					if (i < gridSize - 1 && grid.getPos(i + 1, j) == aliveColor)
						liveCounter++;
					//bottom right
					if (i < gridSize - 1 && j < gridSize - 1 && grid.getPos(i + 1,j + 1) == aliveColor)
						liveCounter++;
					
					//game conditions
					if (grid.getPos(i, j) == aliveColor && (liveCounter == 2 || liveCounter == 3))  {
						grid.setPos(i, j, aliveColor);
					}
					else if (grid.getPos(i, j) == deadColor && liveCounter == 3)  {
						grid.setPos(i, j, aliveColor);
					}
					else {
						grid.setPos(i, j, deadColor);
					}
				}
			}
			grid.update();
		}

	}
}

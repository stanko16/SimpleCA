package structures;

import java.util.Hashtable;

/**
 * 
 * @author Ovkaric
 * 
 *         One dimensional Space where the automation takes place
 */
public class Space {

	private boolean[] cells;
	private Hashtable<Integer, Boolean> rule = new Hashtable<Integer, Boolean>();
	private int width;

	public Space(int width) {
		cells = new boolean[width];
		cells[(width / 2) - 1] = true;
		this.width = width;
	}

	public void randomize(){
		for (int i = 0; i < cells.length; i++) {
			if(Math.random()<0.5){
				cells[i]=true;
			}else{
				cells[i]=false;
			}
			
		}
	}
	
	
	/**
	 * Resets the space
	 */
	public void nullify() {
		for (int i = 0; i < cells.length; i++) {
			cells[i] = false;
			cells[(width / 2) - 1] = true;
		}
	}

	/**
	 * @param r
	 *            an array containing the desired rule
	 */
	public void settRule(boolean r[]) {
		int types[] = { 111, 110, 101, 100, 11, 10, 1, 0 };
		for (int i = 0; i < 8; i++) {
			rule.put(types[i], r[i]);
		}
	}

	/**
	 * @return the cells
	 */
	public boolean[] getCells() {
		return cells;
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(boolean[] cells) {
		this.cells = cells;
	}

	/**
	 * @return the rule
	 */
	public Hashtable<Integer, Boolean> getRule() {
		return rule;
	}

	/**
	 * @param rule
	 *            the rule to set
	 */
	public void setRule(Hashtable<Integer, Boolean> rule) {
		this.rule = rule;
	}

}

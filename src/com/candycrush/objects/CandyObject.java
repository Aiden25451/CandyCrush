package com.candycrush.objects;

public abstract class CandyObject extends GameObject{
	
	protected int row, col;
	protected ID id;

	public CandyObject(Handler handler) {
		super(handler);
	}
	
	public abstract void crush();
	
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return this.id;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	public int getRow() {
		return this.row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	public int getCol() {
		return this.col;
	}

}

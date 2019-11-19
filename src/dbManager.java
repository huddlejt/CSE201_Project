import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class dbManager {
	private int lineNum;
	private RandomAccessFile raf;
	
	public dbManager() {
		lineNum = 1;
		raf = null;
	}
	
	public void open(File in) throws Exception {	
		//check that raf is null, then open file
		if(raf == null) {
			raf = new RandomAccessFile(in, "rw");
			//go to end of file
			
		}
		else {
			Exception a = new Exception("file already open");
			throw a;
		}
		
	}
	
	public void update(int type, PrintWriter pw) {
		
		switch(type) {
			
			case 0:
				
				Iterator foodIterator = foods.entrySet().iterator();
				while (foodIterator.hasNext()) {
					Map.Entry mapElement = (Map.Entry)foodIterator.next();
					pw.println((mapElement.getValue()).toJSON());
			
			}
				
			case 1:
				
				Iterator userIterator = users.entrySet().iterator();
				while (userIterator.hasNext()) {
					Map.Entry mapElement = (Map.Entry)userIterator.next();
					pw.println((mapElement.getValue()).toJSON());
			
			}
				
		}
	}
	
	
	//OVERLOADED
	public boolean addItem(FoodItem fi) {
		//set FoodItem's id to lineNum
		fi.setId(lineNum);
		//check that raf was initialized
		if(raf == null) {
			return false;
		}
		if(lineNum == 1) {
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateLine(fi);
			return true;
		}
		else {
			//skip necessary lines
			for(int i = 1; i <= lineNum; i++) {
				try{
					raf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			//write to next available line
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateLine(fi);
			return true;
			
		}
	}
	//OVERLOADED
	public boolean addItem(User u) {
		u.setUserId(lineNum);
		
		if(raf == null) {
			return false;
		}
		if(lineNum == 1) {
			try {
				raf.writeBytes(u.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateLine(u);
			return true;
		}
		else {
			//skip necessary lines
			for(int i = 1; i < lineNum; i++) {
				try{
					raf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			//write to next available line
			try {
				raf.writeBytes(u.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateLine(u);
			return true;
			
		}
	}
																																									
	//OVERLOADED
	private void updateLine(User u) {
		if(u instanceof Admin) {
			lineNum += 6;
		}
		else {
			lineNum+= 5;
		}
	}
	//OVERLOADED
	private void updateLine(FoodItem fi) {
		if(fi instanceof Beverage) {
			lineNum += 10;
		}
		else {
			lineNum += 9;
		}
	}

	
	//Used to set a User or FoodItem ID
	public int getID() {
		return lineNum;
	}

}
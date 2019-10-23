import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class dbManager {
	private static int lineNum;
	private RandomAccessFile raf;
	
	public dbManager() {
		
	}
	
	public void open(File in) throws Exception {
		
		if(raf == null) {
			raf = new RandomAccessFile(in, "rw");
		}
		
		else {
			Exception a = new Exception("file already open");
			throw a;
		}
		
	}
	
	public boolean addItem(FoodItem fi) throws IOException {
		if(raf == null) {
			return false;
		}
		
		raf.writeBytes(fi.toJSON());
		
		updateLine(fi);
		
		return true;
		
		
	}
	
	private void updateLine(FoodItem fi) {
		if(fi instanceof Beverage) {
			lineNum += 10;
		}
		lineNum += 9;
	}

	

	public static int getID() {
		return lineNum;
	}

}

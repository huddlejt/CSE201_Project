import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class dbManager {
	private long filePointer;
	private RandomAccessFile raf;
	
	public dbManager() {
		filePointer = 1;
		raf = null;
	}
	/*
	 * @param File
	 * @param String readWrite <<Accepts "r", "rw">>
	 */
	public void open(File in, String readWrite) throws Exception {	
		//check that raf is null, then open file
		if(raf == null) {
			try {
				raf = new RandomAccessFile(in, readWrite);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//go to end of file
			while(raf.readLine()!=null) 
				raf.readLine();
			filePointer = raf.getFilePointer();
		}
		else {
			Exception a = new Exception("file already open");
			throw a;
		}
		
	}
	public void close() {
		if (raf != null) {
			try {  raf.close();  
					raf = null;}
			catch (IOException e) {  e.printStackTrace();  }
		}
	}
	
	public String readItem(long id) {
		String item = "";
		String line = "";
		//go to item
		try {
			raf.seek(id);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(!line.equals("}")) {
				line = raf.readLine();
				item += line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	
	//OVERLOADED
	public boolean addItem(FoodItem fi) {
		//set FoodItem's id to lineNum
		fi.setId(filePointer);
		//check that raf was initialized
		if(raf == null) {
			return false;
		}
		if(filePointer == 1) {
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;
		}
		else {
			//skip necessary lines
			try {
				raf.seek(filePointer);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//write to next available line
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;
			
		}
	}
	//OVERLOADED
	public boolean addItem(User u) {
		u.setUserId(filePointer);
		
		if(raf == null) {
			return false;
		}
		if(filePointer == 1) {
			try {
				raf.writeBytes(u.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;
		}
		else {
			//skip necessary lines
			for(int i = 1; i < filePointer; i++) {
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
			updateFilePointer();
			return true;
			
		}
	}
	
	
	//OVERLOADED
	private void updateFilePointer() {
		try {
			filePointer = raf.getFilePointer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//Used to set a User or FoodItem ID
	public long getID() {
		return filePointer;
	}

}

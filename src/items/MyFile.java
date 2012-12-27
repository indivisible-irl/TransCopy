package items;

import java.io.File;

public class MyFile extends Item
{

//// data
	
	////super (Item):
	//private String name;			// filename
	//private String location;		// path string
	//private File self;			// File object
	//private State state;			// 
	//private int attempts;
	
	private static final long serialVersionUID = 1L;
	
	private long size;
	
	
//// constructor
	
	public MyFile(File file) {
		super(file);
		size = super.getSelf().length();
	}
	

//// getters & setters
	
	public void setSize(long s)		{ size = s;		}
	public long getSize()			{ return size;	}

}

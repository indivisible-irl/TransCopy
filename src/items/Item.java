package items;

import java.io.File;
import java.io.Serializable;


public class Item implements Serializable, Comparable<Item>
{

//// data
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String location;
	private File self;
	
	private State state;
	private int attempts;
	
	
//// constructor
	
	public Item(File file)
	{
		self = file;
		location = self.getAbsolutePath();
		name = location.substring(location.lastIndexOf(File.separatorChar)+1);
		
		state = State.unattempted;
		attempts = 0;
	}
	
	
//// getters & setters
	
	public void setName(String str)			{ name = str;		}
	public void setLocation(String path)	{ location = path;	}
	public void setSelf(File file)			{ self = file;		}
	public void setState(State st)			{ state = st;		}
	public void setAttempts(int num)		{ attempts = num;	}
	public String getName()					{ return name;		}
	public String getLocation()				{ return location;	}
	public File getSelf()					{ return self;		}
	public State getState()					{ return state;		}
	public int getAttempts()				{ return attempts;	}
	
	
//// methods
	
	public int increaseAttempts()
	{
		attempts++;
		return attempts;
	}


	@Override
	public int compareTo(Item o) {
		return name.compareTo(o.getName());
	}
	
}

package items;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyFolder extends Item
{
	
//// data
	
	//// super (Item):
	//private String name;
	//private String location;
	//private File self;
	//private State state;
	//private int attempts;
	
	private static final long serialVersionUID = 1L;
	
	private List<Item> folders;
	private List<Item> files;
	
	
	
//// constructor
	
	public MyFolder(File file)
	{
		super(file);
		folders = new ArrayList<Item>();
		files   = new ArrayList<Item>();
	}

	
	
//// getters & setters
	
	public void setFolders(List<Item> items)	{ folders = items;	}
	public void setFiles(List<Item> items)		{ files = items;	}
	public List<Item> getFolders()				{ return folders;	}
	public List<Item> getFiles()				{ return files;		}
	
	
	
//// methods
	
	public void addFile(File file)
	{
		files.add(new MyFile(file));
	}
	public void addFolder(File folder)
	{
		folders.add(new MyFolder(folder));
	}
	
	public void sort()
	{
		Collections.sort(folders);
		Collections.sort(files);
	}
	

}

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
	
	private List<MyFolder> folders;
	private List<MyFile> files;
	
	
	
//// constructor
	
	public MyFolder(File file)
	{
		super(file);
		folders = new ArrayList<MyFolder>();
		files   = new ArrayList<MyFile>();
	}

	
	
//// getters & setters
	
	public void setFolders(List<MyFolder> items){ folders = items;	}
	public void setFiles(List<MyFile> items)	{ files = items;	}
	public List<MyFolder> getFolders()			{ return folders;	}
	public List<MyFile> getFiles()				{ return files;		}
	
	
	
//// methods
	
	public void addFile(File file)
	{
		files.add(new MyFile(file));
	}
	public void addFolder(MyFolder folder)
	{
		folders.add(folder);
	}
	
	public void sort()
	{
		Collections.sort(folders);
		Collections.sort(files);
	}
	
	
	public String disp(int tabs)
	{
		String padding = "";
		for (int i=0; i< tabs; i++)
			padding += "---";
		
		StringBuffer sb = new StringBuffer();
		sb.append(padding).append("|-> ").append(super.getName()).append("\n");
		
		for (MyFolder folder : folders)
		{
			sb.append(folder.disp(tabs+1));
		}
		for (MyFile file : files)
		{
			sb.append(padding).append(padding).append("|-- ").append(file.getName()).append("\n");
		}
		
		return sb.toString();
	}
	
	public void printTree()
	{
		System.out.println("\n\n");
		System.out.println(disp(0));
	}
	

}

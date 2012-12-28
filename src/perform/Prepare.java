package perform;

import items.MyFolder;

import java.io.File;

public class Prepare
{

	public static MyFolder prepare(File rootFolder)
	{
		System.out.println("Root populate:\n\t" +rootFolder.getAbsolutePath());
		if (rootFolder.isDirectory())
		{
			MyFolder root = new MyFolder(rootFolder);
			return populate(root);
		}
		else if (rootFolder.isFile())
		{
			System.out.println("root is not a folder: " +rootFolder.getAbsolutePath());
		}
		
		return null;		
	}
	
	
	private static MyFolder populate(MyFolder folder)
	{
		//System.out.println("Populate: " +folder.getLocation());
		
		File[] contents = folder.getSelf().listFiles();
		
		if (contents != null)
		{
			for (File file : contents)
			{
				//System.out.println(file.getAbsolutePath());
				if (file.isFile())
				{
					folder.addFile(file);
				}
				else if (file.isDirectory())
				{
					MyFolder f = populate(new MyFolder(file));
					folder.addFolder(f);
				}
				else
				{
					System.out.println("Not a file or directory: " +file.getAbsolutePath());
				}
			}
			folder.sort();
			return folder;
		}
		
		System.out.println("No contents");
		//TODO want to recreate empty folders??
		return folder;
	}
	
	
}

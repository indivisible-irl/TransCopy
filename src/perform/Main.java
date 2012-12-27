package perform;

import java.io.File;
import items.*;

public class Main {


	public static void main(String[] args) {
		

		String path = "C:/tmp/test";
		File root = test(path);
		
		if (root != null)
		{
			MyFolder folder = Prepare.prepare(root);
			folder.printTree();
		}
		
	}
	
	
	public static File test(String path)
	{
		File file = new File(path);
		if (file.isDirectory())
		{
			System.out.println("root is dir: " +path);
			return file;
		}
		else if (file.isFile())
		{
			System.out.println("root is file you lazy bugger! just ctrl+c/v!");
			return null;
		}
		else
		{
			System.out.println("test done went wrong...");
			if (!file.exists())
			{
				System.out.println("\tdoesn't exist: " +file.getAbsolutePath());
			}
			return null;
		}
	}

}

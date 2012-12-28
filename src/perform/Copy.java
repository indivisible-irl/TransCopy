package perform;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import items.Job;
import items.MyFile;
import items.MyFolder;

public class Copy {

	
	public static Job copy(Job job)
	{
		
		
		return job;
	}
	
	
	private static void doCopy(MyFolder folder)
	{
		for (MyFile file : folder.getFiles())
		{
			//TODO
		}
	}
	
	private static boolean copyFile(MyFile sFile, File destFile )
	{
		File sourceFile = sFile.getSelf();
		
		if (!sourceFile.canRead())
			return false;
		
		InputStream in = null;
		OutputStream out = null;
		
		try
		{
			in = new BufferedInputStream(new FileInputStream(sourceFile), 1024);
			out = new BufferedOutputStream(new FileOutputStream(destFile), 1024);
			
			
			return true;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return false;
	}
	

	private static boolean verifyCopySuccessful(MyFile sFile, File destFile)
	{
		//TODO compare md5 and (?) size
		return true;
	}
}

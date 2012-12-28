package perform;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import items.Job;

public class JobHandler {
	
//// data
	
	private static final String saveDirPath = "./jobs";


//// constructor
	
	//TODO make class implementable and track contents of saveDir to offer jobs to load
	
	
//// methods
	
	/**
	 * Create a new job
	 * @param t
	 * @param source
	 * @param destination
	 * @return
	 */
	public static Job newJob(String t, String source, String destination)
	{
		Job job = new Job();
		
		job.setTitle(t);
		job.setPathSource(source);
		job.setPathDestination(destination);
		job.setCreated(System.currentTimeMillis());
		job.setLastRun(System.currentTimeMillis());
		job.setAttempts(0);
		
		job.prepare();
		
		return job;
	}
	
	
	/**
	 * Save a job to the storage directory
	 * @param job
	 * @return
	 */
	public static boolean saveJob(Job job)
	{
		//TODO update lastRun time
		
		File saveDir = confirmSaveDir();
		if (saveDir == null)
			return false;
		
		String saveFilename = job+".job";
		File saveFile = new File(saveDir, saveFilename);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fos = new FileOutputStream(saveFile);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(job);
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return false;
	}
	
	
	/**
	 * Load a job from the storage directory
	 * @param loadFile
	 * @return
	 */
	public static Job loadJob(File loadFile)
	{
		File saveDir = confirmSaveDir();
		if (saveDir == null)
			return null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try
		{
			fis = new FileInputStream(loadFile);
			ois = new ObjectInputStream(fis);
			
			Job job = (Job) ois.readObject();
			return job;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	
	/**
	 * Verify or try to create the directory to store jobs
	 * @return
	 */
	private static File confirmSaveDir()
	{
		File dir = new File(saveDirPath);
		if (dir.exists())
		{
			if (dir.isDirectory())
			{
				System.out.println("saveDir exists and is a dir");
				return dir;
			}
			else
			{
				System.out.println("saveDir exists but not a dir");
				return null;
			}
		}
		else
		{
			if (dir.mkdirs())
			{
				System.out.println("Created 'saveDir'");
				return dir;
			}
			else
			{
				System.out.println("couldn't create saveDir");
				return null;
			}
		}
	}
}

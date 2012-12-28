package items;


import java.io.File;
import java.io.Serializable;

import perform.Prepare;


public class Job implements Serializable
{
	
//// data
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String pathSource;
	private String pathDestination;
	
	private long created;
	private long lastRun;
	private int numAttempts;

	private MyFolder rootSource;
	
	
//// constructor
	
	public Job()
	{
		// nada
	}
	
	
	
//// getters & setters
	
	public void setTitle(String t)				{ title = t;				}
	public void setPathSource(String s)			{ pathSource = s;			}
	public void setPathDestination(String d)	{ pathDestination = d;		}
	public void setCreated(long cr)				{ created = cr;				}
	public void setLastRun(long lr)				{ lastRun = lr;				}
	public void setAttempts(int at)				{ numAttempts = at;			}
	public void setRootSource(MyFolder f)		{ rootSource = f;			}
	public String getTitle()					{ return title;				}
	public String getPathSource()				{ return pathSource;		}
	public String getPathDestination()			{ return pathDestination;	}
	public long getCreated()					{ return created;			}
	public long getLastRun()					{ return lastRun;			}
	public int getNumAttempts()					{ return numAttempts;		}
	public MyFolder getRootSource()				{ return rootSource;		}
	
	
	
//// methods
	
	
	public boolean prepare()
	{
		try
		{
			File source = new File(pathSource);
			
			if (source.exists())
			{
				rootSource = Prepare.prepare(source);
				//TODO extra error handling?
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("'pathSource' not set");
			return false;
		}
		
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(Long.toString(created));
		sb.append("_");
		sb.append(title);
		return sb.toString();
	}
	
	public String info()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("====================").append("\n");
		sb.append("T: ").append(title).append("\n");
		sb.append("C: ").append(created).append("\n");
		sb.append("R: ").append(lastRun).append("\n");
		sb.append("S: ").append(pathSource).append("\n");
		sb.append("D: ").append(pathDestination).append("\n");
		sb.append("A: ").append(numAttempts).append("\n");
		sb.append("=====================");
		
		return sb.toString();		
	}
	
	public void disp()
	{
		System.out.println(info());
	}

}

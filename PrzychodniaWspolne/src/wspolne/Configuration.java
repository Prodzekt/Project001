package wspolne;

public class Configuration
{
	static int rmiPort;

	public Configuration()
	{
		rmiPort=8000;
	}
	public int getRmiPort() 
	{
		return rmiPort;
	}

	public void setRmiPort(int rmiPort) {
		this.rmiPort = rmiPort;
	}
}

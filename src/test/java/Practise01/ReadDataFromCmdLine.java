package Practise01;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine 
{
@Test
public void read()
{
	String UN = System.getProperty("username");
	System.out.println(UN);
	String PSW = System.getProperty("password");
    System.out.println(PSW);
}
}

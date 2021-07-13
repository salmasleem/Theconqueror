package exceptions;
import java.io.*;
import java.util.*;
public class BuildingInCoolDownException extends BuildingException {
	public BuildingInCoolDownException()  {
		super();
		} 
	   
	   public BuildingInCoolDownException(String s) {
		   super(s);
	   }
}

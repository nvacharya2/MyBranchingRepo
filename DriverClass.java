/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
	  //create LinkedList and add to it
      LinkedList staff = new LinkedList();
      staff.addFirst("13");
      staff.addFirst("7");
      staff.addFirst("11");

   	  if (staff.contains("13"))
   	  	System.out.println("YASSSSSSSSS slay");
   	  else
   	  	System.out.println("slay FAIL :((((");
   }
}

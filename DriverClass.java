/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
	  //create LinkedList and add to it
      LinkedList staff = new LinkedList();
      staff.add("13");
      staff.add("7");
      staff.add("11");

   	  if staff.contains("13")
   	  	System.out.println("YASSSSSSSSS slay");
   	  else
   	  	System.out.println("slay FAIL :((((");

      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }
}

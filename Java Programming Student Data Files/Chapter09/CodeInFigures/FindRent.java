import javax.swing.*;
class FindRent
{
   public static void main(String[] args)
   {
      int[][] rents = { {400, 450, 510},
                        {500, 560, 630},
                        {625, 676, 740},
                        {1000, 1250, 1600} };
      // floor and bedrooms must be in modules.
      // Module for rent display
      // array must be a file
      int floor = getFloor();
      int bedrooms = getBedrooms();
      entry = JOptionPane.showInputDialog(null,
         "Enter number of bedrooms ");
      bedrooms = Integer.parseInt(entry);
      JOptionPane.showMessageDialog(null,
         "The rent for a " + bedrooms + 
         " bedroom apartment on floor " + floor +
         " is $" + rents[floor][bedrooms]);
   }

   public int getFloor(){
      String entry;
      entry = JOptionPane.showInputDialog(null,
              "Enter a floor number ");
      try{
         floor = Integer.parseInt(entry);
      }
      catch()
      return floor;
   }

   public
}
   
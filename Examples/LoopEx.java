int sales[][] = {{4500,3400,3200,0,4500,6500,4300,6700,9900,10000,3200,5500},
                 {5700,3400,3200,0,4500,6500,4300,6700,9900,10000,3200,5500},
                 {6500,3400,3200,0,4500,6500,4300,6700,9900,10000,3200,5500},
                 {3200,3400,3200,0,4500,6500,4300,6700,9900,10000,3200,5500}
                };

int salesread[4][12];

int salesread2[][] = new int[4][12];

for(int r = 0; r <= 3; r++){
      System.out.print(r + 1);
      for(int c = 0; c <= 11; c++){
          System.out.print(sales[r][c]);
      }
      System.out.println();
}
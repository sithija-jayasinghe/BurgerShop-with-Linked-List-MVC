package burgershop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class BurgerController {
    public static String generateOrderId() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Burger.txt"));
    String line = br.readLine();
    String lastLine = null;

    while (line != null) {
        if (!line.trim().isEmpty()) lastLine = line;
        line = br.readLine();
    }
    br.close();

    if (lastLine == null) return "B0001";

    String orderId = lastLine.split(",")[0];
    return String.format("B%04d", Integer.parseInt(orderId.substring(1)) + 1);
}
    
    public static boolean addNewBurger(Burger burger) throws IOException{
        FileWriter fw = new FileWriter("Burger.txt",true);
        fw.write(System.lineSeparator() + burger.toString());
        fw.close();
        return true;
    }
    
    public static Burger searchBurgerForm (String orderId) throws  IOException{
        FileReader fr = new FileReader("Burger.txt");
        BufferedReader br =  new BufferedReader(fr);
        String line = br.readLine();
        while(line!=null){
            if(line.substring(0, 5).equalsIgnoreCase(orderId)){
                break;
            }
            line = br.readLine();
        }
        br.close();
        fr.close();
        if(line == null){
            return null;
        }
        String [] rowData = line.split(",");
        Burger burger = new Burger (rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Integer.parseInt(rowData[4]));
        return burger;
    }
    public static Burger searchCustomer(String custId) throws  IOException{
        FileReader fr = new FileReader("Burger.txt");
        BufferedReader br =  new BufferedReader(fr);
        String line = br.readLine();
        while(line!=null){
            if(line.substring(6, 16).equals(custId)){
                break;
            }
            line = br.readLine();
        }
        br.close();
        fr.close();
        if(line == null){
            return null;
        }
        String [] rowData = line.split(",");
        Burger burger = new Burger (rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Integer.parseInt(rowData[4]));
        return burger;
    }
    public static boolean updateOrder(Burger burger) throws IOException{
        Scanner input = new Scanner(new File("Burger.txt"));
        List burgerList = new List();
        while(input.hasNext()){
            String line = input.nextLine();
            String [] rowData = line.split(",");
            burgerList.add(new Burger (rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Integer.parseInt(rowData[4])));
        }
        input.close();
        boolean isUpdated = burgerList.set(burger);

        new File("Burger.txt").delete();
        
        FileWriter fw = new FileWriter("Burger.txt");
        
        for (int i = 0; i < burgerList.size(); i++) {
            fw.write(burgerList.get(i).toString()+"\n");
            fw.flush();
        }
        fw.close();
        return isUpdated;
    }
    public static List getAllBurgers() throws FileNotFoundException{
        Scanner input = new Scanner(new File("Burger.txt"));
        List burgerList = new List();
        while(input.hasNext()){
            String line = input.nextLine();
            String [] rowData = line.split(",");
            burgerList.add(new Burger (rowData[0],rowData[1],rowData[2],Integer.parseInt(rowData[3]),Integer.parseInt(rowData[4])));
        }
        return burgerList;
    }
    public static String[][] getBestCustomers() throws IOException {
        Scanner input = new Scanner(new File("Burger.txt"));
        String[][] custArray = new String[0][3]; 
        int count = 0;

        while (input.hasNext()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;
            String[] data = line.split(",");
            String custId = data[1];
            String custName = data[2];
            int tot = 500*Integer.parseInt(data[3]);

            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (custArray[i][0].equals(custId)) {
                    int total = Integer.parseInt(custArray[i][2]);
                    custArray[i][2] = Integer.toString(total + tot);
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (count >= custArray.length) {
                    custArray = extendArray(custArray);
                }
                            custArray[count][0] = custId;
                custArray[count][1] = custName;
                custArray[count][2] = Integer.toString(tot);
                count++;
            }
        }
        input.close();

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int total1 = Integer.parseInt(custArray[j][2]);
                int total2 = Integer.parseInt(custArray[j + 1][2]);
                if (total1 < total2) {
                    String[] temp = custArray[j];
                    custArray[j] = custArray[j + 1];
                    custArray[j + 1] = temp;
                }
            }
        }
        return custArray;
    }
    public static String[][] extendArray(String[][] custArray) {
        int newSize = (custArray.length == 0) ? 1 : custArray.length * 2;
        String[][] tempCustArray = new String[newSize][3];
        for (int i = 0; i < custArray.length; i++) {
            tempCustArray[i] = custArray[i];
        }
        return tempCustArray;
    }
    
}

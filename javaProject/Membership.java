package javaProject;

import java.io.*;
import java.util.*;

class Member implements Serializable{
    int memNo;
    String memName;
    int age;

    Member(int memNo, String memName, int age){
        this.memNo = memNo;
        this.memName = memName;
        this.age = age;
    }
    public String toString(){
        return memNo+" "+memName+" "+age; //constaructor to store each detail of members
    }
    
}
class MemberShip{

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        int selectOpt = -1;

        try (Scanner scan = new Scanner(System.in)) {
            try (Scanner scan1 = new Scanner(System.in)) {
                File file = new File("Members.txt"); //Create file
                ArrayList<Member> arrLst = new ArrayList<Member>();
                ObjectOutputStream OOS = null;
                ObjectInputStream OIS = null;
                ListIterator li = null;

      // write on file (to store entered data)
                if(file.isFile()){
                    OIS = new ObjectInputStream(new FileInputStream(file));
                    arrLst = (ArrayList<Member>)OIS.readObject();
                    OIS.close();
                }

                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x                                                  x");
                System.out.println("x                  ---WELCOME---                   x");
                System.out.println("x                                                  x");
                System.out.println("x        Space + Enter --> OPEN the system         x");
                System.out.println("x        Enter         --> CLOSE the system        x");
                System.out.println("x                                                  x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                String key = scan.nextLine();
                
                switch (key) {
                    case " ":

                    do {
                    
                    //menu
                        System.out.println(" ");
                        System.out.println("1.INSERT");
                        System.out.println("2.UPDATE");
                        System.out.println("3.DELETE");
                        System.out.println("4.SEARCH");
                        System.out.println("5.DISPLAY");
                        System.out.println("6.SORT");
                        System.out.println("0.EXIT");
                        
                        System.out.println(" ");
                        System.out.print("Enter your choice :    ");
                        System.out.println(" ");
                        selectOpt = scan.nextInt();
   
                        switch (selectOpt) {

                        //insert
                            case 1: 
                                System.out.println(" ");
                                System.out.println("Enter how many members you want:");
                                int n = scan.nextInt();
                                for (int i = 0; i < n; i++) {
                                    System.out.println(" ");
                                    System.out.print("Create Membership No          : ");
                                    int memNo = scan.nextInt();
   
                                    System.out.print("Enter Member Name             : ");
                                    String memName = scan1.nextLine();
   
                                    System.out.print("Enter Member age              : ");
                                    int age = scan.nextInt();
   
                                    arrLst.add(new Member(memNo, memName, age));
                                } 
                                OOS = new ObjectOutputStream(new FileOutputStream(file));
                                OOS.writeObject(arrLst);
                                OOS.close();
                            break;

                        //update
                            case 2:
                                if(file.isFile()) {
                                    OIS = new ObjectInputStream(new FileInputStream(file));
                                    arrLst = (ArrayList<Member>)OIS.readObject();
                                    OIS.close();
   
                                    boolean found = false;
                                    System.out.print("Enter memNo to update:    ");
                                    System.out.println(" ");
                                    int memNo = scan.nextInt();
                                    System.out.println("-----------------------------------------------");
                                    li = arrLst.listIterator();
                                    while(li.hasNext()){
                                        Member e = (Member)li.next();
                                        if(e.memNo == memNo){
                                            System.out.print("Enter new empname:    ");
                                            String memName = scan1.nextLine();
   
                                            System.out.print("Enter new age:        ");
                                            int sal = scan.nextInt();
                                            li.set(new Member(memNo, memName, sal));
                                            found = true;
                                        }
                                    }
                                    if(found){
                                        OOS = new ObjectOutputStream(new FileOutputStream(file));
                                        OOS.writeObject(arrLst);
                                        OOS.close();
                                        System.out.println("Data updated successfully...!");             
                                }else{
                                        System.out.println("Data not found...!");
                                    }
                                    System.out.println("-----------------------------------------------");
                                }else{
                                    System.out.println("File not exist...!");
                                }
                            break;

                        //delete
                            case 3:
                                if(file.isFile()) {
                                    OIS = new ObjectInputStream(new FileInputStream(file));
                                    arrLst = (ArrayList<Member>)OIS.readObject();
                                    OIS.close();
   
                                    boolean found = false;
                                    System.out.print("Enter memNo to delete:    ");
                                    System.out.println(" ");
                                    int memNo = scan.nextInt();
                                    System.out.println("-----------------------------------------------");
                                    li = arrLst.listIterator();
                                    while(li.hasNext()){
                                        Member e = (Member)li.next();
                                        if(e.memNo == memNo){
                                            li.remove();
                                            found = true;
                                        }
                                    }
                                    if(found){
                                        OOS = new ObjectOutputStream(new FileOutputStream(file));
                                        OOS.writeObject(arrLst);
                                        OOS.close();
                                        System.out.println("Data deleted successfully...!");             
                                }else{
                                        System.out.println("Data not found...!");
                                    }
                                    System.out.println("-----------------------------------------------");
                                }else{
                                    System.out.println("File not exist...!");
                                }
                            break;

                        //search
                            case 4:
                                if(file.isFile()) {
                                    OIS = new ObjectInputStream(new FileInputStream(file));
                                    arrLst = (ArrayList<Member>)OIS.readObject();
                                    OIS.close();
   
                                    boolean found = false;
                                    System.out.print("Enter memNo to search:    ");
                                    System.out.println(" ");
                                    int memNo = scan.nextInt();
                                    System.out.println("-----------------------------------------------");
                                    li = arrLst.listIterator();
                                    while(li.hasNext()){
                                        Member e = (Member)li.next();
                                        if(e.memNo == memNo){
                                            System.out.println(e);
                                            found = true;
                                        }
                                    }
                                    if(!found)
                                        System.out.println("Data not found...!");
                                    System.out.println("-----------------------------------------------");
                                }else{
                                    System.out.println("File not exist...!");
                                }
                            break;

                        //display
                            case 5:
                                if (file.isFile()) {
                                    OIS = new ObjectInputStream(new FileInputStream(file));
                                    arrLst = (ArrayList<Member>)OIS.readObject();
                                    OIS.close();
                                
                                    System.out.println("-----------------------------------------------");
                                    li = arrLst.listIterator();
                                    while (li.hasNext())
                                        System.out.println(li.next());
                                    System.out.println("-----------------------------------------------");
                                }else{
                                    System.out.println("File not exist...!");
                                }
                            break;

                        //sort
                            case 6:
                                int sorting;
                                do {
                                    
                                    System.out.println(" ");
                                    System.out.println("1) Sort By Mem Number");
                                    System.out.println("2) Sort By Member Name");
                                    System.out.println("3) Sort By Member Age");
                                    System.out.println("0) BACK");
                                    System.out.println(" ");
                                    System.out.print("Enter your choice : ");
                                    System.out.println(" ");
                                    sorting = scan.nextInt();
                                
                                    switch (sorting) {

                                    //Sort By Membership Number
                                        case 1:
                                            if (file.isFile()) {
                                                OIS = new ObjectInputStream(new FileInputStream(file));
                                                arrLst = (ArrayList<Member>)OIS.readObject();
                                                OIS.close();
                        
                                                Collections.sort(arrLst, new Comparator<Member>(){
                                                    public int compare(Member m1, Member m2){
                                                        return m1.memNo - m2.memNo;
                                                    }
                                                });
                                            
                                                System.out.println("-----------------------------------------------");
                                                li = arrLst.listIterator();
                                                while (li.hasNext())
                                                    System.out.println(li.next());
                                                System.out.println("-----------------------------------------------");
                                            }else{
                                                System.out.println("File not exist...!");
                                            }
                                        break;

                                    //Sort By Member Name
                                        case 2:
                                            if (file.isFile()) {
                                                OIS = new ObjectInputStream(new FileInputStream(file));
                                                arrLst = (ArrayList<Member>)OIS.readObject();
                                                OIS.close();
                        
                                                Collections.sort(arrLst, new Comparator<Member>(){
                                                    public int compare(Member m1, Member m2){
                                                        return m1.memName.compareTo(m2.memName);
                                                    }
                                                });
                                            
                                                System.out.println("-----------------------------------------------");
                                                li = arrLst.listIterator();
                                                while (li.hasNext())
                                                    System.out.println(li.next());
                                                System.out.println("-----------------------------------------------");
                                            }else{
                                                System.out.println("File not exist...!");
                                            } 
                                        break;

                                    //Sort By Member Age 
                                        case 3:
                                            if (file.isFile()) {
                                                OIS = new ObjectInputStream(new FileInputStream(file));
                                                arrLst = (ArrayList<Member>)OIS.readObject();
                                                OIS.close();
                        
                                                Collections.sort(arrLst, new Comparator<Member>(){
                                                    public int compare(Member m1, Member m2){
                                                        return m2.age - m1.age;                     // Sorting in Descending Order
                                                    }
                                                });
                                            
                                                System.out.println("-----------------------------------------------");
                                                li = arrLst.listIterator();
                                                while (li.hasNext())
                                                    System.out.println(li.next());
                                                System.out.println("-----------------------------------------------");
                                            }else{
                                                System.out.println("File not exist...!");
                                            }
                                        break;

                                    }       
                                         
                                } 
                                while (sorting!=0); //back to menu

                            break;
                        }

                    } 
                    while (selectOpt!=0); //exit from menu
                        
                    break;
                
                    default:
                        break; //close or exit system

                }
            }
            catch (Exception e) {
                System.out.println(" ");
                System.out.println("-----------------------------------------------");
                System.out.println("Something Went Wrong....!");
                System.out.println("-----------------------------------------------");
            }

        } 
        catch (Exception e) {
            System.out.println(" ");
            System.out.println("-----------------------------------------------");
            System.out.println("Something Went Wrong....!");
            System.out.println("-----------------------------------------------");
        }

    }
}
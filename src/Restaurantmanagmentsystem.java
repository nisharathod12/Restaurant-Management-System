import java.io.*;
import java.util.*;
 import java.sql.*;
 import java.sql.PreparedStatement;
 import java.io.*;
 import java.util.*;

class MenuItem {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name,  double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Menu {
    private ArrayDeque<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayDeque<>();
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public ArrayDeque<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void displayMenu() 
    {
        System.out.println("\n ********* Available Menu Items: *********");
        for (MenuItem item : menuItems) {
            System.out.println(item.getId() + ". " + item.getName() + " - " + item.getPrice());
        }
    }


    }

class Order {
     ArrayDeque<MenuItem> items;
     ArrayDeque<Integer> quantities;

     Order() 
    {
        items = new ArrayDeque<>();
        quantities = new ArrayDeque<>();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public ArrayDeque<MenuItem> getItems() 
    {
        return items;
    }

    public ArrayDeque<Integer> getQuantities() 
    {

        return quantities;
    }

    public double calculateTotalBill() {
        double total = 0;
        Iterator<MenuItem> itemIterator = items.iterator();
        Iterator<Integer> quantityIterator = quantities.iterator();
        while (itemIterator.hasNext() && quantityIterator.hasNext()) {
            MenuItem item = itemIterator.next();
            int quantity = quantityIterator.next();
            total += item.getPrice() * quantity;
        }
        return total;
    }
    
     
}
class payment
{
    int pu,pc;
	String upi;
    
    public void payonline()
    {
        
    Scanner sc=new Scanner(System.in);
         System.out.print("Enter UPI: ");
				        
						do
						{
						pu++;
						if(pu==4)
						{
							System.out.println("Sorry you have reached an extent!!");
						    System.out.println("Please sign in after few seconds");System.exit(0);
						}
						upi=sc.nextLine();
                        
						if(upi.length()==16)
						{
							//System.out.println("You have entered correct upi id");
							break;
						}
						else
						{
							System.out.println("Upi id should contain 16 digits ");
						}
						}while(pu<4);
						
						System.out.println("Enter password: ");
						do
						{
						pc++;
						if(pc==4)
						{
							System.out.println("Sorry you have reached an extent!!");
						    System.out.println("Please sign in after few seconds");
                            System.exit(0);
						}
                        int password=1212;
                        
						int password1=sc.nextInt();
						if(password1==password)
						{
                             System.out.println("=====================");
							System.out.println("payment successful");
                             System.out.println("=====================");
                            System.out.println("\nThank you for using  Restaurant Management System!");
                    System.exit(0);
                            
						}
						else
						{
							
							System.out.println("password should contain 4 digits");
							System.out.print("Enter valid password: ");
						}
						}while(pc<4);
						
						
		}
						
						
		}


class Reservation {
    private int reservationID;
    private String customerName;
    private String contactNumber;
    private String reservationDate;
    private int numberOfGuests;

    public Reservation(int reservationID, String customerName, String contactNumber,
                       String reservationDate, int numberOfGuests) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.reservationDate = reservationDate;
        this.numberOfGuests = numberOfGuests;
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getCustomerName() {
        
        return customerName;
    }

    public String getContactNumber() {
        
            return contactNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}

class Restaurant{
     int pu;
                    
     static Menu menu;
     static ArrayDeque<Order> orders;
     static Hashtable<Integer, Reservation> reservations;
     static int reservationCounter=101 ;

    public static void main(String[] args) throws Exception
    {
        payment p=new payment();
        String dburl="jdbc:mysql://localhost:3306/nisha";
        String dbuser="root";
        String dbpass="";
        String driverName="com.mysql.cj.jdbc.Driver";

        Class.forName(driverName);

        Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);

        if(con!=null)
        {
        System.out.println();
        System.out.println("Connection Success");
        System.out.println();
        }
        else
        {
        System.out.println("Connection failed");
        }
        String sql="insert into menucard(fileName,fileSizeKb,fileExtension,fileContent) values(?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        File f=new File("C://JAVA_INDIVIDUAL/Restaurantmanagmentsystem/MENUCARD.JPG");
        String fileName=f.getName();
        Long fileLength=f.length();
        Long fileSizeKb=(fileLength/1024);
        String fileExtension=fileName.substring(fileName.lastIndexOf("."));
        pst.setString(1,fileName);
        pst.setLong(2,fileSizeKb);
        pst.setString(3,fileExtension);
        FileInputStream fis=new FileInputStream(f);
        pst.setBinaryStream(4,fis);
        int r=pst.executeUpdate();
        if (r>0)
        {
        System.out.println();
        System.out.println("Insert Success");
        System.out.println();
        }
        else
        {
        System.out.println("Insert failed");
        }



        menu = new Menu();
        orders = new ArrayDeque<>();
        reservations = new Hashtable<>();

        MenuItem pizza = new MenuItem(1, "Pizza",250.60);
        MenuItem burger = new MenuItem(2, "Burger",99.00);
        MenuItem pasta = new MenuItem(3, "Pasta", 170.00);        
        MenuItem manchurian = new MenuItem(4, "Manchurian", 100.95);
        MenuItem maggie = new MenuItem(5, "Maggie", 69.95);
        MenuItem sandwich = new MenuItem(6, "Sandwich", 120.50);
        MenuItem pavbhaji = new MenuItem(7, "Pav Bhaji", 100.00);
        MenuItem frenchfries = new MenuItem(8, "French Fries", 89.00);
        MenuItem vegfranki = new MenuItem(9, "veg. Franki", 70.95);
        MenuItem vadapav = new MenuItem(10, "Vadapav", 25.00);


        menu.addItem(pizza);
        menu.addItem(burger);
        menu.addItem(pasta);        
        menu.addItem(manchurian);
        menu.addItem(maggie);
        menu.addItem(sandwich);
        menu.addItem(pavbhaji);
        menu.addItem(frenchfries);
        menu.addItem(vegfranki);
        menu.addItem(vadapav);


        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("**************** Welcome to Restaurant! ********************\n");

        do {
            System.out.println("==================================");
            System.out.println("PRESS 1. TO MAKE RESERVATION ");
            System.out.println("==================================");
            System.out.println("PRESS 2. TO VIEW RESERVATION ");
            System.out.println("==================================");
            System.out.println("PRESS 3. TO VIEW MENU ");
            System.out.println("==================================");
            System.out.println("PRESS 4. TO GIVE ORDER ");
            System.out.println("==================================");
            System.out.println("PRESS 5. TO GENERATE BILL");
            System.out.println("==================================");
            System.out.println("PRESS 6. TO EXIT");
            System.out.println("==================================");
            System.out.print("\nPlease enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                
                
                case 1:
                System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    String contactNumber;
                    do{
                    System.out.print("Enter your contact number: ");
                    contactNumber = scanner.nextLine();
                    if(contactNumber.length()!=10)
                        System.out.println("Invalid mobile number");
                    }while(contactNumber.length()!=10);
                    System.out.print("Enter reservation date (YYYY-MM-DD): ");
                    String reservationDate = scanner.nextLine();
                    System.out.print("Enter number of guests: ");
                    int numberOfGuests = scanner.nextInt();
                    Reservation reservation = new Reservation(reservationCounter++, customerName,
                    contactNumber, reservationDate, numberOfGuests);
                    reservations.put(reservation.getReservationID(), reservation);
                    System.out.println("Reservation confirmed! Your reservation ID is " + (reservationCounter -1 ) + ".");
                    break;
                    
                                  
                case 2:
                // View Reservations
                    System.out.println("\nList of Reservations:");
                    for (Reservation res : reservations.values()) {
                        System.out.println("Reservation ID: " + res.getReservationID());
                        System.out.println("Customer Name: " + res.getCustomerName());
                        System.out.println("Contact Number: " + res.getContactNumber());
                        System.out.println("Reservation Date: " + res.getReservationDate());
                        System.out.println("Number of Guests: " + res.getNumberOfGuests());
                        System.out.println();
                    }
                    break;

                case 3:
                try
                 {
                  String sql1="select * from menucard";
                  PreparedStatement pst1=con.prepareStatement(sql1);
                  ResultSet rs=pst1.executeQuery();

                  while(rs.next())
                  {

                  Blob b=rs.getBlob("fileContent");

                  byte [] arr=b.getBytes(1,(int)b.length());

                  String fileName1="C://JAVA_INDIVIDUAL/Restaurantmanagmentsystem/retrived"+rs.getString("fileName");
                  FileOutputStream fos= new FileOutputStream(fileName1);
                  System.out.println(fileName1+" is FileRetrived");
                  fos.write(arr);
                  fos.close();
                  }
                    }
                  catch(Exception e)
                    {
                        System.out.println();
                        e.printStackTrace();
    
                    }

                break;
                
                    

                case 4:

                 menu.displayMenu();
                 Order order = new Order();
                    while (true) {
                        System.out.print("Enter the ID of the menu item you want to order (0 to finish): ");
                        int selectedItemId = scanner.nextInt();
                        if (selectedItemId == 0) {
                            break;
                        }
                        MenuItem selectedMenuItem = null;
                        for (MenuItem menuItem : menu.getMenuItems()) {
                            if (menuItem.getId() == selectedItemId) 
                            {
                                selectedMenuItem = menuItem;
                                break;
                            }
                        }
                        if (selectedMenuItem == null) {
                            System.out.println("Invalid menu item ID. Please try again.");
                            continue;
                        }
                        System.out.print("Enter the quantity: ");
                        int quantity = scanner.nextInt();
                        order.addItem(selectedMenuItem, quantity);
                        System.out.println("Item added to the order.");
                    }
                    orders.add(order);
                    System.out.println("Order placed successfully!");     
                break;
                    

                case 5:
                   
                
                    Scanner sc=new Scanner(System.in);
                      
                    double totalBill = 0;
                    boolean found = false;
                    for (Order o : orders) {
                        if (!o.getItems().isEmpty()) {
                            totalBill = o.calculateTotalBill();
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        for (Order o : orders) {
                            if (!o.getItems().isEmpty()) 
                            {
                                for (MenuItem item : o.getItems()) {
                                    System.out.println(item.getName() + " x (QUANTITIE : " + o.getQuantities() + " ) -- " + item.getPrice());
                                }
                            }
                        }
                        
                        System.out.println("**************************");
                        System.out.println("\nTOTAL BILL: " + totalBill);
                        System.out.println("**************************");
                       
			     System.out.println("1.CASH ");
			     System.out.println("2.ONLINE");
                 System.out.println("Which payment mode would you like to choose?");
                 String choice1=sc.next();
                 if(choice1.equalsIgnoreCase("cash"))
                 {
                        System.out.println("Enter amount of bill");
                            double ans=sc.nextDouble();
                            if(ans==totalBill)

                            {
                                System.out.println("=====================");
                                System.out.println("Pyment Sucessfull");
                                 System.out.println("=====================");
                                System.out.println("\nThank you for using  Restaurant Management System!");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Payment unsucessfull");
                            }
                 }
                 else
                 {
                    System.out.println("enter valid choice !!");
                 }
                 if(choice1.equalsIgnoreCase("online"))
                 { 
                    System.out.println(" your total bill :"+totalBill);
                    p.payonline();
                    
                 }
                 else
                 {
                    System.out.println("enter valid choice !!");
                 }
                    
                 }
                    
                  else {
                        System.out.println(" --- NO ITEM FOR ORDERED. ---");
                    }
                    
                    break;
                    
                    case 6:
                    System.out.println("\nThank you for using  Restaurant Management System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }while(choice !=6);
    }
}
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Main{
    public static void main(String args[]) {
        String username;
        String password;
        
        System.out.println("**********************");
        System.out.println("* ONLINE EXAM SYSTEM *");
        System.out.println("**********************");
       
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Login:");
        System.out.println("2.Exit:");

        System.out.println("Enter your choice:");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1:
                System.out.println("\n========LOGIN========");
                System.out.print("Enter username:");
                username = sc.nextLine();

                System.out.print("Enter password:");
                password = sc.nextLine();

                try{
                    String url = "jdbc:mysql://localhost:3306/online_exam";
                    String dbUser = "root";
                    String dbPassword = "Root@123";

                    Connection con = DriverManager.getConnection(url, dbUser, dbPassword);

                    String sql = "SELECT * FROM users WHERE username=? AND password=?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, username);
                    ps.setString(2, password);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                       System.out.println("\nLogin Successfull");

                       boolean logout = false;
                    
                    
                    do {
                    System.out.println("\n==============================");
                    System.out.println("          DashBoard");
                    System.out.println("=================================");

                    System.out.println("1.Start Exam");
                    System.out.println("2.Update Profile");
                    System.out.println("3.Change Password");
                    System.out.println("4.Logout");

                    System.out.println("Enter Your choice:");
                    int DashBoardchoice = sc.nextInt();

                    switch(DashBoardchoice){
                        case 1:
                            int score = 0;
                            boolean autoSubmitted = false;
                            long startTime = System.currentTimeMillis();
                            long examDuration = 60000; 
                            System.out.println("\n==========ONLINE EXAM==========");
                            System.out.println("Exam Time : 60 Seconds");
                            System.out.println("Answer all questions before time is over.");

                            System.out.println("\nQ1. Which language is Platform Independent?");
                            System.out.println("A. Java");
                            System.out.println("B. C");
                            System.out.println("c. Assembly");
                            System.out.println("D. Machine Language");
                            if (System.currentTimeMillis()- startTime >= examDuration){
                                System.out.println("\n==================================");
                                System.out.println("Time is Over!");
                                System.out.println("Auto Submitting Exam...");
                                System.out.println("==================================");

                                autoSubmitted = true;
                                break;
                            }

                            System.out.println("Enter Your Answer:");
                            char ans1 = Character.toUpperCase(sc.next().charAt(0));

                            if(ans1 == 'A'){
                                score++;

                            }
                            System.out.println("\nQ2. Which Keyword is Used to  Create New Object In Java?");
                            System.out.println("A. Create");
                            System.out.println("B. New");
                            System.out.println("C. NewObject");
                            System.out.println("D. None of the above");
                            if (System.currentTimeMillis()- startTime >= examDuration){
                                System.out.println("\n==================================");
                                System.out.println("Time is Over!");
                                System.out.println("Auto Submitting Exam...");
                                System.out.println("==================================");

                                autoSubmitted = true;
                                break;
                            }

                            System.out.println("Enter Your Answer:");
                            char ans2 = Character.toUpperCase(sc.next().charAt(0));

                            if(ans2 == 'B'){
                                score++;
                            }
                            System.out.println("\nQ3. Which Database are going to use in this Project?");
                            System.out.println("A. SQL Server");
                            System.out.println("B. Oracle");
                            System.out.println("c. MongoDB");
                            System.out.println("D. MySQL");
                            if (System.currentTimeMillis()- startTime >= examDuration){
                                System.out.println("\n==================================");
                                System.out.println("Time is Over!");
                                System.out.println("Auto Submitting Exam...");
                                System.out.println("==================================");

                                autoSubmitted = true;
                                break;
                            }

                            System.out.println("Enter Your Answer:");
                            char ans3 = Character.toUpperCase(sc.next().charAt(0));

                            if(ans3 == 'D'){
                                score++;
                            }
                            System.out.println("\n========================");
                            System.out.println("            RESULT");
                            System.out.println("===========================");
                            if (autoSubmitted) {
                               System.out.println("Exam Status : AUTO SUBMITTED");
                            } else {
                               System.out.println("Exam Status : SUBMITTED");
                            }

                            System.out.println("Correct Answers: " + score);
                            System.out.println("Worng Answers: " +(3 - score));
                            System.out.println("Total Score: " + score + "/3");




                            break;
                        
                        case 2:
                           sc.nextLine();
                           System.out.println("\n==============================");
                           System.out.println("          Update Profile");
                           System.out.println("=================================");

                           System.out.print("Enter Your Name:");
                           String name = sc.nextLine();

                           System.out.print("Enter Your Email:");
                           String email = sc.nextLine();

                           System.out.print("Enter Your Phone Number:");
                           String phone =  sc.nextLine();

                           System.out.println("\n==========================");
                           System.out.println("Profile Updated Sucessfully");
                           System.out.println("============================");

                           System.out.println("Updated Profile:");
                           System.out.println("-----------------");
                           System.out.println("Name:"+name);
                           System.out.println("Email:"+email);
                           System.out.println("Phone:"+phone);
                           break;
                        case 3:
                           sc.nextLine();
                           System.out.println("\n==============================");
                           System.out.println("          Change Password");
                           System.out.println("=================================");

                           System.out.print("Enter Current Password: ");
                           String oldPassword = sc.nextLine();

                          

                           if (oldPassword.equals(password)) {
                             System.out.print("Enter New Password: ");
                             String newPassword = sc.nextLine();

                             System.out.print("Confirm Password: ");
                             String confirmPassword = sc.nextLine();

                             if (newPassword.equals(confirmPassword)) {
                                password = newPassword;
                                System.out.println("\nPassword changes Successfully!");
                             } else {
                                System.out.println("\nNew Password and Confirm Passworddo not match!");
                             }
                           } else {
                            System.out.println("\nCurrent password is Incorrect");

                           }
                           break;
                            
                            
        

                           
                           
                        case 4:
                            System.out.println("\n==============================");
                            System.out.println("Logout Successful!");
                            System.out.println("Thank You for using Online Exam System.");
                            System.out.println("==============================");

                            logout = true;
                            break;
                        default:
                            System.out.println("\nInvalid DashBoard Choice!");
                    }
                } while (!logout);
                       
                    } else {
                        System.out.println("\nInvalid username or password!please try again");
                    }
                    con.close();
                } catch(Exception e) {
                    System.out.println(e);
                

                

                break;
            }
            case 2:
                System.out.println("Thank You!");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        sc.close();
    }
}
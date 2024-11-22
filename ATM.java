import java.util.*;


class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance=10000f;
    int transactions=0;
    String transactionHistory="";


    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter your name");
        this.name=sc.nextLine();
        System.out.println("\nEnter your Username");
        this.userName=sc.nextLine();
        System.out.println("\nEnter your Password");
        this.password=sc.nextLine();
        System.out.println("\nEnter your Account number");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistration Succesfull.Login");


    }
    public boolean login(){
            boolean isLogin=false; 
            Scanner sc=new Scanner(System.in);
            while(!isLogin){
                System.out.println("\nEnter your username");
                String Username=sc.nextLine();
                if(Username.equals(userName)){
                   while(!isLogin){
                    System.out.println("\nEnter your password:");
                    String Password=sc.nextLine();
                     if(Password.equals(Password)){
                        System.out.println("\nLogin Succesfull");
                        isLogin=true;
                     }
                     else{
                        System.out.println("\n Incorrect Password");
                     }
                   } 
                }else{
                    System.out.println("\nUserName not found");
                }

            }
            return isLogin;
    }
    public void withdraw(){
           System.out.println("\n Enter amount to withdraw:");
            Scanner sc=new Scanner(System.in);
            float amount=sc.nextFloat();
            try{
                if(balance>=amount){
                    transactions++;
                    balance-=amount;
                    System.out.println("\nWithdral Succesfull");
                    String str=amount +"Rs withdrawn\n";
                    transactionHistory= transactionHistory.concat(str);
                }else{
                    System.out.println("\nInsuffient Balance");
                }
            }catch(Exception e){

            }
    }

    public void deposit(){
        System.out.println("\n Enter amount to deposit:");
         Scanner sc=new Scanner(System.in);
         float amount=sc.nextFloat();
         try{
             if(amount<=10000f){
                 transactions++;
                 balance+=amount;
                 System.out.println("\nDeposit Succesfull");
                 String str=amount +"Rs deposit\n";
                 transactionHistory= transactionHistory.concat(str);
             }else{
                 System.out.println("\nSorry.The limit is 10000.");
             }
         }catch(Exception e){
             
         }
 }
 public void transfer(){
    Scanner sc=new Scanner(System.in);
    System.out.println("\n Enter Receipent's Name:");
    String receipent=sc.nextLine();
    System.out.println("\nEnter amount to transfer");
   
     float amount=sc.nextFloat();
     try{
        if(balance>=amount){
         if(amount<=50000f){
             transactions++;
             balance-=amount;
             System.out.println("\nSuccesfull Transferred to "+receipent);
             String str=amount +"Rs transferred to "+receipent+"\n";
             transactionHistory= transactionHistory.concat(str);
         }else{
             System.out.println("\nSorry.The limit is 50000.");
         }
     
     }else{
        System.out.println("\nInsuffient Balance");
     
    }}catch(Exception e){
         
     }
}

public void checkBalance(){
    System.out.println("\n"+balance+"Rs");
}

    public void transactionHistory(){
     if(transactions ==0){
        System.out.println("No transactions happened");
     }else{
        System.out.println("\n"+transactionHistory);
     }
    }
}

public class ATM{
    public static int takenIntegerInput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag &&input>limit ||input<1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }catch(Exception e){
                System.out.println("Enter only integer value");
                flag=false;
            }
        }
        return input;
     }
     public static void main(String[]args){
       System.out.println("\n**********WELCOME TO INDIAN ATM INTERFACE*********");
       System.out.println("\n1.Register\n2.Exit");
       System.out.println("Choose one option:");
       int choose=takenIntegerInput(2);

       if(choose == 1){
        BankAccount b=new BankAccount();
        b.register();
        while(true){
            System.out.println("\n1.Login\n2.Exit");
            System.out.println("Enter your choice:");
            int ch=takenIntegerInput(6);
            if(ch==1){
                if(b.login()){
                    System.out.println("\n**********WELCOME BACK"+b.name+"*********");
                    boolean isFinished=false;
                    while(!isFinished){
                        System.out.println("\n1.withdraw\n2.Deposit\n3.Transfer \n4.check balance\n5.Transaction History \n6.Exit");
                        System.out.println("Enter your choice:");
                        int c=takenIntegerInput(2);
                        switch(c){
                            case 1:
                            b.withdraw();
                            break;
                            case 2:
                            b.deposit();
                            break;
                            case 3:
                            b.transfer();
                            break;
                            case 4:
                            b.checkBalance();
                            break;
                            case 5:
                            b.transactionHistory();
                            break;
                            case 6:
                            isFinished=true;
                            break;
                        }
                    }
                }
            }else{
               System.exit(0);
            }
        }
       }else{
        System.exit(0);
       }
     }
}
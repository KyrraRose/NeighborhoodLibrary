package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Build our library array real quick
        Book[] libraryInventory = {
                //Id,ISBN,Title,Author,CheckedOutTo,isCheckedOut
                new Book(1200,"978−013−587632−9","Daughter of the Moon Goddess","Sue Lynn Tan","",false),
                new Book(1210,"978−193−456789−0","Part of Your World","Abby Jimenez","",false),
                new Book(1220,"979−101−234567−8","The Will of the Many","James Islington","",false),
                new Book(1230,"978−007−123456−7","The Invisible Life of Addie LaRue","V.E. Schwab","",false),
                new Book(1240,"979−222−987654−3","All Systems Red","Martha Wells","",false),
                new Book(1250,"978−306−112233−4","The Sword of Kaigen","M.L. Wang","",false),
                new Book(1260,"979−456−789012−3","Babel","R.F. Kuang","",false),
                new Book(1270,"978−555−001122−3","The Near Witch","Victoria Schwab","",false),
                new Book(1280,"979−678−334455−6","Red Rising","Pierce Brown","",false),
                new Book(1290,"978−700−654321−0","Hell Divers","Nicholas Sansbury Smith","",false),
                new Book(1300,"979−888−102030−4","Master of Sorrows","Justin Travis Call","",false),
                new Book(1310,"978−901−405060−7","Pride and Prejudice","Jane Austen","",false),
                new Book(1320,"979−052−778899−0","The Duke and I","Julia Quinn","",false),
                new Book(1330,"978−111−222333−5","Alien: Sea of Sorrows","James A. Moore","",false),
                new Book(1340,"979−200−400600−8","A Knight of the Seven Kingdoms","George R. R. Martin & Gary Gianni","",false),
                new Book(1350,"978−333−887766−1","A Coup of Tea","Casey Blair","",false),
                new Book(1360,"979−404−505606−9","The Bone Witch","Rin Chupeco","",false),
                new Book(1370,"978−512−918273−6","Tress of the Emerald Sea","Brandon Sanderson","",false),
                new Book(1380,"979−666−333000−2","A Court of Thorns and Roses","Sarah J. Maas","",false),
                new Book(1390,"978−789−123987−5","Blood Over Bright Haven","M.L. Wang","",false)

                //All of these are real books, and I do recommend them (except "the Will of the Many" and "Blood Over Brighthaven", they are on my to be read list)
        };

        //Library home screen! I found some text stars to add a bit of UX to our UI and delight readers.
        while (true) {
            System.out.print("˚　　✦　　　.　　.  ˚　.　　 . ✦　　˚　　 . ★⋆.　　　.　˚\n  ==== Welcome to the Neighborhood Library! ====\n          What would you like to do?\n          [A] Show Available Books\n          [B] Show Checked Out Books\n          [X] Exit the Application\n*　　✦　　.　　.　　　✦　˚ 　　˚　.˚　　　.　　. ˚　.　　 ✦\nType Here: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    boolean subMenu = true;
                    showAvailable(libraryInventory);
                    System.out.println("Would you like to check out a book? . ★⋆.\n    [Y] Yes\n    [N] No\nType here: ");
                    String choiceCheck = scanner.nextLine().trim().toLowerCase();
                    while (subMenu){
                        switch (choiceCheck){
                            case "y":
                                System.out.println("What is your full name?. ✦");
                                String userName = scanner.nextLine().trim();
                                checkOutBook(libraryInventory,userName,scanner);

                                break;
                            case "n":
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Please enter either Y or N!");
                        }
                        if (choiceCheck.equals("y")){
                            System.out.println("Would you like to check out another book?˚　.˚\n    [Y] Yes\n    [N] No\nType here: ");
                        }else{
                            System.out.println("Here are the books you have checked out:");
                        }

                    }
                    // note for lunch key, now do check out prompts

                    break;

                case "b":

                    break;
                case "x":
                    System.out.println("˚　.　　 . ✦　　˚　　 . ★⋆.　　　.\nClosing! Have a Space-Tastic Day!\n✦　　.　　.　　　✦　˚ 　　˚　.");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Anomaly spotted! Please pick a valid choice from the menu.");


            }
            System.out.println("Press [ENTER] to Continue!. ★⋆.");
            scanner.nextLine();

        }



    }
    public static void showAvailable(Book[] libraryInventory){
        int i = 1;
        for (Book book:libraryInventory){
            if (book.isCheckedOut()==false){
                System.out.printf("Book %d: %d %s %s\n",i,book.getId(),book.getIsbn(),book.getTitle(),book.getAuthor());
                i++;
            }
        }

    }
    public static Book[] checkOutBook(Book[] libraryInventory,String userName,Scanner scanner){
        Book[] cart = new Book[libraryInventory.length]; //you COULD check them all out if you wanted to, I guess
        System.out.println("What is the title of the book?");
        String bookTitle = scanner.nextLine();
        int i = 0; //counter
        for (Book book:libraryInventory){
            if (book.getTitle().equalsIgnoreCase(bookTitle)){
                book.setCheckedOutTo(userName);
                book.setCheckedOut(true);
                cart[i]= book;
            }
        }
        i++;
        return cart;
    }
    public static void displayCart(Book [] cart){
        for (Book book:cart){
            System.out.printf("Here is what you have checked out:\n%d %s by %s | %s",book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn());
        }
    }


}

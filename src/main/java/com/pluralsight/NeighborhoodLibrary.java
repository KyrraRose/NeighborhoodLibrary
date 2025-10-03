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
            System.out.print("˚　　✦　　　.　　.  ˚　.　　 . ✦　　˚　　 . ★⋆.　　　.　˚\n  == Welcome to the Galactic Neighborhood Library! ==\n          What would you like to do?\n          [A] Show Available Books\n          [B] Show Checked Out Books\n          [X] Exit the Application\n*　　✦　　.　　.　　　✦　˚ 　　˚　.˚　　　.　　. ˚　.　　 ✦\nType Here: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    boolean subMenu = true;
                    showAvailable(libraryInventory);
                    System.out.print("Would you like to check out a book? . ★⋆.\n    [Y] Yes\n    [N] No\nType here: ");
                    String choiceCheck = scanner.nextLine().trim().toLowerCase();
                    while (subMenu){
                        switch (choiceCheck){
                            case "y":
                                System.out.print("What is your full name?. ✦\nType Here: ");
                                String userName = scanner.nextLine().trim();
                                checkOutBook(libraryInventory,userName,scanner);
                                subMenu = false;
                                break;

                            case "n":
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Please enter either Y or N!");
                        }

                    }

                    break;

                case "b":
                    boolean subMenu2 = true;
                    showCheckedOut(libraryInventory);
                    System.out.print("Would you like to check in a book? . ★⋆.\n    [Y] Yes\n    [N] No\nType here: ");
                    String choiceCheck2 = scanner.nextLine().trim().toLowerCase();
                    while (subMenu2){
                        switch (choiceCheck2){
                            case "y":
                                checkInBook(libraryInventory,scanner);

                                break;

                            case "n":
                                subMenu2 = false;
                                break;
                            default:
                                System.out.println("Please enter either Y or N!");
                        }

                    }


                    break;
                case "x":
                    System.out.println("˚　.　　 . ✦　　˚　　 . ★⋆.　　　.\nClosing! Have a SPACE-TASTIC time reading!\n✦　　.　　.　　　✦　˚ 　　˚　.");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("✦ Anomaly spotted! Please pick a valid choice from the menu. ✦");


            }
            System.out.println("\nPress [ENTER] to Continue!. ★⋆.");
            scanner.nextLine();

        }



    }
    public static void showAvailable(Book[] libraryInventory){
        int i = 1;
        System.out.println("\nAvailable Books ˚　.　　 . ✦　　˚　　 . ★⋆.　　　.✦　　.　　.　　　✦　˚ 　　˚　. \n");
        for (Book book:libraryInventory){
            if (book.isCheckedOut()==false){
                System.out.printf("Book %d: %d %s by %s ISBN: %s \n\n",i,book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn());
                i++;
            }
        }

    }
    public static void checkOutBook(Book[] libraryInventory,String userName,Scanner scanner){
        Book[] cart = new Book[libraryInventory.length]; //you COULD check them all out if you wanted to, I guess
        boolean choice = true;
        int i = 0; //counter
        while (choice){
            if (i == 0){
                System.out.printf("Okay %s, what is the title of the book? ★⋆.　\nType Here: ",userName);
            }else if (i <= 2){
                System.out.printf("What is the title, %s? ★⋆.　\nType Here: ",userName);
            }else{
                System.out.printf("You're a superstar reader %s! What title can I get you? ★⋆. ✦　\nType Here: ",userName);
            }

            String bookTitle = scanner.nextLine().trim().toLowerCase();
            for (Book book:libraryInventory){
                if (book.getTitle().toLowerCase().contains(bookTitle)){
                    System.out.printf("%s by %s was found and added to your cart! ",book.getTitle(),book.getAuthor()); //I don't have time for another y or n to add but that would be ideal
                    book.setCheckedOutTo(userName);
                    book.setCheckedOut(true);
                    cart[i]= book;
                }
            }
            i++;
            System.out.println("Would you like to check out another book?˚　.˚\n    [Y] Yes\n    [N] No\nType here: ");
            String choiceCheck = scanner.nextLine().trim().toLowerCase();
            if (choiceCheck.equals("n")){
                choice= false;
            }
        }
        System.out.println("Here is what you have checked out:  ✦　　˚　　 . ★⋆.　　　.✦　　.　　.　　　✦　˚ 　　˚　.");
        for (Book book:cart){
            if (book != null){
                System.out.printf("%d %s by %s ISBN: %s\n",book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn());
            }

        }
    }
    public static void showCheckedOut(Book[] libraryInventory){
        int i = 1;
        System.out.println("Currently Checked Out Books:  ✦　　˚　　 . ★⋆.　　　.✦　　.　　.　　　✦　˚ 　　˚　. ");
        for (Book book:libraryInventory){
            if (book.isCheckedOut()){
                System.out.printf("Book %d: %d %s by %s checked out by %s\n",i,book.getId(),book.getTitle(),book.getAuthor(),book.getCheckedOutTo());
                i++;
            }
        }

    }
    public static void checkInBook(Book[] libraryInventory,Scanner scanner){
        boolean choice = true;
        while (choice){

            System.out.println("What is the ID of the book?");
            int bookID = scanner.nextInt();
            for (Book book:libraryInventory){
                if (book.getId() == bookID){
                    book.setCheckedOutTo("userName");
                    book.setCheckedOut(false);
                }
            }

            System.out.println("Book checked in! Would you like to check in another book?˚　.˚\n    [Y] Yes\n    [N] No\nType here: ");
            String choiceCheck = scanner.nextLine().trim().toLowerCase();
            if (choiceCheck.equals("n")){
                System.out.println("Great, thank you for checking in! ˚　　 . ★⋆.　　　.✦　　.　");
                choice = false;
            }
        }
    }



}

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL; 
import java.net.URLConnection;
import javax.swing.JOptionPane; 
import java.util.Iterator;

/**
 * This class is a digital library that allows users to download PDFs from a list of topics/interests.
 *
 * @author Katherine ("Kat") Griscom
 * @version Feb 17-April 27, 2025
 *
 */


public class PdfDatabase {

    // initialization station
    static boolean openMenu = true;
    static String userTopic1;
    static String userTopic2;
    static String userTopic3;
    static String userTopic4;
    static String userTopic5;
    static String username = null;
    static String password = null;
    static String fname = null;
    static String lname = null;
    static String name = null;
    static List<Account> accounts = new ArrayList<>();
    static List<Book> pdfLibrary = new ArrayList<>();
    

    // main method
    public static void main(String[] args) throws IOException {
        // Scanner
        Scanner in = new Scanner(System.in);

         // Add a permanent test account
        accounts.add(new Account("Jane", "Doe", "deerest17", "password123", "Health", "Food", "Travel", "Science", ""));

        // Populate the PDF library
        pdfLibrary.add(new Book("The Artist's Way", "Julia Cameron", "https://ia800209.us.archive.org/12/items/the-artists-way-julia-cameron_202403/The_Artists_Way_Julia_Cameron.pdf"));
        pdfLibrary.add(new Book("The Practice and Science of Drawing", "Harold Speed", "https://ia801605.us.archive.org/view_archive.php?archive=/33/items/GutenbergENzip/30.zip&file=Practice%20and%20Science%20of%20Drawing%2C%20The%20-%20Harold%20Speed%2C%202004%20%28159p%29.pdf"));
        pdfLibrary.add(new Book("Drawing for Beginners", "Dorothy Furniss", "https://ia800508.us.archive.org/6/items/drawingforbeginn00furn/drawingforbeginn00furn_bw.pdf"));
        pdfLibrary.add(new Book("Practice Oil Painting", "Solomon J. Solomon", "https://ia802300.us.archive.org/19/items/practiceoilpain00sologoog/practiceoilpain00sologoog.pdf"));
        pdfLibrary.add(new Book("The Theory and Practice of Color", "John Gage", "https://ia601307.us.archive.org/14/items/cu31924002932634/cu31924002932634.pdf"));
        pdfLibrary.add(new Book("The Intelligent Investor", "Benjamin Graham", "https://ia801205.us.archive.org/1/items/thirumala/TheIntelligentInvestor.pdf"));
        pdfLibrary.add(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "https://ia800701.us.archive.org/1/items/RichDadPoorDad_201707/Rich%20Dad%20Poor%20Dad.pdf"));
        pdfLibrary.add(new Book("Think and Grow Rich", "Napoleon Hill", "https://ia600204.us.archive.org/15/items/think-and-grow-rich_202402/Think%20and%20Grow%20Rich.pdf"));
        pdfLibrary.add(new Book("How Not to Die", "Michael Greger", "https://ia800201.us.archive.org/29/items/how-not-to-die-michael-greger/How%20not%20to%20die%20-%20Michael%20Greger.pdf"));
        pdfLibrary.add(new Book("The Body Keeps the Score", "Bessel van der Kolk", "https://ia601604.us.archive.org/35/items/the-body-keeps-the-score-pdf/The-Body-Keeps-the-Score-PDF.pdf"));
        pdfLibrary.add(new Book("Forbidden Health", "Andreas Kalcker", "https://ia800205.us.archive.org/27/items/forbidden-health-by-andreas-kalcker/Forbidden-Health-by-Andreas-Kalcker.pdf"));
        pdfLibrary.add(new Book("Breakfast with Einstein", "Chad Orzel", "https://ia903109.us.archive.org/20/items/ScientificBooks/Breakfast_with_Einstein_The_Exotic_Physics_of_Everyday_Objects.pdf"));
        pdfLibrary.add(new Book("Cosmos", "Carl Sagan", "https://ia800304.us.archive.org/8/items/the-carl-sagan-book-collection/Carl%20Sagan%20-%20Cosmos%20(2011).pdf"));
        pdfLibrary.add(new Book("GURPS Bio-Tech", "David Pulver", "https://ia804602.us.archive.org/26/items/gurps-3e-space-atlas-4-fringe-worlds/GURPS%20-%20Bio-Tech.pdf"));
        pdfLibrary.add(new Book("Encyclopedia of Chemistry", "Don Rittner", "https://ia801203.us.archive.org/21/items/encyclopedia_of_chemistry_science_encyclopedia/encyclopedia_of_chemistry_science_encyclopedia.pdf"));
        pdfLibrary.add(new Book("Basics of Environmental Science", "Michael Allaby", "https://ia802903.us.archive.org/6/items/basicsofenvironmentalsciencemallaby_135_m/Basics%20of%20environmental%20science%20-%20M%20Allaby.pdf"));
        pdfLibrary.add(new Book("The Essence of Mathematics Through Elementary Problems", "Alexander Soifer", "https://ia803009.us.archive.org/16/items/essence-of-mathematics/essence-of-mathematics.pdf"));
        pdfLibrary.add(new Book("Basic Mathematics", "Alan Graham", "https://ia601903.us.archive.org/8/items/BASICMATHEMATICS_201611/BASIC%20MATHEMATICS.pdf"));
        pdfLibrary.add(new Book("Mathematics in the Modern World", "John Kemeny", "https://ia800100.us.archive.org/35/items/mathematics-in-the-modern-world_2022/Mathematics%20in%20the%20Modern%20World.pdf"));
        pdfLibrary.add(new Book("Standard Mathematical Tables and Formulae", "Daniel Zwillinger", "https://ia800503.us.archive.org/11/items/stabdcrcbestecrr654/Standard.Mathematical.Tables.and.Formulae.31st.Edition.Zwillinger.pdf"));
        pdfLibrary.add(new Book("Sapiens", "Yuval Noah Harari", "https://ia903201.us.archive.org/34/items/sbrief/Sapiens_%20A%20Brief%20History%20of%20Humankind%20-%20Yuval%20Noah%20Harari.pdf"));
        pdfLibrary.add(new Book("Guns, Germs, and Steel", "Jared Diamond", "https://ia800201.us.archive.org/26/items/fp_Jared_Diamond-Guns_Germs_and_Steel/Jared_Diamond-Guns_Germs_and_Steel.pdf"));
        pdfLibrary.add(new Book("Atomic Habits", "James Clear", "https://ia801701.us.archive.org/10/items/atomic-habits-original/Atomic%20Habits%20Original.pdf"));
        pdfLibrary.add(new Book("The Power of Now", "Eckhart Tolle", "https://ia801000.us.archive.org/33/items/ThePowerOfNowEckhartTolle_201806/The%20Power%20Of%20Now%20-%20Eckhart%20Tolle.pdf"));
        pdfLibrary.add(new Book("The Seven Habits of Highly Effective People", "Stephen Covey", "https://ia600200.us.archive.org/19/items/SevenHabits/CoveyStephen-TheSevenHabitsOfHighlyEffectivePeople.pdf"));
        pdfLibrary.add(new Book("Fahrenheit 451", "Ray Bradbury", "https://ia800500.us.archive.org/13/items/calibre_library_68.132.22.122.231/Fahrenheit%20451%20-%20Ray%20Bradbury_162.pdf"));
        pdfLibrary.add(new Book("1984", "George Orwell", "https://ia801202.us.archive.org/25/items/GeorgeOrwell1984_201802/George%20Orwell%20-%201984.pdf"));
        pdfLibrary.add(new Book("On Writing Well", "William Zinsser", "http://richardcolby.net/writ2000/wp-content/uploads/2017/09/On-Writing-Well-30th-Anniversa-Zinsser-William.pdf"));
        pdfLibrary.add(new Book("The Film Book", "Ronald Bergan", "https://ia903004.us.archive.org/13/items/TheFilmBookACompleteGuideToTheWorldOfFilm/The%20Film%20Book%20A%20Complete%20Guide%20To%20The%20World%20Of%20Film.pdf"));
        pdfLibrary.add(new Book("Writing the Short Film", "Patricia Cooper", "https://ia903003.us.archive.org/24/items/Writing_The_Short_Film/Writing_The_Short_Film.pdf"));
        pdfLibrary.add(new Book("The Omnivore's Dilemma", "Michael Pollan", "https://ia600205.us.archive.org/25/items/Michael_Pollan-The_Omnivores_Dilemma/Michael_Pollan-The_Omnivores_Dilemma.pdf"));
        pdfLibrary.add(new Book("Foundation Practical Cookery", "John Campbell", "https://ia902202.us.archive.org/18/items/practical-cookery_202206/Practical%20Cookery_%20Foundation%20Student%20Book%20Level%201%20%28%20PDFDrive%20%29.pdf"));
        pdfLibrary.add(new Book("Vagabonding", "Rolf Potts", "https://nemuritoareaderand.wordpress.com/wp-content/uploads/2020/03/rolf-potts-vagabonding-an-uncommon-guide-to-the-art-of-long-term-world-travel.pdf"));
        pdfLibrary.add(new Book("The Art of Travel", "Alain de Botton", "http://lib.ysu.am/disciplines_bk/16ffa30e20c7aa4c6ea72370f55ba377.pdf"));
        pdfLibrary.add(new Book("The Physics of Sports", "Angelo Armenti", "https://ia801905.us.archive.org/2/items/the-physics-of-sports-a-textbook-1/The%20Physics%20of%20Sports-A%20Textbook-1.pdf"));
        pdfLibrary.add(new Book("Explosive Power and Jumping Ability for All Sports", "Tadeusz Starzynski", "https://ia801609.us.archive.org/11/items/explosive-power-and-jumping-ability-for-all-sports/explosive-power-and-jumping-ability-for-all-sports.pdf"));
        pdfLibrary.add(new Book("Simplicity Pattern Book", "Simplicity", "https://ia601709.us.archive.org/17/items/sim_simplicity-fashion-magazine_summer-1950_2_2/sim_simplicity-fashion-magazine_summer-1950_2_2.pdf"));
        pdfLibrary.add(new Book("Fashion Drawing for Dummies", "Unknown", "https://ia600200.us.archive.org/16/items/fashion-drawing-for-dummies-pdf-room/Fashion%20Drawing%20For%20Dummies%20-%20PDF%20Room.pdf"));
        pdfLibrary.add(new Book("Dictionary of Politics and Government", "Paul Barry Clarke", "https://ia802308.us.archive.org/22/items/dictionary-of-politics-and-government/Dictionary%20of%20Politics%20and%20Government.pdf"));
        pdfLibrary.add(new Book("The Art of War", "Sun Tzu", "https://ia803407.us.archive.org/35/items/TheArtOfWarBySunTzu/ArtOfWar.pdf"));
        pdfLibrary.add(new Book("KJV Bible", "Unknown", "https://ia804503.us.archive.org/34/items/new-king-james-version-bible/New-King-James-Version%20Bible.pdf"));
        pdfLibrary.add(new Book("The Quran", "Unknown", "https://ia801604.us.archive.org/35/items/TheQuranenglishTranslation/Quran-Abdel-Haleem-Translation.pdf"));
        pdfLibrary.add(new Book("The Bhagavad Gita", "Unknown", "https://ia601906.us.archive.org/32/items/bhagavad-gita-english/Bhagavad%20Gita%20English.pdf"));
        pdfLibrary.add(new Book("The Analects of Confucius", "Confucius", "https://ia800504.us.archive.org/26/items/psychology-and-philosophy_202312/Analects%20of%20Confucius.pdf"));

        // Welcome Message
        System.out.println("");
        System.out.println("Welcome to the Pdf Database: a free digital library!");
        System.out.println("");
        System.out.println("How it works: ");
        System.out.println("");
        System.out.println("PdfDatabase.java needs to be inside the folder where you want to the pdfs to download to.");
        System.out.println("    The folder must be open on IDE to download.");
        System.out.println("    May work best if the folder exists on the desktop before running the program.");
        System.out.println("    Online complier may not allow program to work as expected.");
        System.out.println("You can select up to five topics/interest from the list to be added to your profile");
        System.out.println("    -Can download the PDF of your choice from each topic/interest");
        System.out.println("    -Add multiple accounts");
        System.out.println("    -Choose a Plus Account, which allows you to select up to 10 topics/interest");
        System.out.println("----------------------------------------------------------------");

        if (openMenu) {
            displayMenu(in, name, username);
            openMenu = false;
        }
    } // end of main
    
/**
       * This method displays the menu and allows the user to select an option.
       *
       * @param in the Scanner object
       * @param name the name of the user
      * @param username the username of the user
       * @return void
       * 
       */
    public static void displayMenu(Scanner in, String name, String username) {
        // Menu
        do {
            int choice;
            System.out.println("Please select an option via typing number:");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. Add Account");
            System.out.println("2. Search and Select Topics/Interests");
            System.out.println("3. View Account Information");
            System.out.println("4. Search for User");
            System.out.println("5. View all PDFs");
            System.out.println("6. Delete Profile");
            System.out.println("7. Log Out");
            System.out.println("----------------------------------------------------------------");
            choice = in.nextInt();
            in.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Add Account");
                    System.out.println("----------------------------------------------------------------");
                    addAccount(in);
                    break;
                case 2:
                    System.out.println("Search Topics/Interests");
                    System.out.println("----------------------------------------------------------------");
                    searchTopic(in);
                    break;
                case 3:
                    System.out.println("View Account Information");
                    System.out.println("----------------------------------------------------------------");
                    viewAccounts();
                    break;
                case 4:
                    System.out.println("Search for User");
                    System.out.println("----------------------------------------------------------------");
                    searchUser(in);
                    break;
                case 5:
                    System.out.println("View all PDFs");
                    System.out.println("----------------------------------------------------------------");
                    viewPdfs();
                    break;
                case 6:
                    System.out.println("Delete Profile");
                    System.out.println("----------------------------------------------------------------");
                    deleteAccount(in);
                    break;
                case 7:
                    System.out.println("Log Out");
                    System.out.println("----------------------------------------------------------------");
                    openMenu = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println("----------------------------------------------------------------");
                    break;
            }
        } while (openMenu);
        in.close();
        System.out.println("Thank you for using the Pdf Database!");
        System.out.println("Goodbye!");
        System.out.println("----------------------------------------------------------------");
        System.exit(0);
    } // end of displayMenu
    /**
 * The class Account represents a user account in the PdfDatabase.
 * @author Kat Griscom
 * @version mar 17, 2025
 */


    public static class Account {
        String fname;
        String lname;
        String name;
        String username;
        String password;
        String userTopic1;
        String userTopic2;
        String userTopic3;
        String userTopic4;
        String userTopic5;
    
        public Account(String fname, String lname, String username, String password, 
                       String userTopic1, String userTopic2, String userTopic3, String userTopic4, String userTopic5) {
            this.fname = fname;
            this.lname = lname;
            this.name = fname + " " + lname;
            this.username = username;
            this.password = password;
            this.userTopic1 = userTopic1;
            this.userTopic2 = userTopic2;
            this.userTopic3 = userTopic3;
            this.userTopic4 = userTopic4;
            this.userTopic5 = userTopic5;
        }
    }

    /**
     * The PlusAccount class extends Account and allows users to have up to 10 topics.
     */
    public static class PlusAccount extends Account {
        String userTopic6;
        String userTopic7;
        String userTopic8;
        String userTopic9;
        String userTopic10;

        public PlusAccount(String fname, String lname, String username, String password, 
                           String userTopic1, String userTopic2, String userTopic3, String userTopic4, String userTopic5,
                           String userTopic6, String userTopic7, String userTopic8, String userTopic9, String userTopic10) {
            super(fname, lname, username, password, userTopic1, userTopic2, userTopic3, userTopic4, userTopic5);
            this.userTopic6 = userTopic6;
            this.userTopic7 = userTopic7;
            this.userTopic8 = userTopic8;
            this.userTopic9 = userTopic9;
            this.userTopic10 = userTopic10;
        }
    }

    // Checks if a username is already taken
    //helper method
public static boolean isUsernameTaken(String username) {
    for (Account acc : accounts) {
        if (acc.username.equalsIgnoreCase(username)) {
            return true;
        }
    }
    return false;
}
    // end of Account class

/**
       * This method allows users to add an account.
       * 
       * @param in the Scanner object
       * @return void
       */
public static void addAccount(Scanner in) {
        String confirm = "";
        
        do {
            System.out.println("Would you like to create a Plus Account? (yes/no):");
            String plusChoice = in.nextLine();

            System.out.println("Please enter your first name:");
            fname = in.nextLine();
            System.out.println("Please enter your last name:");
            lname = in.nextLine();
            name = fname + " " + lname;
            // Ask whether to generate username
        System.out.println("Would you like to generate a username? (yes/no):");
        String genChoice = in.nextLine();

        if (genChoice.equalsIgnoreCase("yes") || genChoice.equalsIgnoreCase("y")) {
            // Keep generating until a unique username is found
            do {
                int num = (int) (Math.random() * 90 + 10); // random 2-digit number
                String firstInitial = fname.substring(0, 1).toLowerCase();
                username = firstInitial + lname.toLowerCase() + num;
            } while (isUsernameTaken(username));
            System.out.println("Your generated username is: " + username);
        } else {
            System.out.println("Please enter your username:");
            username = in.nextLine();
            while (isUsernameTaken(username)) {
                System.out.println("That username is already taken. Please try a different one:");
                username = in.nextLine();
            }
        }

            System.out.println("Please enter a password: (Password must be at least 8 characters)");
            password = in.nextLine();
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters");
                continue;
            }
            System.out.println("Please confirm your password:");
            String confirmPassword = in.nextLine();
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match");
                continue;
                
            }

            if (plusChoice.equalsIgnoreCase("yes") || plusChoice.equalsIgnoreCase("y")) {
                accounts.add(new PlusAccount(fname, lname, username, password, "", "", "", "", "", "", "", "", "", ""));
                System.out.println("Plus Account created successfully!\n");
            } else {
                accounts.add(new Account(fname, lname, username, password, "", "", "", "", ""));
                System.out.println("Standard Account created successfully!\n");
            }

            System.out.println("----------------------------------------------------------------");
            System.out.println("Thank you for registering!");
            System.out.println("Hello, " + name + "!");
            System.out.println("Your username is: " + username);
            System.out.println("Please Confirm yes/no");
            confirm = in.nextLine();
            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for confirming!");
                System.out.println("----------------------------------------------------------------");
            } else {
                System.out.println("Please re-enter your information.");
            }
        } while (!(confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"))); // loops until "y"
}//end of addAccount 
 /**
 * This method allows users to delete an account.
 * @param in the Scanner object
 * @return void
 */
    public static void deleteAccount(Scanner in) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.\n");
            return;
        }else {
        System.out.println("\nEnter username to delete:");
        String username = in.nextLine();
        System.out.println("Enter password:");
        String password = in.nextLine();

        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account acc = iterator.next();
            if (acc.username.equals(username) && acc.password.equals(password)) {
                iterator.remove(); // Remove account from list
                System.out.println("Account deleted successfully!\n");
                return;
                }
            }
        System.out.println("Account not found or incorrect password.\n");
        }
    } // end of deleteAccount

    /**
 * This method allows users to view all accounts.
 * @param in the Scanner object
 * @return void
 */
    
    public static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.\n");
            return;
        }
        System.out.println("\nExisting Accounts:");
        for (Account acc : accounts) {
            System.out.println("Username: " + acc.username + " | Name: " + acc.fname + " " + acc.lname + 
                               " | Topics: " + (acc.userTopic1 != null ? acc.userTopic1 : "None") + ", " +
                               (acc.userTopic2 != null ? acc.userTopic2 : "None") + ", " +
                               (acc.userTopic3 != null ? acc.userTopic3 : "None") + ", " +
                               (acc.userTopic4 != null ? acc.userTopic4 : "None") + ", " +
                               (acc.userTopic5 != null ? acc.userTopic5 : "None"));
        }
    }
    /**
       * This method allows users to search an account.
       * 
       * @param in the Scanner object
       * @return void
       */
      
      public static void searchUser(Scanner in) {
        if (accounts.isEmpty()) {
            System.out.println("Please create an account first.");
            return;
        }
    
        System.out.println("Search by last name (1) or username (2)?");
        int searchChoice = in.nextInt();
        in.nextLine(); // Consume newline
    
        System.out.println("Enter search term:");
        String searchInput = in.nextLine().toLowerCase();
    
        Account bestMatch = null;
        int highestMatchCount = 0;
    
        for (Account acc : accounts) {
            String compareString = (searchChoice == 1) ? acc.lname.toLowerCase() : acc.username.toLowerCase();
            int matchCount = 0;
            int minLength = Math.min(searchInput.length(), compareString.length());
    
            // Compare character by character
            for (int i = 0; i < minLength; i++) {
                if (searchInput.charAt(i) == compareString.charAt(i)) {
                    matchCount++;
                }
            }
    
            // Update best match if this account has more matches
            if (matchCount > highestMatchCount) {
                highestMatchCount = matchCount;
                bestMatch = acc;
            }
        }
    
        if (bestMatch != null && highestMatchCount > 0) {
            System.out.println("Nearest match found!");
            System.out.println("Name: " + bestMatch.name + " | Username: " + bestMatch.username);
        } else {
            System.out.println("No close match found.");
        }
    }// end of searchUser    
    
 /**
 * This method to search for a topic and download a PDF.
 * @param in the Scanner object
 * @return void
 */
    public static void searchTopic(Scanner in) {
        // Search Topic
        int chosenTopics = 0;
        //int topicChoice;
    if (!(accounts.isEmpty())) {
        Account current = accounts.get(accounts.size() - 1); // most recently added account
        while (chosenTopics < 5) {
            displayTopics(); // Call the new method to display topics
            System.out.println("Please select a topic/interest:");
            System.out.println("You may choose up to five topics from the list to be added to your profile");
            System.out.println("----------------------------------------------------------------");

            String topic = "";
            int chosen = in.nextInt();
            in.nextLine(); // consume the newline character
            switch (chosen) {
                case 1: topic = "Art"; break;
                case 2: topic = "Finance"; break;
                case 3: topic = "Health"; break;
                case 4: topic = "Science"; break;
                case 5: topic = "Math"; break;
                case 6: topic = "History"; break;
                case 7: topic = "Self Improvement"; break;
                case 8: topic = "Literature"; break;
                case 9: topic = "Technology"; break;
                case 10: topic = "Music"; break;
                case 11: topic = "Film"; break;
                case 12: topic = "Food"; break;
                case 13: topic = "Travel"; break;
                case 14: topic = "Sports"; break;
                case 15: topic = "Fashion"; break;
                case 16: topic = "Politics"; break;
                case 17: topic = "Religion"; break;
                case 18: return;
                default: topic = "Invalid Choice"; break;
            }

            if (!topic.equals("Invalid Choice")) {
                System.out.println("You have selected: " + topic);
                chosenTopics++; // increments the number of topics chosen

                // Assign the topic to the next available slot
                if (current.userTopic1.isEmpty()) {
                    current.userTopic1 = topic;
                } else if (current.userTopic2.isEmpty()) {
                    current.userTopic2 = topic;
                } else if (current.userTopic3.isEmpty()) {
                    current.userTopic3 = topic;
                } else if (current.userTopic4.isEmpty()) {
                    current.userTopic4 = topic;
                } else if (current.userTopic5.isEmpty()) {
                    current.userTopic5 = topic;
                }
            }

            if (topic.equals("Art")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. The Artist's Way by Julia Cameron");
                System.out.println("2. The Practice and Science of Drawing by Harold Speed");
                System.out.println("3. Drawing for Beginners by Dorothy Furniss");
                System.out.println("4. Practice Oil Painting by Solomon J. Solomon");
                System.out.println("5. The Theory and Practice of Color by John Gage");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia800209.us.archive.org/12/items/the-artists-way-julia-cameron_202403/The_Artists_Way_Julia_Cameron.pdf", "THE_ARTISTS_WAY.pdf"); 
                    break;
                    case 2: downloadPdf("https://ia801605.us.archive.org/view_archive.php?archive=/33/items/GutenbergENzip/30.zip&file=Practice%20and%20Science%20of%20Drawing%2C%20The%20-%20Harold%20Speed%2C%202004%20%28159p%29.pdf", "THE_PRACTICE_AND_SCIENCE_OF_DRAWING.pdf");  
                    break;
                    case 3: downloadPdf("https://ia800508.us.archive.org/6/items/drawingforbeginn00furn/drawingforbeginn00furn_bw.pdf", "DRAWING_FOR_BEGINNERS.pdf");
                    break;
                    case 4: downloadPdf("https://ia802300.us.archive.org/19/items/practiceoilpain00sologoog/practiceoilpain00sologoog.pdf", "THE_PRACTICE_OF_OIL_PAINTING_AND_OF_DRAWING.pdf");
                    break;
                    case 5: downloadPdf("https://ia601307.us.archive.org/14/items/cu31924002932634/cu31924002932634.pdf", "THE_THEORY_AND_PRACTICE_OF_COLOR.pdf");
                    break;
                    default: System.out.println("Invalid Choice");   
            }
        }else if (topic.equals("Finance")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. The Intelligent Investor by Benjamin Graham");
                System.out.println("2. Rich Dad Poor Dad by Robert Kiyosaki");
                System.out.println("3. Think and Grow Rich by Napoleon Hill");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia801205.us.archive.org/1/items/thirumala/TheIntelligentInvestor.pdf", "THE_INTELLIGENT_INVESTOR.pdf");
                    break;
                    case 2: downloadPdf("https://ia800701.us.archive.org/1/items/RichDadPoorDad_201707/Rich%20Dad%20Poor%20Dad.pdf", "RICH_DAD_POOR_DAD.pdf");
                    break;
                    case 3: downloadPdf("https://ia600204.us.archive.org/15/items/think-and-grow-rich_202402/Think%20and%20Grow%20Rich.pdf", "THINK_AND_GROW_RICH.pdf");
                    default: System.out.println("Invalid Choice");
            }
        }else if (topic.equals("Health")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. How Not to Die by Michael Greger");
                System.out.println("2. The Body Keeps the Score by Bessel van der Kolk");
                System.out.println("3. Forbidden Health by Andreas Kalcker");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia800201.us.archive.org/29/items/how-not-to-die-michael-greger/How%20not%20to%20die%20-%20Michael%20Greger.pdf", "HOW_NOT_TO_DIE.pdf");
                    break;
                    case 2:downloadPdf("https://ia601604.us.archive.org/35/items/the-body-keeps-the-score-pdf/The-Body-Keeps-the-Score-PDF.pdf", "THE_BODY_KEEPS_THE_SCORE.pdf");
                    break;
                    case 3: downloadPdf("https://ia800205.us.archive.org/27/items/forbidden-health-by-andreas-kalcker/Forbidden-Health-by-Andreas-Kalcker.pdf", " FORBIDDEN_HEALTH.pdf");
                    break;
                    case 4: downloadPdf("https://ia601902.us.archive.org/24/items/WhereThereIsNoDoctor-English-DavidWerner/14.DavidWerner-WhereThereIsNoDoctor.pdf", "WHERE_THERE_IS_NO_DOCTOR.pdf");
                    break;
                  default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Science")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Breakfast with Einstein by Chad Orzel");
                System.out.println("2. Cosmos by Carl Sagan");
                System.out.println("3. GURPS Bio-Tech by David Pulver");
                System.out.println("4. Encyclopedia of Chemistry by Don Rittner");
                System.out.println("5. Basics of Environmental Science by Michael Allaby");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia903109.us.archive.org/20/items/ScientificBooks/Breakfast_with_Einstein_The_Exotic_Physics_of_Everyday_Objects.pdf", "BREAKFAST_WITH_EINSTEIN.pdf");
                    break;
                    case 2: downloadPdf("https://ia800304.us.archive.org/8/items/the-carl-sagan-book-collection/Carl%20Sagan%20-%20Cosmos%20(2011).pdf", "COSMOS.pdf");
                   break;
                   case 3: downloadPdf("https://ia804602.us.archive.org/26/items/gurps-3e-space-atlas-4-fringe-worlds/GURPS%20-%20Bio-Tech.pdf", "GURPS_BIO-TECH.pdf");
                    break;
                    case 4: downloadPdf("https://ia801203.us.archive.org/21/items/encyclopedia_of_chemistry_science_encyclopedia/encyclopedia_of_chemistry_science_encyclopedia.pdf", " ENCYCLOPEDIA_OF_CHEMISTRY.pdf");
                    break;
                    case 5: downloadPdf("https://ia802903.us.archive.org/6/items/basicsofenvironmentalsciencemallaby_135_m/Basics%20of%20environmental%20science%20-%20M%20Allaby.pdf", "BASICS_OF_ENVIRONMENTAL_SCIENCE.pdf");
                   default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Math")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. The Essence of Mathematics Through Elementary Problems by Alexander Soifer");
                System.out.println("2. Basic Mathematics by Alan Graham");
                System.out.println("3. Mathematics in the Modern World by John Kemeny");
                System.out.println("4. Standard Mathematical Tables and Formulae by Daniel Zwillinger (Warning: Large File)");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia803009.us.archive.org/16/items/essence-of-mathematics/essence-of-mathematics.pdf", "THE_ESSENCE_OF_MATHEMATICS.pdf");
                    break;
                    case 2: downloadPdf("https://ia601903.us.archive.org/8/items/BASICMATHEMATICS_201611/BASIC%20MATHEMATICS.pdf", "BASIC_MATHEMATICS.pdf");
                    break;
                    case 3: downloadPdf("https://ia800100.us.archive.org/35/items/mathematics-in-the-modern-world_2022/Mathematics%20in%20the%20Modern%20World.pdf", "MATHEMATICS_IN_THE_MODERN_WORLD.pdf");
                    break;
                    case 4: downloadPdf("https://ia800503.us.archive.org/11/items/stabdcrcbestecrr654/Standard.Mathematical.Tables.and.Formulae.31st.Edition.Zwillinger.pdf", "STANDARD_MATHEMATICAL_TABLES_AND_FORMULAE.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("History")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Sapiens by Yuval Noah Harari");
                System.out.println("2. Guns, Germs, and Steel by Jared Diamond");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia903201.us.archive.org/34/items/sbrief/Sapiens_%20A%20Brief%20History%20of%20Humankind%20-%20Yuval%20Noah%20Harari.pdf", "SAPIENS.pdf");
                    break;
                    case 2: downloadPdf("https://ia800201.us.archive.org/26/items/fp_Jared_Diamond-Guns_Germs_and_Steel/Jared_Diamond-Guns_Germs_and_Steel.pdf", "GUNS_GERMS_AND_STEEL.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Self Improvement")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Atomic Habits by James Clear");
                System.out.println("2. The Power of Now by Eckhart Tolle");
                System.out.println("3. The Improvement of the Mind by Isaac Watts");
                System.out.println("4. The Seven Habits of Highly Effective People by Stephen Covey");
                System.out.println("5. The 10X Rule by Grant Cardone");
                System.out.println("6. The Art of Being Alone by Vago Damitio");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia801701.us.archive.org/10/items/atomic-habits-original/Atomic%20Habits%20Original.pdf", "ATOMIC_HABITS.pdf");
                    break;
                    case 2: downloadPdf("https://ia801000.us.archive.org/33/items/ThePowerOfNowEckhartTolle_201806/The%20Power%20Of%20Now%20-%20Eckhart%20Tolle.pdf", "THE_POWER_OF_NOW.pdf");
                    break;
                    case 3: downloadPdf("https://ia601600.us.archive.org/33/items/improvementofmind00watt/improvementofmind00watt.pdf", "THE_IMPROVEMENT_OF_THE_MIND.pdf");
                    break;
                    case 4: downloadPdf("https://ia600200.us.archive.org/19/items/SevenHabits/CoveyStephen-TheSevenHabitsOfHighlyEffectivePeople.pdf", "THE_SEVEN_HABITS_OF_HIGHLY_EFFECTIVE_PEOPLE.pdf");
                    break;
                    case 5: downloadPdf("https://ia801001.us.archive.org/31/items/10x_20191019/10X.pdf", "THE_10X_RULE.pdf");
                    break;
                    case 6: downloadPdf("https://ia801204.us.archive.org/10/items/the-art-of-being-alone-solitude-is-my-home-loneliness-was-my-cage/The%20Art%20of%20Being%20ALONE%20Solitude%20Is%20My%20HOME%2C%20Loneliness%20Was%20My%20Cage.pdf", "THE_ART_OF_BEING_ALONE.pdf");
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Literature")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Fahrenheit 451 by Ray Bradbury");
                System.out.println("2. 1984 by George Orwell");
                System.out.println("3. On Writing Well by William Zinsser");
                System.out.println("4. A History of English Literature by Robert Huntington Fletcher");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia800500.us.archive.org/13/items/calibre_library_68.132.22.122.231/Fahrenheit%20451%20-%20Ray%20Bradbury_162.pdf", "FAHRENHEIT_451.pdf");
                    break;
                    case 2: downloadPdf("https://ia801202.us.archive.org/25/items/GeorgeOrwell1984_201802/George%20Orwell%20-%201984.pdf", "1984.pdf");
                    break;
                    case 3: downloadPdf("http://richardcolby.net/writ2000/wp-content/uploads/2017/09/On-Writing-Well-30th-Anniversa-Zinsser-William.pdf", "ON_WRITING_WELL.pdf");
                    break;
                    case 4: downloadPdf("https://ia601605.us.archive.org/35/items/historyofenglish00comp/historyofenglish00comp.pdf", "A_HISTORY_OF_ENGLISH_LITERATURE.pdf");
                        
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Technology")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Enclyclopedia of Computer Science and Technology by Harry Henderson");
                System.out.println("2. A+ Guide to IT Technical Support by Jean Andrews (Warning: Large File)");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia801001.us.archive.org/13/items/encyclopediaofcomputerscienceandtechnology_201909/Encyclopedia%20of%20Computer%20Science%20and%20Technology.pdf", "ENCYCLOPEDIA_OF_COMPUTER_SCIENCE_AND_TECHNOLOGY.pdf");
                    break;
                    case 2: downloadPdf("https://ia904507.us.archive.org/32/items/a-guide-to-it-technical-support/A%2B%20Guide%20to%20IT%20Technical%20Support%20%28%20PDFDrive%20%29.pdf", "A+_GUIDE_TO_IT_TECHNICAL_SUPPORT.pdf");
                    break;
                    default: System.out.println("Invalid Choice");
                }
             }
        else if (topic.equals("Music")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Music Theory for Dummies by Michael Pilhofer");
                System.out.println("2. Muisc Theory: Basic level");
                System.out.println("3. Fundamentals of Musical Composition by Arnold Schoenberg");
                System.out.println("4. Countercultures and Popular Music by Jedediah Sklower and Sheila Whiteley");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia903208.us.archive.org/1/items/MusicTheoryGeorgeThaddeusJones1974/MusicTheoryForDummies.pdf", "HOW_MUSIC_WORKS.pdf");
                    break;
                    case 2: downloadPdf("https://ia803208.us.archive.org/1/items/MusicTheoryGeorgeThaddeusJones1974/MusicTheory-BasicLevel.pdf", "MUSIC_THEORY_BASIC_LEVEL.pdf");
                    break;
                    case 3: downloadPdf("https://ia903208.us.archive.org/1/items/MusicTheoryGeorgeThaddeusJones1974/A.schoenberg-FundamentalsOfMusicalComposition_text.pdf", "MUSIC_THEORY_BASIC_LEVEL.pdf");
                    break;
                    case 4: downloadPdf("https://ia601307.us.archive.org/11/items/Countercultures_and_Popular_Music_by_Jedediah_Sklower_Sheila_Whiteley/Countercultures_and_Popular_Music_by_Jedediah_Sklower_Sheila_Whiteley.pdf", "COUNTERCULTURES_AND_POPULAR_MUSIC.pdf");
                    default: System.out.println("Invalid Choice");
                }
            }
        else if (topic.equals("Film")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1.  The Film Book by Ronald Bergan");
                System.out.println("2. Writing the Short Film by Patricia Cooper");
                System.out.println("3. Film Art: An Introduction by David Bordwell");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia903004.us.archive.org/13/items/TheFilmBookACompleteGuideToTheWorldOfFilm/The%20Film%20Book%20A%20Complete%20Guide%20To%20The%20World%20Of%20Film.pdf", "THE_FILM_BOOK.pdf");
                    break;
                    case 2: downloadPdf("https://ia903003.us.archive.org/24/items/Writing_The_Short_Film/Writing_The_Short_Film.pdf", "WRITING_THE_SHORT_FILM.pdf");
                    break;
                    case 3: downloadPdf("https://ia804604.us.archive.org/20/items/film-art-12th-edition-bordwell-thompson-smith/Film%20Art%20-%2012th%20Edition%20%28Bordwell%2C%20Thompson%2C%20Smith%29.pdf", "FILM_ART_AN_INTRODUCTION.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Food")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. The Omnivore's Dilemma by Michael Pollan");
                System.out.println("2. Foundation Practical Cookery by John Campbell");
                System.out.println("3. Food: A Cultural Culinary History by Ken Albala");
                System.out.println("4. The Lost Book of Superfoods by Bill Monroe");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia600205.us.archive.org/25/items/Michael_Pollan-The_Omnivores_Dilemma/Michael_Pollan-The_Omnivores_Dilemma.pdf", "THE_OMNIVORES_DILEMMA.pdf");
                    break;
                    case 2: downloadPdf("https://ia902202.us.archive.org/18/items/practical-cookery_202206/Practical%20Cookery_%20Foundation%20Student%20Book%20Level%201%20%28%20PDFDrive%20%29.pdf", "FOUNDATION_PRACTICAL_COOKERY.pdf");
                    break;
                    case 3: downloadPdf("https://ia600306.us.archive.org/26/items/FoodACulturalCulinaryHistory/FoodACulturalCulinaryHistory.pdf", "FOOD_A_CULTURAL_CULINARY_HISTORY.pdf");
                    break;
                    case 4: downloadPdf("https://ia804509.us.archive.org/6/items/easy-cellar_202106/The_Lost_Book_Superfoods.pdf", "THE_LOST_BOOK_SUPERFOODS.pdf");
                    break;
                    default: System.out.println("Invalid Choice");
                }
            }
        else if (topic.equals("Travel")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Vagabonding by Rolf Potts");
                System.out.println("2. Wilderness Survival for Dummies by John Haslett");
                System.out.println("3. The Art of Travel by Alain de Botton");
                System.out.println("4. Liminal Travel by Vago Damitio");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://nemuritoareaderand.wordpress.com/wp-content/uploads/2020/03/rolf-potts-vagabonding-an-uncommon-guide-to-the-art-of-long-term-world-travel.pdf", "VAGABONDING.pdf");
                    break;
                    case 2: downloadPdf("https://ia801701.us.archive.org/22/items/WildernessSurvivalForDummies/Wilderness-Survival-for-Dummies.pdf", "THE_GEOGRAPHY_OF_BLISS.pdf");
                    break;
                    case 3: downloadPdf("http://lib.ysu.am/disciplines_bk/16ffa30e20c7aa4c6ea72370f55ba377.pdf", "THE_ART_OF_TRAVEL.pdf");
                    break;
                    case 4: downloadPdf("https://ia803205.us.archive.org/7/items/liminaltravel/liminaltravelebook.pdf", "LIMINAL_TRAVEL.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Sports")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1.The Physics of Sports: A Textbook by Angelo Armenti");
                System.out.println("2. Explosive Power and Jumping Ability for All Sports by Tadeusz Starzynski");
                System.out.println("3. 50 top tools for Coaching by Gillian Jones");
                System.out.println("4. College Atheletics by Michael C. Murphy");
                System.out.println("5. Developing Speed by NSCA");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia801905.us.archive.org/2/items/the-physics-of-sports-a-textbook-1/The%20Physics%20of%20Sports-A%20Textbook-1.pdf", "THE_PHYSICS_OF_SPORTS.pdf");
                    break;
                    case 2: downloadPdf("https://ia801609.us.archive.org/11/items/explosive-power-and-jumping-ability-for-all-sports/explosive-power-and-jumping-ability-for-all-sports.pdf", "EXPLOSIVE_POWER_AND_JUMPING_ABILITY_FOR_ALL_SPORTS.pdf");
                    break;
                    case 3: downloadPdf("https://ia803102.us.archive.org/34/items/CoachingManual/Coaching%20Manual.pdf", "50_TOP_TOOLS_FOR_COACHING.pdf");
                    break;
                    case 4: downloadPdf("https://ia600607.us.archive.org/13/items/collegeathletics02murp/collegeathletics02murp.pdf", "COLLEGE_ATHLETICS.pdf");
                    break;
                    case 5: downloadPdf("https://ia601400.us.archive.org/1/items/workout-books/Fitness%20Programs/NSCA/NSCA%20-%20Developing%20Speed.pdf", "DEVELOPING_SPEED.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}}
        else if (topic.equals("Fashion")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Simplicity Pattern Book by Simplicity");
                System.out.println("2. Fashion Drawing for Dummies");
                System.out.println("3. Fashion: The key concepts by Jennifer Craik");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia601709.us.archive.org/17/items/sim_simplicity-fashion-magazine_summer-1950_2_2/sim_simplicity-fashion-magazine_summer-1950_2_2.pdf", "SIMPLICITY_PATTERN_BOOK.pdf");
                    break;
                    case 2: downloadPdf("https://ia600200.us.archive.org/16/items/fashion-drawing-for-dummies-pdf-room/Fashion%20Drawing%20For%20Dummies%20-%20PDF%20Room.pdf", "FASHION_DRAWING_FOR_DUMMIES.pdf");
                    break;
                    case 3: downloadPdf("https://ia800202.us.archive.org/33/items/jennifer-craik-areeba/jennifer%20craik%20Areeba.pdf", "FASHION_THE_KEY_CONCEPTS.pdf");
                    break;
                    default: System.out.println("Invalid Choice");
                }
            }
        else if (topic.equals("Politics")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. Dictionary of Politics and Government by Paul Barry Clarke");
                System.out.println("2. Encyclopedia of Capatalism by Syed B. Hussain");
                System.out.println("3. The Anarchist Cookbook by William Powell");
                System.out.println("4. The Art of War by Sun Tzu");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia802308.us.archive.org/22/items/dictionary-of-politics-and-government/Dictionary%20of%20Politics%20and%20Government.pdf", "DICTIONARY_OF_POLITICS_AND_GOVERNMENT.pdf");
                    break;
                    case 2: downloadPdf("https://ia601001.us.archive.org/12/items/encyclopediaofcapitalismvol3/Encyclopedia%20of%20Capitalism-%20Vol%201.pdf", "ENCYCLOPEDIA_OF_CAPATALISM.pdf");
                    break;
                    case 3 : downloadPdf("https://ia600801.us.archive.org/32/items/the-anarchist-cookbook-william-powell/The%20Anarchist%20Cookbook%20-%20William%20Powell%20-%20Barricade%20Books%20Inc%20-%201989.pdf", "THE_ANARCHIST_COOKBOOK.pdf");
                    break;
                    case 4: downloadPdf("https://ia803407.us.archive.org/35/items/TheArtOfWarBySunTzu/ArtOfWar.pdf", "THE_ART_OF_WAR.pdf");
                    break;
                    default: System.out.println("Invalid Choice");
                }
            }

        else if (topic.equals("Religion")) {
                System.out.println("Please select a PDF to download:");
                System.out.println("1. KJV Bible (WARNING: LARGE FILE)");
                System.out.println("2. The Quran (English Translation)");
                System.out.println("3. The Bhagavad Gita (English) (WARNING: LARGE FILE)");
                System.out.println("4. The Analects of Confucius");
                int pdfChoice = in.nextInt();
                in.nextLine(); // consume the newline character
                switch (pdfChoice) {
                    case 1: downloadPdf("https://ia804503.us.archive.org/34/items/new-king-james-version-bible/New-King-James-Version%20Bible.pdf", "KJV_BIBLE.pdf");
                    break;
                    case 2: downloadPdf("https://ia801604.us.archive.org/35/items/TheQuranenglishTranslation/Quran-Abdel-Haleem-Translation.pdf", "THE_QURAN.pdf");
                    break;
                    case 3: downloadPdf("https://ia601906.us.archive.org/32/items/bhagavad-gita-english/Bhagavad%20Gita%20English.pdf", "THE_BHAGAVAD_GITA.pdf");
                    break;
                    case 4: downloadPdf("https://ia800504.us.archive.org/26/items/psychology-and-philosophy_202312/Analects%20of%20Confucius.pdf", "THE_ANALECTS_OF_CONFUCIUS.pdf");
                    break;
                    default: System.out.println("Invalid Choice");}
                }
        else if (topic.equals("Exit")) {
                return;
            }
        }
            
    }else {
        System.out.println("Please Create an Account First");
        System.out.println("");
    }
}//end of searchTopic

//this code/method was mostly written by the youtuber: @satyendra singh yadav
 /**
 * This method allows users to download a PDF file from a given URL and save it to a specified filename.
 * @param url The URL of the PDF file to download. 
 * @param filename The name of the file to save the downloaded PDF
 * @return void
 */
    public static void downloadPdf(String url, String filename) {
    try {
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("jsse.enableSNIExtension", "false");

        //  Use the passed URL, do not redefine it
        URLConnection connection = URI.create(url).toURL().openConnection();
        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        connection.addRequestProperty("User-Agent", "Mozilla/5.0");

        InputStream input = connection.getInputStream();

        // Use the provided filename instead of hardcoded value
        File destination = new File(filename); 
        FileOutputStream output = new FileOutputStream(destination, false);

        byte[] buffer = new byte[2048];
        int read;
        System.out.println("Downloading " + filename + "...");
        while ((read = input.read(buffer)) > -1) {
            output.write(buffer, 0, read);
            System.out.print(".");
        }

        output.flush();
        output.close();
        input.close();
        System.out.println("\nDownload complete! Saved as: " + destination.getAbsolutePath());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Failed to download PDF.");
    }
}// end of downloadPdf
 /**
 * This method allows users to view all available PDFs in the library.
 * @param void
 * @return void
 */
public static void viewPdfs() {
    if (pdfLibrary.isEmpty()) {
        System.out.println("No PDFs available in the library.");
        return;
    }

    System.out.println("All PDFs:");
    System.out.println("----------------------------------------------------------------");
    for (int i = 0; i < pdfLibrary.size(); i++) {
        Book pdf = pdfLibrary.get(i);
        System.out.println((i + 1) + ". " + pdf.title + " by " + pdf.author);
    }
    System.out.println("----------------------------------------------------------------");
}
 /**
 * This class will allow books to be saved as an array of objects
 * @author Kat Griscom
 * @version Mar, 17, 2025
 */
    public static class Book {
        String title;
        String author;
        String url;

        public Book(String title, String author, String url) {
            this.title = title;
            this.author = author;
            this.url = url;
        }
    }

    /**
     * This method displays all available topics to the user.
     * @return void
     */
    public static void displayTopics() {
        System.out.println("Available Topics:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Art");
        System.out.println("2. Finance");
        System.out.println("3. Health");
        System.out.println("4. Science");
        System.out.println("5. Math");
        System.out.println("6. History");
        System.out.println("7. Self Improvement");
        System.out.println("8. Literature");
        System.out.println("9. Technology");
        System.out.println("10. Music");
        System.out.println("11. Film");
        System.out.println("12. Food");
        System.out.println("13. Travel");
        System.out.println("14. Sports");
        System.out.println("15. Fashion");
        System.out.println("16. Politics");
        System.out.println("17. Religion");
        System.out.println("18. Exit");
        System.out.println("----------------------------------------------------------------");
    }
}// end of class

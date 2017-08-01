import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by alan on 12.03.16.
 */
public class Administrator {
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

    public static String getLogin() {
        return LOGIN;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    protected void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println();
            System.out.println("Logged as ADMIN");
            System.out.println();
            System.out.println("1.Register new users");
            System.out.println("2.Edit users");
            System.out.println("3.Delete users");
            System.out.println("4.Assign client to an engineer");
            System.out.println("5.Search");
            System.out.println("0.Logout");

            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                registerUser();
            } else if (choose == 2) {
                editUser();
            } else if (choose == 3) {
                deleteUser();
            } else if (choose == 4) {
                assignClient();
            } else if (choose == 5) {
                search();
            }  else if (choose == 0) {
                logout();
            } else {
                System.out.println("Wrong input!");
                menu();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            menu();
        }
    }

    protected void assignClient() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i< Data.getClients().size(); i++) {
                System.out.println(i+1 + ". " + Data.getClients().get(i).getName() + "; " + Data.getClients().get(i).getId());
            }

            System.out.print("Choose a client for assigning: ");
            int chooseClient = Integer.parseInt(reader.readLine());


            for (int i =0; i < Data.getEngineers().size(); i++) {
                System.out.println(i+1 + ". " + Data.getEngineers().get(i).getName() + "; " + Data.getEngineers().get(i).getId());
            }

            System.out.print("Choose an engineer to assign a client: ");
            int chooseEngineer = Integer.parseInt(reader.readLine());
            for (int i = 0; i < Data.getEngineers().size(); i++) {
                if (chooseEngineer == i+1) {
                    Data.getEngineers().get(i).getClients().add(Data.getClients().get(chooseClient));
                }
            }

            System.out.println("Client: " + Data.getClients().get(chooseClient).getName() + Data.getClients().get(chooseClient).getId() + "has been assigned to an engineer: " + Data.getEngineers().get(chooseEngineer).getName() + "; "+ Data.getEngineers().get(chooseEngineer).getId());
        } catch (Exception e) {
            System.out.println();
        }
    }

    protected void deleteUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("1.Delete clerk");
            System.out.println("2.Delete engineer");
            System.out.println("3.Delete manager");
            System.out.println("4.Delete client");
            System.out.println("0.Exit to menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                deleteClerk();
            } else if (choose == 2) {
                deleteEngineer();
            } else if (choose == 3) {
                deleteManager();
            } else if (choose == 4) {
                deleteClient();
            } else if (choose == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    private void deleteClerk() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter clerk's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchClerk(input);
            if (i == -1) {
                System.out.println("No clerk with such information");
                deleteUser();
            }
            if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getClerks().get(i).toString());
            System.out.println("1.Delete clerk");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Clerk " + Data.getClerks().get(i).getName() + " has been deleted");
                Data.getClerks().remove(i);
                menu();
            } else if (choose == 2) {
                deleteUser();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    private void deleteEngineer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter Engineer's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchEngineer(input);
            if (i == -1) {
                System.out.println("No engineer with such information");
                deleteUser();
            }
            if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getEngineers().get(i).toString());
            System.out.println("1.Delete engineer");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Engineer " + Data.getEngineers().get(i).getName() + " has been deleted");
                Data.getEngineers().remove(i);
                menu();
            } else if (choose == 2) {
                deleteUser();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    private void deleteManager() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter manager's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchManager(input);
            if (i == -1) {
                System.out.println("No manager with such information");
                deleteUser();
            }
            if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getManagers().get(i).toString());
            System.out.println("1.Delete manager");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Manager " + Data.getManagers().get(i).getName() + " has been deleted");
                Data.getManagers().remove(i);
                menu();
            } else if (choose == 2) {
                deleteUser();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    private void deleteClient() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter client's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchClient(input);
            if (i == -1) {
                System.out.println("No client with such information");
                deleteUser();
            }
            if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getManagers().get(i).toString());
            System.out.println("1.Delete client");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Client " + Data.getClients().get(i).getName() + " has been deleted");
                Data.getClients().remove(i);
                menu();
            } else if (choose == 2) {
                deleteUser();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    private void registerUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Register new clerk");
        System.out.println("2.Register new engineer");
        System.out.println("3.Register new manager");
        System.out.println("4.Register new client");
        System.out.println("0.Exit to main menu");
        try {
            int s = Integer.parseInt(reader.readLine());
            if (s == 1) {
                registerClerk();
            } else if (s == 2) {
                registerEngineer();
            } else if (s == 3) {
                registerManager();
            } else if (s == 4) {
                registerClient();
            } else if (s == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                registerUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            registerUser();
        }
    }

    protected void registerClient() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter client's name: ");
            String name = reader.readLine();
            System.out.print("Enter client's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter client's email: ");
            String email = reader.readLine();
            System.out.print("Enter client's address: ");
            String address = reader.readLine();
            System.out.print("Enter date: ");
            String date = reader.readLine();
            System.out.print("Enter number of rooms: ");
            int numberOfRooms = Integer.parseInt(reader.readLine());
            System.out.print("Enter type of appliance: ");
            String typeOfApplience = reader.readLine();
            String id;

            if (Data.getClientCount() < 10) id = "CL00000" + Data.getClientCount();
            else if (Data.getClientCount() < 100) id = "CL0000" + Data.getClientCount();
            else if (Data.getClientCount() < 1000) id = "CL000" + Data.getClientCount();
            else if (Data.getClientCount() < 10000) id = "CL00" + Data.getClientCount();
            else if (Data.getClientCount() < 100000) id = "CL0)" + Data.getClientCount();
            else id = "CL" + Data.getClientCount();

            Data.setClientCount(Data.getClientCount()+1);

            System.out.println("Client's ID number is " + id);
            Data.getClients().add(new Client(id, name, phoneNumber, email, address, date, numberOfRooms, typeOfApplience));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            registerUser();
        }
    }

    private void registerClerk() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter clerk's name: ");
            String name = reader.readLine();
            System.out.print("Enter clerk's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter clerk's email: ");
            String email = reader.readLine();
            String id;

            if (Data.getClerkCount() < 10) id = "C00000" + Data.getClerkCount();
            else if (Data.getClerkCount() < 100) id = "C0000" + Data.getClerkCount();
            else if (Data.getClerkCount() < 1000) id = "C000" + Data.getClerkCount();
            else if (Data.getClerkCount() < 10000) id = "C00" + Data.getClerkCount();
            else if (Data.getClerkCount() < 100000) id = "C0)" + Data.getClerkCount();
            else id = "C" + Data.getClerkCount();

            Data.setClerkCount(Data.getClerkCount()+1);

            System.out.println("Clerk's ID number is " + id);
            Data.getClerks().add(new Clerk(id, name, phoneNumber, email));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            System.out.println(e.toString());
            registerUser();
        }
    }

    private void registerEngineer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter engineer's name: ");
            String name = reader.readLine();
            System.out.print("Enter engineer's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter engineer's email: ");
            String email = reader.readLine();
            String id;

            if (Data.getEngineerCount() < 10) id = "E00000" + Data.getEngineerCount();
            else if (Data.getEngineerCount() < 100) id = "E0000" + Data.getEngineerCount();
            else if (Data.getEngineerCount() < 1000) id = "E000" + Data.getEngineerCount();
            else if (Data.getEngineerCount() < 10000) id = "E00" + Data.getEngineerCount();
            else if (Data.getEngineerCount() < 100000) id = "E0)" + Data.getEngineerCount();
            else id = "E" + Data.getEngineerCount();

            Data.setEngineerCount(Data.getEngineerCount() + 1);

            System.out.println("Engineer's ID number is " + id);
            Data.getEngineers().add(new Engineer(id, name, phoneNumber, email, new ArrayList<Client>()));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            registerUser();
        }
    }

    private void registerManager() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter manager's name: ");
            String name = reader.readLine();
            System.out.print("Enter manager's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter manager's email: ");
            String email = reader.readLine();
            String id;

            if (Data.getManagerCount() < 10) id = "M00000" + Data.getManagerCount();
            else if (Data.getManagerCount() < 100) id = "M0000" + Data.getManagerCount();
            else if (Data.getManagerCount() < 1000) id = "M000" + Data.getManagerCount();
            else if (Data.getManagerCount() < 10000) id = "M00" + Data.getManagerCount();
            else if (Data.getManagerCount() < 100000) id = "M0)" + Data.getManagerCount();
            else id = "M" + Data.getManagerCount();

            Data.setManagerCount(Data.getManagerCount() +1);

            System.out.println("Manager's ID number is " + id);
            Data.getManagers().add(new Manager(id, name, phoneNumber, email));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            registerUser();
        }
    }

    protected void search() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Search for a clerk");
        System.out.println("2.Search for a engineer");
        System.out.println("3.Search for a manager");
        System.out.println("4.Search for a client");
        System.out.println("0.Exit to main menu");

        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 1) {
                System.out.print("Enter clerk's name: ");
                String s = reader.readLine();
                int j = searchClerk(s);
                System.out.println(Data.getClerks().get(j).toString());
            } else if (i == 2) {
                System.out.print("Enter engineer's name: ");
                String s = reader.readLine();
                int j = searchEngineer(s);
                System.out.println(Data.getEngineers().get(j).toString());
            } else if (i == 3) {
                System.out.print("Enter manager's name: ");
                String s = reader.readLine();
                int j = searchManager(s);
                System.out.println(Data.getManagers().get(j).toString());
            } else if (i == 4) {
                System.out.print("Enter client's name: ");
                String s = reader.readLine();
                int j = searchClient(s);
                System.out.println(Data.getClients().get(j).toString());
            } else if (i == 0) {
                menu();
            } else {
                System.out.println("Wrong input!");
                search();
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            search();
        }
    }

    protected int searchClient(String in) {
        for (int i=0;i<Data.getClients().size();i++) {
            if (in.equals(Data.getClients().get(i).getName())) {
                return i;
            } else if (in.equals(Data.getClients().get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    private int searchClerk(String in) {
        for (int i=0;i<Data.getClerks().size();i++) {
            if (in.equals(Data.getClerks().get(i).getName())) {
                return i;
            } else if (in.equals(Data.getClerks().get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    private int searchEngineer(String in) {
        for (int i=0;i<Data.getEngineers().size();i++) {
            if (in.equals(Data.getEngineers().get(i).getName())) {
                return i;
            } else if (in.equals(Data.getEngineers().get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    private int searchManager(String in) {
        for (int i=0;i<Data.getManagers().size();i++) {
            if (in.equals(Data.getManagers().get(i).getName())) {
                return i;
            } else if (in.equals(Data.getManagers().get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    protected void editUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Edit clerk's information");
        System.out.println("2.Edit engineer's information");
        System.out.println("3.Edit manager's information");
        System.out.println("4.Edit client's information");
        System.out.println("0.Exit to main menu");

        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 1) {
                editClerk();
            } else if (i == 2) {
                editEngineer();
            } else if (i == 3) {
                editManager();
            } else if (i == 4) {
                editClient();
            } else if (i == 0) {
                menu();
            } else {
                System.out.println("Wrong input!");
                editUser();
            }
        }catch(Exception e){
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    private void editClerk() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter clerk's name or ID number: ");
            String input = reader.readLine();
            int j = searchClerk(input);
            if (j == -1) {
                System.out.println("No clerk with such information");
                editUser();
            }
            System.out.println(Data.getClerks().get(j).toString());
            System.out.println("1.Edit clerk's phone number");
            System.out.println("2.Edit clerk's email");
            System.out.println("3.Search over");
            System.out.println("4.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Enter new phone number: ");
                String phoneNumber = reader.readLine();
                Data.getClerks().get(j).setPhoneNumber(phoneNumber);
                System.out.println("New phone number has been saved");
                menu();
            } else if (choose == 2) {
                System.out.println("Enter new email: ");
                String email = reader.readLine();
                Data.getClerks().get(j).setEmail(email);
                System.out.println("New email has been saved");
                menu();
            } else if (choose == 3) {
                editUser();
            } else if (choose == 4) {
                menu();
            } else {
                System.out.println("Wrong input");
                editUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    private void editEngineer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter engineer's name or ID number: ");
            String input = reader.readLine();
            int j = searchEngineer(input);
            if (j == -1) {
                System.out.println("No engineer with such information");
                editUser();
            }
            System.out.println(Data.getEngineers().get(j).toString());
            System.out.println("1.Edit engineer's phone number");
            System.out.println("2.Edit engineer's email");
            System.out.println("3.Search over");
            System.out.println("4.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Enter new phone number: ");
                String phoneNumber = reader.readLine();
                Data.getEngineers().get(j).setPhoneNumber(phoneNumber);
                System.out.println("New phone number has been saved");
                menu();
            } else if (choose == 2) {
                System.out.println("Enter new email: ");
                String email = reader.readLine();
                Data.getEngineers().get(j).setEmail(email);
                System.out.println("New email has been saved");
                menu();
            } else if (choose == 3) {
                editUser();
            } else if (choose == 4) {
                menu();
            } else {
                System.out.println("Wrong input");
                editUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    private void editManager() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter manager's name or ID number: ");
            String input = reader.readLine();
            int j = searchManager(input);
            if (j == -1) {
                System.out.println("No manager with such information");
                editUser();
            }
            System.out.println(Data.getManagers().get(j).toString());
            System.out.println("1.Edit manager's phone number");
            System.out.println("2.Edit manager's email");
            System.out.println("3.Search over");
            System.out.println("4.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Enter new phone number: ");
                String phoneNumber = reader.readLine();
                Data.getManagers().get(j).setPhoneNumber(phoneNumber);
                System.out.println("New phone number has been saved");
                menu();
            } else if (choose == 2) {
                System.out.println("Enter new email: ");
                String email = reader.readLine();
                Data.getManagers().get(j).setEmail(email);
                System.out.println("New email has been saved");
                menu();
            } else if (choose == 3) {
                editUser();
            } else if (choose == 4) {
                menu();
            } else {
                System.out.println("Wrong input");
                editUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    private void editClient() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter client's name or ID number: ");
            String input = reader.readLine();
            int j = searchManager(input);
            if (j == -1) {
                System.out.println("No client with such information");
                editUser();
            }
            System.out.println(Data.getClients().get(j).toString());
            System.out.println("1.Edit client's phone number");
            System.out.println("2.Edit client's email");
            System.out.println("3.Search over");
            System.out.println("4.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Enter new phone number: ");
                String phoneNumber = reader.readLine();
                Data.getClients().get(j).setPhoneNumber(phoneNumber);
                System.out.println("New phone number has been saved");
                menu();
            } else if (choose == 2) {
                System.out.println("Enter new email: ");
                String email = reader.readLine();
                Data.getClients().get(j).setEmail(email);
                System.out.println("New email has been saved");
                menu();
            } else if (choose == 3) {
                editUser();
            } else if (choose == 4) {
                menu();
            } else {
                System.out.println("Wrong input");
                editUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    protected void logout() {
        try {
            Data.writeClerks();
            Data.writeEngineers();
            Data.writeManagers();
            Data.writeClients();

            Data.writeClerksCount();
            Data.writeEngineersCount();
            Data.writeManagersCount();
            Data.writeClientsCount();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Login.access = false;
    }
}
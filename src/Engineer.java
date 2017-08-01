import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alan on 12.03.16.
 */
public class Engineer extends Administrator implements Serializable {

    private String name;
    private String id;
    private String phoneNumber;
    private String email;
    private ArrayList<Client> clients;

    public Engineer(String id, String name, String phoneNumber, String email, ArrayList<Client> clients) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    protected void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Logged as ENGINEER " + this.getId() + " " + this.getName());
            System.out.println("1.View list");
            System.out.println("2.Generate a report");

            int choose = Integer.parseInt(reader.readLine());

            if (choose == 1) {
                viewInspections();
            } else if (choose == 2) {
                generateReport();
            } else if (choose == 0) {
                logout();
            }
        } catch (Exception e) {
            menu();
        }
    }

    private void viewInspections() {
        System.out.println("List of assigned clients");
        for (Client s : this.getClients()) {
            System.out.println(s.toString());
        }
    }

    private void generateReport() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i=0;i<this.getClients().size();i++) {
                System.out.println(i+1 + this.getClients().get(i).toString());
            }

            System.out.println("Choose from assigned clients:");
            int chooseClient = Integer.parseInt(reader.readLine());
            for (int i=0;i<this.getClients().size();i++) {
                if (chooseClient == i) {
                    System.out.println("Client - " + this.getClients().get(i - 1).toString());
                    System.out.println("Inspection for the client - " + this.getClients().get(i - 1).toString() + " has been done");
                    this.getClients().remove(i-1);
                }
            }
        } catch (Exception e) {
            menu();
        }
    }

    @Override
    public String toString() {
        System.out.println("Assigned clients:");
        for (int i=0;i<clients.size();i++) {
            System.out.println(i+1 +". "+ clients.get(i).toString());
        }
        return "Engineer: " + id + "; " + name + "; " +phoneNumber + "; " + email + ";\n";
    }
}
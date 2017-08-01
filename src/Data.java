import java.io.*;
import java.util.ArrayList;

/**
 * Created by alan on 12.03.16.
 */
public class Data {
    private static Integer clerkCount=1;
    private static Integer engineerCount=1;
    private static Integer managerCount=1;
    private static Integer clientCount=1;

    private static Integer clerkCountW=1;
    private static Integer engineerCountW=1;
    private static Integer managerCountW=1;
    private static Integer clientCountW=1;

    private static ArrayList<Clerk> clerks = new ArrayList<>();
    private static ArrayList<Engineer> engineers = new ArrayList<>();
    private static ArrayList<Manager> managers = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();

    private static ArrayList<Clerk> clerksW = new ArrayList<>();
    private static ArrayList<Engineer> engineersW = new ArrayList<>();
    private static ArrayList<Manager> managersW = new ArrayList<>();
    private static ArrayList<Client> clientsW = new ArrayList<>();

    static {
        try {
            Data.readClerksCount();
            Data.readEngineersCount();
            Data.readManagersCount();
            Data.readClientsCount();

            Data.readClerks();
            Data.readEngineers();
            Data.readManagers();
            Data.readClients();

        } catch (Exception e) {
            e.printStackTrace();
        }
        clerkCountW = clerkCount;
        engineerCountW = engineerCount;
        managerCountW = managerCount;
        clientCountW = clientCount;

        clerksW = clerks;
        engineersW = engineers;
        clientsW = clients;
        managersW = managers;
    }

    public static int getClerkCount() {
        return clerkCount;
    }

    public static int getEngineerCount() {
        return engineerCount;
    }

    public static int getManagerCount() {
        return managerCount;
    }

    public static int getClientCount() {
        return clientCount;
    }

    public static void setClerkCount(int clerkCount) {
        Data.clerkCount = clerkCount;
    }

    public static void setEngineerCount(int engineerCount) {
        Data.engineerCount = engineerCount;
    }

    public static void setManagerCount(int managerCount) {
        Data.managerCount = managerCount;
    }

    public static void setClientCount(int clientCount) {
        Data.clientCount = clientCount;
    }

    public static ArrayList<Clerk> getClerks() {
        return clerksW;
    }

    public static void setClerks(ArrayList<Clerk> clerks) {
        Data.clerks = clerks;
    }

    public static ArrayList<Client> getClients() {
        return clientsW;
    }

    public static void setClients(ArrayList<Client> clients) {
        Data.clients = clients;
    }

    public static ArrayList<Manager> getManagers() {
        return managersW;
    }

    public static void setManagers(ArrayList<Manager> managers) {
        Data.managers = managers;
    }

    public static ArrayList<Engineer> getEngineers() {
        return engineersW;
    }

    public static void setEngineers(ArrayList<Engineer> engineers) {
        Data.engineers = engineers;
    }

    //---------------------------------

    public static void writeClerks() throws IOException {
        FileOutputStream fos = new FileOutputStream("clerksData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getClerks());
        oos.close();
    }

    public static void readClerks() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("clerksData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Clerk> clerks = (ArrayList<Clerk>) ois.readObject();
        setClerks(clerks);
        ois.close();
    }

    public static void writeEngineers() throws IOException {
        FileOutputStream fos = new FileOutputStream("engineersData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getEngineers());
        oos.close();
    }

    public static void readEngineers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("engineersData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Engineer> engineers = (ArrayList<Engineer>) ois.readObject();
        setEngineers(engineers);
        ois.close();
    }

    public static void writeManagers() throws IOException {
        FileOutputStream fos = new FileOutputStream("managersData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getManagers());
        oos.close();
    }

    public static void readManagers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("managersData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Manager> managers = (ArrayList<Manager>) ois.readObject();
        setManagers(managers);
        ois.close();
    }

    public static void writeClients() throws IOException {
        FileOutputStream fos = new FileOutputStream("clientsData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getClients());
        oos.close();
    }

    public static void readClients() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("clientsData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Client> clients = (ArrayList<Client>) ois.readObject();
        setClients(clients);
        ois.close();
    }

    public static void writeClerksCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("clerkCountData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getClerkCount());
        oos.close();
    }

    public static void readClerksCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("clerkCountData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Integer clerkCount = (Integer) ois.readObject();
        setClerkCount(clerkCount);
        ois.close();
    }

    public static void writeEngineersCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("engineersCountData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getEngineerCount());
        oos.close();
    }

    public static void readEngineersCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("engineersCountData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Integer engineerCount = (Integer) ois.readObject();
        setEngineerCount(engineerCount);
        ois.close();
    }

    public static void writeManagersCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("managersCountData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getManagerCount());
        oos.close();
    }

    public static void readManagersCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("managersCountData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Integer managerCount = (Integer) ois.readObject();
        setManagerCount(managerCount);
        ois.close();
    }

    public static void writeClientsCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("clientsCountData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getClientCount());
        oos.close();
    }

    public static void readClientsCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("clientsCountData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Integer clientsCount = (Integer) ois.readObject();
        setClientCount(clientsCount);
        ois.close();
    }

}
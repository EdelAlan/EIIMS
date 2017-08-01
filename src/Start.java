import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Start {

    public void start() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Login menu");
        System.out.println("0.Exit");
        try {
            int in = Integer.parseInt(reader.readLine());
            if (in != 0 && in == 1) {
                Login login = Login.askLogin();
                login.checkLogin();
            } else if (in ==0) {
                System.exit(0);
            } else {
                System.out.println("Wrong input! Press 1 or 0.");
                start();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Press 1 or 0.");
            start();
        }
    }

    public static void main(String[] args)  {

        Start start = new Start();
        start.start();
    }
}
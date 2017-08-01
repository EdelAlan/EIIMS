import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alan on 15.03.16.
 */
public class Login {
    private String login;
    private String password;
    public static boolean access = false;
    Administrator administrator = new Administrator();


    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public static Login askLogin() throws IOException {
        Login login;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter login: ");
        String loginName = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();
        login=new Login(loginName, password);
        return login;
    }

    public void checkLogin() {

        Start start = new Start();

        if (this.getLogin().equals(Administrator.getLogin()) && this.getPassword().equals(Administrator.getPassword())) {
            access=true;
            while (access) {
                administrator.menu();
            }
            if (!access) {
                start.start();
            }
        } else {
            for (int i=0;i<Data.getClerks().size();i++) {
                if (this.getLogin().equals(Data.getClerks().get(i).getName()) && this.getPassword().equals(Data.getClerks().get(i).getId())) {
                    access=true;
                    while (access) {
                        Data.getClerks().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            for (int i=0;i<Data.getEngineers().size();i++) {
                if (this.getLogin().equals(Data.getEngineers().get(i).getName()) && this.getPassword().equals(Data.getEngineers().get(i).getId())) {
                    access=true;
                    while (access) {
                        Data.getEngineers().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            for (int i=0;i<Data.getManagers().size();i++) {
                if (this.getLogin().equals(Data.getManagers().get(i).getName()) && this.getPassword().equals(Data.getManagers().get(i).getId())) {
                    access=true;
                    while (access) {
                        Data.getManagers().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            System.out.println("Wrong input! Please try again");
            start.start();
        }

    }
}
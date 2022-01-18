package Education.Commends;

public interface LoginRegisterCommands {



    String LOGIN = "0";
    String REGISTER = "1";
    String EXIT = "2";
    String PRINTUSER = "3";

    static void printCommands() {
        System.out.println("please input " + LOGIN + " FOR LOGIN");
        System.out.println("please input " + REGISTER + " FOR REGISTER");
        System.out.println("please input " + EXIT + " for LOGOUT");
        System.out.println("please input " + PRINTUSER + " for PRINTUSER");

    }
}

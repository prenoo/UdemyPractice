package email;

public class EmailApp {

    public static void main(String[] args) {

        Email em1 = new Email("John", "Doe");

        em1.changePassword("MMeeOOii");
        System.out.println(em1.getPassword());

    }
}

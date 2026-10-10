
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> nasabah;
    public Bank() {
        nasabah = new ArrayList<>();
    }

    public Customer buatAkun(String nama) {
        String noRekening = String.valueOf(1001 + nasabah.size());

        Customer customer = new Customer(
                nama, noRekening, 100000);

        nasabah.add(customer);
        return customer;
    }
    public Customer cariNasabah(String noRekening) {
        for (Customer customer : nasabah) {
            if (customer.getNoRekening().equals(noRekening)) {
                return customer;
            }
        }

        return null;
    }
    public void tampilkanSemuaNasabah() {
        if (nasabah.isEmpty()) {
            System.out.println("Belum ada akun nasabah.");
            return;
        }

        for (Customer customer : nasabah) {
            System.out.println("--------------------");
            customer.tampilkanData();
        }
        System.out.println("--------------------");
    }
}

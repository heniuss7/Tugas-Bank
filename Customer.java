
public class Customer {
    private String nama;
    private String noRekening;
    private int saldo;
    public Customer(String nama, String noRekening, int saldo) {
        this.nama = nama;
        this.noRekening = noRekening;
        this.saldo = saldo;
    }
    public String getNama() {
        return nama;
    }
    public String getNoRekening() {
        return noRekening;
    }
    public int getSaldo() {
        return saldo;
    }
    public void deposit(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }
    public boolean withdraw(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }
    public void tampilkanData() {
        System.out.println("Nama         : " + nama);
        System.out.println("No. Rekening : " + noRekening);
        System.out.println("Saldo        : Rp " + saldo);
    }
}


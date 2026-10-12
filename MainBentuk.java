public class MainBentuk {
    public static void main(String[] args) {

        BujurSangkar persegi = new BujurSangkar(4, "Merah");
        Lingkaran lingkaran = new Lingkaran(7, "Biru");
        Silinder silinder = new Silinder(10, 7, "Hijau");

        persegi.printInfo();
        lingkaran.printInfo();
        silinder.printInfo();

        System.out.println("\n=== POLYMORPHISM ===");
        Bentuk[] daftarBentuk = {
                persegi,
                lingkaran,
                silinder
        };
        for (Bentuk bentuk : daftarBentuk) {
            bentuk.printInfo();
        }
    }
}

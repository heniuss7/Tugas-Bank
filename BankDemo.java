import java.util.Scanner;

public class BankDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        int pilihan;

        do {
            System.out.println("\n===== BANK ABC =====");
            System.out.println("1. Buat Akun");
            System.out.println("2. Login Nasabah");
            System.out.println("3. Lihat Semua Nasabah");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();

                    if (nama.trim().isEmpty()) {
                        System.out.println("Nama tidak boleh kosong.");
                        break;
                    }

                    Customer customer = bank.buatAkun(nama);

                    System.out.println("\nAkun berhasil dibuat!");
                    System.out.println("Nama         : " + customer.getNama());
                    System.out.println("No. Rekening : " + customer.getNoRekening());
                    System.out.println("Saldo awal   : Rp " + customer.getSaldo());
                    break;

                case 2:
                    System.out.print("Masukkan nomor rekening: ");
                    String noRekening = input.nextLine();

                    Customer nasabah = bank.cariNasabah(noRekening);

                    if (nasabah == null) {
                        System.out.println("Akun tidak ditemukan.");
                        break;
                    }

                    int menuNasabah;

                    do {
                        System.out.println("\n===== MENU NASABAH =====");
                        System.out.println("Selamat datang, " + nasabah.getNama());
                        System.out.println("1. Setor Uang");
                        System.out.println("2. Tarik Uang");
                        System.out.println("3. Cek Saldo");
                        System.out.println("4. Logout");
                        System.out.print("Pilih menu: ");

                        menuNasabah = input.nextInt();

                        switch (menuNasabah) {
                            case 1:
                                System.out.print("Jumlah setor: Rp ");
                                int setor = input.nextInt();

                                if (setor > 0) {
                                    nasabah.deposit(setor);
                                    System.out.println("Setor berhasil.");
                                } else {
                                    System.out.println("Jumlah harus lebih dari 0.");
                                }
                                break;

                            case 2:
                                System.out.print("Jumlah tarik: Rp ");
                                int tarik = input.nextInt();

                                if (nasabah.withdraw(tarik)) {
                                    System.out.println("Penarikan berhasil.");
                                } else {
                                    System.out.println(
                                            "Penarikan gagal. Jumlah tidak valid atau saldo tidak cukup.");
                                }
                                break;

                            case 3:
                                System.out.println(
                                        "Saldo Anda: Rp " + nasabah.getSaldo());
                                break;

                            case 4:
                                System.out.println("Anda berhasil logout.");
                                break;

                            default:
                                System.out.println("Pilihan tidak tersedia.");
                        }

                    } while (menuNasabah != 4);

                    input.nextLine();
                    break;

                case 3:
                    bank.tampilkanSemuaNasabah();
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Bank ABC.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 4);

        input.close();
    }
}

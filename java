import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input nama
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();

        // Input jenis kelamin
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        String jenisKelaminStr = (jenisKelamin == 'P' || jenisKelamin == 'p') ? "Perempuan" : "Laki-laki";

        // Input tanggal lahir
        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
        String tanggalLahirStr = scanner.next();

        // Konversi tanggal lahir ke LocalDate
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        // Hitung umur
        LocalDate tanggalSekarang = LocalDate.now();
        Period periode = Period.between(tanggalLahir, tanggalSekarang);
        int umur = periode.getYears();

        // Output data diri
        System.out.println("\nData diri Anda:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminStr);
        System.out.println("Umur: " + umur + " tahun");
    }
}

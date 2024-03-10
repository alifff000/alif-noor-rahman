import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String inputNama = input.nextLine();

        System.out.print("Jenis kelamin (L/P): ");
        String inputJenisKelamin = input.next();
        while (!inputJenisKelamin.equalsIgnoreCase("L") && !inputJenisKelamin.equalsIgnoreCase("P")) {
            System.out.println("Masukkan jenis kelamin yang valid (L/P): ");
            inputJenisKelamin = input.next();
        }

        String jeniskelaminlengkap = inputJenisKelamin.equalsIgnoreCase("L") ? "Laki-Laki" : "Perempuan";

        System.out.print("Tanggal lahir (dd-mm-yyyy): ");
        String inputTanggalLahir = input.next();
        while (!isValidDateFormat(inputTanggalLahir)) {
            System.out.println("Format tanggal tidak valid. Masukkan kembali (dd-MM-yyyy): ");
            inputTanggalLahir = input.next();
        }

        DateTimeFormatter formattanggal = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tanggallahir = LocalDate.parse(inputTanggalLahir, formattanggal);
        LocalDate waktuterkini = LocalDate.now();
        int tahun = Period.between(tanggallahir, waktuterkini).getYears();
        int bulan = Period.between(tanggallahir, waktuterkini).getMonths();

        System.out.format("\nNama: %s\n", inputNama);
        System.out.format("Jenis Kelamin: %s\n", jeniskelaminlengkap);
        System.out.format("Umur Anda: %d tahun %d bulan\n", tahun, bulan);
        input.close();
    }

    private static boolean isValidDateFormat(String date) {
        try {
            DateTimeFormatter formattanggal = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(date, formattanggal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

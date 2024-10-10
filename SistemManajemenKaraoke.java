import java.util.*;
import java.util.Scanner;
public class SistemManajemenKaraoke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-- SISTEM MANAJEMEN KARAOKE --");
        System.out.println("1. Tambah Ruangan");
        System.out.println("2. Lihat Daftar Ruangan");
        System.out.println("3 Pesan Ruangan");
        System.out.println("4. Tambah Lagu");
        System.out.println("5. Cari Lagu");
        System.out.println("6. Tambah Lagu ke Daftar Putar Ruangan");
        System.out.println("7. Lihat Daftar Putar Ruangan");
        System.out.println("8. Selesai Menggunakan Ruangan");
        System.out.println("9. Lihat Total Pendapatan");
        System.out.println("10. Laporan Penggunaan Ruangan");
        System.out.println("0. E X I T");
        System.out.println("Pilih Opsi : ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 0:
                System.out.println("Sistem Berhenti.");
                input.close();
                break;
            default:
                System.out.println("Pilihan tidak valid. Pilih (1 - 10)");

        }
    }
}

enum jenisRuangan {
    REGULAR,
    VIP,
    VVIP
}

class ruangan {
    private int nomorRuangan;
    private boolean dipakai;
    private double harga;
    private jenisRuangan jenis;

    public ruangan(int nomorRuangan, double harga, jenisRuangan jenis) {
        this. nomorRuangan = nomorRuangan;
        this.dipakai = false;
        this.harga = harga;
        this.jenis = jenis;
    }

    public int getNomorRuangan() {return nomorRuangan;}
    public boolean isDipakai() {return dipakai;}
    public void setDipakai(boolean dipakai) {this.dipakai = dipakai;}
    public double getHarga() {return harga;}
    public jenisRuangan getJenis() {return jenis;}
}

class lagu {
    private String judul;
    private String penyanyi;

    public lagu(String judul, String penyanyi) {
        this.judul = judul;
        this.penyanyi = penyanyi;
    }

    public String getJudul() {return judul;}
    public String getPenyanyi() {return penyanyi;}
}

class sistemKaraoke {
    private List<ruangan> daftarRuangan;
    private List<lagu> daftarLagu;
    private Map<Integer, List<lagu>> daftarPutar;
    private double totalPendapatan;

    public sistemKaraoke() {
        daftarRuangan = new ArrayList<>();
        daftarLagu = new ArrayList<>();
        daftarPutar = new HashMap<>();
        totalPendapatan = 0;
    }


}




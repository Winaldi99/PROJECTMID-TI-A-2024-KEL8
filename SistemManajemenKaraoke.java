import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class SistemManajemenKaraoke {
    public static void main(String[] args) {
        sistemKaraoke sistem = new sistemKaraoke();
        Scanner scanner = new Scanner(System.in);

        sistem.tambahRuangan(1, 50000, jenisRuangan.REGULAR);
        sistem.tambahRuangan(2, 60000, jenisRuangan.VIP);
        sistem.tambahRuangan(3, 70000, jenisRuangan.VVIP);
        sistem.tambahLagu("Shape of You", "Ed Sheeran");
        sistem.tambahLagu("Uptown Funk", "Mark Ronson ft. Bruno Mars");

        while (true) {

            System.out.println("-- SISTEM MANAJEMEN KARAOKE --");
            System.out.println("1. Tambah Ruangan");
            System.out.println("2. Lihat Daftar Ruangan");
            System.out.println("3. Pesan Ruangan");
            System.out.println("4. Tambah Lagu");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Tambah Lagu ke Daftar Putar Ruangan");
            System.out.println("7. Lihat Daftar Putar Ruangan");
            System.out.println("8. Selesai Menggunakan Ruangan");
            System.out.println("9. Lihat Total Pendapatan");
            System.out.println("10. Laporan Penggunaan Ruangan");
            System.out.println("0. E X I T");
            System.out.println("Pilih Opsi : ");
            int pilih;

            try {
                pilih = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid");
                continue;
            }
            clearScreen();

            switch (pilih) {
                case 1:
                    System.out.println("Masukkan nomor Ruangan: ");
                    int nomorRuangan = Integer.parseInt(scanner.nextLine());
                    System.out.println("Masukkan harga Ruangan: ");
                    double harga = Double.parseDouble(scanner.nextLine());
                    System.out.println("Masukkan jenis Ruangan ( REGULAR / VIP / VVIP ): ");
                    jenisRuangan jenis = jenisRuangan.valueOf(scanner.nextLine().toUpperCase());
                    sistem.tambahRuangan(nomorRuangan, harga, jenis);
                    break;
                case 2:
                    sistem.lihatDaftarRuangan();
                    break;
                case 3:
                    System.out.println("Masukkan nomor ruangan yang ingin dipesan: ");
                    sistem.pesanRuangan(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.println("Masukkan judul Lagu: ");
                    String judul = scanner.nextLine();
                    System.out.println("Masukkan nama Penyanyi: ");
                    String penyanyi = scanner.nextLine();
                    sistem.tambahLagu(judul, penyanyi);
                    break;
                case 5:
                    System.out.println("Masukkan kata kunci pencarian: ");
                    sistem.cariLagu(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Masukkan nomor ruangan: ");
                    int nomorRuanganPutar = Integer.parseInt(scanner.nextLine());
                    System.out.println("Masukkan judul lagu: ");
                    String judulPutar = scanner.nextLine();
                    sistem.tambahKeDaftarPutar(nomorRuanganPutar,judulPutar);
                    break;
                case 7:
                    System.out.println("Masukkan nomor ruangan: ");
                    sistem.lihatDaftarPutar(Integer.parseInt(scanner.nextLine()));
                    break;
                case 8:
                    System.out.println("Masukkan nomor ruangan yang ingin selesai digunakan");
                    sistem.selesaiMenggunakanRuangan(Integer.parseInt(scanner.nextLine()));
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 0:
                    System.out.println("Sistem Berhenti.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Pilih (1 - 10)");
            }
        }
    }
    public static void clearScreen() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
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

    public void tambahRuangan(int nomorRuangan, double harga, jenisRuangan jenis) {
        daftarRuangan.add(new ruangan(nomorRuangan, harga, jenis));
        System.out.println("Ruangan " + nomorRuangan + " (" + jenis + ") Berhasil Ditambahkan.");
    }

    public void tambahLagu(String judul, String penyanyi) {
        daftarLagu.add(new lagu(judul, penyanyi));
        System.out.println("Lagu '" + judul + "' oleh " + penyanyi + " Berhasil Ditambahkan.");
    }

    public void pesanRuangan(int nomorRuangan) {
        for (ruangan ruangan : daftarRuangan) {
            if (ruangan.getNomorRuangan() == nomorRuangan && !
                    ruangan.isDipakai()) {
                ruangan.setDipakai(true);
                totalPendapatan += ruangan.getHarga();
                System.out.println("Ruangan " + nomorRuangan + " berhasil dipesan.");
                return;
            }
        }
        System.out.println("Ruangan " + nomorRuangan + "tidak tersedia atau tidak ada.");
    }

    public void lihatDaftarRuangan() {
        if (daftarRuangan.isEmpty()) {
            System.out.println("Ruangan tidak tersedia.");
            return;
        }
        for (ruangan ruangan : daftarRuangan) {
            System.out.println("Ruangan " + ruangan.getNomorRuangan() + " (" + ruangan.getJenis() + "): "
                    + (ruangan.isDipakai() ? "Terpakai" : "Tersedia") + " - Harga: Rp" + ruangan.getHarga());
        }
    }

    public void cariLagu(String katakunci) {
        boolean ditemukan = false;
        for (lagu lagu : daftarLagu) {
            if (lagu.getJudul().toLowerCase().contains(katakunci.toLowerCase()) ||
                    lagu.getPenyanyi().toLowerCase().contains(katakunci.toLowerCase())) {
                System.out.println(lagu.getJudul() + " oleh " + lagu.getPenyanyi());
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada lagu yang cocok: " + katakunci);
        }
    }

    public void tambahKeDaftarPutar(int nomorRuangan, String judul) {
        for (lagu lagu : daftarLagu) {
            if (lagu.getJudul().equalsIgnoreCase(judul)) {
                daftarPutar.computeIfAbsent(nomorRuangan, k -> new ArrayList<>()).add(lagu);
                System.out.println("Menambahkan " + judul + " ke daftar putar Ruangan " + nomorRuangan + ".");
                return;
            }
        }
        System.out.println("Lagu tidak ditemukan dalam daftar lagu.");
    }

    public void lihatDaftarPutar(int nomorRuangan) {
        List<lagu> daftarPutarRuangan =
                daftarPutar.get(nomorRuangan);
        if (daftarPutarRuangan != null && !daftarPutarRuangan.isEmpty()) {
            System.out.println("Daftar putar untuk Ruangan " + nomorRuangan + ":");
            for (lagu lagu : daftarPutarRuangan) {
                System.out.println(lagu.getJudul() + " oleh " + lagu.getPenyanyi());
            }
        } else {
            System.out.println("Tidak ada daftar putar untuk Ruangan " + nomorRuangan);
        }
    }

    public void selesaiMenggunakanRuangan(int nomorRuangan)  {
        for(ruangan ruangan : daftarRuangan) {
            if (ruangan.getNomorRuangan() == nomorRuangan && ruangan.isDipakai()) {
                ruangan.setDipakai(false);
                daftarPutar.remove(nomorRuangan);
                System.out.println("Ruangan " + nomorRuangan + " sekarang tersedia.");
                return;
            }
        }
        System.out.println("Ruangan " + nomorRuangan + "tidak sedang dipakai atau tidak ada.");
    }
}







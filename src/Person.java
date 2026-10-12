public class Person {
    // Person attributes
    private String id;
    private String nama;
    private int tahunLahir;
    private String kategori;
    private String warnaMcLaren;

    // Constructor
    public Person(String id, String nama, int tahunLahir, String kategori, String warnaMcLaren){
        this.id = id;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.kategori = kategori;
        this.warnaMcLaren = warnaMcLaren;
    }

    // Getter and setter each attributes
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public int getTahunLahir(){
        return tahunLahir;
    }
    public void setTahunLahir(int tahunLahir){
        this.tahunLahir = tahunLahir;
    }

    public String getKategori(){
        return kategori;
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    public String getWarna(){
        return warnaMcLaren;
    }
    public void setWarna(String warnaMcLaren){
        this.warnaMcLaren = warnaMcLaren;
    }
}

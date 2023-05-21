package penjualan_rumah.model;

public class Rumah {
    private int id;
    private String nomorRumah;
    private String tipeRumah;
    private int luasTanah;
    private int luasBangunan;
    private String lokasi;
    private int harga;

    public Rumah() {
    }

    public Rumah(int id, String nomorRumah, String tipeRumah, int luasTanah, int luasBangunan, String lokasi, int harga) {
        this.id = id;
        this.nomorRumah = nomorRumah;
        this.tipeRumah = tipeRumah;
        this.luasTanah = luasTanah;
        this.luasBangunan = luasBangunan;
        this.lokasi = lokasi;
        this.harga = harga;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomorRumah() {
        return nomorRumah;
    }

    public void setNomorRumah(String nomorRumah) {
        this.nomorRumah = nomorRumah;
    }

    public String getTipeRumah() {
        return tipeRumah;
    }

    public void setTipeRumah(String tipeRumah) {
        this.tipeRumah = tipeRumah;
    }

    public int getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(int luasTanah) {
        this.luasTanah = luasTanah;
    }

    public int getLuasBangunan() {
        return luasBangunan;
    }

    public void setLuasBangunan(int luasBangunan) {
        this.luasBangunan = luasBangunan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Rumah{" +
                "id=" + id +
                ", nomorRumah='" + nomorRumah + '\'' +
                ", tipeRumah='" + tipeRumah + '\'' +
                ", luasTanah=" + luasTanah +
                ", luasBangunan=" + luasBangunan +
                ", lokasi='" + lokasi + '\'' +
                ", harga=" + harga +
                '}';
    }
}

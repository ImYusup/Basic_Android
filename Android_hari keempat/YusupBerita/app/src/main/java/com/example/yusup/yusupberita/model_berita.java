package com.example.yusup.yusupberita;

/**
 * Created by yusup on 11/18/2016.
 */

public class model_berita {
          //create getter & setter
    public String getId_berita() {
        return id_berita;
    }

    public void setId_berita(String id_berita) {
        this.id_berita = id_berita;
    }

    public String getJudul_berita() {
        return judul_berita;
    }

    public void setJudul_berita(String judul_berita) {
        this.judul_berita = judul_berita;
    }

    public String getGambar_berita() {
        return gambar_berita;
    }

    public void setGambar_berita(String gambar_berita) {
        this.gambar_berita = gambar_berita;
    }

    String id_berita, judul_berita, gambar_berita;
}

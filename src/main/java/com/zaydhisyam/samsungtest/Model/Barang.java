package com.zaydhisyam.samsungtest.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Barang {
    @Id
    private String id;
    private String namaBarang;
    private String namaAkunPenjual;
    private Status status;
    private Integer hargaBarang;
    private Ulasan ulasan;
    private Integer jumlahTerjual;
    private String alamatKirim;
    private String pranala;

    public Barang() {}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaAkunPenjual() {
        return this.namaAkunPenjual;
    }

    public void setNamaAkunPenjual(String namaAkunPenjual) {
        this.namaAkunPenjual = namaAkunPenjual;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getHargaBarang() {
        return this.hargaBarang;
    }

    public void setHargaBarang(Integer hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public Ulasan getUlasan() {
        return this.ulasan;
    }

    public void setUlasan(Ulasan ulasan) {
        this.ulasan = ulasan;
    }

    public Integer getJumlahTerjual() {
        return this.jumlahTerjual;
    }

    public void setJumlahTerjual(Integer jumlahTerjual) {
        this.jumlahTerjual = jumlahTerjual;
    }

    public String getAlamatKirim() {
        return this.alamatKirim;
    }

    public void setAlamatKirim(String alamatKirim) {
        this.alamatKirim = alamatKirim;
    }

    public String getPranala() {
        return this.pranala;
    }

    public void setPranala(String pranala) {
        this.pranala = pranala;
    }
}
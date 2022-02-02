package com.zaydhisyam.samsungtest;

import java.util.List;

import com.zaydhisyam.samsungtest.Model.Barang;
import com.zaydhisyam.samsungtest.Model.Status;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BarangRepository extends MongoRepository<Barang, String> {
    
    List<Barang> findByNamaAkunPenjual(String namaAkunPenjual);

    List<Barang> findByStatus(Status status);

    List<Barang> findByAlamatKirim(String alamatKirim);
}
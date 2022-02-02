package com.zaydhisyam.samsungtest;

import java.util.List;

import com.zaydhisyam.samsungtest.Model.Barang;
import com.zaydhisyam.samsungtest.Model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServices {
    
    @Autowired
    private BarangRepository repository;

    public List<Barang> fetchAllBarang() {
        return repository.findAll();
    }

    public List<Barang> findByAkunPenjual(String namaAkunPenjual) {
        return repository.findByNamaAkunPenjual(namaAkunPenjual);
    }

    public List<Barang> findByAlamatKirim(String alamatKirim) {
        return repository.findByAlamatKirim(alamatKirim);
    }

    public List<Barang> findByStatus(String isOnline) {        
        Status _status;
        if (isOnline.toLowerCase().equals("yes")) _status = Status.Online;
        else _status = Status.Offline;

        return repository.findByStatus(_status);
    }

    public Barang createOrUpdateBarang(Barang barang) {
        return repository.save(barang);
    }

    public void deleteBarangById(String id) {
        repository.deleteById(id);
    }
}
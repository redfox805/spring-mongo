package com.zaydhisyam.samsungtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zaydhisyam.samsungtest.Model.Barang;
import com.zaydhisyam.samsungtest.Model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/barang")
public class BarangController {
    
    @Autowired
    private BarangRepository repository;

    @GetMapping(value = "/list")
    public List<Barang> fetchAllBarang() {
        return repository.findAll();
    }

    @GetMapping(value = "/akun-penjual/{value}")
    public List<Barang> findByAkunPenjual(@PathVariable("value") String namaAkunPenjual) {
        return repository.findByNamaAkunPenjual(namaAkunPenjual);
    }

    @GetMapping(value = "/alamat-kirim/{value}")
    public List<Barang> findByAlamatKirim(@PathVariable("value") String alamatKirim) {
        return repository.findByAlamatKirim(alamatKirim);
    }

    @GetMapping(value = "/status/{value}")
    public List<Barang> findByStatus(@PathVariable("value") String isOnline) {
        Status _status;
        if (isOnline.equals("Online")) _status = Status.Online;
        else _status = Status.Offline;

        return repository.findByStatus(_status);
    }

    @GetMapping(value = "/{id}")
    public List<Barang> findById(@PathVariable String id) {
        List<Barang> result = new ArrayList<>();

        Barang barang = repository.findById(id).orElse(null);
        if (barang != null) result.add(barang);

        return result;
    }

    @PostMapping(value = "/")
    public Barang createNewBarang(@RequestBody Barang barang) {
        return repository.save(barang);
    }

    @PutMapping(value = "/{id}")
    public Barang updateBarang(@PathVariable String id, @RequestBody Barang barang) {
        barang.setId(id);
        return repository.save(barang);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBarangById(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
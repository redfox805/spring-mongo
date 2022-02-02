package com.zaydhisyam.samsungtest;

import java.util.List;

import com.zaydhisyam.samsungtest.Model.Barang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BarangController {
    
    @Autowired
    private BarangServices services;

    @GetMapping(value = "/")
    public List<Barang> fetchAllBarang() {
        return services.fetchAllBarang();
    }

    @GetMapping(value = "akun-penjual")
    public List<Barang> findByAkunPenjual(@RequestParam("v") String namaAkunPenjual) {
        return services.findByAkunPenjual(namaAkunPenjual);
    }

    @GetMapping(value = "alamat-kirim")
    public List<Barang> findByAlamatKirim(@RequestParam("v") String alamatKirim) {
        return services.findByAlamatKirim(alamatKirim);
    }

    @GetMapping(value = "is-online")
    public List<Barang> findByStatus(@RequestParam("v") String isOnline) {
        return services.findByStatus(isOnline);
    }

    @PostMapping(value = "/")
    public Barang createNewBarang(@RequestBody Barang barang) {
        return services.createOrUpdateBarang(barang);
    }

    @PutMapping(value = "/{id}")
    public Barang updateBarang(@PathVariable String id, @RequestBody Barang barang) {
        barang.setId(id);
        return services.createOrUpdateBarang(barang);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBarangById(@PathVariable String id) {
        services.deleteBarangById(id);
        return ResponseEntity.ok(id);
    }
}
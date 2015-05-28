/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author General
 */
public class Mahasiswa {

    private String nim;
    private String nama;
    private String prodi;
    private String alamat;
    private String konsumsi;
    private String status;
    private String password;
    private String kelompok;
    private String alergi;
    private String penyakit;
    private String tahun;

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getAlergi() {
        return alergi;
    }

    public void setAlergi(String alergi) {
        this.alergi = alergi;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getKelompok() {
        return kelompok;
    }

    public void setKelompok(String kelompok) {
        this.kelompok = kelompok;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKonsumsi() {
        return konsumsi;
    }

    public void setKonsumsi(String konsumsi) {
        this.konsumsi = konsumsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

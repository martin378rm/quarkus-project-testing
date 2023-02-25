package id.martin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserData {

    @NotBlank(message = "kolom nama wajib di isi")
    private String nama;
    @NotBlank(message = "kolom email wajib di isi")
    private String email;
    @NotNull(message = "kolom NIM wajib di isi")
    private Integer NIM;
    @NotBlank(message = "kolom alamat wajib di isi")
    private String alamat;

    public UserData(String nama, String email, Integer NIM, String alamat) {
        this.nama = nama;
        this.email = email;
        this.NIM = NIM;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNIM() {
        return NIM;
    }

    public void setNIM(Integer NIM) {
        this.NIM = NIM;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

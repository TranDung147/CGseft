package Model;

import java.util.Date;

public abstract class BenhAn {
    private static int count = 0;
    protected int soThuTu;
    protected String maBenhAn;
    protected String maBenhNhan;
    protected String tenBenhNhan;
    protected Date ngayNhapVien;
    protected Date ngayRaVien;
    protected String lyDoNhapVien;

    public BenhAn() {
    }

    public BenhAn(String maBenhAn, String maBenhNhan, String tenBenhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDoNhapVien) {
        this.soThuTu = ++count;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public abstract String toCSV();
    public abstract void fromCSV(String csv);
    public abstract String getAdditionalInfo();

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        BenhAn.count = count;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
package Model;

import java.util.Date;

public class BenhAnThuong extends BenhAn {
    private double phiNamVien;

    public BenhAnThuong(){
    }

    @Override
    public String toCSV() {
        return soThuTu + "," + maBenhAn + "," + maBenhNhan + "," + tenBenhNhan + "," + ngayNhapVien + "," + ngayRaVien + "," + lyDoNhapVien + "," + phiNamVien;
    }

    @Override
    public void fromCSV(String csv) {
        // parse CSV string to object properties
    }

    public BenhAnThuong(String maBenhAn, String maBenhNhan, String tenBenhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Phi nam vien: %.2f", phiNamVien);
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }
}
package Model;

import java.util.Date;

public class BenhAnVIP extends BenhAn {
    private String loaiVIP;
    private Date thoiHanVIP;

    public BenhAnVIP() {
    }
    public BenhAnVIP(String maBenhAn, String maBenhNhan, String tenBenhNhan, Date ngayNhapVien, Date ngayRaVien, String lyDoNhapVien, String loaiVIP, Date thoiHanVIP) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVIP = loaiVIP;
        this.thoiHanVIP = thoiHanVIP;
    }

    @Override
    public String toCSV() {
        return soThuTu + "," + maBenhAn + "," + maBenhNhan + "," + tenBenhNhan + "," + ngayNhapVien + "," + ngayRaVien + "," + lyDoNhapVien + "," + loaiVIP + "," + thoiHanVIP;
    }

    @Override
    public void fromCSV(String csv) {
        // parse CSV string to object properties
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Loai VIP: %s, Thoi han VIP: %s", loaiVIP, thoiHanVIP);
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public Date getThoiHanVIP() {
        return thoiHanVIP;
    }

    public void setThoiHanVIP(Date thoiHanVIP) {
        this.thoiHanVIP = thoiHanVIP;
    }
}
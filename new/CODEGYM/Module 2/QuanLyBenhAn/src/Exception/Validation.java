package Exception;

import Model.BenhAn;

import java.text.SimpleDateFormat;
import java.util.List;

public class Validation {
    public  void validateMaBenhAn(String maBenhAn, List<BenhAn> records) throws DuplicateMedicalRecordException {
        if (!maBenhAn.matches("BA-[0-9]{3}")) {
            System.out.println("Invalid Ma Benh An format. Please use BA-XXX.");
            throw new IllegalArgumentException();
        }

        for (BenhAn record : records) {
            if (record.getMaBenhAn().equals(maBenhAn)) {
                System.out.println("Duplicate Ma Benh An found.");
                throw new DuplicateMedicalRecordException("Ma Benh An already exists.");
            }
        }
    }

    public  void validateMaBenhNhan(String maBenhNhan) {
        if (!maBenhNhan.matches("BN-[0-9]{3}")) {
            System.out.println("Invalid Ma Benh Nhan format. Please use BN-XXX.");
            throw new IllegalArgumentException();
        }
    }

    public  void validateLoaiVIP(String loaiVIP) {
        if (!loaiVIP.matches("VIP [I|II|III]")) {
            System.out.println("Invalid Loai VIP format. Please use VIP I, VIP II, or VIP III.");
            throw new IllegalArgumentException();
        }
    }

    public  void validateNgay(String ngayNhapVienStr, String ngayRaVienStr) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(ngayNhapVienStr);
            dateFormat.parse(ngayRaVienStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            throw e;
        }
    }
}
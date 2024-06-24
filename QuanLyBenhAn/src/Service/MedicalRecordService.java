package Service;

import Exception.DuplicateMedicalRecordException;
import Exception.Validation;
import Model.BenhAn;
import Model.BenhAnThuong;
import Model.BenhAnVIP;
import Util.CSVUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private final Scanner SCANNER = new Scanner(System.in);
    Validation val = new Validation();

    public void addNewMedicalRecord() {
        try {
            List<BenhAn> records = CSVUtils.readCSV();

            // Auto-increment `soThuTu`
            int nextSoThuTu = records.isEmpty() ? 1 : records.get(records.size() - 1).getSoThuTu() + 1;

            System.out.print("Enter Ma Benh An (BA-XXX): ");
            String maBenhAn = SCANNER.nextLine();
            val.validateMaBenhAn(maBenhAn, records);

            System.out.print("Enter Ma Benh Nhan (BN-XXX): ");
            String maBenhNhan = SCANNER.nextLine();
            val.validateMaBenhNhan(maBenhNhan);

            System.out.print("Enter Ten Benh Nhan: ");
            String tenBenhNhan = SCANNER.nextLine();

            System.out.print("Enter Ngay Nhap Vien (dd/MM/yyyy): ");
            String ngayNhapVienStr = SCANNER.nextLine();
            System.out.print("Enter Ngay Ra Vien (dd/MM/yyyy): ");
            String ngayRaVienStr = SCANNER.nextLine();
            val.validateNgay(ngayNhapVienStr, ngayRaVienStr);

            System.out.print("Enter Ly Do Nhap Vien: ");
            String lyDoNhapVien = SCANNER.nextLine();

            System.out.print("Is this a VIP patient? (yes/no): ");
            String isVIP = SCANNER.nextLine();

            BenhAn benhAn;
            if (isVIP.equalsIgnoreCase("yes")) {
                benhAn = new BenhAnVIP();
                System.out.print("Enter Loai VIP (VIP I, VIP II, VIP III): ");
                String loaiVIP = SCANNER.nextLine();
                val.validateLoaiVIP(loaiVIP);
                System.out.print("Enter Thoi Han VIP (dd/MM/yyyy): ");
                String thoiHanVIPStr = SCANNER.nextLine();
                ((BenhAnVIP) benhAn).setLoaiVIP(loaiVIP);
                ((BenhAnVIP) benhAn).setThoiHanVIP(DATE_FORMAT.parse(thoiHanVIPStr));
            } else {
                benhAn = new BenhAnThuong();
                System.out.print("Enter Phi Nam Vien: ");
                double phiNamVien = Double.parseDouble(SCANNER.nextLine());
                ((BenhAnThuong) benhAn).setPhiNamVien(phiNamVien);
            }

            benhAn.setSoThuTu(nextSoThuTu);
            benhAn.setMaBenhAn(maBenhAn);
            benhAn.setMaBenhNhan(maBenhNhan);
            benhAn.setTenBenhNhan(tenBenhNhan);
            benhAn.setNgayNhapVien(DATE_FORMAT.parse(ngayNhapVienStr));
            benhAn.setNgayRaVien(DATE_FORMAT.parse(ngayRaVienStr));
            benhAn.setLyDoNhapVien(lyDoNhapVien);

            records.add(benhAn);
            CSVUtils.writeCSV(records);
            System.out.println("Medical record added successfully.");

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        } catch (DuplicateMedicalRecordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMedicalRecord() {
        List<BenhAn> records = CSVUtils.readCSV();
        System.out.print("Enter Ma Benh An to delete: ");
        String maBenhAn = SCANNER.nextLine();
        BenhAn recordToDelete = null;

        for (BenhAn record : records) {
            if (record.getMaBenhAn().equals(maBenhAn)) {
                recordToDelete = record;
                break;
            }
        }

        if (recordToDelete != null) {
            System.out.print("Are you sure you want to delete this record? (yes/no): ");
            String confirmation = SCANNER.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                records.remove(recordToDelete);
                CSVUtils.writeCSV(records);
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Record not found.");
        }
    }

    public void viewMedicalRecords() {
        List<BenhAn> records = CSVUtils.readCSV();

        if (records.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }

        for (BenhAn record : records) {
            System.out.println(record);
        }
    }
}


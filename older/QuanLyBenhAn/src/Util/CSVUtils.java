package Util;

import Model.BenhAn;
import Model.BenhAnThuong;
import Model.BenhAnVIP;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private static final String FILE_PATH = "data/medical_records.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static List<BenhAn> readCSV() {
        List<BenhAn> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                BenhAn benhAn;
                if (values.length == 7) { // BenhAnThuong
                    benhAn = new BenhAnThuong();
                    ((BenhAnThuong) benhAn).setPhiNamVien(Double.parseDouble(values[6]));
                } else { // BenhAnVIP
                    benhAn = new BenhAnVIP();
                    ((BenhAnVIP) benhAn).setLoaiVIP(values[6]);
                    ((BenhAnVIP) benhAn).setThoiHanVIP(DATE_FORMAT.parse(values[7]));
                }
                benhAn.setSoThuTu(Integer.parseInt(values[0]));
                benhAn.setMaBenhAn(values[1]);
                benhAn.setMaBenhNhan(values[2]);
                benhAn.setTenBenhNhan(values[3]);
                benhAn.setNgayNhapVien(DATE_FORMAT.parse(values[4]));
                benhAn.setNgayRaVien(DATE_FORMAT.parse(values[5]));
                benhAn.setLyDoNhapVien(values[6]);
                records.add(benhAn);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void writeCSV(List<BenhAn> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (BenhAn benhAn : records) {
                bw.write(benhAn.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
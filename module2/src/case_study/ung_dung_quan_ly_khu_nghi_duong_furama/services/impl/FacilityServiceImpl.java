package case_study.ung_dung_quan_ly_khu_nghi_duong_furama.services.impl;

import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.model.Facility;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.model.House;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.model.Room;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.model.Villa;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.services.FacilityService;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.utils.ReadAndWrite;
import case_study.ung_dung_quan_ly_khu_nghi_duong_furama.utils.RegexDaTa;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR = "^[A-Z][a-z]+$";

    public static final String REGEX_ID_VILLA = "^SVVL-\\d{4}$";

    public static final String REGEX_ID_HOUSE = "^SVHO-\\d{4}$";

    public static final String REGEX_ID_ROOM = "^SVRO-\\d{4}$";

    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";

    public static final String REGEX_DOU = "^[1-9]|([1][0-9])$";

    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    private static List<House> houseList = new ArrayList<>();

    private static List<Villa> villaList = new ArrayList<>();

    private static List<Room> roomList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    static {
        houseList = ReadAndWrite.readHouseListFromCSV();
        villaList = ReadAndWrite.readVillaListFromCSV();
        roomList = ReadAndWrite.readRoomListFromCSV();
    }

    @Override
    public void disPlay() {
        int index = 0;
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (facility.getKey() instanceof Villa) {
                System.out.println("Danh sách Villa là: ");
                System.out.println((index++) + " " + facility.getKey() + " Số lần thuê: " + facility.getValue());
            }
        }
        index = 0;
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (facility.getKey() instanceof House) {
                System.out.println("Danh sách House là: ");
                System.out.println((index++) + " " + facility.getKey() + " Số lần thuê: " + facility.getValue());
            }
        }
        index = 0;
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (facility.getKey() instanceof Room) {
                System.out.println("Danh sách Room là: ");
                System.out.println((index++) + " " + facility.getKey() + " Số lần thuê: " + facility.getValue());
            }
        }


    }

    @Override
    public void maintenanceDisplay() {

    }

    @Override
    public void addVilla() {
        String tenDichVu = inPutName();

        double dienTichSuDung = Double.parseDouble(inPutArea());

        double chiPhiThue = Double.parseDouble(inPutTotalPay());

        int soLuongNguoiToiDa = Integer.parseInt(inPutAmount());

        String kieuThue = inPutRentalType();

        String maDichVu = inPutIdVL();

        String tieuChuanPhong = inPutStandard();

        double dienTichHoBoi = Double.parseDouble(inPutArea());

        int soTang = Integer.parseInt(inPutFloors());
        Villa villa = new Villa(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, maDichVu, tieuChuanPhong, dienTichHoBoi, soTang);
        facilityIntegerMap.put(villa, 0);
        villaList.add(villa);
        ReadAndWrite.writeVillaListFromCSV(villaList, false);

    }

    private String inPutIdVL() {
        System.out.println("Nhập mã dịch vụ: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_ID_VILLA, "Bạn đã nhập sai định dạng, mã dịch vụ  phải có địng dạng là SVVl-XXXX");
    }

    private String inPutIdHO() {
        System.out.println("Nhập mã dịch vụ: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_ID_HOUSE, "Bạn đã nhập sai định dạng, mã dịch vụ  phải có địng dạng là SVVl-XXXX");
    }

    private String inPutIdRO() {
        System.out.println("Nhập mã dịch vụ: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_ID_ROOM, "Bạn đã nhập sai định dạng, mã dịch vụ  phải có địng dạng là SVVl-XXXX");
    }

    private String inPutName() {
        System.out.println("Nhập tên dịch vụ: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tên dịch vụ phải bắt đầu bằng chữ in hoa.");
    }

    private String inPutArea() {
        System.out.println("Nhập diện tích: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai định dạng, phải là số thực và lớn hơn 30 mét vuông.");
    }

    private String inPutTotalPay() {
        System.out.println("Nhập chi phí thuê: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_DOU, "Bạn đã nhập sai định dạng, chi phí thuê phải là số dương.");
    }

    private String inPutAmount() {
        System.out.println("Nhập số lượng người tối đa: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_AMOUNT, "Bạn đã nhập sai định dạng, số lượng người tối đa phải >0 và nhỏ hơn <20.");
    }

    private String inPutRentalType() {
        System.out.println("Nhập kiểu thuê: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu thuê phải bắt đầu bằng chữ in hoa.");
    }

    private String inPutStandard() {
        System.out.println("Nhập tiêu chuẩn phòng: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu thuê phải bắt đầu bằng chữ in hoa..");
    }

    private String inPutFloors() {
        System.out.println("Nhập số tầng: ");
        return RegexDaTa.regexStr(scanner.nextLine(), REGEX_DOU, "Bạn đã nhập sai định dạng, số tầng phải là số dương.");
    }


    @Override
    public void addHouse() {
        String tenDichVu = inPutName();

        double dienTichSuDung = Double.parseDouble(inPutArea());

        double chiPhiThue = Double.parseDouble(inPutTotalPay());

        int soLuongNguoiToiDa = Integer.parseInt(inPutAmount());

        String kieuThue = inPutRentalType();

        String maDichVu = inPutIdHO();

        String tieuChuanPhong = inPutStandard();

        int soTang = Integer.parseInt(inPutFloors());
        House house = new House(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, maDichVu, tieuChuanPhong, soTang);
        facilityIntegerMap.put(house, 0);
        houseList.add(house);
        ReadAndWrite.writeHouserListFromCSV(houseList, false);
    }

    @Override
    public void addRoom() {
        String tenDichVu = inPutName();

        double dienTichSuDung = Double.parseDouble(inPutArea());

        double chiPhiThue = Double.parseDouble(inPutTotalPay());

        int soLuongNguoiToiDa = Integer.parseInt(inPutAmount());

        String kieuThue = inPutRentalType();

        String maDichVu = inPutIdRO();

        System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
        String dichVuMienPhiDiKem = scanner.nextLine();
        Room room = new Room(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, maDichVu, dichVuMienPhiDiKem);
        facilityIntegerMap.put(room, 0);
        roomList.add(room);
        ReadAndWrite.writeRoomListFromCSV(roomList, false);
    }
}

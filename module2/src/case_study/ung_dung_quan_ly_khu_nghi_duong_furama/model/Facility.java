package case_study.ung_dung_quan_ly_khu_nghi_duong_furama.model;

public abstract class Facility {
    private String tenDichVu;

    private double dienTichSuDung;

    private double chiPhiThue;

    private int soLuongNguoiToiDa;

    private String kieuThue;

    private String maDichVu;

    protected final String COMMA = ",";

    public Facility() {
    }

    public Facility(String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String maDichVu) {
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoLuongNguoiToiDa() {
        return soLuongNguoiToiDa;
    }

    public void setSoLuongNguoiToiDa(int soLuongNguoiToiDa) {
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }


    @Override
    public String toString() {
        return
                "tenDichVu='" + tenDichVu + '\'' +
                        ", dienTichSuDung=" + dienTichSuDung +
                        ", chiPhiThue=" + chiPhiThue +
                        ", soLuongNguoiToiDa=" + soLuongNguoiToiDa +
                        ", kieuThue='" + kieuThue +
                        ", madichvu='" + maDichVu + '\'';
    }

    public String getInfoToCSV() {
        return this.getTenDichVu() + COMMA +
                this.getTenDichVu() + COMMA +
                this.getDienTichSuDung() + COMMA +
                this.getChiPhiThue() + COMMA +
                this.getSoLuongNguoiToiDa() + COMMA +
                this.getKieuThue() + COMMA +
                this.getMaDichVu();
    }
}

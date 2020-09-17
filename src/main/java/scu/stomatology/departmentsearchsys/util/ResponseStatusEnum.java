package scu.stomatology.departmentsearchsys.util;

public enum ResponseStatusEnum {

    OK(10000, "成功"),

    FAILED(10001, "失败"),

    ;

    private int code;
    private String msg;

    private ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

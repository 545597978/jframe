/**
 * 
 */
package jframe.pay.domain;

/**
 * 银联订单状态
 * 
 * @author dzh
 * @date Jul 22, 2014 10:59:38 AM
 * @since 1.0
 */
public enum PayStatus {

    /************************** 消费 **********************************/
    C_PAY_WAIT("01", "订单等待支付"), C_PAY_SUC("00", "支付成功"), C_PAY_FAIL("03",
            "支付失败"), C_PAY_TIMEOUT("04", "支付超時"), C_PAY_PROC("05", "消费支付中"),
    /************************** 消费撤销 *********************************/
    C_CANCEL_WAIT("11", "撤銷等待"), C_CANCEL_SUC("10", "撤销成功"), C_CANCEL_FAIL(
            "13", "撤销失败"), C_CANCEL_PROC("15", "撤销处理中"),
    /*************************** 预授权 *********************************/
    A_PAY_WAIT("21", "预授权等待支付"), A_PAY_SUC("20", "支付成功"), A_PAY_FAIL("23",
            "支付失败"), A_PAY_TIMEOUT("24", "支付超时"), A_PAY_PROC("25", "预授权支付中"),
    /*************************** 预授权完成 ********************************/
    A_FNH_WAIT("31", "预授权完成等待"), A_FNH_SUC("30", "预授权完成成功"), A_FNH_FAIL("33",
            "预授权完成失败"), A_FNH_PROC("35", "预授权完成处理中"),
    /*************************** 預授權撤銷 *****************************************/
    A_CANCEL_WAIT("41", "预授权撤销等待"), A_CANCEL_SUC("40", "预授权撤销成功"), A_CANCEL_FAIL(
            "43", "预授权失败"), A_CANCEL_PROC("45", "预授权撤销处理中"), A_PAY_CANCEL_AUTO(
            "46", "预授权自动撤销"),
    /**************************** 预授权完成撤销 *****************************************/
    A_FNH_CANCEL_WAIT("51", "预授权完成撤销等待"), A_FNH_CANCEL_SUC("50", "预授权完成撤销成功"), A_FNH_CANCEL_FAIL(
            "53", "预授权完成撤销失败"), A_FNH_CANCEL_PROC("55", "预授权完成撤销处理中"),
    /**************************** 退货 *****************************************/
    R_WAIT("61", "退货等待"), R_SUC("62", "退货成功"), R_FAIL("63", "退货失败"), R_PROC(
            "64", "退货处理中"),
    /**************************** 余额付款 *****************************************/
    D_SUC("70", "余额付款成功"), D_FAIL("73", "余额付款失败"),
    /**************************** 余额付款撤销 *****************************************/
    D_CANCEL_SUC("80", "余额付款撤销成功"), D_CANCEL_FAIL("83", "余额付款撤销失败"),

    ;

    public final String code;
    public final String desc;

    PayStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static boolean isSucc(String code) {
        if (code == null || code.length() != 2)
            return false;
        return code.charAt(1) == '0' ? true : false;
    }

    public static boolean isFail(String code) {
        if (code == null || code.length() != 2)
            return true;
        return code.charAt(1) == '3' ? true : false;
    }
}

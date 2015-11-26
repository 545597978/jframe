/**
 * 
 */
package jframe.pay.http.ord;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

import io.netty.util.CharsetUtil;
import jframe.pay.domain.http.ReqOp;
import jframe.pay.domain.http.RspCode;
import jframe.pay.domain.util.HttpUtil;
import jframe.pay.domain.util.XmlUtil;
import jframe.pay.http.handler.PayException;
import jframe.pay.http.handler.PayHandler;

/**
 * @author dzh
 * @date Sep 1, 2015 7:31:17 PM
 * @since 1.0
 */
public class OrderHandler extends PayHandler {

    static final OrderService svc = new OrderService();

    /*
     * (non-Javadoc)
     * 
     * @see jframe.pay.http.handler.PayHandler#doService(java.util.Map,
     * java.util.Map)
     */
    @Override
    protected void doService(Map<String, String> req, Map<String, Object> rsp) throws Exception {
        String reqOp = getReqOp();
        if (ReqOp.CONSUME.code.equals(reqOp)) {
            svc.consume(req, rsp);
        } else if (ReqOp.QRYOD.code.equals(reqOp)) {
            svc.qryod(req, rsp);
        } else if (ReqOp.ALIBACK.code.equals(reqOp)) {
            svc.aliback(req, rsp);
        } else if (ReqOp.WXBACK.code.equals(reqOp)) {
            // getPara().forEach((k, v) -> {
            // if (!v.isEmpty()) {
            // req.put(k, v.get(0));
            // }
            // });
            svc.wxback(req, rsp);
        } else if (ReqOp.UPMPBACK.code.equals(reqOp)) {
            svc.upmpback(req, rsp);
        } else {
            RspCode.setRspCode(rsp, RspCode.FAIL_HTTP_REQOP);
            throw new PayException("Not found");
        }
    }

    @Override
    protected Map<String, String> parseHttpReq(String content) throws Exception {
        // if (content.indexOf('=') != -1) {
        // return parseHttpParas(content);
        // }
        // return JsonUtil.decode(content);
        Map<String, String> req = null;
        if (ReqOp.WXBACK.code.equals(getReqOp())) {
            req = XmlUtil.fromXml(content.trim());
        } else {
            req = HttpUtil.parseHttpParas(content.trim());
        }

        req.put("reqUrl", getReqUrl());
        return req;
    }

    @Override
    protected String parseReqContent(String content) throws UnsupportedEncodingException {
        return ReqOp.UPMPBACK.code.equals(getReqOp()) ? content : super.parseReqContent(content);
    }

    @Override
    protected Charset getReqCharset() {
        return ReqOp.UPMPBACK.code.equals(getReqOp()) ? CharsetUtil.ISO_8859_1 : super.getReqCharset();
    }

    // private Map<String, String> fromParameters() {
    // Map<String, String> map = new HashMap<>();
    // getPara().forEach((k, v) -> {
    // if (v != null && v.size() > 0)
    // map.put(k, v.get(0));
    // });
    // return map;
    // }

}

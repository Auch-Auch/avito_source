package com.google.zxing.client.result;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.regex.Pattern;
public final class EmailAddressResultParser extends ResultParser {
    public static final Pattern e = Pattern.compile(",");

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str3;
        String massagedText = ResultParser.getMassagedText(result);
        String[] strArr4 = null;
        if (massagedText.startsWith("mailto:") || massagedText.startsWith("MAILTO:")) {
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String decode = URLDecoder.decode(substring, "UTF-8");
                String[] split = !decode.isEmpty() ? e.split(decode) : null;
                Map<String, String> c = ResultParser.c(massagedText);
                if (c != null) {
                    if (split == null && (str3 = c.get("to")) != null) {
                        split = e.split(str3);
                    }
                    String str4 = c.get("cc");
                    String[] split2 = str4 != null ? e.split(str4) : null;
                    String str5 = c.get("bcc");
                    if (str5 != null) {
                        strArr4 = e.split(str5);
                    }
                    str = c.get(SDKConstants.PARAM_A2U_BODY);
                    strArr3 = split;
                    strArr2 = split2;
                    strArr = strArr4;
                    str2 = c.get("subject");
                } else {
                    strArr3 = split;
                    strArr2 = null;
                    strArr = null;
                    str2 = null;
                    str = null;
                }
                return new EmailAddressParsedResult(strArr3, strArr2, strArr, str2, str);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException(e2);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } else if (!EmailDoCoMoResultParser.d(massagedText)) {
            return null;
        } else {
            return new EmailAddressParsedResult(new String[]{massagedText}, null, null, null, null);
        }
    }
}

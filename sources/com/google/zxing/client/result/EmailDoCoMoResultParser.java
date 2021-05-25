package com.google.zxing.client.result;

import a2.j.k.b.a.a;
import com.google.zxing.Result;
import java.util.regex.Pattern;
public final class EmailDoCoMoResultParser extends a {
    public static final Pattern e = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean d(String str) {
        return str != null && e.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] a;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MATMSG:") || (a = ResultParser.a("TO:", massagedText, ';', true)) == null) {
            return null;
        }
        for (String str : a) {
            if (!d(str)) {
                return null;
            }
        }
        return new EmailAddressParsedResult(a, null, null, ResultParser.b("SUB:", massagedText, ';', false), ResultParser.b("BODY:", massagedText, ';', false));
    }
}

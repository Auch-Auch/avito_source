package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
public final class AddressBookAUResultParser extends ResultParser {
    public static String[] d(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b = ResultParser.b(str + i2 + ':', str2, '\r', z);
            if (b == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(b);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        String[] strArr = null;
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        String b = ResultParser.b("NAME1:", massagedText, '\r', true);
        String b2 = ResultParser.b("NAME2:", massagedText, '\r', true);
        String[] d = d("TEL", 3, massagedText, true);
        String[] d2 = d("MAIL", 3, massagedText, true);
        String b3 = ResultParser.b("MEMORY:", massagedText, '\r', false);
        String b4 = ResultParser.b("ADD:", massagedText, '\r', true);
        if (b4 != null) {
            strArr = new String[]{b4};
        }
        return new AddressBookParsedResult(ResultParser.maybeWrap(b), null, b2, d, null, d2, null, null, b3, strArr, null, null, null, null, null, null);
    }
}

package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.stats.CodePackage;
import com.google.zxing.Result;
import java.util.List;
public final class VEventResultParser extends ResultParser {
    public static String d(CharSequence charSequence, String str, boolean z) {
        List<String> d = VCardResultParser.d(charSequence, str, z, false);
        if (d == null || d.isEmpty()) {
            return null;
        }
        return d.get(0);
    }

    public static String e(String str) {
        if (str != null) {
            return (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public CalendarParsedResult parse(Result result) {
        String[] strArr;
        double d;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String d2 = d("SUMMARY", massagedText, true);
        String d3 = d("DTSTART", massagedText, true);
        if (d3 == null) {
            return null;
        }
        String d4 = d("DTEND", massagedText, true);
        String d5 = d("DURATION", massagedText, true);
        String d6 = d(CodePackage.LOCATION, massagedText, true);
        String e = e(d("ORGANIZER", massagedText, true));
        List<List<String>> e2 = VCardResultParser.e("ATTENDEE", massagedText, true, false);
        if (e2 == null || e2.isEmpty()) {
            strArr = null;
        } else {
            int size = e2.size();
            String[] strArr2 = new String[size];
            for (int i = 0; i < size; i++) {
                strArr2[i] = e2.get(i).get(0);
            }
            strArr = strArr2;
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = e(strArr[i2]);
            }
        }
        String d7 = d(ShareConstants.DESCRIPTION, massagedText, true);
        String d8 = d("GEO", massagedText, true);
        double d9 = Double.NaN;
        if (d8 == null) {
            d = Double.NaN;
        } else {
            int indexOf = d8.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d9 = Double.parseDouble(d8.substring(0, indexOf));
                d = Double.parseDouble(d8.substring(indexOf + 1));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return new CalendarParsedResult(d2, d3, d4, d5, d6, e, strArr, d7, d9, d);
    }
}

package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class VCardResultParser extends ResultParser {
    public static final Pattern e = Pattern.compile("BEGIN:VCARD", 2);
    public static final Pattern f = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    public static final Pattern g = Pattern.compile("\r\n[ \t]");
    public static final Pattern h = Pattern.compile("\\\\[nN]");
    public static final Pattern i = Pattern.compile("\\\\([,;\\\\])");
    public static final Pattern j = Pattern.compile("=");
    public static final Pattern k = Pattern.compile(";");
    public static final Pattern l = Pattern.compile("(?<!\\\\);+");
    public static final Pattern m = Pattern.compile(",");
    public static final Pattern n = Pattern.compile("[;,]");

    public static List<String> d(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> e2 = e(charSequence, str, z, z2);
        if (e2 == null || e2.isEmpty()) {
            return null;
        }
        return e2.get(0);
    }

    public static List<List<String>> e(CharSequence charSequence, String str, boolean z, boolean z2) {
        String str2;
        String str3;
        boolean z3;
        ArrayList arrayList;
        char c;
        int indexOf;
        String str4;
        char charAt;
        String str5 = str;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList2 = null;
        while (i3 < length) {
            int i4 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str5);
            if (i3 > 0) {
                i3--;
            }
            if (!matcher.find(i3)) {
                break;
            }
            int end = matcher.end(i2);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = k.split(group);
                int length2 = split.length;
                int i5 = 0;
                arrayList = null;
                z3 = false;
                str3 = null;
                str2 = null;
                while (i5 < length2) {
                    String str6 = split[i5];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str6);
                    String[] split2 = j.split(str6, i4);
                    if (split2.length > 1) {
                        String str7 = split2[0];
                        String str8 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str7) && "QUOTED-PRINTABLE".equalsIgnoreCase(str8)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str7)) {
                            str3 = str8;
                        } else if ("VALUE".equalsIgnoreCase(str7)) {
                            str2 = str8;
                        }
                    }
                    i5++;
                    i4 = 2;
                }
            } else {
                arrayList = null;
                z3 = false;
                str3 = null;
                str2 = null;
            }
            int i6 = end;
            while (true) {
                c = '\n';
                indexOf = str5.indexOf(10, i6);
                if (indexOf < 0) {
                    break;
                }
                if (indexOf < str.length() - 1) {
                    int i7 = indexOf + 1;
                    if (str5.charAt(i7) == ' ' || str5.charAt(i7) == '\t') {
                        i6 = indexOf + 2;
                    }
                }
                if (!z3) {
                    break;
                }
                if (indexOf <= 0 || str5.charAt(indexOf - 1) != '=') {
                    if (indexOf >= 2) {
                        if (str5.charAt(indexOf - 2) != '=') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6 = indexOf + 1;
            }
            if (indexOf < 0) {
                i3 = length;
                i2 = 0;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str5.charAt(indexOf - 1) == '\r') {
                        indexOf--;
                    }
                    String substring = str5.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (z3) {
                        int length3 = substring.length();
                        StringBuilder sb = new StringBuilder(length3);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i8 = 0;
                        while (i8 < length3) {
                            char charAt2 = substring.charAt(i8);
                            if (!(charAt2 == c || charAt2 == '\r')) {
                                if (charAt2 != '=') {
                                    g(byteArrayOutputStream, str3, sb);
                                    sb.append(charAt2);
                                } else if (i8 < length3 - 2 && (charAt = substring.charAt(i8 + 1)) != '\r') {
                                    c = '\n';
                                    if (charAt != '\n') {
                                        i8 += 2;
                                        char charAt3 = substring.charAt(i8);
                                        int parseHexDigit = ResultParser.parseHexDigit(charAt);
                                        int parseHexDigit2 = ResultParser.parseHexDigit(charAt3);
                                        if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                                            byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                                        }
                                    }
                                }
                                c = '\n';
                            }
                            i8++;
                        }
                        g(byteArrayOutputStream, str3, sb);
                        str4 = sb.toString();
                        if (z2) {
                            str4 = l.matcher(str4).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            substring = l.matcher(substring).replaceAll("\n").trim();
                        }
                        str4 = i.matcher(h.matcher(g.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (ShareConstants.MEDIA_URI.equals(str2)) {
                        try {
                            str4 = URI.create(str4).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(str4);
                        arrayList2.add(arrayList3);
                    } else {
                        i2 = 0;
                        arrayList.add(0, str4);
                        arrayList2.add(arrayList);
                        i3 = indexOf + 1;
                        str5 = str;
                    }
                }
                i2 = 0;
                i3 = indexOf + 1;
                str5 = str;
            }
        }
        return arrayList2;
    }

    public static void f(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] != null && !strArr[i2].isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(strArr[i2]);
        }
    }

    public static void g(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    public static String h(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String[] i(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] j(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str2 = list.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        str = null;
                        break;
                    }
                    str = list.get(i2);
                    int indexOf = str.indexOf(61);
                    if (indexOf < 0) {
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    } else {
                        i2++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe  */
    @Override // com.google.zxing.client.result.ResultParser
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.AddressBookParsedResult parse(com.google.zxing.Result r25) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.VCardResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.AddressBookParsedResult");
    }
}

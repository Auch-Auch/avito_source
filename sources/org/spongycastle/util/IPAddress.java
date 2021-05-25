package org.spongycastle.util;

import a2.b.a.a.a;
public class IPAddress {
    public static boolean isValid(String str) {
        return isValidIPv4(str) || isValidIPv6(str);
    }

    public static boolean isValidIPv4(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String c3 = a.c3(str, ".");
        int i = 0;
        int i2 = 0;
        while (i < c3.length() && (indexOf = c3.indexOf(46, i)) > i) {
            if (i2 == 4) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(c3.substring(i, indexOf));
                if (parseInt >= 0 && parseInt <= 255) {
                    i = indexOf + 1;
                    i2++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        if (i2 == 4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isValidIPv4WithNetmask(java.lang.String r4) {
        /*
            java.lang.String r0 = "/"
            int r0 = r4.indexOf(r0)
            int r1 = r0 + 1
            java.lang.String r1 = r4.substring(r1)
            r2 = 0
            r3 = 1
            if (r0 <= 0) goto L_0x0030
            java.lang.String r4 = r4.substring(r2, r0)
            boolean r4 = isValidIPv4(r4)
            if (r4 == 0) goto L_0x0030
            boolean r4 = isValidIPv4(r1)
            if (r4 != 0) goto L_0x002f
            r4 = 32
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x002c }
            if (r0 < 0) goto L_0x002c
            if (r0 > r4) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0030
        L_0x002f:
            r2 = 1
        L_0x0030:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.IPAddress.isValidIPv4WithNetmask(java.lang.String):boolean");
    }

    public static boolean isValidIPv6(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        String c3 = a.c3(str, ":");
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < c3.length() && (indexOf = c3.indexOf(58, i)) >= i) {
            if (i2 == 8) {
                return false;
            }
            if (i != indexOf) {
                String substring = c3.substring(i, indexOf);
                if (indexOf != c3.length() - 1 || substring.indexOf(46) <= 0) {
                    try {
                        int parseInt = Integer.parseInt(c3.substring(i, indexOf), 16);
                        if (parseInt >= 0 && parseInt <= 65535) {
                        }
                    } catch (NumberFormatException unused) {
                    }
                    return false;
                } else if (!isValidIPv4(substring)) {
                    return false;
                } else {
                    i2++;
                }
            } else if (indexOf != 1 && indexOf != c3.length() - 1 && z) {
                return false;
            } else {
                z = true;
            }
            i = indexOf + 1;
            i2++;
        }
        if (i2 == 8 || z) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isValidIPv6WithNetmask(java.lang.String r4) {
        /*
            java.lang.String r0 = "/"
            int r0 = r4.indexOf(r0)
            int r1 = r0 + 1
            java.lang.String r1 = r4.substring(r1)
            r2 = 0
            r3 = 1
            if (r0 <= 0) goto L_0x0030
            java.lang.String r4 = r4.substring(r2, r0)
            boolean r4 = isValidIPv6(r4)
            if (r4 == 0) goto L_0x0030
            boolean r4 = isValidIPv6(r1)
            if (r4 != 0) goto L_0x002f
            r4 = 128(0x80, float:1.794E-43)
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x002c }
            if (r0 < 0) goto L_0x002c
            if (r0 > r4) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0030
        L_0x002f:
            r2 = 1
        L_0x0030:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.IPAddress.isValidIPv6WithNetmask(java.lang.String):boolean");
    }

    public static boolean isValidWithNetMask(String str) {
        return isValidIPv4WithNetmask(str) || isValidIPv6WithNetmask(str);
    }
}

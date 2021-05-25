package com.google.zxing.client.result;

import java.util.regex.Pattern;
public final class URIParsedResult extends ParsedResult {
    public static final Pattern d = Pattern.compile(":/*([^/@]+)@[^/]+");
    public final String b;
    public final String c;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (com.google.zxing.client.result.ResultParser.isSubstringOfDigits(r3, r0, (r1 < 0 ? r3.length() : r1) - r0) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public URIParsedResult(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            com.google.zxing.client.result.ParsedResultType r0 = com.google.zxing.client.result.ParsedResultType.URI
            r2.<init>(r0)
            java.lang.String r3 = r3.trim()
            r0 = 58
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L_0x0026
            int r0 = r0 + 1
            r1 = 47
            int r1 = r3.indexOf(r1, r0)
            if (r1 >= 0) goto L_0x001f
            int r1 = r3.length()
        L_0x001f:
            int r1 = r1 - r0
            boolean r0 = com.google.zxing.client.result.ResultParser.isSubstringOfDigits(r3, r0, r1)
            if (r0 == 0) goto L_0x002c
        L_0x0026:
            java.lang.String r0 = "http://"
            java.lang.String r3 = r0.concat(r3)
        L_0x002c:
            r2.b = r3
            r2.c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.URIParsedResult.<init>(java.lang.String, java.lang.String):void");
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.maybeAppend(this.c, sb);
        ParsedResult.maybeAppend(this.b, sb);
        return sb.toString();
    }

    public String getTitle() {
        return this.c;
    }

    public String getURI() {
        return this.b;
    }

    public boolean isPossiblyMaliciousURI() {
        return d.matcher(this.b).find();
    }
}

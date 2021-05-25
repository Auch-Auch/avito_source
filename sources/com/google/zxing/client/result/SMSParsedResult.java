package com.google.zxing.client.result;

import a2.b.a.a.a;
import kotlin.text.Typography;
public final class SMSParsedResult extends ParsedResult {
    public final String[] b;
    public final String[] c;
    public final String d;
    public final String e;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.b = new String[]{str};
        this.c = new String[]{str2};
        this.d = str3;
        this.e = str4;
    }

    public String getBody() {
        return this.e;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.b, sb);
        ParsedResult.maybeAppend(this.d, sb);
        ParsedResult.maybeAppend(this.e, sb);
        return sb.toString();
    }

    public String[] getNumbers() {
        return this.b;
    }

    public String getSMSURI() {
        StringBuilder L = a.L("sms:");
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.b.length; i++) {
            if (z2) {
                z2 = false;
            } else {
                L.append(',');
            }
            L.append(this.b[i]);
            String[] strArr = this.c;
            if (!(strArr == null || strArr[i] == null)) {
                L.append(";via=");
                L.append(this.c[i]);
            }
        }
        boolean z3 = this.e != null;
        if (this.d != null) {
            z = true;
        }
        if (z3 || z) {
            L.append('?');
            if (z3) {
                L.append("body=");
                L.append(this.e);
            }
            if (z) {
                if (z3) {
                    L.append(Typography.amp);
                }
                L.append("subject=");
                L.append(this.d);
            }
        }
        return L.toString();
    }

    public String getSubject() {
        return this.d;
    }

    public String[] getVias() {
        return this.c;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.b = strArr;
        this.c = strArr2;
        this.d = str;
        this.e = str2;
    }
}

package org.junit;

import a2.b.a.a.a;
public class ComparisonFailure extends AssertionError {
    private static final long serialVersionUID = 1;
    public String a;
    public String b;

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public String getActual() {
        return this.b;
    }

    public String getExpected() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String substring;
        String str;
        String str2;
        String str3 = this.a;
        String str4 = this.b;
        String message = super.getMessage();
        if (str3 == null || str4 == null || str3.equals(str4)) {
            return Assert.g(message, str3, str4);
        }
        int min = Math.min(str3.length(), str4.length());
        int i = 0;
        while (true) {
            if (i >= min) {
                substring = str3.substring(0, min);
                break;
            } else if (str3.charAt(i) != str4.charAt(i)) {
                substring = str3.substring(0, i);
                break;
            } else {
                i++;
            }
        }
        int min2 = Math.min(str3.length() - substring.length(), str4.length() - substring.length()) - 1;
        int i2 = 0;
        while (i2 <= min2 && str3.charAt((str3.length() - 1) - i2) == str4.charAt((str4.length() - 1) - i2)) {
            i2++;
        }
        String substring2 = str3.substring(str3.length() - i2);
        if (substring.length() <= 20) {
            str = substring;
        } else {
            StringBuilder L = a.L("...");
            L.append(substring.substring(substring.length() - 20));
            str = L.toString();
        }
        if (substring2.length() <= 20) {
            str2 = substring2;
        } else {
            str2 = substring2.substring(0, 20) + "...";
        }
        StringBuilder L2 = a.L(str);
        StringBuilder L3 = a.L("[");
        L3.append(str3.substring(substring.length(), str3.length() - substring2.length()));
        L3.append("]");
        String t = a.t(L2, L3.toString(), str2);
        StringBuilder L4 = a.L(str);
        StringBuilder L5 = a.L("[");
        L5.append(str4.substring(substring.length(), str4.length() - substring2.length()));
        L5.append("]");
        L4.append(L5.toString());
        L4.append(str2);
        return Assert.g(message, t, L4.toString());
    }
}

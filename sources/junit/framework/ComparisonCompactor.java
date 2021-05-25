package junit.framework;

import a2.b.a.a.a;
public class ComparisonCompactor {
    public int a;
    public String b;
    public String c;
    public int d;
    public int e;

    public ComparisonCompactor(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final String a(String str) {
        String str2;
        StringBuilder L = a.L("[");
        L.append(str.substring(this.d, (str.length() - this.e) + 1));
        L.append("]");
        String sb = L.toString();
        String str3 = "...";
        if (this.d > 0) {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            if (this.d > this.a) {
                str2 = str3;
            } else {
                str2 = "";
            }
            sb3.append(str2);
            sb3.append(this.b.substring(Math.max(0, this.d - this.a), this.d));
            sb2.append(sb3.toString());
            sb2.append(sb);
            sb = sb2.toString();
        }
        if (this.e <= 0) {
            return sb;
        }
        StringBuilder L2 = a.L(sb);
        int min = Math.min((this.b.length() - this.e) + 1 + this.a, this.b.length());
        StringBuilder sb4 = new StringBuilder();
        String str4 = this.b;
        sb4.append(str4.substring((str4.length() - this.e) + 1, min));
        if ((this.b.length() - this.e) + 1 >= this.b.length() - this.a) {
            str3 = "";
        }
        sb4.append(str3);
        L2.append(sb4.toString());
        return L2.toString();
    }

    public String compact(String str) {
        String str2;
        String str3 = this.b;
        if (str3 == null || (str2 = this.c) == null || str3.equals(str2)) {
            return Assert.format(str, this.b, this.c);
        }
        this.d = 0;
        int min = Math.min(this.b.length(), this.c.length());
        while (true) {
            int i = this.d;
            if (i >= min || this.b.charAt(i) != this.c.charAt(this.d)) {
                break;
            }
            this.d++;
        }
        int length = this.b.length() - 1;
        int length2 = this.c.length() - 1;
        while (true) {
            int i2 = this.d;
            if (length2 < i2 || length < i2 || this.b.charAt(length) != this.c.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.e = this.b.length() - length;
        return Assert.format(str, a(this.b), a(this.c));
    }
}

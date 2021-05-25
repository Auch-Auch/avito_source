package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.Locale;
import java.util.regex.Pattern;
public final class as implements Comparable<as> {
    private static final Pattern a = Pattern.compile("^[\\d]*(\\.[\\d]*)*(\\-.*)?");
    private final String b;
    private int[] c;
    private String d;
    private Integer e;
    private boolean f = true;

    public as(String str) {
        this.b = str.toLowerCase(Locale.US);
        a();
    }

    private int a(int i) {
        int[] iArr = this.c;
        if (i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    /* renamed from: a */
    public final int compareTo(@NonNull as asVar) {
        boolean z = this.f;
        int i = -1;
        if (z && asVar.f) {
            int max = Math.max(this.c.length, asVar.c.length);
            int i2 = 0;
            while (true) {
                if (i2 >= max) {
                    i = 0;
                    break;
                }
                int a3 = a(i2);
                int a4 = asVar.a(i2);
                if (a3 > a4) {
                    i = 1;
                    break;
                } else if (a3 < a4) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i != 0) {
                return i;
            }
            if (!this.e.equals(asVar.e)) {
                return this.e.compareTo(asVar.e);
            }
            if (this.e.equals(2)) {
                return 0;
            }
            return a(this.d, asVar.d);
        } else if (z) {
            return 1;
        } else {
            if (asVar.f) {
                return -1;
            }
            return a(this.b, asVar.b);
        }
    }

    private static int a(String str, String str2) {
        int compareTo = str.compareTo(str2);
        if (compareTo < 0) {
            return -1;
        }
        return compareTo > 0 ? 1 : 0;
    }

    private void a() {
        String[] split = this.b.split("-");
        int i = 0;
        if (!a.matcher(this.b).matches()) {
            this.f = false;
        }
        String[] split2 = split[0].split("\\.");
        if (this.f) {
            this.c = new int[split2.length];
            while (true) {
                int[] iArr = this.c;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = Integer.parseInt(split2[i]);
                i++;
            }
            int indexOf = this.b.indexOf(45);
            if (indexOf < 0 || indexOf >= this.b.length() - 1) {
                this.e = 2;
                return;
            }
            String substring = this.b.substring(indexOf);
            this.d = substring;
            this.e = Integer.valueOf(!substring.endsWith("-snapshot"));
        }
    }
}

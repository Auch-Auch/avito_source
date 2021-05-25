package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class bm {
    public final int a;
    @NonNull
    public final String b;

    public bm() {
        this.a = -1;
        this.b = "none";
    }

    public bm(@NonNull String str, int i) {
        this.b = str;
        this.a = i;
    }

    public static bm aQ() {
        return new bm();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static bm o(@NonNull String str) {
        char c;
        str.hashCode();
        int i = 1;
        switch (str.hashCode()) {
            case 3387192:
                if (str.equals("none")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 729267099:
                if (str.equals("portrait")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1430647483:
                if (str.equals("landscape")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i = -1;
                break;
            case 1:
                break;
            case 2:
                i = 0;
                break;
            default:
                return null;
        }
        return new bm(str, i);
    }

    public int aR() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }
}

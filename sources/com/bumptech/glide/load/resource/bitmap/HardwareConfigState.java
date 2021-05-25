package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
public final class HardwareConfigState {
    public static final File f = new File("/proc/self/fd");
    public static volatile HardwareConfigState g;
    public final boolean a;
    public final int b;
    public final int c;
    @GuardedBy("this")
    public int d;
    @GuardedBy("this")
    public boolean e = true;

    @VisibleForTesting
    public HardwareConfigState() {
        boolean z = true;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String substring = str.substring(0, 7);
            substring.hashCode();
            char c2 = 65535;
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (Build.VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        this.a = z;
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = 0;
            return;
        }
        this.b = 700;
        this.c = 128;
    }

    public static HardwareConfigState getInstance() {
        if (g == null) {
            synchronized (HardwareConfigState.class) {
                if (g == null) {
                    g = new HardwareConfigState();
                }
            }
        }
        return g;
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        int i3;
        boolean z3;
        if (!z || !this.a || Build.VERSION.SDK_INT < 26 || z2 || i < (i3 = this.c) || i2 < i3) {
            return false;
        }
        synchronized (this) {
            int i4 = this.d + 1;
            this.d = i4;
            if (i4 >= 50) {
                this.d = 0;
                boolean z4 = f.list().length < this.b;
                this.e = z4;
                if (!z4) {
                    Log.isLoggable("Downsampler", 5);
                }
            }
            z3 = this.e;
        }
        if (z3) {
            return true;
        }
        return false;
    }
}

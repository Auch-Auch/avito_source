package com.google.android.exoplayer2.util;

import java.util.Arrays;
public final class LibraryLoader {
    public String[] a;
    public boolean b;
    public boolean c;

    public LibraryLoader(String... strArr) {
        this.a = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.b) {
            return this.c;
        }
        this.b = true;
        try {
            for (String str : this.a) {
                System.loadLibrary(str);
            }
            this.c = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.w("LibraryLoader", "Failed to load " + Arrays.toString(this.a));
        }
        return this.c;
    }

    public synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.b, "Cannot set libraries after loading");
        this.a = strArr;
    }
}

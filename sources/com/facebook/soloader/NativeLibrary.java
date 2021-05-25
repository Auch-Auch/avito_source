package com.facebook.soloader;

import java.util.List;
import javax.annotation.Nullable;
public abstract class NativeLibrary {
    public final Object a = new Object();
    @Nullable
    public List<String> b;
    public Boolean c = Boolean.TRUE;
    public boolean d = false;
    @Nullable
    public volatile UnsatisfiedLinkError e = null;

    public NativeLibrary(List<String> list) {
        this.b = list;
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        if (!loadLibraries()) {
            throw this.e;
        }
    }

    @Nullable
    public UnsatisfiedLinkError getError() {
        return this.e;
    }

    public void initialNativeCheck() throws UnsatisfiedLinkError {
    }

    @Nullable
    public boolean loadLibraries() {
        synchronized (this.a) {
            if (!this.c.booleanValue()) {
                return this.d;
            }
            try {
                List<String> list = this.b;
                if (list != null) {
                    for (String str : list) {
                        SoLoader.loadLibrary(str);
                    }
                }
                initialNativeCheck();
                this.d = true;
                this.b = null;
            } catch (UnsatisfiedLinkError e2) {
                this.e = e2;
                this.d = false;
            } catch (Throwable th) {
                this.e = new UnsatisfiedLinkError("Failed loading libraries");
                this.e.initCause(th);
                this.d = false;
            }
            this.c = Boolean.FALSE;
            return this.d;
        }
    }
}

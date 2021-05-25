package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
@Beta
@GwtCompatible
public final class Runnables {
    public static final Runnable a = new a();

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static Runnable doNothing() {
        return a;
    }
}

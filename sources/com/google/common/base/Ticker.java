package com.google.common.base;

import a2.j.d.a.i;
import a2.j.d.a.j;
import com.google.common.annotations.GwtCompatible;
@GwtCompatible
public abstract class Ticker {
    public static final Ticker a = new a();

    public static class a extends Ticker {
        @Override // com.google.common.base.Ticker
        public long read() {
            i iVar = j.a;
            return System.nanoTime();
        }
    }

    public static Ticker systemTicker() {
        return a;
    }

    public abstract long read();
}

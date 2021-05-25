package com.avito.security;

import java.util.NoSuchElementException;
public final class p1 extends m0 {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    public p1(int i, int i2, int i3) {
        this.d = i3;
        this.a = i2;
        boolean z = i3 <= 0 ? i >= i2 : i <= i2;
        this.b = z;
        this.c = !z ? i2 : i;
    }

    @Override // com.avito.security.m0
    public int b() {
        int i = this.c;
        if (i != this.a) {
            this.c = this.d + i;
        } else if (this.b) {
            this.b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }
}

package com.google.common.collect;

import a2.j.d.c.b2;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@GwtCompatible(emulated = true)
public final class MapMaker {
    public boolean a;
    public int b = -1;
    public int c = -1;
    @MonotonicNonNullDecl
    public b2.p d;
    @MonotonicNonNullDecl
    public b2.p e;
    @MonotonicNonNullDecl
    public Equivalence<Object> f;

    public enum a {
        VALUE
    }

    public b2.p a() {
        return (b2.p) MoreObjects.firstNonNull(this.d, b2.p.STRONG);
    }

    public b2.p b() {
        return (b2.p) MoreObjects.firstNonNull(this.e, b2.p.STRONG);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker c(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.a = true;
        return this;
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int i) {
        int i2 = this.c;
        boolean z = true;
        Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.c = i;
        return this;
    }

    public MapMaker d(b2.p pVar) {
        b2.p pVar2 = this.d;
        Preconditions.checkState(pVar2 == null, "Key strength was already set to %s", pVar2);
        this.d = (b2.p) Preconditions.checkNotNull(pVar);
        if (pVar != b2.p.STRONG) {
            this.a = true;
        }
        return this;
    }

    public MapMaker e(b2.p pVar) {
        b2.p pVar2 = this.e;
        Preconditions.checkState(pVar2 == null, "Value strength was already set to %s", pVar2);
        this.e = (b2.p) Preconditions.checkNotNull(pVar);
        if (pVar != b2.p.STRONG) {
            this.a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int i) {
        int i2 = this.b;
        boolean z = true;
        Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.b = i;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.a) {
            int i = this.b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        b2.f0<Object, Object, b2.e> f0Var = b2.j;
        b2.p pVar = b2.p.WEAK;
        b2.p a3 = a();
        b2.p pVar2 = b2.p.STRONG;
        if (a3 == pVar2 && b() == pVar2) {
            return new b2(this, b2.s.a.a);
        }
        if (a() == pVar2 && b() == pVar) {
            return new b2(this, b2.u.a.a);
        }
        if (a() == pVar && b() == pVar2) {
            return new b2(this, b2.a0.a.a);
        }
        if (a() == pVar && b() == pVar) {
            return new b2(this, b2.c0.a.a);
        }
        throw new AssertionError();
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        b2.p pVar = this.d;
        if (pVar != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(pVar.toString()));
        }
        b2.p pVar2 = this.e;
        if (pVar2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(pVar2.toString()));
        }
        if (this.f != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakKeys() {
        d(b2.p.WEAK);
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakValues() {
        e(b2.p.WEAK);
        return this;
    }
}

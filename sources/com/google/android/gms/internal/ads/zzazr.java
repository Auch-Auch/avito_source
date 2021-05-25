package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
public final class zzazr {
    public final int count;
    public final String name;
    private final double zzebr;
    private final double zzebs;
    public final double zzebt;

    public zzazr(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzebs = d;
        this.zzebr = d2;
        this.zzebt = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzazr)) {
            return false;
        }
        zzazr zzazr = (zzazr) obj;
        if (Objects.equal(this.name, zzazr.name) && this.zzebr == zzazr.zzebr && this.zzebs == zzazr.zzebs && this.count == zzazr.count && Double.compare(this.zzebt, zzazr.zzebt) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzebr), Double.valueOf(this.zzebs), Double.valueOf(this.zzebt), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzebs)).add("maxBound", Double.valueOf(this.zzebr)).add("percent", Double.valueOf(this.zzebt)).add("count", Integer.valueOf(this.count)).toString();
    }
}

package com.yandex.runtime.internal.test_support;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class FullLiteTestStructure implements Serializable {
    private long at;
    private boolean b;
    private int be;
    private byte[] by;
    private int c;
    private double d;
    private TestEnum e;
    private float fl;
    private int i;
    private long i64;
    private Long oat;
    private Boolean ob;
    private Integer obe;
    private byte[] oby;
    private Integer oc;
    private Double od;
    private TestEnum oe;
    private Float ofl;
    private Integer oi;
    private Long oi64;
    private PointF op;
    private Long ort;
    private String os;
    private Long oti;
    private Integer oui;
    private PointF p;
    private long rt;
    private String s;
    private long ti;
    private int ui;

    public FullLiteTestStructure(boolean z, @Nullable Boolean bool, int i2, @Nullable Integer num, int i3, @Nullable Integer num2, long j, @Nullable Long l, float f, @Nullable Float f2, double d2, @Nullable Double d3, @NonNull String str, @Nullable String str2, long j2, @Nullable Long l2, long j3, @Nullable Long l3, long j4, @Nullable Long l4, @NonNull byte[] bArr, @Nullable byte[] bArr2, int i4, @Nullable Integer num3, @NonNull PointF pointF, @Nullable PointF pointF2, @NonNull TestEnum testEnum, @Nullable TestEnum testEnum2, int i5, @Nullable Integer num4) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"s\" cannot be null");
        } else if (bArr == null) {
            throw new IllegalArgumentException("Required field \"by\" cannot be null");
        } else if (pointF == null) {
            throw new IllegalArgumentException("Required field \"p\" cannot be null");
        } else if (testEnum != null) {
            this.b = z;
            this.ob = bool;
            this.i = i2;
            this.oi = num;
            this.ui = i3;
            this.oui = num2;
            this.i64 = j;
            this.oi64 = l;
            this.fl = f;
            this.ofl = f2;
            this.d = d2;
            this.od = d3;
            this.s = str;
            this.os = str2;
            this.ti = j2;
            this.oti = l2;
            this.at = j3;
            this.oat = l3;
            this.rt = j4;
            this.ort = l4;
            this.by = bArr;
            this.oby = bArr2;
            this.c = i4;
            this.oc = num3;
            this.p = pointF;
            this.op = pointF2;
            this.e = testEnum;
            this.oe = testEnum2;
            this.be = i5;
            this.obe = num4;
        } else {
            throw new IllegalArgumentException("Required field \"e\" cannot be null");
        }
    }

    public long getAt() {
        return this.at;
    }

    public boolean getB() {
        return this.b;
    }

    public int getBe() {
        return this.be;
    }

    @NonNull
    public byte[] getBy() {
        return this.by;
    }

    public int getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }

    @NonNull
    public TestEnum getE() {
        return this.e;
    }

    public float getFl() {
        return this.fl;
    }

    public int getI() {
        return this.i;
    }

    public long getI64() {
        return this.i64;
    }

    @Nullable
    public Long getOat() {
        return this.oat;
    }

    @Nullable
    public Boolean getOb() {
        return this.ob;
    }

    @Nullable
    public Integer getObe() {
        return this.obe;
    }

    @Nullable
    public byte[] getOby() {
        return this.oby;
    }

    @Nullable
    public Integer getOc() {
        return this.oc;
    }

    @Nullable
    public Double getOd() {
        return this.od;
    }

    @Nullable
    public TestEnum getOe() {
        return this.oe;
    }

    @Nullable
    public Float getOfl() {
        return this.ofl;
    }

    @Nullable
    public Integer getOi() {
        return this.oi;
    }

    @Nullable
    public Long getOi64() {
        return this.oi64;
    }

    @Nullable
    public PointF getOp() {
        return this.op;
    }

    @Nullable
    public Long getOrt() {
        return this.ort;
    }

    @Nullable
    public String getOs() {
        return this.os;
    }

    @Nullable
    public Long getOti() {
        return this.oti;
    }

    @Nullable
    public Integer getOui() {
        return this.oui;
    }

    @NonNull
    public PointF getP() {
        return this.p;
    }

    public long getRt() {
        return this.rt;
    }

    @NonNull
    public String getS() {
        return this.s;
    }

    public long getTi() {
        return this.ti;
    }

    public int getUi() {
        return this.ui;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.b = archive.add(this.b);
        this.ob = archive.add(this.ob, true);
        this.i = archive.add(this.i);
        this.oi = archive.add(this.oi, true);
        this.ui = archive.add(this.ui);
        this.oui = archive.add(this.oui, true);
        this.i64 = archive.add(this.i64);
        this.oi64 = archive.add(this.oi64, true);
        this.fl = archive.add(this.fl);
        this.ofl = archive.add(this.ofl, true);
        this.d = archive.add(this.d);
        this.od = archive.add(this.od, true);
        this.s = archive.add(this.s, false);
        this.os = archive.add(this.os, true);
        this.ti = archive.add(this.ti);
        this.oti = archive.add(this.oti, true);
        this.at = archive.add(this.at);
        this.oat = archive.add(this.oat, true);
        this.rt = archive.add(this.rt);
        this.ort = archive.add(this.ort, true);
        this.by = archive.add(this.by, false);
        this.oby = archive.add(this.oby, true);
        this.c = archive.add(this.c);
        this.oc = archive.add(this.oc, true);
        this.p = archive.add(this.p, false);
        this.op = archive.add(this.op, true);
        this.e = (TestEnum) archive.add((Archive) this.e, false, (Class<Archive>) TestEnum.class);
        this.oe = (TestEnum) archive.add((Archive) this.oe, true, (Class<Archive>) TestEnum.class);
        this.be = archive.add(Integer.valueOf(this.be), false).intValue();
        this.obe = archive.add(this.obe, true);
    }

    public FullLiteTestStructure() {
    }
}

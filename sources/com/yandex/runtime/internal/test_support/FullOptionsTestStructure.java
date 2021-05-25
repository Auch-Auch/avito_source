package com.yandex.runtime.internal.test_support;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public final class FullOptionsTestStructure implements Serializable {
    private Long at;
    private Boolean b;
    private Integer be;
    private byte[] by;
    private Integer c;
    private Double d;
    private TestEnum e;
    private Float fl;
    private Integer i;
    private Long i64;
    private PointF p;
    private Long rt;
    private String s;
    private Long ti;
    private Integer ui;

    public FullOptionsTestStructure(@Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable Float f, @Nullable Double d2, @Nullable String str, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable byte[] bArr, @Nullable Integer num3, @Nullable PointF pointF, @Nullable TestEnum testEnum, @Nullable Integer num4) {
        this.b = bool;
        this.i = num;
        this.ui = num2;
        this.i64 = l;
        this.fl = f;
        this.d = d2;
        this.s = str;
        this.ti = l2;
        this.at = l3;
        this.rt = l4;
        this.by = bArr;
        this.c = num3;
        this.p = pointF;
        this.e = testEnum;
        this.be = num4;
    }

    @Nullable
    public Long getAt() {
        return this.at;
    }

    @Nullable
    public Boolean getB() {
        return this.b;
    }

    @Nullable
    public Integer getBe() {
        return this.be;
    }

    @Nullable
    public byte[] getBy() {
        return this.by;
    }

    @Nullable
    public Integer getC() {
        return this.c;
    }

    @Nullable
    public Double getD() {
        return this.d;
    }

    @Nullable
    public TestEnum getE() {
        return this.e;
    }

    @Nullable
    public Float getFl() {
        return this.fl;
    }

    @Nullable
    public Integer getI() {
        return this.i;
    }

    @Nullable
    public Long getI64() {
        return this.i64;
    }

    @Nullable
    public PointF getP() {
        return this.p;
    }

    @Nullable
    public Long getRt() {
        return this.rt;
    }

    @Nullable
    public String getS() {
        return this.s;
    }

    @Nullable
    public Long getTi() {
        return this.ti;
    }

    @Nullable
    public Integer getUi() {
        return this.ui;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.b = archive.add(this.b, true);
        this.i = archive.add(this.i, true);
        this.ui = archive.add(this.ui, true);
        this.i64 = archive.add(this.i64, true);
        this.fl = archive.add(this.fl, true);
        this.d = archive.add(this.d, true);
        this.s = archive.add(this.s, true);
        this.ti = archive.add(this.ti, true);
        this.at = archive.add(this.at, true);
        this.rt = archive.add(this.rt, true);
        this.by = archive.add(this.by, true);
        this.c = archive.add(this.c, true);
        this.p = archive.add(this.p, true);
        this.e = (TestEnum) archive.add((Archive) this.e, true, (Class<Archive>) TestEnum.class);
        this.be = archive.add(this.be, true);
    }

    public FullOptionsTestStructure setAt(@Nullable Long l) {
        this.at = l;
        return this;
    }

    public FullOptionsTestStructure setB(@Nullable Boolean bool) {
        this.b = bool;
        return this;
    }

    public FullOptionsTestStructure setBe(@Nullable Integer num) {
        this.be = num;
        return this;
    }

    public FullOptionsTestStructure setBy(@Nullable byte[] bArr) {
        this.by = bArr;
        return this;
    }

    public FullOptionsTestStructure setC(@Nullable Integer num) {
        this.c = num;
        return this;
    }

    public FullOptionsTestStructure setD(@Nullable Double d2) {
        this.d = d2;
        return this;
    }

    public FullOptionsTestStructure setE(@Nullable TestEnum testEnum) {
        this.e = testEnum;
        return this;
    }

    public FullOptionsTestStructure setFl(@Nullable Float f) {
        this.fl = f;
        return this;
    }

    public FullOptionsTestStructure setI(@Nullable Integer num) {
        this.i = num;
        return this;
    }

    public FullOptionsTestStructure setI64(@Nullable Long l) {
        this.i64 = l;
        return this;
    }

    public FullOptionsTestStructure setP(@Nullable PointF pointF) {
        this.p = pointF;
        return this;
    }

    public FullOptionsTestStructure setRt(@Nullable Long l) {
        this.rt = l;
        return this;
    }

    public FullOptionsTestStructure setS(@Nullable String str) {
        this.s = str;
        return this;
    }

    public FullOptionsTestStructure setTi(@Nullable Long l) {
        this.ti = l;
        return this;
    }

    public FullOptionsTestStructure setUi(@Nullable Integer num) {
        this.ui = num;
        return this;
    }

    public FullOptionsTestStructure() {
    }
}

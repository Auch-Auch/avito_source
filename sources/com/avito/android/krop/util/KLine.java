package com.avito.android.krop.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0014\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0012¨\u0006)"}, d2 = {"Lcom/avito/android/krop/util/KLine;", "", "line2", "Lcom/avito/android/krop/util/KPoint;", "findIntersection", "(Lcom/avito/android/krop/util/KLine;)Lcom/avito/android/krop/util/KPoint;", "", "length", "()F", "Lkotlin/Pair;", "getTransition", "()Lkotlin/Pair;", "target", "nearestPointFor", "(Lcom/avito/android/krop/util/KPoint;)Lcom/avito/android/krop/util/KPoint;", "normalFrom", "(Lcom/avito/android/krop/util/KPoint;)Lcom/avito/android/krop/util/KLine;", "component1", "()Lcom/avito/android/krop/util/KPoint;", "component2", "p1", "p2", "copy", "(Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;)Lcom/avito/android/krop/util/KLine;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/krop/util/KPoint;", "getP1", AuthSource.BOOKING_ORDER, "getP2", "<init>", "(Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;)V", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class KLine {
    @NotNull
    public final KPoint a;
    @NotNull
    public final KPoint b;

    public KLine(@NotNull KPoint kPoint, @NotNull KPoint kPoint2) {
        Intrinsics.checkParameterIsNotNull(kPoint, "p1");
        Intrinsics.checkParameterIsNotNull(kPoint2, "p2");
        this.a = kPoint;
        this.b = kPoint2;
    }

    public static /* synthetic */ KLine copy$default(KLine kLine, KPoint kPoint, KPoint kPoint2, int i, Object obj) {
        if ((i & 1) != 0) {
            kPoint = kLine.a;
        }
        if ((i & 2) != 0) {
            kPoint2 = kLine.b;
        }
        return kLine.copy(kPoint, kPoint2);
    }

    @NotNull
    public final KPoint component1() {
        return this.a;
    }

    @NotNull
    public final KPoint component2() {
        return this.b;
    }

    @NotNull
    public final KLine copy(@NotNull KPoint kPoint, @NotNull KPoint kPoint2) {
        Intrinsics.checkParameterIsNotNull(kPoint, "p1");
        Intrinsics.checkParameterIsNotNull(kPoint2, "p2");
        return new KLine(kPoint, kPoint2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KLine)) {
            return false;
        }
        KLine kLine = (KLine) obj;
        return Intrinsics.areEqual(this.a, kLine.a) && Intrinsics.areEqual(this.b, kLine.b);
    }

    @Nullable
    public final KPoint findIntersection(@NotNull KLine kLine) {
        Intrinsics.checkParameterIsNotNull(kLine, "line2");
        float x = this.a.getX();
        float y = this.a.getY();
        float x2 = this.b.getX();
        float y2 = this.b.getY();
        float x3 = kLine.a.getX();
        float y3 = kLine.a.getY();
        float f = x3 - x;
        float f2 = y2 - y;
        float f3 = x2 - x;
        float x4 = kLine.b.getX() - x3;
        float y4 = ((y3 - y) - ((f * f2) / f3)) / (((x4 * f2) / f3) - (kLine.b.getY() - y3));
        float f4 = (float) 0;
        if (y4 >= f4) {
            float f5 = (float) 1;
            if (y4 <= f5) {
                float f6 = ((y4 * x4) + f) / f3;
                if (f6 >= f4 && f6 <= f5) {
                    return new KPoint((f3 * f6) + x, (f6 * f2) + y);
                }
            }
        }
        return null;
    }

    @NotNull
    public final KPoint getP1() {
        return this.a;
    }

    @NotNull
    public final KPoint getP2() {
        return this.b;
    }

    @NotNull
    public final Pair<Float, Float> getTransition() {
        return TuplesKt.to(Float.valueOf(this.b.getX() - this.a.getX()), Float.valueOf(this.b.getY() - this.a.getY()));
    }

    public int hashCode() {
        KPoint kPoint = this.a;
        int i = 0;
        int hashCode = (kPoint != null ? kPoint.hashCode() : 0) * 31;
        KPoint kPoint2 = this.b;
        if (kPoint2 != null) {
            i = kPoint2.hashCode();
        }
        return hashCode + i;
    }

    public final float length() {
        return (float) Math.sqrt((double) (((this.b.getY() - this.a.getY()) * (this.b.getY() - this.a.getY())) + ((this.b.getX() - this.a.getX()) * (this.b.getX() - this.a.getX()))));
    }

    @NotNull
    public final KPoint nearestPointFor(@NotNull KPoint kPoint) {
        Intrinsics.checkParameterIsNotNull(kPoint, "target");
        KPoint kPoint2 = normalFrom(kPoint).b;
        float length = length();
        float length2 = new KLine(this.a, kPoint2).length();
        float length3 = new KLine(this.b, kPoint2).length();
        if (Math.abs((length2 + length3) - length) < ((float) 1)) {
            return kPoint2;
        }
        return length2 > length3 ? this.b : this.a;
    }

    @NotNull
    public final KLine normalFrom(@NotNull KPoint kPoint) {
        Intrinsics.checkParameterIsNotNull(kPoint, "target");
        float length = new KLine(this.a, kPoint).length();
        float length2 = new KLine(this.b, kPoint).length();
        float length3 = length();
        float f = (((length3 * length3) + (length2 * length2)) - (length * length)) / (((float) 2) * length3);
        float f2 = length3 - f;
        float f3 = f2 / (f + f2);
        return new KLine(kPoint, new KPoint(((this.b.getX() - this.a.getX()) * f3) + this.a.getX(), ((this.b.getY() - this.a.getY()) * f3) + this.a.getY()));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("KLine(p1=");
        L.append(this.a);
        L.append(", p2=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}

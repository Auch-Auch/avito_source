package com.avito.android.krop.util;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J8\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010(\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b/\u0010\u0004¨\u00062"}, d2 = {"Lcom/avito/android/krop/util/KRect;", "", "Lcom/avito/android/krop/util/KPoint;", "center", "()Lcom/avito/android/krop/util/KPoint;", "", "dx", "dy", "moveBy", "(FF)Lcom/avito/android/krop/util/KRect;", "", "Lcom/avito/android/krop/util/KLine;", "clockwiseBorders", "()Ljava/util/List;", "clockwiseHeights", "other", "", "contains", "(Lcom/avito/android/krop/util/KRect;)Z", "p", "(Lcom/avito/android/krop/util/KPoint;)Z", "component1", "component2", "component3", "component4", "leftTop", "rightTop", "rightBottom", "leftBottom", "copy", "(Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;)Lcom/avito/android/krop/util/KRect;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/krop/util/KPoint;", "getLeftTop", "c", "getRightBottom", "d", "getLeftBottom", AuthSource.BOOKING_ORDER, "getRightTop", "<init>", "(Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;Lcom/avito/android/krop/util/KPoint;)V", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class KRect {
    @NotNull
    public final KPoint a;
    @NotNull
    public final KPoint b;
    @NotNull
    public final KPoint c;
    @NotNull
    public final KPoint d;

    public static final class a extends Lambda implements Function3<KPoint, KPoint, KPoint, Float> {
        public static final a a = new a();

        public a() {
            super(3);
        }

        public final float a(@NotNull KPoint kPoint, @NotNull KPoint kPoint2, @NotNull KPoint kPoint3) {
            Intrinsics.checkParameterIsNotNull(kPoint, "p1");
            Intrinsics.checkParameterIsNotNull(kPoint2, "p2");
            Intrinsics.checkParameterIsNotNull(kPoint3, "p3");
            return Math.abs(((kPoint3.getY() - kPoint.getY()) * (kPoint2.getX() - kPoint.getX())) - ((kPoint2.getY() - kPoint.getY()) * (kPoint3.getX() - kPoint.getX()))) / ((float) 2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Float invoke(KPoint kPoint, KPoint kPoint2, KPoint kPoint3) {
            return Float.valueOf(a(kPoint, kPoint2, kPoint3));
        }
    }

    public KRect(@NotNull KPoint kPoint, @NotNull KPoint kPoint2, @NotNull KPoint kPoint3, @NotNull KPoint kPoint4) {
        Intrinsics.checkParameterIsNotNull(kPoint, "leftTop");
        Intrinsics.checkParameterIsNotNull(kPoint2, "rightTop");
        Intrinsics.checkParameterIsNotNull(kPoint3, "rightBottom");
        Intrinsics.checkParameterIsNotNull(kPoint4, "leftBottom");
        this.a = kPoint;
        this.b = kPoint2;
        this.c = kPoint3;
        this.d = kPoint4;
    }

    public static /* synthetic */ KRect copy$default(KRect kRect, KPoint kPoint, KPoint kPoint2, KPoint kPoint3, KPoint kPoint4, int i, Object obj) {
        if ((i & 1) != 0) {
            kPoint = kRect.a;
        }
        if ((i & 2) != 0) {
            kPoint2 = kRect.b;
        }
        if ((i & 4) != 0) {
            kPoint3 = kRect.c;
        }
        if ((i & 8) != 0) {
            kPoint4 = kRect.d;
        }
        return kRect.copy(kPoint, kPoint2, kPoint3, kPoint4);
    }

    @NotNull
    public final KPoint center() {
        float f = (float) 2;
        return new KPoint((this.d.getX() + this.b.getX()) / f, (this.d.getY() + this.b.getY()) / f);
    }

    @NotNull
    public final List<KLine> clockwiseBorders() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new KLine[]{new KLine(this.a, this.b), new KLine(this.b, this.c), new KLine(this.c, this.d), new KLine(this.d, this.a)});
    }

    @NotNull
    public final List<KPoint> clockwiseHeights() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new KPoint[]{this.a, this.b, this.c, this.d});
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
    public final KPoint component3() {
        return this.c;
    }

    @NotNull
    public final KPoint component4() {
        return this.d;
    }

    public final boolean contains(@NotNull KRect kRect) {
        Intrinsics.checkParameterIsNotNull(kRect, "other");
        return contains(kRect.a) && contains(kRect.b) && contains(kRect.d) && contains(kRect.c);
    }

    @NotNull
    public final KRect copy(@NotNull KPoint kPoint, @NotNull KPoint kPoint2, @NotNull KPoint kPoint3, @NotNull KPoint kPoint4) {
        Intrinsics.checkParameterIsNotNull(kPoint, "leftTop");
        Intrinsics.checkParameterIsNotNull(kPoint2, "rightTop");
        Intrinsics.checkParameterIsNotNull(kPoint3, "rightBottom");
        Intrinsics.checkParameterIsNotNull(kPoint4, "leftBottom");
        return new KRect(kPoint, kPoint2, kPoint3, kPoint4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KRect)) {
            return false;
        }
        KRect kRect = (KRect) obj;
        return Intrinsics.areEqual(this.a, kRect.a) && Intrinsics.areEqual(this.b, kRect.b) && Intrinsics.areEqual(this.c, kRect.c) && Intrinsics.areEqual(this.d, kRect.d);
    }

    @NotNull
    public final KPoint getLeftBottom() {
        return this.d;
    }

    @NotNull
    public final KPoint getLeftTop() {
        return this.a;
    }

    @NotNull
    public final KPoint getRightBottom() {
        return this.c;
    }

    @NotNull
    public final KPoint getRightTop() {
        return this.b;
    }

    public int hashCode() {
        KPoint kPoint = this.a;
        int i = 0;
        int hashCode = (kPoint != null ? kPoint.hashCode() : 0) * 31;
        KPoint kPoint2 = this.b;
        int hashCode2 = (hashCode + (kPoint2 != null ? kPoint2.hashCode() : 0)) * 31;
        KPoint kPoint3 = this.c;
        int hashCode3 = (hashCode2 + (kPoint3 != null ? kPoint3.hashCode() : 0)) * 31;
        KPoint kPoint4 = this.d;
        if (kPoint4 != null) {
            i = kPoint4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public final KRect moveBy(float f, float f2) {
        return new KRect(this.a.moveBy(f, f2), this.b.moveBy(f, f2), this.c.moveBy(f, f2), this.d.moveBy(f, f2));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("KRect(leftTop=");
        L.append(this.a);
        L.append(", rightTop=");
        L.append(this.b);
        L.append(", rightBottom=");
        L.append(this.c);
        L.append(", leftBottom=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    public final boolean contains(@NotNull KPoint kPoint) {
        Intrinsics.checkParameterIsNotNull(kPoint, "p");
        a aVar = a.a;
        return Math.abs((aVar.a(this.a, this.b, this.d) * ((float) 2)) - (aVar.a(this.b, this.c, kPoint) + (aVar.a(this.d, this.c, kPoint) + (aVar.a(this.a, this.d, kPoint) + aVar.a(this.a, this.b, kPoint))))) < ((float) 10);
    }
}

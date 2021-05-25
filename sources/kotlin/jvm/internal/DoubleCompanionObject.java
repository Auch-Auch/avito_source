package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007XT¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u0012\u0004\b\u0012\u0010\rR\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u0012\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u00020\t8\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u0012\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u0012\u0004\b\u0018\u0010\rR\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u0012\u0004\b\u001a\u0010\r¨\u0006\u001c"}, d2 = {"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "", "getMIN_VALUE", "()D", "getMAX_VALUE", "getPOSITIVE_INFINITY", "getNEGATIVE_INFINITY", "getNaN", "", "SIZE_BYTES", "I", "getSIZE_BYTES$annotations", "()V", "POSITIVE_INFINITY", "D", "getPOSITIVE_INFINITY$annotations", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY$annotations", "MAX_VALUE", "getMAX_VALUE$annotations", "SIZE_BITS", "getSIZE_BITS$annotations", "NaN", "getNaN$annotations", "MIN_VALUE", "getMIN_VALUE$annotations", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class DoubleCompanionObject {
    @NotNull
    public static final DoubleCompanionObject INSTANCE = new DoubleCompanionObject();
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double NaN = Double.NaN;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getMAX_VALUE$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getMIN_VALUE$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getNEGATIVE_INFINITY$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getNaN$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getPOSITIVE_INFINITY$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSIZE_BITS$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSIZE_BYTES$annotations() {
    }

    public final double getMAX_VALUE() {
        return Double.MAX_VALUE;
    }

    public final double getMIN_VALUE() {
        return Double.MIN_VALUE;
    }

    public final double getNEGATIVE_INFINITY() {
        return Double.NEGATIVE_INFINITY;
    }

    public final double getNaN() {
        return Double.NaN;
    }

    public final double getPOSITIVE_INFINITY() {
        return Double.POSITIVE_INFINITY;
    }
}

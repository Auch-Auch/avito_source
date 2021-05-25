package com.avito.android.delivery.analytics.summary;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/ErrorType;", "", "", "toString", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "Companion", "OUT_OF_STOCK", "NOT_ENOUGH", "delivery_release"}, k = 1, mv = {1, 4, 2})
public enum ErrorType {
    OUT_OF_STOCK,
    NOT_ENOUGH;
    
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/analytics/summary/ErrorType$Companion;", "", "", FirebaseAnalytics.Param.QUANTITY, "Lcom/avito/android/delivery/analytics/summary/ErrorType;", "fromQuantity", "(I)Lcom/avito/android/delivery/analytics/summary/ErrorType;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ErrorType fromQuantity(int i) {
            return i == 0 ? ErrorType.OUT_OF_STOCK : ErrorType.NOT_ENOUGH;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ErrorType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            ErrorType errorType = ErrorType.OUT_OF_STOCK;
            iArr[0] = 1;
            ErrorType errorType2 = ErrorType.NOT_ENOUGH;
            iArr[1] = 2;
        }
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return "out of stock";
        }
        if (ordinal == 1) {
            return "not enough";
        }
        throw new NoWhenBranchMatchedException();
    }
}

package com.avito.android.remote.model.delivery;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsResult;", "", "<init>", "()V", "DeliveryUnavailable", "Success", "Lcom/avito/android/remote/model/delivery/DeliveryPointsResult$Success;", "Lcom/avito/android/remote/model/delivery/DeliveryPointsResult$DeliveryUnavailable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public abstract class DeliveryPointsResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsResult$DeliveryUnavailable;", "Lcom/avito/android/remote/model/delivery/DeliveryPointsResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeliveryUnavailable extends DeliveryPointsResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliveryUnavailable(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsResult$Success;", "Lcom/avito/android/remote/model/delivery/DeliveryPointsResult;", "Lcom/avito/android/remote/model/delivery/DeliveryPoints;", "deliveryPoints", "Lcom/avito/android/remote/model/delivery/DeliveryPoints;", "getDeliveryPoints", "()Lcom/avito/android/remote/model/delivery/DeliveryPoints;", "<init>", "(Lcom/avito/android/remote/model/delivery/DeliveryPoints;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends DeliveryPointsResult {
        @NotNull
        private final DeliveryPoints deliveryPoints;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull DeliveryPoints deliveryPoints2) {
            super(null);
            Intrinsics.checkNotNullParameter(deliveryPoints2, "deliveryPoints");
            this.deliveryPoints = deliveryPoints2;
        }

        @NotNull
        public final DeliveryPoints getDeliveryPoints() {
            return this.deliveryPoints;
        }
    }

    private DeliveryPointsResult() {
    }

    public /* synthetic */ DeliveryPointsResult(j jVar) {
        this();
    }
}

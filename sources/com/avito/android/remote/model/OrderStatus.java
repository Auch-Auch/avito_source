package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/OrderStatus;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/OrderMessage;", "orderMessage", "Lcom/avito/android/remote/model/OrderMessage;", "getOrderMessage", "()Lcom/avito/android/remote/model/OrderMessage;", "", "isDone", "Z", "()Z", "<init>", "(ZLcom/avito/android/remote/model/OrderMessage;)V", "Done", "Success", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class OrderStatus implements Parcelable {
    private final boolean isDone;
    @Nullable
    private final OrderMessage orderMessage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/OrderStatus$Done;", "Lcom/avito/android/remote/model/OrderStatus;", "", "isDone", "Lcom/avito/android/remote/model/OrderMessage;", "orderMessage", "<init>", "(ZLcom/avito/android/remote/model/OrderMessage;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Done extends OrderStatus {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Done> CREATOR = Parcels.creator(OrderStatus$Done$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/OrderStatus$Done$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/OrderStatus$Done;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Done(boolean z, @Nullable OrderMessage orderMessage) {
            super(z, orderMessage);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/OrderStatus$Success;", "Lcom/avito/android/remote/model/OrderStatus;", "Lcom/avito/android/remote/model/OrderMessage;", "orderMessage", "Lcom/avito/android/remote/model/OrderMessage;", "getOrderMessage", "()Lcom/avito/android/remote/model/OrderMessage;", "", "isDone", "Z", "()Z", "<init>", "(ZLcom/avito/android/remote/model/OrderMessage;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends OrderStatus {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Success> CREATOR = Parcels.creator(OrderStatus$Success$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("success")
        private final boolean isDone;
        @SerializedName("message")
        @Nullable
        private final OrderMessage orderMessage;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/OrderStatus$Success$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/OrderStatus$Success;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Success(boolean z, @Nullable OrderMessage orderMessage2) {
            super(z, orderMessage2);
            this.isDone = z;
            this.orderMessage = orderMessage2;
        }

        @Override // com.avito.android.remote.model.OrderStatus
        @Nullable
        public OrderMessage getOrderMessage() {
            return this.orderMessage;
        }

        @Override // com.avito.android.remote.model.OrderStatus
        public boolean isDone() {
            return this.isDone;
        }
    }

    public OrderStatus(boolean z, @Nullable OrderMessage orderMessage2) {
        this.isDone = z;
        this.orderMessage = orderMessage2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public OrderMessage getOrderMessage() {
        return this.orderMessage;
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeBool(parcel, isDone());
        parcel.writeParcelable(getOrderMessage(), i);
    }
}

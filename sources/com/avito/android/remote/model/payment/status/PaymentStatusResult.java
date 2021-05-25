package com.avito.android.remote.model.payment.status;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SimpleUserDialog;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/status/PaymentStatusResult;", "", "<init>", "()V", "ForbiddenPayment", "PaymentStatus", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$ForbiddenPayment;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentStatusResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$ForbiddenPayment;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForbiddenPayment extends PaymentStatusResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ForbiddenPayment(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0018J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SimpleUserDialog;", "userDialog", "Lcom/avito/android/remote/model/SimpleUserDialog;", "getUserDialog", "()Lcom/avito/android/remote/model/SimpleUserDialog;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SimpleUserDialog;)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class PaymentStatus extends PaymentStatusResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @SerializedName("status")
        @NotNull
        private final String state;
        @SerializedName("userDialog")
        @Nullable
        private final SimpleUserDialog userDialog;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<PaymentStatus> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(j jVar) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public PaymentStatus createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PaymentStatus(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public PaymentStatus[] newArray(int i) {
                return new PaymentStatus[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentStatus(@NotNull String str, @Nullable SimpleUserDialog simpleUserDialog) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "state");
            this.state = str;
            this.userDialog = simpleUserDialog;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getState() {
            return this.state;
        }

        @Nullable
        public final SimpleUserDialog getUserDialog() {
            return this.userDialog;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.state);
            parcel.writeParcelable(this.userDialog, i);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PaymentStatus(@org.jetbrains.annotations.NotNull android.os.Parcel r3) {
            /*
                r2 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = r3.readString()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                java.lang.String r1 = "parcel.readString()!!"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Class<com.avito.android.remote.model.SimpleUserDialog> r1 = com.avito.android.remote.model.SimpleUserDialog.class
                java.lang.ClassLoader r1 = r1.getClassLoader()
                android.os.Parcelable r3 = r3.readParcelable(r1)
                com.avito.android.remote.model.SimpleUserDialog r3 = (com.avito.android.remote.model.SimpleUserDialog) r3
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.payment.status.PaymentStatusResult.PaymentStatus.<init>(android.os.Parcel):void");
        }
    }

    private PaymentStatusResult() {
    }

    public /* synthetic */ PaymentStatusResult(j jVar) {
        this();
    }
}

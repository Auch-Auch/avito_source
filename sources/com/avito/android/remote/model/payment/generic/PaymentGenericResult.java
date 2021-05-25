package com.avito.android.remote.model.payment.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "", "<init>", "()V", "DuplicatePayment", "ForbiddenPayment", "FormIncorrectData", "Ok", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$FormIncorrectData;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$DuplicatePayment;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$ForbiddenPayment;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentGenericResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$DuplicatePayment;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class DuplicatePayment extends PaymentGenericResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DuplicatePayment(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$ForbiddenPayment;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForbiddenPayment extends PaymentGenericResult {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$FormIncorrectData;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class FormIncorrectData extends PaymentGenericResult {
        @SerializedName("messages")
        @NotNull
        private final Map<String, String> messages;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FormIncorrectData(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "messages");
            this.messages = map;
        }

        @NotNull
        public final Map<String, String> getMessages() {
            return this.messages;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", ShareConstants.MEDIA_URI, "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", AnalyticFieldsName.orderId, "getOrderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends PaymentGenericResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @SerializedName(AnalyticFieldsName.orderId)
        @NotNull
        private final String orderId;
        @SerializedName(ShareConstants.MEDIA_URI)
        @NotNull
        private final String uri;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult$Ok;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<Ok> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(j jVar) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public Ok createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Ok(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public Ok[] newArray(int i) {
                return new Ok[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.MEDIA_URI);
            this.orderId = str;
            this.uri = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        @NotNull
        public final String getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.orderId);
            parcel.writeString(this.uri);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Ok(@org.jetbrains.annotations.NotNull android.os.Parcel r3) {
            /*
                r2 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = r3.readString()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                java.lang.String r1 = "parcel.readString()!!"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r3 = a2.b.a.a.a.u2(r3, r1)
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.payment.generic.PaymentGenericResult.Ok.<init>(android.os.Parcel):void");
        }
    }

    private PaymentGenericResult() {
    }

    public /* synthetic */ PaymentGenericResult(j jVar) {
        this();
    }
}

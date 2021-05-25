package com.avito.android.remote.model.payment.form;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult;", "", "<init>", "()V", "Ok", "Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentGenericFormResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B=\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001e\u001a\u00020\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok;", "Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "", "methodSignature", "Ljava/lang/String;", "getMethodSignature", "()Ljava/lang/String;", "title", "getTitle", "submitText", "getSubmitText", "paymentSessionId", "getPaymentSessionId", "Lcom/avito/android/remote/model/text/AttributedText;", "information", "Lcom/avito/android/remote/model/text/AttributedText;", "getInformation", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends PaymentGenericFormResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @SerializedName("fields")
        @NotNull
        private final List<ParameterSlot> fields;
        @SerializedName("information")
        @NotNull
        private final AttributedText information;
        @SerializedName("methodSignature")
        @NotNull
        private final String methodSignature;
        @SerializedName("paymentSessionId")
        @NotNull
        private final String paymentSessionId;
        @SerializedName("submitText")
        @NotNull
        private final String submitText;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult$Ok;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
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

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull String str, @NotNull AttributedText attributedText, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<? extends ParameterSlot> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(attributedText, "information");
            Intrinsics.checkNotNullParameter(str2, "submitText");
            Intrinsics.checkNotNullParameter(str3, "paymentSessionId");
            Intrinsics.checkNotNullParameter(str4, "methodSignature");
            Intrinsics.checkNotNullParameter(list, "fields");
            this.title = str;
            this.information = attributedText;
            this.submitText = str2;
            this.paymentSessionId = str3;
            this.methodSignature = str4;
            this.fields = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<ParameterSlot> getFields() {
            return this.fields;
        }

        @NotNull
        public final AttributedText getInformation() {
            return this.information;
        }

        @NotNull
        public final String getMethodSignature() {
            return this.methodSignature;
        }

        @NotNull
        public final String getPaymentSessionId() {
            return this.paymentSessionId;
        }

        @NotNull
        public final String getSubmitText() {
            return this.submitText;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.information, i);
            parcel.writeString(this.submitText);
            parcel.writeString(this.paymentSessionId);
            parcel.writeString(this.methodSignature);
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.fields, 0, 2, null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Ok(@org.jetbrains.annotations.NotNull android.os.Parcel r9) {
            /*
                r8 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r2 = r9.readString()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                java.lang.String r0 = "parcel.readString()!!"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                java.lang.Class<com.avito.android.remote.model.text.AttributedText> r1 = com.avito.android.remote.model.text.AttributedText.class
                android.os.Parcelable r1 = a2.b.a.a.a.z1(r1, r9)
                r3 = r1
                com.avito.android.remote.model.text.AttributedText r3 = (com.avito.android.remote.model.text.AttributedText) r3
                java.lang.String r4 = a2.b.a.a.a.u2(r9, r0)
                java.lang.String r5 = a2.b.a.a.a.u2(r9, r0)
                java.lang.String r6 = a2.b.a.a.a.u2(r9, r0)
                java.lang.Class<com.avito.android.remote.model.category_parameters.base.ParameterSlot> r0 = com.avito.android.remote.model.category_parameters.base.ParameterSlot.class
                java.util.List r9 = com.avito.android.util.ParcelsKt.createParcelableList(r9, r0)
                if (r9 == 0) goto L_0x002f
                goto L_0x0033
            L_0x002f:
                java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0033:
                r7 = r9
                r1 = r8
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.payment.form.PaymentGenericFormResult.Ok.<init>(android.os.Parcel):void");
        }
    }

    private PaymentGenericFormResult() {
    }

    public /* synthetic */ PaymentGenericFormResult(j jVar) {
        this();
    }
}

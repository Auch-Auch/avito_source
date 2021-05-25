package com.avito.android.remote.model.payment.status.form;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult;", "", "<init>", "()V", "StatusForm", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentStatusFormResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B-\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b \u0010\"J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "instructions", "Ljava/util/List;", "getInstructions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/LinkAction;", "action", "Lcom/avito/android/remote/model/LinkAction;", "getAction", "()Lcom/avito/android/remote/model/LinkAction;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/LinkAction;)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class StatusForm extends PaymentStatusFormResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @SerializedName("action")
        @NotNull
        private final LinkAction action;
        @SerializedName("disclaimer")
        @NotNull
        private final AttributedText disclaimer;
        @SerializedName("instructions")
        @NotNull
        private final List<AttributedText> instructions;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult$StatusForm;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<StatusForm> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(j jVar) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public StatusForm createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StatusForm(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public StatusForm[] newArray(int i) {
                return new StatusForm[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StatusForm(@NotNull String str, @NotNull List<AttributedText> list, @NotNull AttributedText attributedText, @NotNull LinkAction linkAction) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "instructions");
            Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
            Intrinsics.checkNotNullParameter(linkAction, "action");
            this.title = str;
            this.instructions = list;
            this.disclaimer = attributedText;
            this.action = linkAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final LinkAction getAction() {
            return this.action;
        }

        @NotNull
        public final AttributedText getDisclaimer() {
            return this.disclaimer;
        }

        @NotNull
        public final List<AttributedText> getInstructions() {
            return this.instructions;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            ParcelsKt.writeOptimizedParcelableList(parcel, this.instructions, i);
            parcel.writeParcelable(this.disclaimer, i);
            parcel.writeParcelable(this.action, i);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public StatusForm(@org.jetbrains.annotations.NotNull android.os.Parcel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = r5.readString()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                java.lang.String r1 = "parcel.readString()!!"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Class<com.avito.android.remote.model.text.AttributedText> r1 = com.avito.android.remote.model.text.AttributedText.class
                java.util.List r1 = com.avito.android.util.ParcelsKt.createParcelableList(r5, r1)
                if (r1 == 0) goto L_0x001a
                goto L_0x001e
            L_0x001a:
                java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x001e:
                java.lang.Class<com.avito.android.remote.model.text.AttributedText> r2 = com.avito.android.remote.model.text.AttributedText.class
                android.os.Parcelable r2 = a2.b.a.a.a.z1(r2, r5)
                com.avito.android.remote.model.text.AttributedText r2 = (com.avito.android.remote.model.text.AttributedText) r2
                java.lang.Class<com.avito.android.remote.model.LinkAction> r3 = com.avito.android.remote.model.LinkAction.class
                android.os.Parcelable r5 = a2.b.a.a.a.z1(r3, r5)
                com.avito.android.remote.model.LinkAction r5 = (com.avito.android.remote.model.LinkAction) r5
                r4.<init>(r0, r1, r2, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult.StatusForm.<init>(android.os.Parcel):void");
        }
    }

    private PaymentStatusFormResult() {
    }

    public /* synthetic */ PaymentStatusFormResult(j jVar) {
        this();
    }
}

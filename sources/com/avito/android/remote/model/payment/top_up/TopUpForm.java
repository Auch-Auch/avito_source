package com.avito.android.remote.model.payment.top_up;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/payment/top_up/TopUpHint;", "hints", "Ljava/util/List;", "getHints", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "fields", "getFields", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "submitText", "getSubmitText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpForm implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("fields")
    @NotNull
    private final List<ParameterSlot> fields;
    @SerializedName("hints")
    @NotNull
    private final List<TopUpHint> hints;
    @SerializedName("submitText")
    @NotNull
    private final String submitText;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/payment/top_up/TopUpForm$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<TopUpForm> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public TopUpForm createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TopUpForm(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public TopUpForm[] newArray(int i) {
            return new TopUpForm[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX WARN: Multi-variable type inference failed */
    public TopUpForm(@NotNull String str, @NotNull String str2, @NotNull List<? extends ParameterSlot> list, @NotNull List<TopUpHint> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "submitText");
        Intrinsics.checkNotNullParameter(list, "fields");
        Intrinsics.checkNotNullParameter(list2, "hints");
        this.title = str;
        this.submitText = str2;
        this.fields = list;
        this.hints = list2;
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
    public final List<TopUpHint> getHints() {
        return this.hints;
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
        parcel.writeString(this.submitText);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.fields, 0, 2, null);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.hints, 0, 2, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TopUpForm(@org.jetbrains.annotations.NotNull android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = a2.b.a.a.a.u2(r5, r1)
            java.lang.Class<com.avito.android.remote.model.category_parameters.base.ParameterSlot> r2 = com.avito.android.remote.model.category_parameters.base.ParameterSlot.class
            java.util.List r2 = com.avito.android.util.ParcelsKt.createParcelableList(r5, r2)
            if (r2 == 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0022:
            java.lang.Class<com.avito.android.remote.model.payment.top_up.TopUpHint> r3 = com.avito.android.remote.model.payment.top_up.TopUpHint.class
            java.util.List r5 = com.avito.android.util.ParcelsKt.createParcelableList(r5, r3)
            if (r5 == 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x002f:
            r4.<init>(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.payment.top_up.TopUpForm.<init>(android.os.Parcel):void");
    }
}

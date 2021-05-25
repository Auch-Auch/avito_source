package com.avito.android.payment;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b#\b\u0016\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.BO\u0012\u0006\u0010*\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b+\u0010-J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0018\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u001e\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010!\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001c\u0010$\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010R\u001c\u0010'\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R\u001c\u0010*\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010¨\u0006/"}, d2 = {"Lcom/avito/android/payment/WebPaymentResourceProviderImpl;", "Lcom/avito/android/payment/WebPaymentResourceProvider;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "h", "Ljava/lang/String;", "getPreloadingErrorMessage", "()Ljava/lang/String;", "preloadingErrorMessage", "f", "getErrorDialogMessage", "errorDialogMessage", "i", "I", "getToolbarUpIconRes", "toolbarUpIconRes", "d", "getCancellationDialogNegativeButtonText", "cancellationDialogNegativeButtonText", g.a, "getErrorDialogButtonText", "errorDialogButtonText", "c", "getCancellationDialogPositiveButtonText", "cancellationDialogPositiveButtonText", AuthSource.BOOKING_ORDER, "getCancellationDialogMessage", "cancellationDialogMessage", "e", "getErrorDialogTitle", "errorDialogTitle", AuthSource.SEND_ABUSE, "getToolbarTitle", "toolbarTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public class WebPaymentResourceProviderImpl implements WebPaymentResourceProvider, Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WebPaymentResourceProviderImpl> CREATOR = new Parcelable.Creator<WebPaymentResourceProviderImpl>() { // from class: com.avito.android.payment.WebPaymentResourceProviderImpl$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        @NotNull
        public WebPaymentResourceProviderImpl createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WebPaymentResourceProviderImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public WebPaymentResourceProviderImpl[] newArray(int i2) {
            return new WebPaymentResourceProviderImpl[i2];
        }
    };
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    public final int i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/WebPaymentResourceProviderImpl$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/WebPaymentResourceProviderImpl;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public WebPaymentResourceProviderImpl(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, int i2) {
        Intrinsics.checkNotNullParameter(str, "toolbarTitle");
        Intrinsics.checkNotNullParameter(str2, "cancellationDialogMessage");
        Intrinsics.checkNotNullParameter(str3, "cancellationDialogPositiveButtonText");
        Intrinsics.checkNotNullParameter(str4, "cancellationDialogNegativeButtonText");
        Intrinsics.checkNotNullParameter(str5, "errorDialogTitle");
        Intrinsics.checkNotNullParameter(str6, "errorDialogMessage");
        Intrinsics.checkNotNullParameter(str7, "errorDialogButtonText");
        Intrinsics.checkNotNullParameter(str8, "preloadingErrorMessage");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getCancellationDialogMessage() {
        return this.b;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getCancellationDialogNegativeButtonText() {
        return this.d;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getCancellationDialogPositiveButtonText() {
        return this.c;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getErrorDialogButtonText() {
        return this.g;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getErrorDialogMessage() {
        return this.f;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getErrorDialogTitle() {
        return this.e;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getPreloadingErrorMessage() {
        return this.h;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    @NotNull
    public String getToolbarTitle() {
        return this.a;
    }

    @Override // com.avito.android.payment.WebPaymentResourceProvider
    public int getToolbarUpIconRes() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getToolbarTitle());
        parcel.writeString(getCancellationDialogMessage());
        parcel.writeString(getCancellationDialogPositiveButtonText());
        parcel.writeString(getCancellationDialogNegativeButtonText());
        parcel.writeString(getErrorDialogTitle());
        parcel.writeString(getErrorDialogMessage());
        parcel.writeString(getErrorDialogButtonText());
        parcel.writeString(getPreloadingErrorMessage());
        parcel.writeInt(getToolbarUpIconRes());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebPaymentResourceProviderImpl(@org.jetbrains.annotations.NotNull android.os.Parcel r12) {
        /*
            r11 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r2 = r12.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r0 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r3 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r4 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r5 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r6 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r7 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r8 = a2.b.a.a.a.u2(r12, r0)
            java.lang.String r9 = a2.b.a.a.a.u2(r12, r0)
            int r10 = r12.readInt()
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.payment.WebPaymentResourceProviderImpl.<init>(android.os.Parcel):void");
    }
}

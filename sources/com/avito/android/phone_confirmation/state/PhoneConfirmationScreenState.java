package com.avito.android.phone_confirmation.state;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u001f\b\b\u0018\u0000 G2\u00020\u0001:\u0001GBo\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u000b¢\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010E\u001a\u00020\u0005¢\u0006\u0004\bC\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ|\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010 \u001a\u00020\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010$\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b'\u0010\rJ\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u001a\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0019\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\rR\u0019\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u0010\u0010R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u0010\rR\u0019\u0010$\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u0010\rR\u001b\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u0010\rR\u0019\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b\u001c\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0015R\u0019\u0010 \u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u0010\r¨\u0006H"}, d2 = {"Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "component5", "()Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "component6", "component7", "component8", "component9", "component10", "phone", "isCompany", "codeRequested", "validationStatus", "confirmationTime", "hasNetworkError", "codeRequestError", "validationError", "tooManyValidations", "enteredCode", "copy", "(Ljava/lang/String;ZZZLcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Z", "getValidationStatus", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "c", "getCodeRequested", "i", "getTooManyValidations", "j", "getEnteredCode", "h", "getValidationError", AuthSource.BOOKING_ORDER, "e", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "getConfirmationTime", "f", "getHasNetworkError", g.a, "getCodeRequestError", "<init>", "(Ljava/lang/String;ZZZLcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationScreenState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhoneConfirmationScreenState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    @Nullable
    public final PhoneConfirmationTime e;
    public final boolean f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @NotNull
    public final String j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PhoneConfirmationScreenState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhoneConfirmationScreenState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PhoneConfirmationScreenState(parcel2);
        }
    }

    public PhoneConfirmationScreenState(@NotNull String str, boolean z, boolean z2, boolean z3, @Nullable PhoneConfirmationTime phoneConfirmationTime, boolean z4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str5, "enteredCode");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = phoneConfirmationTime;
        this.f = z4;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
    }

    public static /* synthetic */ PhoneConfirmationScreenState copy$default(PhoneConfirmationScreenState phoneConfirmationScreenState, String str, boolean z, boolean z2, boolean z3, PhoneConfirmationTime phoneConfirmationTime, boolean z4, String str2, String str3, String str4, String str5, int i2, Object obj) {
        return phoneConfirmationScreenState.copy((i2 & 1) != 0 ? phoneConfirmationScreenState.a : str, (i2 & 2) != 0 ? phoneConfirmationScreenState.b : z, (i2 & 4) != 0 ? phoneConfirmationScreenState.c : z2, (i2 & 8) != 0 ? phoneConfirmationScreenState.d : z3, (i2 & 16) != 0 ? phoneConfirmationScreenState.e : phoneConfirmationTime, (i2 & 32) != 0 ? phoneConfirmationScreenState.f : z4, (i2 & 64) != 0 ? phoneConfirmationScreenState.g : str2, (i2 & 128) != 0 ? phoneConfirmationScreenState.h : str3, (i2 & 256) != 0 ? phoneConfirmationScreenState.i : str4, (i2 & 512) != 0 ? phoneConfirmationScreenState.j : str5);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    public final boolean component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @Nullable
    public final PhoneConfirmationTime component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final PhoneConfirmationScreenState copy(@NotNull String str, boolean z, boolean z2, boolean z3, @Nullable PhoneConfirmationTime phoneConfirmationTime, boolean z4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str5, "enteredCode");
        return new PhoneConfirmationScreenState(str, z, z2, z3, phoneConfirmationTime, z4, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneConfirmationScreenState)) {
            return false;
        }
        PhoneConfirmationScreenState phoneConfirmationScreenState = (PhoneConfirmationScreenState) obj;
        return Intrinsics.areEqual(this.a, phoneConfirmationScreenState.a) && this.b == phoneConfirmationScreenState.b && this.c == phoneConfirmationScreenState.c && this.d == phoneConfirmationScreenState.d && Intrinsics.areEqual(this.e, phoneConfirmationScreenState.e) && this.f == phoneConfirmationScreenState.f && Intrinsics.areEqual(this.g, phoneConfirmationScreenState.g) && Intrinsics.areEqual(this.h, phoneConfirmationScreenState.h) && Intrinsics.areEqual(this.i, phoneConfirmationScreenState.i) && Intrinsics.areEqual(this.j, phoneConfirmationScreenState.j);
    }

    @Nullable
    public final String getCodeRequestError() {
        return this.g;
    }

    public final boolean getCodeRequested() {
        return this.c;
    }

    @Nullable
    public final PhoneConfirmationTime getConfirmationTime() {
        return this.e;
    }

    @NotNull
    public final String getEnteredCode() {
        return this.j;
    }

    public final boolean getHasNetworkError() {
        return this.f;
    }

    @NotNull
    public final String getPhone() {
        return this.a;
    }

    @Nullable
    public final String getTooManyValidations() {
        return this.i;
    }

    @Nullable
    public final String getValidationError() {
        return this.h;
    }

    public final boolean getValidationStatus() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode + i4) * 31;
        boolean z2 = this.c;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.d;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        PhoneConfirmationTime phoneConfirmationTime = this.e;
        int hashCode2 = (i15 + (phoneConfirmationTime != null ? phoneConfirmationTime.hashCode() : 0)) * 31;
        boolean z4 = this.f;
        if (!z4) {
            i3 = z4 ? 1 : 0;
        }
        int i16 = (hashCode2 + i3) * 31;
        String str2 = this.g;
        int hashCode3 = (i16 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.h;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.i;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.j;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public final boolean isCompany() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PhoneConfirmationScreenState(phone=");
        L.append(this.a);
        L.append(", isCompany=");
        L.append(this.b);
        L.append(", codeRequested=");
        L.append(this.c);
        L.append(", validationStatus=");
        L.append(this.d);
        L.append(", confirmationTime=");
        L.append(this.e);
        L.append(", hasNetworkError=");
        L.append(this.f);
        L.append(", codeRequestError=");
        L.append(this.g);
        L.append(", validationError=");
        L.append(this.h);
        L.append(", tooManyValidations=");
        L.append(this.i);
        L.append(", enteredCode=");
        return a2.b.a.a.a.t(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i2) {
        if (parcel != null) {
            parcel.writeString(this.a);
            ParcelsKt.writeBool(parcel, this.b);
            ParcelsKt.writeBool(parcel, this.c);
            ParcelsKt.writeBool(parcel, this.d);
            parcel.writeParcelable(this.e, i2);
            ParcelsKt.writeBool(parcel, this.f);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneConfirmationScreenState(String str, boolean z, boolean z2, boolean z3, PhoneConfirmationTime phoneConfirmationTime, boolean z4, String str2, String str3, String str4, String str5, int i2, j jVar) {
        this(str, z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? null : phoneConfirmationTime, (i2 & 32) != 0 ? false : z4, (i2 & 64) != 0 ? null : str2, (i2 & 128) != 0 ? null : str3, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? "" : str5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhoneConfirmationScreenState(@org.jetbrains.annotations.NotNull android.os.Parcel r13) {
        /*
            r12 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r2 = r13.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r0 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            boolean r3 = com.avito.android.util.ParcelsKt.readBool(r13)
            boolean r4 = com.avito.android.util.ParcelsKt.readBool(r13)
            boolean r5 = com.avito.android.util.ParcelsKt.readBool(r13)
            java.lang.Class<com.avito.android.phone_confirmation.state.PhoneConfirmationTime> r1 = com.avito.android.phone_confirmation.state.PhoneConfirmationTime.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r13.readParcelable(r1)
            r6 = r1
            com.avito.android.phone_confirmation.state.PhoneConfirmationTime r6 = (com.avito.android.phone_confirmation.state.PhoneConfirmationTime) r6
            boolean r7 = com.avito.android.util.ParcelsKt.readBool(r13)
            java.lang.String r8 = r13.readString()
            java.lang.String r9 = r13.readString()
            java.lang.String r10 = r13.readString()
            java.lang.String r11 = a2.b.a.a.a.u2(r13, r0)
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState.<init>(android.os.Parcel):void");
    }
}

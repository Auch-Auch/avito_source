package com.avito.android.phone_confirmation.state;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\r¨\u0006'"}, d2 = {"Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "phoneNumber", "timeNextRequestAllowed", "copy", "(Ljava/lang/String;J)Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "J", "getTimeNextRequestAllowed", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhoneNumber", "<init>", "(Ljava/lang/String;J)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationTime implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhoneConfirmationTime> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final long b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PhoneConfirmationTime> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhoneConfirmationTime invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PhoneConfirmationTime(parcel2);
        }
    }

    public PhoneConfirmationTime(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        this.a = str;
        this.b = j;
    }

    public static /* synthetic */ PhoneConfirmationTime copy$default(PhoneConfirmationTime phoneConfirmationTime, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneConfirmationTime.a;
        }
        if ((i & 2) != 0) {
            j = phoneConfirmationTime.b;
        }
        return phoneConfirmationTime.copy(str, j);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    @NotNull
    public final PhoneConfirmationTime copy(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        return new PhoneConfirmationTime(str, j);
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
        if (!(obj instanceof PhoneConfirmationTime)) {
            return false;
        }
        PhoneConfirmationTime phoneConfirmationTime = (PhoneConfirmationTime) obj;
        return Intrinsics.areEqual(this.a, phoneConfirmationTime.a) && this.b == phoneConfirmationTime.b;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.a;
    }

    public final long getTimeNextRequestAllowed() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + c.a(this.b);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PhoneConfirmationTime(phoneNumber=");
        L.append(this.a);
        L.append(", timeNextRequestAllowed=");
        return a2.b.a.a.a.l(L, this.b, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(this.a);
        }
        if (parcel != null) {
            parcel.writeLong(this.b);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhoneConfirmationTime(@org.jetbrains.annotations.NotNull android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            long r1 = r4.readLong()
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.phone_confirmation.state.PhoneConfirmationTime.<init>(android.os.Parcel):void");
    }
}

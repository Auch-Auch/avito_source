package com.avito.android.location_picker.entities;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b \b\b\u0018\u0000 F2\u00020\u0001:\u0001FBo\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b¢\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bC\u0010EJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJx\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b%\u0010\u0011J\u0010\u0010&\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b&\u0010\nJ\u001a\u0010)\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0011R\u0013\u0010/\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\rR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b4\u0010\rR\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u0010\rR\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u0010\rR\u0019\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u0010\rR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010\rR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010,\u001a\u0004\b>\u0010\u0011R\u0019\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010\rR\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u0010\r¨\u0006G"}, d2 = {"Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "hasGeneralNetworkError", "hasNetworkErrorOnConfirmation", "addressConfirmationError", "unknownError", "notGrantedPermissionError", "notSuggestedAddressError", "noSuggestsError", "emptyAddressError", "advertsCountError", "advertsCountNetworkError", "copy", "(ZZLjava/lang/String;Ljava/lang/String;ZZZZZZ)Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getAddressConfirmationError", "getNoErrors", "noErrors", AuthSource.BOOKING_ORDER, "Z", "getHasNetworkErrorOnConfirmation", g.a, "getNoSuggestsError", "j", "getAdvertsCountNetworkError", AuthSource.SEND_ABUSE, "getHasGeneralNetworkError", "e", "getNotGrantedPermissionError", "h", "getEmptyAddressError", "d", "getUnknownError", "f", "getNotSuggestedAddressError", "i", "getAdvertsCountError", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;ZZZZZZ)V", "(Landroid/os/Parcel;)V", "CREATOR", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerErrors implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final boolean a;
    public final boolean b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location_picker/entities/LocationPickerErrors$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "", "size", "", "newArray", "(I)[Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<LocationPickerErrors> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public LocationPickerErrors createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationPickerErrors(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public LocationPickerErrors[] newArray(int i) {
            return new LocationPickerErrors[i];
        }
    }

    public LocationPickerErrors() {
        this(false, false, null, null, false, false, false, false, false, false, 1023, null);
    }

    public LocationPickerErrors(boolean z, boolean z2, @Nullable String str, @Nullable String str2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = str2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z7;
        this.i = z8;
        this.j = z9;
    }

    public static /* synthetic */ LocationPickerErrors copy$default(LocationPickerErrors locationPickerErrors, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9, int i2, Object obj) {
        return locationPickerErrors.copy((i2 & 1) != 0 ? locationPickerErrors.a : z, (i2 & 2) != 0 ? locationPickerErrors.b : z2, (i2 & 4) != 0 ? locationPickerErrors.c : str, (i2 & 8) != 0 ? locationPickerErrors.d : str2, (i2 & 16) != 0 ? locationPickerErrors.e : z3, (i2 & 32) != 0 ? locationPickerErrors.f : z4, (i2 & 64) != 0 ? locationPickerErrors.g : z5, (i2 & 128) != 0 ? locationPickerErrors.h : z7, (i2 & 256) != 0 ? locationPickerErrors.i : z8, (i2 & 512) != 0 ? locationPickerErrors.j : z9);
    }

    public final boolean component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    public final boolean component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final LocationPickerErrors copy(boolean z, boolean z2, @Nullable String str, @Nullable String str2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9) {
        return new LocationPickerErrors(z, z2, str, str2, z3, z4, z5, z7, z8, z9);
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
        if (!(obj instanceof LocationPickerErrors)) {
            return false;
        }
        LocationPickerErrors locationPickerErrors = (LocationPickerErrors) obj;
        return this.a == locationPickerErrors.a && this.b == locationPickerErrors.b && Intrinsics.areEqual(this.c, locationPickerErrors.c) && Intrinsics.areEqual(this.d, locationPickerErrors.d) && this.e == locationPickerErrors.e && this.f == locationPickerErrors.f && this.g == locationPickerErrors.g && this.h == locationPickerErrors.h && this.i == locationPickerErrors.i && this.j == locationPickerErrors.j;
    }

    @Nullable
    public final String getAddressConfirmationError() {
        return this.c;
    }

    public final boolean getAdvertsCountError() {
        return this.i;
    }

    public final boolean getAdvertsCountNetworkError() {
        return this.j;
    }

    public final boolean getEmptyAddressError() {
        return this.h;
    }

    public final boolean getHasGeneralNetworkError() {
        return this.a;
    }

    public final boolean getHasNetworkErrorOnConfirmation() {
        return this.b;
    }

    public final boolean getNoErrors() {
        return !(this.b || this.e || this.f || this.g || this.h || this.a || this.c != null || this.d != null || this.i || this.j);
    }

    public final boolean getNoSuggestsError() {
        return this.g;
    }

    public final boolean getNotGrantedPermissionError() {
        return this.e;
    }

    public final boolean getNotSuggestedAddressError() {
        return this.f;
    }

    @Nullable
    public final String getUnknownError() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.a;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = i3 * 31;
        boolean z2 = this.b;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        String str = this.c;
        int i11 = 0;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        int i12 = (hashCode + i11) * 31;
        boolean z3 = this.e;
        if (z3) {
            z3 = true;
        }
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = z3 ? 1 : 0;
        int i16 = (i12 + i13) * 31;
        boolean z4 = this.f;
        if (z4) {
            z4 = true;
        }
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = z4 ? 1 : 0;
        int i20 = (i16 + i17) * 31;
        boolean z5 = this.g;
        if (z5) {
            z5 = true;
        }
        int i21 = z5 ? 1 : 0;
        int i22 = z5 ? 1 : 0;
        int i23 = z5 ? 1 : 0;
        int i24 = (i20 + i21) * 31;
        boolean z7 = this.h;
        if (z7) {
            z7 = true;
        }
        int i25 = z7 ? 1 : 0;
        int i26 = z7 ? 1 : 0;
        int i27 = z7 ? 1 : 0;
        int i28 = (i24 + i25) * 31;
        boolean z8 = this.i;
        if (z8) {
            z8 = true;
        }
        int i29 = z8 ? 1 : 0;
        int i30 = z8 ? 1 : 0;
        int i31 = z8 ? 1 : 0;
        int i32 = (i28 + i29) * 31;
        boolean z9 = this.j;
        if (!z9) {
            i2 = z9 ? 1 : 0;
        }
        return i32 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocationPickerErrors(hasGeneralNetworkError=");
        L.append(this.a);
        L.append(", hasNetworkErrorOnConfirmation=");
        L.append(this.b);
        L.append(", addressConfirmationError=");
        L.append(this.c);
        L.append(", unknownError=");
        L.append(this.d);
        L.append(", notGrantedPermissionError=");
        L.append(this.e);
        L.append(", notSuggestedAddressError=");
        L.append(this.f);
        L.append(", noSuggestsError=");
        L.append(this.g);
        L.append(", emptyAddressError=");
        L.append(this.h);
        L.append(", advertsCountError=");
        L.append(this.i);
        L.append(", advertsCountNetworkError=");
        return a.B(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.a ? (byte) 1 : 0);
        parcel.writeByte(this.b ? (byte) 1 : 0);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeByte(this.j ? (byte) 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationPickerErrors(boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9, int i2, j jVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : str, (i2 & 8) == 0 ? str2 : null, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4, (i2 & 64) != 0 ? false : z5, (i2 & 128) != 0 ? false : z7, (i2 & 256) != 0 ? false : z8, (i2 & 512) == 0 ? z9 : false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationPickerErrors(@org.jetbrains.annotations.NotNull android.os.Parcel r17) {
        /*
            r16 = this;
            java.lang.String r0 = "parcel"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            byte r0 = r17.readByte()
            r2 = 0
            byte r3 = (byte) r2
            r4 = 1
            if (r0 == r3) goto L_0x0012
            r6 = 1
            goto L_0x0013
        L_0x0012:
            r6 = 0
        L_0x0013:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x001b
            r7 = 1
            goto L_0x001c
        L_0x001b:
            r7 = 0
        L_0x001c:
            java.lang.String r8 = r17.readString()
            java.lang.String r9 = r17.readString()
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x002c
            r10 = 1
            goto L_0x002d
        L_0x002c:
            r10 = 0
        L_0x002d:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x0035
            r11 = 1
            goto L_0x0036
        L_0x0035:
            r11 = 0
        L_0x0036:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x003e
            r12 = 1
            goto L_0x003f
        L_0x003e:
            r12 = 0
        L_0x003f:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x0047
            r13 = 1
            goto L_0x0048
        L_0x0047:
            r13 = 0
        L_0x0048:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x0050
            r14 = 1
            goto L_0x0051
        L_0x0050:
            r14 = 0
        L_0x0051:
            byte r0 = r17.readByte()
            if (r0 == r3) goto L_0x0059
            r15 = 1
            goto L_0x005a
        L_0x0059:
            r15 = 0
        L_0x005a:
            r5 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_picker.entities.LocationPickerErrors.<init>(android.os.Parcel):void");
    }
}

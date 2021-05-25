package com.avito.android.location_picker.entities;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0013\b\b\u0018\u0000 02\u00020\u0001:\u00010B1\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b-\u0010/J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\nJ\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\rR\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\rR\u0019\u0010\u0019\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0010¨\u00061"}, d2 = {"Lcom/avito/android/location_picker/entities/AddressValidationState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "chooseButtonIsActive", "()Z", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "component1", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "component2", "component3", "", "component4", "()Ljava/lang/String;", "validationRules", "currentAddressIsValid", "triggerValidateRadius", "error", "copy", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZLjava/lang/String;)Lcom/avito/android/location_picker/entities/AddressValidationState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getCurrentAddressIsValid", "c", "getTriggerValidateRadius", "d", "Ljava/lang/String;", "getError", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "getValidationRules", "<init>", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZLjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class AddressValidationState implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    public final AddressParameter.ValidationRules a;
    public final boolean b;
    public final boolean c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location_picker/entities/AddressValidationState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/location_picker/entities/AddressValidationState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/location_picker/entities/AddressValidationState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/location_picker/entities/AddressValidationState;", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AddressValidationState> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AddressValidationState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressValidationState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AddressValidationState[] newArray(int i) {
            return new AddressValidationState[i];
        }
    }

    public AddressValidationState() {
        this(null, false, false, null, 15, null);
    }

    public AddressValidationState(@Nullable AddressParameter.ValidationRules validationRules, boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.a = validationRules;
        this.b = z;
        this.c = z2;
        this.d = str;
    }

    public static /* synthetic */ AddressValidationState copy$default(AddressValidationState addressValidationState, AddressParameter.ValidationRules validationRules, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            validationRules = addressValidationState.a;
        }
        if ((i & 2) != 0) {
            z = addressValidationState.b;
        }
        if ((i & 4) != 0) {
            z2 = addressValidationState.c;
        }
        if ((i & 8) != 0) {
            str = addressValidationState.d;
        }
        return addressValidationState.copy(validationRules, z, z2, str);
    }

    public final boolean chooseButtonIsActive() {
        if (this.a != null) {
            if (!this.b) {
                return false;
            }
            if (!(this.d.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final AddressParameter.ValidationRules component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final AddressValidationState copy(@Nullable AddressParameter.ValidationRules validationRules, boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        return new AddressValidationState(validationRules, z, z2, str);
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
        if (!(obj instanceof AddressValidationState)) {
            return false;
        }
        AddressValidationState addressValidationState = (AddressValidationState) obj;
        return Intrinsics.areEqual(this.a, addressValidationState.a) && this.b == addressValidationState.b && this.c == addressValidationState.c && Intrinsics.areEqual(this.d, addressValidationState.d);
    }

    public final boolean getCurrentAddressIsValid() {
        return this.b;
    }

    @NotNull
    public final String getError() {
        return this.d;
    }

    public final boolean getTriggerValidateRadius() {
        return this.c;
    }

    @Nullable
    public final AddressParameter.ValidationRules getValidationRules() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AddressParameter.ValidationRules validationRules = this.a;
        int i = 0;
        int hashCode = (validationRules != null ? validationRules.hashCode() : 0) * 31;
        boolean z = this.b;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean z2 = this.c;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        String str = this.d;
        if (str != null) {
            i = str.hashCode();
        }
        return i7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AddressValidationState(validationRules=");
        L.append(this.a);
        L.append(", currentAddressIsValid=");
        L.append(this.b);
        L.append(", triggerValidateRadius=");
        L.append(this.c);
        L.append(", error=");
        return a.t(L, this.d, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeByte(this.b ? (byte) 1 : 0);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeString(this.d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddressValidationState(@org.jetbrains.annotations.NotNull android.os.Parcel r7) {
        /*
            r6 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Class<com.avito.android.remote.model.category_parameters.AddressParameter$ValidationRules> r0 = com.avito.android.remote.model.category_parameters.AddressParameter.ValidationRules.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r7.readParcelable(r0)
            com.avito.android.remote.model.category_parameters.AddressParameter$ValidationRules r0 = (com.avito.android.remote.model.category_parameters.AddressParameter.ValidationRules) r0
            byte r1 = r7.readByte()
            r2 = 0
            byte r3 = (byte) r2
            r4 = 1
            if (r1 == r3) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            byte r5 = r7.readByte()
            if (r5 == r3) goto L_0x0024
            r2 = 1
        L_0x0024:
            java.lang.String r7 = r7.readString()
            if (r7 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            java.lang.String r7 = ""
        L_0x002d:
            java.lang.String r3 = "parcel.readString() ?: emptyString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            r6.<init>(r0, r1, r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_picker.entities.AddressValidationState.<init>(android.os.Parcel):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressValidationState(AddressParameter.ValidationRules validationRules, boolean z, boolean z2, String str, int i, j jVar) {
        this((i & 1) != 0 ? null : validationRules, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? "" : str);
    }
}

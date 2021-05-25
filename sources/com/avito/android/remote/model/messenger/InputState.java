package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b!\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J2\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\u0012\u0010\r¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/messenger/InputState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "isDisabled", "reason", "description", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/InputState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReason", "getDescription", "Z", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "models_release"}, k = 1, mv = {1, 4, 2})
public final class InputState implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("isDisabled")
    private final boolean isDisabled;
    @SerializedName("reason")
    @Nullable
    private final String reason;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/messenger/InputState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/messenger/InputState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/messenger/InputState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/messenger/InputState;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<InputState> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public InputState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InputState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public InputState[] newArray(int i) {
            return new InputState[i];
        }
    }

    public InputState(boolean z, @Nullable String str, @Nullable String str2) {
        this.isDisabled = z;
        this.reason = str;
        this.description = str2;
    }

    public static /* synthetic */ InputState copy$default(InputState inputState, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inputState.isDisabled;
        }
        if ((i & 2) != 0) {
            str = inputState.reason;
        }
        if ((i & 4) != 0) {
            str2 = inputState.description;
        }
        return inputState.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.isDisabled;
    }

    @Nullable
    public final String component2() {
        return this.reason;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final InputState copy(boolean z, @Nullable String str, @Nullable String str2) {
        return new InputState(z, str, str2);
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
        if (!(obj instanceof InputState)) {
            return false;
        }
        InputState inputState = (InputState) obj;
        return this.isDisabled == inputState.isDisabled && Intrinsics.areEqual(this.reason, inputState.reason) && Intrinsics.areEqual(this.description, inputState.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.isDisabled;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.reason;
        int i5 = 0;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return hashCode + i5;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("InputState(isDisabled=");
        L.append(this.isDisabled);
        L.append(", reason=");
        L.append(this.reason);
        L.append(", description=");
        return a.t(L, this.description, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isDisabled ? (byte) 1 : 0);
        parcel.writeString(this.reason);
        parcel.writeString(this.description);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InputState(@NotNull Parcel parcel) {
        this(parcel.readByte() != ((byte) 0), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}

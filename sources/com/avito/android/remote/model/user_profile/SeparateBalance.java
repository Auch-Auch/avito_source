package com.avito.android.remote.model.user_profile;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "real", "Ljava/lang/String;", "getReal", "()Ljava/lang/String;", TariffCountPayloadCreator.PAYLOAD_BONUS, "getBonus", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SeparateBalance implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName(TariffCountPayloadCreator.PAYLOAD_BONUS)
    @NotNull
    private final String bonus;
    @SerializedName("real")
    @NotNull
    private final String real;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/user_profile/SeparateBalance$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<SeparateBalance> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SeparateBalance createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SeparateBalance(a.u2(parcel, "parcel.readString()!!"), a.u2(parcel, "parcel.readString()!!"));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public SeparateBalance[] newArray(int i) {
            return new SeparateBalance[i];
        }
    }

    public SeparateBalance(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "real");
        Intrinsics.checkNotNullParameter(str2, TariffCountPayloadCreator.PAYLOAD_BONUS);
        this.real = str;
        this.bonus = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getBonus() {
        return this.bonus;
    }

    @NotNull
    public final String getReal() {
        return this.real;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.real);
        parcel.writeString(this.bonus);
    }
}

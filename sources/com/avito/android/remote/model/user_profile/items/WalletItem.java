package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.user_profile.SeparateBalance;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/WalletItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "separate", "Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "getSeparate", "()Lcom/avito/android/remote/model/user_profile/SeparateBalance;", "", "balance", "Ljava/lang/String;", "getBalance", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/SeparateBalance;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class WalletItem extends UserProfileItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WalletItem> CREATOR = Parcels.creator(WalletItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("balance")
    @NotNull
    private final String balance;
    @SerializedName("separate")
    @Nullable
    private final SeparateBalance separate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/WalletItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/items/WalletItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletItem(String str, SeparateBalance separateBalance, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : separateBalance);
    }

    @NotNull
    public final String getBalance() {
        return this.balance;
    }

    @Nullable
    public final SeparateBalance getSeparate() {
        return this.separate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.balance);
        parcel.writeParcelable(this.separate, i);
    }

    public WalletItem(@NotNull String str, @Nullable SeparateBalance separateBalance) {
        Intrinsics.checkNotNullParameter(str, "balance");
        this.balance = str;
        this.separate = separateBalance;
    }
}

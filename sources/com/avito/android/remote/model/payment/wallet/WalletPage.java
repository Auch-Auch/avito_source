package com.avito.android.remote.model.payment.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/payment/wallet/WalletBalance;", "balance", "Lcom/avito/android/remote/model/payment/wallet/WalletBalance;", "getBalance", "()Lcom/avito/android/remote/model/payment/wallet/WalletBalance;", "Lcom/avito/android/remote/model/Action;", "secondaryAction", "Lcom/avito/android/remote/model/Action;", "getSecondaryAction", "()Lcom/avito/android/remote/model/Action;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "primaryAction", "getPrimaryAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/payment/wallet/WalletBalance;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Action;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WalletPage implements Parcelable {
    public static final Parcelable.Creator<WalletPage> CREATOR = new Creator();
    @SerializedName("balance")
    @NotNull
    private final WalletBalance balance;
    @SerializedName("primaryAction")
    @Nullable
    private final Action primaryAction;
    @SerializedName("secondaryAction")
    @Nullable
    private final Action secondaryAction;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<WalletPage> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WalletPage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new WalletPage(parcel.readString(), (WalletBalance) parcel.readParcelable(WalletPage.class.getClassLoader()), (Action) parcel.readParcelable(WalletPage.class.getClassLoader()), (Action) parcel.readParcelable(WalletPage.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WalletPage[] newArray(int i) {
            return new WalletPage[i];
        }
    }

    public WalletPage(@NotNull String str, @NotNull WalletBalance walletBalance, @Nullable Action action, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(walletBalance, "balance");
        this.title = str;
        this.balance = walletBalance;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final WalletBalance getBalance() {
        return this.balance;
    }

    @Nullable
    public final Action getPrimaryAction() {
        return this.primaryAction;
    }

    @Nullable
    public final Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.balance, i);
        parcel.writeParcelable(this.primaryAction, i);
        parcel.writeParcelable(this.secondaryAction, i);
    }
}

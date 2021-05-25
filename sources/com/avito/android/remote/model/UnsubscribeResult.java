package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/UnsubscribeResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/FavoriteSellerCounter;", "subscriptions", "Lcom/avito/android/remote/model/FavoriteSellerCounter;", "getSubscriptions", "()Lcom/avito/android/remote/model/FavoriteSellerCounter;", SubscribersReadInteractor.TYPE, "getSubscribers", "<init>", "(Lcom/avito/android/remote/model/FavoriteSellerCounter;Lcom/avito/android/remote/model/FavoriteSellerCounter;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class UnsubscribeResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UnsubscribeResult> CREATOR = Parcels.creator(UnsubscribeResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(SubscribersReadInteractor.TYPE)
    @Nullable
    private final FavoriteSellerCounter subscribers;
    @SerializedName("subscriptions")
    @Nullable
    private final FavoriteSellerCounter subscriptions;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/UnsubscribeResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/UnsubscribeResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public UnsubscribeResult(@Nullable FavoriteSellerCounter favoriteSellerCounter, @Nullable FavoriteSellerCounter favoriteSellerCounter2) {
        this.subscriptions = favoriteSellerCounter;
        this.subscribers = favoriteSellerCounter2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final FavoriteSellerCounter getSubscribers() {
        return this.subscribers;
    }

    @Nullable
    public final FavoriteSellerCounter getSubscriptions() {
        return this.subscriptions;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.subscriptions, i);
        parcel.writeParcelable(this.subscribers, i);
    }
}

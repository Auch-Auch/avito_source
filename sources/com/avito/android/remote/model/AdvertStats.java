package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/AdvertStats;", "Landroid/os/Parcelable;", "", "hasCounters", "()Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AdvertStatsContact;", "contacts", "Lcom/avito/android/remote/model/AdvertStatsContact;", "getContacts", "()Lcom/avito/android/remote/model/AdvertStatsContact;", "today", "Ljava/lang/Integer;", "getToday", "()Ljava/lang/Integer;", "total", "getTotal", FavoritesContract.TABLE_NAME, "getFavorites", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/AdvertStatsContact;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStats implements Parcelable {
    public static final Parcelable.Creator<AdvertStats> CREATOR = new Creator();
    @Nullable
    private final AdvertStatsContact contacts;
    @Nullable
    private final DeepLink deepLink;
    @Nullable
    private final Integer favorites;
    @Nullable
    private final Integer today;
    @Nullable
    private final Integer total;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertStats> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStats createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertStats(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (DeepLink) parcel.readParcelable(AdvertStats.class.getClassLoader()), parcel.readInt() != 0 ? AdvertStatsContact.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStats[] newArray(int i) {
            return new AdvertStats[i];
        }
    }

    public AdvertStats(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable DeepLink deepLink2, @Nullable AdvertStatsContact advertStatsContact) {
        this.total = num;
        this.today = num2;
        this.favorites = num3;
        this.deepLink = deepLink2;
        this.contacts = advertStatsContact;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdvertStatsContact getContacts() {
        return this.contacts;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final Integer getFavorites() {
        return this.favorites;
    }

    @Nullable
    public final Integer getToday() {
        return this.today;
    }

    @Nullable
    public final Integer getTotal() {
        return this.total;
    }

    public final boolean hasCounters() {
        return (this.total == null || this.today == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.total;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.today;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.favorites;
        if (num3 != null) {
            a.H0(parcel, 1, num3);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.deepLink, i);
        AdvertStatsContact advertStatsContact = this.contacts;
        if (advertStatsContact != null) {
            parcel.writeInt(1);
            advertStatsContact.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}

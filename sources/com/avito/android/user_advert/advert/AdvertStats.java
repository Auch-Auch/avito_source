package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStatsContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017¨\u0006'"}, d2 = {"Lcom/avito/android/user_advert/advert/AdvertStats;", "Landroid/os/Parcelable;", "", "hasCounters", "()Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getTotal", "()Ljava/lang/Integer;", "total", AuthSource.BOOKING_ORDER, "getToday", "today", "Lcom/avito/android/remote/model/AdvertStatsContact;", "e", "Lcom/avito/android/remote/model/AdvertStatsContact;", "getContacts", "()Lcom/avito/android/remote/model/AdvertStatsContact;", "contacts", "c", "getFavorites", FavoritesContract.TABLE_NAME, "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/AdvertStatsContact;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStats implements Parcelable {
    public static final Parcelable.Creator<AdvertStats> CREATOR = new Creator();
    @Nullable
    public final Integer a;
    @Nullable
    public final Integer b;
    @Nullable
    public final Integer c;
    @Nullable
    public final DeepLink d;
    @Nullable
    public final AdvertStatsContact e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertStats> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStats createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertStats(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (DeepLink) parcel.readParcelable(AdvertStats.class.getClassLoader()), (AdvertStatsContact) parcel.readParcelable(AdvertStats.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertStats[] newArray(int i) {
            return new AdvertStats[i];
        }
    }

    public AdvertStats(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable DeepLink deepLink, @Nullable AdvertStatsContact advertStatsContact) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = deepLink;
        this.e = advertStatsContact;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdvertStatsContact getContacts() {
        return this.e;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.d;
    }

    @Nullable
    public final Integer getFavorites() {
        return this.c;
    }

    @Nullable
    public final Integer getToday() {
        return this.b;
    }

    @Nullable
    public final Integer getTotal() {
        return this.a;
    }

    public final boolean hasCounters() {
        return (this.a == null || this.b == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.a;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.b;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.c;
        if (num3 != null) {
            a.H0(parcel, 1, num3);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
    }
}

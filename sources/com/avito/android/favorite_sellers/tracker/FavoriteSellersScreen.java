package com.avito.android.favorite_sellers.tracker;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/favorite_sellers/tracker/FavoriteSellersScreen;", "Lcom/avito/android/analytics/screens/Screen;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersScreen extends Screen {
    public static final Parcelable.Creator<FavoriteSellersScreen> CREATOR = new Creator();
    @NotNull
    public static final FavoriteSellersScreen INSTANCE = new FavoriteSellersScreen();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FavoriteSellersScreen> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteSellersScreen createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                return FavoriteSellersScreen.INSTANCE;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteSellersScreen[] newArray(int i) {
            return new FavoriteSellersScreen[i];
        }
    }

    public FavoriteSellersScreen() {
        super("FavoriteSellers", false, 2, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(1);
    }
}

package com.avito.android.advert_stats.remote.model;

import com.avito.android.db.FavoritesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_stats/remote/model/ViewsStat;", "", "", "vasViews", "Ljava/lang/Integer;", "getVasViews", "()Ljava/lang/Integer;", "contacts", "I", "getContacts", "()I", FavoritesContract.TABLE_NAME, "getFavorites", "views", "getViews", "<init>", "(ILjava/lang/Integer;II)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class ViewsStat {
    @SerializedName("contacts")
    private final int contacts;
    @SerializedName(FavoritesContract.TABLE_NAME)
    private final int favorites;
    @SerializedName("vasViews")
    @Nullable
    private final Integer vasViews;
    @SerializedName("views")
    private final int views;

    public ViewsStat(int i, @Nullable Integer num, int i2, int i3) {
        this.views = i;
        this.vasViews = num;
        this.contacts = i2;
        this.favorites = i3;
    }

    public final int getContacts() {
        return this.contacts;
    }

    public final int getFavorites() {
        return this.favorites;
    }

    @Nullable
    public final Integer getVasViews() {
        return this.vasViews;
    }

    public final int getViews() {
        return this.views;
    }
}

package com.avito.android.favorites.adapter.error;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/favorites/adapter/error/FavoriteErrorItem;", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "getStringId$annotations", "()V", "stringId", AuthSource.BOOKING_ORDER, "getMessage", "message", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getFailedUri", "()Landroid/net/Uri;", "failedUri", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteErrorItem implements FavoriteListItem {
    public static final Parcelable.Creator<FavoriteErrorItem> CREATOR = new Creator();
    @NotNull
    public final String a = "favorite_error";
    @NotNull
    public final String b;
    @NotNull
    public final Uri c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FavoriteErrorItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteErrorItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FavoriteErrorItem(parcel.readString(), (Uri) parcel.readParcelable(FavoriteErrorItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FavoriteErrorItem[] newArray(int i) {
            return new FavoriteErrorItem[i];
        }
    }

    public FavoriteErrorItem(@NotNull String str, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(uri, "failedUri");
        this.b = str;
        this.c = uri;
    }

    public static /* synthetic */ void getStringId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Uri getFailedUri() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteListItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getMessage() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
    }
}

package com.avito.android.favorite_sellers.adapter.error;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0019\u001a\u00020\u00188\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/error/ErrorItem;", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getFailedUri", "()Landroid/net/Uri;", "failedUri", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "isEditable", "Z", "()Z", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorItem implements FavoriteSellersItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ErrorItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a = ErrorSnippetItem.ID;
    @NotNull
    public final String b;
    @NotNull
    public final Uri c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/error/ErrorItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/favorite_sellers/adapter/error/ErrorItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ErrorItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ErrorItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ErrorItem(a2.b.a.a.a.u2(parcel2, "readString()!!"), (Uri) a2.b.a.a.a.z1(Uri.class, parcel2));
        }
    }

    public ErrorItem(@NotNull String str, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(uri, "failedUri");
        this.b = str;
        this.c = uri;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem, android.os.Parcelable
    public int describeContents() {
        return FavoriteSellersItem.DefaultImpls.describeContents(this);
    }

    @NotNull
    public final Uri getFailedUri() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteSellersItem.DefaultImpls.getId(this);
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

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem
    public boolean isEditable() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
    }
}

package com.avito.android.remote.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B3\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\nR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSellersResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "totalCount", "I", "getTotalCount", "", "Lcom/avito/android/remote/model/FavoriteSellersResultItem;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "xHash", "Ljava/lang/String;", "getXHash", "()Ljava/lang/String;", "Landroid/net/Uri;", "nextPage", "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "<init>", "(Ljava/util/List;Landroid/net/Uri;ILjava/lang/String;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FavoriteSellersResult> CREATOR = Parcels.creator(FavoriteSellersResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("list")
    @Nullable
    private final List<FavoriteSellersResultItem> list;
    @SerializedName("nextPage")
    @Nullable
    private final Uri nextPage;
    @SerializedName("totalCount")
    private final int totalCount;
    @SerializedName("xHash")
    @Nullable
    private final String xHash;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSellersResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.FavoriteSellersResultItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public FavoriteSellersResult(@Nullable List<? extends FavoriteSellersResultItem> list2, @Nullable Uri uri, int i, @Nullable String str) {
        this.list = list2;
        this.nextPage = uri;
        this.totalCount = i;
        this.xHash = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<FavoriteSellersResultItem> getList() {
        return this.list;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.nextPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    @Nullable
    public final String getXHash() {
        return this.xHash;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.list, 0, 2, null);
        parcel.writeParcelable(this.nextPage, i);
        parcel.writeInt(this.totalCount);
        parcel.writeString(this.xHash);
    }
}

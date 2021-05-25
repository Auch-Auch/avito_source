package com.avito.android.favorites;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsDataSource;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "", "close", "()V", "Lcom/avito/android/favorite/FavoriteModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/CloseableDataSource;", "dataSource", "getCount", "()I", "count", "<init>", "(Lcom/avito/android/remote/model/CloseableDataSource;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsDataSource implements CloseableDataSource<FavoriteAdvertItem> {
    public final CloseableDataSource<FavoriteModel> a;

    public FavoriteAdvertsDataSource(@NotNull CloseableDataSource<FavoriteModel> closeableDataSource) {
        Intrinsics.checkNotNullParameter(closeableDataSource, "dataSource");
        this.a = closeableDataSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public FavoriteAdvertItem getItem(int i) {
        return FavoriteAdvertItem.Companion.fromFavoriteModel(this.a.getItem(i));
    }
}

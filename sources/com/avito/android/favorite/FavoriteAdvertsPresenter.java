package com.avito.android.favorite;

import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\u00042\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/favorite/FavoriteAdvertsView;)V", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "attachErrorMessageView", "(Lcom/avito/android/legacy_mvp/ErrorMessageView;)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", "detachViews", "()V", "wipeSynchronizedIds", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/FavorableItem;", "subscribeToFavoriteButtonClicked", "()Lio/reactivex/rxjava3/core/Observable;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertsPresenter extends FavoriteButtonClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.favorite.FavoriteAdvertsPresenter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onSecondaryDataSourcesChanged$default(FavoriteAdvertsPresenter favoriteAdvertsPresenter, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    list = null;
                }
                favoriteAdvertsPresenter.onSecondaryDataSourcesChanged(list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSecondaryDataSourcesChanged");
        }
    }

    void attachErrorMessageView(@NotNull ErrorMessageView errorMessageView);

    void attachView(@NotNull FavoriteAdvertsView favoriteAdvertsView);

    void detachViews();

    void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource);

    void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list);

    @NotNull
    Observable<FavorableItem> subscribeToFavoriteButtonClicked();

    void wipeSynchronizedIds();
}

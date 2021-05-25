package com.avito.android.favorite_sellers.adapter.loading;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.loading.action.LoadingItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItemView;", "view", "Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItemView;Lcom/avito/android/favorite_sellers/adapter/loading/LoadingItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class LoadingItemPresenterImpl implements LoadingItemPresenter {
    public final Consumer<FavoriteSellersItemAction> a;

    @Inject
    public LoadingItemPresenterImpl(@NotNull Consumer<FavoriteSellersItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "bindConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull LoadingItemView loadingItemView, @NotNull LoadingItem loadingItem, int i) {
        Intrinsics.checkNotNullParameter(loadingItemView, "view");
        Intrinsics.checkNotNullParameter(loadingItem, "item");
        this.a.accept(new LoadingItemAction.NextPage(loadingItem.getNextPage()));
    }
}

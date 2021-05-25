package com.avito.android.user_adverts.tab_screens.advert_list.loading;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenterImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenter;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemView;", "view", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemView;Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionConsumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "bindConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LoadingItemPresenterImpl implements LoadingItemPresenter {
    public final Consumer<UserAdvertItemAction> a;

    @Inject
    public LoadingItemPresenterImpl(@NotNull Consumer<UserAdvertItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "bindConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull LoadingItemView loadingItemView, @NotNull LoadingItem loadingItem, int i) {
        Intrinsics.checkNotNullParameter(loadingItemView, "view");
        Intrinsics.checkNotNullParameter(loadingItem, "item");
        this.a.accept(new LoadMoreAction());
    }
}

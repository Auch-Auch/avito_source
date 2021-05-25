package com.avito.android.favorites.adapter.error;

import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.adapter.error.action.FavoriteErrorItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenter;", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemView;", "view", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemView;Lcom/avito/android/favorites/adapter/error/FavoriteErrorItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/favorites/action/FavoriteItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteErrorItemPresenterImpl implements FavoriteErrorItemPresenter {
    public final Consumer<FavoriteItemAction> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoriteErrorItemPresenterImpl a;
        public final /* synthetic */ FavoriteErrorItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FavoriteErrorItemPresenterImpl favoriteErrorItemPresenterImpl, FavoriteErrorItem favoriteErrorItem) {
            super(0);
            this.a = favoriteErrorItemPresenterImpl;
            this.b = favoriteErrorItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(new FavoriteErrorItemAction(this.b.getFailedUri()));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoriteErrorItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FavoriteErrorItemView favoriteErrorItemView) {
            super(0);
            this.a = favoriteErrorItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setRefreshListener(null);
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public FavoriteErrorItemPresenterImpl(@NotNull Consumer<FavoriteItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull FavoriteErrorItemView favoriteErrorItemView, @NotNull FavoriteErrorItem favoriteErrorItem, int i) {
        Intrinsics.checkNotNullParameter(favoriteErrorItemView, "view");
        Intrinsics.checkNotNullParameter(favoriteErrorItem, "item");
        favoriteErrorItemView.setMessage(favoriteErrorItem.getMessage());
        favoriteErrorItemView.setRefreshListener(new a(this, favoriteErrorItem));
        favoriteErrorItemView.setUnbindListener(new b(favoriteErrorItemView));
    }
}

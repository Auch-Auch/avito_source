package com.avito.android.rating.publish.select_advert.adapter.loading;

import com.avito.android.di.PerFragment;
import com.avito.android.rating.details.adapter.loading.LoadingItemBlueprint;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenter;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/loading/LoadingItemModule;", "", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", "provideLoadingItemShownAction$rating_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideLoadingItemShownAction", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class LoadingItemModule {
    @NotNull
    public static final LoadingItemModule INSTANCE = new LoadingItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/loading/LoadingItemModule$Declarations;", "", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenterImpl;", "impl", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenter;", "bindItemPresenter", "(Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenterImpl;)Lcom/avito/android/rating/details/adapter/loading/LoadingItemPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", "Lio/reactivex/rxjava3/functions/Consumer;", "provideLoadingItemShownConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/core/Observable;", "provideLoadingItemShownObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        LoadingItemPresenter bindItemPresenter(@NotNull LoadingItemPresenterImpl loadingItemPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<LoadingItemNextPageAction> provideLoadingItemShownConsumer(@NotNull PublishRelay<LoadingItemNextPageAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<LoadingItemNextPageAction> provideLoadingItemShownObservable(@NotNull PublishRelay<LoadingItemNextPageAction> publishRelay);
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerFragment
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull LoadingItemPresenter loadingItemPresenter) {
        Intrinsics.checkNotNullParameter(loadingItemPresenter, "presenter");
        return new LoadingItemBlueprint(loadingItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<LoadingItemNextPageAction> provideLoadingItemShownAction$rating_release() {
        PublishRelay<LoadingItemNextPageAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<LoadingItemNextPageAction>()");
        return create;
    }
}

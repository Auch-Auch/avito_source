package com.avito.android.rating.publish.select_advert.di;

import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.publish.select_advert.SelectAdvertInteractor;
import com.avito.android.rating.publish.select_advert.SelectAdvertInteractorImpl;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenter;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistryImpl;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenterImpl;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "provideItemClicksStream$rating_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideItemClicksStream", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry$rating_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideResponsiveItemPresenterRegistry", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "callableResponsiveItemPresenterRegistry", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter$rating_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class SelectAdvertModule {
    @NotNull
    public static final SelectAdvertModule INSTANCE = new SelectAdvertModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertModule$Declarations;", "", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractorImpl;", "interactor", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "bindSelectAdvertInteractor", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractorImpl;)Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "bindSelectAdvertPresenter", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenterImpl;)Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        Consumer<SelectAdvertAction> bindConsumer(@NotNull PublishRelay<SelectAdvertAction> publishRelay);

        @Binds
        @NotNull
        Observable<SelectAdvertAction> bindObservable(@NotNull PublishRelay<SelectAdvertAction> publishRelay);

        @Binds
        @NotNull
        SelectAdvertInteractor bindSelectAdvertInteractor(@NotNull SelectAdvertInteractorImpl selectAdvertInteractorImpl);

        @Binds
        @NotNull
        SelectAdvertPresenter bindSelectAdvertPresenter(@NotNull SelectAdvertPresenterImpl selectAdvertPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ResponsiveAdapterPresenter provideAdapterPresenter$rating_release(@NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "callableResponsiveItemPresenterRegistry");
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<RatingDetailsItem> provideItemClicksStream$rating_release() {
        PublishRelay<RatingDetailsItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CallableResponsiveItemPresenterRegistry provideResponsiveItemPresenterRegistry$rating_release() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }
}

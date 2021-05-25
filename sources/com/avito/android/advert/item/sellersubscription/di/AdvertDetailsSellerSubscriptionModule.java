package com.avito.android.advert.item.sellersubscription.di;

import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenterImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionInteractor;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionInteractorImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProviderImpl;
import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationInteractor;
import com.avito.android.util.preferences.GeoContract;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/di/AdvertDetailsSellerSubscriptionModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/advert/item/sellersubscription/action/SellerSubscriptionAction;", "provideRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AdvertDetailsSellerSubscriptionModule {
    @NotNull
    public static final AdvertDetailsSellerSubscriptionModule INSTANCE = new AdvertDetailsSellerSubscriptionModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H'¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H'¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/di/AdvertDetailsSellerSubscriptionModule$Declarations;", "", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenter;", "bindItemPresenter", "(Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenterImpl;)Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenter;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "bindSubscriptionPresenter", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl;)Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractorImpl;", "interactor", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;", "bindSubscriptionInteractor", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractorImpl;)Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "bindRecommendationInteractor", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;)Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationInteractor;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "bindSubscriptionResourceProvider", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProviderImpl;)Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/advert/item/sellersubscription/action/SellerSubscriptionAction;", "relay", "Lio/reactivex/rxjava3/functions/Consumer;", "bindActionConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/core/Observable;", "bindActionObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        Consumer<SellerSubscriptionAction> bindActionConsumer(@NotNull PublishRelay<SellerSubscriptionAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<SellerSubscriptionAction> bindActionObservable(@NotNull PublishRelay<SellerSubscriptionAction> publishRelay);

        @PerFragment
        @Binds
        @NotNull
        AdvertDetailsSellerSubscriptionPresenter bindItemPresenter(@NotNull AdvertDetailsSellerSubscriptionPresenterImpl advertDetailsSellerSubscriptionPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        RecommendationInteractor bindRecommendationInteractor(@NotNull SellerSubscriptionInteractor sellerSubscriptionInteractor);

        @PerFragment
        @Binds
        @NotNull
        SellerSubscriptionInteractor bindSubscriptionInteractor(@NotNull SellerSubscriptionInteractorImpl sellerSubscriptionInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerSubscriptionPresenter bindSubscriptionPresenter(@NotNull SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerSubscriptionResourceProvider bindSubscriptionResourceProvider(@NotNull SellerSubscriptionResourceProviderImpl sellerSubscriptionResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishRelay<SellerSubscriptionAction> provideRelay() {
        PublishRelay<SellerSubscriptionAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}

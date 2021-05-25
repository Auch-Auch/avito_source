package com.avito.android.user_advert.di;

import com.avito.android.advert_core.di.module.AdvertDeliveryBlockDataObservable;
import com.avito.android.advert_core.di.module.AdvertSellerShortTermRentObservable;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesObservable;
import com.avito.android.analytics.di.BivrostStatisticsModule;
import com.avito.android.di.PerActivity;
import com.avito.android.di.PerScreen;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.advert.DraftId;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivity;
import com.avito.android.user_advert.advert.feature_teasers.di.MyAdvertDetailsFeaturesTeasersModule;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerScreen
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_advert/di/MyDraftDetailsComponent;", "", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity;)V", "Builder", "DraftDetailsModule", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {MyAdvertDetailsDependencies.class}, modules = {MyDraftAdvertDetailsModule.class, DraftDetailsModule.class, MyAdvertDetailsFeaturesTeasersModule.class, BivrostStatisticsModule.class})
@PerActivity
public interface MyDraftDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/user_advert/di/MyDraftDetailsComponent$Builder;", "Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Lcom/avito/android/user_advert/di/MyDraftDetailsComponent;", "build", "()Lcom/avito/android/user_advert/di/MyDraftDetailsComponent;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder extends DetailsComponentBuilder<MyDraftDetailsComponent> {
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        @NotNull
        /* renamed from: build */
        MyDraftDetailsComponent mo95build();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_advert/di/MyDraftDetailsComponent$DraftDetailsModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "provideAdvertDeliveryBlockDataObservable", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "provideSellerShortTermRentObservable", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "provideMyAdvertSafeDealServicesObservable$user_advert_release", "()Lcom/jakewharton/rxrelay3/Relay;", "provideMyAdvertSafeDealServicesObservable", "Lcom/avito/android/user_advert/advert/DetailsId;", "detailsId", "", "provideAdvertId", "(Lcom/avito/android/user_advert/advert/DetailsId;)Ljava/lang/String;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static final class DraftDetailsModule {
        @NotNull
        public static final DraftDetailsModule INSTANCE = new DraftDetailsModule();

        @Provides
        @Reusable
        @NotNull
        @AdvertDeliveryBlockDataObservable
        public final PublishRelay<AdvertDeliveryC2C> provideAdvertDeliveryBlockDataObservable() {
            PublishRelay<AdvertDeliveryC2C> create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            return create;
        }

        @AdvertId
        @Provides
        @NotNull
        public final String provideAdvertId(@NotNull DetailsId detailsId) {
            Intrinsics.checkNotNullParameter(detailsId, "detailsId");
            return ((DraftId) detailsId).getDraftId();
        }

        @MyAdvertSafeDealServicesObservable
        @Provides
        @Reusable
        @NotNull
        public final Relay<MyAdvertSafeDeal> provideMyAdvertSafeDealServicesObservable$user_advert_release() {
            BehaviorRelay create = BehaviorRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
            return create;
        }

        @Provides
        @Reusable
        @NotNull
        @AdvertSellerShortTermRentObservable
        public final PublishRelay<AdvertSellerShortTermRent> provideSellerShortTermRentObservable() {
            PublishRelay<AdvertSellerShortTermRent> create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            return create;
        }
    }

    void inject(@NotNull MyAdvertDetailsActivity myAdvertDetailsActivity);
}

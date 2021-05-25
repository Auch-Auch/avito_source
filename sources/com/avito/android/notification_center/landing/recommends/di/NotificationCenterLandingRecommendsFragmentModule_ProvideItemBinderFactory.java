package com.avito.android.notification_center.landing.recommends.di;

import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemBlueprint;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsFragmentModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<NotificationCenterLandingRecommendsAdvertItemBlueprint> a;
    public final Provider<NotificationCenterLandingRecommendsHeaderItemBlueprint> b;
    public final Provider<NotificationCenterLandingRecommendsReviewItemBlueprint> c;
    public final Provider<NotificationCenterLandingRecommendsTitleItemBlueprint> d;

    public NotificationCenterLandingRecommendsFragmentModule_ProvideItemBinderFactory(Provider<NotificationCenterLandingRecommendsAdvertItemBlueprint> provider, Provider<NotificationCenterLandingRecommendsHeaderItemBlueprint> provider2, Provider<NotificationCenterLandingRecommendsReviewItemBlueprint> provider3, Provider<NotificationCenterLandingRecommendsTitleItemBlueprint> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static NotificationCenterLandingRecommendsFragmentModule_ProvideItemBinderFactory create(Provider<NotificationCenterLandingRecommendsAdvertItemBlueprint> provider, Provider<NotificationCenterLandingRecommendsHeaderItemBlueprint> provider2, Provider<NotificationCenterLandingRecommendsReviewItemBlueprint> provider3, Provider<NotificationCenterLandingRecommendsTitleItemBlueprint> provider4) {
        return new NotificationCenterLandingRecommendsFragmentModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4);
    }

    public static ItemBinder provideItemBinder(NotificationCenterLandingRecommendsAdvertItemBlueprint notificationCenterLandingRecommendsAdvertItemBlueprint, NotificationCenterLandingRecommendsHeaderItemBlueprint notificationCenterLandingRecommendsHeaderItemBlueprint, NotificationCenterLandingRecommendsReviewItemBlueprint notificationCenterLandingRecommendsReviewItemBlueprint, NotificationCenterLandingRecommendsTitleItemBlueprint notificationCenterLandingRecommendsTitleItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(NotificationCenterLandingRecommendsFragmentModule.INSTANCE.provideItemBinder(notificationCenterLandingRecommendsAdvertItemBlueprint, notificationCenterLandingRecommendsHeaderItemBlueprint, notificationCenterLandingRecommendsReviewItemBlueprint, notificationCenterLandingRecommendsTitleItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}

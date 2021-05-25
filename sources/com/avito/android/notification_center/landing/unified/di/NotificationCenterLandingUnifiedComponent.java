package com.avito.android.notification_center.landing.unified.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivity;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.Relay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent;", "", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedActivity;", "activity", "", "inject", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedActivity;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationCenterLandingUnifiedDependencies.class}, modules = {NotificationCenterLandingUnifiedModule.class})
@PerActivity
public interface NotificationCenterLandingUnifiedComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011H'¢\u0006\u0004\b\u0018\u0010\u0015J\u001d\u0010\u001b\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H'¢\u0006\u0004\b\u001b\u0010\u0015J\u001f\u0010\u001e\u001a\u00020\u00002\u000e\b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011H'¢\u0006\u0004\b\u001e\u0010\u0015J\u001f\u0010 \u001a\u00020\u00002\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011H'¢\u0006\u0004\b \u0010\u0015J\u001d\u0010#\u001a\u00020\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0011H'¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedDependencies;)Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "", "id", "withId", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "advertClickRelay", "withAdvertClickRelay", "(Lcom/jakewharton/rxrelay2/Relay;)Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent$Builder;", "Lcom/avito/android/serp/adapter/FavorableItem;", "advertFavoriteRelay", "withAdvertFavoriteRelay", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonItem;", "buttonClickRelay", "withButtonClickRelay", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;", "pairButtonFirstClickRelay", "withPairButtonFirstClickRelay", "pairButtonSecondClickRelay", "withPairButtonSecondClickRelay", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItem;", "subtitleClickRelay", "withSubtitleClickRelay", "Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent;", "build", "()Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationCenterLandingUnifiedComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationCenterLandingUnifiedDependencies notificationCenterLandingUnifiedDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertClickRelay(@NotNull Relay<UnifiedAdvertItem> relay);

        @BindsInstance
        @NotNull
        Builder withAdvertFavoriteRelay(@NotNull Relay<FavorableItem> relay);

        @BindsInstance
        @NotNull
        Builder withButtonClickRelay(@NotNull Relay<UnifiedButtonItem> relay);

        @BindsInstance
        @NotNull
        Builder withId(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPairButtonFirstClickRelay(@ButtonFirst @NotNull Relay<UnifiedPairButtonItem> relay);

        @BindsInstance
        @NotNull
        Builder withPairButtonSecondClickRelay(@ButtonSecond @NotNull Relay<UnifiedPairButtonItem> relay);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSubtitleClickRelay(@NotNull Relay<UnifiedSubtitleItem> relay);
    }

    void inject(@NotNull NotificationCenterLandingUnifiedActivity notificationCenterLandingUnifiedActivity);
}

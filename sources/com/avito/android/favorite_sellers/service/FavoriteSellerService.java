package com.avito.android.favorite_sellers.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationButtonClickEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorite_sellers.service.di.DaggerFavoriteSellerServiceComponent;
import com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies;
import com.avito.android.util.IntentsKt;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/favorite_sellers/service/FavoriteSellerService;", "Landroid/app/IntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleIntent", "(Landroid/content/Intent;)V", "Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractor;", "interactor", "Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractor;", "getInteractor", "()Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractor;", "setInteractor", "(Lcom/avito/android/favorite_sellers/service/FavoriteSellerInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "Landroidx/core/app/NotificationManagerCompat;", "getNotificationManagerCompat", "()Landroidx/core/app/NotificationManagerCompat;", "setNotificationManagerCompat", "(Landroidx/core/app/NotificationManagerCompat;)V", "<init>", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellerService extends IntentService {
    @Inject
    public Analytics analytics;
    @Inject
    public FavoriteSellerInteractor interactor;
    @Inject
    public NotificationManagerCompat notificationManagerCompat;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FavoriteSellerServiceAction.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

    public FavoriteSellerService() {
        super("FavoriteSellerService");
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final FavoriteSellerInteractor getInteractor() {
        FavoriteSellerInteractor favoriteSellerInteractor = this.interactor;
        if (favoriteSellerInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return favoriteSellerInteractor;
    }

    @NotNull
    public final NotificationManagerCompat getNotificationManagerCompat() {
        NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
        if (notificationManagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        }
        return notificationManagerCompat2;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerFavoriteSellerServiceComponent.builder().dependentOn((FavoriteSellerServiceDependencies) ComponentDependenciesKt.getDependencies(FavoriteSellerServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        String stringExtra;
        Integer nullableIntExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("user_key")) != null && (nullableIntExtra = IntentsKt.getNullableIntExtra(intent, "notification_id")) != null) {
            int intValue = nullableIntExtra.intValue();
            String stringExtra2 = intent.getStringExtra("notification_tag");
            Serializable serializableExtra = intent.getSerializableExtra("action");
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.favorite_sellers.service.FavoriteSellerServiceAction");
            FavoriteSellerServiceAction favoriteSellerServiceAction = (FavoriteSellerServiceAction) serializableExtra;
            NotificationAnalyticParams notificationAnalyticParams = (NotificationAnalyticParams) intent.getParcelableExtra("notification_analytics");
            if (notificationAnalyticParams != null) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new NotificationButtonClickEvent(notificationAnalyticParams.b, notificationAnalyticParams.a));
            }
            NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
            if (notificationManagerCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
            }
            notificationManagerCompat2.cancel(stringExtra2, intValue);
            if (favoriteSellerServiceAction.ordinal() == 0) {
                FavoriteSellerInteractor favoriteSellerInteractor = this.interactor;
                if (favoriteSellerInteractor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("interactor");
                }
                favoriteSellerInteractor.muteSync(stringExtra);
            }
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setInteractor(@NotNull FavoriteSellerInteractor favoriteSellerInteractor) {
        Intrinsics.checkNotNullParameter(favoriteSellerInteractor, "<set-?>");
        this.interactor = favoriteSellerInteractor;
    }

    public final void setNotificationManagerCompat(@NotNull NotificationManagerCompat notificationManagerCompat2) {
        Intrinsics.checkNotNullParameter(notificationManagerCompat2, "<set-?>");
        this.notificationManagerCompat = notificationManagerCompat2;
    }
}

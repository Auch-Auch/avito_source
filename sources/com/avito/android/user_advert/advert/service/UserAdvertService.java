package com.avito.android.user_advert.advert.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Parcelable;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.PublishIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationButtonClickEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.advert.service.UserAdvertServiceAction;
import com.avito.android.user_advert.advert.service.di.DaggerUserAdvertServiceComponent;
import com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies;
import com.avito.android.util.Constants;
import com.avito.android.util.IntentsKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/avito/android/user_advert/advert/service/UserAdvertService;", "Landroid/app/IntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleIntent", "(Landroid/content/Intent;)V", "Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "interactor", "Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "getInteractor", "()Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "setInteractor", "(Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;)V", "Lcom/avito/android/UserAdvertIntentFactory;", "userAdvertIntentFactory", "Lcom/avito/android/UserAdvertIntentFactory;", "getUserAdvertIntentFactory", "()Lcom/avito/android/UserAdvertIntentFactory;", "setUserAdvertIntentFactory", "(Lcom/avito/android/UserAdvertIntentFactory;)V", "Lcom/avito/android/PublishIntentFactory;", "publishIntentFactory", "Lcom/avito/android/PublishIntentFactory;", "getPublishIntentFactory", "()Lcom/avito/android/PublishIntentFactory;", "setPublishIntentFactory", "(Lcom/avito/android/PublishIntentFactory;)V", "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "Landroidx/core/app/NotificationManagerCompat;", "getNotificationManagerCompat", "()Landroidx/core/app/NotificationManagerCompat;", "setNotificationManagerCompat", "(Landroidx/core/app/NotificationManagerCompat;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/UserAdvertsIntentFactory;", "userAdvertsIntentFactory", "Lcom/avito/android/UserAdvertsIntentFactory;", "getUserAdvertsIntentFactory", "()Lcom/avito/android/UserAdvertsIntentFactory;", "setUserAdvertsIntentFactory", "(Lcom/avito/android/UserAdvertsIntentFactory;)V", "<init>", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertService extends IntentService {
    @Inject
    public Analytics analytics;
    @Inject
    public UserAdvertInteractor interactor;
    @Inject
    public NotificationManagerCompat notificationManagerCompat;
    @Inject
    public PublishIntentFactory publishIntentFactory;
    @Inject
    public UserAdvertIntentFactory userAdvertIntentFactory;
    @Inject
    public UserAdvertsIntentFactory userAdvertsIntentFactory;

    public UserAdvertService() {
        super("UserAdvertService");
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
    public final UserAdvertInteractor getInteractor() {
        UserAdvertInteractor userAdvertInteractor = this.interactor;
        if (userAdvertInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return userAdvertInteractor;
    }

    @NotNull
    public final NotificationManagerCompat getNotificationManagerCompat() {
        NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
        if (notificationManagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        }
        return notificationManagerCompat2;
    }

    @NotNull
    public final PublishIntentFactory getPublishIntentFactory() {
        PublishIntentFactory publishIntentFactory2 = this.publishIntentFactory;
        if (publishIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishIntentFactory");
        }
        return publishIntentFactory2;
    }

    @NotNull
    public final UserAdvertIntentFactory getUserAdvertIntentFactory() {
        UserAdvertIntentFactory userAdvertIntentFactory2 = this.userAdvertIntentFactory;
        if (userAdvertIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertIntentFactory");
        }
        return userAdvertIntentFactory2;
    }

    @NotNull
    public final UserAdvertsIntentFactory getUserAdvertsIntentFactory() {
        UserAdvertsIntentFactory userAdvertsIntentFactory2 = this.userAdvertsIntentFactory;
        if (userAdvertsIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsIntentFactory");
        }
        return userAdvertsIntentFactory2;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerUserAdvertServiceComponent.builder().dependentOn((UserAdvertServiceDependencies) ComponentDependenciesKt.getDependencies(UserAdvertServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        Integer nullableIntExtra;
        int i;
        if (intent != null) {
            NotificationAnalyticParams notificationAnalyticParams = (NotificationAnalyticParams) intent.getParcelableExtra("notification_analytics");
            if (notificationAnalyticParams != null) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new NotificationButtonClickEvent(notificationAnalyticParams.b, notificationAnalyticParams.a));
            }
            String stringExtra = intent.getStringExtra("advert_id");
            if (stringExtra != null && (nullableIntExtra = IntentsKt.getNullableIntExtra(intent, "notification_id")) != null) {
                int intValue = nullableIntExtra.intValue();
                String stringExtra2 = intent.getStringExtra("notification_tag");
                Parcelable parcelableExtra = intent.getParcelableExtra("action");
                Objects.requireNonNull(parcelableExtra, "null cannot be cast to non-null type com.avito.android.user_advert.advert.service.UserAdvertServiceAction");
                UserAdvertServiceAction userAdvertServiceAction = (UserAdvertServiceAction) parcelableExtra;
                NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
                if (notificationManagerCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
                }
                notificationManagerCompat2.cancel(stringExtra2, intValue);
                sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                if (userAdvertServiceAction instanceof UserAdvertServiceAction.Close) {
                    UserAdvertInteractor userAdvertInteractor = this.interactor;
                    if (userAdvertInteractor == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("interactor");
                    }
                    userAdvertInteractor.closeAdvertSync(((UserAdvertServiceAction.Close) userAdvertServiceAction).getReasonId(), stringExtra);
                } else if (userAdvertServiceAction instanceof UserAdvertServiceAction.AutoPublish) {
                    UserAdvertInteractor userAdvertInteractor2 = this.interactor;
                    if (userAdvertInteractor2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("interactor");
                    }
                    UserAdvertServiceAction.AutoPublish autoPublish = (UserAdvertServiceAction.AutoPublish) userAdvertServiceAction;
                    if (!userAdvertInteractor2.setAutoPublishSync(autoPublish.getEnable(), stringExtra)) {
                        if (autoPublish.getEnable()) {
                            i = R.string.autopublish_from_push_enable_error;
                        } else {
                            i = R.string.autopublish_from_push_disable_error;
                        }
                        String string = getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …ror\n                    )");
                        UserAdvertIntentFactory userAdvertIntentFactory2 = this.userAdvertIntentFactory;
                        if (userAdvertIntentFactory2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userAdvertIntentFactory");
                        }
                        Intent myAdvertDetailsWithMessageIntent = userAdvertIntentFactory2.myAdvertDetailsWithMessageIntent(stringExtra, string);
                        UserAdvertsIntentFactory userAdvertsIntentFactory2 = this.userAdvertsIntentFactory;
                        if (userAdvertsIntentFactory2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsIntentFactory");
                        }
                        Intent putExtra = myAdvertDetailsWithMessageIntent.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(userAdvertsIntentFactory2, null, null, false, 7, null).addFlags(603979776));
                        Intrinsics.checkNotNullExpressionValue(putExtra, "userAdvertIntentFactory.…                        )");
                        putExtra.setFlags(335544320);
                        startActivity(putExtra);
                    }
                } else if (userAdvertServiceAction instanceof UserAdvertServiceAction.Activate) {
                    UserAdvertInteractor userAdvertInteractor3 = this.interactor;
                    if (userAdvertInteractor3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("interactor");
                    }
                    if (!userAdvertInteractor3.activateAdvertSync(stringExtra)) {
                        String string2 = getString(R.string.advert_activation_failure);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.advert_activation_failure)");
                        UserAdvertIntentFactory userAdvertIntentFactory3 = this.userAdvertIntentFactory;
                        if (userAdvertIntentFactory3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userAdvertIntentFactory");
                        }
                        Intent myAdvertDetailsWithMessageIntent2 = userAdvertIntentFactory3.myAdvertDetailsWithMessageIntent(stringExtra, string2);
                        UserAdvertsIntentFactory userAdvertsIntentFactory3 = this.userAdvertsIntentFactory;
                        if (userAdvertsIntentFactory3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userAdvertsIntentFactory");
                        }
                        Intent putExtra2 = myAdvertDetailsWithMessageIntent2.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(userAdvertsIntentFactory3, null, null, false, 7, null).addFlags(603979776));
                        Intrinsics.checkNotNullExpressionValue(putExtra2, "userAdvertIntentFactory.…                        )");
                        putExtra2.setFlags(335544320);
                        startActivity(putExtra2);
                    }
                }
            }
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setInteractor(@NotNull UserAdvertInteractor userAdvertInteractor) {
        Intrinsics.checkNotNullParameter(userAdvertInteractor, "<set-?>");
        this.interactor = userAdvertInteractor;
    }

    public final void setNotificationManagerCompat(@NotNull NotificationManagerCompat notificationManagerCompat2) {
        Intrinsics.checkNotNullParameter(notificationManagerCompat2, "<set-?>");
        this.notificationManagerCompat = notificationManagerCompat2;
    }

    public final void setPublishIntentFactory(@NotNull PublishIntentFactory publishIntentFactory2) {
        Intrinsics.checkNotNullParameter(publishIntentFactory2, "<set-?>");
        this.publishIntentFactory = publishIntentFactory2;
    }

    public final void setUserAdvertIntentFactory(@NotNull UserAdvertIntentFactory userAdvertIntentFactory2) {
        Intrinsics.checkNotNullParameter(userAdvertIntentFactory2, "<set-?>");
        this.userAdvertIntentFactory = userAdvertIntentFactory2;
    }

    public final void setUserAdvertsIntentFactory(@NotNull UserAdvertsIntentFactory userAdvertsIntentFactory2) {
        Intrinsics.checkNotNullParameter(userAdvertsIntentFactory2, "<set-?>");
        this.userAdvertsIntentFactory = userAdvertsIntentFactory2;
    }
}

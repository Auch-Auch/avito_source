package com.avito.android.social_management.adapter.notification.di;

import com.avito.android.di.PerActivity;
import com.avito.android.social_management.adapter.notification.NotificationItemBlueprint;
import com.avito.android.social_management.adapter.notification.NotificationItemPresenter;
import com.avito.android.social_management.adapter.notification.NotificationItemPresenterImpl;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/social_management/adapter/notification/di/NotificationItemModule;", "", "Lcom/avito/android/social_management/adapter/notification/NotificationItemBlueprint;", "impl", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/social_management/adapter/notification/NotificationItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenterImpl;", "Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenter;", "bindPresenter", "(Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenterImpl;)Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenter;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "relay", "Lio/reactivex/functions/Consumer;", "bindNotificationActionsRelay", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/functions/Consumer;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface NotificationItemModule {
    @Binds
    @IntoSet
    @NotNull
    @PerActivity
    ItemBlueprint<?, ?> bindBlueprint(@NotNull NotificationItemBlueprint notificationItemBlueprint);

    @Binds
    @NotNull
    @PerActivity
    Consumer<SocialNotificationAction> bindNotificationActionsRelay(@NotNull PublishRelay<SocialNotificationAction> publishRelay);

    @PerActivity
    @Binds
    @NotNull
    NotificationItemPresenter bindPresenter(@NotNull NotificationItemPresenterImpl notificationItemPresenterImpl);
}

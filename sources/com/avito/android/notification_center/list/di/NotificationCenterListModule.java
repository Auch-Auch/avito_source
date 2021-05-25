package com.avito.android.notification_center.list.di;

import a2.b.a.a.a;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.date_time_formatter.RelativeDateFormatterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.list.NotificationCenterListInteractor;
import com.avito.android.notification_center.list.NotificationCenterListInteractorImpl;
import com.avito.android.notification_center.list.NotificationCenterListPresenter;
import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.notification_center.list.NotificationCenterListView;
import com.avito.android.notification_center.list.item.ErrorSnippetItemBlueprint;
import com.avito.android.notification_center.list.item.ErrorSnippetItemPresenter;
import com.avito.android.notification_center.list.item.ErrorSnippetItemPresenterImpl;
import com.avito.android.notification_center.list.item.ErrorSnippetItemView;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.avito.android.notification_center.list.item.NotificationCenterListItemBlueprint;
import com.avito.android.notification_center.list.item.NotificationCenterListItemClickListener;
import com.avito.android.notification_center.list.item.NotificationCenterListItemPresenter;
import com.avito.android.notification_center.list.item.NotificationCenterListItemPresenterImpl;
import com.avito.android.notification_center.list.item.NotificationCenterListItemView;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0007\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/notification_center/list/di/NotificationCenterListModule;", "", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "kotlin.jvm.PlatformType", "provideRefreshClicks$notification_center_release", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "provideRefreshClicks", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$notification_center_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemBlueprint;", "notificationCenterListItemBlueprint", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemBlueprint;", "errorSnippetItemBlueprint", "provideItemBinder$notification_center_release", "(Lcom/avito/android/notification_center/list/item/NotificationCenterListItemBlueprint;Lcom/avito/android/notification_center/list/item/ErrorSnippetItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class NotificationCenterListModule {
    @NotNull
    public static final NotificationCenterListModule INSTANCE = new NotificationCenterListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u00132\u0006\u0010\u0012\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\b\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/avito/android/notification_center/list/di/NotificationCenterListModule$Declarations;", "", "Lcom/avito/android/notification_center/list/NotificationCenterListInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;", "bindNotificationCenterListInteractor", "(Lcom/avito/android/notification_center/list/NotificationCenterListInteractorImpl;)Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;", "Lcom/avito/android/notification_center/list/NotificationCenterListPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;", "bindNotificationCenterListPresenter", "(Lcom/avito/android/notification_center/list/NotificationCenterListPresenterImpl;)Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;", "Lcom/avito/android/date_time_formatter/RelativeDateFormatterImpl;", "formatter", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "bindRelativeDateFormatter", "(Lcom/avito/android/date_time_formatter/RelativeDateFormatterImpl;)Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemView;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;", "bindNotificationCenterListItemBlueprint", "(Lcom/avito/android/notification_center/list/item/NotificationCenterListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenterImpl;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenter;", "bindNotificationCenterListItemPresenter", "(Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenterImpl;)Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenter;", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemBlueprint;", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemView;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "bindErrorSnippetItemBlueprint", "(Lcom/avito/android/notification_center/list/item/ErrorSnippetItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemPresenterImpl;", "Lcom/avito/android/notification_center/list/item/ErrorSnippetItemPresenter;", "bindErrorSnippetItemPresenter", "(Lcom/avito/android/notification_center/list/item/ErrorSnippetItemPresenterImpl;)Lcom/avito/android/notification_center/list/item/ErrorSnippetItemPresenter;", "Lcom/avito/android/notification_center/list/NotificationCenterListView$Callback;", "bindNotificationCenterListViewCallback", "(Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;)Lcom/avito/android/notification_center/list/NotificationCenterListView$Callback;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;", "bindNotificationCenterListItemClickListener", "(Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;)Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "bindAppendingListener", "(Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;)Lcom/avito/android/ui/adapter/AppendingListener;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AppendingListener bindAppendingListener(@NotNull NotificationCenterListPresenter notificationCenterListPresenter);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<ErrorSnippetItemView, NotificationCenterListItem.ErrorSnippet> bindErrorSnippetItemBlueprint(@NotNull ErrorSnippetItemBlueprint errorSnippetItemBlueprint);

        @PerActivity
        @Binds
        @NotNull
        ErrorSnippetItemPresenter bindErrorSnippetItemPresenter(@NotNull ErrorSnippetItemPresenterImpl errorSnippetItemPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterListInteractor bindNotificationCenterListInteractor(@NotNull NotificationCenterListInteractorImpl notificationCenterListInteractorImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationCenterListItemView, NotificationCenterListItem.Notification> bindNotificationCenterListItemBlueprint(@NotNull NotificationCenterListItemBlueprint notificationCenterListItemBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterListItemClickListener bindNotificationCenterListItemClickListener(@NotNull NotificationCenterListPresenter notificationCenterListPresenter);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterListItemPresenter bindNotificationCenterListItemPresenter(@NotNull NotificationCenterListItemPresenterImpl notificationCenterListItemPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterListPresenter bindNotificationCenterListPresenter(@NotNull NotificationCenterListPresenterImpl notificationCenterListPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterListView.Callback bindNotificationCenterListViewCallback(@NotNull NotificationCenterListPresenter notificationCenterListPresenter);

        @PerActivity
        @Binds
        @NotNull
        RelativeDateFormatter bindRelativeDateFormatter(@NotNull RelativeDateFormatterImpl relativeDateFormatterImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$notification_center_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ItemBinder provideItemBinder$notification_center_release(@NotNull NotificationCenterListItemBlueprint notificationCenterListItemBlueprint, @NotNull ErrorSnippetItemBlueprint errorSnippetItemBlueprint) {
        Intrinsics.checkNotNullParameter(notificationCenterListItemBlueprint, "notificationCenterListItemBlueprint");
        Intrinsics.checkNotNullParameter(errorSnippetItemBlueprint, "errorSnippetItemBlueprint");
        return new ItemBinder.Builder().registerItem(notificationCenterListItemBlueprint).registerItem(errorSnippetItemBlueprint).build();
    }

    @Provides
    @PerActivity
    public final PublishRelay<NotificationCenterListItem.ErrorSnippet> provideRefreshClicks$notification_center_release() {
        return PublishRelay.create();
    }
}

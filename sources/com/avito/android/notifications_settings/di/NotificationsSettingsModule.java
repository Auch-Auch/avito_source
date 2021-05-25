package com.avito.android.notifications_settings.di;

import a2.b.a.a.a;
import com.avito.android.di.PerActivity;
import com.avito.android.notifications_settings.NotificationsSettingsConverter;
import com.avito.android.notifications_settings.NotificationsSettingsConverterImpl;
import com.avito.android.notifications_settings.NotificationsSettingsInteractor;
import com.avito.android.notifications_settings.NotificationsSettingsInteractorImpl;
import com.avito.android.notifications_settings.NotificationsSettingsPresenter;
import com.avito.android.notifications_settings.NotificationsSettingsPresenterImpl;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoBlueprint;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoItem;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoPresenter;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoPresenterImpl;
import com.avito.android.notifications_settings.info.NotificationsSettingsInfoView;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomBlueprint;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomItem;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomPresenter;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomPresenterImpl;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomView;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopBlueprint;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopItem;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopPresenter;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopPresenterImpl;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopView;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceBlueprint;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceItem;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpacePresenter;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpacePresenterImpl;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceView;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleBlueprint;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleItem;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitlePresenter;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitlePresenterImpl;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleView;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleBlueprint;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleItem;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsTogglePresenter;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsTogglePresenterImpl;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/notifications_settings/di/NotificationsSettingsModule;", "", "Lcom/jakewharton/rxrelay2/Relay;", "", "provideSettingsConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleItem;", "provideNotificationsSettingsToggleItemConsumer", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoBlueprint;", "infoBlueprint", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomBlueprint;", "shadowBottomBlueprint", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopBlueprint;", "shadowTopBlueprint", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceBlueprint;", "spaceBlueprint", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleBlueprint;", "titleBlueprint", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleBlueprint;", "toggleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoBlueprint;Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomBlueprint;Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopBlueprint;Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceBlueprint;Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleBlueprint;Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class NotificationsSettingsModule {
    @NotNull
    public static final NotificationsSettingsModule INSTANCE = new NotificationsSettingsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\n\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J#\u0010,\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0\u00042\u0006\u0010\u0003\u001a\u00020)H'¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020/2\u0006\u0010\n\u001a\u00020.H'¢\u0006\u0004\b0\u00101J#\u00105\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040\u00042\u0006\u0010\u0003\u001a\u000202H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u0010\n\u001a\u000207H'¢\u0006\u0004\b9\u0010:J\u0017\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020;H'¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020A2\u0006\u0010\n\u001a\u00020@H'¢\u0006\u0004\bB\u0010CJ\u0017\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020DH'¢\u0006\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/avito/android/notifications_settings/di/NotificationsSettingsModule$Declarations;", "", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoView;", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoItem;", "bindNotificationsSettingsInfoBlueprint", "(Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoPresenterImpl;", "presenter", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoPresenter;", "bindNotificationsSettingsInfoPresenter", "(Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoPresenterImpl;)Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoPresenter;", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomBlueprint;", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomView;", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomItem;", "bindNotificationsSettingsShadowBottomBlueprint", "(Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomPresenterImpl;", "Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomPresenter;", "bindNotificationsSettingsShadowBottomPresenter", "(Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomPresenterImpl;)Lcom/avito/android/notifications_settings/shadow/bottom/NotificationsSettingsShadowBottomPresenter;", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopBlueprint;", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopView;", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopItem;", "bindNotificationsSettingsShadowTopBlueprint", "(Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopPresenterImpl;", "Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopPresenter;", "bindNotificationsSettingsShadowTopPresenter", "(Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopPresenterImpl;)Lcom/avito/android/notifications_settings/shadow/top/NotificationsSettingsShadowTopPresenter;", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceBlueprint;", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceView;", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceItem;", "bindNotificationsSettingsSpaceBlueprint", "(Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpaceBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpacePresenterImpl;", "Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpacePresenter;", "bindNotificationsSettingsSpacePresenter", "(Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpacePresenterImpl;)Lcom/avito/android/notifications_settings/space/NotificationsSettingsSpacePresenter;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleBlueprint;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleView;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleItem;", "bindNotificationsSettingsTitleBlueprint", "(Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitlePresenterImpl;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitlePresenter;", "bindNotificationsSettingsTitlePresenter", "(Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitlePresenterImpl;)Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitlePresenter;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleBlueprint;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleView;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleItem;", "bindNotificationsSettingsToggleBlueprint", "(Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsToggleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenterImpl;", "Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenter;", "bindNotificationsSettingsTogglePresenter", "(Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenterImpl;)Lcom/avito/android/notifications_settings/toggle/NotificationsSettingsTogglePresenter;", "Lcom/avito/android/notifications_settings/NotificationsSettingsInteractorImpl;", "interactor", "Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;", "bindNotificationsSettingsInteractor", "(Lcom/avito/android/notifications_settings/NotificationsSettingsInteractorImpl;)Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;", "Lcom/avito/android/notifications_settings/NotificationsSettingsPresenterImpl;", "Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "bindNotificationsSettingsPresenter", "(Lcom/avito/android/notifications_settings/NotificationsSettingsPresenterImpl;)Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "Lcom/avito/android/notifications_settings/NotificationsSettingsConverterImpl;", "converter", "Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;", "bindNotificationsSettingsConverter", "(Lcom/avito/android/notifications_settings/NotificationsSettingsConverterImpl;)Lcom/avito/android/notifications_settings/NotificationsSettingsConverter;", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsConverter bindNotificationsSettingsConverter(@NotNull NotificationsSettingsConverterImpl notificationsSettingsConverterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsInfoView, NotificationsSettingsInfoItem> bindNotificationsSettingsInfoBlueprint(@NotNull NotificationsSettingsInfoBlueprint notificationsSettingsInfoBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsInfoPresenter bindNotificationsSettingsInfoPresenter(@NotNull NotificationsSettingsInfoPresenterImpl notificationsSettingsInfoPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsInteractor bindNotificationsSettingsInteractor(@NotNull NotificationsSettingsInteractorImpl notificationsSettingsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsPresenter bindNotificationsSettingsPresenter(@NotNull NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsShadowBottomView, NotificationsSettingsShadowBottomItem> bindNotificationsSettingsShadowBottomBlueprint(@NotNull NotificationsSettingsShadowBottomBlueprint notificationsSettingsShadowBottomBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsShadowBottomPresenter bindNotificationsSettingsShadowBottomPresenter(@NotNull NotificationsSettingsShadowBottomPresenterImpl notificationsSettingsShadowBottomPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsShadowTopView, NotificationsSettingsShadowTopItem> bindNotificationsSettingsShadowTopBlueprint(@NotNull NotificationsSettingsShadowTopBlueprint notificationsSettingsShadowTopBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsShadowTopPresenter bindNotificationsSettingsShadowTopPresenter(@NotNull NotificationsSettingsShadowTopPresenterImpl notificationsSettingsShadowTopPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsSpaceView, NotificationsSettingsSpaceItem> bindNotificationsSettingsSpaceBlueprint(@NotNull NotificationsSettingsSpaceBlueprint notificationsSettingsSpaceBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsSpacePresenter bindNotificationsSettingsSpacePresenter(@NotNull NotificationsSettingsSpacePresenterImpl notificationsSettingsSpacePresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsTitleView, NotificationsSettingsTitleItem> bindNotificationsSettingsTitleBlueprint(@NotNull NotificationsSettingsTitleBlueprint notificationsSettingsTitleBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsTitlePresenter bindNotificationsSettingsTitlePresenter(@NotNull NotificationsSettingsTitlePresenterImpl notificationsSettingsTitlePresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<NotificationsSettingsToggleView, NotificationsSettingsToggleItem> bindNotificationsSettingsToggleBlueprint(@NotNull NotificationsSettingsToggleBlueprint notificationsSettingsToggleBlueprint);

        @PerActivity
        @Binds
        @NotNull
        NotificationsSettingsTogglePresenter bindNotificationsSettingsTogglePresenter(@NotNull NotificationsSettingsTogglePresenterImpl notificationsSettingsTogglePresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder(@NotNull NotificationsSettingsInfoBlueprint notificationsSettingsInfoBlueprint, @NotNull NotificationsSettingsShadowBottomBlueprint notificationsSettingsShadowBottomBlueprint, @NotNull NotificationsSettingsShadowTopBlueprint notificationsSettingsShadowTopBlueprint, @NotNull NotificationsSettingsSpaceBlueprint notificationsSettingsSpaceBlueprint, @NotNull NotificationsSettingsTitleBlueprint notificationsSettingsTitleBlueprint, @NotNull NotificationsSettingsToggleBlueprint notificationsSettingsToggleBlueprint) {
        Intrinsics.checkNotNullParameter(notificationsSettingsInfoBlueprint, "infoBlueprint");
        Intrinsics.checkNotNullParameter(notificationsSettingsShadowBottomBlueprint, "shadowBottomBlueprint");
        Intrinsics.checkNotNullParameter(notificationsSettingsShadowTopBlueprint, "shadowTopBlueprint");
        Intrinsics.checkNotNullParameter(notificationsSettingsSpaceBlueprint, "spaceBlueprint");
        Intrinsics.checkNotNullParameter(notificationsSettingsTitleBlueprint, "titleBlueprint");
        Intrinsics.checkNotNullParameter(notificationsSettingsToggleBlueprint, "toggleBlueprint");
        return new ItemBinder.Builder().registerItem(notificationsSettingsInfoBlueprint).registerItem(notificationsSettingsShadowBottomBlueprint).registerItem(notificationsSettingsShadowTopBlueprint).registerItem(notificationsSettingsSpaceBlueprint).registerItem(notificationsSettingsTitleBlueprint).registerItem(notificationsSettingsToggleBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Relay<NotificationsSettingsToggleItem> provideNotificationsSettingsToggleItemConsumer() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Noti…ionsSettingsToggleItem>()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Relay<Unit> provideSettingsConsumer() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Unit>()");
        return create;
    }
}

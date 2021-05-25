package com.avito.android.notifications_settings.di;

import com.avito.android.notifications_settings.info.NotificationsSettingsInfoBlueprint;
import com.avito.android.notifications_settings.shadow.bottom.NotificationsSettingsShadowBottomBlueprint;
import com.avito.android.notifications_settings.shadow.top.NotificationsSettingsShadowTopBlueprint;
import com.avito.android.notifications_settings.space.NotificationsSettingsSpaceBlueprint;
import com.avito.android.notifications_settings.title.NotificationsSettingsTitleBlueprint;
import com.avito.android.notifications_settings.toggle.NotificationsSettingsToggleBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationsSettingsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<NotificationsSettingsInfoBlueprint> a;
    public final Provider<NotificationsSettingsShadowBottomBlueprint> b;
    public final Provider<NotificationsSettingsShadowTopBlueprint> c;
    public final Provider<NotificationsSettingsSpaceBlueprint> d;
    public final Provider<NotificationsSettingsTitleBlueprint> e;
    public final Provider<NotificationsSettingsToggleBlueprint> f;

    public NotificationsSettingsModule_ProvideItemBinderFactory(Provider<NotificationsSettingsInfoBlueprint> provider, Provider<NotificationsSettingsShadowBottomBlueprint> provider2, Provider<NotificationsSettingsShadowTopBlueprint> provider3, Provider<NotificationsSettingsSpaceBlueprint> provider4, Provider<NotificationsSettingsTitleBlueprint> provider5, Provider<NotificationsSettingsToggleBlueprint> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static NotificationsSettingsModule_ProvideItemBinderFactory create(Provider<NotificationsSettingsInfoBlueprint> provider, Provider<NotificationsSettingsShadowBottomBlueprint> provider2, Provider<NotificationsSettingsShadowTopBlueprint> provider3, Provider<NotificationsSettingsSpaceBlueprint> provider4, Provider<NotificationsSettingsTitleBlueprint> provider5, Provider<NotificationsSettingsToggleBlueprint> provider6) {
        return new NotificationsSettingsModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ItemBinder provideItemBinder(NotificationsSettingsInfoBlueprint notificationsSettingsInfoBlueprint, NotificationsSettingsShadowBottomBlueprint notificationsSettingsShadowBottomBlueprint, NotificationsSettingsShadowTopBlueprint notificationsSettingsShadowTopBlueprint, NotificationsSettingsSpaceBlueprint notificationsSettingsSpaceBlueprint, NotificationsSettingsTitleBlueprint notificationsSettingsTitleBlueprint, NotificationsSettingsToggleBlueprint notificationsSettingsToggleBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(NotificationsSettingsModule.provideItemBinder(notificationsSettingsInfoBlueprint, notificationsSettingsShadowBottomBlueprint, notificationsSettingsShadowTopBlueprint, notificationsSettingsSpaceBlueprint, notificationsSettingsTitleBlueprint, notificationsSettingsToggleBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

package com.avito.android.settings.ui;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.DebugIntentFactory;
import com.avito.android.settings.SettingsPresenter;
import com.avito.android.settings.SettingsResourceProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SettingsFragment_MembersInjector implements MembersInjector<SettingsFragment> {
    public final Provider<SettingsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<DebugIntentFactory> e;
    public final Provider<SettingsResourceProvider> f;

    public SettingsFragment_MembersInjector(Provider<SettingsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4, Provider<DebugIntentFactory> provider5, Provider<SettingsResourceProvider> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<SettingsFragment> create(Provider<SettingsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4, Provider<DebugIntentFactory> provider5, Provider<SettingsResourceProvider> provider6) {
        return new SettingsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SettingsFragment settingsFragment, ActivityIntentFactory activityIntentFactory) {
        settingsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.adapterPresenter")
    public static void injectAdapterPresenter(SettingsFragment settingsFragment, AdapterPresenter adapterPresenter) {
        settingsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.debugIntentFactory")
    public static void injectDebugIntentFactory(SettingsFragment settingsFragment, DebugIntentFactory debugIntentFactory) {
        settingsFragment.debugIntentFactory = debugIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.itemBinder")
    public static void injectItemBinder(SettingsFragment settingsFragment, ItemBinder itemBinder) {
        settingsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.resourceProvider")
    public static void injectResourceProvider(SettingsFragment settingsFragment, SettingsResourceProvider settingsResourceProvider) {
        settingsFragment.resourceProvider = settingsResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.settings.ui.SettingsFragment.settingsPresenter")
    public static void injectSettingsPresenter(SettingsFragment settingsFragment, SettingsPresenter settingsPresenter) {
        settingsFragment.settingsPresenter = settingsPresenter;
    }

    public void injectMembers(SettingsFragment settingsFragment) {
        injectSettingsPresenter(settingsFragment, this.a.get());
        injectAdapterPresenter(settingsFragment, this.b.get());
        injectItemBinder(settingsFragment, this.c.get());
        injectActivityIntentFactory(settingsFragment, this.d.get());
        injectDebugIntentFactory(settingsFragment, this.e.get());
        injectResourceProvider(settingsFragment, this.f.get());
    }
}

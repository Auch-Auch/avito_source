package com.avito.android.settings;

import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.SearchApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class SettingsPresenterImpl_Factory implements Factory<SettingsPresenterImpl> {
    public final Provider<Observable<String>> a;
    public final Provider<SavedLocationInteractor> b;
    public final Provider<SearchApi> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<SettingsResourceProvider> f;
    public final Provider<DeviceIdProvider> g;
    public final Provider<DarkThemeManager> h;
    public final Provider<BuildInfo> i;
    public final Provider<String> j;
    public final Provider<DarkThemeConfig> k;
    public final Provider<Preferences> l;
    public final Provider<Kundle> m;

    public SettingsPresenterImpl_Factory(Provider<Observable<String>> provider, Provider<SavedLocationInteractor> provider2, Provider<SearchApi> provider3, Provider<SchedulersFactory3> provider4, Provider<AdapterPresenter> provider5, Provider<SettingsResourceProvider> provider6, Provider<DeviceIdProvider> provider7, Provider<DarkThemeManager> provider8, Provider<BuildInfo> provider9, Provider<String> provider10, Provider<DarkThemeConfig> provider11, Provider<Preferences> provider12, Provider<Kundle> provider13) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
    }

    public static SettingsPresenterImpl_Factory create(Provider<Observable<String>> provider, Provider<SavedLocationInteractor> provider2, Provider<SearchApi> provider3, Provider<SchedulersFactory3> provider4, Provider<AdapterPresenter> provider5, Provider<SettingsResourceProvider> provider6, Provider<DeviceIdProvider> provider7, Provider<DarkThemeManager> provider8, Provider<BuildInfo> provider9, Provider<String> provider10, Provider<DarkThemeConfig> provider11, Provider<Preferences> provider12, Provider<Kundle> provider13) {
        return new SettingsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static SettingsPresenterImpl newInstance(Observable<String> observable, SavedLocationInteractor savedLocationInteractor, SearchApi searchApi, SchedulersFactory3 schedulersFactory3, AdapterPresenter adapterPresenter, SettingsResourceProvider settingsResourceProvider, DeviceIdProvider deviceIdProvider, DarkThemeManager darkThemeManager, BuildInfo buildInfo, String str, DarkThemeConfig darkThemeConfig, Preferences preferences, Kundle kundle) {
        return new SettingsPresenterImpl(observable, savedLocationInteractor, searchApi, schedulersFactory3, adapterPresenter, settingsResourceProvider, deviceIdProvider, darkThemeManager, buildInfo, str, darkThemeConfig, preferences, kundle);
    }

    @Override // javax.inject.Provider
    public SettingsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}

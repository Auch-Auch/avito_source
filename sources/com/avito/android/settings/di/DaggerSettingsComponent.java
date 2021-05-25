package com.avito.android.settings.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.DebugIntentFactory;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.settings.SettingsPresenterImpl;
import com.avito.android.settings.SettingsResourceProviderImpl;
import com.avito.android.settings.adapter.CategorySettingsItemBlueprint;
import com.avito.android.settings.adapter.CategorySettingsItemBlueprint_Factory;
import com.avito.android.settings.adapter.CategorySettingsItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.DividerItemBlueprint;
import com.avito.android.settings.adapter.DividerItemBlueprint_Factory;
import com.avito.android.settings.adapter.DividerItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.InfoSettingsItemBlueprint;
import com.avito.android.settings.adapter.InfoSettingsItemBlueprint_Factory;
import com.avito.android.settings.adapter.InfoSettingsItemPresenterImpl;
import com.avito.android.settings.adapter.InfoSettingsItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemBlueprint;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemBlueprint_Factory;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemPresenterImpl;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.ListItemBlueprint;
import com.avito.android.settings.adapter.ListItemBlueprint_Factory;
import com.avito.android.settings.adapter.ListItemPresenterImpl;
import com.avito.android.settings.adapter.ListItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemBlueprint;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemBlueprint_Factory;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemPresenterImpl;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemPresenterImpl_Factory;
import com.avito.android.settings.adapter.SelectSettingsItemBlueprint;
import com.avito.android.settings.adapter.SelectSettingsItemBlueprint_Factory;
import com.avito.android.settings.adapter.SelectSettingsItemPresenterImpl;
import com.avito.android.settings.adapter.SelectSettingsItemPresenterImpl_Factory;
import com.avito.android.settings.di.SettingsComponent;
import com.avito.android.settings.ui.SettingsFragment;
import com.avito.android.settings.ui.SettingsFragment_MembersInjector;
import com.avito.android.shared_providers.SupportEmailResourceProviderImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSettingsComponent implements SettingsComponent {
    public Provider<AdapterPresenter> A;
    public final PublishRelay<String> a;
    public final SettingsDependencies b;
    public final Resources c;
    public final Kundle d;
    public Provider<SavedLocationStorage> e;
    public Provider<LocationApi> f;
    public Provider<TopLocationInteractor> g;
    public Provider<Features> h;
    public Provider<BackNavigationLocationInteractor> i;
    public Provider<SavedLocationInteractorImpl> j;
    public Provider<SavedLocationInteractor> k;
    public Provider<DividerItemBlueprint> l = DividerItemBlueprint_Factory.create(DividerItemPresenterImpl_Factory.create());
    public Provider<CategorySettingsItemBlueprint> m = CategorySettingsItemBlueprint_Factory.create(CategorySettingsItemPresenterImpl_Factory.create());
    public Provider<PublishRelay<String>> n;
    public Provider<LogoWithVersionSettingsItemPresenterImpl> o;
    public Provider<LogoWithVersionSettingsItemBlueprint> p;
    public Provider<InfoSettingsItemPresenterImpl> q;
    public Provider<InfoSettingsItemBlueprint> r;
    public Provider<SelectSettingsItemPresenterImpl> s;
    public Provider<SelectSettingsItemBlueprint> t;
    public Provider<ListItemPresenterImpl> u;
    public Provider<ListItemBlueprint> v;
    public Provider<InfoSettingsWithProgressItemPresenterImpl> w;
    public Provider<InfoSettingsWithProgressItemBlueprint> x;
    public Provider<Set<ItemBlueprint<?, ?>>> y;
    public Provider<ItemBinder> z;

    public static final class b implements SettingsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.settings.di.SettingsComponent.Factory
        public SettingsComponent create(SettingsDependencies settingsDependencies, LocationDependencies locationDependencies, Kundle kundle, Resources resources, PublishRelay<String> publishRelay) {
            Preconditions.checkNotNull(settingsDependencies);
            Preconditions.checkNotNull(locationDependencies);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(publishRelay);
            return new DaggerSettingsComponent(settingsDependencies, locationDependencies, kundle, resources, publishRelay, null);
        }
    }

    public static class c implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public c(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class d implements Provider<LocationApi> {
        public final LocationDependencies a;

        public d(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class e implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public e(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class f implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public f(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class g implements Provider<Features> {
        public final SettingsDependencies a;

        public g(SettingsDependencies settingsDependencies) {
            this.a = settingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public DaggerSettingsComponent(SettingsDependencies settingsDependencies, LocationDependencies locationDependencies, Kundle kundle, Resources resources, PublishRelay publishRelay, a aVar) {
        this.a = publishRelay;
        this.b = settingsDependencies;
        this.c = resources;
        this.d = kundle;
        e eVar = new e(locationDependencies);
        this.e = eVar;
        d dVar = new d(locationDependencies);
        this.f = dVar;
        f fVar = new f(locationDependencies);
        this.g = fVar;
        g gVar = new g(settingsDependencies);
        this.h = gVar;
        c cVar = new c(locationDependencies);
        this.i = cVar;
        SavedLocationInteractorImpl_Factory create = SavedLocationInteractorImpl_Factory.create(eVar, dVar, fVar, gVar, cVar);
        this.j = create;
        this.k = SingleCheck.provider(create);
        Factory create2 = InstanceFactory.create(publishRelay);
        this.n = create2;
        LogoWithVersionSettingsItemPresenterImpl_Factory create3 = LogoWithVersionSettingsItemPresenterImpl_Factory.create(create2);
        this.o = create3;
        this.p = LogoWithVersionSettingsItemBlueprint_Factory.create(create3);
        InfoSettingsItemPresenterImpl_Factory create4 = InfoSettingsItemPresenterImpl_Factory.create(this.n);
        this.q = create4;
        this.r = InfoSettingsItemBlueprint_Factory.create(create4);
        SelectSettingsItemPresenterImpl_Factory create5 = SelectSettingsItemPresenterImpl_Factory.create(this.n);
        this.s = create5;
        this.t = SelectSettingsItemBlueprint_Factory.create(create5);
        ListItemPresenterImpl_Factory create6 = ListItemPresenterImpl_Factory.create(this.n);
        this.u = create6;
        this.v = ListItemBlueprint_Factory.create(create6);
        InfoSettingsWithProgressItemPresenterImpl_Factory create7 = InfoSettingsWithProgressItemPresenterImpl_Factory.create(this.n);
        this.w = create7;
        this.x = InfoSettingsWithProgressItemBlueprint_Factory.create(create7);
        SetFactory build = SetFactory.builder(7, 0).addProvider(this.l).addProvider(this.m).addProvider(this.p).addProvider(this.r).addProvider(this.t).addProvider(this.v).addProvider(this.x).build();
        this.y = build;
        Provider<ItemBinder> provider = DoubleCheck.provider(SettingsModule_ProvideItemBinder$settings_releaseFactory.create(build));
        this.z = provider;
        this.A = DoubleCheck.provider(SettingsModule_ProvideAdapterPresenter$settings_releaseFactory.create(provider));
    }

    public static SettingsComponent.Factory factory() {
        return new b(null);
    }

    public final SettingsResourceProviderImpl a() {
        Resources resources = this.c;
        return new SettingsResourceProviderImpl(resources, new SupportEmailResourceProviderImpl(resources, (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.b.profileInfoStorage()), (BuildInfo) Preconditions.checkNotNullFromComponent(this.b.buildInfo())));
    }

    @Override // com.avito.android.settings.di.SettingsComponent
    public void inject(SettingsFragment settingsFragment) {
        SettingsFragment_MembersInjector.injectSettingsPresenter(settingsFragment, new SettingsPresenterImpl(this.a, this.k.get(), (SearchApi) Preconditions.checkNotNullFromComponent(this.b.searchApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3()), this.A.get(), a(), (DeviceIdProvider) Preconditions.checkNotNullFromComponent(this.b.deviceIdProvider()), (DarkThemeManager) Preconditions.checkNotNullFromComponent(this.b.darkThemeManager()), (BuildInfo) Preconditions.checkNotNullFromComponent(this.b.buildInfo()), SettingsModule_ProvideAppVersionName$settings_releaseFactory.provideAppVersionName$settings_release((BuildInfo) Preconditions.checkNotNullFromComponent(this.b.buildInfo())), (DarkThemeConfig) Preconditions.checkNotNullFromComponent(this.b.darkThemeConfig()), (Preferences) Preconditions.checkNotNullFromComponent(this.b.preferences()), this.d));
        SettingsFragment_MembersInjector.injectAdapterPresenter(settingsFragment, this.A.get());
        SettingsFragment_MembersInjector.injectItemBinder(settingsFragment, this.z.get());
        SettingsFragment_MembersInjector.injectActivityIntentFactory(settingsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        SettingsFragment_MembersInjector.injectDebugIntentFactory(settingsFragment, (DebugIntentFactory) Preconditions.checkNotNullFromComponent(this.b.debugIntentFactory()));
        SettingsFragment_MembersInjector.injectResourceProvider(settingsFragment, a());
    }
}

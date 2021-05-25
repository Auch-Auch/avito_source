package com.avito.android.safedeal.profile_settings.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.profile_settings.DeliveryProfileSettingsViewModelFactory;
import com.avito.android.safedeal.profile_settings.DeliveryProfileSettingsViewModelFactory_Factory;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment_MembersInjector;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractorImpl;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractorImpl_Factory;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsResourceProvider;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsResourceProviderImpl;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsResourceProviderImpl_Factory;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel;
import com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsContentsComparator;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsContentsComparator_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverterImpl;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverterImpl_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemBlueprint_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonBlueprint_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonPresenterImpl_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemBlueprint_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemBlueprint_Factory;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemPresenterImpl_Factory;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerProfileDeliverySettingsComponent implements ProfileDeliverySettingsComponent {
    public Provider<SkeletonPresenter> A;
    public Provider<SkeletonBlueprint> B;
    public Provider<ListItemPresenter> C;
    public Provider<ListItemBlueprint> D;
    public Provider<ItemBinder> E;
    public Provider<AdapterPresenter> F;
    public Provider<SimpleRecyclerAdapter> G;
    public Provider<ListUpdateCallback> H;
    public Provider<ProfileDeliverySettingsContentsComparator> I;
    public Provider<DiffCalculator> J;
    public Provider<DataAwareAdapterPresenter> K;
    public final ProfileDeliverySettingsDependencies a;
    public Provider<Fragment> b;
    public Provider<SafeDealApi> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<SchedulersFactory3> e;
    public Provider<ProfileDeliverySettingsInteractorImpl> f;
    public Provider<Context> g;
    public Provider<AttributedTextFormatter> h;
    public Provider<ProfileDeliverySettingsItemsConverterImpl> i;
    public Provider<ProfileDeliverySettingsItemsConverter> j;
    public Provider<Resources> k;
    public Provider<ProfileDeliverySettingsResourceProviderImpl> l;
    public Provider<ProfileDeliverySettingsResourceProvider> m;
    public Provider<ScreenTrackerFactory> n;
    public Provider<String> o = DoubleCheck.provider(ProfileDeliverySettingsTrackerModule_ProvidesScreenContentTypeFactory.create());
    public Provider<ScreenDiInjectTracker> p = DoubleCheck.provider(ProfileDeliverySettingsTrackerModule_ProvidesScreenDiInjectTracker$safedeal_releaseFactory.create(this.n, TimerFactory_Factory.create(), this.o));
    public Provider<ScreenInitTracker> q = DoubleCheck.provider(ProfileDeliverySettingsTrackerModule_ProvidesScreenInitTrackerFactory.create(this.n, TimerFactory_Factory.create(), this.o));
    public Provider<ScreenFlowTrackerProvider> r;
    public Provider<BaseScreenPerformanceTrackerImpl> s;
    public Provider<BaseScreenPerformanceTracker> t;
    public Provider<DeliveryProfileSettingsViewModelFactory> u;
    public Provider<ProfileDeliverySettingsViewModel> v;
    public Provider<SwitcherItemPresenter> w;
    public Provider<SwitcherItemBlueprint> x;
    public Provider<TextItemPresenter> y;
    public Provider<TextItemBlueprint> z;

    public static final class b implements ProfileDeliverySettingsComponent.Builder {
        public Activity a;
        public Resources b;
        public Fragment c;
        public ProfileDeliverySettingsDependencies d;

        public b(a aVar) {
        }

        @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent.Builder
        public ProfileDeliverySettingsComponent.Builder activity(Activity activity) {
            this.a = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent.Builder
        public ProfileDeliverySettingsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Activity.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, ProfileDeliverySettingsDependencies.class);
            return new DaggerProfileDeliverySettingsComponent(this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent.Builder
        public ProfileDeliverySettingsComponent.Builder deliveryProfileSettingsDependencies(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.d = (ProfileDeliverySettingsDependencies) Preconditions.checkNotNull(profileDeliverySettingsDependencies);
            return this;
        }

        @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent.Builder
        public ProfileDeliverySettingsComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent.Builder
        public ProfileDeliverySettingsComponent.Builder viewModelFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Context> {
        public final ProfileDeliverySettingsDependencies a;

        public c(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.a = profileDeliverySettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class d implements Provider<SafeDealApi> {
        public final ProfileDeliverySettingsDependencies a;

        public d(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.a = profileDeliverySettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SafeDealApi get() {
            return (SafeDealApi) Preconditions.checkNotNullFromComponent(this.a.safedealApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final ProfileDeliverySettingsDependencies a;

        public e(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.a = profileDeliverySettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulers3());
        }
    }

    public static class f implements Provider<ScreenTrackerFactory> {
        public final ProfileDeliverySettingsDependencies a;

        public f(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.a = profileDeliverySettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final ProfileDeliverySettingsDependencies a;

        public g(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies) {
            this.a = profileDeliverySettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerProfileDeliverySettingsComponent(ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies, Activity activity, Resources resources, Fragment fragment, a aVar) {
        this.a = profileDeliverySettingsDependencies;
        this.b = InstanceFactory.create(fragment);
        d dVar = new d(profileDeliverySettingsDependencies);
        this.c = dVar;
        g gVar = new g(profileDeliverySettingsDependencies);
        this.d = gVar;
        e eVar = new e(profileDeliverySettingsDependencies);
        this.e = eVar;
        this.f = DoubleCheck.provider(ProfileDeliverySettingsInteractorImpl_Factory.create(dVar, gVar, eVar));
        this.g = new c(profileDeliverySettingsDependencies);
        Provider<AttributedTextFormatter> provider = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.h = provider;
        ProfileDeliverySettingsItemsConverterImpl_Factory create = ProfileDeliverySettingsItemsConverterImpl_Factory.create(this.g, provider);
        this.i = create;
        this.j = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.k = create2;
        ProfileDeliverySettingsResourceProviderImpl_Factory create3 = ProfileDeliverySettingsResourceProviderImpl_Factory.create(create2);
        this.l = create3;
        this.m = DoubleCheck.provider(create3);
        this.n = new f(profileDeliverySettingsDependencies);
        Provider<ScreenFlowTrackerProvider> provider2 = DoubleCheck.provider(ProfileDeliverySettingsTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.n, TimerFactory_Factory.create()));
        this.r = provider2;
        BaseScreenPerformanceTrackerImpl_Factory create4 = BaseScreenPerformanceTrackerImpl_Factory.create(this.p, this.q, provider2, this.o);
        this.s = create4;
        Provider<BaseScreenPerformanceTracker> provider3 = DoubleCheck.provider(create4);
        this.t = provider3;
        Provider<DeliveryProfileSettingsViewModelFactory> provider4 = DoubleCheck.provider(DeliveryProfileSettingsViewModelFactory_Factory.create(this.f, this.e, this.j, this.m, provider3));
        this.u = provider4;
        Provider<ProfileDeliverySettingsViewModel> provider5 = DoubleCheck.provider(ProfileDeliverySettingsModule_ProvideDeliveryProfileSettingsViewModel$safedeal_releaseFactory.create(this.b, provider4));
        this.v = provider5;
        Provider<SwitcherItemPresenter> provider6 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideSwitcherItemPresenter$safedeal_releaseFactory.create(provider5));
        this.w = provider6;
        this.x = SwitcherItemBlueprint_Factory.create(provider6);
        Provider<TextItemPresenter> provider7 = DoubleCheck.provider(TextItemPresenterImpl_Factory.create());
        this.y = provider7;
        this.z = TextItemBlueprint_Factory.create(provider7);
        Provider<SkeletonPresenter> provider8 = DoubleCheck.provider(SkeletonPresenterImpl_Factory.create());
        this.A = provider8;
        this.B = SkeletonBlueprint_Factory.create(provider8);
        Provider<ListItemPresenter> provider9 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideListItemPresenter$safedeal_releaseFactory.create(this.v));
        this.C = provider9;
        ListItemBlueprint_Factory create5 = ListItemBlueprint_Factory.create(provider9);
        this.D = create5;
        Provider<ItemBinder> provider10 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideItemBinder$safedeal_releaseFactory.create(this.x, this.z, this.B, create5));
        this.E = provider10;
        Provider<AdapterPresenter> provider11 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideSimpleAdapterPresenter$safedeal_releaseFactory.create(provider10));
        this.F = provider11;
        Provider<SimpleRecyclerAdapter> provider12 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideRecyclerAdapter$safedeal_releaseFactory.create(provider11, this.E));
        this.G = provider12;
        this.H = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideListUpdateCallback$safedeal_releaseFactory.create(provider12));
        Provider<ProfileDeliverySettingsContentsComparator> provider13 = DoubleCheck.provider(ProfileDeliverySettingsContentsComparator_Factory.create());
        this.I = provider13;
        Provider<DiffCalculator> provider14 = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideDiffCalculator$safedeal_releaseFactory.create(provider13));
        this.J = provider14;
        this.K = DoubleCheck.provider(ProfileDeliverySettingsBlueprintsModule_ProvideDataAwareAdapterPresenter$safedeal_releaseFactory.create(this.H, this.F, provider14));
    }

    public static ProfileDeliverySettingsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsComponent
    public void inject(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        ProfileDeliverySettingsFragment_MembersInjector.injectViewModel(profileDeliverySettingsFragment, this.v.get());
        ProfileDeliverySettingsFragment_MembersInjector.injectAdapterPresenter(profileDeliverySettingsFragment, this.K.get());
        ProfileDeliverySettingsFragment_MembersInjector.injectRecyclerViewAdapter(profileDeliverySettingsFragment, this.G.get());
        ProfileDeliverySettingsFragment_MembersInjector.injectDeepLinkIntentFactory(profileDeliverySettingsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ProfileDeliverySettingsFragment_MembersInjector.injectTracker(profileDeliverySettingsFragment, this.t.get());
    }
}

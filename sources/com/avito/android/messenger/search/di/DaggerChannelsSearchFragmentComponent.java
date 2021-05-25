package com.avito.android.messenger.search.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl_Factory;
import com.avito.android.messenger.di.RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory;
import com.avito.android.messenger.search.ChannelsSearchFragment;
import com.avito.android.messenger.search.ChannelsSearchFragment_MembersInjector;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl_Factory;
import com.avito.android.messenger.search.ChannelsSearchPresenter;
import com.avito.android.messenger.search.ChannelsSearchPresenterImpl;
import com.avito.android.messenger.search.ChannelsSearchPresenterImpl_Factory;
import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverterImpl;
import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverterImpl_Factory;
import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter;
import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter_Factory;
import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter;
import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter_Factory;
import com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerChannelsSearchFragmentComponent implements ChannelsSearchFragmentComponent {
    public Provider<ItemBlueprint<?, ?>> A;
    public Provider<Set<ItemBlueprint<?, ?>>> B;
    public Provider<ItemBinder> C;
    public Provider<AdapterPresenter> D;
    public final ChannelsSearchComponentDependencies a;
    public Provider<Fragment> b;
    public Provider<AccountStateProvider> c;
    public Provider<MessengerClient<AvitoMessengerApi>> d;
    public Provider<MessengerEntityConverter> e;
    public Provider<Analytics> f;
    public Provider<SchedulersFactory> g;
    public Provider<ChannelsSearchInteractorImpl> h;
    public Provider<ViewModelFactory> i;
    public Provider<ChannelsSearchInteractor> j;
    public Provider<Context> k;
    public Provider<AttributedTextFormatter> l;
    public Provider<LocalMessagePreviewProviderImpl> m;
    public Provider<TimeSource> n;
    public Provider<Locale> o;
    public Provider<Resources> p;
    public Provider<RelativeDateFormatter> q;
    public Provider<Features> r;
    public Provider<ChannelsSearchResultConverterImpl> s;
    public Provider<Formatter<Throwable>> t;
    public Provider<ChannelsSearchPresenterImpl> u;
    public Provider<Map<Class<?>, Provider<ViewModel>>> v;
    public Provider<ChannelsSearchPresenter> w;
    public Provider<ChannelItemPresenter> x;
    public Provider<ItemBlueprint<?, ?>> y;
    public Provider<SupportChannelItemPresenter> z;

    public static final class b implements ChannelsSearchFragmentComponent.Builder {
        public Fragment a;
        public Resources b;
        public ChannelsSearchComponentDependencies c;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent.Builder
        public ChannelsSearchFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, ChannelsSearchComponentDependencies.class);
            return new DaggerChannelsSearchFragmentComponent(this.c, this.a, this.b, null);
        }

        @Override // com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent.Builder
        public ChannelsSearchFragmentComponent.Builder channelsSearchDependencies(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.c = (ChannelsSearchComponentDependencies) Preconditions.checkNotNull(channelsSearchComponentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent.Builder
        public ChannelsSearchFragmentComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent.Builder
        public ChannelsSearchFragmentComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final ChannelsSearchComponentDependencies a;

        public c(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final ChannelsSearchComponentDependencies a;

        public d(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Context> {
        public final ChannelsSearchComponentDependencies a;

        public e(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class f implements Provider<Features> {
        public final ChannelsSearchComponentDependencies a;

        public f(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Locale> {
        public final ChannelsSearchComponentDependencies a;

        public g(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final ChannelsSearchComponentDependencies a;

        public h(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class i implements Provider<MessengerEntityConverter> {
        public final ChannelsSearchComponentDependencies a;

        public i(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerEntityConverter get() {
            return (MessengerEntityConverter) Preconditions.checkNotNullFromComponent(this.a.messengerEntityConverter());
        }
    }

    public static class j implements Provider<SchedulersFactory> {
        public final ChannelsSearchComponentDependencies a;

        public j(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class k implements Provider<TimeSource> {
        public final ChannelsSearchComponentDependencies a;

        public k(ChannelsSearchComponentDependencies channelsSearchComponentDependencies) {
            this.a = channelsSearchComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerChannelsSearchFragmentComponent(ChannelsSearchComponentDependencies channelsSearchComponentDependencies, Fragment fragment, Resources resources, a aVar) {
        this.a = channelsSearchComponentDependencies;
        this.b = InstanceFactory.create(fragment);
        c cVar = new c(channelsSearchComponentDependencies);
        this.c = cVar;
        h hVar = new h(channelsSearchComponentDependencies);
        this.d = hVar;
        i iVar = new i(channelsSearchComponentDependencies);
        this.e = iVar;
        d dVar = new d(channelsSearchComponentDependencies);
        this.f = dVar;
        j jVar = new j(channelsSearchComponentDependencies);
        this.g = jVar;
        this.h = ChannelsSearchInteractorImpl_Factory.create(cVar, hVar, iVar, dVar, jVar);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.i = delegateFactory;
        this.j = DoubleCheck.provider(ChannelsSearchModule_ProvideChannelsSearchInteractor$messenger_releaseFactory.create(this.b, delegateFactory));
        this.k = new e(channelsSearchComponentDependencies);
        Provider<AttributedTextFormatter> provider = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.l = provider;
        this.m = LocalMessagePreviewProviderImpl_Factory.create(this.k, provider);
        this.n = new k(channelsSearchComponentDependencies);
        this.o = new g(channelsSearchComponentDependencies);
        Factory create = InstanceFactory.create(resources);
        this.p = create;
        Provider<RelativeDateFormatter> provider2 = SingleCheck.provider(RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory.create(this.n, this.o, create));
        this.q = provider2;
        f fVar = new f(channelsSearchComponentDependencies);
        this.r = fVar;
        this.s = ChannelsSearchResultConverterImpl_Factory.create(this.m, provider2, fVar);
        Provider<Formatter<Throwable>> provider3 = DoubleCheck.provider(ChannelsSearchModule_ProvideErrorFormatterFactory.create(this.p));
        this.t = provider3;
        this.u = ChannelsSearchPresenterImpl_Factory.create(this.j, this.s, provider3, this.g);
        MapProviderFactory build = MapProviderFactory.builder(2).put((MapProviderFactory.Builder) ChannelsSearchInteractorImpl.class, (Provider) this.h).put((MapProviderFactory.Builder) ChannelsSearchPresenterImpl.class, (Provider) this.u).build();
        this.v = build;
        DelegateFactory.setDelegate(this.i, SingleCheck.provider(ViewModelFactory_Factory.create(build)));
        Provider<ChannelsSearchPresenter> provider4 = DoubleCheck.provider(ChannelsSearchModule_ProvideChannelsSearchPresenter$messenger_releaseFactory.create(this.b, this.i));
        this.w = provider4;
        ChannelItemPresenter_Factory create2 = ChannelItemPresenter_Factory.create(provider4);
        this.x = create2;
        this.y = ChannelsSearchModule_ProvideChannelItemBlueprintFactory.create(create2);
        SupportChannelItemPresenter_Factory create3 = SupportChannelItemPresenter_Factory.create(this.w);
        this.z = create3;
        this.A = ChannelsSearchModule_ProvideSupportChannelItemBlueprintFactory.create(create3);
        SetFactory build2 = SetFactory.builder(3, 0).addProvider(ChannelsSearchModule_ProvidePaginationItemBlueprintFactory.create()).addProvider(this.y).addProvider(this.A).build();
        this.B = build2;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(ChannelsSearchModule_ProvideItemBinderFactory.create(build2));
        this.C = provider5;
        this.D = DoubleCheck.provider(ChannelsSearchModule_ProvideAdapterPresenterFactory.create(provider5));
    }

    public static ChannelsSearchFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent
    public void inject(ChannelsSearchFragment channelsSearchFragment) {
        ChannelsSearchFragment_MembersInjector.injectActivityIntentFactory(channelsSearchFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ChannelsSearchFragment_MembersInjector.injectSearchPresenter(channelsSearchFragment, this.w.get());
        ChannelsSearchFragment_MembersInjector.injectAdapterPresenter(channelsSearchFragment, this.D.get());
        ChannelsSearchFragment_MembersInjector.injectItemBinder(channelsSearchFragment, this.C.get());
        ChannelsSearchFragment_MembersInjector.injectBuildInfo(channelsSearchFragment, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
    }
}

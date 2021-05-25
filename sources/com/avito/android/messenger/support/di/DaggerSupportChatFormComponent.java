package com.avito.android.messenger.support.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.support.SupportChatFormFragment;
import com.avito.android.messenger.support.SupportChatFormFragment_MembersInjector;
import com.avito.android.messenger.support.SupportChatFormInteractorImpl;
import com.avito.android.messenger.support.SupportChatFormInteractorImpl_Factory;
import com.avito.android.messenger.support.SupportChatFormPresenterImpl;
import com.avito.android.messenger.support.SupportChatFormPresenterImpl_Factory;
import com.avito.android.messenger.support.di.SupportChatFormComponent;
import com.avito.android.remote.SupportApi;
import com.avito.android.util.Formatter;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerSupportChatFormComponent implements SupportChatFormComponent {
    public final Fragment a;
    public final SupportChatFormDependencies b;
    public Provider<Integer> c;
    public Provider<SchedulersFactory> d;
    public Provider<SupportApi> e;
    public Provider<MessengerClient<AvitoMessengerApi>> f;
    public Provider<RandomKeyProvider> g;
    public Provider<SupportChatFormInteractorImpl> h;
    public Provider<Resources> i;
    public Provider<Formatter<Throwable>> j;
    public Provider<SupportChatFormPresenterImpl> k;
    public Provider<Map<Class<?>, Provider<ViewModel>>> l;
    public Provider<ViewModelFactory> m;

    public static final class b implements SupportChatFormComponent.Builder {
        public Integer a;
        public Fragment b;
        public Resources c;
        public SupportChatFormDependencies d;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.support.di.SupportChatFormComponent.Builder
        public SupportChatFormComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Integer.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, SupportChatFormDependencies.class);
            return new DaggerSupportChatFormComponent(this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.messenger.support.di.SupportChatFormComponent.Builder
        public SupportChatFormComponent.Builder dependencies(SupportChatFormDependencies supportChatFormDependencies) {
            this.d = (SupportChatFormDependencies) Preconditions.checkNotNull(supportChatFormDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.support.di.SupportChatFormComponent.Builder
        public SupportChatFormComponent.Builder fragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.support.di.SupportChatFormComponent.Builder
        public SupportChatFormComponent.Builder problemId(int i) {
            this.a = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }

        @Override // com.avito.android.messenger.support.di.SupportChatFormComponent.Builder
        public SupportChatFormComponent.Builder resources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final SupportChatFormDependencies a;

        public c(SupportChatFormDependencies supportChatFormDependencies) {
            this.a = supportChatFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class d implements Provider<RandomKeyProvider> {
        public final SupportChatFormDependencies a;

        public d(SupportChatFormDependencies supportChatFormDependencies) {
            this.a = supportChatFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final SupportChatFormDependencies a;

        public e(SupportChatFormDependencies supportChatFormDependencies) {
            this.a = supportChatFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<SupportApi> {
        public final SupportChatFormDependencies a;

        public f(SupportChatFormDependencies supportChatFormDependencies) {
            this.a = supportChatFormDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SupportApi get() {
            return (SupportApi) Preconditions.checkNotNullFromComponent(this.a.supportApi());
        }
    }

    public DaggerSupportChatFormComponent(SupportChatFormDependencies supportChatFormDependencies, Integer num, Fragment fragment, Resources resources, a aVar) {
        this.a = fragment;
        this.b = supportChatFormDependencies;
        this.c = InstanceFactory.create(num);
        this.d = new e(supportChatFormDependencies);
        f fVar = new f(supportChatFormDependencies);
        this.e = fVar;
        c cVar = new c(supportChatFormDependencies);
        this.f = cVar;
        d dVar = new d(supportChatFormDependencies);
        this.g = dVar;
        this.h = SupportChatFormInteractorImpl_Factory.create(fVar, cVar, dVar);
        Factory create = InstanceFactory.create(resources);
        this.i = create;
        SupportChatFormModule_ProvideErrorFormatterFactory create2 = SupportChatFormModule_ProvideErrorFormatterFactory.create(create);
        this.j = create2;
        this.k = SupportChatFormPresenterImpl_Factory.create(this.c, this.d, this.h, create2);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) SupportChatFormPresenterImpl.class, (Provider) this.k).build();
        this.l = build;
        this.m = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static SupportChatFormComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.support.di.SupportChatFormComponent
    public void inject(SupportChatFormFragment supportChatFormFragment) {
        SupportChatFormFragment_MembersInjector.injectPresenter(supportChatFormFragment, SupportChatFormModule_ProvideSupportChatFormPresenterFactory.provideSupportChatFormPresenter(this.m.get(), this.a));
        SupportChatFormFragment_MembersInjector.injectActivityIntentFactory(supportChatFormFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        SupportChatFormFragment_MembersInjector.injectAnalytics(supportChatFormFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
    }
}

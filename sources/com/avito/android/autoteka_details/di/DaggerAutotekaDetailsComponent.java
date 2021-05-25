package com.avito.android.autoteka_details.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.autoteka_details.AutotekaDetailsConverter;
import com.avito.android.autoteka_details.AutotekaDetailsConverterImpl;
import com.avito.android.autoteka_details.AutotekaDetailsConverterImpl_Factory;
import com.avito.android.autoteka_details.AutotekaDetailsFragment;
import com.avito.android.autoteka_details.AutotekaDetailsFragment_MembersInjector;
import com.avito.android.autoteka_details.AutotekaDetailsPresenter;
import com.avito.android.autoteka_details.AutotekaDetailsPresenterImpl;
import com.avito.android.autoteka_details.AutotekaDetailsPresenterImpl_Factory;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl_Factory;
import com.avito.android.autoteka_details.di.AutotekaDetailsComponent;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerAutotekaDetailsComponent implements AutotekaDetailsComponent {
    public final AutotekaDetailsDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<AutotekaApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<Kundle> g;
    public Provider<AutotekaDetailsResponse> h;
    public Provider<AutotekaDetailsInteractorImpl> i;
    public Provider<AutotekaDetailsInteractor> j;
    public Provider<Resources> k;
    public Provider<AttributedTextFormatter> l;
    public Provider<AutotekaDetailsConverterImpl> m;
    public Provider<AutotekaDetailsConverter> n;
    public Provider<Analytics> o;
    public Provider<Boolean> p;
    public Provider<AutotekaDetailsPresenterImpl> q;
    public Provider<AutotekaDetailsPresenter> r;

    public static final class b implements AutotekaDetailsComponent.Builder {
        public AutotekaDetailsDependencies a;
        public Resources b;
        public String c;
        public String d;
        public Boolean e;
        public Kundle f;
        public AutotekaDetailsResponse g;

        public b(a aVar) {
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AutotekaDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.e, Boolean.class);
            return new DaggerAutotekaDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder dependentOn(AutotekaDetailsDependencies autotekaDetailsDependencies) {
            this.a = (AutotekaDetailsDependencies) Preconditions.checkNotNull(autotekaDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withAdvertId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withAutotekaDetails(AutotekaDetailsResponse autotekaDetailsResponse) {
            this.g = autotekaDetailsResponse;
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withInteractorState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withIsRestored(boolean z) {
            this.e = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent.Builder
        public AutotekaDetailsComponent.Builder withUtmQuery(String str) {
            this.d = str;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final AutotekaDetailsDependencies a;

        public c(AutotekaDetailsDependencies autotekaDetailsDependencies) {
            this.a = autotekaDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<AutotekaApi> {
        public final AutotekaDetailsDependencies a;

        public d(AutotekaDetailsDependencies autotekaDetailsDependencies) {
            this.a = autotekaDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AutotekaApi get() {
            return (AutotekaApi) Preconditions.checkNotNullFromComponent(this.a.autotekaApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final AutotekaDetailsDependencies a;

        public e(AutotekaDetailsDependencies autotekaDetailsDependencies) {
            this.a = autotekaDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final AutotekaDetailsDependencies a;

        public f(AutotekaDetailsDependencies autotekaDetailsDependencies) {
            this.a = autotekaDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerAutotekaDetailsComponent(AutotekaDetailsDependencies autotekaDetailsDependencies, Resources resources, String str, String str2, Boolean bool, Kundle kundle, AutotekaDetailsResponse autotekaDetailsResponse, a aVar) {
        this.a = autotekaDetailsDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.createNullable(str2);
        this.d = new d(autotekaDetailsDependencies);
        this.e = new e(autotekaDetailsDependencies);
        this.f = new f(autotekaDetailsDependencies);
        this.g = InstanceFactory.createNullable(kundle);
        Factory createNullable = InstanceFactory.createNullable(autotekaDetailsResponse);
        this.h = createNullable;
        AutotekaDetailsInteractorImpl_Factory create = AutotekaDetailsInteractorImpl_Factory.create(this.b, this.d, this.e, this.f, this.g, createNullable);
        this.i = create;
        this.j = DoubleCheck.provider(create);
        this.k = InstanceFactory.create(resources);
        Provider<AttributedTextFormatter> provider = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.l = provider;
        AutotekaDetailsConverterImpl_Factory create2 = AutotekaDetailsConverterImpl_Factory.create(this.k, provider);
        this.m = create2;
        this.n = DoubleCheck.provider(create2);
        this.o = new c(autotekaDetailsDependencies);
        Factory create3 = InstanceFactory.create(bool);
        this.p = create3;
        AutotekaDetailsPresenterImpl_Factory create4 = AutotekaDetailsPresenterImpl_Factory.create(this.b, this.c, this.j, this.n, this.e, this.o, create3);
        this.q = create4;
        this.r = DoubleCheck.provider(create4);
    }

    public static AutotekaDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.autoteka_details.di.AutotekaDetailsComponent
    public void inject(AutotekaDetailsFragment autotekaDetailsFragment) {
        AutotekaDetailsFragment_MembersInjector.injectPresenter(autotekaDetailsFragment, this.r.get());
        AutotekaDetailsFragment_MembersInjector.injectInteractor(autotekaDetailsFragment, this.j.get());
        AutotekaDetailsFragment_MembersInjector.injectImplicitIntent(autotekaDetailsFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        AutotekaDetailsFragment_MembersInjector.injectAnalytics(autotekaDetailsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AutotekaDetailsFragment_MembersInjector.injectFeatures(autotekaDetailsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

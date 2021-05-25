package com.avito.android.info.di;

import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.info.business.InfoInteractor;
import com.avito.android.info.business.InfoInteractorImpl;
import com.avito.android.info.business.InfoInteractorImpl_Factory;
import com.avito.android.info.di.InfoActivityComponent;
import com.avito.android.info.ui.InfoActivity;
import com.avito.android.info.ui.InfoActivity_MembersInjector;
import com.avito.android.info.ui.InfoPresenter;
import com.avito.android.info.ui.InfoPresenterImpl;
import com.avito.android.info.ui.InfoPresenterImpl_Factory;
import com.avito.android.remote.InfoApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerInfoActivityComponent implements InfoActivityComponent {
    public final InfoActivityDependencies a;
    public Provider<String> b;
    public Provider<InfoApi> c;
    public Provider<String> d;
    public Provider<InfoInteractorImpl> e;
    public Provider<InfoInteractor> f;
    public Provider<SchedulersFactory> g;
    public Provider<Bundle> h;
    public Provider<InfoPresenterImpl> i;
    public Provider<InfoPresenter> j;

    public static final class b implements InfoActivityComponent.Builder {
        public InfoActivityDependencies a;
        public String b;
        public String c;
        public Bundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.info.di.InfoActivityComponent.Builder
        public InfoActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, InfoActivityDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            return new DaggerInfoActivityComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.info.di.InfoActivityComponent.Builder
        public InfoActivityComponent.Builder dependentOn(InfoActivityDependencies infoActivityDependencies) {
            this.a = (InfoActivityDependencies) Preconditions.checkNotNull(infoActivityDependencies);
            return this;
        }

        @Override // com.avito.android.info.di.InfoActivityComponent.Builder
        public InfoActivityComponent.Builder withPath(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.info.di.InfoActivityComponent.Builder
        public InfoActivityComponent.Builder withState(Bundle bundle) {
            this.d = bundle;
            return this;
        }

        @Override // com.avito.android.info.di.InfoActivityComponent.Builder
        public InfoActivityComponent.Builder withTitle(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<InfoApi> {
        public final InfoActivityDependencies a;

        public c(InfoActivityDependencies infoActivityDependencies) {
            this.a = infoActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public InfoApi get() {
            return (InfoApi) Preconditions.checkNotNullFromComponent(this.a.infoApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final InfoActivityDependencies a;

        public d(InfoActivityDependencies infoActivityDependencies) {
            this.a = infoActivityDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerInfoActivityComponent(InfoActivityDependencies infoActivityDependencies, String str, String str2, Bundle bundle, a aVar) {
        this.a = infoActivityDependencies;
        this.b = InstanceFactory.create(str);
        this.c = new c(infoActivityDependencies);
        Factory create = InstanceFactory.create(str2);
        this.d = create;
        InfoInteractorImpl_Factory create2 = InfoInteractorImpl_Factory.create(this.c, create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new d(infoActivityDependencies);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.h = createNullable;
        InfoPresenterImpl_Factory create3 = InfoPresenterImpl_Factory.create(this.b, this.f, this.g, createNullable);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
    }

    public static InfoActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.info.di.InfoActivityComponent
    public void inject(InfoActivity infoActivity) {
        InfoActivity_MembersInjector.injectInfoPresenter(infoActivity, this.j.get());
        InfoActivity_MembersInjector.injectAnalytics(infoActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

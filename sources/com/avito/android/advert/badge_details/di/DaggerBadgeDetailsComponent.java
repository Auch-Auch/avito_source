package com.avito.android.advert.badge_details.di;

import android.content.res.Resources;
import com.avito.android.advert.badge_details.BadgeDetailsActivity;
import com.avito.android.advert.badge_details.BadgeDetailsActivity_MembersInjector;
import com.avito.android.advert.badge_details.BadgeDetailsInteractor;
import com.avito.android.advert.badge_details.BadgeDetailsInteractorImpl;
import com.avito.android.advert.badge_details.BadgeDetailsInteractorImpl_Factory;
import com.avito.android.advert.badge_details.BadgeDetailsPresenter;
import com.avito.android.advert.badge_details.BadgeDetailsPresenterImpl;
import com.avito.android.advert.badge_details.BadgeDetailsPresenterImpl_Factory;
import com.avito.android.advert.badge_details.BadgeDetailsResourceProvider;
import com.avito.android.advert.badge_details.BadgeDetailsResourceProviderImpl;
import com.avito.android.advert.badge_details.BadgeDetailsResourceProviderImpl_Factory;
import com.avito.android.advert.badge_details.di.BadgeDetailsComponent;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerBadgeDetailsComponent implements BadgeDetailsComponent {
    public final BadgeDetailsDependencies a;
    public Provider<Integer> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<Kundle> e;
    public Provider<Analytics> f;
    public Provider<AdvertDetailsApi> g;
    public Provider<BadgeDetailsInteractorImpl> h;
    public Provider<BadgeDetailsInteractor> i;
    public Provider<Resources> j;
    public Provider<BadgeDetailsResourceProviderImpl> k;
    public Provider<BadgeDetailsResourceProvider> l;
    public Provider<SchedulersFactory3> m;
    public Provider<BadgeDetailsPresenterImpl> n;
    public Provider<BadgeDetailsPresenter> o;

    public static final class b implements BadgeDetailsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.advert.badge_details.di.BadgeDetailsComponent.Factory
        public BadgeDetailsComponent create(int i, String str, String str2, Kundle kundle, Resources resources, BadgeDetailsDependencies badgeDetailsDependencies) {
            Preconditions.checkNotNull(Integer.valueOf(i));
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(badgeDetailsDependencies);
            return new DaggerBadgeDetailsComponent(badgeDetailsDependencies, Integer.valueOf(i), str, str2, kundle, resources, null);
        }
    }

    public static class c implements Provider<AdvertDetailsApi> {
        public final BadgeDetailsDependencies a;

        public c(BadgeDetailsDependencies badgeDetailsDependencies) {
            this.a = badgeDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class d implements Provider<Analytics> {
        public final BadgeDetailsDependencies a;

        public d(BadgeDetailsDependencies badgeDetailsDependencies) {
            this.a = badgeDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final BadgeDetailsDependencies a;

        public e(BadgeDetailsDependencies badgeDetailsDependencies) {
            this.a = badgeDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerBadgeDetailsComponent(BadgeDetailsDependencies badgeDetailsDependencies, Integer num, String str, String str2, Kundle kundle, Resources resources, a aVar) {
        this.a = badgeDetailsDependencies;
        this.b = InstanceFactory.create(num);
        this.c = InstanceFactory.create(str);
        this.d = InstanceFactory.create(str2);
        this.e = InstanceFactory.createNullable(kundle);
        this.f = new d(badgeDetailsDependencies);
        c cVar = new c(badgeDetailsDependencies);
        this.g = cVar;
        BadgeDetailsInteractorImpl_Factory create = BadgeDetailsInteractorImpl_Factory.create(cVar);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.j = create2;
        BadgeDetailsResourceProviderImpl_Factory create3 = BadgeDetailsResourceProviderImpl_Factory.create(create2);
        this.k = create3;
        Provider<BadgeDetailsResourceProvider> provider = DoubleCheck.provider(create3);
        this.l = provider;
        e eVar = new e(badgeDetailsDependencies);
        this.m = eVar;
        BadgeDetailsPresenterImpl_Factory create4 = BadgeDetailsPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, this.f, this.i, provider, eVar);
        this.n = create4;
        this.o = DoubleCheck.provider(create4);
    }

    public static BadgeDetailsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.advert.badge_details.di.BadgeDetailsComponent
    public void inject(BadgeDetailsActivity badgeDetailsActivity) {
        BadgeDetailsActivity_MembersInjector.injectPresenter(badgeDetailsActivity, this.o.get());
        BadgeDetailsActivity_MembersInjector.injectDeepLinkIntentFactory(badgeDetailsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
    }
}

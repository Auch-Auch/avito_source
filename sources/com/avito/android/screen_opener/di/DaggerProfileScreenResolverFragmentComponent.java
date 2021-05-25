package com.avito.android.screen_opener.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker_Impl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.screen_opener.ProfileScreenResolverFragment;
import com.avito.android.screen_opener.ProfileScreenResolverFragment_MembersInjector;
import com.avito.android.screen_opener.ProfileScreenResolverInteractor;
import com.avito.android.screen_opener.ProfileScreenResolverInteractorImpl;
import com.avito.android.screen_opener.ProfileScreenResolverInteractorImpl_Factory;
import com.avito.android.screen_opener.ProfileScreenResolverPresenter;
import com.avito.android.screen_opener.ProfileScreenResolverPresenterImpl;
import com.avito.android.screen_opener.ProfileScreenResolverPresenterImpl_Factory;
import com.avito.android.screen_opener.di.ProfileScreenResolverFragmentComponent;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerProfileScreenResolverFragmentComponent implements ProfileScreenResolverFragmentComponent {
    public final ProfileScreenResolverFragmentDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<PublicProfileApi> d;
    public Provider<SchedulersFactory3> e;
    public Provider<ProfileScreenResolverInteractorImpl> f;
    public Provider<ProfileScreenResolverInteractor> g;
    public Provider<UnknownScreenTracker.Impl> h;
    public Provider<UnknownScreenTracker> i;
    public Provider<Resources> j;
    public Provider<ErrorFormatterImpl> k;
    public Provider<ErrorFormatter> l;
    public Provider<ErrorHelperImpl> m;
    public Provider<ErrorHelper> n;
    public Provider<ProfileScreenResolverPresenterImpl> o;
    public Provider<ProfileScreenResolverPresenter> p;

    public static final class b implements ProfileScreenResolverFragmentComponent.Builder {
        public b(a aVar) {
        }

        @Override // com.avito.android.screen_opener.di.ProfileScreenResolverFragmentComponent.Builder
        public ProfileScreenResolverFragmentComponent create(String str, String str2, Resources resources, ProfileScreenResolverFragmentDependencies profileScreenResolverFragmentDependencies) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(profileScreenResolverFragmentDependencies);
            return new DaggerProfileScreenResolverFragmentComponent(profileScreenResolverFragmentDependencies, str, str2, resources, null);
        }
    }

    public static class c implements Provider<PublicProfileApi> {
        public final ProfileScreenResolverFragmentDependencies a;

        public c(ProfileScreenResolverFragmentDependencies profileScreenResolverFragmentDependencies) {
            this.a = profileScreenResolverFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublicProfileApi get() {
            return (PublicProfileApi) Preconditions.checkNotNullFromComponent(this.a.publicProfileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final ProfileScreenResolverFragmentDependencies a;

        public d(ProfileScreenResolverFragmentDependencies profileScreenResolverFragmentDependencies) {
            this.a = profileScreenResolverFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerProfileScreenResolverFragmentComponent(ProfileScreenResolverFragmentDependencies profileScreenResolverFragmentDependencies, String str, String str2, Resources resources, a aVar) {
        this.a = profileScreenResolverFragmentDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.createNullable(str2);
        c cVar = new c(profileScreenResolverFragmentDependencies);
        this.d = cVar;
        d dVar = new d(profileScreenResolverFragmentDependencies);
        this.e = dVar;
        ProfileScreenResolverInteractorImpl_Factory create = ProfileScreenResolverInteractorImpl_Factory.create(cVar, dVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        UnknownScreenTracker_Impl_Factory create2 = UnknownScreenTracker_Impl_Factory.create(TimerFactory_Factory.create());
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.j = create3;
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(create3);
        this.k = create4;
        Provider<ErrorFormatter> provider = SingleCheck.provider(create4);
        this.l = provider;
        ErrorHelperImpl_Factory create5 = ErrorHelperImpl_Factory.create(provider);
        this.m = create5;
        Provider<ErrorHelper> provider2 = SingleCheck.provider(create5);
        this.n = provider2;
        ProfileScreenResolverPresenterImpl_Factory create6 = ProfileScreenResolverPresenterImpl_Factory.create(this.b, this.c, this.g, this.i, this.e, provider2);
        this.o = create6;
        this.p = DoubleCheck.provider(create6);
    }

    public static ProfileScreenResolverFragmentComponent.Builder factory() {
        return new b(null);
    }

    @Override // com.avito.android.screen_opener.di.ProfileScreenResolverFragmentComponent
    public void inject(ProfileScreenResolverFragment profileScreenResolverFragment) {
        ProfileScreenResolverFragment_MembersInjector.injectActivityIntentFactory(profileScreenResolverFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ProfileScreenResolverFragment_MembersInjector.injectPresenter(profileScreenResolverFragment, this.p.get());
        ProfileScreenResolverFragment_MembersInjector.injectPerformanceTracker(profileScreenResolverFragment, this.i.get());
    }
}

package com.avito.android.profile.tfa.settings.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.profile.tfa.settings.TfaSettingsFragment;
import com.avito.android.profile.tfa.settings.TfaSettingsFragment_MembersInjector;
import com.avito.android.profile.tfa.settings.TfaSettingsInteractor;
import com.avito.android.profile.tfa.settings.TfaSettingsInteractorImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsInteractorImpl_Factory;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenter;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl_Factory;
import com.avito.android.profile.tfa.settings.di.TfaSettingsComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerTfaSettingsComponent implements TfaSettingsComponent {
    public final TfaSettingsDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory3> c;
    public Provider<TfaSettingsInteractorImpl> d;
    public Provider<TfaSettingsInteractor> e;
    public Provider<Resources> f;
    public Provider<ErrorFormatterImpl> g;
    public Provider<ErrorFormatter> h;
    public Provider<ErrorHelperImpl> i;
    public Provider<ErrorHelper> j;
    public Provider<Kundle> k;
    public Provider<TfaSettingsPresenterImpl> l;
    public Provider<TfaSettingsPresenter> m;

    public static final class b implements TfaSettingsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.tfa.settings.di.TfaSettingsComponent.Factory
        public TfaSettingsComponent create(Activity activity, Resources resources, Kundle kundle, TfaSettingsDependencies tfaSettingsDependencies) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(kundle);
            Preconditions.checkNotNull(tfaSettingsDependencies);
            return new DaggerTfaSettingsComponent(tfaSettingsDependencies, activity, resources, kundle, null);
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final TfaSettingsDependencies a;

        public c(TfaSettingsDependencies tfaSettingsDependencies) {
            this.a = tfaSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final TfaSettingsDependencies a;

        public d(TfaSettingsDependencies tfaSettingsDependencies) {
            this.a = tfaSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerTfaSettingsComponent(TfaSettingsDependencies tfaSettingsDependencies, Activity activity, Resources resources, Kundle kundle, a aVar) {
        this.a = tfaSettingsDependencies;
        c cVar = new c(tfaSettingsDependencies);
        this.b = cVar;
        d dVar = new d(tfaSettingsDependencies);
        this.c = dVar;
        TfaSettingsInteractorImpl_Factory create = TfaSettingsInteractorImpl_Factory.create(cVar, dVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.f = create2;
        ErrorFormatterImpl_Factory create3 = ErrorFormatterImpl_Factory.create(create2);
        this.g = create3;
        Provider<ErrorFormatter> provider = SingleCheck.provider(create3);
        this.h = provider;
        ErrorHelperImpl_Factory create4 = ErrorHelperImpl_Factory.create(provider);
        this.i = create4;
        this.j = SingleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(kundle);
        this.k = create5;
        TfaSettingsPresenterImpl_Factory create6 = TfaSettingsPresenterImpl_Factory.create(this.e, this.c, this.j, create5);
        this.l = create6;
        this.m = DoubleCheck.provider(create6);
    }

    public static TfaSettingsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.tfa.settings.di.TfaSettingsComponent
    public void inject(TfaSettingsFragment tfaSettingsFragment) {
        TfaSettingsFragment_MembersInjector.injectPresenter(tfaSettingsFragment, this.m.get());
        TfaSettingsFragment_MembersInjector.injectActivityIntentFactory(tfaSettingsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        TfaSettingsFragment_MembersInjector.injectDeepLinkIntentFactory(tfaSettingsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}

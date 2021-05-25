package com.avito.android.soa_stat.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.soa_stat.di.SoaStatProfileSettingsComponent;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity_MembersInjector;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsInteractor;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsInteractorImpl;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsInteractorImpl_Factory;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSoaStatProfileSettingsComponent implements SoaStatProfileSettingsComponent {
    public final SoaStatProfileSettingsDependencies a;
    public final AttributedTextFormatter b;
    public Provider<ProfileApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<SoaStatProfileSettingsInteractorImpl> f;
    public Provider<SoaStatProfileSettingsInteractor> g;

    public static final class b implements SoaStatProfileSettingsComponent.Builder {
        public SoaStatProfileSettingsDependencies a;
        public AttributedTextFormatter b;

        public b(a aVar) {
        }

        @Override // com.avito.android.soa_stat.di.SoaStatProfileSettingsComponent.Builder
        public SoaStatProfileSettingsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SoaStatProfileSettingsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AttributedTextFormatter.class);
            return new DaggerSoaStatProfileSettingsComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.soa_stat.di.SoaStatProfileSettingsComponent.Builder
        public SoaStatProfileSettingsComponent.Builder soaStatDependencies(SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies) {
            this.a = (SoaStatProfileSettingsDependencies) Preconditions.checkNotNull(soaStatProfileSettingsDependencies);
            return this;
        }

        @Override // com.avito.android.soa_stat.di.SoaStatProfileSettingsComponent.Builder
        public SoaStatProfileSettingsComponent.Builder withFormatter(AttributedTextFormatter attributedTextFormatter) {
            this.b = (AttributedTextFormatter) Preconditions.checkNotNull(attributedTextFormatter);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final SoaStatProfileSettingsDependencies a;

        public c(SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies) {
            this.a = soaStatProfileSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final SoaStatProfileSettingsDependencies a;

        public d(SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies) {
            this.a = soaStatProfileSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final SoaStatProfileSettingsDependencies a;

        public e(SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies) {
            this.a = soaStatProfileSettingsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerSoaStatProfileSettingsComponent(SoaStatProfileSettingsDependencies soaStatProfileSettingsDependencies, AttributedTextFormatter attributedTextFormatter, a aVar) {
        this.a = soaStatProfileSettingsDependencies;
        this.b = attributedTextFormatter;
        c cVar = new c(soaStatProfileSettingsDependencies);
        this.c = cVar;
        d dVar = new d(soaStatProfileSettingsDependencies);
        this.d = dVar;
        e eVar = new e(soaStatProfileSettingsDependencies);
        this.e = eVar;
        SoaStatProfileSettingsInteractorImpl_Factory create = SoaStatProfileSettingsInteractorImpl_Factory.create(cVar, dVar, eVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
    }

    public static SoaStatProfileSettingsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.soa_stat.di.SoaStatProfileSettingsComponent
    public void inject(SoaStatProfileSettingsActivity soaStatProfileSettingsActivity) {
        SoaStatProfileSettingsActivity_MembersInjector.injectViewModelFactory(soaStatProfileSettingsActivity, new SoaStatProfileSettingsViewModelFactory(this.g.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.b, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())));
        SoaStatProfileSettingsActivity_MembersInjector.injectAnalytics(soaStatProfileSettingsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

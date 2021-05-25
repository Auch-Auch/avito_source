package com.avito.android.extended_profile_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsFragment;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsFragment_MembersInjector;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsInteractor;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsInteractorImpl_Factory;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModel;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModelFactory;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModelFactory_Factory;
import com.avito.android.extended_profile_settings.di.ExtendedProfileSettingsComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerExtendedProfileSettingsComponent implements ExtendedProfileSettingsComponent {
    public Provider<Fragment> a;
    public Provider<ExtendedProfileSettingsInteractor> b;
    public Provider<ExtendedProfileSettingsViewModelFactory> c;
    public Provider<ViewModelProvider.Factory> d;
    public Provider<ExtendedProfileSettingsViewModel> e;

    public static final class b implements ExtendedProfileSettingsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.extended_profile_settings.di.ExtendedProfileSettingsComponent.Factory
        public ExtendedProfileSettingsComponent create(Fragment fragment, ExtendedProfileSettingsDependencies extendedProfileSettingsDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(extendedProfileSettingsDependencies);
            return new DaggerExtendedProfileSettingsComponent(extendedProfileSettingsDependencies, fragment, null);
        }
    }

    public DaggerExtendedProfileSettingsComponent(ExtendedProfileSettingsDependencies extendedProfileSettingsDependencies, Fragment fragment, a aVar) {
        this.a = InstanceFactory.create(fragment);
        Provider<ExtendedProfileSettingsInteractor> provider = DoubleCheck.provider(ExtendedProfileSettingsInteractorImpl_Factory.create());
        this.b = provider;
        ExtendedProfileSettingsViewModelFactory_Factory create = ExtendedProfileSettingsViewModelFactory_Factory.create(provider);
        this.c = create;
        Provider<ViewModelProvider.Factory> provider2 = DoubleCheck.provider(create);
        this.d = provider2;
        this.e = DoubleCheck.provider(ExtendedProfileSettingsModule_ProvideViewModelFactory.create(this.a, provider2));
    }

    public static ExtendedProfileSettingsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.extended_profile_settings.di.ExtendedProfileSettingsComponent
    public void inject(ExtendedProfileSettingsFragment extendedProfileSettingsFragment) {
        ExtendedProfileSettingsFragment_MembersInjector.injectViewModel(extendedProfileSettingsFragment, this.e.get());
    }
}

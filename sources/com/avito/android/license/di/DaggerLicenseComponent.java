package com.avito.android.license.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.license.di.LicenseComponent;
import com.avito.android.license.ui.LicenseFragment;
import com.avito.android.license.ui.LicenseFragment_MembersInjector;
import dagger.internal.Preconditions;
public final class DaggerLicenseComponent implements LicenseComponent {
    public final CoreComponentDependencies a;

    public static final class b implements LicenseComponent.Builder {
        public CoreComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.license.di.LicenseComponent.Builder
        public LicenseComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            return new DaggerLicenseComponent(this.a, null);
        }

        @Override // com.avito.android.license.di.LicenseComponent.Builder
        public LicenseComponent.Builder dependentOn(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public DaggerLicenseComponent(CoreComponentDependencies coreComponentDependencies, a aVar) {
        this.a = coreComponentDependencies;
    }

    public static LicenseComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.license.di.LicenseComponent
    public void inject(LicenseFragment licenseFragment) {
        LicenseFragment_MembersInjector.injectAnalytics(licenseFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}

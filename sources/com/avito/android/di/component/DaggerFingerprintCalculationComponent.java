package com.avito.android.di.component;

import android.content.Context;
import com.avito.android.di.FingerprintCalculationDependencies;
import com.avito.android.di.component.FingerprintCalculationComponent;
import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.service.short_task.FingerprintCalculationTask;
import com.avito.android.service.short_task.FingerprintCalculationTask_MembersInjector;
import dagger.internal.Preconditions;
public final class DaggerFingerprintCalculationComponent implements FingerprintCalculationComponent {
    public final FingerprintCalculationDependencies a;

    public static final class b implements FingerprintCalculationComponent.Builder {
        public FingerprintCalculationDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.FingerprintCalculationComponent.Builder
        public FingerprintCalculationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FingerprintCalculationDependencies.class);
            return new DaggerFingerprintCalculationComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.FingerprintCalculationComponent.Builder
        public FingerprintCalculationComponent.Builder dependencies(FingerprintCalculationDependencies fingerprintCalculationDependencies) {
            this.a = (FingerprintCalculationDependencies) Preconditions.checkNotNull(fingerprintCalculationDependencies);
            return this;
        }
    }

    public DaggerFingerprintCalculationComponent(FingerprintCalculationDependencies fingerprintCalculationDependencies, a aVar) {
        this.a = fingerprintCalculationDependencies;
    }

    public static FingerprintCalculationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.FingerprintCalculationComponent
    public void inject(FingerprintCalculationTask fingerprintCalculationTask) {
        FingerprintCalculationTask_MembersInjector.injectContext(fingerprintCalculationTask, (Context) Preconditions.checkNotNullFromComponent(this.a.context()));
        FingerprintCalculationTask_MembersInjector.injectFingerprintStorage(fingerprintCalculationTask, (FingerprintStorage) Preconditions.checkNotNullFromComponent(this.a.fingerprintStorage()));
    }
}

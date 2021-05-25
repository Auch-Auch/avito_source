package com.avito.android.version_conflict.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.version_conflict.ResolveAppVersionConflictActivity;
import com.avito.android.version_conflict.ResolveAppVersionConflictActivity_MembersInjector;
import com.avito.android.version_conflict.di.ResolveAppVersionConflictComponent;
import dagger.internal.Preconditions;
public final class DaggerResolveAppVersionConflictComponent implements ResolveAppVersionConflictComponent {
    public final CoreComponentDependencies a;

    public static final class b implements ResolveAppVersionConflictComponent.Builder {
        public CoreComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.version_conflict.di.ResolveAppVersionConflictComponent.Builder
        public ResolveAppVersionConflictComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            return new DaggerResolveAppVersionConflictComponent(this.a, null);
        }

        @Override // com.avito.android.version_conflict.di.ResolveAppVersionConflictComponent.Builder
        public ResolveAppVersionConflictComponent.Builder dependentOn(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public DaggerResolveAppVersionConflictComponent(CoreComponentDependencies coreComponentDependencies, a aVar) {
        this.a = coreComponentDependencies;
    }

    public static ResolveAppVersionConflictComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.version_conflict.di.ResolveAppVersionConflictComponent
    public void inject(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity) {
        ResolveAppVersionConflictActivity_MembersInjector.injectImplicitIntentFactory(resolveAppVersionConflictActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}

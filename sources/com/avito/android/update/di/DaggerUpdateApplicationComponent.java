package com.avito.android.update.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.update.UpdateApplicationActivity;
import com.avito.android.update.UpdateApplicationActivity_MembersInjector;
import com.avito.android.update.UpdateApplicationPresenter;
import com.avito.android.update.UpdateApplicationPresenterImpl_Factory;
import com.avito.android.update.di.UpdateApplicationComponent;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerUpdateApplicationComponent implements UpdateApplicationComponent {
    public final CoreComponentDependencies a;
    public Provider<UpdateApplicationPresenter> b = DoubleCheck.provider(UpdateApplicationPresenterImpl_Factory.create());

    public static final class b implements UpdateApplicationComponent.Builder {
        public CoreComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.update.di.UpdateApplicationComponent.Builder
        public UpdateApplicationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            return new DaggerUpdateApplicationComponent(this.a, null);
        }

        @Override // com.avito.android.update.di.UpdateApplicationComponent.Builder
        public UpdateApplicationComponent.Builder dependentOn(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public DaggerUpdateApplicationComponent(CoreComponentDependencies coreComponentDependencies, a aVar) {
        this.a = coreComponentDependencies;
    }

    public static UpdateApplicationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.update.di.UpdateApplicationComponent
    public void inject(UpdateApplicationActivity updateApplicationActivity) {
        UpdateApplicationActivity_MembersInjector.injectIntentFactory(updateApplicationActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        UpdateApplicationActivity_MembersInjector.injectPresenter(updateApplicationActivity, this.b.get());
    }
}

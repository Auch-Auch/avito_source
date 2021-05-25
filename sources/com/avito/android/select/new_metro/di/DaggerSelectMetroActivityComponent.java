package com.avito.android.select.new_metro.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.select.new_metro.SelectMetroActivity;
import com.avito.android.select.new_metro.di.SelectMetroActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerSelectMetroActivityComponent implements SelectMetroActivityComponent {

    public static final class b implements SelectMetroActivityComponent.Builder {
        public CoreComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroActivityComponent.Builder
        public SelectMetroActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            return new DaggerSelectMetroActivityComponent(this.a);
        }

        @Override // com.avito.android.select.new_metro.di.SelectMetroActivityComponent.Builder
        public SelectMetroActivityComponent.Builder setDependencies(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public DaggerSelectMetroActivityComponent() {
    }

    public static SelectMetroActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.select.new_metro.di.SelectMetroActivityComponent
    public void inject(SelectMetroActivity selectMetroActivity) {
    }

    public DaggerSelectMetroActivityComponent(CoreComponentDependencies coreComponentDependencies) {
    }
}

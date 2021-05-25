package com.avito.android.ui.di;

import com.avito.android.Features;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.ui.di.TabBaseComponent;
import com.avito.android.ui.fragments.InjectHolder;
import com.avito.android.ui.fragments.InjectHolder_MembersInjector;
import dagger.internal.Preconditions;
public final class DaggerTabBaseComponent implements TabBaseComponent {
    public final CoreComponentDependencies a;

    public static final class b implements TabBaseComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.ui.di.TabBaseComponent.Factory
        public TabBaseComponent create(CoreComponentDependencies coreComponentDependencies) {
            Preconditions.checkNotNull(coreComponentDependencies);
            return new DaggerTabBaseComponent(coreComponentDependencies, null);
        }
    }

    public DaggerTabBaseComponent(CoreComponentDependencies coreComponentDependencies, a aVar) {
        this.a = coreComponentDependencies;
    }

    public static TabBaseComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.ui.di.TabBaseComponent
    public void inject(InjectHolder injectHolder) {
        InjectHolder_MembersInjector.injectFeatures(injectHolder, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

package com.avito.android.ui.activity;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.activity.BaseActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerBaseActivityComponent implements BaseActivityComponent {
    public final BaseActivityComponentDependencies a;

    public static final class b implements BaseActivityComponent.Builder {
        public BaseActivityComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.ui.activity.BaseActivityComponent.Builder
        public BaseActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BaseActivityComponentDependencies.class);
            return new DaggerBaseActivityComponent(this.a, null);
        }

        @Override // com.avito.android.ui.activity.BaseActivityComponent.Builder
        public BaseActivityComponent.Builder dependentOn(BaseActivityComponentDependencies baseActivityComponentDependencies) {
            this.a = (BaseActivityComponentDependencies) Preconditions.checkNotNull(baseActivityComponentDependencies);
            return this;
        }
    }

    public DaggerBaseActivityComponent(BaseActivityComponentDependencies baseActivityComponentDependencies, a aVar) {
        this.a = baseActivityComponentDependencies;
    }

    public static BaseActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.ui.activity.BaseActivityComponent
    public void inject(BaseActivity.Holder holder) {
        BaseActivity_Holder_MembersInjector.injectAnalytics(holder, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        BaseActivity_Holder_MembersInjector.injectFeatures(holder, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        BaseActivity_Holder_MembersInjector.injectDarkThemeConfig(holder, (DarkThemeConfig) Preconditions.checkNotNullFromComponent(this.a.darkThemeConfig()));
        BaseActivity_Holder_MembersInjector.injectPrefix(holder, (GraphitePrefix) Preconditions.checkNotNullFromComponent(this.a.graphitePrefix()));
    }
}

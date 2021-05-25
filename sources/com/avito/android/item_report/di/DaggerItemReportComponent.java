package com.avito.android.item_report.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.item_report.ItemReportActivity;
import com.avito.android.item_report.ItemReportFragment;
import com.avito.android.item_report.ItemReportFragment_MembersInjector;
import com.avito.android.item_report.di.ItemReportComponent;
import com.avito.android.item_report.remote.ItemReportApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Preconditions;
public final class DaggerItemReportComponent implements ItemReportComponent {
    public final ItemReportDependencies a;

    public static final class b implements ItemReportComponent.Builder {
        public ItemReportDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.item_report.di.ItemReportComponent.Builder
        public ItemReportComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ItemReportDependencies.class);
            return new DaggerItemReportComponent(this.a, null);
        }

        @Override // com.avito.android.item_report.di.ItemReportComponent.Builder
        public ItemReportComponent.Builder dependentOn(ItemReportDependencies itemReportDependencies) {
            this.a = (ItemReportDependencies) Preconditions.checkNotNull(itemReportDependencies);
            return this;
        }
    }

    public DaggerItemReportComponent(ItemReportDependencies itemReportDependencies, a aVar) {
        this.a = itemReportDependencies;
    }

    public static ItemReportComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.item_report.di.ItemReportComponent
    public void inject(ItemReportActivity itemReportActivity) {
    }

    @Override // com.avito.android.item_report.di.ItemReportComponent
    public void inject(ItemReportFragment itemReportFragment) {
        ItemReportFragment_MembersInjector.injectApi(itemReportFragment, (ItemReportApi) Preconditions.checkNotNullFromComponent(this.a.itemReportApi()));
        ItemReportFragment_MembersInjector.injectAnalytics(itemReportFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ItemReportFragment_MembersInjector.injectSchedulersFactory(itemReportFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }
}

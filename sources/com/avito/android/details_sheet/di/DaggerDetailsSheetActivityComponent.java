package com.avito.android.details_sheet.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.details_sheet.DetailsSheetActivity;
import com.avito.android.details_sheet.DetailsSheetActivity_MembersInjector;
import com.avito.android.details_sheet.di.DetailsSheetActivityComponent;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerDetailsSheetActivityComponent implements DetailsSheetActivityComponent {
    public final DetailsSheetActivityDependencies a;
    public Provider<AttributedTextFormatter> b = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());

    public static final class b implements DetailsSheetActivityComponent.Builder {
        public DetailsSheetActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.details_sheet.di.DetailsSheetActivityComponent.Builder
        public DetailsSheetActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DetailsSheetActivityDependencies.class);
            return new DaggerDetailsSheetActivityComponent(this.a, null);
        }

        @Override // com.avito.android.details_sheet.di.DetailsSheetActivityComponent.Builder
        public DetailsSheetActivityComponent.Builder dependencies(DetailsSheetActivityDependencies detailsSheetActivityDependencies) {
            this.a = (DetailsSheetActivityDependencies) Preconditions.checkNotNull(detailsSheetActivityDependencies);
            return this;
        }
    }

    public DaggerDetailsSheetActivityComponent(DetailsSheetActivityDependencies detailsSheetActivityDependencies, a aVar) {
        this.a = detailsSheetActivityDependencies;
    }

    public static DetailsSheetActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.details_sheet.di.DetailsSheetActivityComponent
    public void inject(DetailsSheetActivity detailsSheetActivity) {
        DetailsSheetActivity_MembersInjector.injectImplicitIntentFactory(detailsSheetActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        DetailsSheetActivity_MembersInjector.injectAttributedTextFormatter(detailsSheetActivity, this.b.get());
        DetailsSheetActivity_MembersInjector.injectAnalytics(detailsSheetActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DetailsSheetActivity_MembersInjector.injectDeeplinkIntentFactory(detailsSheetActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}

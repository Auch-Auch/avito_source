package com.avito.android.suggest_locations.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.LocationApi;
import com.avito.android.suggest_locations.SuggestLocationsFragment;
import com.avito.android.suggest_locations.SuggestLocationsFragment_MembersInjector;
import com.avito.android.suggest_locations.SuggestLocationsInteractorImpl;
import com.avito.android.suggest_locations.SuggestLocationsItemConverterImpl;
import com.avito.android.suggest_locations.SuggestLocationsPresenterImpl;
import com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractorImpl;
import com.avito.android.suggest_locations.di.SuggestLocationsComponent;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Preconditions;
public final class DaggerSuggestLocationsComponent implements SuggestLocationsComponent {
    public final SuggestLocationsDependencies a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Boolean e;
    public final String f;
    public final Boolean g;
    public final String h;
    public final Boolean i;
    public final Kundle j;

    public static final class b implements SuggestLocationsComponent.Builder {
        public SuggestLocationsDependencies a;
        public Kundle b;
        public String c;
        public String d;
        public Integer e;
        public String f;
        public Boolean g;
        public Boolean h;
        public String i;
        public Boolean j;
        public Boolean k;

        public b(a aVar) {
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder autoOpenKeyboard(boolean z) {
            this.j = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SuggestLocationsDependencies.class);
            Preconditions.checkBuilderRequirement(this.e, Integer.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.j, Boolean.class);
            Preconditions.checkBuilderRequirement(this.k, Boolean.class);
            return new DaggerSuggestLocationsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder categoryId(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder dependencies(SuggestLocationsDependencies suggestLocationsDependencies) {
            this.a = (SuggestLocationsDependencies) Preconditions.checkNotNull(suggestLocationsDependencies);
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder fromBlock(int i2) {
            this.e = (Integer) Preconditions.checkNotNull(Integer.valueOf(i2));
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder geoSessionId(String str) {
            this.i = str;
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder locationId(String str) {
            this.c = str;
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder query(String str) {
            this.f = str;
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder savedState(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder showHistoricalSuggest(boolean z) {
            this.g = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder suggestAddress(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent.Builder
        public SuggestLocationsComponent.Builder useLegacyApi(boolean z) {
            this.k = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public DaggerSuggestLocationsComponent(SuggestLocationsDependencies suggestLocationsDependencies, Kundle kundle, String str, String str2, Integer num, String str3, Boolean bool, Boolean bool2, String str4, Boolean bool3, Boolean bool4) {
        this.a = suggestLocationsDependencies;
        this.b = str;
        this.c = str2;
        this.d = num;
        this.e = bool2;
        this.f = str3;
        this.g = bool;
        this.h = str4;
        this.i = bool4;
        this.j = kundle;
    }

    public static SuggestLocationsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.suggest_locations.di.SuggestLocationsComponent
    public void inject(SuggestLocationsFragment suggestLocationsFragment) {
        SuggestLocationsFragment_MembersInjector.injectPresenter(suggestLocationsFragment, new SuggestLocationsPresenterImpl(new SuggestLocationsInteractorImpl((LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulers3()), new SuggestLocationsItemConverterImpl()), new SuggestLocationsAnalyticsInteractorImpl((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulers3()), this.b, this.c, this.d, this.e.booleanValue(), this.f, this.g.booleanValue(), this.h, this.i.booleanValue(), this.j));
        SuggestLocationsFragment_MembersInjector.injectActivityIntentFactory(suggestLocationsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SuggestLocationsFragment_MembersInjector.injectFeatures(suggestLocationsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

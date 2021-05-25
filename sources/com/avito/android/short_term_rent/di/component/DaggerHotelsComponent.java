package com.avito.android.short_term_rent.di.component;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.short_term_rent.di.component.HotelsComponent;
import com.avito.android.short_term_rent.hotels.HotelsActivity;
import com.avito.android.short_term_rent.hotels.HotelsActivity_MembersInjector;
import com.avito.android.short_term_rent.hotels.HotelsViewModelFactory;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.short_term_rent.hotels.data.HotelsRepositoryImpl;
import com.avito.android.short_term_rent.hotels.data.HotelsRepositoryImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerHotelsComponent implements HotelsComponent {
    public final String a;
    public final HotelsDependencies b;
    public Provider<ShortTermRentApi> c;
    public Provider<HotelsRepositoryImpl> d;
    public Provider<HotelsRepository> e;

    public static final class b implements HotelsComponent.Builder {
        public HotelsDependencies a;
        public String b;

        public b(a aVar) {
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsComponent.Builder
        public HotelsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HotelsDependencies.class);
            return new DaggerHotelsComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsComponent.Builder
        public HotelsComponent.Builder hotelsDependencies(HotelsDependencies hotelsDependencies) {
            this.a = (HotelsDependencies) Preconditions.checkNotNull(hotelsDependencies);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsComponent.Builder
        public HotelsComponent.Builder withMarker(String str) {
            this.b = str;
            return this;
        }
    }

    public static class c implements Provider<ShortTermRentApi> {
        public final HotelsDependencies a;

        public c(HotelsDependencies hotelsDependencies) {
            this.a = hotelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public DaggerHotelsComponent(HotelsDependencies hotelsDependencies, String str, a aVar) {
        this.a = str;
        this.b = hotelsDependencies;
        c cVar = new c(hotelsDependencies);
        this.c = cVar;
        HotelsRepositoryImpl_Factory create = HotelsRepositoryImpl_Factory.create(cVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
    }

    public static HotelsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.short_term_rent.di.component.HotelsComponent
    public void inject(HotelsActivity hotelsActivity) {
        HotelsActivity_MembersInjector.injectViewModelFactory(hotelsActivity, new HotelsViewModelFactory(this.a, this.e.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3()), (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics())));
        HotelsActivity_MembersInjector.injectIntentFactory(hotelsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        HotelsActivity_MembersInjector.injectDeepLinkIntentFactory(hotelsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.b.deepLinkIntentFactory()));
        HotelsActivity_MembersInjector.injectAnalytics(hotelsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
    }
}

package com.avito.android.short_term_rent.di.component;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.di.component.HotelsFilterLocationComponent;
import com.avito.android.short_term_rent.di.module.HotelsFiltersLocationModule_ProvideLocationViewModel$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.short_term_rent.hotels.data.HotelsRepositoryImpl;
import com.avito.android.short_term_rent.hotels.data.HotelsRepositoryImpl_Factory;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog_MembersInjector;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModel;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModelFactory;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModelFactory_Factory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class DaggerHotelsFilterLocationComponent implements HotelsFilterLocationComponent {
    public Provider<ShortTermRentApi> a;
    public Provider<HotelsRepositoryImpl> b;
    public Provider<HotelsRepository> c;
    public Provider<SchedulersFactory3> d;
    public Provider<List<HotelsLocation>> e;
    public Provider<HotelsLocationViewModelFactory> f;
    public Provider<HotelsLocationViewModel> g;

    public static final class b implements HotelsFilterLocationComponent.Builder {
        public List<HotelsLocation> a;
        public HotelsDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterLocationComponent.Builder
        public HotelsFilterLocationComponent.Builder bindDefaultLocations(List list) {
            this.a = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterLocationComponent.Builder
        public HotelsFilterLocationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, List.class);
            Preconditions.checkBuilderRequirement(this.b, HotelsDependencies.class);
            return new DaggerHotelsFilterLocationComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterLocationComponent.Builder
        public HotelsFilterLocationComponent.Builder dependencies(HotelsDependencies hotelsDependencies) {
            this.b = (HotelsDependencies) Preconditions.checkNotNull(hotelsDependencies);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final HotelsDependencies a;

        public c(HotelsDependencies hotelsDependencies) {
            this.a = hotelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class d implements Provider<ShortTermRentApi> {
        public final HotelsDependencies a;

        public d(HotelsDependencies hotelsDependencies) {
            this.a = hotelsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public DaggerHotelsFilterLocationComponent(HotelsDependencies hotelsDependencies, List list, a aVar) {
        d dVar = new d(hotelsDependencies);
        this.a = dVar;
        HotelsRepositoryImpl_Factory create = HotelsRepositoryImpl_Factory.create(dVar);
        this.b = create;
        this.c = DoubleCheck.provider(create);
        this.d = new c(hotelsDependencies);
        Factory create2 = InstanceFactory.create(list);
        this.e = create2;
        HotelsLocationViewModelFactory_Factory create3 = HotelsLocationViewModelFactory_Factory.create(this.c, this.d, create2);
        this.f = create3;
        this.g = DoubleCheck.provider(HotelsFiltersLocationModule_ProvideLocationViewModel$short_term_rent_releaseFactory.create(create3));
    }

    public static HotelsFilterLocationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.short_term_rent.di.component.HotelsFilterLocationComponent
    public void inject(HotelsLocationDialog hotelsLocationDialog) {
        HotelsLocationDialog_MembersInjector.injectViewModel(hotelsLocationDialog, this.g.get());
    }
}

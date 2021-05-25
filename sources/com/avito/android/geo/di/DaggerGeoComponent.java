package com.avito.android.geo.di;

import com.avito.android.geo.GeoPositionModel;
import com.avito.android.geo.GeoService;
import com.avito.android.geo.GeoService_MembersInjector;
import com.avito.android.geo.GeoStorage;
import com.avito.android.geo.di.GeoComponent;
import com.avito.android.server_time.TimeSource;
import com.avito.android.version_conflict.ConfigStorage;
import dagger.internal.Preconditions;
public final class DaggerGeoComponent implements GeoComponent {
    public final GeoDependencies a;

    public static final class b implements GeoComponent.Builder {
        public GeoDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.geo.di.GeoComponent.Builder
        public GeoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, GeoDependencies.class);
            return new DaggerGeoComponent(this.a, null);
        }

        @Override // com.avito.android.geo.di.GeoComponent.Builder
        public GeoComponent.Builder dependentOn(GeoDependencies geoDependencies) {
            this.a = (GeoDependencies) Preconditions.checkNotNull(geoDependencies);
            return this;
        }
    }

    public DaggerGeoComponent(GeoDependencies geoDependencies, a aVar) {
        this.a = geoDependencies;
    }

    public static GeoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.geo.di.GeoComponent
    public void inject(GeoService geoService) {
        GeoService_MembersInjector.injectGeoPositionModel(geoService, new GeoPositionModel((TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource()), (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage()), (ConfigStorage) Preconditions.checkNotNullFromComponent(this.a.configStorage())));
    }
}

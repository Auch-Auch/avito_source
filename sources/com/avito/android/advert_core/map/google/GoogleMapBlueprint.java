package com.avito.android.advert_core.map.google;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.android.advert_core.map.MapItem;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.advert_core.map.MapView;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/map/google/GoogleMapBlueprint;", "Lcom/avito/android/advert_core/map/MapBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert_core/map/MapPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/map/MapPresenter;", "getPresenter", "()Lcom/avito/android/advert_core/map/MapPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert_core/map/google/GoogleMapViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "markerIconFactory", "<init>", "(Lcom/avito/android/advert_core/map/MapPresenter;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleMapBlueprint extends MapBlueprint {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<GoogleMapViewImpl> a;
    @NotNull
    public final MapPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, GoogleMapViewImpl> {
        public final /* synthetic */ AmenityMarkerIconFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AmenityMarkerIconFactory amenityMarkerIconFactory) {
            super(2);
            this.a = amenityMarkerIconFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public GoogleMapViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new GoogleMapViewImpl(view2, this.a);
        }
    }

    @Inject
    public GoogleMapBlueprint(@NotNull MapPresenter mapPresenter, @NotNull AmenityMarkerIconFactory amenityMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(mapPresenter, "presenter");
        Intrinsics.checkNotNullParameter(amenityMarkerIconFactory, "markerIconFactory");
        this.b = mapPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.developments_catalog_google_map, new a(amenityMarkerIconFactory));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<GoogleMapViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof MapItem;
    }

    /* Return type fixed from 'com.avito.android.advert_core.map.MapPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<MapView, MapItem> getPresenter() {
        return this.b;
    }
}

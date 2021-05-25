package com.avito.android.advert_core.map.yandex;

import android.content.Context;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/map/yandex/YandexMapBlueprint;", "Lcom/avito/android/advert_core/map/MapBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert_core/map/yandex/YandexMapViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/advert_core/map/MapPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/map/MapPresenter;", "getPresenter", "()Lcom/avito/android/advert_core/map/MapPresenter;", "presenter", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "c", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "markerIconFactory", "<init>", "(Lcom/avito/android/advert_core/map/MapPresenter;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexMapBlueprint extends MapBlueprint {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<YandexMapViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.developments_catalog_yandex_map, new a(this));
    @NotNull
    public final MapPresenter b;
    public final AmenityMarkerIconFactory c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, YandexMapViewImpl> {
        public final /* synthetic */ YandexMapBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(YandexMapBlueprint yandexMapBlueprint) {
            super(2);
            this.a = yandexMapBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public YandexMapViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            currentThread.setContextClassLoader(context.getClassLoader());
            return new YandexMapViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public YandexMapBlueprint(@NotNull MapPresenter mapPresenter, @NotNull AmenityMarkerIconFactory amenityMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(mapPresenter, "presenter");
        Intrinsics.checkNotNullParameter(amenityMarkerIconFactory, "markerIconFactory");
        this.b = mapPresenter;
        this.c = amenityMarkerIconFactory;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<YandexMapViewImpl> getViewHolderProvider() {
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

package com.avito.android.search.map.reducer;

import a2.g.r.g;
import com.avito.android.avito_map.AvitoMapZoomLevel;
import com.avito.android.di.PerFragment;
import com.avito.android.redux.Reducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.favorite_pins.FavoritePinsInteractor;
import com.avito.android.search.map.interactor.MapViewPortProvider;
import com.avito.android.search.map.interactor.ViewedPinsInteractor;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.PanelStateKt;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010C\u001a\u00020A\u0012\u0006\u0010@\u001a\u00020>\u0012\u0006\u0010=\u001a\u00020;\u0012\u0006\u0010:\u001a\u000208¢\u0006\u0004\bD\u0010EJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020&0+*\b\u0012\u0004\u0012\u00020&0+H\u0002¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\b\u0012\u0004\u0012\u00020&0+*\b\u0012\u0004\u0012\u00020&0+2\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010/J)\u00101\u001a\b\u0012\u0004\u0012\u00020&0+*\b\u0012\u0004\u0012\u00020&0+2\b\u00100\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b1\u0010/J\u0013\u00103\u001a\u00020\r*\u000202H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020\u0014H\u0002¢\u0006\u0004\b6\u00107R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010B¨\u0006F"}, d2 = {"Lcom/avito/android/search/map/reducer/MapReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "", "panelState", "", "f", "(Ljava/lang/String;)Z", "Lcom/google/android/gms/maps/model/LatLng;", "newCenterCoordinates", "Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "c", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLngBounds;)Lcom/google/android/gms/maps/model/LatLngBounds;", "pinCoordinates", "", "advertsCount", "mapBounds", "d", "(Lcom/google/android/gms/maps/model/LatLng;ILcom/google/android/gms/maps/model/LatLngBounds;)Lcom/google/android/gms/maps/model/LatLng;", "Lcom/avito/android/search/map/SearchMapState$MapState;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/search/map/SearchMapState$MapState;)Lcom/avito/android/search/map/SearchMapState$MapState;", "id", "markerIsFavorite", "markerFavoriteIds", "Lkotlin/Pair;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;ZLjava/lang/String;)Lkotlin/Pair;", "", "ids", "e", "(Ljava/util/List;)Ljava/lang/String;", "Lcom/avito/android/search/map/view/MarkerItem;", "markerItem", "favoritesIds", "h", "(Lcom/avito/android/search/map/view/MarkerItem;Ljava/lang/String;)Lcom/avito/android/search/map/view/MarkerItem;", "", "l", "(Ljava/util/List;)Ljava/util/List;", "j", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "selectedPinId", "i", "Lcom/avito/android/remote/model/Coordinates;", "k", "(Lcom/avito/android/remote/model/Coordinates;)Lcom/google/android/gms/maps/model/LatLng;", "count", g.a, "(I)Ljava/lang/String;", "Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "favoritePinsInteractor", "Lcom/avito/android/avito_map/AvitoMapZoomLevel;", "Lcom/avito/android/avito_map/AvitoMapZoomLevel;", "mapZoomLevel", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "mapViewPortProvider", "Lcom/avito/android/search/map/interactor/ViewedPinsInteractor;", "Lcom/avito/android/search/map/interactor/ViewedPinsInteractor;", "viewedPinsInteractor", "<init>", "(Lcom/avito/android/search/map/interactor/ViewedPinsInteractor;Lcom/avito/android/search/map/interactor/MapViewPortProvider;Lcom/avito/android/avito_map/AvitoMapZoomLevel;Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapReducer implements Reducer<SearchMapState, MapAction> {
    public final ViewedPinsInteractor a;
    public final MapViewPortProvider b;
    public final AvitoMapZoomLevel c;
    public final FavoritePinsInteractor d;

    @Inject
    public MapReducer(@NotNull ViewedPinsInteractor viewedPinsInteractor, @NotNull MapViewPortProvider mapViewPortProvider, @NotNull AvitoMapZoomLevel avitoMapZoomLevel, @NotNull FavoritePinsInteractor favoritePinsInteractor) {
        Intrinsics.checkNotNullParameter(viewedPinsInteractor, "viewedPinsInteractor");
        Intrinsics.checkNotNullParameter(mapViewPortProvider, "mapViewPortProvider");
        Intrinsics.checkNotNullParameter(avitoMapZoomLevel, "mapZoomLevel");
        Intrinsics.checkNotNullParameter(favoritePinsInteractor, "favoritePinsInteractor");
        this.a = viewedPinsInteractor;
        this.b = mapViewPortProvider;
        this.c = avitoMapZoomLevel;
        this.d = favoritePinsInteractor;
    }

    public final Pair<Boolean, String> a(String str, boolean z, String str2) {
        List split$default;
        List<String> arrayList = new ArrayList<>();
        if (z) {
            if (!(str2 == null || (split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
                arrayList.addAll(split$default);
            }
            if (this.d.isMarkForRemove(arrayList).size() == arrayList.size()) {
                arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt__CollectionsKt.emptyList());
            }
            return new Pair<>(Boolean.valueOf(z), e(arrayList));
        }
        for (Map.Entry<String, Boolean> entry : this.d.isFavoriteList(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)).entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                arrayList.add(key);
            }
        }
        if (!arrayList.isEmpty()) {
            z = true;
            return new Pair<>(Boolean.valueOf(z), e(arrayList));
        }
        z = false;
        return new Pair<>(Boolean.valueOf(z), e(arrayList));
    }

    public final SearchMapState.MapState b(SearchMapState.MapState mapState) {
        List<MarkerItem> markerItems = mapState.getMarkerItems();
        List<MarkerItem> list = null;
        if (markerItems != null) {
            list = i(markerItems, null);
        }
        return SearchMapState.MapState.copy$default(mapState, null, null, null, false, null, null, false, list, null, null, null, false, false, false, null, false, false, false, null, 523647, null);
    }

    public final LatLngBounds c(LatLng latLng, LatLngBounds latLngBounds) {
        if (latLng == null || latLngBounds == null) {
            return null;
        }
        double d2 = latLngBounds.getCenter().latitude - latLng.latitude;
        double d3 = latLngBounds.getCenter().longitude - latLng.longitude;
        LatLng latLng2 = latLngBounds.southwest;
        LatLng latLng3 = new LatLng(latLng2.latitude - d2, latLng2.longitude - d3);
        LatLng latLng4 = latLngBounds.northeast;
        return new LatLngBounds(latLng3, new LatLng(latLng4.latitude - d2, latLng4.longitude - d3));
    }

    public final LatLng d(LatLng latLng, int i, LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        double d2 = latLngBounds.northeast.latitude - latLngBounds.southwest.latitude;
        int intValue = this.b.getViewPort().getFirst().intValue();
        if (intValue == 0) {
            return null;
        }
        double offsetForVisibleArea = (d2 * ((double) this.b.getOffsetForVisibleArea(i))) / ((double) intValue);
        return new LatLng(latLng.latitude - ((latLngBounds.northeast.latitude - offsetForVisibleArea) - latLngBounds.getCenter().latitude), latLng.longitude);
    }

    public final String e(List<String> list) {
        return list.isEmpty() ^ true ? CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null) : "";
    }

    public final boolean f(String str) {
        return Intrinsics.areEqual(str, PanelStateKt.PANEL_HIDDEN) || Intrinsics.areEqual(str, "none");
    }

    public final String g(int i) {
        if (i > 9999) {
            return MapReducerKt.MAX_PIN_VALUE;
        }
        if (i > 1) {
            return String.valueOf(i);
        }
        return null;
    }

    public final MarkerItem h(MarkerItem markerItem, String str) {
        if (markerItem instanceof MarkerItem.Pin) {
            return MarkerItem.Pin.copy$default((MarkerItem.Pin) markerItem, null, null, false, null, 0, false, null, str.length() > 0, str, null, null, 1663, null);
        } else if (!(markerItem instanceof MarkerItem.Rash)) {
            return markerItem;
        } else {
            return MarkerItem.Rash.copy$default((MarkerItem.Rash) markerItem, null, false, null, null, 0, false, str.length() > 0, str, null, null, 831, null);
        }
    }

    public final List<MarkerItem> i(List<? extends MarkerItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof MarkerItem.Pin) {
                T t2 = t;
                t = (T) MarkerItem.Pin.copy$default(t2, null, null, Intrinsics.areEqual(t2.getId(), str), null, 0, false, null, false, null, null, null, 2043, null);
            } else if (t instanceof MarkerItem.Rash) {
                T t3 = t;
                t = (T) MarkerItem.Rash.copy$default(t3, null, Intrinsics.areEqual(t3.getId(), str), null, null, 0, false, false, null, null, null, 1021, null);
            }
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x000b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.avito.android.search.map.view.MarkerItem> j(java.util.List<? extends com.avito.android.search.map.view.MarkerItem> r20, java.lang.String r21) {
        /*
            r19 = this;
            r0 = r21
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r20.iterator()
        L_0x000b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.next()
            com.avito.android.search.map.view.MarkerItem r3 = (com.avito.android.search.map.view.MarkerItem) r3
            boolean r4 = r3 instanceof com.avito.android.search.map.view.MarkerItem.Pin
            if (r4 == 0) goto L_0x003f
            r5 = r3
            com.avito.android.search.map.view.MarkerItem$Pin r5 = (com.avito.android.search.map.view.MarkerItem.Pin) r5
            java.lang.String r3 = r5.getId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r3 == 0) goto L_0x003d
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 2015(0x7df, float:2.824E-42)
            r18 = 0
            com.avito.android.search.map.view.MarkerItem$Pin r3 = com.avito.android.search.map.view.MarkerItem.Pin.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0062
        L_0x003d:
            r3 = r5
            goto L_0x0062
        L_0x003f:
            boolean r4 = r3 instanceof com.avito.android.search.map.view.MarkerItem.Rash
            if (r4 == 0) goto L_0x0062
            r5 = r3
            com.avito.android.search.map.view.MarkerItem$Rash r5 = (com.avito.android.search.map.view.MarkerItem.Rash) r5
            java.lang.String r3 = r5.getId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r3 == 0) goto L_0x003d
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 991(0x3df, float:1.389E-42)
            r17 = 0
            com.avito.android.search.map.view.MarkerItem$Rash r3 = com.avito.android.search.map.view.MarkerItem.Rash.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x0062:
            if (r3 == 0) goto L_0x000b
            r1.add(r3)
            goto L_0x000b
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.reducer.MapReducer.j(java.util.List, java.lang.String):java.util.List");
    }

    public final LatLng k(Coordinates coordinates) {
        return new LatLng(coordinates.getLatitude(), coordinates.getLongitude());
    }

    public final List<MarkerItem> l(List<? extends MarkerItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof MarkerItem.Pin) {
                T t2 = t;
                t = (T) MarkerItem.Pin.copy$default(t2, null, null, false, null, 0, this.a.isViewed(t2.getListIds()), null, false, null, null, null, 2015, null);
            } else if (t instanceof MarkerItem.Rash) {
                T t3 = t;
                t = (T) MarkerItem.Rash.copy$default(t3, null, false, null, null, 0, this.a.isViewed(t3.getListIds()), false, null, null, null, 991, null);
            }
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:199:0x099f  */
    /* JADX WARNING: Removed duplicated region for block: B:222:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019c  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.search.map.SearchMapState reduce(@org.jetbrains.annotations.NotNull com.avito.android.search.map.SearchMapState r49, @org.jetbrains.annotations.NotNull com.avito.android.search.map.action.MapAction r50) {
        /*
        // Method dump skipped, instructions count: 2484
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.reducer.MapReducer.reduce(com.avito.android.search.map.SearchMapState, com.avito.android.search.map.action.MapAction):com.avito.android.search.map.SearchMapState");
    }
}

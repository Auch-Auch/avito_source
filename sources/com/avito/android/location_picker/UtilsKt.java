package com.avito.android.location_picker;

import android.content.res.Resources;
import android.view.View;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t*\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u0012\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\b0\b \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\b0\b\u0018\u00010\u000e0\u000e*\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "emptyErrors", "()Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "", "Lio/reactivex/rxjava3/core/Maybe;", "", "toMaybe", "(Z)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "", "", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/location_picker/entities/LocationPickerState;)Ljava/util/Map;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/BuildInfo;", "build", "kotlin.jvm.PlatformType", "logDiffIfDebug", "(Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/BuildInfo;)Lio/reactivex/rxjava3/core/Observable;", "Landroid/view/View;", "", "widthInPixels", "(Landroid/view/View;)I", "location-picker_release"}, k = 2, mv = {1, 4, 2})
public final class UtilsKt {

    public static final class a<T1, T2, R> implements BiFunction<LocationPickerState, LocationPickerState, LocationPickerState> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public LocationPickerState apply(LocationPickerState locationPickerState, LocationPickerState locationPickerState2) {
            LocationPickerState locationPickerState3 = locationPickerState;
            LocationPickerState locationPickerState4 = locationPickerState2;
            Intrinsics.checkNotNullParameter(locationPickerState3, InternalConstsKt.FIRST_IMAGE);
            Intrinsics.checkNotNullParameter(locationPickerState4, "second");
            UtilsKt.access$printDiff(locationPickerState3, locationPickerState4);
            return locationPickerState4;
        }
    }

    public static final Map<String, Object> a(LocationPickerState locationPickerState) {
        Map mapOf = r.mapOf(TuplesKt.to("isInitialCoordinates", Boolean.valueOf(locationPickerState.isInitialCoordinates())), TuplesKt.to("latLng", locationPickerState.getLatLng()), TuplesKt.to("zoom", Float.valueOf(locationPickerState.getZoom())), TuplesKt.to("addressString", locationPickerState.getAddressString()), TuplesKt.to("addressStringFitsCoords", Boolean.valueOf(locationPickerState.getAddressStringFitsCoords())), TuplesKt.to("addressStringToSearchFor", locationPickerState.getAddressStringToSearchFor()), TuplesKt.to("coordsVerified", Boolean.valueOf(locationPickerState.getCoordsVerified())), TuplesKt.to("searchHasFocus", Boolean.valueOf(locationPickerState.getSearchHasFocus())), TuplesKt.to("cameraMoving", Boolean.valueOf(locationPickerState.getCameraMoving())), TuplesKt.to("querySuggestionsLoadedBy", locationPickerState.getQuerySuggestionsLoadedBy()), TuplesKt.to("shouldBeVerified", Boolean.valueOf(locationPickerState.getShouldBeVerified())), TuplesKt.to("itemId", locationPickerState.getItemId()), TuplesKt.to("moveCameraToDeviceLocation", Boolean.valueOf(locationPickerState.getMoveCameraToDeviceLocation())), TuplesKt.to("suggestionList", locationPickerState.getSuggestionList()), TuplesKt.to("shouldMoveToDeviceLocation", Boolean.valueOf(locationPickerState.getShouldMoveToDeviceLocation())));
        LocationPickerErrors errors = locationPickerState.getErrors();
        return r.plus(mapOf, r.mapOf(TuplesKt.to("addressConfirmationError", errors.getAddressConfirmationError()), TuplesKt.to("hasGeneralNetworkError", Boolean.valueOf(errors.getHasGeneralNetworkError())), TuplesKt.to("hasNetworkErrorOnConfirmation", Boolean.valueOf(errors.getHasNetworkErrorOnConfirmation())), TuplesKt.to("unknownError", errors.getUnknownError()), TuplesKt.to("notGrantedPermissionError", Boolean.valueOf(errors.getNotGrantedPermissionError()))));
    }

    public static final void access$printDiff(LocationPickerState locationPickerState, LocationPickerState locationPickerState2) {
        if (!Intrinsics.areEqual(locationPickerState, locationPickerState2)) {
            Map<String, Object> a3 = a(locationPickerState);
            Map<String, Object> a4 = a(locationPickerState2);
            StringBuilder sb = new StringBuilder();
            for (String str : a3.keySet()) {
                Object obj = a3.get(str);
                Object obj2 = a4.get(str);
                if (!Intrinsics.areEqual(obj, obj2)) {
                    sb.append(str + ": " + obj + " -> " + obj2 + '\n');
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            Logs.debug$default("LocationPickerBinder", sb2, null, 4, null);
        }
    }

    @NotNull
    public static final LocationPickerErrors emptyErrors() {
        return new LocationPickerErrors(false, false, null, null, false, false, false, false, false, false, 1023, null);
    }

    public static final Observable<LocationPickerState> logDiffIfDebug(@NotNull Observable<LocationPickerState> observable, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(observable, "$this$logDiffIfDebug");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        return buildInfo.isDebug() ? observable.scan(a.a) : observable;
    }

    @NotNull
    public static final Maybe<Unit> toMaybe(boolean z) {
        if (z) {
            Maybe<Unit> just = Maybe.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "Maybe.just(Unit)");
            return just;
        }
        Maybe<Unit> empty = Maybe.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
        return empty;
    }

    public static final int widthInPixels(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$widthInPixels");
        int width = view.getWidth();
        if (view.getWidth() != 0) {
            return width;
        }
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        return resources.getDisplayMetrics().widthPixels;
    }
}

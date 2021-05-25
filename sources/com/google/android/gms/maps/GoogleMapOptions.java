package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getMapType", id = 4)
    private int mapType = -1;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getZOrderOnTopForParcel", id = 2, type = "byte")
    private Boolean zzaj;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getUseViewLifecycleInFragmentForParcel", id = 3, type = "byte")
    private Boolean zzak;
    @SafeParcelable.Field(getter = "getCamera", id = 5)
    private CameraPosition zzal;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getZoomControlsEnabledForParcel", id = 6, type = "byte")
    private Boolean zzam;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getCompassEnabledForParcel", id = 7, type = "byte")
    private Boolean zzan;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getScrollGesturesEnabledForParcel", id = 8, type = "byte")
    private Boolean zzao;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getZoomGesturesEnabledForParcel", id = 9, type = "byte")
    private Boolean zzap;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getTiltGesturesEnabledForParcel", id = 10, type = "byte")
    private Boolean zzaq;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getRotateGesturesEnabledForParcel", id = 11, type = "byte")
    private Boolean zzar;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getLiteModeForParcel", id = 12, type = "byte")
    private Boolean zzas;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getMapToolbarEnabledForParcel", id = 14, type = "byte")
    private Boolean zzat;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getAmbientEnabledForParcel", id = 15, type = "byte")
    private Boolean zzau;
    @SafeParcelable.Field(getter = "getMinZoomPreference", id = 16)
    private Float zzav = null;
    @SafeParcelable.Field(getter = "getMaxZoomPreference", id = 17)
    private Float zzaw = null;
    @SafeParcelable.Field(getter = "getLatLngBoundsForCameraTarget", id = 18)
    private LatLngBounds zzax = null;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", id = 19, type = "byte")
    private Boolean zzay;

    @SafeParcelable.Constructor
    public GoogleMapOptions(@SafeParcelable.Param(id = 2) byte b, @SafeParcelable.Param(id = 3) byte b2, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) CameraPosition cameraPosition, @SafeParcelable.Param(id = 6) byte b3, @SafeParcelable.Param(id = 7) byte b4, @SafeParcelable.Param(id = 8) byte b5, @SafeParcelable.Param(id = 9) byte b6, @SafeParcelable.Param(id = 10) byte b8, @SafeParcelable.Param(id = 11) byte b9, @SafeParcelable.Param(id = 12) byte b10, @SafeParcelable.Param(id = 14) byte b11, @SafeParcelable.Param(id = 15) byte b12, @SafeParcelable.Param(id = 16) Float f, @SafeParcelable.Param(id = 17) Float f2, @SafeParcelable.Param(id = 18) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 19) byte b13) {
        this.zzaj = zza.zza(b);
        this.zzak = zza.zza(b2);
        this.mapType = i;
        this.zzal = cameraPosition;
        this.zzam = zza.zza(b3);
        this.zzan = zza.zza(b4);
        this.zzao = zza.zza(b5);
        this.zzap = zza.zza(b6);
        this.zzaq = zza.zza(b8);
        this.zzar = zza.zza(b9);
        this.zzas = zza.zza(b10);
        this.zzat = zza.zza(b11);
        this.zzau = zza.zza(b12);
        this.zzav = f;
        this.zzaw = f2;
        this.zzax = latLngBounds;
        this.zzay = zza.zza(b13);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i = R.styleable.MapAttrs_mapType;
        if (obtainAttributes.hasValue(i)) {
            googleMapOptions.mapType(obtainAttributes.getInt(i, -1));
        }
        int i2 = R.styleable.MapAttrs_zOrderOnTop;
        if (obtainAttributes.hasValue(i2)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(i2, false));
        }
        int i3 = R.styleable.MapAttrs_useViewLifecycle;
        if (obtainAttributes.hasValue(i3)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(i3, false));
        }
        int i4 = R.styleable.MapAttrs_uiCompass;
        if (obtainAttributes.hasValue(i4)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(i4, true));
        }
        int i5 = R.styleable.MapAttrs_uiRotateGestures;
        if (obtainAttributes.hasValue(i5)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(i5, true));
        }
        int i6 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
        if (obtainAttributes.hasValue(i6)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(i6, true));
        }
        int i7 = R.styleable.MapAttrs_uiScrollGestures;
        if (obtainAttributes.hasValue(i7)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(i7, true));
        }
        int i8 = R.styleable.MapAttrs_uiTiltGestures;
        if (obtainAttributes.hasValue(i8)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(i8, true));
        }
        int i9 = R.styleable.MapAttrs_uiZoomGestures;
        if (obtainAttributes.hasValue(i9)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(i9, true));
        }
        int i10 = R.styleable.MapAttrs_uiZoomControls;
        if (obtainAttributes.hasValue(i10)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(i10, true));
        }
        int i11 = R.styleable.MapAttrs_liteMode;
        if (obtainAttributes.hasValue(i11)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(i11, false));
        }
        int i12 = R.styleable.MapAttrs_uiMapToolbar;
        if (obtainAttributes.hasValue(i12)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(i12, true));
        }
        int i13 = R.styleable.MapAttrs_ambientEnabled;
        if (obtainAttributes.hasValue(i13)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(i13, false));
        }
        int i14 = R.styleable.MapAttrs_cameraMinZoomPreference;
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(i14, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(zza(context, attributeSet));
        googleMapOptions.camera(zzb(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds zza(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        Float valueOf = obtainAttributes.hasValue(i) ? Float.valueOf(obtainAttributes.getFloat(i, 0.0f)) : null;
        int i2 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        Float valueOf2 = obtainAttributes.hasValue(i2) ? Float.valueOf(obtainAttributes.getFloat(i2, 0.0f)) : null;
        int i3 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        Float valueOf3 = obtainAttributes.hasValue(i3) ? Float.valueOf(obtainAttributes.getFloat(i3, 0.0f)) : null;
        int i4 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        Float valueOf4 = obtainAttributes.hasValue(i4) ? Float.valueOf(obtainAttributes.getFloat(i4, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition zzb(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i = R.styleable.MapAttrs_cameraTargetLat;
        float f = obtainAttributes.hasValue(i) ? obtainAttributes.getFloat(i, 0.0f) : 0.0f;
        int i2 = R.styleable.MapAttrs_cameraTargetLng;
        LatLng latLng = new LatLng((double) f, (double) (obtainAttributes.hasValue(i2) ? obtainAttributes.getFloat(i2, 0.0f) : 0.0f));
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        int i3 = R.styleable.MapAttrs_cameraZoom;
        if (obtainAttributes.hasValue(i3)) {
            builder.zoom(obtainAttributes.getFloat(i3, 0.0f));
        }
        int i4 = R.styleable.MapAttrs_cameraBearing;
        if (obtainAttributes.hasValue(i4)) {
            builder.bearing(obtainAttributes.getFloat(i4, 0.0f));
        }
        int i5 = R.styleable.MapAttrs_cameraTilt;
        if (obtainAttributes.hasValue(i5)) {
            builder.tilt(obtainAttributes.getFloat(i5, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    public final GoogleMapOptions ambientEnabled(boolean z) {
        this.zzau = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzal = cameraPosition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean z) {
        this.zzan = Boolean.valueOf(z);
        return this;
    }

    public final Boolean getAmbientEnabled() {
        return this.zzau;
    }

    public final CameraPosition getCamera() {
        return this.zzal;
    }

    public final Boolean getCompassEnabled() {
        return this.zzan;
    }

    public final LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzax;
    }

    public final Boolean getLiteMode() {
        return this.zzas;
    }

    public final Boolean getMapToolbarEnabled() {
        return this.zzat;
    }

    public final int getMapType() {
        return this.mapType;
    }

    public final Float getMaxZoomPreference() {
        return this.zzaw;
    }

    public final Float getMinZoomPreference() {
        return this.zzav;
    }

    public final Boolean getRotateGesturesEnabled() {
        return this.zzar;
    }

    public final Boolean getScrollGesturesEnabled() {
        return this.zzao;
    }

    public final Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.zzay;
    }

    public final Boolean getTiltGesturesEnabled() {
        return this.zzaq;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzak;
    }

    public final Boolean getZOrderOnTop() {
        return this.zzaj;
    }

    public final Boolean getZoomControlsEnabled() {
        return this.zzam;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzap;
    }

    public final GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.zzax = latLngBounds;
        return this;
    }

    public final GoogleMapOptions liteMode(boolean z) {
        this.zzas = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzat = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapType(int i) {
        this.mapType = i;
        return this;
    }

    public final GoogleMapOptions maxZoomPreference(float f) {
        this.zzaw = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions minZoomPreference(float f) {
        this.zzav = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzar = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzao = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        this.zzay = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaq = Boolean.valueOf(z);
        return this;
    }

    @Override // java.lang.Object
    public final String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.mapType)).add("LiteMode", this.zzas).add("Camera", this.zzal).add("CompassEnabled", this.zzan).add("ZoomControlsEnabled", this.zzam).add("ScrollGesturesEnabled", this.zzao).add("ZoomGesturesEnabled", this.zzap).add("TiltGesturesEnabled", this.zzaq).add("RotateGesturesEnabled", this.zzar).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzay).add("MapToolbarEnabled", this.zzat).add("AmbientEnabled", this.zzau).add("MinZoomPreference", this.zzav).add("MaxZoomPreference", this.zzaw).add("LatLngBoundsForCameraTarget", this.zzax).add("ZOrderOnTop", this.zzaj).add("UseViewLifecycleInFragment", this.zzak).toString();
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzak = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, zza.zza(this.zzaj));
        SafeParcelWriter.writeByte(parcel, 3, zza.zza(this.zzak));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i, false);
        SafeParcelWriter.writeByte(parcel, 6, zza.zza(this.zzam));
        SafeParcelWriter.writeByte(parcel, 7, zza.zza(this.zzan));
        SafeParcelWriter.writeByte(parcel, 8, zza.zza(this.zzao));
        SafeParcelWriter.writeByte(parcel, 9, zza.zza(this.zzap));
        SafeParcelWriter.writeByte(parcel, 10, zza.zza(this.zzaq));
        SafeParcelWriter.writeByte(parcel, 11, zza.zza(this.zzar));
        SafeParcelWriter.writeByte(parcel, 12, zza.zza(this.zzas));
        SafeParcelWriter.writeByte(parcel, 14, zza.zza(this.zzat));
        SafeParcelWriter.writeByte(parcel, 15, zza.zza(this.zzau));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i, false);
        SafeParcelWriter.writeByte(parcel, 19, zza.zza(this.zzay));
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaj = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzam = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzap = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions() {
    }
}

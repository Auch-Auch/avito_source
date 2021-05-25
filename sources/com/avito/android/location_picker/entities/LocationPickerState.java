package com.avito.android.location_picker.entities;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0013\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001Bí\u0001\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u000e\u0012\b\b\u0002\u00104\u001a\u00020\u0011\u0012\b\b\u0002\u00105\u001a\u00020\u0014\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020\u0011\u0012\b\b\u0002\u00108\u001a\u00020\u000b\u0012\b\b\u0002\u00109\u001a\u00020\u0011\u0012\b\b\u0002\u0010:\u001a\u00020\u0011\u0012\b\b\u0002\u0010;\u001a\u00020\u0011\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010>\u001a\u00020\"\u0012\b\b\u0002\u0010?\u001a\u00020\u0011\u0012\b\b\u0002\u0010@\u001a\u00020\u0011\u0012\b\b\u0002\u0010A\u001a\u00020\u0011\u0012\u0006\u0010B\u001a\u00020\u000b\u0012\b\b\u0002\u0010C\u001a\u00020\u0011\u0012\b\b\u0002\u0010D\u001a\u00020*\u0012\b\b\u0002\u0010E\u001a\u00020\u0011\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010G\u001a\u00020/¢\u0006\u0006\b\u0001\u0010\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u0019\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0013J\u0010\u0010\u001c\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\rJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eHÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b%\u0010\u0013J\u0010\u0010&\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b&\u0010\u0013J\u0010\u0010'\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b'\u0010\u0013J\u0010\u0010(\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b)\u0010\u0013J\u0010\u0010+\u001a\u00020*HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b-\u0010\u0013J\u0012\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b.\u0010\rJ\u0010\u00100\u001a\u00020/HÆ\u0003¢\u0006\u0004\b0\u00101Jö\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u00112\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u00112\b\b\u0002\u0010:\u001a\u00020\u00112\b\b\u0002\u0010;\u001a\u00020\u00112\b\b\u0002\u0010<\u001a\u00020\u000b2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010>\u001a\u00020\"2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010A\u001a\u00020\u00112\b\b\u0002\u0010B\u001a\u00020\u000b2\b\b\u0002\u0010C\u001a\u00020\u00112\b\b\u0002\u0010D\u001a\u00020*2\b\b\u0002\u0010E\u001a\u00020\u00112\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010G\u001a\u00020/HÆ\u0001¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bJ\u0010\rJ\u0010\u0010K\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bK\u0010\nJ\u001a\u0010N\u001a\u00020\u00112\b\u0010M\u001a\u0004\u0018\u00010LHÖ\u0003¢\u0006\u0004\bN\u0010OR\u0019\u0010<\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\rR\u0019\u0010@\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0013R\u0019\u00106\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010\rR\u0019\u0010;\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bY\u0010\u0013R\u0013\u0010[\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010\u0013R\u0019\u00109\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010T\u001a\u0004\b]\u0010\u0013R\u0013\u0010_\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b^\u0010\u0013R\u0013\u0010a\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b`\u0010\u0013R\u0019\u0010C\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010T\u001a\u0004\bc\u0010\u0013R\u0019\u0010:\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010T\u001a\u0004\be\u0010\u0013R\u0019\u00108\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010Q\u001a\u0004\bg\u0010\rR\u0013\u0010i\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bh\u0010\u0013R\u0019\u00104\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010T\u001a\u0004\bk\u0010\u0013R\u001b\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010Q\u001a\u0004\bm\u0010\rR\u0013\u0010q\u001a\u00020n8F@\u0006¢\u0006\u0006\u001a\u0004\bo\u0010pR\u001b\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\br\u0010Q\u001a\u0004\bs\u0010\rR\u0013\u0010u\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bt\u0010\u0013R\u0013\u0010w\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bv\u0010\u0013R\u0013\u0010y\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\bx\u0010\u0013R\u0019\u0010?\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bz\u0010T\u001a\u0004\b{\u0010\u0013R\u0019\u00105\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u0016R\u001a\u0010B\u001a\u00020\u000b8\u0006@\u0006¢\u0006\r\n\u0004\b\u0010Q\u001a\u0005\b\u0001\u0010\rR\u001c\u00103\u001a\u00020\u000e8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0010R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010!R\u001c\u0010D\u001a\u00020*8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010,R\u001b\u0010E\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010T\u001a\u0005\b\u0001\u0010\u0013R\u0017\u0010\u0001\u001a\u00030\u00018F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010G\u001a\u00020/8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u00101R\u001b\u00107\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010T\u001a\u0005\b\u0001\u0010\u0013R\u001b\u0010A\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010T\u001a\u0005\b\u0001\u0010\u0013R\u0015\u0010\u0001\u001a\u00020\u00118F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0013R\u001c\u0010>\u001a\u00020\"8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010$¨\u0006\u0001"}, d2 = {"Lcom/avito/android/location_picker/entities/LocationPickerState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "", "component3", "()Z", "", "component4", "()F", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "component12", "()Ljava/util/List;", "Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "component13", "()Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "component14", "component15", "component16", "component17", "component18", "Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "component19", "()Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "component20", "component21", "Lcom/avito/android/location_picker/entities/AddressValidationState;", "component22", "()Lcom/avito/android/location_picker/entities/AddressValidationState;", "itemId", "latLng", "doNotTryToGetAddress", "zoom", "addressString", "addressStringFitsCoords", "addressStringToSearchFor", "coordsVerified", "shouldBeVerified", "searchHasFocus", "querySuggestionsLoadedBy", "suggestionList", "errors", "cameraMoving", "shouldMoveToDeviceLocation", "moveCameraToDeviceLocation", "categoryId", "userInteractsWithUI", "radiusState", "sendLocationToJobAssistant", "jsonWebToken", "addressValidationState", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;ZFLjava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/util/List;Lcom/avito/android/location_picker/entities/LocationPickerErrors;ZZZLjava/lang/String;ZLcom/avito/android/location_picker/entities/SearchRadiusViewState;ZLjava/lang/String;Lcom/avito/android/location_picker/entities/AddressValidationState;)Lcom/avito/android/location_picker/entities/LocationPickerState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "k", "Ljava/lang/String;", "getQuerySuggestionsLoadedBy", "o", "Z", "getShouldMoveToDeviceLocation", "e", "getAddressString", "j", "getSearchHasFocus", "getShouldVerifyCoords", "shouldVerifyCoords", "h", "getCoordsVerified", "getShouldShowLoader", "shouldShowLoader", "getShouldRequestAddressByGPSCoords", "shouldRequestAddressByGPSCoords", "r", "getUserInteractsWithUI", "i", "getShouldBeVerified", g.a, "getAddressStringToSearchFor", "getShouldLoadSuggestions", "shouldLoadSuggestions", "c", "getDoNotTryToGetAddress", AuthSource.SEND_ABUSE, "getItemId", "Lcom/avito/android/location_picker/entities/LocationPickerNotification;", "getCurrentMessage", "()Lcom/avito/android/location_picker/entities/LocationPickerNotification;", "currentMessage", "u", "getJsonWebToken", "getShouldActivateChooseButton", "shouldActivateChooseButton", "getShouldConfirmAddress", "shouldConfirmAddress", "getShouldLoadRadiusList", "shouldLoadRadiusList", "n", "getCameraMoving", "d", "F", "getZoom", VKApiConst.Q, "getCategoryId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "l", "Ljava/util/List;", "getSuggestionList", "s", "Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "getRadiusState", "t", "getSendLocationToJobAssistant", "Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapTarget", "()Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTarget", VKApiConst.VERSION, "Lcom/avito/android/location_picker/entities/AddressValidationState;", "getAddressValidationState", "f", "getAddressStringFitsCoords", "p", "getMoveCameraToDeviceLocation", "isInitialCoordinates", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/location_picker/entities/LocationPickerErrors;", "getErrors", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;ZFLjava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/util/List;Lcom/avito/android/location_picker/entities/LocationPickerErrors;ZZZLjava/lang/String;ZLcom/avito/android/location_picker/entities/SearchRadiusViewState;ZLjava/lang/String;Lcom/avito/android/location_picker/entities/AddressValidationState;)V", "(Landroid/os/Parcel;)V", "CREATOR", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerState implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    public final String a;
    @NotNull
    public final AvitoMapPoint b;
    public final boolean c;
    public final float d;
    @NotNull
    public final String e;
    public final boolean f;
    @NotNull
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    @NotNull
    public final String k;
    @NotNull
    public final List<AddressSuggestion> l;
    @NotNull
    public final LocationPickerErrors m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    @NotNull
    public final String q;
    public final boolean r;
    @NotNull
    public final SearchRadiusViewState s;
    public final boolean t;
    @Nullable
    public final String u;
    @NotNull
    public final AddressValidationState v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location_picker/entities/LocationPickerState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/location_picker/entities/LocationPickerState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/location_picker/entities/LocationPickerState;", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<LocationPickerState> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public LocationPickerState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationPickerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public LocationPickerState[] newArray(int i) {
            return new LocationPickerState[i];
        }
    }

    public LocationPickerState(@Nullable String str, @NotNull AvitoMapPoint avitoMapPoint, boolean z, float f2, @NotNull String str2, boolean z2, @NotNull String str3, boolean z3, boolean z4, boolean z5, @NotNull String str4, @NotNull List<AddressSuggestion> list, @NotNull LocationPickerErrors locationPickerErrors, boolean z7, boolean z8, boolean z9, @NotNull String str5, boolean z10, @NotNull SearchRadiusViewState searchRadiusViewState, boolean z11, @Nullable String str6, @NotNull AddressValidationState addressValidationState) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        Intrinsics.checkNotNullParameter(str2, "addressString");
        Intrinsics.checkNotNullParameter(str3, "addressStringToSearchFor");
        Intrinsics.checkNotNullParameter(str4, "querySuggestionsLoadedBy");
        Intrinsics.checkNotNullParameter(list, "suggestionList");
        Intrinsics.checkNotNullParameter(locationPickerErrors, "errors");
        Intrinsics.checkNotNullParameter(str5, "categoryId");
        Intrinsics.checkNotNullParameter(searchRadiusViewState, "radiusState");
        Intrinsics.checkNotNullParameter(addressValidationState, "addressValidationState");
        this.a = str;
        this.b = avitoMapPoint;
        this.c = z;
        this.d = f2;
        this.e = str2;
        this.f = z2;
        this.g = str3;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = str4;
        this.l = list;
        this.m = locationPickerErrors;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.q = str5;
        this.r = z10;
        this.s = searchRadiusViewState;
        this.t = z11;
        this.u = str6;
        this.v = addressValidationState;
    }

    public static /* synthetic */ LocationPickerState copy$default(LocationPickerState locationPickerState, String str, AvitoMapPoint avitoMapPoint, boolean z, float f2, String str2, boolean z2, String str3, boolean z3, boolean z4, boolean z5, String str4, List list, LocationPickerErrors locationPickerErrors, boolean z7, boolean z8, boolean z9, String str5, boolean z10, SearchRadiusViewState searchRadiusViewState, boolean z11, String str6, AddressValidationState addressValidationState, int i2, Object obj) {
        return locationPickerState.copy((i2 & 1) != 0 ? locationPickerState.a : str, (i2 & 2) != 0 ? locationPickerState.b : avitoMapPoint, (i2 & 4) != 0 ? locationPickerState.c : z, (i2 & 8) != 0 ? locationPickerState.d : f2, (i2 & 16) != 0 ? locationPickerState.e : str2, (i2 & 32) != 0 ? locationPickerState.f : z2, (i2 & 64) != 0 ? locationPickerState.g : str3, (i2 & 128) != 0 ? locationPickerState.h : z3, (i2 & 256) != 0 ? locationPickerState.i : z4, (i2 & 512) != 0 ? locationPickerState.j : z5, (i2 & 1024) != 0 ? locationPickerState.k : str4, (i2 & 2048) != 0 ? locationPickerState.l : list, (i2 & 4096) != 0 ? locationPickerState.m : locationPickerErrors, (i2 & 8192) != 0 ? locationPickerState.n : z7, (i2 & 16384) != 0 ? locationPickerState.o : z8, (i2 & 32768) != 0 ? locationPickerState.p : z9, (i2 & 65536) != 0 ? locationPickerState.q : str5, (i2 & 131072) != 0 ? locationPickerState.r : z10, (i2 & 262144) != 0 ? locationPickerState.s : searchRadiusViewState, (i2 & 524288) != 0 ? locationPickerState.t : z11, (i2 & 1048576) != 0 ? locationPickerState.u : str6, (i2 & 2097152) != 0 ? locationPickerState.v : addressValidationState);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    @NotNull
    public final String component11() {
        return this.k;
    }

    @NotNull
    public final List<AddressSuggestion> component12() {
        return this.l;
    }

    @NotNull
    public final LocationPickerErrors component13() {
        return this.m;
    }

    public final boolean component14() {
        return this.n;
    }

    public final boolean component15() {
        return this.o;
    }

    public final boolean component16() {
        return this.p;
    }

    @NotNull
    public final String component17() {
        return this.q;
    }

    public final boolean component18() {
        return this.r;
    }

    @NotNull
    public final SearchRadiusViewState component19() {
        return this.s;
    }

    @NotNull
    public final AvitoMapPoint component2() {
        return this.b;
    }

    public final boolean component20() {
        return this.t;
    }

    @Nullable
    public final String component21() {
        return this.u;
    }

    @NotNull
    public final AddressValidationState component22() {
        return this.v;
    }

    public final boolean component3() {
        return this.c;
    }

    public final float component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final LocationPickerState copy(@Nullable String str, @NotNull AvitoMapPoint avitoMapPoint, boolean z, float f2, @NotNull String str2, boolean z2, @NotNull String str3, boolean z3, boolean z4, boolean z5, @NotNull String str4, @NotNull List<AddressSuggestion> list, @NotNull LocationPickerErrors locationPickerErrors, boolean z7, boolean z8, boolean z9, @NotNull String str5, boolean z10, @NotNull SearchRadiusViewState searchRadiusViewState, boolean z11, @Nullable String str6, @NotNull AddressValidationState addressValidationState) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        Intrinsics.checkNotNullParameter(str2, "addressString");
        Intrinsics.checkNotNullParameter(str3, "addressStringToSearchFor");
        Intrinsics.checkNotNullParameter(str4, "querySuggestionsLoadedBy");
        Intrinsics.checkNotNullParameter(list, "suggestionList");
        Intrinsics.checkNotNullParameter(locationPickerErrors, "errors");
        Intrinsics.checkNotNullParameter(str5, "categoryId");
        Intrinsics.checkNotNullParameter(searchRadiusViewState, "radiusState");
        Intrinsics.checkNotNullParameter(addressValidationState, "addressValidationState");
        return new LocationPickerState(str, avitoMapPoint, z, f2, str2, z2, str3, z3, z4, z5, str4, list, locationPickerErrors, z7, z8, z9, str5, z10, searchRadiusViewState, z11, str6, addressValidationState);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationPickerState)) {
            return false;
        }
        LocationPickerState locationPickerState = (LocationPickerState) obj;
        return Intrinsics.areEqual(this.a, locationPickerState.a) && Intrinsics.areEqual(this.b, locationPickerState.b) && this.c == locationPickerState.c && Float.compare(this.d, locationPickerState.d) == 0 && Intrinsics.areEqual(this.e, locationPickerState.e) && this.f == locationPickerState.f && Intrinsics.areEqual(this.g, locationPickerState.g) && this.h == locationPickerState.h && this.i == locationPickerState.i && this.j == locationPickerState.j && Intrinsics.areEqual(this.k, locationPickerState.k) && Intrinsics.areEqual(this.l, locationPickerState.l) && Intrinsics.areEqual(this.m, locationPickerState.m) && this.n == locationPickerState.n && this.o == locationPickerState.o && this.p == locationPickerState.p && Intrinsics.areEqual(this.q, locationPickerState.q) && this.r == locationPickerState.r && Intrinsics.areEqual(this.s, locationPickerState.s) && this.t == locationPickerState.t && Intrinsics.areEqual(this.u, locationPickerState.u) && Intrinsics.areEqual(this.v, locationPickerState.v);
    }

    @NotNull
    public final String getAddressString() {
        return this.e;
    }

    public final boolean getAddressStringFitsCoords() {
        return this.f;
    }

    @NotNull
    public final String getAddressStringToSearchFor() {
        return this.g;
    }

    @NotNull
    public final AddressValidationState getAddressValidationState() {
        return this.v;
    }

    public final boolean getCameraMoving() {
        return this.n;
    }

    @NotNull
    public final String getCategoryId() {
        return this.q;
    }

    public final boolean getCoordsVerified() {
        return this.h;
    }

    @NotNull
    public final LocationPickerNotification getCurrentMessage() {
        if (this.m.getHasNetworkErrorOnConfirmation()) {
            return new NetworkErrorOnConfirmation();
        }
        if (this.m.getNotGrantedPermissionError()) {
            return new NotGrantedPermissions();
        }
        if (this.m.getNotSuggestedAddressError()) {
            return new NotSuggestedAddressError();
        }
        if (this.m.getNoSuggestsError()) {
            return new NoSuggestsError();
        }
        if (this.m.getEmptyAddressError()) {
            return new EmptyAddressError();
        }
        if (this.m.getHasGeneralNetworkError()) {
            return new NetworkError();
        }
        if (this.m.getAddressConfirmationError() != null && !this.j) {
            return new Message(this.m.getAddressConfirmationError());
        }
        if (this.m.getUnknownError() != null) {
            return new Message(this.m.getUnknownError());
        }
        if (this.m.getAdvertsCountError()) {
            return new AdvertsCountError();
        }
        if (this.m.getAdvertsCountNetworkError()) {
            return new AdvertsCountNetworkError();
        }
        return new None();
    }

    public final boolean getDoNotTryToGetAddress() {
        return this.c;
    }

    @NotNull
    public final LocationPickerErrors getErrors() {
        return this.m;
    }

    @Nullable
    public final String getItemId() {
        return this.a;
    }

    @Nullable
    public final String getJsonWebToken() {
        return this.u;
    }

    @NotNull
    public final AvitoMapPoint getLatLng() {
        return this.b;
    }

    @NotNull
    public final AvitoMapTarget getMapTarget() {
        return new AvitoMapTarget(this.b, this.d);
    }

    public final boolean getMoveCameraToDeviceLocation() {
        return this.p;
    }

    @NotNull
    public final String getQuerySuggestionsLoadedBy() {
        return this.k;
    }

    @NotNull
    public final SearchRadiusViewState getRadiusState() {
        return this.s;
    }

    public final boolean getSearchHasFocus() {
        return this.j;
    }

    public final boolean getSendLocationToJobAssistant() {
        return this.t;
    }

    public final boolean getShouldActivateChooseButton() {
        return !this.n && this.m.getNoErrors() && this.v.chooseButtonIsActive();
    }

    public final boolean getShouldBeVerified() {
        return this.i;
    }

    public final boolean getShouldConfirmAddress() {
        return this.m.getNoErrors() && m.isBlank(this.g) && !this.j && !this.f && !this.n && !isInitialCoordinates() && !this.c;
    }

    public final boolean getShouldLoadRadiusList() {
        return this.s.getShouldLoadRadiusList() && this.s.getLoadFailed();
    }

    public final boolean getShouldLoadSuggestions() {
        if (!this.j || this.f || !(!m.isBlank(this.e)) || (!this.l.isEmpty() && !(!Intrinsics.areEqual(this.k, this.e)))) {
            return false;
        }
        return true;
    }

    public final boolean getShouldMoveToDeviceLocation() {
        return this.o;
    }

    public final boolean getShouldRequestAddressByGPSCoords() {
        return (Intrinsics.areEqual(this.q, LocationPickerStateKt.CATEGORY_REAL_ESTATE) ^ true) || this.r;
    }

    public final boolean getShouldShowLoader() {
        return getShouldConfirmAddress() || getShouldVerifyCoords();
    }

    public final boolean getShouldVerifyCoords() {
        return this.i && !this.h && this.m.getNoErrors();
    }

    @NotNull
    public final List<AddressSuggestion> getSuggestionList() {
        return this.l;
    }

    public final boolean getUserInteractsWithUI() {
        return this.r;
    }

    public final float getZoom() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AvitoMapPoint avitoMapPoint = this.b;
        int hashCode2 = (hashCode + (avitoMapPoint != null ? avitoMapPoint.hashCode() : 0)) * 31;
        boolean z = this.c;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i1 = a.i1(this.d, (hashCode2 + i4) * 31, 31);
        String str2 = this.e;
        int hashCode3 = (i1 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.f;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode3 + i7) * 31;
        String str3 = this.g;
        int hashCode4 = (i10 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z3 = this.h;
        if (z3) {
            z3 = true;
        }
        int i11 = z3 ? 1 : 0;
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = (hashCode4 + i11) * 31;
        boolean z4 = this.i;
        if (z4) {
            z4 = true;
        }
        int i15 = z4 ? 1 : 0;
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = (i14 + i15) * 31;
        boolean z5 = this.j;
        if (z5) {
            z5 = true;
        }
        int i19 = z5 ? 1 : 0;
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = (i18 + i19) * 31;
        String str4 = this.k;
        int hashCode5 = (i22 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<AddressSuggestion> list = this.l;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        LocationPickerErrors locationPickerErrors = this.m;
        int hashCode7 = (hashCode6 + (locationPickerErrors != null ? locationPickerErrors.hashCode() : 0)) * 31;
        boolean z7 = this.n;
        if (z7) {
            z7 = true;
        }
        int i23 = z7 ? 1 : 0;
        int i24 = z7 ? 1 : 0;
        int i25 = z7 ? 1 : 0;
        int i26 = (hashCode7 + i23) * 31;
        boolean z8 = this.o;
        if (z8) {
            z8 = true;
        }
        int i27 = z8 ? 1 : 0;
        int i28 = z8 ? 1 : 0;
        int i29 = z8 ? 1 : 0;
        int i30 = (i26 + i27) * 31;
        boolean z9 = this.p;
        if (z9) {
            z9 = true;
        }
        int i31 = z9 ? 1 : 0;
        int i32 = z9 ? 1 : 0;
        int i33 = z9 ? 1 : 0;
        int i34 = (i30 + i31) * 31;
        String str5 = this.q;
        int hashCode8 = (i34 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z10 = this.r;
        if (z10) {
            z10 = true;
        }
        int i35 = z10 ? 1 : 0;
        int i36 = z10 ? 1 : 0;
        int i37 = z10 ? 1 : 0;
        int i38 = (hashCode8 + i35) * 31;
        SearchRadiusViewState searchRadiusViewState = this.s;
        int hashCode9 = (i38 + (searchRadiusViewState != null ? searchRadiusViewState.hashCode() : 0)) * 31;
        boolean z11 = this.t;
        if (!z11) {
            i3 = z11 ? 1 : 0;
        }
        int i39 = (hashCode9 + i3) * 31;
        String str6 = this.u;
        int hashCode10 = (i39 + (str6 != null ? str6.hashCode() : 0)) * 31;
        AddressValidationState addressValidationState = this.v;
        if (addressValidationState != null) {
            i2 = addressValidationState.hashCode();
        }
        return hashCode10 + i2;
    }

    public final boolean isInitialCoordinates() {
        return this.b.getLatitude() == 0.0d && this.b.getLongitude() == 0.0d && !this.n && !this.j && this.m.getNoErrors();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LocationPickerState(itemId=");
        L.append(this.a);
        L.append(", latLng=");
        L.append(this.b);
        L.append(", doNotTryToGetAddress=");
        L.append(this.c);
        L.append(", zoom=");
        L.append(this.d);
        L.append(", addressString=");
        L.append(this.e);
        L.append(", addressStringFitsCoords=");
        L.append(this.f);
        L.append(", addressStringToSearchFor=");
        L.append(this.g);
        L.append(", coordsVerified=");
        L.append(this.h);
        L.append(", shouldBeVerified=");
        L.append(this.i);
        L.append(", searchHasFocus=");
        L.append(this.j);
        L.append(", querySuggestionsLoadedBy=");
        L.append(this.k);
        L.append(", suggestionList=");
        L.append(this.l);
        L.append(", errors=");
        L.append(this.m);
        L.append(", cameraMoving=");
        L.append(this.n);
        L.append(", shouldMoveToDeviceLocation=");
        L.append(this.o);
        L.append(", moveCameraToDeviceLocation=");
        L.append(this.p);
        L.append(", categoryId=");
        L.append(this.q);
        L.append(", userInteractsWithUI=");
        L.append(this.r);
        L.append(", radiusState=");
        L.append(this.s);
        L.append(", sendLocationToJobAssistant=");
        L.append(this.t);
        L.append(", jsonWebToken=");
        L.append(this.u);
        L.append(", addressValidationState=");
        L.append(this.v);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i2);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeString(this.g);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeByte(this.j ? (byte) 1 : 0);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.l);
        parcel.writeParcelable(this.m, i2);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeByte(this.o ? (byte) 1 : 0);
        parcel.writeByte(this.p ? (byte) 1 : 0);
        parcel.writeString(this.q);
        parcel.writeByte(this.r ? (byte) 1 : 0);
        parcel.writeParcelable(this.s, i2);
        parcel.writeByte(this.t ? (byte) 1 : 0);
        parcel.writeString(this.u);
        parcel.writeParcelable(this.v, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationPickerState(String str, AvitoMapPoint avitoMapPoint, boolean z, float f2, String str2, boolean z2, String str3, boolean z3, boolean z4, boolean z5, String str4, List list, LocationPickerErrors locationPickerErrors, boolean z7, boolean z8, boolean z9, String str5, boolean z10, SearchRadiusViewState searchRadiusViewState, boolean z11, String str6, AddressValidationState addressValidationState, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? new AvitoMapPoint(0.0d, 0.0d) : avitoMapPoint, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0.0f : f2, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? "" : str3, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? false : z5, (i2 & 1024) != 0 ? "" : str4, (i2 & 2048) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 4096) != 0 ? new LocationPickerErrors(false, false, null, null, false, false, false, false, false, false, 1023, null) : locationPickerErrors, (i2 & 8192) != 0 ? false : z7, (i2 & 16384) != 0 ? false : z8, (32768 & i2) != 0 ? false : z9, str5, (131072 & i2) != 0 ? false : z10, (262144 & i2) != 0 ? new SearchRadiusViewState(null, null, false, false, null, 0, null, false, false, 0, null, false, null, 8191, null) : searchRadiusViewState, (524288 & i2) != 0 ? false : z11, (1048576 & i2) != 0 ? null : str6, (i2 & 2097152) != 0 ? new AddressValidationState(null, false, false, null, 15, null) : addressValidationState);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationPickerState(@org.jetbrains.annotations.NotNull android.os.Parcel r26) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_picker.entities.LocationPickerState.<init>(android.os.Parcel):void");
    }
}

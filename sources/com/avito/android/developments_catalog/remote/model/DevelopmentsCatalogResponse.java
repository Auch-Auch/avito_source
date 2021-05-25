package com.avito.android.developments_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AlertBannerInfo;
import com.avito.android.remote.model.BuildingProgress;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Image;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001Bû\u0001\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010&\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010.¢\u0006\u0004\bu\u0010vJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b*\u0010\nJ\u0012\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010/\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0004\b/\u00100J\u0002\u0010D\u001a\u00020\u00002\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00072\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010.HÆ\u0001¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bF\u0010\u0004J\u0010\u0010H\u001a\u00020GHÖ\u0001¢\u0006\u0004\bH\u0010IJ\u001a\u0010M\u001a\u00020L2\b\u0010K\u001a\u0004\u0018\u00010JHÖ\u0003¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020GHÖ\u0001¢\u0006\u0004\bO\u0010IJ \u0010T\u001a\u00020S2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020GHÖ\u0001¢\u0006\u0004\bT\u0010UR\u001e\u00107\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u0010V\u001a\u0004\bW\u0010\u0013R\u001e\u0010=\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u0010X\u001a\u0004\bY\u0010#R$\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b:\u0010Z\u001a\u0004\b[\u0010\nR$\u0010A\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010Z\u001a\u0004\b\\\u0010\nR\u001e\u0010@\u001a\u0004\u0018\u00010&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b@\u0010]\u001a\u0004\b^\u0010(R\u001e\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010_\u001a\u0004\b`\u0010\u0010R\u001c\u00101\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010a\u001a\u0004\bb\u0010\u0004R\u001e\u0010;\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b;\u0010c\u001a\u0004\bd\u0010\u001dR$\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u0010Z\u001a\u0004\be\u0010\nR\u001e\u00109\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010f\u001a\u0004\bg\u0010\u0018R\u001c\u00102\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010a\u001a\u0004\bh\u0010\u0004R\u001e\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010a\u001a\u0004\bi\u0010\u0004R\u001e\u0010<\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010j\u001a\u0004\bk\u0010 R\u001e\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b?\u0010a\u001a\u0004\bl\u0010\u0004R$\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010Z\u001a\u0004\bm\u0010\nR\u001e\u0010B\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bB\u0010n\u001a\u0004\bo\u0010-R\u001e\u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u0010p\u001a\u0004\bq\u0010\rR\u001e\u0010C\u001a\u0004\u0018\u00010.8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bC\u0010r\u001a\u0004\bs\u00100R\u001e\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010a\u001a\u0004\bt\u0010\u0004¨\u0006w"}, d2 = {"Lcom/avito/android/developments_catalog/remote/model/DevelopmentsCatalogResponse;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/avito/android/developments_catalog/remote/model/MetroParam;", "component4", "()Ljava/util/List;", "Lcom/avito/android/remote/model/AlertBannerInfo;", "component5", "()Lcom/avito/android/remote/model/AlertBannerInfo;", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;", "component6", "()Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;", "Lcom/avito/android/remote/model/AdvertAction$Phone;", "component7", "()Lcom/avito/android/remote/model/AdvertAction$Phone;", "Lcom/avito/android/developments_catalog/remote/model/KeyValue;", "component8", "Lcom/avito/android/developments_catalog/remote/model/DeveloperCompany;", "component9", "()Lcom/avito/android/developments_catalog/remote/model/DeveloperCompany;", "Lcom/avito/android/remote/model/Image;", "component10", "Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;", "component11", "()Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;", "Lcom/avito/android/developments_catalog/remote/model/AboutDevelopment;", "component12", "()Lcom/avito/android/developments_catalog/remote/model/AboutDevelopment;", "Lcom/avito/android/remote/model/Coordinates;", "component13", "()Lcom/avito/android/remote/model/Coordinates;", "component14", "component15", "Lcom/avito/android/developments_catalog/remote/model/LegalDisclaimer;", "component16", "()Lcom/avito/android/developments_catalog/remote/model/LegalDisclaimer;", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "component17", "Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "component18", "()Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "Lcom/avito/android/remote/model/BuildingProgress;", "component19", "()Lcom/avito/android/remote/model/BuildingProgress;", "id", "title", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "metro", "alert", "developmentAdvice", "phone", "infoParams", "developerCompany", "images", "avitoOffers", "aboutDevelopment", ParameterId.COORDS, "share", "locationId", "legalDisclaimer", "amenityButtons", "mapPreview", "buildingProgress", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/AlertBannerInfo;Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;Lcom/avito/android/remote/model/AdvertAction$Phone;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/DeveloperCompany;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;Lcom/avito/android/developments_catalog/remote/model/AboutDevelopment;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/remote/model/LegalDisclaimer;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/MapPreview;Lcom/avito/android/remote/model/BuildingProgress;)Lcom/avito/android/developments_catalog/remote/model/DevelopmentsCatalogResponse;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AdvertAction$Phone;", "getPhone", "Lcom/avito/android/remote/model/Coordinates;", "getCoords", "Ljava/util/List;", "getImages", "getAmenityButtons", "Lcom/avito/android/developments_catalog/remote/model/LegalDisclaimer;", "getLegalDisclaimer", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;", "getDevelopmentAdvice", "Ljava/lang/String;", "getId", "Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;", "getAvitoOffers", "getInfoParams", "Lcom/avito/android/developments_catalog/remote/model/DeveloperCompany;", "getDeveloperCompany", "getTitle", "getAddress", "Lcom/avito/android/developments_catalog/remote/model/AboutDevelopment;", "getAboutDevelopment", "getLocationId", "getMetro", "Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "getMapPreview", "Lcom/avito/android/remote/model/AlertBannerInfo;", "getAlert", "Lcom/avito/android/remote/model/BuildingProgress;", "getBuildingProgress", "getShare", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/AlertBannerInfo;Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;Lcom/avito/android/remote/model/AdvertAction$Phone;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/DeveloperCompany;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/AvitoOffers;Lcom/avito/android/developments_catalog/remote/model/AboutDevelopment;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/remote/model/LegalDisclaimer;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/MapPreview;Lcom/avito/android/remote/model/BuildingProgress;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogResponse implements Parcelable {
    public static final Parcelable.Creator<DevelopmentsCatalogResponse> CREATOR = new Creator();
    @SerializedName("aboutDevelopment")
    @Nullable
    private final AboutDevelopment aboutDevelopment;
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final String address;
    @SerializedName("alert")
    @Nullable
    private final AlertBannerInfo alert;
    @SerializedName("layersButtons")
    @Nullable
    private final List<AmenityButton> amenityButtons;
    @SerializedName("avitoOffers")
    @Nullable
    private final AvitoOffers avitoOffers;
    @SerializedName("buildingProgress")
    @Nullable
    private final BuildingProgress buildingProgress;
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coords;
    @SerializedName("developer")
    @Nullable
    private final DeveloperCompany developerCompany;
    @SerializedName("developmentsAdvice")
    @Nullable
    private final DevelopmentsAdvice developmentAdvice;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final List<Image> images;
    @SerializedName("infoParams")
    @Nullable
    private final List<KeyValue> infoParams;
    @SerializedName("legalDisclaimer")
    @Nullable
    private final LegalDisclaimer legalDisclaimer;
    @SerializedName("locationId")
    @Nullable
    private final String locationId;
    @SerializedName("mapPreview")
    @Nullable
    private final MapPreview mapPreview;
    @SerializedName("metro")
    @Nullable
    private final List<MetroParam> metro;
    @SerializedName("phone")
    @Nullable
    private final AdvertAction.Phone phone;
    @SerializedName("share")
    @Nullable
    private final String share;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DevelopmentsCatalogResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            AboutDevelopment aboutDevelopment;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(MetroParam.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            AlertBannerInfo alertBannerInfo = (AlertBannerInfo) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader());
            DevelopmentsAdvice createFromParcel = parcel.readInt() != 0 ? DevelopmentsAdvice.CREATOR.createFromParcel(parcel) : null;
            AdvertAction.Phone phone = (AdvertAction.Phone) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add(KeyValue.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            DeveloperCompany createFromParcel2 = parcel.readInt() != 0 ? DeveloperCompany.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                arrayList3 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList3.add((Image) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader()));
                    readInt3--;
                }
            } else {
                arrayList3 = null;
            }
            AvitoOffers createFromParcel3 = parcel.readInt() != 0 ? AvitoOffers.CREATOR.createFromParcel(parcel) : null;
            AboutDevelopment createFromParcel4 = parcel.readInt() != 0 ? AboutDevelopment.CREATOR.createFromParcel(parcel) : null;
            Coordinates coordinates = (Coordinates) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader());
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            LegalDisclaimer createFromParcel5 = parcel.readInt() != 0 ? LegalDisclaimer.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(readInt4);
                while (readInt4 != 0) {
                    arrayList5.add((AmenityButton) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader()));
                    readInt4--;
                    createFromParcel4 = createFromParcel4;
                }
                aboutDevelopment = createFromParcel4;
                arrayList4 = arrayList5;
            } else {
                aboutDevelopment = createFromParcel4;
                arrayList4 = null;
            }
            return new DevelopmentsCatalogResponse(readString, readString2, readString3, arrayList, alertBannerInfo, createFromParcel, phone, arrayList2, createFromParcel2, arrayList3, createFromParcel3, aboutDevelopment, coordinates, readString4, readString5, createFromParcel5, arrayList4, parcel.readInt() != 0 ? MapPreview.CREATOR.createFromParcel(parcel) : null, (BuildingProgress) parcel.readParcelable(DevelopmentsCatalogResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsCatalogResponse[] newArray(int i) {
            return new DevelopmentsCatalogResponse[i];
        }
    }

    public DevelopmentsCatalogResponse(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<MetroParam> list, @Nullable AlertBannerInfo alertBannerInfo, @Nullable DevelopmentsAdvice developmentsAdvice, @Nullable AdvertAction.Phone phone2, @Nullable List<KeyValue> list2, @Nullable DeveloperCompany developerCompany2, @Nullable List<Image> list3, @Nullable AvitoOffers avitoOffers2, @Nullable AboutDevelopment aboutDevelopment2, @Nullable Coordinates coordinates, @Nullable String str4, @Nullable String str5, @Nullable LegalDisclaimer legalDisclaimer2, @Nullable List<AmenityButton> list4, @Nullable MapPreview mapPreview2, @Nullable BuildingProgress buildingProgress2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.address = str3;
        this.metro = list;
        this.alert = alertBannerInfo;
        this.developmentAdvice = developmentsAdvice;
        this.phone = phone2;
        this.infoParams = list2;
        this.developerCompany = developerCompany2;
        this.images = list3;
        this.avitoOffers = avitoOffers2;
        this.aboutDevelopment = aboutDevelopment2;
        this.coords = coordinates;
        this.share = str4;
        this.locationId = str5;
        this.legalDisclaimer = legalDisclaimer2;
        this.amenityButtons = list4;
        this.mapPreview = mapPreview2;
        this.buildingProgress = buildingProgress2;
    }

    public static /* synthetic */ DevelopmentsCatalogResponse copy$default(DevelopmentsCatalogResponse developmentsCatalogResponse, String str, String str2, String str3, List list, AlertBannerInfo alertBannerInfo, DevelopmentsAdvice developmentsAdvice, AdvertAction.Phone phone2, List list2, DeveloperCompany developerCompany2, List list3, AvitoOffers avitoOffers2, AboutDevelopment aboutDevelopment2, Coordinates coordinates, String str4, String str5, LegalDisclaimer legalDisclaimer2, List list4, MapPreview mapPreview2, BuildingProgress buildingProgress2, int i, Object obj) {
        return developmentsCatalogResponse.copy((i & 1) != 0 ? developmentsCatalogResponse.id : str, (i & 2) != 0 ? developmentsCatalogResponse.title : str2, (i & 4) != 0 ? developmentsCatalogResponse.address : str3, (i & 8) != 0 ? developmentsCatalogResponse.metro : list, (i & 16) != 0 ? developmentsCatalogResponse.alert : alertBannerInfo, (i & 32) != 0 ? developmentsCatalogResponse.developmentAdvice : developmentsAdvice, (i & 64) != 0 ? developmentsCatalogResponse.phone : phone2, (i & 128) != 0 ? developmentsCatalogResponse.infoParams : list2, (i & 256) != 0 ? developmentsCatalogResponse.developerCompany : developerCompany2, (i & 512) != 0 ? developmentsCatalogResponse.images : list3, (i & 1024) != 0 ? developmentsCatalogResponse.avitoOffers : avitoOffers2, (i & 2048) != 0 ? developmentsCatalogResponse.aboutDevelopment : aboutDevelopment2, (i & 4096) != 0 ? developmentsCatalogResponse.coords : coordinates, (i & 8192) != 0 ? developmentsCatalogResponse.share : str4, (i & 16384) != 0 ? developmentsCatalogResponse.locationId : str5, (i & 32768) != 0 ? developmentsCatalogResponse.legalDisclaimer : legalDisclaimer2, (i & 65536) != 0 ? developmentsCatalogResponse.amenityButtons : list4, (i & 131072) != 0 ? developmentsCatalogResponse.mapPreview : mapPreview2, (i & 262144) != 0 ? developmentsCatalogResponse.buildingProgress : buildingProgress2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final List<Image> component10() {
        return this.images;
    }

    @Nullable
    public final AvitoOffers component11() {
        return this.avitoOffers;
    }

    @Nullable
    public final AboutDevelopment component12() {
        return this.aboutDevelopment;
    }

    @Nullable
    public final Coordinates component13() {
        return this.coords;
    }

    @Nullable
    public final String component14() {
        return this.share;
    }

    @Nullable
    public final String component15() {
        return this.locationId;
    }

    @Nullable
    public final LegalDisclaimer component16() {
        return this.legalDisclaimer;
    }

    @Nullable
    public final List<AmenityButton> component17() {
        return this.amenityButtons;
    }

    @Nullable
    public final MapPreview component18() {
        return this.mapPreview;
    }

    @Nullable
    public final BuildingProgress component19() {
        return this.buildingProgress;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.address;
    }

    @Nullable
    public final List<MetroParam> component4() {
        return this.metro;
    }

    @Nullable
    public final AlertBannerInfo component5() {
        return this.alert;
    }

    @Nullable
    public final DevelopmentsAdvice component6() {
        return this.developmentAdvice;
    }

    @Nullable
    public final AdvertAction.Phone component7() {
        return this.phone;
    }

    @Nullable
    public final List<KeyValue> component8() {
        return this.infoParams;
    }

    @Nullable
    public final DeveloperCompany component9() {
        return this.developerCompany;
    }

    @NotNull
    public final DevelopmentsCatalogResponse copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<MetroParam> list, @Nullable AlertBannerInfo alertBannerInfo, @Nullable DevelopmentsAdvice developmentsAdvice, @Nullable AdvertAction.Phone phone2, @Nullable List<KeyValue> list2, @Nullable DeveloperCompany developerCompany2, @Nullable List<Image> list3, @Nullable AvitoOffers avitoOffers2, @Nullable AboutDevelopment aboutDevelopment2, @Nullable Coordinates coordinates, @Nullable String str4, @Nullable String str5, @Nullable LegalDisclaimer legalDisclaimer2, @Nullable List<AmenityButton> list4, @Nullable MapPreview mapPreview2, @Nullable BuildingProgress buildingProgress2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new DevelopmentsCatalogResponse(str, str2, str3, list, alertBannerInfo, developmentsAdvice, phone2, list2, developerCompany2, list3, avitoOffers2, aboutDevelopment2, coordinates, str4, str5, legalDisclaimer2, list4, mapPreview2, buildingProgress2);
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
        if (!(obj instanceof DevelopmentsCatalogResponse)) {
            return false;
        }
        DevelopmentsCatalogResponse developmentsCatalogResponse = (DevelopmentsCatalogResponse) obj;
        return Intrinsics.areEqual(this.id, developmentsCatalogResponse.id) && Intrinsics.areEqual(this.title, developmentsCatalogResponse.title) && Intrinsics.areEqual(this.address, developmentsCatalogResponse.address) && Intrinsics.areEqual(this.metro, developmentsCatalogResponse.metro) && Intrinsics.areEqual(this.alert, developmentsCatalogResponse.alert) && Intrinsics.areEqual(this.developmentAdvice, developmentsCatalogResponse.developmentAdvice) && Intrinsics.areEqual(this.phone, developmentsCatalogResponse.phone) && Intrinsics.areEqual(this.infoParams, developmentsCatalogResponse.infoParams) && Intrinsics.areEqual(this.developerCompany, developmentsCatalogResponse.developerCompany) && Intrinsics.areEqual(this.images, developmentsCatalogResponse.images) && Intrinsics.areEqual(this.avitoOffers, developmentsCatalogResponse.avitoOffers) && Intrinsics.areEqual(this.aboutDevelopment, developmentsCatalogResponse.aboutDevelopment) && Intrinsics.areEqual(this.coords, developmentsCatalogResponse.coords) && Intrinsics.areEqual(this.share, developmentsCatalogResponse.share) && Intrinsics.areEqual(this.locationId, developmentsCatalogResponse.locationId) && Intrinsics.areEqual(this.legalDisclaimer, developmentsCatalogResponse.legalDisclaimer) && Intrinsics.areEqual(this.amenityButtons, developmentsCatalogResponse.amenityButtons) && Intrinsics.areEqual(this.mapPreview, developmentsCatalogResponse.mapPreview) && Intrinsics.areEqual(this.buildingProgress, developmentsCatalogResponse.buildingProgress);
    }

    @Nullable
    public final AboutDevelopment getAboutDevelopment() {
        return this.aboutDevelopment;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final AlertBannerInfo getAlert() {
        return this.alert;
    }

    @Nullable
    public final List<AmenityButton> getAmenityButtons() {
        return this.amenityButtons;
    }

    @Nullable
    public final AvitoOffers getAvitoOffers() {
        return this.avitoOffers;
    }

    @Nullable
    public final BuildingProgress getBuildingProgress() {
        return this.buildingProgress;
    }

    @Nullable
    public final Coordinates getCoords() {
        return this.coords;
    }

    @Nullable
    public final DeveloperCompany getDeveloperCompany() {
        return this.developerCompany;
    }

    @Nullable
    public final DevelopmentsAdvice getDevelopmentAdvice() {
        return this.developmentAdvice;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<Image> getImages() {
        return this.images;
    }

    @Nullable
    public final List<KeyValue> getInfoParams() {
        return this.infoParams;
    }

    @Nullable
    public final LegalDisclaimer getLegalDisclaimer() {
        return this.legalDisclaimer;
    }

    @Nullable
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final MapPreview getMapPreview() {
        return this.mapPreview;
    }

    @Nullable
    public final List<MetroParam> getMetro() {
        return this.metro;
    }

    @Nullable
    public final AdvertAction.Phone getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getShare() {
        return this.share;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.address;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<MetroParam> list = this.metro;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        AlertBannerInfo alertBannerInfo = this.alert;
        int hashCode5 = (hashCode4 + (alertBannerInfo != null ? alertBannerInfo.hashCode() : 0)) * 31;
        DevelopmentsAdvice developmentsAdvice = this.developmentAdvice;
        int hashCode6 = (hashCode5 + (developmentsAdvice != null ? developmentsAdvice.hashCode() : 0)) * 31;
        AdvertAction.Phone phone2 = this.phone;
        int hashCode7 = (hashCode6 + (phone2 != null ? phone2.hashCode() : 0)) * 31;
        List<KeyValue> list2 = this.infoParams;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        DeveloperCompany developerCompany2 = this.developerCompany;
        int hashCode9 = (hashCode8 + (developerCompany2 != null ? developerCompany2.hashCode() : 0)) * 31;
        List<Image> list3 = this.images;
        int hashCode10 = (hashCode9 + (list3 != null ? list3.hashCode() : 0)) * 31;
        AvitoOffers avitoOffers2 = this.avitoOffers;
        int hashCode11 = (hashCode10 + (avitoOffers2 != null ? avitoOffers2.hashCode() : 0)) * 31;
        AboutDevelopment aboutDevelopment2 = this.aboutDevelopment;
        int hashCode12 = (hashCode11 + (aboutDevelopment2 != null ? aboutDevelopment2.hashCode() : 0)) * 31;
        Coordinates coordinates = this.coords;
        int hashCode13 = (hashCode12 + (coordinates != null ? coordinates.hashCode() : 0)) * 31;
        String str4 = this.share;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.locationId;
        int hashCode15 = (hashCode14 + (str5 != null ? str5.hashCode() : 0)) * 31;
        LegalDisclaimer legalDisclaimer2 = this.legalDisclaimer;
        int hashCode16 = (hashCode15 + (legalDisclaimer2 != null ? legalDisclaimer2.hashCode() : 0)) * 31;
        List<AmenityButton> list4 = this.amenityButtons;
        int hashCode17 = (hashCode16 + (list4 != null ? list4.hashCode() : 0)) * 31;
        MapPreview mapPreview2 = this.mapPreview;
        int hashCode18 = (hashCode17 + (mapPreview2 != null ? mapPreview2.hashCode() : 0)) * 31;
        BuildingProgress buildingProgress2 = this.buildingProgress;
        if (buildingProgress2 != null) {
            i = buildingProgress2.hashCode();
        }
        return hashCode18 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DevelopmentsCatalogResponse(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", address=");
        L.append(this.address);
        L.append(", metro=");
        L.append(this.metro);
        L.append(", alert=");
        L.append(this.alert);
        L.append(", developmentAdvice=");
        L.append(this.developmentAdvice);
        L.append(", phone=");
        L.append(this.phone);
        L.append(", infoParams=");
        L.append(this.infoParams);
        L.append(", developerCompany=");
        L.append(this.developerCompany);
        L.append(", images=");
        L.append(this.images);
        L.append(", avitoOffers=");
        L.append(this.avitoOffers);
        L.append(", aboutDevelopment=");
        L.append(this.aboutDevelopment);
        L.append(", coords=");
        L.append(this.coords);
        L.append(", share=");
        L.append(this.share);
        L.append(", locationId=");
        L.append(this.locationId);
        L.append(", legalDisclaimer=");
        L.append(this.legalDisclaimer);
        L.append(", amenityButtons=");
        L.append(this.amenityButtons);
        L.append(", mapPreview=");
        L.append(this.mapPreview);
        L.append(", buildingProgress=");
        L.append(this.buildingProgress);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.address);
        List<MetroParam> list = this.metro;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MetroParam) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.alert, i);
        DevelopmentsAdvice developmentsAdvice = this.developmentAdvice;
        if (developmentsAdvice != null) {
            parcel.writeInt(1);
            developmentsAdvice.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.phone, i);
        List<KeyValue> list2 = this.infoParams;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                ((KeyValue) l02.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        DeveloperCompany developerCompany2 = this.developerCompany;
        if (developerCompany2 != null) {
            parcel.writeInt(1);
            developerCompany2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<Image> list3 = this.images;
        if (list3 != null) {
            Iterator l03 = a.l0(parcel, 1, list3);
            while (l03.hasNext()) {
                parcel.writeParcelable((Image) l03.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        AvitoOffers avitoOffers2 = this.avitoOffers;
        if (avitoOffers2 != null) {
            parcel.writeInt(1);
            avitoOffers2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AboutDevelopment aboutDevelopment2 = this.aboutDevelopment;
        if (aboutDevelopment2 != null) {
            parcel.writeInt(1);
            aboutDevelopment2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.coords, i);
        parcel.writeString(this.share);
        parcel.writeString(this.locationId);
        LegalDisclaimer legalDisclaimer2 = this.legalDisclaimer;
        if (legalDisclaimer2 != null) {
            parcel.writeInt(1);
            legalDisclaimer2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<AmenityButton> list4 = this.amenityButtons;
        if (list4 != null) {
            Iterator l04 = a.l0(parcel, 1, list4);
            while (l04.hasNext()) {
                parcel.writeParcelable((AmenityButton) l04.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        MapPreview mapPreview2 = this.mapPreview;
        if (mapPreview2 != null) {
            parcel.writeInt(1);
            mapPreview2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.buildingProgress, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DevelopmentsCatalogResponse(String str, String str2, String str3, List list, AlertBannerInfo alertBannerInfo, DevelopmentsAdvice developmentsAdvice, AdvertAction.Phone phone2, List list2, DeveloperCompany developerCompany2, List list3, AvitoOffers avitoOffers2, AboutDevelopment aboutDevelopment2, Coordinates coordinates, String str4, String str5, LegalDisclaimer legalDisclaimer2, List list4, MapPreview mapPreview2, BuildingProgress buildingProgress2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : alertBannerInfo, (i & 32) != 0 ? null : developmentsAdvice, (i & 64) != 0 ? null : phone2, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : developerCompany2, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : avitoOffers2, (i & 2048) != 0 ? null : aboutDevelopment2, (i & 4096) != 0 ? null : coordinates, (i & 8192) != 0 ? null : str4, (i & 16384) != 0 ? null : str5, (32768 & i) != 0 ? null : legalDisclaimer2, (65536 & i) != 0 ? null : list4, (131072 & i) != 0 ? null : mapPreview2, (i & 262144) != 0 ? null : buildingProgress2);
    }
}

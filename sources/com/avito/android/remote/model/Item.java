package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.util.AvitoCollectionUtils;
import com.avito.android.util.AvitoTextUtils;
import com.avito.android.util.BooleansKt;
import com.avito.android.util.ParcelUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Deprecated
public class Item implements LocationInfo, Parcelable, Comparable<Item> {
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() { // from class: com.avito.android.remote.model.Item.1
        @Override // android.os.Parcelable.Creator
        public Item createFromParcel(Parcel parcel) {
            return new Item(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Item[] newArray(int i) {
            return new Item[i];
        }
    };
    @Nullable
    private AdvertActions actions;
    @Nullable
    public String address;
    @Nullable
    private AnonymousNumber anonymousNumber;
    @Nullable
    private AutoDeal autoDeal;
    @Nullable
    public String categoryId;
    @Nullable
    private String categoryName;
    @Nullable
    private Coordinates coordinates;
    @Nullable
    private DfpBannerItem creditInfo;
    @Nullable
    private AdvertDeliveryC2C delivery;
    public String description;
    public String directionId;
    public String districtId;
    private boolean enableDelivery;
    @Nullable
    private Map<String, String> firebaseParams;
    public boolean hidePhone;
    @NonNull
    public String id;
    @NonNull
    public final List<ExtendedImage> images;
    public boolean isFavorite;
    @Nullable
    public String locationId;
    @NonNull
    private List<Action> mActions;
    @Nullable
    private String mDirectionName;
    @Nullable
    private String mDistrictName;
    @Nullable
    private String mLocationName;
    @Nullable
    private String mMetroName;
    @Nullable
    private Video mVideo;
    public String metroId;
    @Nullable
    private MyAdvertVas myAdvertVas;
    @Nullable
    private String note;
    @Nullable
    private AdvertParameters parameters;
    public String phone;
    public boolean phoneOnly;
    @Nullable
    public AdvertPrice price;
    @NonNull
    private List<RejectReason> rejectReasons;
    @Nullable
    private AdvertSeller seller;
    @Nullable
    private AdvertSharing sharing;
    @Nullable
    public String shopId;
    @Nullable
    public String shopName;
    @Nullable
    private AdvertStats stats;
    @Nullable
    public String status;
    public long time;
    public String title;
    @Nullable
    public String ttlHumanized;
    @Nullable
    public String userType;
    @Nullable
    private String version;
    @NonNull
    private String wizardId;

    public Item() {
        this.images = new ArrayList(0);
        this.rejectReasons = Collections.emptyList();
        this.mActions = Collections.emptyList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Item)) {
            return this.id.equals(((Item) obj).id);
        }
        return false;
    }

    @NonNull
    public List<Action> getActions() {
        return this.mActions;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    public String getAddress() {
        return this.address;
    }

    @Nullable
    public AdvertActions getAdvertActions() {
        return this.actions;
    }

    @Nullable
    public AnonymousNumber getAnonymousNumber() {
        return this.anonymousNumber;
    }

    @Nullable
    public AutoDeal getAutoDeal() {
        return this.autoDeal;
    }

    @Nullable
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public DfpBannerItem getCreditInfo() {
        return this.creditInfo;
    }

    @Nullable
    public AdvertDeliveryC2C getDelivery() {
        return this.delivery;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    @Deprecated
    public String getDirectionName() {
        return this.mDirectionName;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    @Deprecated
    public String getDistrictName() {
        return this.mDistrictName;
    }

    @Nullable
    public Map<String, String> getFirebaseParams() {
        return this.firebaseParams;
    }

    @NonNull
    public List<Image> getImages() {
        ArrayList arrayList = new ArrayList(this.images.size());
        for (ExtendedImage extendedImage : this.images) {
            arrayList.add(extendedImage.getImage());
        }
        return arrayList;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    @Deprecated
    public String getLocationName() {
        return this.mLocationName;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    @Deprecated
    public String getMetroName() {
        return this.mMetroName;
    }

    @Nullable
    public MyAdvertVas getMyAdvertVas() {
        return this.myAdvertVas;
    }

    @Nullable
    public String getNote() {
        return this.note;
    }

    @Nullable
    public AdvertParameters getParameters() {
        return this.parameters;
    }

    @Nullable
    public AdvertPrice getPrice() {
        return this.price;
    }

    @NonNull
    public List<RejectReason> getRejectReasons() {
        return this.rejectReasons;
    }

    @Nullable
    public AdvertSeller getSeller() {
        return this.seller;
    }

    @Nullable
    public AdvertSharing getSharing() {
        return this.sharing;
    }

    @Nullable
    public AdvertStats getStats() {
        return this.stats;
    }

    public String getTitle() {
        return this.title;
    }

    @Nullable
    public String getVersion() {
        return this.version;
    }

    @Nullable
    public Video getVideo() {
        return this.mVideo;
    }

    @NonNull
    public String getWizardId() {
        return this.wizardId;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasAddress() {
        return !TextUtils.isEmpty(this.address);
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasCoordinates() {
        Coordinates coordinates2 = this.coordinates;
        return coordinates2 != null && !coordinates2.isEmpty();
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasDirection() {
        return !TextUtils.isEmpty(this.directionId);
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasDistrict() {
        return !TextUtils.isEmpty(this.districtId);
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasLocation() {
        return !TextUtils.isEmpty(this.locationId);
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasMetro() {
        return !TextUtils.isEmpty(this.metroId);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean isDeliveryEnabled() {
        return this.enableDelivery;
    }

    public boolean isFromCompany() {
        return "company".equals(this.userType);
    }

    public boolean isShopItem() {
        return BooleansKt.not(AvitoTextUtils.isNullOrEmpty(this.shopId));
    }

    public void setActions(@NonNull List<Action> list) {
        this.mActions = AvitoCollectionUtils.notNull(list);
    }

    public void setAdvertActions(@Nullable AdvertActions advertActions) {
        this.actions = advertActions;
    }

    public void setAnonymousNumber(@Nullable AnonymousNumber anonymousNumber2) {
        this.anonymousNumber = anonymousNumber2;
    }

    public void setAutoDeal(@Nullable AutoDeal autoDeal2) {
        this.autoDeal = autoDeal2;
    }

    public void setCategoryName(@Nullable String str) {
        this.categoryName = str;
    }

    public void setCoordinates(@Nullable Coordinates coordinates2) {
        this.coordinates = coordinates2;
    }

    public void setCreditInfo(@Nullable DfpBannerItem dfpBannerItem) {
        this.creditInfo = dfpBannerItem;
    }

    public void setDelivery(@Nullable AdvertDeliveryC2C advertDeliveryC2C) {
        this.delivery = advertDeliveryC2C;
    }

    public void setDeliveryEnabled(boolean z) {
        this.enableDelivery = z;
    }

    public void setDirectionName(@Nullable String str) {
        this.mDirectionName = str;
    }

    public void setDistrictName(@Nullable String str) {
        this.mDistrictName = str;
    }

    public void setFirebaseParams(@Nullable Map<String, String> map) {
        this.firebaseParams = map;
    }

    public void setLocationName(@Nullable String str) {
        this.mLocationName = str;
    }

    public void setMetroName(@Nullable String str) {
        this.mMetroName = str;
    }

    public void setMyAdvertVas(@Nullable MyAdvertVas myAdvertVas2) {
        this.myAdvertVas = myAdvertVas2;
    }

    public void setNote(@Nullable String str) {
        this.note = str;
    }

    public void setNullableWizardId(@Nullable String str) {
        if (str != null) {
            this.wizardId = str;
        }
    }

    public void setParameters(@Nullable AdvertParameters advertParameters) {
        this.parameters = advertParameters;
    }

    public void setRejectReasons(@NonNull List<RejectReason> list) {
        this.rejectReasons = AvitoCollectionUtils.notNull(list);
    }

    public void setSeller(@Nullable AdvertSeller advertSeller) {
        this.seller = advertSeller;
    }

    public void setSharing(@Nullable AdvertSharing advertSharing) {
        this.sharing = advertSharing;
    }

    public void setStats(@Nullable AdvertStats advertStats) {
        this.stats = advertStats;
    }

    public void setVersion(@Nullable String str) {
        this.version = str;
    }

    public void setVideo(@Nullable Video video) {
        this.mVideo = video;
    }

    public void setWizardId(@NonNull String str) {
        this.wizardId = str;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append(" [id=");
        return a.t(sb, this.id, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.locationId);
        parcel.writeString(this.mLocationName);
        parcel.writeString(this.address);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.metroId);
        parcel.writeString(this.mMetroName);
        parcel.writeString(this.districtId);
        parcel.writeString(this.mDistrictName);
        parcel.writeString(this.directionId);
        parcel.writeString(this.mDirectionName);
        parcel.writeString(this.categoryId);
        parcel.writeLong(this.time);
        if (!TextUtils.isEmpty(this.ttlHumanized)) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.ttlHumanized);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (!TextUtils.isEmpty(this.phone)) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.phone);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeByte(this.phoneOnly ? (byte) 1 : 0);
        parcel.writeByte(this.hidePhone ? (byte) 1 : 0);
        parcel.writeString(this.title);
        parcel.writeString(this.userType);
        parcel.writeTypedList(this.images);
        if (this.price != null) {
            parcel.writeByte((byte) 1);
            parcel.writeParcelable(this.price, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.status);
        if (this.seller != null) {
            parcel.writeByte((byte) 1);
            parcel.writeParcelable(this.seller, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (!TextUtils.isEmpty(this.description)) {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.description);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeParcelable(this.parameters, i);
        parcel.writeParcelable(this.stats, i);
        parcel.writeTypedList(this.rejectReasons);
        parcel.writeString(this.shopId);
        parcel.writeString(this.shopName);
        parcel.writeParcelable(this.mVideo, i);
        ParcelUtils.writeOptimizedParcelableList(parcel, this.mActions);
        parcel.writeParcelable(this.actions, i);
        parcel.writeParcelable(this.delivery, i);
        parcel.writeParcelable(this.sharing, i);
        parcel.writeString(this.wizardId);
        parcel.writeString(this.version);
        parcel.writeParcelable(this.myAdvertVas, i);
        parcel.writeParcelable(this.anonymousNumber, i);
        parcel.writeParcelable(this.creditInfo, i);
        parcel.writeString(this.note);
        ParcelUtils.writeValueMap(parcel, this.firebaseParams);
        parcel.writeParcelable(this.autoDeal, i);
        parcel.writeString(this.categoryName);
    }

    public int compareTo(Item item) {
        int i = ((this.time - item.time) > 0 ? 1 : ((this.time - item.time) == 0 ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }

    public Item(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = new ArrayList(0);
        this.images = arrayList;
        this.rejectReasons = Collections.emptyList();
        this.mActions = Collections.emptyList();
        this.id = parcel.readString();
        this.locationId = parcel.readString();
        this.mLocationName = parcel.readString();
        this.address = parcel.readString();
        this.coordinates = (Coordinates) parcel.readParcelable(Coordinates.class.getClassLoader());
        this.metroId = parcel.readString();
        this.mMetroName = parcel.readString();
        this.districtId = parcel.readString();
        this.mDistrictName = parcel.readString();
        this.directionId = parcel.readString();
        this.mDirectionName = parcel.readString();
        this.categoryId = parcel.readString();
        this.time = parcel.readLong();
        if (parcel.readByte() > 0) {
            this.ttlHumanized = parcel.readString();
        }
        if (parcel.readByte() > 0) {
            this.phone = parcel.readString();
        }
        this.phoneOnly = parcel.readByte() > 0;
        this.hidePhone = parcel.readByte() > 0 ? true : z;
        this.title = parcel.readString();
        this.userType = parcel.readString();
        parcel.readTypedList(arrayList, ExtendedImage.CREATOR);
        if (parcel.readByte() > 0) {
            this.price = (AdvertPrice) parcel.readParcelable(AdvertPrice.class.getClassLoader());
        }
        this.status = parcel.readString();
        if (parcel.readByte() > 0) {
            this.seller = (AdvertSeller) parcel.readParcelable(AdvertSeller.class.getClassLoader());
        }
        if (parcel.readByte() > 0) {
            this.description = parcel.readString();
        }
        this.parameters = (AdvertParameters) parcel.readParcelable(AdvertParameters.class.getClassLoader());
        this.stats = (AdvertStats) parcel.readParcelable(AdvertStats.class.getClassLoader());
        this.rejectReasons = parcel.createTypedArrayList(RejectReason.CREATOR);
        this.shopId = parcel.readString();
        this.shopName = parcel.readString();
        this.mVideo = (Video) parcel.readParcelable(Video.class.getClassLoader());
        this.mActions = AvitoCollectionUtils.notNull(ParcelUtils.createParcelableList(parcel, Action.class));
        this.actions = (AdvertActions) parcel.readParcelable(AdvertActions.class.getClassLoader());
        this.delivery = (AdvertDeliveryC2C) parcel.readParcelable(AdvertDeliveryC2C.class.getClassLoader());
        this.sharing = (AdvertSharing) parcel.readParcelable(AdvertSharing.class.getClassLoader());
        this.wizardId = parcel.readString();
        this.version = parcel.readString();
        this.myAdvertVas = (MyAdvertVas) parcel.readParcelable(MyAdvertVas.class.getClassLoader());
        this.anonymousNumber = (AnonymousNumber) parcel.readParcelable(AnonymousNumber.class.getClassLoader());
        this.creditInfo = (DfpBannerItem) parcel.readParcelable(DfpBannerItem.class.getClassLoader());
        this.note = parcel.readString();
        this.firebaseParams = ParcelUtils.createValueMap(parcel, String.class, String.class);
        this.autoDeal = (AutoDeal) parcel.readParcelable(AutoDeal.class.getClassLoader());
        this.categoryName = parcel.readString();
    }
}

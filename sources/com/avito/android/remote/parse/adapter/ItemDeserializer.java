package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.AutoDeal;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.ExtendedImage;
import com.avito.android.remote.model.Item;
import com.avito.android.remote.model.MyAdvertVas;
import com.avito.android.remote.model.RejectReason;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vk.sdk.api.model.VKAttachments;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ItemDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/Item;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/Item;", "Lcom/google/gson/JsonObject;", "jsonObject", "", "dictionaryName", "id", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ItemDeserializer implements JsonDeserializer<Item> {
    public ItemDeserializer(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
    }

    public final String a(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        JsonObject asJsonObject2;
        JsonElement jsonElement3;
        if (str2 == null || str2.length() == 0 || (jsonElement = jsonObject.get(str)) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (jsonElement2 = asJsonObject.get(str2)) == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null || (jsonElement3 = asJsonObject2.get("name")) == null) {
            return null;
        }
        return jsonElement3.getAsString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:216:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:219:0x00e7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00e7 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: com.avito.android.remote.model.Item */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList] */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public Item deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        List list;
        List list2;
        String str;
        String str2;
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        JsonElement jsonElement3;
        JsonObject asJsonObject2;
        JsonElement jsonElement4;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        Item item = new Item();
        item.categoryId = a.x2(I1, "categoryId", "jsonObject[\"categoryId\"]");
        item.id = a.x2(I1, "id", "jsonObject[\"id\"]");
        item.title = a.x2(I1, "title", "jsonObject[\"title\"]");
        JsonElement jsonElement5 = I1.get("actions");
        String str3 = null;
        JsonArray asJsonArray = jsonElement5 != null ? jsonElement5.getAsJsonArray() : null;
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            list = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement6 = asJsonArray.get(i);
                list.add(jsonDeserializationContext.deserialize(jsonElement6 != null ? jsonElement6.getAsJsonObject() : null, Action.class));
            }
        } else {
            list = 0;
        }
        if (list == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        item.setActions(list);
        JsonElement jsonElement7 = I1.get("enableDelivery");
        item.setDeliveryEnabled(jsonElement7 != null ? jsonElement7.getAsBoolean() : false);
        JsonElement jsonElement8 = I1.get("isFavorite");
        item.isFavorite = jsonElement8 != null ? jsonElement8.getAsBoolean() : false;
        JsonElement jsonElement9 = I1.get("phoneOnly");
        item.phoneOnly = jsonElement9 != null ? jsonElement9.getAsBoolean() : false;
        JsonElement jsonElement10 = I1.get(ChannelContext.Item.HIDE_PHONE);
        item.hidePhone = jsonElement10 != null ? jsonElement10.getAsBoolean() : false;
        JsonElement jsonElement11 = I1.get("reasons");
        JsonArray asJsonArray2 = jsonElement11 != null ? jsonElement11.getAsJsonArray() : null;
        if (asJsonArray2 != null) {
            int size2 = asJsonArray2.size();
            list2 = new ArrayList(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                JsonElement jsonElement12 = asJsonArray2.get(i2);
                list2.add(jsonDeserializationContext.deserialize(jsonElement12 != null ? jsonElement12.getAsJsonObject() : null, RejectReason.class));
            }
        } else {
            list2 = 0;
        }
        if (list2 == 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        item.setRejectReasons(list2);
        JsonElement jsonElement13 = I1.get("time");
        item.time = jsonElement13 != null ? jsonElement13.getAsLong() : 0;
        JsonElement jsonElement14 = I1.get(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        item.address = jsonElement14 != null ? jsonElement14.getAsString() : null;
        JsonElement jsonElement15 = I1.get("contacts");
        item.setAdvertActions((AdvertActions) (jsonElement15 != null ? jsonDeserializationContext.deserialize(jsonElement15, AdvertActions.class) : null));
        JsonElement jsonElement16 = I1.get("anonymousNumber");
        item.setAnonymousNumber((AnonymousNumber) (jsonElement16 != null ? jsonDeserializationContext.deserialize(jsonElement16, AnonymousNumber.class) : null));
        JsonElement jsonElement17 = I1.get("deliveryC2C");
        AdvertDeliveryC2C advertDeliveryC2C = (AdvertDeliveryC2C) (jsonElement17 != null ? jsonDeserializationContext.deserialize(jsonElement17, AdvertDeliveryC2C.class) : null);
        if (advertDeliveryC2C == null) {
            JsonElement jsonElement18 = I1.get("delivery");
            advertDeliveryC2C = (AdvertDeliveryC2C) (jsonElement18 != null ? jsonDeserializationContext.deserialize(jsonElement18, AdvertDeliveryC2C.class) : null);
        }
        item.setDelivery(advertDeliveryC2C);
        JsonElement jsonElement19 = I1.get("description");
        item.description = jsonElement19 != null ? jsonElement19.getAsString() : null;
        JsonElement jsonElement20 = I1.get(UrlParams.DIRECTION_ID);
        item.directionId = jsonElement20 != null ? jsonElement20.getAsString() : null;
        JsonElement jsonElement21 = I1.get(UrlParams.DISTRICT_ID);
        item.districtId = jsonElement21 != null ? jsonElement21.getAsString() : null;
        JsonElement jsonElement22 = I1.get("locationId");
        item.locationId = jsonElement22 != null ? jsonElement22.getAsString() : null;
        JsonElement jsonElement23 = I1.get(UrlParams.METRO_ID);
        item.metroId = jsonElement23 != null ? jsonElement23.getAsString() : null;
        JsonElement jsonElement24 = I1.get("vas");
        item.setMyAdvertVas((MyAdvertVas) (jsonElement24 != null ? jsonDeserializationContext.deserialize(jsonElement24, MyAdvertVas.class) : null));
        JsonElement jsonElement25 = I1.get(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        item.setParameters((AdvertParameters) (jsonElement25 != null ? jsonDeserializationContext.deserialize(jsonElement25, AdvertParameters.class) : null));
        JsonElement jsonElement26 = I1.get("phone");
        item.phone = jsonElement26 != null ? jsonElement26.getAsString() : null;
        JsonElement jsonElement27 = I1.get("price");
        item.price = (AdvertPrice) (jsonElement27 != null ? jsonDeserializationContext.deserialize(jsonElement27, AdvertPrice.class) : null);
        JsonElement jsonElement28 = I1.get("seller");
        item.setSeller((AdvertSeller) (jsonElement28 != null ? jsonDeserializationContext.deserialize(jsonElement28, AdvertSeller.class) : null));
        JsonElement jsonElement29 = I1.get("sharing");
        item.setSharing((AdvertSharing) (jsonElement29 != null ? jsonDeserializationContext.deserialize(jsonElement29, AdvertSharing.class) : null));
        JsonElement jsonElement30 = I1.get("shopId");
        if (jsonElement30 == null || (str = jsonElement30.getAsString()) == null) {
            JsonElement jsonElement31 = I1.get(ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
            str = (jsonElement31 == null || (asJsonObject2 = jsonElement31.getAsJsonObject()) == null || (jsonElement4 = asJsonObject2.get("id")) == null) ? null : jsonElement4.getAsString();
        }
        item.shopId = str;
        JsonElement jsonElement32 = I1.get(ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        item.shopName = (jsonElement32 == null || (asJsonObject = jsonElement32.getAsJsonObject()) == null || (jsonElement3 = asJsonObject.get("name")) == null) ? null : jsonElement3.getAsString();
        JsonElement jsonElement33 = I1.get("status");
        item.status = jsonElement33 != null ? jsonElement33.getAsString() : null;
        JsonElement jsonElement34 = I1.get("stats");
        item.setStats((AdvertStats) (jsonElement34 != null ? jsonDeserializationContext.deserialize(jsonElement34, AdvertStats.class) : null));
        JsonElement jsonElement35 = I1.get("ttlHumanized");
        item.ttlHumanized = jsonElement35 != null ? jsonElement35.getAsString() : null;
        JsonElement jsonElement36 = I1.get("userType");
        item.userType = jsonElement36 != null ? jsonElement36.getAsString() : null;
        JsonElement jsonElement37 = I1.get("version");
        item.setVersion(jsonElement37 != null ? jsonElement37.getAsString() : null);
        JsonElement jsonElement38 = I1.get("video");
        item.setVideo((Video) (jsonElement38 != null ? jsonDeserializationContext.deserialize(jsonElement38, Video.class) : null));
        JsonElement jsonElement39 = I1.get("creditInfo");
        item.setCreditInfo((DfpBannerItem) (jsonElement39 != null ? jsonDeserializationContext.deserialize(jsonElement39, DfpBannerItem.class) : null));
        JsonElement jsonElement40 = I1.get(VKAttachments.TYPE_NOTE);
        item.setNote((String) (jsonElement40 != null ? jsonDeserializationContext.deserialize(jsonElement40, String.class) : null));
        JsonElement jsonElement41 = I1.get("firebaseParams");
        item.setFirebaseParams((Map) (jsonElement41 != null ? jsonDeserializationContext.deserialize(jsonElement41, Map.class) : null));
        JsonElement jsonElement42 = I1.get("autodeal");
        item.setAutoDeal((AutoDeal) (jsonElement42 != null ? jsonDeserializationContext.deserialize(jsonElement42, AutoDeal.class) : null));
        JsonElement jsonElement43 = I1.get(ParameterId.COORDS);
        JsonObject asJsonObject3 = jsonElement43 != null ? jsonElement43.getAsJsonObject() : null;
        if (asJsonObject3 != null) {
            Object deserialize = jsonDeserializationContext.deserialize(asJsonObject3, Coordinates.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
            item.setCoordinates((Coordinates) deserialize);
        }
        JsonElement jsonElement44 = I1.get("images");
        if (jsonElement44 != null) {
            if (jsonElement44.isJsonArray()) {
                JsonArray asJsonArray3 = jsonElement44.getAsJsonArray();
                int size3 = asJsonArray3.size();
                ArrayList arrayList = new ArrayList(size3);
                for (int i3 = 0; i3 < size3; i3++) {
                    JsonElement jsonElement45 = asJsonArray3.get(i3);
                    Intrinsics.checkNotNullExpressionValue(jsonElement45, "jsonArray[a]");
                    JsonObject asJsonObject4 = jsonElement45.getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(asJsonObject4, "jsonArray[a].asJsonObject");
                    Object deserialize2 = jsonDeserializationContext.deserialize(asJsonObject4, ExtendedImage.class);
                    Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
                    item.images.add((ExtendedImage) deserialize2);
                }
                item.images.addAll(arrayList);
            } else if (jsonElement44.isJsonObject()) {
                JsonElement jsonElement46 = jsonElement44.getAsJsonObject().get("main");
                Intrinsics.checkNotNullExpressionValue(jsonElement46, "jsonObject[\"main\"]");
                Object deserialize3 = jsonDeserializationContext.deserialize(jsonElement46, ExtendedImage.class);
                Intrinsics.checkNotNullExpressionValue(deserialize3, "deserialize(json, T::class.java)");
                item.images.add((ExtendedImage) deserialize3);
            }
        }
        JsonElement jsonElement47 = I1.get("refs");
        JsonObject asJsonObject5 = jsonElement47 != null ? jsonElement47.getAsJsonObject() : null;
        if (asJsonObject5 != null) {
            item.setLocationName(a(asJsonObject5, "locations", item.locationId));
            item.setMetroName(a(asJsonObject5, "metro", item.metroId));
            item.setDistrictName(a(asJsonObject5, "districts", item.districtId));
            item.setDirectionName(a(asJsonObject5, "directions", item.directionId));
            item.setCategoryName(a(asJsonObject5, "categories", item.categoryId));
        }
        Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
        JsonElement jsonElement48 = I1.get(ParameterId.EDIT);
        if (jsonElement48 == null || (str2 = jsonElement48.getAsString()) == null) {
            JsonElement jsonElement49 = I1.get("params");
            if (jsonElement49 != null && ((jsonElement2 = jsonElement49.getAsJsonObject().get(ParameterId.EDIT)) == null || (str3 = jsonElement2.getAsString()) == null)) {
                str3 = "";
            }
            str2 = str3;
        }
        item.setNullableWizardId(str2);
        return item;
    }
}

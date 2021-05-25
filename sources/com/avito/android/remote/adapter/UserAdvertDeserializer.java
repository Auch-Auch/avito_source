package com.avito.android.remote.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertImage;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.Service;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vk.sdk.api.VKApiConst;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/adapter/UserAdvertDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/UserAdvert;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/UserAdvert;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertDeserializer implements JsonDeserializer<UserAdvert> {
    public final Features a;

    public UserAdvertDeserializer(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public UserAdvert deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        long j;
        ArrayList arrayList;
        UserOrderStatus userOrderStatus;
        ForegroundImage foregroundImage;
        JsonElement jsonElement2;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "id", "jsonObject[\"id\"]");
        String x22 = a.x2(I1, "title", "jsonObject[\"title\"]");
        JsonElement jsonElement3 = I1.get("category");
        NameIdEntity nameIdEntity = (NameIdEntity) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, NameIdEntity.class) : null);
        JsonElement jsonElement4 = I1.get("images");
        AdvertImage advertImage = (AdvertImage) (jsonElement4 != null ? jsonDeserializationContext.deserialize(jsonElement4, AdvertImage.class) : null);
        JsonElement jsonElement5 = I1.get("video");
        Video video = (Video) (jsonElement5 != null ? jsonDeserializationContext.deserialize(jsonElement5, Video.class) : null);
        JsonElement jsonElement6 = I1.get("price");
        String asString = jsonElement6 != null ? jsonElement6.getAsString() : null;
        JsonElement jsonElement7 = I1.get("shortcut");
        String asString2 = jsonElement7 != null ? jsonElement7.getAsString() : null;
        JsonElement jsonElement8 = I1.get("time");
        Intrinsics.checkNotNullExpressionValue(jsonElement8, "jsonObject[\"time\"]");
        long asLong = jsonElement8.getAsLong();
        JsonElement jsonElement9 = I1.get("stats");
        AdvertStats advertStats = (AdvertStats) (jsonElement9 != null ? jsonDeserializationContext.deserialize(jsonElement9, AdvertStats.class) : null);
        JsonElement jsonElement10 = I1.get(VKApiConst.SERVICES);
        Intrinsics.checkNotNullExpressionValue(jsonElement10, "jsonObject[\"services\"]");
        JsonArray asJsonArray = jsonElement10.getAsJsonArray();
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            j = asLong;
            ArrayList arrayList2 = new ArrayList(size);
            int i = 0;
            while (i < size) {
                JsonElement jsonElement11 = asJsonArray.get(i);
                arrayList2.add(jsonDeserializationContext.deserialize(jsonElement11 != null ? jsonElement11.getAsJsonObject() : null, Service.class));
                i++;
                asJsonArray = asJsonArray;
                size = size;
            }
            arrayList = arrayList2;
        } else {
            j = asLong;
            arrayList = null;
        }
        JsonElement jsonElement12 = I1.get(Constants.FirelogAnalytics.PARAM_TTL);
        TimeToLive timeToLive = (TimeToLive) (jsonElement12 != null ? jsonDeserializationContext.deserialize(jsonElement12, TimeToLive.class) : null);
        JsonElement jsonElement13 = I1.get("declineReason");
        String asString3 = jsonElement13 != null ? jsonElement13.getAsString() : null;
        JsonElement jsonElement14 = I1.get(ShareConstants.MEDIA_URI);
        DeepLink deepLink = (DeepLink) (jsonElement14 != null ? jsonDeserializationContext.deserialize(jsonElement14, DeepLink.class) : null);
        Boolean valueOf = Boolean.valueOf(I1.get("delivery") != null);
        JsonElement jsonElement15 = I1.get("status");
        UserAdvert.Status status = (UserAdvert.Status) (jsonElement15 != null ? jsonDeserializationContext.deserialize(jsonElement15, UserAdvert.Status.class) : null);
        if (this.a.getOrderStatusOnSnippet().invoke().booleanValue()) {
            JsonElement jsonElement16 = I1.get("orderStatus");
            userOrderStatus = (UserOrderStatus) (jsonElement16 != null ? jsonDeserializationContext.deserialize(jsonElement16, UserOrderStatus.class) : null);
        } else {
            userOrderStatus = null;
        }
        JsonElement jsonElement17 = I1.get("shortcutTitle");
        String asString4 = jsonElement17 != null ? jsonElement17.getAsString() : null;
        JsonElement jsonElement18 = I1.get("priceBadge");
        PriceBadge priceBadge = (PriceBadge) (jsonElement18 != null ? jsonDeserializationContext.deserialize(jsonElement18, PriceBadge.class) : null);
        JsonElement jsonElement19 = I1.get("isAutoPublishOn");
        Boolean valueOf2 = jsonElement19 != null ? Boolean.valueOf(jsonElement19.getAsBoolean()) : null;
        boolean asBoolean = (!this.a.getAdvertOnModerationHighlight().invoke().booleanValue() || (jsonElement2 = I1.get("isModerated")) == null) ? false : jsonElement2.getAsBoolean();
        if (this.a.getBadSellers().invoke().booleanValue()) {
            JsonElement jsonElement20 = I1.get("infoImage");
            foregroundImage = (ForegroundImage) (jsonElement20 != null ? jsonDeserializationContext.deserialize(jsonElement20, ForegroundImage.class) : null);
        } else {
            foregroundImage = null;
        }
        Intrinsics.checkNotNullExpressionValue(x2, "id");
        Intrinsics.checkNotNullExpressionValue(x22, "title");
        return new UserAdvert(x2, x22, nameIdEntity, advertImage, video, asString, asString2, j, advertStats, arrayList, timeToLive, asString3, asBoolean, deepLink, valueOf, status, userOrderStatus, asString4, priceBadge, valueOf2, foregroundImage);
    }
}

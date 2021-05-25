package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.AdvertStatsContact;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertStatsAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertStats;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertStats;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsAdapter implements JsonDeserializer<AdvertStats> {
    public final Features a;

    public AdvertStatsAdapter(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AdvertStats deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement5 = I1.get("views");
        AdvertStatsContact advertStatsContact = null;
        Object obj = null;
        JsonObject asJsonObject = jsonElement5 != null ? jsonElement5.getAsJsonObject() : null;
        Integer valueOf = (asJsonObject == null || (jsonElement4 = asJsonObject.get("total")) == null) ? null : Integer.valueOf(jsonElement4.getAsInt());
        Integer valueOf2 = (asJsonObject == null || (jsonElement3 = asJsonObject.get("today")) == null) ? null : Integer.valueOf(jsonElement3.getAsInt());
        JsonElement jsonElement6 = I1.get(FavoritesContract.TABLE_NAME);
        JsonObject asJsonObject2 = jsonElement6 != null ? jsonElement6.getAsJsonObject() : null;
        Integer valueOf3 = (asJsonObject2 == null || (jsonElement2 = asJsonObject2.get("total")) == null) ? null : Integer.valueOf(jsonElement2.getAsInt());
        JsonElement jsonElement7 = I1.get(ShareConstants.MEDIA_URI);
        DeepLink deepLink = (DeepLink) (jsonElement7 != null ? jsonDeserializationContext.deserialize(jsonElement7, DeepLink.class) : null);
        if (this.a.getUserAdvertContactsViews().invoke().booleanValue()) {
            JsonElement jsonElement8 = I1.get("contacts");
            if (jsonElement8 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement8, AdvertStatsContact.class);
            }
            advertStatsContact = (AdvertStatsContact) obj;
        }
        return new AdvertStats(valueOf, valueOf2, valueOf3, deepLink, advertStatsContact);
    }
}

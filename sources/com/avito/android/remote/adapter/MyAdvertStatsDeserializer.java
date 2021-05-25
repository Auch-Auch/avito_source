package com.avito.android.remote.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/adapter/MyAdvertStatsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertStatsDeserializer implements JsonDeserializer<MyAdvertDetails.Stats> {
    public final Features a;

    public MyAdvertStatsDeserializer(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public MyAdvertDetails.Stats deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("views");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"views\"]");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, MyAdvertDetails.Stats.Views.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        MyAdvertDetails.Stats.Views views = (MyAdvertDetails.Stats.Views) deserialize;
        JsonElement jsonElement3 = I1.get(FavoritesContract.TABLE_NAME);
        MyAdvertDetails.Stats.Contacts contacts = null;
        Object obj = null;
        MyAdvertDetails.Stats.Favorites favorites = (MyAdvertDetails.Stats.Favorites) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, MyAdvertDetails.Stats.Favorites.class) : null);
        JsonElement jsonElement4 = I1.get(ShareConstants.MEDIA_URI);
        DeepLink deepLink = (DeepLink) (jsonElement4 != null ? jsonDeserializationContext.deserialize(jsonElement4, DeepLink.class) : null);
        if (this.a.getUserAdvertContactsViews().invoke().booleanValue()) {
            JsonElement jsonElement5 = I1.get("contacts");
            if (jsonElement5 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement5, MyAdvertDetails.Stats.Contacts.class);
            }
            contacts = (MyAdvertDetails.Stats.Contacts) obj;
        }
        return new MyAdvertDetails.Stats(views, favorites, deepLink, contacts);
    }
}

package com.avito.android.remote.parse.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.PostAdvertResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/PostAdvertResultDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/PostAdvertResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/PostAdvertResult;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PostAdvertResultDeserializer implements JsonDeserializer<PostAdvertResult> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public PostAdvertResult deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        PostAdvertResult.Messages messages;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("item");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"item\"]");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, PostAdvertResult.PostedAdvert.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        PostAdvertResult.PostedAdvert postedAdvert = (PostAdvertResult.PostedAdvert) deserialize;
        Object obj = null;
        if (asJsonObject.has("messages")) {
            JsonElement jsonElement3 = asJsonObject.get("messages");
            Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject[\"messages\"]");
            Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement3, PostAdvertResult.Messages.class);
            Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
            messages = (PostAdvertResult.Messages) deserialize2;
        } else {
            messages = null;
        }
        JsonElement jsonElement4 = asJsonObject.get("nextStepUri");
        if (jsonElement4 != null) {
            obj = jsonDeserializationContext.deserialize(jsonElement4, DeepLink.class);
        }
        return new PostAdvertResult(postedAdvert, messages, (DeepLink) obj);
    }
}

package com.avito.android.remote.parse.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ChannelMenuActionTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelMenuActionTypeAdapter implements JsonDeserializer<ChannelMenuAction>, JsonSerializer<ChannelMenuAction> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public ChannelMenuAction deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        NoMatchLink noMatchLink;
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Object obj = null;
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("title");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[TITLE]");
            String asString = jsonElement2.getAsString();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
            String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, "icon");
            JsonElement jsonElement3 = asJsonObject.get("confirmation");
            ActionConfirmation actionConfirmation = (ActionConfirmation) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, ActionConfirmation.class) : null);
            String nullableString2 = JsonObjectExtensionsKt.getNullableString(asJsonObject, "deepLink");
            JsonElement jsonElement4 = asJsonObject.get("deepLink");
            if (jsonElement4 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement4, DeepLink.class);
            }
            DeepLink deepLink = (DeepLink) obj;
            if (deepLink != null) {
                noMatchLink = deepLink;
            } else {
                noMatchLink = new NoMatchLink();
            }
            Intrinsics.checkNotNullExpressionValue(asString, "title");
            return new ChannelMenuAction(asString, noMatchLink, nullableString, actionConfirmation, nullableString2);
        }
        throw new IllegalArgumentException("Unexpected json: " + jsonElement);
    }

    @NotNull
    public JsonElement serialize(@Nullable ChannelMenuAction channelMenuAction, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (channelMenuAction != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("title", channelMenuAction.getTitle());
            if (channelMenuAction.getRawDeepLink() != null) {
                jsonObject.addProperty("deepLink", channelMenuAction.getRawDeepLink());
            }
            if (channelMenuAction.getConfirmation() != null) {
                jsonObject.add("confirmation", jsonSerializationContext.serialize(channelMenuAction.getConfirmation()));
            }
            if (channelMenuAction.getIcon() != null) {
                jsonObject.add("icon", jsonSerializationContext.serialize(channelMenuAction.getIcon()));
            }
            return jsonObject;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }
}

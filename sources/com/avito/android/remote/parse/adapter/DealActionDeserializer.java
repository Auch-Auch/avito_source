package com.avito.android.remote.parse.adapter;

import android.net.Uri;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.util.Logs;
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
import ru.avito.messenger.api.entity.context.ChannelDealAction;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/parse/adapter/DealActionDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lru/avito/messenger/api/entity/context/ChannelDealAction;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class DealActionDeserializer implements JsonDeserializer<ChannelDealAction>, JsonSerializer<ChannelDealAction> {
    /* Return type fixed from 'com.avito.android.remote.model.messenger.deal_action.DealAction' to match base method */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ChannelDealAction deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonNull()) {
            return new DealAction.None();
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("value");
            JsonElement jsonElement3 = asJsonObject.get(PlatformActions.PLATFORM_SUPPORT);
            if (jsonElement2 == null || jsonElement2.isJsonNull()) {
                return new DealAction.None();
            }
            if (jsonElement2.isJsonObject()) {
                JsonObject asJsonObject2 = jsonElement2.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject2, "value.asJsonObject");
                try {
                    JsonElement jsonElement4 = asJsonObject2.get("deepLink");
                    Intrinsics.checkNotNullExpressionValue(jsonElement4, "json[\"deepLink\"]");
                    Uri parse = Uri.parse(jsonElement4.getAsString());
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(json[\"deepLink\"].asString)");
                    JsonElement jsonElement5 = asJsonObject2.get("title");
                    Intrinsics.checkNotNullExpressionValue(jsonElement5, "json[\"title\"]");
                    String asString = jsonElement5.getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "json[\"title\"].asString");
                    return new DealAction.Action(asString, parse, (PlatformSupport) jsonDeserializationContext.deserialize(jsonElement3, PlatformSupport.class));
                } catch (Exception unused) {
                    Logs.error$default("DealActionDeserializer", "Failed to parse deal action from json=" + asJsonObject2, null, 4, null);
                    return new DealAction.None();
                }
            } else {
                Logs.error$default("DealActionDeserializer", "Unexpected value: " + jsonElement2, null, 4, null);
                return new DealAction.None();
            }
        } else {
            Logs.error$default("DealActionDeserializer", "Unexpected json: " + jsonElement, null, 4, null);
            return new DealAction.None();
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable ChannelDealAction channelDealAction, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (!(channelDealAction instanceof DealAction.Action)) {
            channelDealAction = null;
        }
        DealAction.Action action = (DealAction.Action) channelDealAction;
        if (action != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(PlatformActions.PLATFORM_SUPPORT, jsonSerializationContext.serialize(action.getPlatformSupport(), PlatformSupport.class));
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("title", jsonSerializationContext.serialize(action.getTitle()));
            jsonObject2.add("deepLink", jsonSerializationContext.serialize(action.getUri().toString()));
            jsonObject.add("value", jsonObject2);
            return jsonObject;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }
}

package com.avito.android.remote.parse.adapter.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.ContextAction;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.messenger.context_actions.ItemsRequest;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.avito.android.util.Logs;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/ContextActionsTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lru/avito/messenger/api/entity/context/ChannelContextActions;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lru/avito/messenger/api/entity/context/ChannelContextActions;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonElement;)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "data", AuthSource.BOOKING_ORDER, "(Lcom/google/gson/JsonSerializationContext;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;)Lcom/google/gson/JsonElement;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ContextActionsTypeAdapter implements JsonDeserializer<ChannelContextActions>, JsonSerializer<ChannelContextActions> {
    public final PlatformActions.ExpandableData a(JsonDeserializationContext jsonDeserializationContext, JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObj");
            String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, PlatformActions.ExpandableData.TITLE_SHORT);
            JsonElement jsonElement2 = asJsonObject.get(PlatformActions.ExpandableData.CANCEL_ACTION);
            Type type = new TypeToken<ContextActionHandler.MethodCall>() { // from class: com.avito.android.remote.parse.adapter.messenger.ContextActionsTypeAdapter$deserializeExpandableData$$inlined$gsonTypeToken$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
            return new PlatformActions.ExpandableData(nullableString, (ContextActionHandler.MethodCall) jsonDeserializationContext.deserialize(jsonElement2, type));
        }
        throw new IllegalArgumentException("Expected null or object, but got: " + jsonElement);
    }

    public final JsonElement b(JsonSerializationContext jsonSerializationContext, PlatformActions.ExpandableData expandableData) {
        if (expandableData != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(PlatformActions.ExpandableData.TITLE_SHORT, expandableData.getTitleShort());
            jsonObject.add(PlatformActions.ExpandableData.CANCEL_ACTION, jsonSerializationContext.serialize(expandableData.getCancelHandler()));
            return jsonObject;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }

    /* Return type fixed from 'com.avito.android.remote.model.messenger.context_actions.PlatformActions' to match base method */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ChannelContextActions deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        PlatformActions.None none;
        ChannelContextActions actions;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonNull()) {
            return new PlatformActions.None(null);
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
            String nullableString = JsonObjectExtensionsKt.getNullableString(asJsonObject, "type");
            JsonElement jsonElement2 = asJsonObject.get("value");
            String nullableString2 = JsonObjectExtensionsKt.getNullableString(asJsonObject, "messageId");
            JsonElement jsonElement3 = asJsonObject.get(PlatformActions.PLATFORM_SUPPORT);
            Long nullableLong = JsonObjectExtensionsKt.getNullableLong(asJsonObject, "version");
            if (jsonElement2 == null || jsonElement2.isJsonNull()) {
                none = new PlatformActions.None(nullableLong);
            } else if (jsonElement2.isJsonObject()) {
                JsonObject asJsonObject2 = jsonElement2.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject2, "value.asJsonObject");
                Boolean nullableBoolean = JsonObjectExtensionsKt.getNullableBoolean(asJsonObject2, PlatformActions.HIDE_KEYBOARD);
                boolean booleanValue = nullableBoolean != null ? nullableBoolean.booleanValue() : false;
                if (nullableString != null && nullableString.hashCode() == -2123879298 && nullableString.equals(PlatformActions.ItemsList.TYPE)) {
                    JsonObject asJsonObject3 = jsonElement2.getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(asJsonObject3, "value.asJsonObject");
                    try {
                        PlatformActions.ExpandableData a = a(jsonDeserializationContext, asJsonObject3.get(PlatformActions.EXPANDABLE));
                        if (a == null) {
                            none = new PlatformActions.None(nullableLong);
                        } else {
                            JsonElement jsonElement4 = asJsonObject3.get("title");
                            Intrinsics.checkNotNullExpressionValue(jsonElement4, "json[PlatformActions.TITLE]");
                            String asString = jsonElement4.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString, "json[PlatformActions.TITLE].asString");
                            Object deserialize = jsonDeserializationContext.deserialize(asJsonObject3.get(PlatformActions.ItemsList.ITEMS_REQUEST), ItemsRequest.class);
                            Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(\n   …ava\n                    )");
                            actions = new PlatformActions.ItemsList(asString, (ItemsRequest) deserialize, nullableString2, (PlatformSupport) jsonDeserializationContext.deserialize(jsonElement3, PlatformSupport.class), nullableLong, a, booleanValue);
                        }
                    } catch (Exception unused) {
                        Logs.error$default("ContextActionsTypeAdapter", "Failed to parse items list from json=" + asJsonObject3, null, 4, null);
                        none = new PlatformActions.None(nullableLong);
                    }
                } else {
                    JsonObject asJsonObject4 = jsonElement2.getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(asJsonObject4, "value.asJsonObject");
                    try {
                        String nullableString3 = JsonObjectExtensionsKt.getNullableString(asJsonObject4, "title");
                        JsonElement jsonElement5 = asJsonObject4.get("actions");
                        Type type2 = new TypeToken<List<? extends ContextAction>>() { // from class: com.avito.android.remote.parse.adapter.messenger.ContextActionsTypeAdapter$parseContextActions$$inlined$gsonTypeToken$1
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                        Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement5, type2);
                        Intrinsics.checkNotNullExpressionValue(deserialize2, "context.deserialize(\n   …ion>>()\n                )");
                        actions = new PlatformActions.Actions(nullableString3, (List) deserialize2, nullableString2, (PlatformSupport) jsonDeserializationContext.deserialize(jsonElement3, PlatformSupport.class), nullableLong, a(jsonDeserializationContext, asJsonObject4.get(PlatformActions.EXPANDABLE)), booleanValue);
                    } catch (Exception unused2) {
                        Logs.error$default("ContextActionsTypeAdapter", "Failed to parse context actions from json=" + asJsonObject4, null, 4, null);
                        none = new PlatformActions.None(nullableLong);
                    }
                }
                return actions;
            } else {
                Logs.error$default("ContextActionsTypeAdapter", "Unexpected value: " + jsonElement2, null, 4, null);
                none = new PlatformActions.None(nullableLong);
            }
            return none;
        }
        Logs.error$default("ContextActionsTypeAdapter", "Unexpected json: " + jsonElement, null, 4, null);
        return new PlatformActions.None(null);
    }

    @NotNull
    public JsonElement serialize(@Nullable ChannelContextActions channelContextActions, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (channelContextActions instanceof PlatformActions.Actions) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("messageId", channelContextActions.getMessageId());
            jsonObject.add(PlatformActions.PLATFORM_SUPPORT, jsonSerializationContext.serialize(channelContextActions.getPlatformSupport(), PlatformSupport.class));
            jsonObject.addProperty("version", channelContextActions.getVersion());
            JsonObject jsonObject2 = new JsonObject();
            PlatformActions.Actions actions = (PlatformActions.Actions) channelContextActions;
            jsonObject2.add("title", jsonSerializationContext.serialize(actions.getTitle()));
            List<ContextAction> actions2 = actions.getActions();
            Type type2 = new TypeToken<List<? extends ContextAction>>() { // from class: com.avito.android.remote.parse.adapter.messenger.ContextActionsTypeAdapter$$special$$inlined$gsonTypeToken$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
            jsonObject2.add("actions", jsonSerializationContext.serialize(actions2, type2));
            jsonObject2.add(PlatformActions.EXPANDABLE, b(jsonSerializationContext, actions.getExpandableData()));
            jsonObject2.add(PlatformActions.HIDE_KEYBOARD, jsonSerializationContext.serialize(Boolean.valueOf(actions.getHideKeyboard())));
            jsonObject.add("value", jsonObject2);
            return jsonObject;
        } else if (channelContextActions instanceof PlatformActions.ItemsList) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("messageId", channelContextActions.getMessageId());
            jsonObject3.addProperty("type", PlatformActions.ItemsList.TYPE);
            jsonObject3.addProperty("version", channelContextActions.getVersion());
            jsonObject3.add(PlatformActions.PLATFORM_SUPPORT, jsonSerializationContext.serialize(channelContextActions.getPlatformSupport(), PlatformSupport.class));
            JsonObject jsonObject4 = new JsonObject();
            PlatformActions.ItemsList itemsList = (PlatformActions.ItemsList) channelContextActions;
            jsonObject4.add("title", jsonSerializationContext.serialize(itemsList.getTitle()));
            jsonObject4.add(PlatformActions.ItemsList.ITEMS_REQUEST, jsonSerializationContext.serialize(itemsList.getItemsRequest(), ItemsRequest.class));
            jsonObject4.add(PlatformActions.EXPANDABLE, b(jsonSerializationContext, itemsList.getExpandableData()));
            jsonObject4.add(PlatformActions.HIDE_KEYBOARD, jsonSerializationContext.serialize(Boolean.valueOf(itemsList.getHideKeyboard())));
            jsonObject3.add("value", jsonObject4);
            return jsonObject3;
        } else if (channelContextActions instanceof PlatformActions.None) {
            JsonObject jsonObject5 = new JsonObject();
            jsonObject5.addProperty("messageId", channelContextActions.getMessageId());
            jsonObject5.add(PlatformActions.PLATFORM_SUPPORT, jsonSerializationContext.serialize(channelContextActions.getPlatformSupport(), PlatformSupport.class));
            jsonObject5.addProperty("version", channelContextActions.getVersion());
            return jsonObject5;
        } else {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
    }
}

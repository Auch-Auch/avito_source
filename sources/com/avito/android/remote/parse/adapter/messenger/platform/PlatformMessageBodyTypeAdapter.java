package com.avito.android.remote.parse.adapter.messenger.platform;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform;
import com.avito.android.remote.model.text.AttributedText;
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
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import t6.n.d;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u000f\u0012\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J)\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u001b\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/platform/PlatformMessageBodyTypeAdapter;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", "T", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", MessageBody.SystemMessageBody.Platform.CHUNKS, "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, "", "flow", "fallbackText", "createBody", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public abstract class PlatformMessageBodyTypeAdapter<T extends MessageBody.SystemMessageBody.Platform> implements JsonDeserializer<MessageBody.SystemMessageBody>, JsonSerializer<T> {
    public final String a;

    public PlatformMessageBodyTypeAdapter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.a = str;
    }

    public static /* synthetic */ MessageBody.SystemMessageBody.Platform createBody$default(PlatformMessageBodyTypeAdapter platformMessageBodyTypeAdapter, List list, PlatformActions platformActions, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                platformActions = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return platformMessageBodyTypeAdapter.createBody(list, platformActions, str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBody");
    }

    public final MessageBody.SystemMessageBody a(String str) {
        if (str == null || m.isBlank(str)) {
            return new MessageBody.SystemMessageBody.Unknown();
        }
        return createBody$default(this, d.listOf(new MessageBody.SystemMessageBody.Platform.Bubble.Text(new AttributedText(str != null ? str : "", CollectionsKt__CollectionsKt.emptyList()))), null, null, str, 6, null);
    }

    @NotNull
    public abstract T createBody(@NotNull List<? extends MessageBody.SystemMessageBody.Platform.Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBodyTypeAdapter<T extends com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return serialize((PlatformMessageBodyTypeAdapter<T>) ((MessageBody.SystemMessageBody.Platform) obj), type, jsonSerializationContext);
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public MessageBody.SystemMessageBody deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        List<String> platforms;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("text");
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        JsonElement jsonElement3 = asJsonObject.get(MessageBody.SystemMessageBody.Platform.CHUNKS);
        JsonElement jsonElement4 = asJsonObject.get(MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS);
        try {
            Type type2 = new TypeToken<List<? extends MessageBody.SystemMessageBody.Platform.Bubble>>() { // from class: com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBodyTypeAdapter$deserialize$$inlined$gsonTypeToken$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
            Object deserialize = jsonDeserializationContext.deserialize(jsonElement3, type2);
            Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(chun…List<Platform.Bubble>>())");
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "jsonObject");
            T createBody = createBody((List) deserialize, (PlatformActions) jsonDeserializationContext.deserialize(jsonElement4, ChannelContextActions.class), JsonObjectExtensionsKt.getNullableString(asJsonObject, "flow"), asString);
            PlatformActions contextActions = createBody.getContextActions();
            if (contextActions == null) {
                return createBody;
            }
            PlatformSupport platformSupport = contextActions.getPlatformSupport();
            if ((platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) ? true : platforms.contains("android")) {
                return createBody;
            }
            return a(asString);
        } catch (Exception e) {
            String str = this.a;
            Logs.error(str, "Failed to deserialize system platform message body: " + jsonElement, e);
            return a(asString);
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable T t, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (t == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks = t.getChunks();
        Type type2 = new TypeToken<List<? extends MessageBody.SystemMessageBody.Platform.Bubble>>() { // from class: com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBodyTypeAdapter$$special$$inlined$gsonTypeToken$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
        jsonObject.add(MessageBody.SystemMessageBody.Platform.CHUNKS, jsonSerializationContext.serialize(chunks, type2));
        PlatformActions contextActions = t.getContextActions();
        if (contextActions != null) {
            jsonObject.add(MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, jsonSerializationContext.serialize(contextActions, ChannelContextActions.class));
        }
        String flow = t.getFlow();
        if (flow != null) {
            jsonObject.add("flow", jsonSerializationContext.serialize(flow));
        }
        String fallbackText = t.getFallbackText();
        if (fallbackText != null) {
            jsonObject.add("text", jsonSerializationContext.serialize(fallbackText));
        }
        return jsonObject;
    }
}

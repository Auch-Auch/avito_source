package com.avito.android.remote.parse.adapter.messenger.platform;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/platform/PlatformMessageBubbleTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMessageBubbleTypeAdapter implements JsonDeserializer<MessageBody.SystemMessageBody.Platform.Bubble>, JsonSerializer<MessageBody.SystemMessageBody.Platform.Bubble> {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        if (r7 == null) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform.Bubble deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r6, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r7, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r8) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBubbleTypeAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$Bubble");
    }

    @NotNull
    public JsonElement serialize(@Nullable MessageBody.SystemMessageBody.Platform.Bubble bubble, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (bubble == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text) {
            jsonObject.addProperty("type", "text");
            jsonObject.add("value", jsonSerializationContext.serialize(((MessageBody.SystemMessageBody.Platform.Bubble.Text) bubble).getText(), AttributedText.class));
        } else if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image) {
            jsonObject.addProperty("type", "image");
            jsonObject.add("value", jsonSerializationContext.serialize(bubble));
        } else if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) {
            jsonObject.addProperty("type", MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation.TYPE);
            jsonObject.add("value", jsonSerializationContext.serialize(bubble));
        } else if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item) {
            jsonObject.addProperty("type", "item");
            jsonObject.add("value", jsonSerializationContext.serialize(bubble));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return jsonObject;
    }
}

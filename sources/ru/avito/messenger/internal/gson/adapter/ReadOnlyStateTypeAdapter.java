package ru.avito.messenger.internal.gson.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ReadOnlyState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/ReadOnlyStateTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lru/avito/messenger/api/entity/ReadOnlyState;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lru/avito/messenger/api/entity/ReadOnlyState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ReadOnlyStateTypeAdapter implements JsonDeserializer<ReadOnlyState> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public ReadOnlyState deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        String str = null;
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        if (jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("reason");
            Intrinsics.checkNotNullExpressionValue(jsonElement2, "json.asJsonObject[\"reason\"]");
            String asString = jsonElement2.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "json.asJsonObject[\"reason\"].asString");
            JsonElement jsonElement3 = jsonElement.getAsJsonObject().get("description");
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
            }
            return new ReadOnlyState(asString, str);
        } else if (!jsonElement.isJsonPrimitive()) {
            throw new IllegalStateException(("Unsupported readOnly value: " + jsonElement + ", but false or object expected").toString());
        } else if (!jsonElement.getAsBoolean()) {
            return null;
        } else {
            throw new IllegalStateException(("Unexpected readOnly value: " + jsonElement + ", but object expected").toString());
        }
    }
}

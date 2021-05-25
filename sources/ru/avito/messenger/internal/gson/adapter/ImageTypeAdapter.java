package ru.avito.messenger.internal.gson.adapter;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.collection.ArrayMap;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.Image;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/ImageTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lru/avito/messenger/api/entity/Image;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lru/avito/messenger/api/entity/Image;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ImageTypeAdapter implements JsonDeserializer<Image> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public Image deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        ArrayMap arrayMap = new ArrayMap(I1.entrySet().size());
        for (Map.Entry<String, JsonElement> entry : I1.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "value");
            Uri parse = Uri.parse(value.getAsString());
            Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
            String scheme = parse.getScheme();
            if (scheme == null || scheme.length() == 0) {
                parse = parse.buildUpon().scheme("https").build();
            }
            arrayMap.put(key, parse);
        }
        return new Image(arrayMap);
    }
}

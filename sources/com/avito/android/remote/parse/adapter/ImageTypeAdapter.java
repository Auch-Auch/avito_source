package com.avito.android.remote.parse.adapter;

import android.net.Uri;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.util.JsonNullParsingException;
import com.avito.android.util.StringUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ImageTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/Image;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/Image;", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/Image;)V", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ImageTypeAdapter extends TypeAdapter<Image> {
    @Override // com.google.gson.TypeAdapter
    @Nullable
    public Image read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jsonReader.peek() != JsonToken.NULL) {
                JsonToken peek = jsonReader.peek();
                JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
                if (peek == jsonToken) {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        Intrinsics.checkNotNullExpressionValue(nextName, "nextName()");
                        Size parseSizeEfficently = StringUtils.parseSizeEfficently(nextName);
                        Uri parse = Uri.parse(jsonReader.nextString());
                        if (parseSizeEfficently != null) {
                            Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
                            linkedHashMap.put(parseSizeEfficently, parse);
                        }
                    }
                    jsonReader.endObject();
                    return new Image(linkedHashMap);
                }
                throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonReader.peek() + " at " + jsonReader);
            }
            throw new JsonNullParsingException();
        } catch (JsonNullParsingException unused) {
            jsonReader.skipValue();
            return null;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0033: INVOKE  (r3v0 int) = (r1v1 com.avito.android.remote.model.Size) type: VIRTUAL call: com.avito.android.remote.model.Size.getWidth():int), (wrap: char : ?: SGET   com.vk.sdk.api.model.VKApiPhotoSize.X char), (wrap: int : 0x003f: INVOKE  (r1v2 int) = (r1v1 com.avito.android.remote.model.Size) type: VIRTUAL call: com.avito.android.remote.model.Size.getHeight():int)] */
    public void write(@NotNull JsonWriter jsonWriter, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (image != null) {
            jsonWriter.beginObject();
            for (Map.Entry<Size, Uri> entry : image.getVariants().entrySet()) {
                Size key = entry.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append(key.getWidth());
                sb.append(VKApiPhotoSize.X);
                sb.append(key.getHeight());
                jsonWriter.name(sb.toString());
                jsonWriter.value(entry.getValue().toString());
            }
            jsonWriter.endObject();
            return;
        }
        jsonWriter.nullValue();
    }
}

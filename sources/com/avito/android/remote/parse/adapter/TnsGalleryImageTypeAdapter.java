package com.avito.android.remote.parse.adapter;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.util.JsonNullParsingException;
import com.avito.android.util.StringUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/TnsGalleryImageTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/TnsGalleryImage;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/TnsGalleryImage;", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/TnsGalleryImage;)V", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryImageTypeAdapter extends TypeAdapter<TnsGalleryImage> {
    public final Gson a;

    public TnsGalleryImageTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public TnsGalleryImage read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jsonReader.peek() != JsonToken.NULL) {
                JsonToken peek = jsonReader.peek();
                JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
                if (peek == jsonToken) {
                    jsonReader.beginObject();
                    Size size = null;
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        if (Intrinsics.areEqual(nextName, "originalSize")) {
                            size = (Size) this.a.getAdapter(Size.class).read(jsonReader);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(nextName, "name");
                            Size parseSizeEfficently = StringUtils.parseSizeEfficently(nextName);
                            Uri parse = Uri.parse(jsonReader.nextString());
                            if (parseSizeEfficently != null) {
                                Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
                                Uri uri = (Uri) linkedHashMap.put(parseSizeEfficently, parse);
                            }
                        }
                    }
                    jsonReader.endObject();
                    return new TnsGalleryImage(new Image(linkedHashMap), size);
                }
                throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonReader.peek() + " at " + jsonReader);
            }
            throw new JsonNullParsingException();
        } catch (JsonNullParsingException unused) {
            jsonReader.skipValue();
            return null;
        }
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable TnsGalleryImage tnsGalleryImage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        throw new UnsupportedOperationException();
    }
}

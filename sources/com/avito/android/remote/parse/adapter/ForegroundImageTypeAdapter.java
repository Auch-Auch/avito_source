package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0001\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ForegroundImageTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/ForegroundImage;", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/ForegroundImage;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/ForegroundImage;", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.SEND_ABUSE, "Lcom/google/gson/TypeAdapter;", "textAdapter", "Lcom/avito/android/remote/model/UniversalColor;", AuthSource.BOOKING_ORDER, "colorAdapter", "Lcom/avito/android/remote/model/Image;", "c", "imageTypeAdapter", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundImageTypeAdapter extends TypeAdapter<ForegroundImage> {
    public final TypeAdapter<AttributedText> a;
    public final TypeAdapter<UniversalColor> b;
    public final TypeAdapter<Image> c;
    public final Features d;

    public ForegroundImageTypeAdapter(@NotNull TypeAdapter<AttributedText> typeAdapter, @NotNull TypeAdapter<UniversalColor> typeAdapter2, @NotNull TypeAdapter<Image> typeAdapter3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(typeAdapter, "textAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter2, "colorAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter3, "imageTypeAdapter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = typeAdapter;
        this.b = typeAdapter2;
        this.c = typeAdapter3;
        this.d = features;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public ForegroundImage read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (!this.d.getBadSellers().invoke().booleanValue()) {
            jsonReader.skipValue();
            return null;
        } else if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                AttributedText attributedText = null;
                UniversalColor universalColor = null;
                Image image = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != 71847867) {
                            if (hashCode != 100313435) {
                                if (hashCode == 110371416 && nextName.equals("title")) {
                                    attributedText = this.a.read(jsonReader);
                                }
                            } else if (nextName.equals("image")) {
                                image = this.c.read(jsonReader);
                            }
                        } else if (nextName.equals("dimColor")) {
                            universalColor = this.b.read(jsonReader);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (attributedText == null || universalColor == null) {
                    return null;
                }
                Intrinsics.checkNotNull(attributedText);
                Intrinsics.checkNotNull(universalColor);
                return new ForegroundImage(attributedText, universalColor, image);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        } else {
            throw new JsonNullParsingException();
        }
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable ForegroundImage foregroundImage) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (!this.d.getBadSellers().invoke().booleanValue() || foregroundImage == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("title");
        jsonWriter.value(this.a.toJson(foregroundImage.getTitle()));
        jsonWriter.name("dimColor");
        jsonWriter.value(this.b.toJson(foregroundImage.getDimColor()));
        jsonWriter.name("image");
        jsonWriter.value(this.c.toJson(foregroundImage.getImage()));
        jsonWriter.endObject();
    }
}

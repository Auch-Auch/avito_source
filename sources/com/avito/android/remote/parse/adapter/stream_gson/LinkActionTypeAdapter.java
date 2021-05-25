package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.util.JsonNullParsingException;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/LinkActionTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/LinkAction;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/LinkAction;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/LinkAction;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkActionTypeAdapter extends TypeAdapter<LinkAction> {
    @Override // com.google.gson.TypeAdapter
    @Nullable
    public LinkAction read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                String str = null;
                String str2 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != 116076) {
                            if (hashCode == 110371416 && nextName.equals("title")) {
                                str = jsonReader.nextString();
                            }
                        } else if (nextName.equals(ShareConstants.MEDIA_URI)) {
                            str2 = jsonReader.nextString();
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (str == null || str2 == null) {
                    return null;
                }
                Uri parse = Uri.parse(str2);
                Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(uri)");
                return new LinkAction(str, parse);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable LinkAction linkAction) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        throw new UnsupportedOperationException();
    }
}

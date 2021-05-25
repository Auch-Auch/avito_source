package com.avito.android.remote.parse.adapter.stream_gson;

import com.avito.android.remote.model.search.suggest.LocalIcon;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/SuggestLocalIconTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/search/suggest/LocalIcon;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/search/suggest/LocalIcon;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/search/suggest/LocalIcon;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocalIconTypeAdapter extends TypeAdapter<LocalIcon> {
    @Override // com.google.gson.TypeAdapter
    @Nullable
    public LocalIcon read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String nextString = jsonReader.nextString();
        if (nextString == null) {
            return null;
        }
        return new LocalIcon(nextString);
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable LocalIcon localIcon) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        throw new UnsupportedOperationException();
    }
}

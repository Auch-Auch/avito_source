package com.avito.android.remote.parse.adapter.inline_filters;

import com.avito.android.remote.model.search.InlineFilterValue;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterSelectValueTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;)Ljava/lang/Void;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterSelectValueTypeAdapter extends TypeAdapter<InlineFilterValue.InlineFilterSelectValue> {
    @Override // com.google.gson.TypeAdapter
    @NotNull
    public InlineFilterValue.InlineFilterSelectValue read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        return new InlineFilterValue.InlineFilterSelectValue(jsonReader.nextString());
    }

    @NotNull
    public Void write(@NotNull JsonWriter jsonWriter, @NotNull InlineFilterValue.InlineFilterSelectValue inlineFilterSelectValue) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(inlineFilterSelectValue, "value");
        throw new UnsupportedOperationException();
    }
}

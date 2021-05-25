package com.avito.android.remote.parse.adapter.inline_filters;

import a2.b.a.a.a;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/inline_filters/InlineFilterMultiSelectValueTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;)Ljava/lang/Void;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterMultiSelectValueTypeAdapter extends TypeAdapter<InlineFilterValue.InlineFilterMultiSelectValue> {
    @Override // com.google.gson.TypeAdapter
    @NotNull
    public InlineFilterValue.InlineFilterMultiSelectValue read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        ArrayList arrayList = new ArrayList();
        JsonToken peek = jsonReader.peek();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        if (peek == jsonToken) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                String nextString = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                arrayList.add(nextString);
            }
            jsonReader.endArray();
            return new InlineFilterValue.InlineFilterMultiSelectValue(arrayList);
        }
        throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
    }

    @NotNull
    public Void write(@NotNull JsonWriter jsonWriter, @NotNull InlineFilterValue.InlineFilterMultiSelectValue inlineFilterMultiSelectValue) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(inlineFilterMultiSelectValue, "value");
        throw new UnsupportedOperationException();
    }
}

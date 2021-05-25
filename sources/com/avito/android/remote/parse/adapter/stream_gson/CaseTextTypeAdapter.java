package com.avito.android.remote.parse.adapter.stream_gson;

import android.util.SparseArray;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/CaseTextTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/CaseText;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/CaseText;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/CaseText;", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "gson", "com/avito/android/remote/parse/adapter/stream_gson/CaseTextTypeAdapter$typeToken$1", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/parse/adapter/stream_gson/CaseTextTypeAdapter$typeToken$1;", "typeToken", "<init>", "(Lcom/google/gson/Gson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CaseTextTypeAdapter extends TypeAdapter<CaseText> {
    public final CaseTextTypeAdapter$typeToken$1 a = new CaseTextTypeAdapter$typeToken$1();
    public final Gson b;

    public CaseTextTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.b = gson;
    }

    @Override // com.google.gson.TypeAdapter
    @NotNull
    public CaseText read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Map map = (Map) this.b.getAdapter(this.a).read(jsonReader);
        SparseArray sparseArray = new SparseArray(map.size());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.append(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        return new CaseText(sparseArray);
    }

    public void write(@Nullable JsonWriter jsonWriter, @Nullable CaseText caseText) {
        throw new UnsupportedOperationException();
    }
}

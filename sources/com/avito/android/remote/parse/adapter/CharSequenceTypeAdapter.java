package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/CharSequenceTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/CharSequence;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/CharSequence;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CharSequenceTypeAdapter extends TypeAdapter<CharSequence> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[8] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public CharSequence read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        JsonToken peek = jsonReader.peek();
        if (peek != null) {
            int ordinal = peek.ordinal();
            if (ordinal == 5) {
                return jsonReader.nextString();
            }
            if (ordinal == 8) {
                return null;
            }
        }
        StringBuilder L = a.L("Unexpected token: ");
        L.append(jsonReader.peek());
        throw new IllegalStateException(L.toString());
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        jsonWriter.value(charSequence != null ? charSequence.toString() : null);
    }
}

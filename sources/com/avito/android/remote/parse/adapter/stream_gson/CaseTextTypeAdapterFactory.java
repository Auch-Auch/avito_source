package com.avito.android.remote.parse.adapter.stream_gson;

import com.avito.android.remote.model.CaseText;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/CaseTextTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "T", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CaseTextTypeAdapterFactory implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (Intrinsics.areEqual(typeToken.getRawType(), CaseText.class)) {
            return new CaseTextTypeAdapter(gson);
        }
        return null;
    }
}

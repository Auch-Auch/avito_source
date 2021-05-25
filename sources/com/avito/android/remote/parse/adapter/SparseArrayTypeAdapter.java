package com.avito.android.remote.parse.adapter;

import android.util.SparseArray;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SparseArrayTypeAdapter;", "T", "Lcom/google/gson/JsonDeserializer;", "Landroid/util/SparseArray;", "Lcom/google/gson/JsonSerializer;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Landroid/util/SparseArray;", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "serialize", "(Landroid/util/SparseArray;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "type", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SparseArrayTypeAdapter<T> implements JsonDeserializer<SparseArray<T>>, JsonSerializer<SparseArray<T>> {
    public final Type a = new TypeToken<Map<Integer, ? extends T>>() { // from class: com.avito.android.remote.parse.adapter.SparseArrayTypeAdapter$type$1
    }.getType();

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return serialize((SparseArray) ((SparseArray) obj), type, jsonSerializationContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: android.util.SparseArray<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public SparseArray<T> deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Map map = (Map) jsonDeserializationContext.deserialize(jsonElement, this.a);
        SparseArray<T> sparseArray = (SparseArray<T>) new SparseArray(map.size());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.append(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        return sparseArray;
    }

    @NotNull
    public JsonElement serialize(@Nullable SparseArray<T> sparseArray, @Nullable Type type, @Nullable JsonSerializationContext jsonSerializationContext) {
        JsonElement serialize;
        if (sparseArray != null) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                linkedTreeMap.put(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
            }
            if (!(jsonSerializationContext == null || (serialize = jsonSerializationContext.serialize(linkedTreeMap, this.a)) == null)) {
                return serialize;
            }
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonNull jsonNull2 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull2, "JsonNull.INSTANCE");
        return jsonNull2;
    }
}

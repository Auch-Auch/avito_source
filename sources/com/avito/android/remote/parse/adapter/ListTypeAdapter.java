package com.avito.android.remote.parse.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ListTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "", "", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/util/List;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ListTypeAdapter implements JsonDeserializer<List<? extends Object>> {
    /* Return type fixed from 'java.util.List<java.lang.Object>' to match base method */
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public List<? extends Object> deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Type type2;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonArray()) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else if (type instanceof WildcardType) {
                return deserialize(jsonElement, ((WildcardType) type).getUpperBounds()[0], jsonDeserializationContext);
            } else {
                type2 = null;
            }
            if (type2 != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    Object deserialize = jsonDeserializationContext.deserialize(it.next(), type2);
                    if (deserialize != null) {
                        arrayList.add(deserialize);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }
}

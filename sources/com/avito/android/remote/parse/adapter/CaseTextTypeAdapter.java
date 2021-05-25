package com.avito.android.remote.parse.adapter;

import android.util.SparseArray;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/CaseTextTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/CaseText;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/CaseText;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "type", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CaseTextTypeAdapter implements JsonDeserializer<CaseText> {
    public final Type a = new TypeToken<Map<Integer, ? extends String>>() { // from class: com.avito.android.remote.parse.adapter.CaseTextTypeAdapter$type$1
    }.getType();

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public CaseText deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Map map = (Map) jsonDeserializationContext.deserialize(jsonElement, this.a);
        SparseArray sparseArray = new SparseArray(map.size());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.append(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        return new CaseText(sparseArray);
    }
}

package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B/\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "T", "Lcom/google/gson/JsonDeserializer;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "Ljava/lang/Class;", "fallbackObjectType", "Ljava/lang/Class;", "", "", "getMapping", "()Ljava/util/Map;", "mapping", "typeKey", "Ljava/lang/String;", "valueKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class RuntimeTypeAdapter<T> implements JsonDeserializer<T> {
    private final Class<? extends T> fallbackObjectType;
    private final String typeKey;
    private final String valueKey;

    public RuntimeTypeAdapter() {
        this(null, null, null, 7, null);
    }

    public RuntimeTypeAdapter(@NotNull String str, @NotNull String str2, @Nullable Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(str, "typeKey");
        Intrinsics.checkNotNullParameter(str2, "valueKey");
        this.typeKey = str;
        this.valueKey = str2;
        this.fallbackObjectType = cls;
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public T deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement3 = I1.get(this.typeKey);
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        Type type2 = getMapping().get(asString);
        if (type2 == null) {
            type2 = this.fallbackObjectType;
        }
        if (type2 == null || (jsonElement2 = I1.get(this.valueKey)) == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) {
            return null;
        }
        return (T) jsonDeserializationContext.deserialize(asJsonObject, type2);
    }

    @NotNull
    public abstract Map<String, Type> getMapping();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RuntimeTypeAdapter(String str, String str2, Class cls, int i, j jVar) {
        this((i & 1) != 0 ? "type" : str, (i & 2) != 0 ? "value" : str2, (i & 4) != 0 ? null : cls);
    }
}

package com.avito.android.util;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\b¢\u0006\u0004\b\u0006\u0010\t\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\b¢\u0006\u0004\b\u0006\u0010\u000b\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0002*\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "T", "", "Lcom/avito/android/util/TypeAdapterEntry;", "Lcom/google/gson/TypeAdapter;", "adapter", "registerTypeAdapter", "(Ljava/util/Set;Lcom/google/gson/TypeAdapter;)Ljava/util/Set;", "Lcom/google/gson/JsonDeserializer;", "(Ljava/util/Set;Lcom/google/gson/JsonDeserializer;)Ljava/util/Set;", "Lcom/google/gson/JsonSerializer;", "(Ljava/util/Set;Lcom/google/gson/JsonSerializer;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "Ljava/lang/reflect/Type;", "type", "", "", "statuses", "registerCustomType", "(Ljava/util/Set;Ljava/lang/reflect/Type;Ljava/util/Map;)Ljava/util/Set;", "gson"}, k = 2, mv = {1, 4, 2})
public final class GsonSetsKt {
    @NotNull
    public static final Set<CustomTypeAdapterEntry> registerCustomType(@NotNull Set<CustomTypeAdapterEntry> set, @NotNull Type type, @NotNull Map<String, ? extends Type> map) {
        Intrinsics.checkNotNullParameter(set, "$this$registerCustomType");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(map, "statuses");
        set.add(new CustomTypeAdapterEntry(type, map));
        return set;
    }

    public static final /* synthetic */ <T> Set<TypeAdapterEntry> registerTypeAdapter(Set<TypeAdapterEntry> set, TypeAdapter<T> typeAdapter) {
        Intrinsics.checkNotNullParameter(set, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        set.add(new TypeAdapterEntry(Object.class, typeAdapter));
        return set;
    }

    public static final /* synthetic */ <T> Set<TypeAdapterEntry> registerTypeAdapter(Set<TypeAdapterEntry> set, JsonDeserializer<T> jsonDeserializer) {
        Intrinsics.checkNotNullParameter(set, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(jsonDeserializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        set.add(new TypeAdapterEntry(Object.class, jsonDeserializer));
        return set;
    }

    public static final /* synthetic */ <T> Set<TypeAdapterEntry> registerTypeAdapter(Set<TypeAdapterEntry> set, JsonSerializer<T> jsonSerializer) {
        Intrinsics.checkNotNullParameter(set, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(jsonSerializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        set.add(new TypeAdapterEntry(Object.class, jsonSerializer));
        return set;
    }
}

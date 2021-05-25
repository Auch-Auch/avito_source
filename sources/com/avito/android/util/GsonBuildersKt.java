package com.avito.android.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a.\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\b¢\u0006\u0004\b\u0005\u0010\b\u001a.\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\b¢\u0006\u0004\b\t\u0010\b\u001a.\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\b¢\u0006\u0004\b\t\u0010\u000b\u001a.\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\b¢\u0006\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"", "T", "Lcom/google/gson/GsonBuilder;", "Lcom/google/gson/TypeAdapter;", "adapter", "registerTypeAdapter", "(Lcom/google/gson/GsonBuilder;Lcom/google/gson/TypeAdapter;)Lcom/google/gson/GsonBuilder;", "Lcom/google/gson/JsonDeserializer;", "(Lcom/google/gson/GsonBuilder;Lcom/google/gson/JsonDeserializer;)Lcom/google/gson/GsonBuilder;", "registerTypeHierarchyAdapter", "Lcom/google/gson/JsonSerializer;", "(Lcom/google/gson/GsonBuilder;Lcom/google/gson/JsonSerializer;)Lcom/google/gson/GsonBuilder;", "gson"}, k = 2, mv = {1, 4, 2})
public final class GsonBuildersKt {
    public static final /* synthetic */ <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, TypeAdapter<T> typeAdapter) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeAdapter(Object.class, typeAdapter);
        return gsonBuilder;
    }

    public static final /* synthetic */ <T> GsonBuilder registerTypeHierarchyAdapter(GsonBuilder gsonBuilder, JsonDeserializer<T> jsonDeserializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeHierarchyAdapter");
        Intrinsics.checkNotNullParameter(jsonDeserializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeHierarchyAdapter(Object.class, jsonDeserializer);
        return gsonBuilder;
    }

    public static final /* synthetic */ <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, JsonDeserializer<T> jsonDeserializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(jsonDeserializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeAdapter(Object.class, jsonDeserializer);
        return gsonBuilder;
    }

    public static final /* synthetic */ <T> GsonBuilder registerTypeHierarchyAdapter(GsonBuilder gsonBuilder, JsonSerializer<T> jsonSerializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeHierarchyAdapter");
        Intrinsics.checkNotNullParameter(jsonSerializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeHierarchyAdapter(Object.class, jsonSerializer);
        return gsonBuilder;
    }

    public static final /* synthetic */ <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, JsonSerializer<T> jsonSerializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(jsonSerializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeAdapter(Object.class, jsonSerializer);
        return gsonBuilder;
    }
}

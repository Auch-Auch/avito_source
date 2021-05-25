package ru.avito.messenger.internal.util;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\b¢\u0006\u0004\b\n\u0010\u000b\u001a(\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\b¢\u0006\u0004\b\n\u0010\r\u001a(\u0010\u0010\u001a\u00028\u0000\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a:\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u000e2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0012\"\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u0010\u0010\u0014\u001a.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a.\u0010\u001d\u001a\u00020\u001a\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a.\u0010 \u001a\u00020\u001a\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\b¢\u0006\u0004\b \u0010!\u001a.\u0010\u001d\u001a\u00020\u001a\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006*\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\b¢\u0006\u0004\b\u001d\u0010!¨\u0006\""}, d2 = {"Lcom/google/gson/JsonObject;", "", "parameter", "Lcom/google/gson/JsonElement;", "get", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonElement;", "", "T", "Lcom/google/gson/Gson;", "jsonString", "fromJson", "(Lcom/google/gson/Gson;Ljava/lang/String;)Ljava/lang/Object;", "jsonElement", "(Lcom/google/gson/Gson;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "Lcom/google/gson/JsonDeserializationContext;", "json", "deserialize", "(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "", MessengerShareContentUtility.ELEMENTS, "(Lcom/google/gson/JsonDeserializationContext;[Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "Lcom/google/gson/JsonArray;", "jsonArray", "", "deserializeList", "(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonArray;)Ljava/util/List;", "Lcom/google/gson/GsonBuilder;", "Lcom/google/gson/TypeAdapter;", "adapter", "registerTypeAdapter", "(Lcom/google/gson/GsonBuilder;Lcom/google/gson/TypeAdapter;)Lcom/google/gson/GsonBuilder;", "Lcom/google/gson/JsonDeserializer;", "registerTypeHierarchyAdapter", "(Lcom/google/gson/GsonBuilder;Lcom/google/gson/JsonDeserializer;)Lcom/google/gson/GsonBuilder;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class GsonKt {
    public static final /* synthetic */ <T> T deserialize(JsonDeserializationContext jsonDeserializationContext, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "$this$deserialize");
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) jsonDeserializationContext.deserialize(jsonElement, Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "deserialize(json, T::class.java)");
        return t;
    }

    public static final /* synthetic */ <T> List<T> deserializeList(JsonDeserializationContext jsonDeserializationContext, JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "$this$deserializeList");
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            Intrinsics.reifiedOperationMarker(4, "T");
            arrayList.add(jsonDeserializationContext.deserialize(it.next(), Object.class));
        }
        return arrayList;
    }

    public static final /* synthetic */ <T> T fromJson(Gson gson, String str) {
        Intrinsics.checkNotNullParameter(gson, "$this$fromJson");
        Intrinsics.checkNotNullParameter(str, "jsonString");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) gson.fromJson(str, (Class<Object>) Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "fromJson<T>(jsonString, T::class.java)");
        return t;
    }

    @Nullable
    public static final JsonElement get(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "$this$get");
        Intrinsics.checkNotNullParameter(str, "parameter");
        return jsonObject.get(str);
    }

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

    public static final /* synthetic */ <T> T deserialize(JsonDeserializationContext jsonDeserializationContext, JsonElement... jsonElementArr) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "$this$deserialize");
        Intrinsics.checkNotNullParameter(jsonElementArr, MessengerShareContentUtility.ELEMENTS);
        for (JsonElement jsonElement : jsonElementArr) {
            if (jsonElement != null) {
                Intrinsics.reifiedOperationMarker(4, "T");
                T t = (T) jsonDeserializationContext.deserialize(jsonElement, Object.class);
                Intrinsics.checkNotNullExpressionValue(t, "deserialize(json, T::class.java)");
                return t;
            }
        }
        return null;
    }

    public static final /* synthetic */ <T> T fromJson(Gson gson, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(gson, "$this$fromJson");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) gson.fromJson(jsonElement, (Class<Object>) Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "fromJson<T>(jsonElement, T::class.java)");
        return t;
    }

    public static final /* synthetic */ <T> GsonBuilder registerTypeAdapter(GsonBuilder gsonBuilder, JsonDeserializer<T> jsonDeserializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(jsonDeserializer, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        gsonBuilder.registerTypeAdapter(Object.class, jsonDeserializer);
        return gsonBuilder;
    }
}

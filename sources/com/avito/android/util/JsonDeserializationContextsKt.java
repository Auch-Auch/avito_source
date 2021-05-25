package com.avito.android.util;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a:\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\b\"\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u0005\u0010\n\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\b¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"", "T", "Lcom/google/gson/JsonDeserializationContext;", "Lcom/google/gson/JsonElement;", "json", "deserialize", "(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "deserializeNullable", "", MessengerShareContentUtility.ELEMENTS, "(Lcom/google/gson/JsonDeserializationContext;[Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "Lcom/google/gson/JsonArray;", "jsonArray", "", "deserializeList", "(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonArray;)Ljava/util/List;", "deserializeNullableList", "gson"}, k = 2, mv = {1, 4, 2})
public final class JsonDeserializationContextsKt {
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

    public static final /* synthetic */ <T> T deserializeNullable(JsonDeserializationContext jsonDeserializationContext, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "$this$deserializeNullable");
        if (jsonElement == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) jsonDeserializationContext.deserialize(jsonElement, Object.class);
    }

    public static final /* synthetic */ <T> List<T> deserializeNullableList(JsonDeserializationContext jsonDeserializationContext, JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "$this$deserializeNullableList");
        if (jsonArray == null) {
            return null;
        }
        int size = jsonArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement = jsonArray.get(i);
            JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
            Intrinsics.reifiedOperationMarker(4, "T");
            arrayList.add(jsonDeserializationContext.deserialize(asJsonObject, Object.class));
        }
        return arrayList;
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
}

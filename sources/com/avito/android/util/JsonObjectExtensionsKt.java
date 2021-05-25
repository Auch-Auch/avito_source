package com.avito.android.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a.\u0010\u0013\u001a\u00020\u00002\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\b\u0011H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a$\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00010\u0001*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u001c\u0010\u001a\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u001c*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u001f\u001a\n \u0016*\u0004\u0018\u00010\u00000\u0000*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006!"}, d2 = {"Lcom/google/gson/JsonObject;", "", "parameter", "Lcom/google/gson/JsonElement;", "get", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonElement;", "memberName", "getNullableString", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "", "getNullableLong", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "", "getNullableBoolean", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "jsonObject", "(Lkotlin/jvm/functions/Function1;)Lcom/google/gson/JsonObject;", "tag", "kotlin.jvm.PlatformType", "getString", "(Lcom/google/gson/JsonElement;Ljava/lang/String;)Ljava/lang/String;", "getStringNullable", "getLong", "(Lcom/google/gson/JsonElement;Ljava/lang/String;)J", "", "getInt", "(Lcom/google/gson/JsonElement;Ljava/lang/String;)I", "getObject", "(Lcom/google/gson/JsonElement;Ljava/lang/String;)Lcom/google/gson/JsonObject;", "gson"}, k = 2, mv = {1, 4, 2})
public final class JsonObjectExtensionsKt {
    @Nullable
    public static final JsonElement get(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "$this$get");
        Intrinsics.checkNotNullParameter(str, "parameter");
        return jsonObject.get(str);
    }

    public static final int getInt(@NotNull JsonElement jsonElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$getInt");
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "asJsonObject.get(tag)");
        return jsonElement2.getAsInt();
    }

    public static final long getLong(@NotNull JsonElement jsonElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$getLong");
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "asJsonObject.get(tag)");
        return jsonElement2.getAsLong();
    }

    @Nullable
    public static final Boolean getNullableBoolean(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "$this$getNullableBoolean");
        Intrinsics.checkNotNullParameter(str, "memberName");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return Boolean.valueOf(jsonElement.getAsBoolean());
    }

    @Nullable
    public static final Long getNullableLong(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "$this$getNullableLong");
        Intrinsics.checkNotNullParameter(str, "memberName");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return Long.valueOf(jsonElement.getAsLong());
    }

    @Nullable
    public static final String getNullableString(@NotNull JsonObject jsonObject, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "$this$getNullableString");
        Intrinsics.checkNotNullParameter(str, "memberName");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsString();
    }

    public static final JsonObject getObject(@NotNull JsonElement jsonElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$getObject");
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "asJsonObject.get(tag)");
        return jsonElement2.getAsJsonObject();
    }

    public static final String getString(@NotNull JsonElement jsonElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$getString");
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "asJsonObject.get(tag)");
        return jsonElement2.getAsString();
    }

    @Nullable
    public static final String getStringNullable(@NotNull JsonElement jsonElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$getStringNullable");
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        if (jsonElement2 instanceof JsonNull) {
            return null;
        }
        return jsonElement2.getAsString();
    }

    @NotNull
    public static final JsonObject jsonObject(@NotNull Function1<? super JsonObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        JsonObject jsonObject = new JsonObject();
        function1.invoke(jsonObject);
        return jsonObject;
    }

    public static /* synthetic */ JsonObject jsonObject$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = JsonObjectExtensionsKt$jsonObject$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(function1, "block");
        JsonObject jsonObject = new JsonObject();
        function1.invoke(jsonObject);
        return jsonObject;
    }
}

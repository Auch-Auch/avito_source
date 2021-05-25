package ru.avito.messenger.internal.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/gson/JsonObject;", "", "memberName", "getNullableString", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "", "getNullableLong", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class JsonObjectsKt {
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
}

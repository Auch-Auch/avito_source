package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.References;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ReferencesTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/References;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/References;", "Lcom/google/gson/JsonObject;", "", "key", "", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/util/Map;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ReferencesTypeAdapter implements JsonDeserializer<References> {
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> a(com.google.gson.JsonObject r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = r4.has(r5)
            r1 = 1
            if (r0 == 0) goto L_0x001c
            com.google.gson.JsonObject r0 = r4.getAsJsonObject(r5)
            java.lang.String r2 = "getAsJsonObject(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.Set r0 = r0.entrySet()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0022
            r4 = 0
            return r4
        L_0x0022:
            com.google.gson.JsonObject r4 = r4.getAsJsonObject(r5)
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0033:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r4.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            com.google.gson.JsonElement r0 = (com.google.gson.JsonElement) r0
            java.lang.String r2 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()
            java.lang.String r2 = "name"
            com.google.gson.JsonElement r0 = r0.get(r2)
            java.lang.String r2 = "value.asJsonObject.get(\"name\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r0 = r0.getAsString()
            r5.put(r1, r0)
            goto L_0x0033
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.ReferencesTypeAdapter.a(com.google.gson.JsonObject, java.lang.String):java.util.Map");
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public References deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "referencesHolder");
        return new References(a(asJsonObject, "locations"), a(asJsonObject, "metro"), a(asJsonObject, "districts"), a(asJsonObject, "directions"), a(asJsonObject, "categories"));
    }
}

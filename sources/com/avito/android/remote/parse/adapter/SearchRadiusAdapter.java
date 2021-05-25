package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.SearchRadius;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SearchRadiusAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/SearchRadius;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/SearchRadius;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchRadiusAdapter implements JsonDeserializer<SearchRadius> {
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        if (r10 != null) goto L_0x005c;
     */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.SearchRadius deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r10, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r11, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r12) {
        /*
            r9 = this;
            java.lang.String r1 = "json"
            java.lang.String r3 = "typeOfT"
            java.lang.String r5 = "context"
            r0 = r10
            r2 = r11
            r4 = r12
            com.google.gson.JsonObject r10 = a2.b.a.a.a.I1(r0, r1, r2, r3, r4, r5)
            java.lang.String r11 = "id"
            com.google.gson.JsonElement r11 = r10.get(r11)
            r0 = 0
            if (r11 == 0) goto L_0x001c
            java.lang.String r11 = r11.getAsString()
            r2 = r11
            goto L_0x001d
        L_0x001c:
            r2 = r0
        L_0x001d:
            java.lang.String r11 = "title"
            com.google.gson.JsonElement r11 = r10.get(r11)
            if (r11 == 0) goto L_0x002b
            java.lang.String r11 = r11.getAsString()
            r3 = r11
            goto L_0x002c
        L_0x002b:
            r3 = r0
        L_0x002c:
            java.lang.String r11 = "distanceInMeters"
            com.google.gson.JsonElement r11 = r10.get(r11)
            if (r11 == 0) goto L_0x003c
            long r0 = r11.getAsLong()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x003c:
            r4 = r0
            java.lang.String r11 = "coordinates"
            com.google.gson.JsonElement r10 = r10.get(r11)
            if (r10 == 0) goto L_0x0055
            java.lang.Class<com.avito.android.remote.model.Coordinates> r11 = com.avito.android.remote.model.Coordinates.class
            java.lang.Object r10 = r12.deserialize(r10, r11)
            java.lang.String r11 = "deserialize(json, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            com.avito.android.remote.model.Coordinates r10 = (com.avito.android.remote.model.Coordinates) r10
            if (r10 == 0) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            com.avito.android.remote.model.Coordinates r10 = new com.avito.android.remote.model.Coordinates
            r11 = 0
            double r11 = (double) r11
            r10.<init>(r11, r11)
        L_0x005c:
            r5 = r10
            com.avito.android.remote.model.SearchRadius r10 = new com.avito.android.remote.model.SearchRadius
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.SearchRadiusAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.SearchRadius");
    }
}

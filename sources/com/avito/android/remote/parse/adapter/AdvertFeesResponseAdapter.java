package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.AdvertFeesResponse;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertFeesResponseAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertFeesResponse;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertFeesResponse;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertFeesResponseAdapter implements JsonDeserializer<AdvertFeesResponse> {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008e  */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.AdvertFeesResponse deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r8, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r9, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r10) {
        /*
            r7 = this;
            java.lang.String r1 = "json"
            java.lang.String r3 = "typeOfT"
            java.lang.String r5 = "context"
            r0 = r8
            r2 = r9
            r4 = r10
            com.google.gson.JsonObject r8 = a2.b.a.a.a.I1(r0, r1, r2, r3, r4, r5)
            java.lang.String r9 = "message"
            com.google.gson.JsonElement r9 = r8.get(r9)
            r0 = 0
            if (r9 == 0) goto L_0x001b
            java.lang.String r9 = r9.getAsString()
            goto L_0x001c
        L_0x001b:
            r9 = r0
        L_0x001c:
            java.lang.String r1 = "buy"
            boolean r2 = r8.has(r1)
            java.lang.String r3 = "deserialize(json, T::class.java)"
            if (r2 == 0) goto L_0x0047
            com.google.gson.JsonObject r1 = r8.getAsJsonObject(r1)
            java.lang.String r2 = "single"
            boolean r4 = r1.has(r2)
            if (r4 == 0) goto L_0x0047
            com.google.gson.JsonObject r1 = r1.getAsJsonObject(r2)
            java.lang.String r2 = "buy.getAsJsonObject(\"single\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Class<com.avito.android.remote.model.SingleFee> r2 = com.avito.android.remote.model.SingleFee.class
            java.lang.Object r1 = r10.deserialize(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.avito.android.remote.model.SingleFee r1 = (com.avito.android.remote.model.SingleFee) r1
            goto L_0x0048
        L_0x0047:
            r1 = r0
        L_0x0048:
            java.lang.String r2 = "packages"
            boolean r4 = r8.has(r2)
            if (r4 == 0) goto L_0x0085
            com.google.gson.JsonElement r2 = r8.get(r2)
            java.lang.String r4 = "js.get(\"packages\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.google.gson.JsonArray r2 = r2.getAsJsonArray()
            java.lang.String r4 = "js.get(\"packages\").asJsonArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.size()
            r4.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L_0x006f:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0086
            java.lang.Object r5 = r2.next()
            com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5
            java.lang.Class<com.avito.android.remote.model.OwnedPackage> r6 = com.avito.android.remote.model.OwnedPackage.class
            java.lang.Object r5 = r10.deserialize(r5, r6)
            r4.add(r5)
            goto L_0x006f
        L_0x0085:
            r4 = r0
        L_0x0086:
            java.lang.String r2 = "action"
            boolean r5 = r8.has(r2)
            if (r5 == 0) goto L_0x00a3
            com.google.gson.JsonObject r8 = r8.getAsJsonObject(r2)
            java.lang.String r0 = "js.getAsJsonObject(\"action\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.Class<com.avito.android.remote.model.Action> r0 = com.avito.android.remote.model.Action.class
            java.lang.Object r8 = r10.deserialize(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            r0 = r8
            com.avito.android.remote.model.Action r0 = (com.avito.android.remote.model.Action) r0
        L_0x00a3:
            com.avito.android.remote.model.AdvertFeesResponse r8 = new com.avito.android.remote.model.AdvertFeesResponse
            r8.<init>(r9, r1, r4, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.AdvertFeesResponseAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.AdvertFeesResponse");
    }
}

package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.AdvertActions;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertActionsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertActions;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertActions;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertActionsDeserializer implements JsonDeserializer<AdvertActions> {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0042 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.AdvertActions deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r3, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r4, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r5) {
        /*
            r2 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "typeOfT"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()
            java.lang.String r4 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = "access"
            com.google.gson.JsonElement r4 = r3.get(r4)
            if (r4 == 0) goto L_0x0041
            com.google.gson.JsonObject r4 = r4.getAsJsonObject()
            java.lang.String r0 = "action"
            com.google.gson.JsonElement r4 = r4.get(r0)
            java.lang.String r0 = "access.asJsonObject[\"action\"]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Class<com.avito.android.remote.model.AdvertAction$Access> r0 = com.avito.android.remote.model.AdvertAction.Access.class
            java.lang.Object r4 = r5.deserialize(r4, r0)
            java.lang.String r0 = "deserialize(json, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            com.avito.android.remote.model.AdvertAction$Access r4 = (com.avito.android.remote.model.AdvertAction.Access) r4
            java.util.List r4 = t6.n.d.listOf(r4)
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0045
            goto L_0x007e
        L_0x0045:
            java.lang.String r4 = "list"
            com.google.gson.JsonElement r3 = r3.get(r4)
            if (r3 == 0) goto L_0x0079
            com.google.gson.JsonArray r3 = r3.getAsJsonArray()
            java.lang.String r4 = "list.asJsonArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r3.size()
            r4.<init>(r0)
            java.util.Iterator r3 = r3.iterator()
        L_0x0063:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x007e
            java.lang.Object r0 = r3.next()
            com.google.gson.JsonElement r0 = (com.google.gson.JsonElement) r0
            java.lang.Class<com.avito.android.remote.model.AdvertAction> r1 = com.avito.android.remote.model.AdvertAction.class
            java.lang.Object r0 = r5.deserialize(r0, r1)
            r4.add(r0)
            goto L_0x0063
        L_0x0079:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r4 = r3
        L_0x007e:
            com.avito.android.remote.model.AdvertActions r3 = new com.avito.android.remote.model.AdvertActions
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.AdvertActionsDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.AdvertActions");
    }
}

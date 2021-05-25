package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.delivery.InfoBlock;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AttributesBlockDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/delivery/InfoBlock$AttributesBlock;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/delivery/InfoBlock$AttributesBlock;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class AttributesBlockDeserializer implements JsonDeserializer<InfoBlock.AttributesBlock> {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.delivery.InfoBlock.AttributesBlock deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r7, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r8, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r9) {
        /*
            r6 = this;
            java.lang.String r1 = "json"
            java.lang.String r3 = "typeOfT"
            java.lang.String r5 = "context"
            r0 = r7
            r2 = r8
            r4 = r9
            com.google.gson.JsonObject r7 = a2.b.a.a.a.I1(r0, r1, r2, r3, r4, r5)
            java.lang.String r8 = "title"
            com.google.gson.JsonElement r8 = r7.get(r8)
            r0 = 0
            if (r8 == 0) goto L_0x001b
            java.lang.String r8 = r8.getAsString()
            goto L_0x001c
        L_0x001b:
            r8 = r0
        L_0x001c:
            java.lang.String r1 = "parameters"
            com.google.gson.JsonObject r7 = r7.getAsJsonObject(r1)
            if (r7 == 0) goto L_0x0031
            java.lang.String r1 = "list"
            com.google.gson.JsonElement r7 = r7.get(r1)
            if (r7 == 0) goto L_0x0031
            com.google.gson.JsonArray r7 = r7.getAsJsonArray()
            goto L_0x0032
        L_0x0031:
            r7 = r0
        L_0x0032:
            if (r7 == 0) goto L_0x0057
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0041:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            java.lang.Class<com.avito.android.remote.model.delivery.Attribute> r2 = com.avito.android.remote.model.delivery.Attribute.class
            java.lang.Object r1 = r9.deserialize(r1, r2)
            r0.add(r1)
            goto L_0x0041
        L_0x0057:
            com.avito.android.remote.model.delivery.InfoBlock$AttributesBlock r7 = new com.avito.android.remote.model.delivery.InfoBlock$AttributesBlock
            if (r0 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0060:
            r7.<init>(r8, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.AttributesBlockDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.delivery.InfoBlock$AttributesBlock");
    }
}

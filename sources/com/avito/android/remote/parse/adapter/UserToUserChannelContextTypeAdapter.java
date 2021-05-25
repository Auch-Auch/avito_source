package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.JsonDeserializer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/UserToUserChannelContextTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UserToUserChannelContextTypeAdapter implements JsonDeserializer<ChannelContext.UserToUser> {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0045 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.messenger.context.ChannelContext.UserToUser deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r7, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r8, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r9) {
        /*
            r6 = this;
            java.lang.String r1 = "json"
            java.lang.String r3 = "typeOfT"
            java.lang.String r5 = "context"
            r0 = r7
            r2 = r8
            r4 = r9
            com.google.gson.JsonObject r7 = a2.b.a.a.a.I1(r0, r1, r2, r3, r4, r5)
            java.lang.String r8 = "menu"
            com.google.gson.JsonElement r8 = r7.get(r8)
            if (r8 == 0) goto L_0x0041
            com.google.gson.JsonArray r8 = r8.getAsJsonArray()
            java.lang.String r0 = "menuJsonArray.asJsonArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r8.size()
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L_0x002b:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r8.next()
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            java.lang.Class<com.avito.android.remote.model.messenger.context.ChannelMenuAction> r2 = com.avito.android.remote.model.messenger.context.ChannelMenuAction.class
            java.lang.Object r1 = r9.deserialize(r1, r2)
            r0.add(r1)
            goto L_0x002b
        L_0x0041:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0045:
            java.lang.String r8 = "attachMenu"
            com.google.gson.JsonElement r8 = r7.get(r8)
            r1 = 0
            if (r8 == 0) goto L_0x0055
            java.lang.Class<com.avito.android.remote.model.messenger.attach_menu.AttachMenu> r2 = com.avito.android.remote.model.messenger.attach_menu.AttachMenu.class
            java.lang.Object r8 = r9.deserialize(r8, r2)
            goto L_0x0056
        L_0x0055:
            r8 = r1
        L_0x0056:
            com.avito.android.remote.model.messenger.attach_menu.AttachMenu r8 = (com.avito.android.remote.model.messenger.attach_menu.AttachMenu) r8
            java.lang.String r2 = "sharedLocation"
            com.google.gson.JsonElement r7 = r7.get(r2)
            if (r7 == 0) goto L_0x0066
            java.lang.Class<com.avito.android.remote.model.messenger.message.MessageBody$Location> r1 = com.avito.android.remote.model.messenger.message.MessageBody.Location.class
            java.lang.Object r1 = r9.deserialize(r7, r1)
        L_0x0066:
            com.avito.android.remote.model.messenger.message.MessageBody$Location r1 = (com.avito.android.remote.model.messenger.message.MessageBody.Location) r1
            com.avito.android.remote.model.messenger.context.ChannelContext$UserToUser r7 = new com.avito.android.remote.model.messenger.context.ChannelContext$UserToUser
            r7.<init>(r1, r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.UserToUserChannelContextTypeAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.messenger.context.ChannelContext$UserToUser");
    }
}

package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SystemChannelContextTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$System;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$System;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SystemChannelContextTypeAdapter implements JsonDeserializer<ChannelContext.System> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ChannelContext.System deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        ArrayList arrayList;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("name");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "js.get(NAME)");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        String nullableString = JsonObjectExtensionsKt.getNullableString(I1, "status");
        String nullableString2 = JsonObjectExtensionsKt.getNullableString(I1, "description");
        JsonElement jsonElement3 = I1.get("image");
        Object obj = null;
        if (!(jsonElement3 instanceof JsonObject)) {
            jsonElement3 = null;
        }
        JsonObject jsonObject = (JsonObject) jsonElement3;
        Image image = (Image) (jsonObject != null ? jsonDeserializationContext.deserialize(jsonObject, Image.class) : null);
        JsonElement jsonElement4 = I1.get("menu");
        if (jsonElement4 != null) {
            JsonArray asJsonArray = jsonElement4.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray, "menuJsonArray.asJsonArray");
            ArrayList arrayList2 = new ArrayList(asJsonArray.size());
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList2.add(jsonDeserializationContext.deserialize(it.next(), ChannelMenuAction.class));
            }
            arrayList = arrayList2;
        } else {
            arrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        JsonElement jsonElement5 = I1.get(ChannelContext.ATTACH_MENU);
        if (jsonElement5 != null) {
            obj = jsonDeserializationContext.deserialize(jsonElement5, AttachMenu.class);
        }
        Intrinsics.checkNotNullExpressionValue(asString, "name");
        return new ChannelContext.System(asString, nullableString, nullableString2, image, arrayList, (AttachMenu) obj);
    }
}

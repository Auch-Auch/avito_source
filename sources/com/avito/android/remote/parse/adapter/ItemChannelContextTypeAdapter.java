package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.avito.android.remote.model.messenger.message.MessageBody;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ItemChannelContextTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ItemChannelContextTypeAdapter implements JsonDeserializer<ChannelContext.Item> {
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0071: APUT  (r5v2 com.google.gson.JsonElement[]), (0 ??[int, short, byte, char]), (r11v2 com.google.gson.JsonElement) */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ChannelContext.Item deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String str;
        String str2;
        Object obj;
        ArrayList arrayList;
        JsonObject asJsonObject;
        String asString;
        String asString2;
        String asString3;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "id", "js.get(ID)");
        String x22 = a.x2(I1, "title", "js.get(TITLE)");
        JsonElement jsonElement2 = I1.get("categoryId");
        String str3 = (jsonElement2 == null || (asString3 = jsonElement2.getAsString()) == null) ? "" : asString3;
        JsonElement jsonElement3 = I1.get("category");
        if (jsonElement3 == null || (asString2 = jsonElement3.getAsString()) == null) {
            str = "";
        } else {
            str = asString2;
        }
        JsonElement jsonElement4 = I1.get("priceString");
        if (jsonElement4 == null || (asString = jsonElement4.getAsString()) == null) {
            str2 = "";
        } else {
            str2 = asString;
        }
        JsonElement[] jsonElementArr = new JsonElement[2];
        JsonElement jsonElement5 = I1.get("images");
        jsonElementArr[0] = (jsonElement5 == null || (asJsonObject = jsonElement5.getAsJsonObject()) == null) ? null : asJsonObject.get("main");
        jsonElementArr[1] = I1.get("image");
        int i = 0;
        while (true) {
            if (i >= 2) {
                obj = null;
                break;
            }
            JsonElement jsonElement6 = jsonElementArr[i];
            if (jsonElement6 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement6, Image.class);
                Intrinsics.checkNotNullExpressionValue(obj, "deserialize(json, T::class.java)");
                break;
            }
            i++;
        }
        Image image = (Image) obj;
        JsonElement jsonElement7 = I1.get("deleted");
        boolean asBoolean = jsonElement7 != null ? jsonElement7.getAsBoolean() : false;
        JsonElement jsonElement8 = I1.get(ChannelContext.Item.USER_ID);
        String asString4 = jsonElement8 != null ? jsonElement8.getAsString() : null;
        JsonElement jsonElement9 = I1.get("actions");
        if (jsonElement9 != null) {
            JsonArray asJsonArray = jsonElement9.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray, "actionsArray.asJsonArray");
            ArrayList arrayList2 = new ArrayList(asJsonArray.size());
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList2.add(jsonDeserializationContext.deserialize(it.next(), Action.class));
            }
        } else {
            CollectionsKt__CollectionsKt.emptyList();
        }
        JsonElement jsonElement10 = I1.get("menu");
        if (jsonElement10 != null) {
            JsonArray asJsonArray2 = jsonElement10.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(asJsonArray2, "menuJsonArray.asJsonArray");
            ArrayList arrayList3 = new ArrayList(asJsonArray2.size());
            Iterator<JsonElement> it2 = asJsonArray2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(jsonDeserializationContext.deserialize(it2.next(), ChannelMenuAction.class));
            }
            arrayList = arrayList3;
        } else {
            arrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        JsonElement jsonElement11 = I1.get(ChannelContext.ATTACH_MENU);
        AttachMenu attachMenu = (AttachMenu) (jsonElement11 != null ? jsonDeserializationContext.deserialize(jsonElement11, AttachMenu.class) : null);
        JsonElement jsonElement12 = I1.get("sharedLocation");
        MessageBody.Location location = (MessageBody.Location) (jsonElement12 != null ? jsonDeserializationContext.deserialize(jsonElement12, MessageBody.Location.class) : null);
        JsonElement jsonElement13 = I1.get(ChannelContext.Item.REPLY_TIME);
        ChatReplyTime chatReplyTime = (ChatReplyTime) (jsonElement13 != null ? jsonDeserializationContext.deserialize(jsonElement13, ChatReplyTime.class) : null);
        JsonElement jsonElement14 = I1.get(ChannelContext.Item.HIDE_PHONE);
        boolean asBoolean2 = jsonElement14 != null ? jsonElement14.getAsBoolean() : false;
        Intrinsics.checkNotNullExpressionValue(x2, "id");
        Intrinsics.checkNotNullExpressionValue(x22, "title");
        return new ChannelContext.Item(x2, str3, str, x22, str2, image, asBoolean, asString4, arrayList, attachMenu, location, chatReplyTime, asBoolean2);
    }
}

package com.avito.android.remote.parse.adapter.messenger;

import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/AttachMenuTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AttachMenuTypeAdapter implements JsonDeserializer<AttachMenu>, JsonSerializer<AttachMenu> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public AttachMenu deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Object obj = null;
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("file");
            AttachMenuItem.File file = (AttachMenuItem.File) (jsonElement2 != null ? jsonDeserializationContext.deserialize(jsonElement2, AttachMenuItem.File.class) : null);
            JsonElement jsonElement3 = asJsonObject.get("image");
            AttachMenuItem.Image image = (AttachMenuItem.Image) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, AttachMenuItem.Image.class) : null);
            JsonElement jsonElement4 = asJsonObject.get("item");
            AttachMenuItem.Item item = (AttachMenuItem.Item) (jsonElement4 != null ? jsonDeserializationContext.deserialize(jsonElement4, AttachMenuItem.Item.class) : null);
            JsonElement jsonElement5 = asJsonObject.get("location");
            if (jsonElement5 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement5, AttachMenuItem.Location.class);
            }
            return new AttachMenu(file, image, item, (AttachMenuItem.Location) obj);
        } else if (jsonElement.isJsonNull()) {
            return null;
        } else {
            throw new IllegalArgumentException("Unexpected json: " + jsonElement);
        }
    }

    @NotNull
    public JsonElement serialize(@Nullable AttachMenu attachMenu, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (attachMenu == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        AttachMenuItem.File file = attachMenu.getFile();
        if (file != null) {
            jsonObject.add("file", jsonSerializationContext.serialize(file));
        }
        AttachMenuItem.Image image = attachMenu.getImage();
        if (image != null) {
            jsonObject.add("image", jsonSerializationContext.serialize(image));
        }
        AttachMenuItem.Item item = attachMenu.getItem();
        if (item != null) {
            jsonObject.add("item", jsonSerializationContext.serialize(item));
        }
        AttachMenuItem.Location location = attachMenu.getLocation();
        if (location != null) {
            jsonObject.add("location", jsonSerializationContext.serialize(location));
        }
        return jsonObject;
    }
}

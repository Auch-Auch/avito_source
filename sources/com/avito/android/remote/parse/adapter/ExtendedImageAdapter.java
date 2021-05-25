package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.ExtendedImage;
import com.avito.android.remote.model.Image;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ExtendedImageAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/ExtendedImage;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/ExtendedImage;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedImageAdapter implements JsonDeserializer<ExtendedImage> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public ExtendedImage deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("id");
        Image image = null;
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString == null) {
            Object deserialize = jsonDeserializationContext.deserialize(I1, Image.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(jsonObject, Image::class.java)");
            return new ExtendedImage(null, (Image) deserialize, null, 4, null);
        }
        Object deserialize2 = jsonDeserializationContext.deserialize(I1.get("url"), Image.class);
        Intrinsics.checkNotNullExpressionValue(deserialize2, "context.deserialize(json…url\"], Image::class.java)");
        Image image2 = (Image) deserialize2;
        JsonElement jsonElement3 = I1.get("original");
        if (jsonElement3 != null) {
            image = (Image) jsonDeserializationContext.deserialize(jsonElement3, Image.class);
        }
        return new ExtendedImage(asString, image2, image);
    }
}

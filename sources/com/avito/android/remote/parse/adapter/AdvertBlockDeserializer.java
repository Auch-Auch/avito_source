package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.delivery.InfoBlock;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertBlockDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/delivery/InfoBlock$AdvertBlock;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/delivery/InfoBlock$AdvertBlock;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBlockDeserializer implements JsonDeserializer<InfoBlock.AdvertBlock> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public InfoBlock.AdvertBlock deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement5 = I1.get("title");
        Image image = null;
        String asString = jsonElement5 != null ? jsonElement5.getAsString() : null;
        JsonObject asJsonObject2 = I1.getAsJsonObject(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        JsonObject asJsonObject3 = (asJsonObject2 == null || (jsonElement4 = asJsonObject2.get("item")) == null) ? null : jsonElement4.getAsJsonObject();
        String asString2 = (asJsonObject3 == null || (jsonElement3 = asJsonObject3.get("title")) == null) ? null : jsonElement3.getAsString();
        String asString3 = (asJsonObject3 == null || (jsonElement2 = asJsonObject3.get("price")) == null) ? null : jsonElement2.getAsString();
        if (!(asJsonObject3 == null || (asJsonObject = asJsonObject3.getAsJsonObject("image")) == null)) {
            Object deserialize = jsonDeserializationContext.deserialize(asJsonObject, Image.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
            image = (Image) deserialize;
        }
        return new InfoBlock.AdvertBlock(asString, image, asString2, asString3);
    }
}

package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.model.LinkAction;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/LinkActionTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/LinkAction;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/LinkAction;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkActionTypeAdapter implements JsonDeserializer<LinkAction> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public LinkAction deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String asString;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("title");
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        JsonElement jsonElement3 = I1.get(ShareConstants.MEDIA_URI);
        if (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) {
            return null;
        }
        Uri parse = Uri.parse(asString);
        Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
        return new LinkAction(asString2, parse);
    }
}

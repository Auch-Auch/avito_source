package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.model.Action;
import com.facebook.share.internal.ShareConstants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ActionTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/Action;", "Lcom/google/gson/JsonSerializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/Action;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/Action;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ActionTypeAdapter implements JsonDeserializer<Action>, JsonSerializer<Action> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public Action deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String str;
        Boolean bool;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[TITLE]");
        String asString = jsonElement2.getAsString();
        Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
        JsonElement jsonElement3 = I1.get(ShareConstants.MEDIA_URI);
        DeepLink deepLink = (DeepLink) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, DeepLink.class) : null);
        if (deepLink == null) {
            deepLink = new NoMatchLink();
        }
        JsonElement jsonElement4 = I1.get("confirmation");
        Action.Confirmation confirmation = (Action.Confirmation) (jsonElement4 != null ? jsonDeserializationContext.deserialize(jsonElement4, Action.Confirmation.class) : null);
        if (!I1.has("type")) {
            str = null;
        } else {
            JsonElement jsonElement5 = I1.get("type");
            Intrinsics.checkNotNullExpressionValue(jsonElement5, "jsonObject[TYPE]");
            String asString2 = jsonElement5.getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject[TYPE].asString");
            if (!(asString2.length() == 0) && asString2.charAt(0) != '/') {
                asString2 = '/' + asString2;
            }
            str = asString2;
        }
        String x2 = I1.has(ShareConstants.MEDIA_URI) ? a.x2(I1, ShareConstants.MEDIA_URI, "jsonObject[URI]") : null;
        if (I1.has("closesElement")) {
            JsonElement jsonElement6 = I1.get("closesElement");
            Intrinsics.checkNotNullExpressionValue(jsonElement6, "jsonObject[CLOSES_ELEMENT]");
            bool = Boolean.valueOf(jsonElement6.getAsBoolean());
        } else {
            bool = null;
        }
        Intrinsics.checkNotNullExpressionValue(asString, "title");
        return new Action(asString, deepLink, confirmation, str, x2, bool);
    }

    @NotNull
    public JsonElement serialize(@Nullable Action action, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (action != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("title", action.getTitle());
            if (action.getRawUri() != null) {
                jsonObject.addProperty(ShareConstants.MEDIA_URI, action.getRawUri());
            }
            if (action.getConfirmation() != null) {
                jsonObject.add("confirmation", jsonSerializationContext.serialize(action.getConfirmation()));
            }
            jsonObject.add("type", jsonSerializationContext.serialize(action.getType()));
            if (action.getClosesElement() != null) {
                jsonObject.addProperty("closesElement", action.getClosesElement());
            }
            return jsonObject;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }
}

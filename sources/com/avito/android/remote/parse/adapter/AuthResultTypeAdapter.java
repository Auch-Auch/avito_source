package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.Session;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AuthResultTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AuthResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AuthResult;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AuthResultTypeAdapter implements JsonDeserializer<AuthResult> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AuthResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("user");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"user\")");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement2, Profile.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement, Session.class);
        Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
        Session session = (Session) deserialize2;
        Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
        return new AuthResult(session, (Profile) deserialize, JsonObjectExtensionsKt.getNullableString(I1, "message"));
    }
}

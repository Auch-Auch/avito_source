package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.InvalidSchemaException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.ReflectionKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0004\b\u0016\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\t\u001a\u00020\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002*\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR.\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00060\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/remote/parse/adapter/TypedResultDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/TypedResult;", "Ljava/lang/reflect/Type;", "T", "baseType", "", "", "statuses", "registerCustomType", "(Ljava/lang/reflect/Type;Ljava/util/Map;)Lcom/avito/android/remote/parse/adapter/TypedResultDeserializer;", "Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/TypedResult;", "status", "Lcom/google/gson/JsonObject;", "result", "resultType", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonDeserializationContext;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/reflect/Type;)Lcom/avito/android/remote/model/TypedResult;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "defaultErrorCases", "", "customTypes", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public class TypedResultDeserializer implements JsonDeserializer<TypedResult<?>> {
    public final Map<Type, Map<String, Type>> a = new LinkedHashMap();
    public final Map<String, Type> b = r.mapOf(TuplesKt.to("incorrect-data", ErrorResult.IncorrectData.class), TuplesKt.to("error-dialog", ErrorResult.ErrorDialog.class), TuplesKt.to("unauthenticated", ErrorResult.Unauthenticated.class), TuplesKt.to("unauthorized", ErrorResult.Unauthorized.class), TuplesKt.to("forbidden", ErrorResult.Forbidden.class), TuplesKt.to("bad-request", ErrorResult.BadRequest.class), TuplesKt.to("internal-error", ErrorResult.InternalError.class), TuplesKt.to("action", ErrorResult.ErrorAction.class));

    public final TypedResult<Object> a(JsonDeserializationContext jsonDeserializationContext, String str, JsonObject jsonObject, Type type) {
        Type type2 = this.b.get(str);
        if (type2 == null) {
            return new TypedResult.OfError(new ErrorResult.UnknownStatusError("Unknown status \"" + str + "\" for type " + type));
        }
        Object deserialize = jsonDeserializationContext.deserialize(jsonObject, type2);
        Intrinsics.checkNotNullExpressionValue(deserialize, "this.deserialize(result, defaultErrorClass)");
        ErrorResult errorResult = (ErrorResult) deserialize;
        if (!(errorResult.getMessage().length() == 0)) {
            return new TypedResult.OfError(errorResult);
        }
        throw new InvalidSchemaException();
    }

    @NotNull
    public final <T extends Type> TypedResultDeserializer registerCustomType(@NotNull T t, @NotNull Map<String, ? extends Type> map) {
        Intrinsics.checkNotNullParameter(t, "baseType");
        Intrinsics.checkNotNullParameter(map, "statuses");
        this.a.put(t, map);
        return this;
    }

    /* Return type fixed from 'com.avito.android.remote.model.TypedResult<java.lang.Object>' to match base method */
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public TypedResult<?> deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException, InvalidSchemaException {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Type firstRawArgumentType = ReflectionKt.firstRawArgumentType(type);
        if (firstRawArgumentType != null) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "js");
            String asString = TypedResultDeserializerKt.access$getMandatoryKey(asJsonObject, "status").getAsString();
            JsonObject asJsonObject2 = TypedResultDeserializerKt.access$getMandatoryKey(asJsonObject, "result").getAsJsonObject();
            Map<String, Type> map = this.a.get(firstRawArgumentType);
            if (map != null) {
                Type type2 = map.get(asString);
                if (type2 == null) {
                    Intrinsics.checkNotNullExpressionValue(asString, "status");
                    Intrinsics.checkNotNullExpressionValue(asJsonObject2, "result");
                    return a(jsonDeserializationContext, asString, asJsonObject2, firstRawArgumentType);
                }
                Intrinsics.checkNotNullExpressionValue(asJsonObject2, "result");
                Object deserialize = jsonDeserializationContext.deserialize(asJsonObject2, type2);
                Intrinsics.checkNotNullExpressionValue(deserialize, "this.deserialize(result, resultType)");
                return new TypedResult.OfResult(deserialize);
            } else if (Intrinsics.areEqual(asString, "ok")) {
                Intrinsics.checkNotNullExpressionValue(asJsonObject2, "result");
                Object deserialize2 = jsonDeserializationContext.deserialize(asJsonObject2, firstRawArgumentType);
                Intrinsics.checkNotNullExpressionValue(deserialize2, "this.deserialize(result, resultType)");
                return new TypedResult.OfResult(deserialize2);
            } else {
                Intrinsics.checkNotNullExpressionValue(asString, "status");
                Intrinsics.checkNotNullExpressionValue(asJsonObject2, "result");
                return a(jsonDeserializationContext, asString, asJsonObject2, firstRawArgumentType);
            }
        } else {
            throw new IllegalArgumentException(("Can't define argument type of " + type).toString());
        }
    }
}

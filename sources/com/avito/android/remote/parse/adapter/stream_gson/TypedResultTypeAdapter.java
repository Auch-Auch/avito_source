package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import com.avito.android.remote.InvalidSchemaException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001BK\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0013\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00120\u0012¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/TypedResult;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/TypedResult;)V", "", "typeString", "", AuthSource.SEND_ABUSE, "(Lcom/google/gson/stream/JsonReader;Ljava/lang/String;)Lcom/avito/android/remote/model/TypedResult;", "", "Ljava/lang/reflect/Type;", "d", "Ljava/util/Map;", "customTypes", "c", "defaultErrorCases", AuthSource.BOOKING_ORDER, "Ljava/lang/reflect/Type;", "actualType", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;Ljava/lang/reflect/Type;Ljava/util/Map;Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TypedResultTypeAdapter extends TypeAdapter<TypedResult<?>> {
    public final Gson a;
    public final Type b;
    public final Map<String, Type> c;
    public final Map<Type, Map<String, Type>> d;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends java.lang.reflect.Type> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.reflect.Type, ? extends java.util.Map<java.lang.String, ? extends java.lang.reflect.Type>> */
    /* JADX WARN: Multi-variable type inference failed */
    public TypedResultTypeAdapter(@NotNull Gson gson, @NotNull Type type, @NotNull Map<String, ? extends Type> map, @NotNull Map<Type, ? extends Map<String, ? extends Type>> map2) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(type, "actualType");
        Intrinsics.checkNotNullParameter(map, "defaultErrorCases");
        Intrinsics.checkNotNullParameter(map2, "customTypes");
        this.a = gson;
        this.b = type;
        this.c = map;
        this.d = map2;
    }

    public final TypedResult<Object> a(JsonReader jsonReader, String str) {
        Type type = this.c.get(str);
        if (type == null) {
            return new TypedResult.OfError(new ErrorResult.UnknownStatusError(a.e3("Unknown \"", str, "\".")));
        }
        Object fromJson = this.a.fromJson(jsonReader, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(reader, defaultErrorClass)");
        ErrorResult errorResult = (ErrorResult) fromJson;
        if (!(errorResult.getMessage().length() == 0)) {
            return new TypedResult.OfError(errorResult);
        }
        throw new InvalidSchemaException();
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public TypedResult<?> read(@NotNull JsonReader jsonReader) {
        TypedResult<?> typedResult;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        String nextName = jsonReader.nextName();
        Map<String, Type> map = this.d.get(this.b);
        if (map != null) {
            Type type = map.get(nextName);
            if (type == null) {
                Intrinsics.checkNotNullExpressionValue(nextName, "typeString");
                typedResult = a(jsonReader, nextName);
            } else {
                typedResult = new TypedResult.OfResult<>(this.a.fromJson(jsonReader, type));
            }
        } else if (Intrinsics.areEqual(nextName, "success")) {
            typedResult = new TypedResult.OfResult<>(this.a.fromJson(jsonReader, this.b));
        } else {
            Intrinsics.checkNotNullExpressionValue(nextName, "typeString");
            typedResult = a(jsonReader, nextName);
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return typedResult;
    }

    public void write(@Nullable JsonWriter jsonWriter, @Nullable TypedResult<?> typedResult) {
        throw new UnsupportedOperationException();
    }
}

package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.CustomTypedResultEntry;
import com.avito.android.util.ReflectionKt;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\b\u001a\u00020\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ3\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R.\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00050\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "Ljava/lang/Class;", "T", "baseType", "", "", "statuses", "registerCustomType", "(Ljava/lang/Class;Ljava/util/Map;)Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;", "Lcom/avito/android/util/CustomTypedResultEntry;", "entry", "(Lcom/avito/android/util/CustomTypedResultEntry;)Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Ljava/lang/reflect/Type;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "defaultErrorCases", "", AuthSource.SEND_ABUSE, "customTypes", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TypedResultTypeAdapterFactory implements TypeAdapterFactory {
    public final Map<Type, Map<String, Type>> a = new LinkedHashMap();
    public final Map<String, Type> b = r.mapOf(TuplesKt.to("incorrect-data", ErrorResult.IncorrectData.class), TuplesKt.to("error-dialog", ErrorResult.ErrorDialog.class), TuplesKt.to("unauthenticated", ErrorResult.Unauthenticated.class), TuplesKt.to("unauthorized", ErrorResult.Unauthorized.class), TuplesKt.to("forbidden", ErrorResult.Forbidden.class), TuplesKt.to("bad-request", ErrorResult.BadRequest.class), TuplesKt.to("internal-error", ErrorResult.InternalError.class));

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!Intrinsics.areEqual(typeToken.getRawType(), TypedResult.class)) {
            return null;
        }
        Type type = typeToken.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type.type");
        Type firstRawArgumentType = ReflectionKt.firstRawArgumentType(type);
        if (firstRawArgumentType != null) {
            return new TypedResultTypeAdapter(gson, firstRawArgumentType, this.b, this.a);
        }
        StringBuilder L = a.L("Can't define argument type of ");
        L.append(typeToken.getType());
        throw new IllegalArgumentException(L.toString().toString());
    }

    @NotNull
    public final <T extends Class<?>> TypedResultTypeAdapterFactory registerCustomType(@NotNull T t, @NotNull Map<String, ? extends Class<?>> map) {
        Intrinsics.checkNotNullParameter(t, "baseType");
        Intrinsics.checkNotNullParameter(map, "statuses");
        this.a.put(t, map);
        return this;
    }

    @NotNull
    public final TypedResultTypeAdapterFactory registerCustomType(@NotNull CustomTypedResultEntry customTypedResultEntry) {
        Intrinsics.checkNotNullParameter(customTypedResultEntry, "entry");
        return registerCustomType(customTypedResultEntry.getType(), customTypedResultEntry.getStatuses());
    }
}

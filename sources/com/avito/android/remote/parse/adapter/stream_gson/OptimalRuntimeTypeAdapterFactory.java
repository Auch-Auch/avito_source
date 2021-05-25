package com.avito.android.remote.parse.adapter.stream_gson;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cB\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\u0004\b\u0001\u0010\u00012\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "T", "Lcom/google/gson/TypeAdapterFactory;", "Ljava/lang/Class;", "type", "", "label", "registerSubtype", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "registerFallbackSubtype", "(Ljava/lang/Class;)Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Ljava/util/LinkedHashMap;", AuthSource.SEND_ABUSE, "Ljava/util/LinkedHashMap;", "labelToSubtype", AuthSource.BOOKING_ORDER, "Ljava/lang/Class;", "fallbackSubtype", "c", "baseType", "<init>", "(Ljava/lang/Class;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OptimalRuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final LinkedHashMap<String, Class<? extends T>> a = new LinkedHashMap<>();
    public Class<? extends T> b;
    public final Class<T> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory$Companion;", "", "T", "Ljava/lang/Class;", "baseType", "Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "of", "(Ljava/lang/Class;)Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <T> OptimalRuntimeTypeAdapterFactory<T> of(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "baseType");
            return new OptimalRuntimeTypeAdapterFactory<>(cls);
        }

        public Companion(j jVar) {
        }
    }

    public OptimalRuntimeTypeAdapterFactory(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "baseType");
        this.c = cls;
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        TypeAdapter<T> typeAdapter = null;
        if (!Intrinsics.areEqual(typeToken.getRawType(), this.c)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.a.size());
        for (Map.Entry<String, Class<? extends T>> entry : this.a.entrySet()) {
            TypeAdapter<T> adapter = gson.getAdapter(TypeToken.get((Class) entry.getValue()));
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
            linkedHashMap.put(entry.getKey(), adapter);
        }
        Class<? extends T> cls = this.b;
        if (cls != null) {
            typeAdapter = gson.getAdapter(TypeToken.get((Class) cls));
            Objects.requireNonNull(typeAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
        }
        return new TypeAdapter<T>(linkedHashMap, typeAdapter) { // from class: com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory$create$1
            public final /* synthetic */ LinkedHashMap a;
            public final /* synthetic */ TypeAdapter b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.gson.TypeAdapter
            @Nullable
            public T read(@NotNull JsonReader jsonReader) throws IOException {
                Intrinsics.checkNotNullParameter(jsonReader, "reader");
                jsonReader.beginObject();
                T t = null;
                if (jsonReader.hasNext()) {
                    TypeAdapter typeAdapter2 = (TypeAdapter) this.a.get(jsonReader.nextName());
                    if (typeAdapter2 == null) {
                        typeAdapter2 = this.b;
                    }
                    if (typeAdapter2 != null) {
                        t = (T) typeAdapter2.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return t;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(@NotNull JsonWriter jsonWriter, T t) throws IOException {
                Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
                throw new UnsupportedOperationException();
            }
        }.nullSafe();
    }

    @NotNull
    public final OptimalRuntimeTypeAdapterFactory<T> registerFallbackSubtype(@NotNull Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        this.b = cls;
        return this;
    }

    @NotNull
    public final OptimalRuntimeTypeAdapterFactory<T> registerSubtype(@NotNull Class<? extends T> cls, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(str, "label");
        if (!this.a.containsKey(str)) {
            this.a.put(str, cls);
            return this;
        }
        throw new IllegalArgumentException("types and labels must be unique");
    }
}

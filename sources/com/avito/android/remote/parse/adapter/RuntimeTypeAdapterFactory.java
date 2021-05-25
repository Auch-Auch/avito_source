package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
public class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    @NonNull
    public final Class<?> a;
    @NonNull
    public final String b;
    @NonNull
    public final Map<String, Class<?>> c = new LinkedHashMap();
    @NonNull
    public final Map<String, TypeAdapterFactory> d = new LinkedHashMap();
    @Nullable
    public Class<?> e;

    public RuntimeTypeAdapterFactory(@NonNull Class<?> cls, @NonNull String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.a = cls;
        this.b = str;
    }

    @NonNull
    public static <T> RuntimeTypeAdapterFactory<T> of(@NonNull Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        TypeAdapter<T> typeAdapter;
        final TypeAdapter<T> typeAdapter2 = null;
        if (typeToken.getRawType() != this.a) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap(this.c.size());
        for (Map.Entry<String, Class<?>> entry : this.c.entrySet()) {
            TypeAdapterFactory typeAdapterFactory = this.d.get(entry.getKey());
            if (typeAdapterFactory != null) {
                typeAdapter = typeAdapterFactory.create(gson, TypeToken.get((Class) entry.getValue()));
            } else {
                typeAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            }
            linkedHashMap.put(entry.getKey(), typeAdapter);
        }
        Class<?> cls = this.e;
        if (cls != null) {
            typeAdapter2 = gson.getDelegateAdapter(this, TypeToken.get((Class) cls));
        }
        return new TypeAdapter<R>() { // from class: com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement parse = Streams.parse(jsonReader);
                JsonElement remove = parse.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.b);
                if (remove != null) {
                    TypeAdapter typeAdapter3 = (TypeAdapter) linkedHashMap.get(remove.getAsString());
                    if (typeAdapter3 == null) {
                        typeAdapter3 = typeAdapter2;
                    }
                    if (typeAdapter3 == null) {
                        return null;
                    }
                    return (R) typeAdapter3.fromJsonTree(parse);
                }
                StringBuilder L = a.L("cannot deserialize ");
                L.append(RuntimeTypeAdapterFactory.this.a);
                L.append(" because it does not define a field named ");
                L.append(RuntimeTypeAdapterFactory.this.b);
                throw new JsonParseException(L.toString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, R r) throws IOException {
                throw new UnsupportedOperationException();
            }
        }.nullSafe();
    }

    @NonNull
    public RuntimeTypeAdapterFactory<T> registerFallbackSubtype(@NonNull Class<?> cls) {
        this.e = cls;
        return this;
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(@NonNull Class<? extends T> cls, @NonNull String str, @Nullable TypeAdapterFactory typeAdapterFactory) {
        if (cls == null) {
            throw null;
        } else if (str != null) {
            if (typeAdapterFactory != null) {
                this.d.put(str, typeAdapterFactory);
            }
            if (!this.c.containsKey(str)) {
                this.c.put(str, cls);
                return this;
            }
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            throw null;
        }
    }

    @NonNull
    public static <T> RuntimeTypeAdapterFactory<T> of(@NonNull Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(@NonNull Class<? extends T> cls, @NonNull String str) {
        return registerSubtype(cls, str, null);
    }
}

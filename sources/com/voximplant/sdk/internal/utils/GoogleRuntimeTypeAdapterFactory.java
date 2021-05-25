package com.voximplant.sdk.internal.utils;

import a2.b.a.a.a;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
public final class GoogleRuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    public final Class<?> a;
    public final String b;
    public final Map<String, Class<?>> c = new LinkedHashMap();
    public final Map<Class<?>, String> d = new LinkedHashMap();

    public GoogleRuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.a = cls;
        this.b = str;
    }

    public static <T> GoogleRuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new GoogleRuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.a) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.c.entrySet()) {
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), delegateAdapter);
            linkedHashMap2.put(entry.getValue(), delegateAdapter);
        }
        return new TypeAdapter<R>() { // from class: com.voximplant.sdk.internal.utils.GoogleRuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement parse = Streams.parse(jsonReader);
                JsonElement remove = parse.getAsJsonObject().remove(GoogleRuntimeTypeAdapterFactory.this.b);
                if (remove != null) {
                    String asString = remove.getAsString();
                    TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(asString);
                    if (typeAdapter != null) {
                        return (R) typeAdapter.fromJsonTree(parse);
                    }
                    StringBuilder L = a.L("cannot deserialize ");
                    L.append(GoogleRuntimeTypeAdapterFactory.this.a);
                    L.append(" subtype named ");
                    L.append(asString);
                    L.append("; did you forget to register a subtype?");
                    throw new JsonParseException(L.toString());
                }
                StringBuilder L2 = a.L("cannot deserialize ");
                L2.append(GoogleRuntimeTypeAdapterFactory.this.a);
                L2.append(" because it does not define a field named ");
                L2.append(GoogleRuntimeTypeAdapterFactory.this.b);
                throw new JsonParseException(L2.toString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls = r.getClass();
                String str = GoogleRuntimeTypeAdapterFactory.this.d.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter != null) {
                    JsonObject asJsonObject = typeAdapter.toJsonTree(r).getAsJsonObject();
                    if (!asJsonObject.has(GoogleRuntimeTypeAdapterFactory.this.b)) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.add(GoogleRuntimeTypeAdapterFactory.this.b, new JsonPrimitive(str));
                        for (Map.Entry<String, JsonElement> entry2 : asJsonObject.entrySet()) {
                            jsonObject.add(entry2.getKey(), entry2.getValue());
                        }
                        Streams.write(jsonObject, jsonWriter);
                        return;
                    }
                    StringBuilder L = a.L("cannot serialize ");
                    L.append(cls.getName());
                    L.append(" because it already defines a field named ");
                    L.append(GoogleRuntimeTypeAdapterFactory.this.b);
                    throw new JsonParseException(L.toString());
                }
                throw new JsonParseException(a.D2(cls, a.L("cannot serialize "), "; did you forget to register a subtype?"));
            }
        }.nullSafe();
    }

    public GoogleRuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null) {
            throw null;
        } else if (str == null) {
            throw null;
        } else if (this.d.containsKey(cls) || this.c.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.c.put(str, cls);
            this.d.put(cls, str);
            return this;
        }
    }

    public static <T> GoogleRuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new GoogleRuntimeTypeAdapterFactory<>(cls, "type");
    }

    public GoogleRuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }
}

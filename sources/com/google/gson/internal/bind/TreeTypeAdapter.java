package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public final JsonSerializer<T> a;
    public final JsonDeserializer<T> b;
    public final Gson c;
    public final TypeToken<T> d;
    public final TypeAdapterFactory e;
    public final TreeTypeAdapter<T>.b f = new b(null);
    public TypeAdapter<T> g;

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        public final TypeToken<?> a;
        public final boolean b;
        public final Class<?> c;
        public final JsonSerializer<?> d;
        public final JsonDeserializer<?> e;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonDeserializer<?> jsonDeserializer = null;
            JsonSerializer<?> jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.d = jsonSerializer;
            jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            this.e = jsonDeserializer;
            C$Gson$Preconditions.checkArgument((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.a = typeToken;
            this.b = z;
            this.c = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            TypeToken<?> typeToken2 = this.a;
            if (typeToken2 != null) {
                z = typeToken2.equals(typeToken) || (this.b && this.a.getType() == typeToken.getRawType());
            } else {
                z = this.c.isAssignableFrom(typeToken.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.d, this.e, gson, typeToken, this);
            }
            return null;
        }
    }

    public final class b implements JsonSerializationContext, JsonDeserializationContext {
        public b(a aVar) {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.c.toJsonTree(obj, type);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.a = jsonSerializer;
        this.b = jsonDeserializer;
        this.c = gson;
        this.d = typeToken;
        this.e = typeAdapterFactory;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.b == null) {
            TypeAdapter<T> typeAdapter = this.g;
            if (typeAdapter == null) {
                typeAdapter = this.c.getDelegateAdapter(this.e, this.d);
                this.g = typeAdapter;
            }
            return typeAdapter.read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.b.deserialize(parse, this.d.getType(), this.f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.a;
        if (jsonSerializer == null) {
            TypeAdapter<T> typeAdapter = this.g;
            if (typeAdapter == null) {
                typeAdapter = this.c.getDelegateAdapter(this.e, this.d);
                this.g = typeAdapter;
            }
            typeAdapter.write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t, this.d.getType(), this.f), jsonWriter);
        }
    }
}

package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final ConstructorConstructor a;
    public final FieldNamingStrategy b;
    public final Excluder c;
    public final JsonAdapterAnnotationTypeAdapterFactory d;
    public final ReflectionAccessor e = ReflectionAccessor.getInstance();

    public static final class Adapter<T> extends TypeAdapter<T> {
        public final ObjectConstructor<T> a;
        public final Map<String, a> b;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, a> map) {
            this.a = objectConstructor;
            this.b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.a.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    a aVar = this.b.get(jsonReader.nextName());
                    if (aVar != null) {
                        if (aVar.c) {
                            aVar.a(jsonReader, construct);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (a aVar : this.b.values()) {
                    if (aVar.c(t)) {
                        jsonWriter.name(aVar.a);
                        aVar.b(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static abstract class a {
        public final String a;
        public final boolean b;
        public final boolean c;

        public a(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public abstract void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        public abstract void b(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.a = constructorConstructor;
        this.b = fieldNamingStrategy;
        this.c = excluder;
        this.d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0198 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0180 A[SYNTHETIC] */
    @Override // com.google.gson.TypeAdapterFactory
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson r36, com.google.gson.reflect.TypeToken<T> r37) {
        /*
        // Method dump skipped, instructions count: 483
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public boolean excludeField(Field field, boolean z) {
        Excluder excluder = this.c;
        return !excluder.excludeClass(field.getType(), z) && !excluder.excludeField(field, z);
    }
}

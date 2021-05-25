package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    public double a = -1.0d;
    public int b = 136;
    public boolean c = true;
    public boolean d;
    public List<ExclusionStrategy> e = Collections.emptyList();
    public List<ExclusionStrategy> f = Collections.emptyList();

    public final boolean a(Class<?> cls) {
        if (this.a != -1.0d && !e((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((this.c || !d(cls)) && !c(cls)) {
            return false;
        }
        return true;
    }

    public final boolean b(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.e : this.f) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean a3 = a(rawType);
        final boolean z = a3 || b(rawType, true);
        final boolean z2 = a3 || b(rawType, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
                public TypeAdapter<T> a;

                @Override // com.google.gson.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (z2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    TypeAdapter<T> typeAdapter = this.a;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.a = typeAdapter;
                    }
                    return typeAdapter.read(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (z) {
                        jsonWriter.nullValue();
                        return;
                    }
                    TypeAdapter<T> typeAdapter = this.a;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.a = typeAdapter;
                    }
                    typeAdapter.write(jsonWriter, t);
                }
            };
        }
        return null;
    }

    public final boolean d(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.c = false;
        return clone;
    }

    public final boolean e(Since since, Until until) {
        if (!(since == null || since.value() <= this.a)) {
            return false;
        }
        if (until == null || until.value() > this.a) {
            return true;
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.b & field.getModifiers()) != 0) {
            return true;
        }
        if (!(this.a == -1.0d || e((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.d && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.c && d(field.getType())) || c(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        for (ExclusionStrategy exclusionStrategy : list) {
            if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.d = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.e);
            clone.e = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f);
            clone.f = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.b = 0;
        for (int i : iArr) {
            clone.b = i | clone.b;
        }
        return clone;
    }

    public Excluder withVersion(double d2) {
        Excluder clone = clone();
        clone.a = d2;
        return clone;
    }

    @Override // java.lang.Object
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}

package a2.j.e.g.a;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
public final class d implements ObjectEncoderContext, ValueEncoderContext {
    public d a = null;
    public boolean b = true;
    public final JsonWriter c;
    public final Map<Class<?>, ObjectEncoder<?>> d;
    public final Map<Class<?>, ValueEncoder<?>> e;
    public final ObjectEncoder<Object> f;
    public final boolean g;

    public d(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = objectEncoder;
        this.g = z;
    }

    @NonNull
    public d a(long j) throws IOException {
        e();
        this.c.value(j);
        return this;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0032: APUT  (r1v15 java.lang.Object[]), (0 ??[int, short, byte, char]), (r6v23 java.lang.Class<?>) */
    @NonNull
    public d b(@Nullable Object obj, boolean z) throws IOException {
        Class<?> cls;
        int i = 0;
        if (z) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                if (obj == null) {
                    cls = null;
                } else {
                    cls = obj.getClass();
                }
                objArr[0] = cls;
                throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                d((byte[]) obj);
                return this;
            }
            this.c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i < length) {
                    this.c.value((long) iArr[i]);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i < length2) {
                    a(jArr[i]);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i < length3) {
                    this.c.value(dArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i < length4) {
                    this.c.value(zArr[i]);
                    i++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    b(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    b(obj2, false);
                }
            }
            this.c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.c.beginArray();
            for (Object obj3 : (Collection) obj) {
                b(obj3, false);
            }
            this.c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                }
            }
            this.c.endObject();
            return this;
        } else {
            ObjectEncoder<?> objectEncoder = this.d.get(obj.getClass());
            if (objectEncoder != null) {
                if (!z) {
                    this.c.beginObject();
                }
                objectEncoder.encode(obj, this);
                if (!z) {
                    this.c.endObject();
                }
                return this;
            }
            ValueEncoder<?> valueEncoder = this.e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                String name = ((Enum) obj).name();
                e();
                this.c.value(name);
                return this;
            } else {
                ObjectEncoder<Object> objectEncoder2 = this.f;
                if (!z) {
                    this.c.beginObject();
                }
                objectEncoder2.encode(obj, this);
                if (!z) {
                    this.c.endObject();
                }
                return this;
            }
        }
    }

    @NonNull
    /* renamed from: c */
    public d add(@NonNull String str, @Nullable Object obj) throws IOException {
        if (!this.g) {
            e();
            this.c.name(str);
            if (obj != null) {
                return b(obj, false);
            }
            this.c.nullValue();
            return this;
        } else if (obj == null) {
            return this;
        } else {
            e();
            this.c.name(str);
            return b(obj, false);
        }
    }

    @NonNull
    public d d(@Nullable byte[] bArr) throws IOException {
        e();
        if (bArr == null) {
            this.c.nullValue();
        } else {
            this.c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final void e() throws IOException {
        if (this.b) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.e();
                this.a.b = false;
                this.a = null;
                this.c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        return b(obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) throws IOException {
        e();
        this.a = new d(this);
        this.c.name(str);
        this.c.beginObject();
        return this.a;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(@Nullable byte[] bArr) throws IOException {
        d(bArr);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, double d2) throws IOException {
        e();
        this.c.name(str);
        e();
        this.c.value(d2);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, int i) throws IOException {
        e();
        this.c.name(str);
        e();
        this.c.value((long) i);
        return this;
    }

    public d(d dVar) {
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, long j) throws IOException {
        e();
        this.c.name(str);
        e();
        this.c.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext add(@NonNull String str, boolean z) throws IOException {
        e();
        this.c.name(str);
        e();
        this.c.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(@Nullable String str) throws IOException {
        e();
        this.c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(double d2) throws IOException {
        e();
        this.c.value(d2);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(int i) throws IOException {
        e();
        this.c.value((long) i);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(long j) throws IOException {
        e();
        this.c.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(boolean z) throws IOException {
        e();
        this.c.value(z);
        return this;
    }
}

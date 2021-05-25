package com.google.firebase.encoders.json;

import a2.j.e.g.a.c;
import a2.j.e.g.a.d;
import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    public static final b e = new b(null);
    public final Map<Class<?>, ObjectEncoder<?>> a = new HashMap();
    public final Map<Class<?>, ValueEncoder<?>> b = new HashMap();
    public ObjectEncoder<Object> c = a2.j.e.g.a.a.a;
    public boolean d = false;

    public static final class b implements ValueEncoder<Date> {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b(a aVar) {
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        public void encode(@NonNull Object obj, @NonNull Object obj2) throws IOException {
            ((ValueEncoderContext) obj2).add(a.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) a2.j.e.g.a.b.a);
        registerEncoder(Boolean.class, (ValueEncoder) c.a);
        registerEncoder(Date.class, (ValueEncoder) e);
    }

    @NonNull
    public DataEncoder build() {
        return new a();
    }

    @NonNull
    public JsonDataEncoderBuilder configureWith(@NonNull Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder ignoreNullValues(boolean z) {
        this.d = z;
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.c = objectEncoder;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.a.put(cls, objectEncoder);
        this.b.remove(cls);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.b.put(cls, valueEncoder);
        this.a.remove(cls);
        return this;
    }

    public class a implements DataEncoder {
        public a() {
        }

        @Override // com.google.firebase.encoders.DataEncoder
        public void encode(@NonNull Object obj, @NonNull Writer writer) throws IOException {
            JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
            d dVar = new d(writer, jsonDataEncoderBuilder.a, jsonDataEncoderBuilder.b, jsonDataEncoderBuilder.c, jsonDataEncoderBuilder.d);
            dVar.b(obj, false);
            dVar.e();
            dVar.c.flush();
        }

        @Override // com.google.firebase.encoders.DataEncoder
        public String encode(@NonNull Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                encode(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }
}

package retrofit2.converter.protobuf;

import a2.b.a.a.a;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
public final class ProtoConverterFactory extends Converter.Factory {
    @Nullable
    private final ExtensionRegistryLite registry;

    private ProtoConverterFactory(@Nullable ExtensionRegistryLite extensionRegistryLite) {
        this.registry = extensionRegistryLite;
    }

    public static ProtoConverterFactory create() {
        return new ProtoConverterFactory(null);
    }

    public static ProtoConverterFactory createWithRegistry(@Nullable ExtensionRegistryLite extensionRegistryLite) {
        return new ProtoConverterFactory(extensionRegistryLite);
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if ((type instanceof Class) && MessageLite.class.isAssignableFrom((Class) type)) {
            return new ProtoRequestBodyConverter();
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Parser parser;
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!MessageLite.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            parser = (Parser) cls.getDeclaredMethod("parser", new Class[0]).invoke(null, new Object[0]);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            try {
                parser = (Parser) cls.getDeclaredField("PARSER").get(null);
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                throw new IllegalArgumentException(a.D2(cls, a.L("Found a protobuf message but "), " had no parser() method or PARSER field."), e2);
            }
        }
        return new ProtoResponseBodyConverter(parser, this.registry);
    }
}

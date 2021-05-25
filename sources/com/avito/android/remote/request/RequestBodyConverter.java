package com.avito.android.remote.request;

import com.avito.android.util.RequestUtils;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.inject.Named;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
public class RequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final MediaType b = MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8");
    public final Annotation[] a;

    public RequestBodyConverter(Type type, Annotation[] annotationArr) {
        this.a = annotationArr;
    }

    public final RequestBody a(T t) {
        Annotation[] annotationArr = this.a;
        String str = "";
        if (annotationArr != null) {
            int i = 0;
            while (true) {
                if (i >= annotationArr.length) {
                    break;
                }
                Annotation annotation = annotationArr[i];
                if (Named.class.equals(annotation.annotationType())) {
                    str = ((Named) annotation).value();
                    break;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        RequestUtils.appendEncodedParam(sb, str, t);
        return RequestBody.create(b, sb.toString());
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t) throws IOException {
        if (t == null) {
            return a(t);
        }
        if (t.getClass().isArray()) {
            return a(t);
        }
        throw new UnsupportedOperationException(t.getClass() + " is unsupported");
    }
}

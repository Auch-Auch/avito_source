package com.avito.android.remote.parse.adapter.stream_gson;

import android.os.SystemClock;
import com.avito.android.remote.InvalidSchemaException;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.parse.ParsingAnalytics;
import com.avito.android.util.Logs;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/StreamGsonResponseParserConverter;", "F", "T", "Lretrofit2/Converter;", "value", "convert", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/io/Reader;", "reader", AuthSource.SEND_ABUSE, "(Ljava/io/Reader;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", AuthSource.BOOKING_ORDER, "Ljava/lang/reflect/Type;", "type", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/remote/parse/ParsingAnalytics;", "c", "Lcom/avito/android/remote/parse/ParsingAnalytics;", "analytics", "<init>", "(Lcom/google/gson/Gson;Ljava/lang/reflect/Type;Lcom/avito/android/remote/parse/ParsingAnalytics;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class StreamGsonResponseParserConverter<F, T> implements Converter<F, T> {
    public final Gson a;
    public final Type b;
    public final ParsingAnalytics c;

    public StreamGsonResponseParserConverter(@NotNull Gson gson, @NotNull Type type, @NotNull ParsingAnalytics parsingAnalytics) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parsingAnalytics, "analytics");
        this.a = gson;
        this.b = type;
        this.c = parsingAnalytics;
    }

    public final T a(Reader reader) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            T t = (T) this.a.fromJson(reader, this.b);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            this.c.send(this.b, elapsedRealtime2);
            Logs.debug$default("NewGsonResponseParserConverter", this.b + ": " + elapsedRealtime2, null, 4, null);
            return t;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // retrofit2.Converter
    @Nullable
    public T convert(F f) {
        if (!(f instanceof ResponseBody)) {
            return null;
        }
        F f2 = f;
        try {
            T a3 = a(f2.charStream());
            f2.close();
            return a3;
        } catch (InvalidSchemaException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            f2.close();
            throw th;
        }
    }
}

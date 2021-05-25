package com.avito.android.jsonrpc.client;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BG\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b!\u0010\"J!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcServiceBuilder;", "T", "B", "", "Lcom/avito/android/jsonrpc/client/JsonRpcInterceptor;", "interceptor", "addInterceptor", "(Lcom/avito/android/jsonrpc/client/JsonRpcInterceptor;)Lcom/avito/android/jsonrpc/client/JsonRpcServiceBuilder;", "build", "()Ljava/lang/Object;", "Lkotlin/Function1;", "", "", "e", "Lkotlin/jvm/functions/Function1;", "logger", "Ljava/lang/Class;", AuthSource.BOOKING_ORDER, "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", AuthSource.SEND_ABUSE, "Ljava/util/ArrayList;", "interceptors", "Lcom/avito/android/jsonrpc/client/Deserializer;", "d", "Lcom/avito/android/jsonrpc/client/Deserializer;", "resultDeserializer", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "c", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "client", "<init>", "(Ljava/lang/Class;Lcom/avito/android/jsonrpc/client/JsonRpcClient;Lcom/avito/android/jsonrpc/client/Deserializer;Lkotlin/jvm/functions/Function1;)V", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcServiceBuilder<T, B> {
    public final ArrayList<JsonRpcInterceptor> a;
    public final Class<T> b;
    public final JsonRpcClient<B> c;
    public final Deserializer<B> d;
    public Function1<? super String, Unit> e;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return Unit.INSTANCE;
        }
    }

    public JsonRpcServiceBuilder(@NotNull Class<T> cls, @NotNull JsonRpcClient<B> jsonRpcClient, @NotNull Deserializer<B> deserializer, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
        Intrinsics.checkNotNullParameter(deserializer, "resultDeserializer");
        Intrinsics.checkNotNullParameter(function1, "logger");
        this.b = cls;
        this.c = jsonRpcClient;
        this.d = deserializer;
        this.e = function1;
        this.a = new ArrayList<>();
    }

    @NotNull
    public final JsonRpcServiceBuilder<T, B> addInterceptor(@NotNull JsonRpcInterceptor jsonRpcInterceptor) {
        Intrinsics.checkNotNullParameter(jsonRpcInterceptor, "interceptor");
        this.a.add(jsonRpcInterceptor);
        return this;
    }

    public final T build() {
        return (T) Proxy.newProxyInstance(this.b.getClassLoader(), new Class[]{this.b}, new JsonRpcInvocationHandler(this.b, this.c, this.d, this.e, this.a));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonRpcServiceBuilder(Class cls, JsonRpcClient jsonRpcClient, Deserializer deserializer, Function1 function1, int i, j jVar) {
        this(cls, jsonRpcClient, deserializer, (i & 8) != 0 ? a.a : function1);
    }
}

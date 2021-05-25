package com.avito.android.jsonrpc.client;

import androidx.core.app.NotificationCompat;
import com.avito.android.jsonrpc.annotations.JsonRpcBody;
import com.avito.android.jsonrpc.annotations.JsonRpcMethod;
import com.avito.android.jsonrpc.annotations.JsonRpcMethodCall;
import com.avito.android.jsonrpc.annotations.JsonRpcMethodName;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001)BS\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b'\u0010(J2\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcInvocationHandler;", "T", "B", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "", "Lcom/avito/android/jsonrpc/client/JsonRpcInterceptor;", "f", "Ljava/util/List;", "interceptors", "Ljava/lang/Class;", AuthSource.BOOKING_ORDER, "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "Lcom/avito/android/jsonrpc/client/Deserializer;", "d", "Lcom/avito/android/jsonrpc/client/Deserializer;", "resultDeserializer", "Ljava/util/concurrent/atomic/AtomicLong;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/atomic/AtomicLong;", "requestId", "Lkotlin/Function1;", "", "", "e", "Lkotlin/jvm/functions/Function1;", "logger", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "c", "Lcom/avito/android/jsonrpc/client/JsonRpcClient;", "client", "<init>", "(Ljava/lang/Class;Lcom/avito/android/jsonrpc/client/JsonRpcClient;Lcom/avito/android/jsonrpc/client/Deserializer;Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "Companion", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcInvocationHandler<T, B> implements InvocationHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final AtomicLong a = new AtomicLong(0);
    public final Class<T> b;
    public final JsonRpcClient<B> c;
    public final Deserializer<B> d;
    public final Function1<String, Unit> e;
    public final List<JsonRpcInterceptor> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/jsonrpc/client/JsonRpcInvocationHandler$Companion;", "", "<init>", "()V", "jsonrpc"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final /* synthetic */ Annotation access$getAnnotation(Companion companion, Method method) {
            Objects.requireNonNull(companion);
            Intrinsics.reifiedOperationMarker(4, "T");
            return method.getAnnotation(Annotation.class);
        }

        public static final Type access$getResultGenericTypeArgument$p(Companion companion, Method method) {
            Objects.requireNonNull(companion);
            Type genericReturnType = method.getGenericReturnType();
            Objects.requireNonNull(genericReturnType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "(genericReturnType as Pa…Type).actualTypeArguments");
            Object first = ArraysKt___ArraysKt.first(actualTypeArguments);
            Intrinsics.checkNotNullExpressionValue(first, "(genericReturnType as Pa…tualTypeArguments.first()");
            return (Type) first;
        }

        public static final boolean access$getReturnsSingle$p(Companion companion, Method method) {
            Objects.requireNonNull(companion);
            Class<?> returnType = method.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "returnType");
            return Intrinsics.areEqual(returnType.getCanonicalName(), Single.class.getCanonicalName());
        }

        public static final Pair access$jsonRpcNameAndParamsBody(Companion companion, Method method, Object[] objArr, Class cls) {
            Objects.requireNonNull(companion);
            if (method.getParameterAnnotations().length == 2) {
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "parameterAnnotations");
                ArrayList arrayList = new ArrayList(parameterAnnotations.length);
                int length = parameterAnnotations.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    Annotation annotation = null;
                    if (i2 >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    if (annotationArr != null) {
                        int length2 = annotationArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                break;
                            }
                            Annotation annotation2 = annotationArr[i3];
                            Companion companion2 = JsonRpcInvocationHandler.Companion;
                            Intrinsics.checkNotNullExpressionValue(annotation2, AuthSource.SEND_ABUSE);
                            if (JsonRpcMethodName.class.isInstance(annotation2) || JsonRpcBody.class.isInstance(annotation2)) {
                                annotation = annotation2;
                                break;
                            }
                            i3++;
                        }
                    }
                    arrayList.add(annotation);
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                String str = null;
                Object obj = null;
                while (it.hasNext()) {
                    Object next = it.next();
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Annotation annotation3 = (Annotation) next;
                    if (annotation3 instanceof JsonRpcMethodName) {
                        String str2 = objArr != null ? objArr[i] : null;
                        if (!(str2 instanceof String)) {
                            str2 = null;
                        }
                        str = str2;
                        if (str == null) {
                            StringBuilder L = a2.b.a.a.a.L("Method name passed to ");
                            L.append(cls.getName());
                            L.append('#');
                            L.append(method.getName());
                            L.append("() must be a String");
                            throw new IllegalStateException(L.toString().toString());
                        }
                    } else if (!(annotation3 instanceof JsonRpcBody)) {
                        StringBuilder M = a2.b.a.a.a.M("Argument #", i, " of ");
                        M.append(cls.getName());
                        M.append('#');
                        M.append(method.getName());
                        M.append("()");
                        M.append(" must be annotated with @JsonRpcMethodName or @JsonRpcBody");
                        throw new IllegalStateException(M.toString().toString());
                    } else if (objArr == null || (obj = objArr[i]) == null) {
                        StringBuilder L2 = a2.b.a.a.a.L("JsonRpcBody passed to ");
                        L2.append(cls.getName());
                        L2.append('#');
                        L2.append(method.getName());
                        L2.append("() must not be null");
                        throw new IllegalStateException(L2.toString().toString());
                    }
                    arrayList2.add(Unit.INSTANCE);
                    i = i4;
                }
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("methodName");
                }
                if (obj == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(SDKConstants.PARAM_A2U_BODY);
                }
                return TuplesKt.to(str, obj);
            }
            throw new IllegalStateException((cls.getName() + '#' + method.getName() + "() is annotated with @JsonRpcMethodCall so it must have exactly 2 parameters").toString());
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x013e */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final java.util.Map access$jsonRpcParameters(com.avito.android.jsonrpc.client.JsonRpcInvocationHandler.Companion r15, java.lang.reflect.Method r16, java.lang.Object[] r17, java.lang.Class r18) {
            /*
            // Method dump skipped, instructions count: 462
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.jsonrpc.client.JsonRpcInvocationHandler.Companion.access$jsonRpcParameters(com.avito.android.jsonrpc.client.JsonRpcInvocationHandler$Companion, java.lang.reflect.Method, java.lang.Object[], java.lang.Class):java.util.Map");
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<B, Object> {
        public final /* synthetic */ JsonRpcInvocationHandler a;
        public final /* synthetic */ Method b;
        public final /* synthetic */ Type c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JsonRpcInvocationHandler jsonRpcInvocationHandler, Method method, Type type) {
            super(1);
            this.a = jsonRpcInvocationHandler;
            this.b = method;
            this.c = type;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Object invoke(B b2) {
            if (!Companion.access$getReturnsSingle$p(JsonRpcInvocationHandler.Companion, this.b) || !(!Intrinsics.areEqual(this.c, Unit.class))) {
                return Unit.INSTANCE;
            }
            Function1 function1 = this.a.e;
            StringBuilder L = a2.b.a.a.a.L("JsonRPC: Parsing ");
            L.append(this.c);
            L.append(" from result=");
            L.append((Object) b2);
            function1.invoke(L.toString());
            Object deserialize = this.a.d.deserialize(this.c, b2);
            if (deserialize != null) {
                return deserialize;
            }
            throw new NullJsonRpcCallResultException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.jsonrpc.client.JsonRpcInterceptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonRpcInvocationHandler(@NotNull Class<T> cls, @NotNull JsonRpcClient<B> jsonRpcClient, @NotNull Deserializer<B> deserializer, @NotNull Function1<? super String, Unit> function1, @NotNull List<? extends JsonRpcInterceptor> list) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(jsonRpcClient, "client");
        Intrinsics.checkNotNullParameter(deserializer, "resultDeserializer");
        Intrinsics.checkNotNullParameter(function1, "logger");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        this.b = cls;
        this.c = jsonRpcClient;
        this.d = deserializer;
        this.e = function1;
        this.f = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    @NotNull
    public Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) throws Throwable {
        Pair pair;
        Intrinsics.checkNotNullParameter(obj, "proxy");
        Intrinsics.checkNotNullParameter(method, "method");
        Companion companion = Companion;
        Annotation annotation = (JsonRpcMethod) method.getAnnotation(JsonRpcMethod.class);
        if (annotation == null) {
            annotation = method.getAnnotation(JsonRpcMethodCall.class);
        }
        if (annotation == null) {
            Object invoke = method.invoke(method, objArr);
            Intrinsics.checkNotNullExpressionValue(invoke, "invoke(this, args)");
            return invoke;
        } else if (Companion.access$getReturnsSingle$p(companion, method)) {
            long incrementAndGet = this.a.incrementAndGet();
            if (annotation instanceof JsonRpcMethod) {
                pair = TuplesKt.to(((JsonRpcMethod) annotation).value(), Companion.access$jsonRpcParameters(companion, method, objArr, this.b));
            } else if (annotation instanceof JsonRpcMethodCall) {
                pair = Companion.access$jsonRpcNameAndParamsBody(companion, method, objArr, this.b);
            } else {
                throw new IllegalStateException("Only @JsonRpcMethod & @JsonRpcMethodCall method annotations are supported".toString());
            }
            RpcRequest rpcRequest = new RpcRequest(incrementAndGet, (String) pair.component1(), pair.component2());
            Type access$getResultGenericTypeArgument$p = Companion.access$getResultGenericTypeArgument$p(companion, method);
            Iterator<T> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().intercept(rpcRequest, method);
            }
            Function1<String, Unit> function1 = this.e;
            function1.invoke("JsonRPC: Calling: " + rpcRequest);
            return this.c.call(rpcRequest, new a(this, method, access$getResultGenericTypeArgument$p));
        } else {
            throw new IllegalStateException("Only io.reactivex.Single<T> is supported as return type".toString());
        }
    }
}

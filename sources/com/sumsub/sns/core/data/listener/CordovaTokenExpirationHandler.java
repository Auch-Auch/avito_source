package com.sumsub.sns.core.data.listener;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/listener/CordovaTokenExpirationHandler;", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "", "onTokenExpired", "()Ljava/lang/String;", "onTokenExpiredMain", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class CordovaTokenExpirationHandler implements TokenExpirationHandler {

    @DebugMetadata(c = "com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$onTokenExpired$1", f = "TokenExpirationHandler.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        public int b;
        public final /* synthetic */ CordovaTokenExpirationHandler c;

        @DebugMetadata(c = "com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$onTokenExpired$1$1", f = "TokenExpirationHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$a$a  reason: collision with other inner class name */
        public static final class C0318a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            public final /* synthetic */ a b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0318a(a aVar, Continuation continuation) {
                super(2, continuation);
                this.b = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new C0318a(this.b, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                Continuation<? super String> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                C0318a aVar = new C0318a(this.b, continuation2);
                Unit unit = Unit.INSTANCE;
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(unit);
                return aVar.b.c.onTokenExpiredMain();
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                t6.p.a.a.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                return this.b.c.onTokenExpiredMain();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CordovaTokenExpirationHandler cordovaTokenExpirationHandler, Continuation continuation) {
            super(2, continuation);
            this.c = cordovaTokenExpirationHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.c, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            Continuation<? super String> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.c, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C0318a aVar = new C0318a(this, null);
                this.b = 1;
                obj = BuildersKt.withContext(main, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @Override // com.sumsub.sns.core.data.listener.TokenExpirationHandler
    @Nullable
    public String onTokenExpired() {
        return (String) BuildersKt.runBlocking$default(null, new a(this, null), 1, null);
    }

    @Nullable
    public abstract String onTokenExpiredMain();
}

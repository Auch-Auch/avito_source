package kotlinx.coroutines.channels;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\r\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "ticker", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "channel", AuthSource.BOOKING_ORDER, "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AuthSource.SEND_ABUSE, "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TickerMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public long c;
        public long d;
        public Object e;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return TickerChannelsKt.a(0, 0, null, this);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"delayMillis", "initialDelayMillis", "channel", "deadline", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay"}, s = {"J$0", "J$1", "L$0", "J$2", "J$0", "J$1", "L$0", "J$2", "J$3", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5", "J$6", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public Object j;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return TickerChannelsKt.b(0, 0, null, this);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {0, 1}, l = {72, 73}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"})
    public static final class c extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        public ProducerScope b;
        public Object c;
        public int d;
        public final /* synthetic */ TickerMode e;
        public final /* synthetic */ long f;
        public final /* synthetic */ long g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(TickerMode tickerMode, long j, long j2, Continuation continuation) {
            super(2, continuation);
            this.e = tickerMode;
            this.f = j;
            this.g = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            c cVar = new c(this.e, this.f, this.g, continuation);
            cVar.b = (ProducerScope) obj;
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            c cVar = new c(this.e, this.f, this.g, continuation);
            cVar.b = producerScope;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = this.b;
                int ordinal = this.e.ordinal();
                if (ordinal == 0) {
                    long j = this.f;
                    long j2 = this.g;
                    SendChannel channel = producerScope.getChannel();
                    this.c = producerScope;
                    this.d = 1;
                    if (TickerChannelsKt.b(j, j2, channel, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (ordinal == 1) {
                    long j3 = this.f;
                    long j4 = this.g;
                    SendChannel channel2 = producerScope.getChannel();
                    this.c = producerScope;
                    this.d = 2;
                    if (TickerChannelsKt.a(j3, j4, channel2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1 || i == 2) {
                ProducerScope producerScope2 = (ProducerScope) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object a(long r8, long r10, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.TickerChannelsKt.a
            if (r0 == 0) goto L_0x0013
            r0 = r13
            kotlinx.coroutines.channels.TickerChannelsKt$a r0 = (kotlinx.coroutines.channels.TickerChannelsKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.TickerChannelsKt$a r0 = new kotlinx.coroutines.channels.TickerChannelsKt$a
            r0.<init>(r13)
        L_0x0018:
            java.lang.Object r13 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 2
            r5 = 3
            if (r2 == 0) goto L_0x0058
            if (r2 == r3) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r5) goto L_0x0037
            java.lang.Object r8 = r0.e
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.d
            long r11 = r0.c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x008e
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            java.lang.Object r8 = r0.e
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.d
            long r11 = r0.c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007f
        L_0x004b:
            java.lang.Object r8 = r0.e
            r12 = r8
            kotlinx.coroutines.channels.SendChannel r12 = (kotlinx.coroutines.channels.SendChannel) r12
            long r10 = r0.d
            long r8 = r0.c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006a
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.c = r8
            r0.d = r10
            r0.e = r12
            r0.b = r3
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r13 != r1) goto L_0x006a
            return r1
        L_0x006a:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r0.c = r8
            r0.d = r10
            r0.e = r12
            r0.b = r4
            java.lang.Object r13 = r12.send(r13, r0)
            if (r13 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L_0x007f:
            r0.c = r11
            r0.d = r9
            r0.e = r8
            r0.b = r5
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r11, r0)
            if (r13 != r1) goto L_0x008e
            return r1
        L_0x008e:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.a(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object b(long r22, long r24, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.b(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long j, long j2, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new c(tickerMode, j, j2, null));
            }
            throw new IllegalArgumentException(a2.b.a.a.a.V2("Expected non-negative initial delay, but has ", j2, " ms").toString());
        }
        throw new IllegalArgumentException(a2.b.a.a.a.V2("Expected non-negative delay, but has ", j, " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }
}

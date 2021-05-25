package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u6.a.h0.a0;
import u6.a.h0.b0;
import u6.a.h0.c;
import u6.a.h0.e;
import u6.a.h0.f;
import u6.a.h0.f0;
import u6.a.h0.h;
import u6.a.h0.i;
import u6.a.h0.i0;
import u6.a.h0.j;
import u6.a.h0.j0;
import u6.a.h0.k;
import u6.a.h0.n;
import u6.a.h0.n0;
import u6.a.h0.o;
import u6.a.h0.o0;
import u6.a.h0.p;
import u6.a.h0.p0;
import u6.a.h0.q;
import u6.a.h0.v;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class ChannelsKt {
    @NotNull
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    /* JADX WARN: Type inference failed for: r7v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object all(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.all(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        cancelConsumed(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object any(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof u6.a.h0.d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            u6.a.h0.d r0 = (u6.a.h0.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            u6.a.h0.d r0 = new u6.a.h0.d
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r5 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r5 = r0.d
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r0 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0059 }
            goto L_0x0054
        L_0x0036:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()
            r0.c = r5
            r0.d = r5
            r0.e = r5
            r0.b = r3
            java.lang.Object r6 = r6.hasNext(r0)
            if (r6 != r1) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            cancelConsumed(r5, r4)
            r1 = r6
        L_0x0058:
            return r1
        L_0x0059:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005b }
        L_0x005b:
            r0 = move-exception
            cancelConsumed(r5, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.any(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r14v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V> java.lang.Object associate(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends kotlin.Pair<? extends K, ? extends V>> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<K, ? extends V>> r14) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associate(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r14v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K> java.lang.Object associateBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<K, ? extends E>> r14) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associateBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r14v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, M extends java.util.Map<? super K, ? super E>> java.lang.Object associateByTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull M r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r14) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associateByTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r14v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object associateTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull M r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends kotlin.Pair<? extends K, ? extends V>> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r14) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associateTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.concurrent.CancellationException */
    /* JADX WARN: Multi-variable type inference failed */
    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = th;
            }
            cancellationException = cancellationException;
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        CancellationException cancellationException = null;
        int i = 1;
        try {
            return (R) function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(i);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, cancellationException, i, (Object) cancellationException);
            InlineMarker.finallyEnd(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[Catch:{ all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<E> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 != r4) goto L_0x004a
            java.lang.Object r9 = r0.h
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r0.g
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r2 = r0.f
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r5 = r0.e
            kotlinx.coroutines.channels.BroadcastChannel r5 = (kotlinx.coroutines.channels.BroadcastChannel) r5
            java.lang.Object r6 = r0.d
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.c
            kotlinx.coroutines.channels.BroadcastChannel r7 = (kotlinx.coroutines.channels.BroadcastChannel) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x00a0 }
            r8 = r0
            r0 = r9
            r9 = r7
            r7 = r2
            r2 = r10
            r10 = r5
            r5 = r1
            r1 = r8
            goto L_0x007c
        L_0x004a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.channels.ReceiveChannel r2 = r9.openSubscription()
            kotlinx.coroutines.channels.ChannelIterator r11 = r2.iterator()
            r5 = r1
            r6 = r2
            r1 = r0
            r0 = r10
            r10 = r9
        L_0x0062:
            r1.c = r9     // Catch:{ all -> 0x009e }
            r1.d = r0     // Catch:{ all -> 0x009e }
            r1.e = r10     // Catch:{ all -> 0x009e }
            r1.f = r6     // Catch:{ all -> 0x009e }
            r1.g = r2     // Catch:{ all -> 0x009e }
            r1.h = r11     // Catch:{ all -> 0x009e }
            r1.b = r4     // Catch:{ all -> 0x009e }
            java.lang.Object r7 = r11.hasNext(r1)     // Catch:{ all -> 0x009e }
            if (r7 != r5) goto L_0x0077
            goto L_0x009a
        L_0x0077:
            r8 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r8
        L_0x007c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x009b }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x009b }
            if (r11 == 0) goto L_0x008f
            java.lang.Object r11 = r0.next()     // Catch:{ all -> 0x009b }
            r6.invoke(r11)     // Catch:{ all -> 0x009b }
            r11 = r0
            r0 = r6
            r6 = r7
            goto L_0x0062
        L_0x008f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009b }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
        L_0x009a:
            return r5
        L_0x009b:
            r9 = move-exception
            r6 = r7
            goto L_0x00a2
        L_0x009e:
            r9 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r9 = move-exception
            r6 = r2
        L_0x00a2:
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r6, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.consumeEach(kotlinx.coroutines.channels.BroadcastChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEachIndexed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.collections.IndexedValue<? extends E>, kotlin.Unit> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
        // Method dump skipped, instructions count: 205
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.consumeEachIndexed(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> receiveChannel) {
        return new e(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final Function1<Throwable, Unit> consumesAll(@NotNull ReceiveChannel<?>... receiveChannelArr) {
        return new f(receiveChannelArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object count(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r11) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.count(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> distinct(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return distinctBy$default(receiveChannel, null, new h(null), 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new i(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> drop(@NotNull ReceiveChannel<? extends E> receiveChannel, int i, @NotNull CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new j(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> dropWhile(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new k(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return dropWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object elementAt(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r16, int r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r18) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.elementAt(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object elementAtOrElse(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, int r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r14) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.elementAtOrElse(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object elementAtOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, int r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r13) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.elementAtOrNull(kotlinx.coroutines.channels.ReceiveChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new n(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> filterIndexed(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new o(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterIndexed(receiveChannel, coroutineContext, function3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[Catch:{ all -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6 A[Catch:{ all -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object filterIndexedTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r18, @org.jetbrains.annotations.NotNull C r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, java.lang.Boolean> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r21) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterIndexedTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> filterNot(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return filter(receiveChannel, coroutineContext, new p(function2, null));
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterNot(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> filter$default = filter$default(receiveChannel, null, new q(null), 1, null);
        Objects.requireNonNull(filter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E>");
        return filter$default;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object filterNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r13) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object filterNotTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterNotTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object filterTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object find(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r14) {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.find(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r14v5, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object findLast(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r14) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.findLast(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object first(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r6) {
        /*
            boolean r0 = r6 instanceof u6.a.h0.t
            if (r0 == 0) goto L_0x0013
            r0 = r6
            u6.a.h0.t r0 = (u6.a.h0.t) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            u6.a.h0.t r0 = new u6.a.h0.t
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r5 = r0.f
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r1 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r1 = r0.d
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r0 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x003a }
            goto L_0x005f
        L_0x003a:
            r5 = move-exception
            goto L_0x007b
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x0078 }
            r0.c = r5     // Catch:{ all -> 0x0078 }
            r0.d = r5     // Catch:{ all -> 0x0078 }
            r0.e = r5     // Catch:{ all -> 0x0078 }
            r0.f = r6     // Catch:{ all -> 0x0078 }
            r0.b = r3     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r6.hasNext(r0)     // Catch:{ all -> 0x0078 }
            if (r0 != r1) goto L_0x005c
            goto L_0x006f
        L_0x005c:
            r1 = r5
            r5 = r6
            r6 = r0
        L_0x005f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0070
            java.lang.Object r5 = r5.next()
            cancelConsumed(r1, r4)
            r1 = r5
        L_0x006f:
            return r1
        L_0x0070:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "ReceiveChannel is empty."
            r5.<init>(r6)
            throw r5
        L_0x0078:
            r6 = move-exception
            r1 = r5
            r5 = r6
        L_0x007b:
            throw r5     // Catch:{ all -> 0x007c }
        L_0x007c:
            r6 = move-exception
            cancelConsumed(r1, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.first(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object firstOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r6) {
        /*
            boolean r0 = r6 instanceof u6.a.h0.u
            if (r0 == 0) goto L_0x0013
            r0 = r6
            u6.a.h0.u r0 = (u6.a.h0.u) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            u6.a.h0.u r0 = new u6.a.h0.u
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r5 = r0.f
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r1 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r1 = r0.d
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r0 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x003a }
            goto L_0x005f
        L_0x003a:
            r5 = move-exception
            goto L_0x0078
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x0075 }
            r0.c = r5     // Catch:{ all -> 0x0075 }
            r0.d = r5     // Catch:{ all -> 0x0075 }
            r0.e = r5     // Catch:{ all -> 0x0075 }
            r0.f = r6     // Catch:{ all -> 0x0075 }
            r0.b = r3     // Catch:{ all -> 0x0075 }
            java.lang.Object r0 = r6.hasNext(r0)     // Catch:{ all -> 0x0075 }
            if (r0 != r1) goto L_0x005c
            goto L_0x0074
        L_0x005c:
            r1 = r5
            r5 = r6
            r6 = r0
        L_0x005f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x006c
            cancelConsumed(r1, r4)
            r1 = r4
            goto L_0x0074
        L_0x006c:
            java.lang.Object r5 = r5.next()
            cancelConsumed(r1, r4)
            r1 = r5
        L_0x0074:
            return r1
        L_0x0075:
            r6 = move-exception
            r1 = r5
            r5 = r6
        L_0x0078:
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r6 = move-exception
            cancelConsumed(r1, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.firstOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<R> flatMap(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new v(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return flatMap(receiveChannel, coroutineContext, function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> java.lang.Object fold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, R r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super E, ? extends R> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r14) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.fold(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bc A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> java.lang.Object foldIndexed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r18, R r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super E, ? extends R> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r21) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.foldIndexed(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K> java.lang.Object groupBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<K, ? extends java.util.List<? extends E>>> r15) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.groupBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, M extends java.util.Map<? super K, java.util.List<E>>> java.lang.Object groupByTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull M r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r15) {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.groupByTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object indexOf(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, E r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r12) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.indexOf(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object indexOfFirst(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r12) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.indexOfFirst(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object indexOfLast(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.indexOfLast(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object last(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r10) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.last(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object lastIndexOf(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, E r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.lastIndexOf(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object lastOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r10) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.lastOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new a0(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return map(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new b0(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return filterNotNull(mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6 A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends java.util.Collection<? super R>> java.lang.Object mapIndexedNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r18, @org.jetbrains.annotations.NotNull C r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, ? extends R> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r21) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapIndexedNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Collection, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends java.util.Collection<? super R>> java.lang.Object mapIndexedTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull C r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, ? extends R> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r15) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapIndexedTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapNotNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return filterNotNull(map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapNotNull(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends java.util.Collection<? super R>> java.lang.Object mapNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull C r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r13) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r13v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Collection, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends java.util.Collection<? super R>> java.lang.Object mapTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull C r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r13) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec A[Catch:{ all -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R extends java.lang.Comparable<? super R>> java.lang.Object maxBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r15) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.maxBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object maxWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull java.util.Comparator<? super E> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r12) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.maxWith(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec A[Catch:{ all -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R extends java.lang.Comparable<? super R>> java.lang.Object minBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r15) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.minBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object minWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull java.util.Comparator<? super E> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r12) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.minWith(kotlinx.coroutines.channels.ReceiveChannel, java.util.Comparator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        cancelConsumed(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object none(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof u6.a.h0.e0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            u6.a.h0.e0 r0 = (u6.a.h0.e0) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            u6.a.h0.e0 r0 = new u6.a.h0.e0
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r5 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r5 = r0.d
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r0 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0066 }
            goto L_0x0054
        L_0x0036:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()
            r0.c = r5
            r0.d = r5
            r0.e = r5
            r0.b = r3
            java.lang.Object r6 = r6.hasNext(r0)
            if (r6 != r1) goto L_0x0054
            goto L_0x0065
        L_0x0054:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            cancelConsumed(r5, r4)
        L_0x0065:
            return r1
        L_0x0066:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r0 = move-exception
            cancelConsumed(r5, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.none(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<? extends E>, kotlinx.coroutines.selects.SelectClause1<E> */
    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> SelectClause1<E> onReceiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        Objects.requireNonNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
        return (SelectClause1<? extends E>) receiveChannel.getOnReceiveOrNull();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00aa A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object partition(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.util.List<? extends E>, ? extends java.util.List<? extends E>>> r14) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.partition(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ExperimentalCoroutinesApi
    @Nullable
    public static final <E> Object receiveOrNull(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        Objects.requireNonNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
        return receiveChannel.receiveOrNull(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5 A[Catch:{ all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, E extends S> java.lang.Object reduce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super S, ? super E, ? extends S> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super S> r12) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.reduce(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc A[Catch:{ all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, E extends S> java.lang.Object reduceIndexed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super S, ? super E, ? extends S> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super S> r14) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.reduceIndexed(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> requireNoNulls(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return map$default(receiveChannel, null, new f0(receiveChannel, null), 1, null);
    }

    public static final <E> void sendBlocking(@NotNull SendChannel<? super E> sendChannel, E e) {
        if (!sendChannel.offer(e)) {
            BuildersKt.runBlocking$default(null, new c(sendChannel, e, null), 1, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object single(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r9) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.single(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object singleOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r10) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.singleOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object sumBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Integer> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.sumBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object sumByDouble(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r17, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Double> r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Double> r19) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.sumByDouble(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> take(@NotNull ReceiveChannel<? extends E> receiveChannel, int i, @NotNull CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new i0(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<E> takeWhile(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new j0(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return takeWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object toChannel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull C r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r12) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.toChannel(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object toCollection(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r13) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.toCollection(kotlinx.coroutines.channels.ReceiveChannel, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        return toMutableList(receiveChannel, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object toMap(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> r12, @org.jetbrains.annotations.NotNull M r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r14) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.toMap(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object toMutableList(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<E>> continuation) {
        return toCollection(receiveChannel, new ArrayList(), continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Set<E>> continuation) {
        return toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object toSet(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Set<? extends E>> continuation) {
        return toMutableSet(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumes(receiveChannel), new n0(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull ReceiveChannel<? extends R> receiveChannel2) {
        return zip$default(receiveChannel, receiveChannel2, null, o0.a, 2, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @NotNull
    public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull ReceiveChannel<? extends R> receiveChannel2, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, consumesAll(receiveChannel, receiveChannel2), new p0(receiveChannel, receiveChannel2, function2, null), 6, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        a2.b.a.a.a.E0(1, r2, r3, 1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> R consume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> r3) {
        /*
            r0 = 1
            java.lang.Object r3 = r3.invoke(r2)     // Catch:{ all -> 0x000a }
            r1 = 0
            a2.b.a.a.a.E0(r0, r2, r1, r0)
            return r3
        L_0x000a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x000c }
        L_0x000c:
            r1 = move-exception
            a2.b.a.a.a.E0(r0, r2, r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.consume(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object any(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.any(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object none(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.none(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r14v5. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object associateByTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull M r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends V> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r14) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associateByTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object filterNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull C r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r12) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4 A[Catch:{ all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object filterNotTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterNotTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4 A[Catch:{ all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object filterTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends kotlinx.coroutines.channels.SendChannel<? super R>> java.lang.Object mapNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends kotlinx.coroutines.channels.SendChannel<? super R>> java.lang.Object mapTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull C r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends R> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r14) {
        /*
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <K, V> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull Continuation<? super Map<K, ? extends V>> continuation) {
        return toMap(receiveChannel, new LinkedHashMap(), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v7. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Map, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00aa A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V> java.lang.Object associateBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends V> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<K, ? extends V>> r15) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.associateBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[Catch:{ all -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 != r3) goto L_0x004d
            java.lang.Object r8 = r0.h
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.g
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r2 = r0.f
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            java.lang.Object r4 = r0.e
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r0.d
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r6 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0049 }
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r4
            r4 = r2
            r2 = r8
            r8 = r6
            r6 = 1
            goto L_0x007e
        L_0x0049:
            r8 = move-exception
            r9 = r4
            goto L_0x00a1
        L_0x004d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 0
            kotlinx.coroutines.channels.ChannelIterator r2 = r8.iterator()     // Catch:{ all -> 0x009d }
            r4 = r10
            r3 = r1
            r5 = 1
            r10 = r8
            r1 = r0
            r0 = r9
            r9 = r10
        L_0x0064:
            r1.c = r8     // Catch:{ all -> 0x009a }
            r1.d = r0     // Catch:{ all -> 0x009a }
            r1.e = r9     // Catch:{ all -> 0x009a }
            r1.f = r4     // Catch:{ all -> 0x009a }
            r1.g = r10     // Catch:{ all -> 0x009a }
            r1.h = r2     // Catch:{ all -> 0x009a }
            r1.b = r5     // Catch:{ all -> 0x009a }
            java.lang.Object r6 = r2.hasNext(r1)     // Catch:{ all -> 0x009a }
            if (r6 != r3) goto L_0x0079
            goto L_0x0096
        L_0x0079:
            r7 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r7
        L_0x007e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0097 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x0091
            java.lang.Object r10 = r2.next()     // Catch:{ all -> 0x0097 }
            r5.invoke(r10)     // Catch:{ all -> 0x0097 }
            r10 = r0
            r0 = r5
            r5 = r6
            goto L_0x0064
        L_0x0091:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0097 }
            a2.b.a.a.a.E0(r6, r9, r4, r6)
        L_0x0096:
            return r3
        L_0x0097:
            r8 = move-exception
            r3 = r6
            goto L_0x00a1
        L_0x009a:
            r8 = move-exception
            r3 = r5
            goto L_0x00a1
        L_0x009d:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00a1:
            throw r8     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r10 = move-exception
            a2.b.a.a.a.E0(r3, r9, r8, r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.consumeEach(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r12v6, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends kotlinx.coroutines.channels.SendChannel<? super R>> java.lang.Object mapIndexedTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r16, @org.jetbrains.annotations.NotNull C r17, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, ? extends R> r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r19) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapIndexedTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object count(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r12) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.count(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v1. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r11v9, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object filterIndexedTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r19, @org.jetbrains.annotations.NotNull C r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, java.lang.Boolean> r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r22) {
        /*
        // Method dump skipped, instructions count: 365
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.filterIndexedTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object first(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r12) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.first(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object firstOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r13) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.firstOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v1. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r11v9, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R, C extends kotlinx.coroutines.channels.SendChannel<? super R>> java.lang.Object mapIndexedNotNullTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r19, @org.jetbrains.annotations.NotNull C r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super E, ? extends R> r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r22) {
        /*
        // Method dump skipped, instructions count: 361
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.mapIndexedNotNullTo(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object singleOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r15) {
        /*
        // Method dump skipped, instructions count: 239
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.singleOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad A[Catch:{ all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object last(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r14) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.last(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r13v7, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object lastOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r13) {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.lastOrNull(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object single(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r14) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.single(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V, M extends java.util.Map<? super K, java.util.List<V>>> java.lang.Object groupByTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r11, @org.jetbrains.annotations.NotNull M r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends V> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> r15) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.groupByTo(kotlinx.coroutines.channels.ReceiveChannel, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b8 A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, K, V> java.lang.Object groupBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends K> r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, ? extends V> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<K, ? extends java.util.List<? extends V>>> r21) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.groupBy(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a'\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0001\"\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\t0\u0007H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "", "awaitAll", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "jobs", "", "joinAll", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class AwaitKt {

    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {26}, m = "awaitAll", n = {"deferreds"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AwaitKt.awaitAll((Deferred[]) null, this);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {43}, m = "awaitAll", n = {"$this$awaitAll"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AwaitKt.awaitAll((Collection) null, this);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0}, l = {55}, m = "joinAll", n = {"jobs", "$this$forEach$iv", "element$iv", "it"}, s = {"L$0", "L$1", "L$3", "L$4"})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public int h;
        public int i;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AwaitKt.joinAll((Job[]) null, this);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0}, l = {67}, m = "joinAll", n = {"$this$joinAll", "$this$forEach$iv", "element$iv", "it"}, s = {"L$0", "L$1", "L$3", "L$4"})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;

        public d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return AwaitKt.joinAll((Collection<? extends Job>) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Deferred<? extends T>[] r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.AwaitKt$a r0 = (kotlinx.coroutines.AwaitKt.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$a r0 = new kotlinx.coroutines.AwaitKt$a
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.c
            kotlinx.coroutines.Deferred[] r4 = (kotlinx.coroutines.Deferred[]) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0055
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            int r5 = r4.length
            if (r5 != 0) goto L_0x003d
            r5 = 1
            goto L_0x003e
        L_0x003d:
            r5 = 0
        L_0x003e:
            if (r5 == 0) goto L_0x0045
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0058
        L_0x0045:
            u6.a.b r5 = new u6.a.b
            r5.<init>(r4)
            r0.c = r4
            r0.b = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L_0x0058:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(kotlinx.coroutines.Deferred[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object joinAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job[] r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.AwaitKt.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.AwaitKt$c r0 = (kotlinx.coroutines.AwaitKt.c) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$c r0 = new kotlinx.coroutines.AwaitKt$c
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 != r3) goto L_0x0047
            java.lang.Object r7 = r0.g
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            java.lang.Object r7 = r0.f
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            int r7 = r0.i
            int r2 = r0.h
            java.lang.Object r4 = r0.e
            kotlinx.coroutines.Job[] r4 = (kotlinx.coroutines.Job[]) r4
            java.lang.Object r5 = r0.d
            kotlinx.coroutines.Job[] r5 = (kotlinx.coroutines.Job[]) r5
            java.lang.Object r6 = r0.c
            kotlinx.coroutines.Job[] r6 = (kotlinx.coroutines.Job[]) r6
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            r2 = r0
            r0 = r6
            goto L_0x0076
        L_0x0047:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = r7.length
            r2 = 0
            r5 = r8
            r2 = r0
            r4 = r1
            r8 = r7
            r0 = r8
            r1 = r0
            r7 = 0
        L_0x005b:
            if (r7 >= r5) goto L_0x0078
            r6 = r8[r7]
            r2.c = r0
            r2.d = r1
            r2.e = r8
            r2.h = r5
            r2.i = r7
            r2.f = r6
            r2.g = r6
            r2.b = r3
            java.lang.Object r6 = r6.join(r2)
            if (r6 != r4) goto L_0x0076
            return r4
        L_0x0076:
            int r7 = r7 + r3
            goto L_0x005b
        L_0x0078:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(kotlinx.coroutines.Job[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Deferred<? extends T>> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.AwaitKt.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.AwaitKt$b r0 = (kotlinx.coroutines.AwaitKt.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$b r0 = new kotlinx.coroutines.AwaitKt$b
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.c
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0061
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0043
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0064
        L_0x0043:
            u6.a.b r6 = new u6.a.b
            r2 = 0
            kotlinx.coroutines.Deferred[] r2 = new kotlinx.coroutines.Deferred[r2]
            java.lang.Object[] r2 = r5.toArray(r2)
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r2, r4)
            kotlinx.coroutines.Deferred[] r2 = (kotlinx.coroutines.Deferred[]) r2
            r6.<init>(r2)
            r0.c = r5
            r0.b = r3
            java.lang.Object r6 = r6.a(r0)
            if (r6 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r5 = r6
            java.util.List r5 = (java.util.List) r5
        L_0x0064:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.awaitAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object joinAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Job> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.AwaitKt.d
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.AwaitKt$d r0 = (kotlinx.coroutines.AwaitKt.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.AwaitKt$d r0 = new kotlinx.coroutines.AwaitKt$d
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r7 = r0.g
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            java.lang.Object r7 = r0.e
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.d
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.c
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r4
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r6
            goto L_0x0052
        L_0x003e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.Iterator r8 = r7.iterator()
            r2 = r1
            r1 = r0
            r0 = r7
            r7 = r8
            r8 = r0
        L_0x0052:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L_0x0072
            java.lang.Object r4 = r7.next()
            r5 = r4
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            r1.c = r8
            r1.d = r0
            r1.e = r7
            r1.f = r4
            r1.g = r5
            r1.b = r3
            java.lang.Object r4 = r5.join(r1)
            if (r4 != r2) goto L_0x0052
            return r2
        L_0x0072:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.joinAll(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

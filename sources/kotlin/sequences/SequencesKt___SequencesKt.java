package kotlin.sequences;

import com.avito.android.lib.design.input.FormatterType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.g;
import t6.n.y;
public class SequencesKt___SequencesKt extends t6.x.f {

    public static final class a extends Lambda implements Function1<T, T> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            return t;
        }
    }

    public static final class b extends Lambda implements Function1<Integer, T> {
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(1);
            this.a = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Integer num) {
            num.intValue();
            throw new IndexOutOfBoundsException(a2.b.a.a.a.i(a2.b.a.a.a.L("Sequence doesn't contain element at index "), this.a, FormatterType.defaultDecimalSeparator));
        }
    }

    public static final class c extends Lambda implements Function1<IndexedValue<? extends T>, Boolean> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function2 function2) {
            super(1);
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            IndexedValue indexedValue = (IndexedValue) obj;
            Intrinsics.checkNotNullParameter(indexedValue, "it");
            return Boolean.valueOf(((Boolean) this.a.invoke(Integer.valueOf(indexedValue.getIndex()), indexedValue.getValue())).booleanValue());
        }
    }

    public static final class d extends Lambda implements Function1<IndexedValue<? extends T>, T> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            IndexedValue indexedValue = (IndexedValue) obj;
            Intrinsics.checkNotNullParameter(indexedValue, "it");
            return indexedValue.getValue();
        }
    }

    public static final class e extends Lambda implements Function1<T, Boolean> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            return Boolean.valueOf(obj == null);
        }
    }

    public static final class j extends Lambda implements Function1<T, T> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Function1 function1) {
            super(1);
            this.a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            this.a.invoke(t);
            return t;
        }
    }

    public static final class k extends Lambda implements Function2<Integer, T, T> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Function2 function2) {
            super(2);
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Integer num, Object obj) {
            this.a.invoke(Integer.valueOf(num.intValue()), obj);
            return obj;
        }
    }

    public static final class l extends Lambda implements Function1<T, T> {
        public final /* synthetic */ Sequence a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Sequence sequence) {
            super(1);
            this.a = sequence;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final T invoke(@Nullable T t) {
            if (t != null) {
                return t;
            }
            StringBuilder L = a2.b.a.a.a.L("null element found in ");
            L.append(this.a);
            L.append(FormatterType.defaultDecimalSeparator);
            throw new IllegalArgumentException(L.toString());
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2081, 2085}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
    public static final class m extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ Sequence f;
        public final /* synthetic */ Object g;
        public final /* synthetic */ Function2 h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Sequence sequence, Object obj, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f = sequence;
            this.g = obj;
            this.h = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            m mVar = new m(this.f, this.g, this.h, continuation);
            mVar.b = obj;
            return mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            m mVar = new m(this.f, this.g, this.h, continuation2);
            mVar.b = obj;
            return mVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r7.e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002d
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                java.lang.Object r1 = r7.d
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r7.c
                java.lang.Object r4 = r7.b
                kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
                kotlin.ResultKt.throwOnFailure(r8)
                r8 = r3
                goto L_0x004c
            L_0x001d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0025:
                java.lang.Object r1 = r7.b
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0042
            L_0x002d:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.b
                r1 = r8
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                java.lang.Object r8 = r7.g
                r7.b = r1
                r7.e = r3
                java.lang.Object r8 = r1.yield(r8, r7)
                if (r8 != r0) goto L_0x0042
                return r0
            L_0x0042:
                java.lang.Object r8 = r7.g
                kotlin.sequences.Sequence r3 = r7.f
                java.util.Iterator r3 = r3.iterator()
                r4 = r1
                r1 = r3
            L_0x004c:
                r3 = r7
            L_0x004d:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x006c
                java.lang.Object r5 = r1.next()
                kotlin.jvm.functions.Function2 r6 = r3.h
                java.lang.Object r8 = r6.invoke(r8, r5)
                r3.b = r4
                r3.c = r8
                r3.d = r1
                r3.e = r2
                java.lang.Object r5 = r4.yield(r8, r3)
                if (r5 != r0) goto L_0x004d
                return r0
            L_0x006c:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2109, 2114}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$0", "L$1", "I$0"})
    public static final class n extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public int f;
        public final /* synthetic */ Sequence g;
        public final /* synthetic */ Object h;
        public final /* synthetic */ Function3 i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(Sequence sequence, Object obj, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.g = sequence;
            this.h = obj;
            this.i = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            n nVar = new n(this.g, this.h, this.i, continuation);
            nVar.b = obj;
            return nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            n nVar = new n(this.g, this.h, this.i, continuation2);
            nVar.b = obj;
            return nVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r9.f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0030
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                int r1 = r9.e
                java.lang.Object r3 = r9.d
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r9.c
                java.lang.Object r5 = r9.b
                kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r1
                r1 = r4
                goto L_0x0051
            L_0x0020:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0028:
                java.lang.Object r1 = r9.b
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x0045
            L_0x0030:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.b
                r1 = r10
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                java.lang.Object r10 = r9.h
                r9.b = r1
                r9.f = r3
                java.lang.Object r10 = r1.yield(r10, r9)
                if (r10 != r0) goto L_0x0045
                return r0
            L_0x0045:
                r10 = 0
                java.lang.Object r3 = r9.h
                kotlin.sequences.Sequence r4 = r9.g
                java.util.Iterator r4 = r4.iterator()
                r5 = r1
                r1 = r3
                r3 = r4
            L_0x0051:
                r4 = r9
            L_0x0052:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L_0x0081
                java.lang.Object r6 = r3.next()
                kotlin.jvm.functions.Function3 r7 = r4.i
                int r8 = r10 + 1
                if (r10 >= 0) goto L_0x0065
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x0065:
                java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
                java.lang.Object r10 = r7.invoke(r10, r1, r6)
                r4.b = r5
                r4.c = r10
                r4.d = r3
                r4.e = r8
                r4.f = r2
                java.lang.Object r1 = r5.yield(r10, r4)
                if (r1 != r0) goto L_0x007e
                return r0
            L_0x007e:
                r1 = r10
                r10 = r8
                goto L_0x0052
            L_0x0081:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2139, 2142}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class o extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ Sequence f;
        public final /* synthetic */ Function2 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(Sequence sequence, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f = sequence;
            this.g = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            o oVar = new o(this.f, this.g, continuation);
            oVar.b = obj;
            return oVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            o oVar = new o(this.f, this.g, continuation2);
            oVar.b = obj;
            return oVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            SequenceScope sequenceScope;
            Iterator it;
            Object obj2;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.b;
                Iterator it2 = this.f.iterator();
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    this.b = sequenceScope;
                    this.c = it2;
                    this.d = obj2;
                    this.e = 1;
                    if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = it2;
                }
                return Unit.INSTANCE;
            } else if (i == 1 || i == 2) {
                obj2 = this.d;
                it = (Iterator) this.c;
                sequenceScope = (SequenceScope) this.b;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                obj2 = this.g.invoke(obj2, it.next());
                this.b = sequenceScope;
                this.c = it;
                this.d = obj2;
                this.e = 2;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2168, 2172}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    public static final class p extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public int f;
        public final /* synthetic */ Sequence g;
        public final /* synthetic */ Function3 h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(Sequence sequence, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.g = sequence;
            this.h = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            p pVar = new p(this.g, this.h, continuation);
            pVar.b = obj;
            return pVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            p pVar = new p(this.g, this.h, continuation2);
            pVar.b = obj;
            return pVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r10.f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0038
                if (r1 == r3) goto L_0x002a
                if (r1 != r2) goto L_0x0022
                int r1 = r10.e
                java.lang.Object r3 = r10.d
                java.lang.Object r4 = r10.c
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r10.b
                kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
                kotlin.ResultKt.throwOnFailure(r11)
                r11 = r10
                r9 = r3
                r3 = r1
                r1 = r9
                goto L_0x0060
            L_0x0022:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x002a:
                java.lang.Object r1 = r10.d
                java.lang.Object r4 = r10.c
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r10.b
                kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x005f
            L_0x0038:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.b
                r5 = r11
                kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
                kotlin.sequences.Sequence r11 = r10.g
                java.util.Iterator r4 = r11.iterator()
                boolean r11 = r4.hasNext()
                if (r11 == 0) goto L_0x008f
                java.lang.Object r1 = r4.next()
                r10.b = r5
                r10.c = r4
                r10.d = r1
                r10.f = r3
                java.lang.Object r11 = r5.yield(r1, r10)
                if (r11 != r0) goto L_0x005f
                return r0
            L_0x005f:
                r11 = r10
            L_0x0060:
                boolean r6 = r4.hasNext()
                if (r6 == 0) goto L_0x008f
                kotlin.jvm.functions.Function3 r6 = r11.h
                int r7 = r3 + 1
                if (r3 >= 0) goto L_0x006f
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x006f:
                java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
                java.lang.Object r8 = r4.next()
                java.lang.Object r3 = r6.invoke(r3, r1, r8)
                r11.b = r5
                r11.c = r4
                r11.d = r3
                r11.e = r7
                r11.f = r2
                java.lang.Object r1 = r5.yield(r3, r11)
                if (r1 != r0) goto L_0x008c
                return r0
            L_0x008c:
                r1 = r3
                r3 = r7
                goto L_0x0060
            L_0x008f:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class q extends Lambda implements Function2<T, R, Pair<? extends T, ? extends R>> {
        public static final q a = new q();

        public q() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    public static final class r extends Lambda implements Function2<T, T, Pair<? extends T, ? extends T>> {
        public static final r a = new r();

        public r() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2666}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
    public static final class s extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ Sequence f;
        public final /* synthetic */ Function2 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(Sequence sequence, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f = sequence;
            this.g = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            s sVar = new s(this.f, this.g, continuation);
            sVar.b = obj;
            return sVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            s sVar = new s(this.f, this.g, continuation2);
            sVar.b = obj;
            return sVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            SequenceScope sequenceScope;
            Iterator it;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope2 = (SequenceScope) this.b;
                Iterator it2 = this.f.iterator();
                if (!it2.hasNext()) {
                    return Unit.INSTANCE;
                }
                sequenceScope = sequenceScope2;
                obj2 = it2.next();
                it = it2;
            } else if (i == 1) {
                Object obj3 = this.d;
                it = (Iterator) this.c;
                sequenceScope = (SequenceScope) this.b;
                ResultKt.throwOnFailure(obj);
                obj2 = obj3;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object next = it.next();
                Object invoke = this.g.invoke(obj2, next);
                this.b = sequenceScope;
                this.c = it;
                this.d = next;
                this.e = 1;
                if (sequenceScope.yield(invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = next;
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> boolean all(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            if (!function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    @NotNull
    public static final <T> Iterable<T> asIterable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$asIterable");
        return new Object(sequence) { // from class: kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1
            public final /* synthetic */ Sequence a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return this.a.iterator();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(function1.invoke(obj), obj);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m2, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m2.put(function1.invoke(obj), obj);
        }
        return m2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Sequence<? extends T> sequence, @NotNull M m2, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            m2.put(pair.getFirst(), pair.getSecond());
        }
        return m2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Sequence<? extends K> sequence, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateWith");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(obj, function1.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Sequence<? extends K> sequence, @NotNull M m2, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        Iterator<? extends K> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m2.put(obj, function1.invoke(obj));
        }
        return m2;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Byte b2 : sequence) {
            d2 += (double) b2.byteValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Double d3 : sequence) {
            d2 += d3.doubleValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Float f2 : sequence) {
            d2 += (double) f2.floatValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Integer num : sequence) {
            d2 += (double) num.intValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Long l2 : sequence) {
            d2 += (double) l2.longValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Short sh : sequence) {
            d2 += (double) sh.shortValue();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<List<T>> chunked(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$chunked");
        return windowed(sequence, i2, i2, true);
    }

    public static final <T> boolean contains(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$contains");
        return indexOf(sequence, t) >= 0;
    }

    public static final <T> int count(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i2;
    }

    @NotNull
    public static final <T> Sequence<T> distinct(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$distinct");
        return distinctBy(sequence, a.a);
    }

    @NotNull
    public static final <T, K> Sequence<T> distinctBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new DistinctSequence(sequence, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> drop(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$drop");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).drop(i2);
            }
            return new DropSequence(sequence, i2);
        }
    }

    @NotNull
    public static final <T> Sequence<T> dropWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new DropWhileSequence(sequence, function1);
    }

    public static final <T> T elementAt(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAt");
        return (T) elementAtOrElse(sequence, i2, new b(i2));
    }

    public static final <T> T elementAtOrElse(@NotNull Sequence<? extends T> sequence, int i2, @NotNull Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (i2 < 0) {
            return (T) function1.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t : sequence) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return (T) function1.invoke(Integer.valueOf(i2));
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAtOrNull");
        if (i2 < 0) {
            return null;
        }
        int i3 = 0;
        for (T t : sequence) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return null;
    }

    @NotNull
    public static final <T> Sequence<T> filter(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, true, function1);
    }

    @NotNull
    public static final <T> Sequence<T> filterIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        return new TransformingSequence(new FilteringSequence(new IndexingSequence(sequence), true, new c(function2)), d.a);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function2.invoke(Integer.valueOf(i2), obj).booleanValue()) {
                c2.add(obj);
            }
            i2 = i3;
        }
        return c2;
    }

    public static final /* synthetic */ <R> Sequence<R> filterIsInstance(Sequence<?> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstance");
        Intrinsics.needClassReification();
        Sequence<R> filter = filter(sequence, SequencesKt___SequencesKt$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return filter;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Sequence<?> sequence, C c2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (Object obj : sequence) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T> Sequence<T> filterNot(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, false, function1);
    }

    @NotNull
    public static final <T> Sequence<T> filterNotNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> filterNot = filterNot(sequence, e.a);
        Objects.requireNonNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return filterNot;
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (Object obj : sequence) {
            if (obj != null) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (!function1.invoke(obj).booleanValue()) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> T first(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$first");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return (T) it.next();
    }

    @NotNull
    public static final <T, R> Sequence<R> flatMap(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new FlatteningSequence(sequence, function1, g.a);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIndexedIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIndexedIterable(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, function2, h.a);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIndexedSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIndexedSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(sequence, function2, i.a);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIterable")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> Sequence<R> flatMapIterable(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new FlatteningSequence(sequence, function1, f.a);
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapIterableTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke((Object) it.next()));
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(c2, (Sequence) function1.invoke((Object) it.next()));
        }
        return c2;
    }

    public static final <T, R> R fold(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            r2 = (R) function2.invoke(r2, (Object) it.next());
        }
        return r2;
    }

    public static final <T, R> R foldIndexed(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            r2 = (R) function3.invoke(Integer.valueOf(i2), r2, obj);
            i2 = i3;
        }
        return r2;
    }

    public static final <T> void forEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            function1.invoke((Object) it.next());
        }
    }

    public static final <T> void forEachIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            function2.invoke(Integer.valueOf(i2), obj);
            i2 = i3;
        }
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m2, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m2.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.j0(m2, invoke);
            }
            ((List) obj2).add(obj);
        }
        return m2;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupingBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new Grouping<T, K>(sequence, function1) { // from class: kotlin.sequences.SequencesKt___SequencesKt$groupingBy$1
            public final /* synthetic */ Sequence a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.collections.Grouping
            public K keyOf(T t) {
                return (K) this.b.invoke(t);
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return this.a.iterator();
            }
        };
    }

    public static final <T> int indexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOf");
        int i2 = 0;
        for (Object obj : sequence) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = -1;
        int i3 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i3 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Sequence<? extends T> sequence, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (Object obj : sequence) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            t6.y.e.appendElement(a3, obj, function1);
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static /* synthetic */ Appendable joinTo$default(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(sequence, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Sequence<? extends T> sequence, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sequence, charSequence, charSequence6, charSequence5, i4, charSequence4, function1);
    }

    public static final <T> T last(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$last");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            while (it.hasNext()) {
                t = (T) it.next();
            }
            return t;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> int lastIndexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$lastIndexOf");
        int i2 = -1;
        int i3 = 0;
        for (Object obj : sequence) {
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$lastOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        while (it.hasNext()) {
            t = (T) it.next();
        }
        return t;
    }

    @NotNull
    public static final <T, R> Sequence<R> map(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new TransformingSequence(sequence, function1);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return new TransformingIndexedSequence(sequence, function2);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexedNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedNotNull");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return filterNotNull(new TransformingIndexedSequence(sequence, function2));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i2), obj);
            if (invoke != null) {
                c2.add(invoke);
            }
            i2 = i3;
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            c2.add(function2.invoke(Integer.valueOf(i2), obj));
            i2 = i3;
        }
        return c2;
    }

    @NotNull
    public static final <T, R> Sequence<R> mapNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return filterNotNull(new TransformingSequence(sequence, function1));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object invoke = function1.invoke((Object) it.next());
            if (invoke != null) {
                c2.add(invoke);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Sequence<? extends T> sequence, @NotNull C c2, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c2.add(function1.invoke((Object) it.next()));
        }
        return c2;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max */
    public static final Double m427max(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return m429maxOrNull(sequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo < 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it.hasNext());
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T maxByOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$maxByOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0016
            r5 = 0
            return r5
        L_0x0016:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x0027:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 >= 0) goto L_0x0039
            r0 = r2
            r1 = r3
        L_0x0039:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x0027
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.maxByOrNull(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull */
    public static final Double m429maxOrNull(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxOrNull");
        Iterator<Double> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T maxWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(sequence, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T maxWithOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r3, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> r4) {
        /*
            java.lang.String r0 = "$this$maxWithOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "comparator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0016
            r3 = 0
            return r3
        L_0x0016:
            java.lang.Object r0 = r3.next()
        L_0x001a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r3.next()
            int r2 = r4.compare(r0, r1)
            if (r2 >= 0) goto L_0x001a
            r0 = r1
            goto L_0x001a
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.maxWithOrNull(kotlin.sequences.Sequence, java.util.Comparator):java.lang.Object");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min */
    public static final Double m431min(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return m433minOrNull(sequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo > 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it.hasNext());
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T minByOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$minByOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0016
            r5 = 0
            return r5
        L_0x0016:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x0027:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 <= 0) goto L_0x0039
            r0 = r2
            r1 = r3
        L_0x0039:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x0027
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.minByOrNull(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull */
    public static final Double m433minOrNull(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minOrNull");
        Iterator<Double> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T minWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(sequence, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T minWithOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r3, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> r4) {
        /*
            java.lang.String r0 = "$this$minWithOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "comparator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0016
            r3 = 0
            return r3
        L_0x0016:
            java.lang.Object r0 = r3.next()
        L_0x001a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r3.next()
            int r2 = r4.compare(r0, r1)
            if (r2 <= 0) goto L_0x001a
            r0 = r1
            goto L_0x001a
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.minWithOrNull(kotlin.sequences.Sequence, java.util.Comparator):java.lang.Object");
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        return new SequencesKt___SequencesKt$minus$1(sequence, t);
    }

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$none");
        return !sequence.iterator().hasNext();
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T> Sequence<T> onEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$onEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        return map(sequence, new j(function1));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> onEachIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        return mapIndexed(sequence, new k(function2));
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, SequencesKt__SequencesKt.sequenceOf(t)));
    }

    public static final <S, T extends S> S reduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            S s2 = (S) it.next();
            while (it.hasNext()) {
                s2 = (S) function2.invoke(s2, (Object) it.next());
            }
            return s2;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            S s2 = (S) it.next();
            int i2 = 1;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                s2 = (S) function3.invoke(Integer.valueOf(i2), s2, (Object) it.next());
                i2 = i3;
            }
            return s2;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s2 = (S) it.next();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            s2 = (S) function3.invoke(Integer.valueOf(i2), s2, (Object) it.next());
            i2 = i3;
        }
        return s2;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s2 = (S) it.next();
        while (it.hasNext()) {
            s2 = (S) function2.invoke(s2, (Object) it.next());
        }
        return s2;
    }

    @NotNull
    public static final <T> Sequence<T> requireNoNulls(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$requireNoNulls");
        return map(sequence, new l(sequence));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> Sequence<R> runningFold(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningFold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new m(sequence, r2, function2, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> Sequence<R> runningFoldIndexed(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new n(sequence, r2, function3, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> Sequence<S> runningReduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new o(sequence, function2, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> Sequence<S> runningReduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt__SequenceBuilderKt.sequence(new p(sequence, function3, null));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> Sequence<R> scan(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scan");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return runningFold(sequence, r2, function2);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> Sequence<R> scanIndexed(@NotNull Sequence<? extends T> sequence, R r2, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return runningFoldIndexed(sequence, r2, function3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduce instead.", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <S, T extends S> Sequence<S> scanReduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return runningReduce(sequence, function2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduceIndexed instead.", replaceWith = @ReplaceWith(expression = "runningReduceIndexed(operation)", imports = {}))
    public static final <S, T extends S> Sequence<S> scanReduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return runningReduceIndexed(sequence, function3);
    }

    public static final <T> T single(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$single");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            if (!it.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$singleOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        if (it.hasNext()) {
            return null;
        }
        return t;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sorted(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sorted");
        return new Sequence<T>(sequence) { // from class: kotlin.sequences.SequencesKt___SequencesKt$sorted$1
            public final /* synthetic */ Sequence a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                List mutableList = SequencesKt___SequencesKt.toMutableList(this.a);
                g.sort(mutableList);
                return mutableList.iterator();
            }
        };
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedDescending");
        return sortedWith(sequence, t6.o.a.reverseOrder());
    }

    @NotNull
    public static final <T> Sequence<T> sortedWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Sequence<T>(sequence, comparator) { // from class: kotlin.sequences.SequencesKt___SequencesKt$sortedWith$1
            public final /* synthetic */ Sequence a;
            public final /* synthetic */ Comparator b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                List mutableList = SequencesKt___SequencesKt.toMutableList(this.a);
                g.sortWith(mutableList, this.b);
                return mutableList.iterator();
            }
        };
    }

    public static final <T> int sumBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += function1.invoke((Object) it.next()).intValue();
        }
        return i2;
    }

    public static final <T> double sumByDouble(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = sequence.iterator();
        double d2 = 0.0d;
        while (it.hasNext()) {
            d2 += function1.invoke((Object) it.next()).doubleValue();
        }
        return d2;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i2 = 0;
        for (Byte b2 : sequence) {
            i2 += b2.byteValue();
        }
        return i2;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        double d2 = 0.0d;
        for (Double d3 : sequence) {
            d2 += d3.doubleValue();
        }
        return d2;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        float f2 = 0.0f;
        for (Float f3 : sequence) {
            f2 += f3.floatValue();
        }
        return f2;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i2 = 0;
        for (Integer num : sequence) {
            i2 += num.intValue();
        }
        return i2;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        long j2 = 0;
        for (Long l2 : sequence) {
            j2 += l2.longValue();
        }
        return j2;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i2 = 0;
        for (Short sh : sequence) {
            i2 += sh.shortValue();
        }
        return i2;
    }

    @NotNull
    public static final <T> Sequence<T> take(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).take(i2);
            }
            return new TakeSequence(sequence, i2);
        }
    }

    @NotNull
    public static final <T> Sequence<T> takeWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new TakeWhileSequence(sequence, function1);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Sequence<? extends T> sequence, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    @NotNull
    public static final <T> List<T> toList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toList");
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(sequence));
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) toCollection(sequence, new ArrayList());
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toMutableSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toSet");
        return y.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<List<T>> windowed(@NotNull Sequence<? extends T> sequence, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(sequence, "$this$windowed");
        return SlidingWindowKt.windowedSequence(sequence, i2, i3, z, false);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i2, i3, z);
    }

    @NotNull
    public static final <T> Sequence<IndexedValue<T>> withIndex(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$withIndex");
        return new IndexingSequence(sequence);
    }

    @NotNull
    public static final <T, R> Sequence<Pair<T, R>> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zip");
        Intrinsics.checkNotNullParameter(sequence2, "other");
        return new MergingSequence(sequence, sequence2, q.a);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<Pair<T, T>> zipWithNext(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zipWithNext");
        return zipWithNext(sequence, r.a);
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> chunked(@NotNull Sequence<? extends T> sequence, int i2, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$chunked");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return windowed(sequence, i2, i2, true, function1);
    }

    public static final <T> int count(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue() && (i2 = i2 + 1) < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                } else {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i2;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max */
    public static final Float m428max(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return m430maxOrNull(sequence);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min */
    public static final Float m432min(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return m434minOrNull(sequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            return sequence;
        }
        return new Sequence<T>(sequence, tArr) { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2
            public final /* synthetic */ Sequence a;
            public final /* synthetic */ Object[] b;

            public static final class a extends Lambda implements Function1<T, Boolean> {
                public final /* synthetic */ HashSet a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(HashSet hashSet) {
                    super(1);
                    this.a = hashSet;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public Boolean invoke(Object obj) {
                    return Boolean.valueOf(this.a.contains(obj));
                }
            }

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt___SequencesKt.filterNot(this.a, new a(ArraysKt___ArraysKt.toHashSet(this.b))).iterator();
            }
        };
    }

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return plus((Sequence) sequence, (Iterable) ArraysKt___ArraysJvmKt.asList(tArr));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> windowed(@NotNull Sequence<? extends T> sequence, int i2, int i3, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$windowed");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return map(SlidingWindowKt.windowedSequence(sequence, i2, i3, z, true), function1);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i2, int i3, boolean z, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i2, i3, z, function1);
    }

    @NotNull
    public static final <T, R, V> Sequence<V> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> sequence2, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zip");
        Intrinsics.checkNotNullParameter(sequence2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return new MergingSequence(sequence, sequence2, function2);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> Sequence<R> zipWithNext(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zipWithNext");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt__SequenceBuilderKt.sequence(new s(sequence, function2, null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m2, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m2.put(function1.invoke(obj), function12.invoke(obj));
        }
        return m2;
    }

    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T max(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return (T) maxOrNull(sequence);
    }

    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T min(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return (T) minOrNull(sequence);
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, CollectionsKt___CollectionsKt.asSequence(iterable)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(function1.invoke(obj), function12.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T firstOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$firstOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x000e
            return r0
        L_0x0025:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.firstOrNull(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        return new Sequence<T>(sequence, iterable) { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3
            public final /* synthetic */ Sequence a;
            public final /* synthetic */ Iterable b;

            public static final class a extends Lambda implements Function1<T, Boolean> {
                public final /* synthetic */ Collection a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(Collection collection) {
                    super(1);
                    this.a = collection;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public Boolean invoke(Object obj) {
                    return Boolean.valueOf(this.a.contains(obj));
                }
            }

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                Collection convertToSetForSetOperation = e.convertToSetForSetOperation(this.b);
                if (convertToSetForSetOperation.isEmpty()) {
                    return this.a.iterator();
                }
                return SequencesKt___SequencesKt.filterNot(this.a, new a(convertToSetForSetOperation)).iterator();
            }
        };
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends T> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(sequence2, MessengerShareContentUtility.ELEMENTS);
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, sequence2));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T first(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$first"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x000e
            return r0
        L_0x0025:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "Sequence contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.first(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends T> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(sequence2, MessengerShareContentUtility.ELEMENTS);
        return new Sequence<T>(sequence, sequence2) { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4
            public final /* synthetic */ Sequence a;
            public final /* synthetic */ Sequence b;

            public static final class a extends Lambda implements Function1<T, Boolean> {
                public final /* synthetic */ HashSet a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(HashSet hashSet) {
                    super(1);
                    this.a = hashSet;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public Boolean invoke(Object obj) {
                    return Boolean.valueOf(this.a.contains(obj));
                }
            }

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                HashSet hashSet = SequencesKt___SequencesKt.toHashSet(this.b);
                if (hashSet.isEmpty()) {
                    return this.a.iterator();
                }
                return SequencesKt___SequencesKt.filterNot(this.a, new a(hashSet)).iterator();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T singleOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r6) {
        /*
            java.lang.String r0 = "$this$singleOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
            r1 = 0
            r2 = r0
        L_0x0011:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x002d
            java.lang.Object r3 = r5.next()
            java.lang.Object r4 = r6.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0011
            if (r1 == 0) goto L_0x002a
            return r0
        L_0x002a:
            r1 = 1
            r2 = r3
            goto L_0x0011
        L_0x002d:
            if (r1 != 0) goto L_0x0030
            return r0
        L_0x0030:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.singleOrNull(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m2, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m2, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m2.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.j0(m2, invoke);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lastOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r4) {
        /*
            java.lang.String r0 = "$this$lastOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            r0 = 0
        L_0x000f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r3.next()
            java.lang.Object r2 = r4.invoke(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x000f
            r0 = r1
            goto L_0x000f
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.lastOrNull(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T last(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "$this$last"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r4 = r4.iterator()
            r0 = 0
            r1 = 0
        L_0x0010:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r4.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0010
            r0 = 1
            r0 = r2
            r1 = 1
            goto L_0x0010
        L_0x002a:
            if (r1 == 0) goto L_0x002d
            return r0
        L_0x002d:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Sequence contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.last(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T single(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "$this$single"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r4 = r4.iterator()
            r0 = 0
            r1 = 0
        L_0x0010:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r4.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0010
            if (r1 != 0) goto L_0x002c
            r0 = 1
            r0 = r2
            r1 = 1
            goto L_0x0010
        L_0x002c:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Sequence contains more than one matching element."
            r4.<init>(r5)
            throw r4
        L_0x0034:
            if (r1 == 0) goto L_0x0037
            return r0
        L_0x0037:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Sequence contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.single(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull */
    public static final Float m430maxOrNull(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxOrNull");
        Iterator<Float> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull */
    public static final Float m434minOrNull(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minOrNull");
        Iterator<Float> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.Comparable<? super T>> T maxOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r3) {
        /*
            java.lang.String r0 = "$this$maxOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            java.lang.Object r0 = r3.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
        L_0x0017:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = r0.compareTo(r1)
            if (r2 >= 0) goto L_0x0017
            r0 = r1
            goto L_0x0017
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.maxOrNull(kotlin.sequences.Sequence):java.lang.Comparable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.Comparable<? super T>> T minOrNull(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> r3) {
        /*
            java.lang.String r0 = "$this$minOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            java.lang.Object r0 = r3.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
        L_0x0017:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = r0.compareTo(r1)
            if (r2 <= 0) goto L_0x0017
            r0 = r1
            goto L_0x0017
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt.minOrNull(kotlin.sequences.Sequence):java.lang.Comparable");
    }
}

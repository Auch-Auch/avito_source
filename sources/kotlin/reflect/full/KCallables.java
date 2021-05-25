package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a;\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\fH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\"&\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"&\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010\"*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017*\u0006\u0012\u0002\b\u00030\u00008F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/KCallable;", "", "name", "Lkotlin/reflect/KParameter;", "findParameterByName", "(Lkotlin/reflect/KCallable;Ljava/lang/String;)Lkotlin/reflect/KParameter;", "R", "", "", "args", "callSuspend", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callSuspendBy", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "extensionReceiverParameter", "getInstanceParameter", "getInstanceParameter$annotations", "instanceParameter", "", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "getValueParameters$annotations", "valueParameters", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "KCallables")
public final class KCallables {

    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0}, l = {55}, m = "callSuspend", n = {"$this$callSuspend"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return KCallables.callSuspend(null, null, this);
        }
    }

    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0}, l = {73}, m = "callSuspendBy", n = {"$this$callSuspendBy"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public Object c;
        public Object d;
        public Object e;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return KCallables.callSuspendBy(null, null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> java.lang.Object callSuspend(@org.jetbrains.annotations.NotNull kotlin.reflect.KCallable<? extends R> r4, @org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlin.reflect.full.KCallables$a r0 = (kotlin.reflect.full.KCallables.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlin.reflect.full.KCallables$a r0 = new kotlin.reflect.full.KCallables$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.d
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r4 = r0.c
            kotlin.reflect.KCallable r4 = (kotlin.reflect.KCallable) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x007c
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L_0x004c
            int r6 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.Object r4 = r4.call(r5)
            return r4
        L_0x004c:
            boolean r6 = r4 instanceof kotlin.reflect.KFunction
            if (r6 == 0) goto L_0x009e
            r0.c = r4
            r0.d = r5
            r0.b = r3
            kotlin.jvm.internal.SpreadBuilder r6 = new kotlin.jvm.internal.SpreadBuilder
            r2 = 2
            r6.<init>(r2)
            r6.addSpread(r5)
            r6.add(r0)
            int r5 = r6.size()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Object[] r5 = r6.toArray(r5)
            java.lang.Object r6 = r4.call(r5)
            java.lang.Object r5 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            if (r6 != r5) goto L_0x0079
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0079:
            if (r6 != r1) goto L_0x007c
            return r1
        L_0x007c:
            kotlin.reflect.KType r5 = r4.getReturnType()
            kotlin.reflect.KClassifier r5 = r5.getClassifier()
            java.lang.Class<kotlin.Unit> r0 = kotlin.Unit.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L_0x009d
            kotlin.reflect.KType r4 = r4.getReturnType()
            boolean r4 = r4.isMarkedNullable()
            if (r4 != 0) goto L_0x009d
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x009d:
            return r6
        L_0x009e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspend on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.callSuspend(kotlin.reflect.KCallable, java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> java.lang.Object callSuspendBy(@org.jetbrains.annotations.NotNull kotlin.reflect.KCallable<? extends R> r4, @org.jetbrains.annotations.NotNull java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlin.reflect.full.KCallables$b r0 = (kotlin.reflect.full.KCallables.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlin.reflect.full.KCallables$b r0 = new kotlin.reflect.full.KCallables$b
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r4 = r0.e
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r4 = r0.d
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.c
            kotlin.reflect.KCallable r4 = (kotlin.reflect.KCallable) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0076
        L_0x0035:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L_0x004b
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L_0x004b:
            boolean r6 = r4 instanceof kotlin.reflect.KFunction
            if (r6 == 0) goto L_0x00af
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.reflect.jvm.internal.KCallableImpl r2 = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(r4)
            if (r2 == 0) goto L_0x0098
            r6.element = r2
            r0.c = r4
            r0.d = r5
            r0.e = r6
            r0.b = r3
            kotlin.reflect.jvm.internal.KCallableImpl r2 = (kotlin.reflect.jvm.internal.KCallableImpl) r2
            java.lang.Object r6 = r2.callDefaultMethod$kotlin_reflection(r5, r0)
            java.lang.Object r5 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            if (r6 != r5) goto L_0x0073
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0073:
            if (r6 != r1) goto L_0x0076
            return r1
        L_0x0076:
            kotlin.reflect.KType r5 = r4.getReturnType()
            kotlin.reflect.KClassifier r5 = r5.getClassifier()
            java.lang.Class<kotlin.Unit> r0 = kotlin.Unit.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L_0x0097
            kotlin.reflect.KType r4 = r4.getReturnType()
            boolean r4 = r4.isMarkedNullable()
            if (r4 != 0) goto L_0x0097
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0097:
            return r6
        L_0x0098:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r5 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "This callable does not support a default call: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        L_0x00af:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspendBy on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.callSuspendBy(kotlin.reflect.KCallable, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final KParameter findParameterByName(@NotNull KCallable<?> kCallable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$findParameterByName");
        Intrinsics.checkNotNullParameter(str, "name");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        boolean z = false;
        T t2 = null;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (Intrinsics.areEqual(next.getName(), str)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    t2 = next;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    @Nullable
    public static final KParameter getExtensionReceiverParameter(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$extensionReceiverParameter");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        T t2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (next.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    t2 = next;
                    z = true;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    @Nullable
    public static final KParameter getInstanceParameter(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$instanceParameter");
        Iterator<T> it = kCallable.getParameters().iterator();
        T t = null;
        T t2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                if (next.getKind() == KParameter.Kind.INSTANCE) {
                    if (z) {
                        break;
                    }
                    t2 = next;
                    z = true;
                }
            } else if (z) {
                t = t2;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    @NotNull
    public static final List<KParameter> getValueParameters(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "$this$valueParameters");
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (T t : parameters) {
            if (t.getKind() == KParameter.Kind.VALUE) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }
}

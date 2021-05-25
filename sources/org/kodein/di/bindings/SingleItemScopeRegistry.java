package org.kodein.di.bindings;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010\u0018J7\u0010\n\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u00110\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lorg/kodein/di/bindings/SingleItemScopeRegistry;", "Lorg/kodein/di/bindings/ScopeRegistry;", "", "Lorg/kodein/di/bindings/RegKey;", "key", "", "sync", "Lkotlin/Function0;", "Lorg/kodein/di/bindings/Reference;", "creator", "getOrCreate", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "isEmpty", "()Z", "", "Lkotlin/Pair;", ResidentialComplexModuleKt.VALUES, "()Ljava/util/List;", "", ProductAction.ACTION_REMOVE, "(Ljava/lang/Object;)V", "clear", "()V", AuthSource.BOOKING_ORDER, "Lkotlin/Pair;", "_pair", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "_lock", "<init>", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SingleItemScopeRegistry extends ScopeRegistry {
    public final Object a = new Object();
    public volatile Pair<? extends Object, ? extends Function0<? extends Object>> b;

    public SingleItemScopeRegistry() {
        super(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // org.kodein.di.bindings.ScopeRegistry
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.a
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r3.b
            r2 = 0
            if (r1 != 0) goto L_0x0009
        L_0x0007:
            r0 = r2
            goto L_0x002c
        L_0x0009:
            if (r0 != 0) goto L_0x0018
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r0 = r3.b
            if (r0 == 0) goto L_0x0007
            java.lang.Object r0 = r0.component2()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3.b = r2
            goto L_0x002c
        L_0x0018:
            monitor-enter(r0)
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r3.b     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0028
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x0042 }
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1     // Catch:{ all -> 0x0042 }
            r3.b = r2     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)
            r0 = r1
            goto L_0x002c
        L_0x0028:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            monitor-exit(r0)
            goto L_0x0007
        L_0x002c:
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r0.invoke()
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            boolean r1 = r0 instanceof org.kodein.di.bindings.ScopeCloseable
            if (r1 != 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r2 = r0
        L_0x003a:
            org.kodein.di.bindings.ScopeCloseable r2 = (org.kodein.di.bindings.ScopeCloseable) r2
            if (r2 == 0) goto L_0x0041
            r2.close()
        L_0x0041:
            return
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.bindings.SingleItemScopeRegistry.clear():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dc  */
    @Override // org.kodein.di.bindings.ScopeRegistry
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getOrCreate(@org.jetbrains.annotations.NotNull java.lang.Object r4, boolean r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends org.kodein.di.bindings.Reference<? extends java.lang.Object>> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "creator"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r0 = 0
            if (r5 == 0) goto L_0x0010
            java.lang.Object r5 = r3.a
            goto L_0x0011
        L_0x0010:
            r5 = r0
        L_0x0011:
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r3.b
            if (r1 == 0) goto L_0x002a
            java.lang.Object r2 = r1.component1()
            java.lang.Object r1 = r1.component2()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)
            if (r2 == 0) goto L_0x002a
            java.lang.Object r1 = r1.invoke()
            goto L_0x002b
        L_0x002a:
            r1 = r0
        L_0x002b:
            if (r1 == 0) goto L_0x0033
            kotlin.Pair r4 = kotlin.TuplesKt.to(r0, r1)
            goto L_0x00c0
        L_0x0033:
            if (r5 != 0) goto L_0x0077
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r5 = r3.b
            if (r5 == 0) goto L_0x004e
            java.lang.Object r1 = r5.component1()
            java.lang.Object r5 = r5.component2()
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r1 == 0) goto L_0x004e
            java.lang.Object r5 = r5.invoke()
            goto L_0x004f
        L_0x004e:
            r5 = r0
        L_0x004f:
            if (r5 == 0) goto L_0x0052
            goto L_0x0096
        L_0x0052:
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r5 = r3.b
            if (r5 == 0) goto L_0x005d
            java.lang.Object r5 = r5.getSecond()
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            goto L_0x005e
        L_0x005d:
            r5 = r0
        L_0x005e:
            java.lang.Object r6 = r6.invoke()
            org.kodein.di.bindings.Reference r6 = (org.kodein.di.bindings.Reference) r6
            java.lang.Object r1 = r6.component1()
            kotlin.jvm.functions.Function0 r6 = r6.component2()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r6)
            r3.b = r4
            kotlin.Pair r4 = kotlin.TuplesKt.to(r5, r1)
            goto L_0x00c0
        L_0x0077:
            monitor-enter(r5)
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r3.b     // Catch:{ all -> 0x00e0 }
            if (r1 == 0) goto L_0x0091
            java.lang.Object r2 = r1.component1()     // Catch:{ all -> 0x00e0 }
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x00e0 }
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1     // Catch:{ all -> 0x00e0 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r2)     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r1 = r1.invoke()     // Catch:{ all -> 0x00e0 }
            goto L_0x0092
        L_0x0091:
            r1 = r0
        L_0x0092:
            if (r1 == 0) goto L_0x009b
            monitor-exit(r5)
            r5 = r1
        L_0x0096:
            kotlin.Pair r4 = kotlin.TuplesKt.to(r0, r5)
            goto L_0x00c0
        L_0x009b:
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r3.b
            if (r1 == 0) goto L_0x00a6
            java.lang.Object r1 = r1.getSecond()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            goto L_0x00a7
        L_0x00a6:
            r1 = r0
        L_0x00a7:
            java.lang.Object r6 = r6.invoke()
            org.kodein.di.bindings.Reference r6 = (org.kodein.di.bindings.Reference) r6
            java.lang.Object r2 = r6.component1()
            kotlin.jvm.functions.Function0 r6 = r6.component2()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r6)
            r3.b = r4
            kotlin.Pair r4 = kotlin.TuplesKt.to(r1, r2)
            monitor-exit(r5)
        L_0x00c0:
            java.lang.Object r5 = r4.component1()
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r4.component2()
            if (r5 == 0) goto L_0x00d1
            java.lang.Object r5 = r5.invoke()
            goto L_0x00d2
        L_0x00d1:
            r5 = r0
        L_0x00d2:
            boolean r6 = r5 instanceof org.kodein.di.bindings.ScopeCloseable
            if (r6 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r0 = r5
        L_0x00d8:
            org.kodein.di.bindings.ScopeCloseable r0 = (org.kodein.di.bindings.ScopeCloseable) r0
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            return r4
        L_0x00e0:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.bindings.SingleItemScopeRegistry.getOrCreate(java.lang.Object, boolean, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    @Nullable
    public Function0<Object> getOrNull(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "key");
        Pair<? extends Object, ? extends Function0<? extends Object>> pair = this.b;
        if (pair == null) {
            return null;
        }
        Object component1 = pair.component1();
        Function0<Object> function0 = (Function0) pair.component2();
        if (Intrinsics.areEqual(obj, component1)) {
            return function0;
        }
        return null;
    }

    public final boolean isEmpty() {
        return this.b == null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // org.kodein.di.bindings.ScopeRegistry
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.Object r0 = r5.a
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r5.b
            r2 = 0
            if (r1 != 0) goto L_0x000f
        L_0x000c:
            r0 = r2
            goto L_0x0088
        L_0x000f:
            if (r0 != 0) goto L_0x0049
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r0 = r5.b
            if (r0 == 0) goto L_0x000c
            java.lang.Object r1 = r0.component1()
            java.lang.Object r0 = r0.component2()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r6)
            r3 = r3 ^ 1
            if (r3 != 0) goto L_0x002a
            r5.b = r2
            goto L_0x0088
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SingleItemScopeRegistry currently holds a different key\n"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = " != "
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = r2.toString()
            r0.<init>(r6)
            throw r0
        L_0x0049:
            monitor-enter(r0)
            kotlin.Pair<? extends java.lang.Object, ? extends kotlin.jvm.functions.Function0<? extends java.lang.Object>> r1 = r5.b     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0084
            java.lang.Object r3 = r1.component1()     // Catch:{ all -> 0x009e }
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x009e }
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1     // Catch:{ all -> 0x009e }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)     // Catch:{ all -> 0x009e }
            r4 = r4 ^ 1
            if (r4 != 0) goto L_0x0065
            r5.b = r2     // Catch:{ all -> 0x009e }
            monitor-exit(r0)
            r0 = r1
            goto L_0x0088
        L_0x0065:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "SingleItemScopeRegistry currently holds a different key\n"
            r2.append(r4)
            r2.append(r6)
            java.lang.String r6 = " != "
            r2.append(r6)
            r2.append(r3)
            java.lang.String r6 = r2.toString()
            r1.<init>(r6)
            throw r1
        L_0x0084:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            monitor-exit(r0)
            goto L_0x000c
        L_0x0088:
            if (r0 == 0) goto L_0x008f
            java.lang.Object r6 = r0.invoke()
            goto L_0x0090
        L_0x008f:
            r6 = r2
        L_0x0090:
            boolean r0 = r6 instanceof org.kodein.di.bindings.ScopeCloseable
            if (r0 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r2 = r6
        L_0x0096:
            org.kodein.di.bindings.ScopeCloseable r2 = (org.kodein.di.bindings.ScopeCloseable) r2
            if (r2 == 0) goto L_0x009d
            r2.close()
        L_0x009d:
            return
        L_0x009e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.bindings.SingleItemScopeRegistry.remove(java.lang.Object):void");
    }

    @Override // org.kodein.di.bindings.ScopeRegistry
    @NotNull
    public List<Pair<Object, Function0<Object>>> values() {
        List<Pair<Object, Function0<Object>>> listOf;
        Pair<? extends Object, ? extends Function0<? extends Object>> pair = this.b;
        return (pair == null || (listOf = d.listOf(pair)) == null) ? CollectionsKt__CollectionsKt.emptyList() : listOf;
    }
}

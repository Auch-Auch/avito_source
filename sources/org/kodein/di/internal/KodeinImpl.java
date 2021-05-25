package org.kodein.di.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinTrigger;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rB,\b\u0016\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0004\b\f\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001d\u0010\u000b\u001a\u00020\u00068F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lorg/kodein/di/internal/KodeinImpl;", "Lorg/kodein/di/Kodein;", "Lorg/kodein/di/internal/KodeinContainerImpl;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/internal/KodeinContainerImpl;", "_container", "Lorg/kodein/di/KodeinContainer;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "<init>", "(Lorg/kodein/di/internal/KodeinContainerImpl;)V", "", "allowSilentOverride", "Lkotlin/Function1;", "Lorg/kodein/di/Kodein$MainBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "(ZLkotlin/jvm/functions/Function1;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class KodeinImpl implements Kodein {
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KodeinImpl.class), "container", "getContainer()Lorg/kodein/di/KodeinContainer;"))};
    @NotNull
    public final Lazy a;
    public final KodeinContainerImpl b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJB\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lorg/kodein/di/internal/KodeinImpl$Companion;", "", "", "allowSilentOverride", "Lkotlin/Function1;", "Lorg/kodein/di/Kodein$MainBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lkotlin/Pair;", "Lorg/kodein/di/Kodein;", "Lkotlin/Function0;", "withDelayedCallbacks", "(ZLkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ KodeinImpl a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(KodeinImpl kodeinImpl) {
                super(0);
                this.a = kodeinImpl;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                Function0<Unit> initCallbacks = this.a.b.getInitCallbacks();
                if (initCallbacks != null) {
                    initCallbacks.invoke();
                }
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        public static final KodeinMainBuilderImpl access$newBuilder(Companion companion, boolean z, Function1 function1) {
            Objects.requireNonNull(companion);
            KodeinMainBuilderImpl kodeinMainBuilderImpl = new KodeinMainBuilderImpl(z);
            function1.invoke(kodeinMainBuilderImpl);
            return kodeinMainBuilderImpl;
        }

        public static /* synthetic */ Pair withDelayedCallbacks$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.withDelayedCallbacks(z, function1);
        }

        @NotNull
        public final Pair<Kodein, Function0<Unit>> withDelayedCallbacks(boolean z, @NotNull Function1<? super Kodein.MainBuilder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "init");
            KodeinMainBuilderImpl kodeinMainBuilderImpl = new KodeinMainBuilderImpl(z);
            function1.invoke(kodeinMainBuilderImpl);
            KodeinImpl kodeinImpl = new KodeinImpl(kodeinMainBuilderImpl, false, null);
            return TuplesKt.to(kodeinImpl, new a(kodeinImpl));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<KodeinContainerImpl> {
        public final /* synthetic */ KodeinImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KodeinImpl kodeinImpl) {
            super(0);
            this.a = kodeinImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KodeinContainerImpl invoke() {
            if (this.a.b.getInitCallbacks() == null) {
                return this.a.b;
            }
            throw new IllegalStateException("Kodein has not been initialized");
        }
    }

    public KodeinImpl(@NotNull KodeinContainerImpl kodeinContainerImpl) {
        Intrinsics.checkParameterIsNotNull(kodeinContainerImpl, "_container");
        this.b = kodeinContainerImpl;
        this.a = c.lazy(new a(this));
    }

    @Override // org.kodein.di.Kodein
    @NotNull
    public final KodeinContainer getContainer() {
        Lazy lazy = this.a;
        KProperty kProperty = c[0];
        return (KodeinContainer) lazy.getValue();
    }

    @Override // org.kodein.di.Kodein, org.kodein.di.KodeinAware
    @NotNull
    public Kodein getKodein() {
        return Kodein.DefaultImpls.getKodein(this);
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public KodeinContext<?> getKodeinContext() {
        return Kodein.DefaultImpls.getKodeinContext(this);
    }

    @Override // org.kodein.di.KodeinAware
    @Nullable
    public KodeinTrigger getKodeinTrigger() {
        return Kodein.DefaultImpls.getKodeinTrigger(this);
    }

    public KodeinImpl(KodeinMainBuilderImpl kodeinMainBuilderImpl, boolean z, j jVar) {
        this(new KodeinContainerImpl(kodeinMainBuilderImpl.getContainerBuilder(), kodeinMainBuilderImpl.getExternalSources(), kodeinMainBuilderImpl.getFullDescriptionOnError(), z));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodeinImpl(boolean r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super org.kodein.di.Kodein.MainBuilder, kotlin.Unit> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            org.kodein.di.internal.KodeinImpl$Companion r0 = org.kodein.di.internal.KodeinImpl.Companion
            org.kodein.di.internal.KodeinMainBuilderImpl r4 = org.kodein.di.internal.KodeinImpl.Companion.access$newBuilder(r0, r4, r5)
            org.kodein.di.internal.KodeinContainerImpl r5 = new org.kodein.di.internal.KodeinContainerImpl
            org.kodein.di.internal.KodeinContainerBuilderImpl r0 = r4.getContainerBuilder()
            java.util.List r1 = r4.getExternalSources()
            boolean r4 = r4.getFullDescriptionOnError()
            r2 = 1
            r5.<init>(r0, r1, r4, r2)
            r3.<init>(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.internal.KodeinImpl.<init>(boolean, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KodeinImpl(boolean z, Function1 function1, int i, j jVar) {
        this((i & 1) != 0 ? false : z, function1);
    }
}

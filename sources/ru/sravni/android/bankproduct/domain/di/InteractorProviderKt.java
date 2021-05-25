package ru.sravni.android.bankproduct.domain.di;

import a7.c.a.a.l.a.b;
import a7.c.a.a.l.a.c;
import a7.c.a.a.l.a.d;
import a7.c.a.a.l.a.e;
import a7.c.a.a.l.a.f;
import a7.c.a.a.l.a.g;
import a7.c.a.a.l.a.h;
import a7.c.a.a.l.a.i;
import a7.c.a.a.l.a.j;
import a7.c.a.a.l.a.k;
import a7.c.a.a.l.a.l;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.Singleton;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/kodein/di/Kodein$Module;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Module;", "getInteractorKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "interactorKodeinModule", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class InteractorProviderKt {
    @NotNull
    public static final Kodein.Module a = new Kodein.Module("interactorKodeinModule", false, null, a.a, 6, null);

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            Kodein.Builder.DefaultImpls.constant$default(builder2, "splashDelay", null, 2, null).With(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$with$1()), 1L);
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$1()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$1()), null, true, d.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$2()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$2()), null, true, e.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$3()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$provider$1()), f.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$4()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$3()), null, true, g.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$5()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$4()), null, true, h.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$6()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$5()), null, true, i.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$7()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$6()), null, true, j.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$8()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$7()), null, true, k.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$9()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$8()), null, true, l.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$10()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$9()), null, true, a7.c.a.a.l.a.a.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$11()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$10()), null, true, b.a));
            builder2.Bind(TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$bind$12()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new InteractorProviderKt$interactorKodeinModule$1$$special$$inlined$singleton$11()), null, true, c.a));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module getInteractorKodeinModule() {
        return a;
    }
}

package ru.sravni.android.bankproduct.analytic.di;

import a7.c.a.a.j.a.b;
import a7.c.a.a.j.a.c;
import a7.c.a.a.j.a.d;
import a7.c.a.a.j.a.e;
import a7.c.a.a.j.a.f;
import a7.c.a.a.j.a.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Singleton;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\t\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\b\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lorg/kodein/di/Kodein$Module;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Module;", "getAnalyticKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "analyticKodeinModule", AuthSource.BOOKING_ORDER, "getAnalyticKodeinModuleV2", "analyticKodeinModuleV2", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class AnalyticProviderKt {
    @NotNull
    public static final Kodein.Module a = new Kodein.Module("analyticKodeinModule", false, null, a.b, 6, null);
    @NotNull
    public static final Kodein.Module b = new Kodein.Module("analyticKodeinModuleV2", false, null, a.c, 6, null);

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Kodein.Builder builder) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkParameterIsNotNull(builder, "$receiver");
                return Unit.INSTANCE;
            } else if (i == 1) {
                Kodein.Builder builder2 = builder;
                Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$1()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$1()), null, true, a7.c.a.a.j.a.a.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$2()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$2()), null, true, b.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$3()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$3()), null, true, c.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$4()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$4()), null, true, d.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$5()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$5()), null, true, e.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$6()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$6()), null, true, f.a));
                builder2.Bind(TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$bind$7()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new AnalyticProviderKt$analyticKodeinModuleV2$1$$special$$inlined$singleton$7()), null, true, g.a));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @NotNull
    public static final Kodein.Module getAnalyticKodeinModule() {
        return a;
    }

    @NotNull
    public static final Kodein.Module getAnalyticKodeinModuleV2() {
        return b;
    }
}

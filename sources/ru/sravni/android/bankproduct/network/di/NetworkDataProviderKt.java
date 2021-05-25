package ru.sravni.android.bankproduct.network.di;

import a7.c.a.a.n.d.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "serverHostConfig", "Lorg/kodein/di/Kodein$Module;", "networkKodeinModule", "(Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;)Lorg/kodein/di/Kodein$Module;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class NetworkDataProviderKt {

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public final /* synthetic */ SravniNetworkConfiguration a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SravniNetworkConfiguration sravniNetworkConfiguration) {
            super(1);
            this.a = sravniNetworkConfiguration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            Kodein.Builder.DefaultImpls.import$default(builder2, NetworkClientProviderKt.getNetworkClientKodeinModule(), false, 2, null);
            builder2.Bind(TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$bind$1()), "connectionTimeout", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$provider$1()), new b6(0, this)));
            builder2.Bind(TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$bind$2()), "readTimeout", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$provider$2()), new b6(1, this)));
            builder2.Bind(TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$bind$3()), "callTimeout", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$provider$3()), new b6(2, this)));
            builder2.Bind(TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$bind$4()), "baseUrl", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new NetworkDataProviderKt$networkKodeinModule$1$$special$$inlined$provider$4()), new c(this)));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module networkKodeinModule(@NotNull SravniNetworkConfiguration sravniNetworkConfiguration) {
        Intrinsics.checkParameterIsNotNull(sravniNetworkConfiguration, "serverHostConfig");
        return new Kodein.Module("networkKodeinModule", false, null, new a(sravniNetworkConfiguration), 6, null);
    }
}

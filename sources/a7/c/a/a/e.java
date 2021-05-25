package a7.c.a.a;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Kodein;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.di.BankLibraryProviderKt;
import ru.sravni.android.bankproduct.di.MockDataProviderKt;
import ru.sravni.android.bankproduct.di.buildlevel.debug.BuildProviderKt;
import ru.sravni.android.bankproduct.network.di.NetworkDataProviderKt;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
import ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt;
import ru.sravni.android.bankproduct.presentation.navigation.di.NavigationKodeinModuleKt;
public final class e extends Lambda implements Function1<Kodein.MainBuilder, Unit> {
    public final /* synthetic */ SravniChatActivity a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SravniNetworkConfiguration c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(SravniChatActivity sravniChatActivity, boolean z, SravniNetworkConfiguration sravniNetworkConfiguration) {
        super(1);
        this.a = sravniChatActivity;
        this.b = z;
        this.c = sravniNetworkConfiguration;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Kodein.MainBuilder mainBuilder) {
        Kodein.MainBuilder mainBuilder2 = mainBuilder;
        Intrinsics.checkParameterIsNotNull(mainBuilder2, "$receiver");
        if (this.b) {
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, BuildProviderKt.getDebugBuildTypeKodeinModule(), false, 2, null);
        } else {
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, ru.sravni.android.bankproduct.di.buildlevel.release.BuildProviderKt.getReleaseBuildTypeKodeinModule(), false, 2, null);
        }
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, BankLibraryProviderKt.getBankLibraryKodeinModule(), false, 2, null);
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, PresentationMainProviderKt.getPresentationMainKodeinModule(), false, 2, null);
        Kodein.Builder.DefaultImpls.import$default(mainBuilder2, NavigationKodeinModuleKt.getNavigationKodeinModule(), false, 2, null);
        SravniNetworkConfiguration sravniNetworkConfiguration = this.c;
        if (sravniNetworkConfiguration == null) {
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, MockDataProviderKt.getMockDataKodeinModule(), false, 2, null);
        } else {
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, NetworkDataProviderKt.networkKodeinModule(sravniNetworkConfiguration), false, 2, null);
        }
        mainBuilder2.Bind(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$bind$1
        }), null, null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new TypeReference<SravniChatActivity>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$provider$1
        }), new b(this)));
        mainBuilder2.Bind(TypesKt.TT(new TypeReference<Intent>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$bind$2
        }), null, null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new TypeReference<Intent>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$provider$2
        }), new c(this)));
        mainBuilder2.Bind(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$bind$3
        }), "avitoDefaultSettedPhone", null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$makeKodein$1$$special$$inlined$provider$3
        }), new d(this)));
        return Unit.INSTANCE;
    }
}

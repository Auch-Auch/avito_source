package a7.c.a.a.o.a.c.a;

import androidx.fragment.app.FragmentActivity;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Copy;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.di.PresentationTokenFailKodeinModuleKt;
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.view.TokenRefreshDialog;
public final class b extends Lambda implements Function1<Kodein.MainBuilder, Unit> {
    public final /* synthetic */ TokenRefreshDialog a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(TokenRefreshDialog tokenRefreshDialog) {
        super(1);
        this.a = tokenRefreshDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Kodein.MainBuilder mainBuilder) {
        Kodein.MainBuilder mainBuilder2 = mainBuilder;
        Intrinsics.checkParameterIsNotNull(mainBuilder2, "$receiver");
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            Kodein.MainBuilder.DefaultImpls.extend$default(mainBuilder2, ((KodeinAware) activity).getKodein(), false, (Copy) null, 6, (Object) null);
            mainBuilder2.Bind(TypesKt.TT(new TypeReference<TokenRefreshDialog>() { // from class: ru.sravni.android.bankproduct.presentation.auth.tokenfail.view.TokenRefreshDialog$initKodein$1$$special$$inlined$bind$1
            }), null, null).with(new Provider(mainBuilder2.getContextType(), TypesKt.TT(new TypeReference<TokenRefreshDialog>() { // from class: ru.sravni.android.bankproduct.presentation.auth.tokenfail.view.TokenRefreshDialog$initKodein$1$$special$$inlined$provider$1
            }), new a(this)));
            Kodein.Builder.DefaultImpls.import$default(mainBuilder2, PresentationTokenFailKodeinModuleKt.getPresentationTokenFailKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.KodeinAware");
    }
}

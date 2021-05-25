package a7.c.a.a.l.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoRepository;
import ru.sravni.android.bankproduct.domain.offer.osago.OfferOsagoInteractor;
public final class g extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, OfferOsagoInteractor> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferOsagoInteractor invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new OfferOsagoInteractor((IOfferOsagoRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferOsagoRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$4$$special$$inlined$instance$1
        }), null));
    }
}

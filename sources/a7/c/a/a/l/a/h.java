package a7.c.a.a.l.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductRepository;
import ru.sravni.android.bankproduct.domain.offer.product.OfferProductInteractor;
public final class h extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, OfferProductInteractor> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductInteractor invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new OfferProductInteractor((IOfferProductRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$5$$special$$inlined$instance$1
        }), null));
    }
}

package a7.c.a.a.m;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.mock.webclient.OfferProductWebClientStub;
import ru.sravni.android.bankproduct.mock.webclient.OfferProductWebClientStubInfo;
public final class o extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, OfferProductWebClientStub> {
    public static final o a = new o();

    public o() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductWebClientStub invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new OfferProductWebClientStub(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$9$$special$$inlined$instance$1
        }), "delay")).longValue(), (Context) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$9$$special$$inlined$instance$2
        }), null), (OfferProductWebClientStubInfo) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<OfferProductWebClientStubInfo>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$9$$special$$inlined$instance$3
        }), null));
    }
}

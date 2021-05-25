package a7.c.a.a.m;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.mock.auth.IAuthAccessData;
import ru.sravni.android.bankproduct.mock.webclient.DashBoardWebClientStub;
import ru.sravni.android.bankproduct.mock.webclient.DashBoardWebClientStubInfo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
public final class b extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, DashBoardWebClientStub> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public DashBoardWebClientStub invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new DashBoardWebClientStub(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$11$$special$$inlined$instance$1
        }), "delay")).longValue(), (ITokenRefresher) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRefresher>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$11$$special$$inlined$instance$2
        }), null), (IAuthAccessData) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthAccessData>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$11$$special$$inlined$instance$3
        }), null), (Context) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$11$$special$$inlined$instance$4
        }), null), (DashBoardWebClientStubInfo) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<DashBoardWebClientStubInfo>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$11$$special$$inlined$instance$5
        }), null));
    }
}

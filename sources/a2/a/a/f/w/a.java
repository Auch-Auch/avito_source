package a2.a.a.f.w;

import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ AutotekaCpoProgramPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AutotekaCpoProgramPresenterImpl autotekaCpoProgramPresenterImpl) {
        super(1);
        this.a = autotekaCpoProgramPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        AutotekaCpoProgramPresenter.Router router = this.a.b;
        if (router != null) {
            router.close();
        }
        return Unit.INSTANCE;
    }
}

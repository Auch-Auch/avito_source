package a2.a.a.e2.v;

import com.avito.android.publish.infomodel_request.InfomodelRequestViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ InfomodelRequestViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(InfomodelRequestViewModel infomodelRequestViewModel) {
        super(0);
        this.a = infomodelRequestViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.onRetryClicked();
        return Unit.INSTANCE;
    }
}

package a2.a.a.e2.u;

import com.avito.android.publish.edit_advert_request.EditAdvertRequestViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ EditAdvertRequestViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(EditAdvertRequestViewModel editAdvertRequestViewModel) {
        super(0);
        this.a = editAdvertRequestViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.onRetryClicked();
        return Unit.INSTANCE;
    }
}

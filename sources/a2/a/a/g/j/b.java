package a2.a.a.g.j;

import com.avito.android.advert_core.phone_request.PhoneRequestPresenterImpl;
import com.avito.android.advert_core.phone_request.PhoneRequestRouter;
import com.avito.android.remote.error.TypedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<TypedError, Unit> {
    public final /* synthetic */ PhoneRequestPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PhoneRequestPresenterImpl phoneRequestPresenterImpl) {
        super(1);
        this.a = phoneRequestPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(TypedError typedError) {
        Intrinsics.checkNotNullParameter(typedError, "it");
        PhoneRequestRouter phoneRequestRouter = this.a.a;
        if (phoneRequestRouter != null) {
            phoneRequestRouter.leaveScreen();
        }
        return Unit.INSTANCE;
    }
}

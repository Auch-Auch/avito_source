package a2.a.a.e2.w;

import android.view.View;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Exception, Unit> {
    public final /* synthetic */ InputVinFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(InputVinFragment inputVinFragment) {
        super(1);
        this.a = inputVinFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        View view = this.a.getView();
        if (view != null) {
            Views.showSnackBar$default(view, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
        return Unit.INSTANCE;
    }
}

package a2.a.a.p3.a.a;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.util.architecture_components.IntentDataHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d a;
    public final /* synthetic */ IntentDataHolder b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, IntentDataHolder intentDataHolder) {
        super(0);
        this.a = dVar;
        this.b = intentDataHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        FragmentActivity activity = this.a.a.getActivity();
        if (activity != null) {
            activity.finish();
        }
        this.a.a.startActivity(this.b.getIntent());
        return Unit.INSTANCE;
    }
}

package a2.a.a.e2.e0;

import com.avito.android.publish.start_publish.StartPublishFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ StartPublishFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(StartPublishFragment startPublishFragment) {
        super(0);
        this.a = startPublishFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.j = null;
        this.a.onBackPressed();
        return Unit.INSTANCE;
    }
}

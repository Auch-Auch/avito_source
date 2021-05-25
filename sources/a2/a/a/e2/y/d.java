package a2.a.a.e2.y;

import com.avito.android.publish.premoderation.PremoderationRequestViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PremoderationRequestViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(PremoderationRequestViewModel premoderationRequestViewModel) {
        super(0);
        this.a = premoderationRequestViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.onRetryClicked();
        return Unit.INSTANCE;
    }
}

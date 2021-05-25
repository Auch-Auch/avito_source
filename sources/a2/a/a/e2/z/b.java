package a2.a.a.e2.z;

import com.avito.android.publish.pretend.PretendViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PretendViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PretendViewModel pretendViewModel) {
        super(0);
        this.a = pretendViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.onRetryClicked();
        return Unit.INSTANCE;
    }
}

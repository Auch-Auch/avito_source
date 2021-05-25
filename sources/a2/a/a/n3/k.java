package a2.a.a.n3;

import com.avito.android.util.InitializeOperator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class k extends Lambda implements Function0<Unit> {
    public final /* synthetic */ InitializeOperator.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(InitializeOperator.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (this.a.d.isInitialized()) {
            InitializeOperator.a aVar = this.a;
            List<T> list = aVar.b;
            if (list != null) {
                for (T t : list) {
                    aVar.onNext(t);
                }
            }
            aVar.b = null;
        } else {
            this.a.onError(new IllegalStateException("Initializable not initialized"));
        }
        return Unit.INSTANCE;
    }
}

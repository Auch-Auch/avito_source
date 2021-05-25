package a2.a.a.e2;

import com.avito.android.publish.PublishParametersInteractor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<PublishParametersInteractor.Data> {
    public final /* synthetic */ d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public PublishParametersInteractor.Data invoke() {
        return new PublishParametersInteractor.Data(this.a.a, null, 2, null);
    }
}

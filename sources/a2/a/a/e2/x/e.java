package a2.a.a.e2.x;

import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        super(0);
        this.a = objectsEditPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ObjectsEditPresenterImpl.access$deleteParameters(this.a);
        return Unit.INSTANCE;
    }
}

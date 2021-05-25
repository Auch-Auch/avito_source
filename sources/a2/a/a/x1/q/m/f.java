package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(CameraItemPresenterImpl cameraItemPresenterImpl) {
        super(1);
        this.a = cameraItemPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        CameraItemPresenterImpl.access$updateEnablePermissionsButtonText(this.a, bool.booleanValue());
        return Unit.INSTANCE;
    }
}

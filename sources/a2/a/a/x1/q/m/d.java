package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CameraItemPresenterImpl.g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(CameraItemPresenterImpl.g gVar) {
        super(0);
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        CameraItemPresenter.Router router = this.a.a.d;
        if (router != null) {
            router.openAppSettings();
        }
        return Unit.INSTANCE;
    }
}

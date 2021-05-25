package defpackage;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: f5  reason: default package */
public final class f5 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f5(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        int i = this.a;
        if (i == 0) {
            CameraItemPresenterImpl.access$initCameraIfFirstTime((CameraItemPresenterImpl) this.b);
            return Unit.INSTANCE;
        } else if (i == 1) {
            CameraItemPresenterImpl.access$initGalleryButton((CameraItemPresenterImpl) this.b);
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

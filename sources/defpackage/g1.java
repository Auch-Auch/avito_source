package defpackage;

import com.avito.android.photo_picker.camera.CameraViewModel;
import com.avito.android.photo_picker.legacy.CameraInteractor;
import io.reactivex.functions.Consumer;
import org.funktionale.option.Option;
/* compiled from: java-style lambda group */
/* renamed from: g1  reason: default package */
public final class g1<T> implements Consumer<Option<? extends CameraInteractor>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public g1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Option<? extends CameraInteractor> option) {
        int i = this.a;
        if (i == 0) {
            CameraInteractor cameraInteractor = (CameraInteractor) option.orNull();
            if (cameraInteractor != null) {
                cameraInteractor.prepareCamera(((CameraViewModel) this.b).u.getRotation(), ((CameraViewModel) this.b).c());
            }
        } else if (i == 1) {
            Option<? extends CameraInteractor> option2 = option;
            if (!option2.isEmpty()) {
                ((CameraViewModel) this.b).c = (CameraInteractor) option2.get();
                CameraViewModel.access$startPreview((CameraViewModel) this.b);
            }
        } else {
            throw null;
        }
    }
}

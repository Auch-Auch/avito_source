package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public a(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        CameraItemView cameraItemView = this.a.a;
        if (cameraItemView != null) {
            cameraItemView.hideDescription();
        }
    }
}

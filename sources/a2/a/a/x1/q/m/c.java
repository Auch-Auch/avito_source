package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public c(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        CameraItemView cameraItemView = this.a.a;
        if (cameraItemView != null) {
            cameraItemView.showNoImagesFromGalleryAvailable();
        }
    }
}

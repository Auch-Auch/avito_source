package a2.a.a.x1.q.m;

import android.graphics.Bitmap;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import io.reactivex.functions.Consumer;
import org.funktionale.option.Option;
public final class b<T> implements Consumer<Option<? extends Bitmap>> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    public b(CameraItemPresenterImpl cameraItemPresenterImpl) {
        this.a = cameraItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Option<? extends Bitmap> option) {
        Option<? extends Bitmap> option2 = option;
        if (option2.isEmpty()) {
            CameraItemView cameraItemView = this.a.a;
            if (cameraItemView != null) {
                cameraItemView.showNoImagesFromGalleryAvailable();
                return;
            }
            return;
        }
        CameraItemView cameraItemView2 = this.a.a;
        if (cameraItemView2 != null) {
            cameraItemView2.setGalleryButtonSrc((Bitmap) option2.get());
        }
    }
}

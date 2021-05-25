package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> {
    public final /* synthetic */ CameraItemPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(CameraItemPresenterImpl cameraItemPresenterImpl) {
        super(1);
        this.a = cameraItemPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
        CameraItemView cameraItemView;
        CameraItemView cameraItemView2;
        Pair<? extends Boolean, ? extends Boolean> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "it");
        boolean booleanValue = ((Boolean) pair2.getFirst()).booleanValue();
        boolean booleanValue2 = ((Boolean) pair2.getSecond()).booleanValue();
        boolean z = booleanValue2 || booleanValue;
        if (booleanValue2) {
            this.a.f();
            CameraItemView cameraItemView3 = this.a.a;
            if (cameraItemView3 != null) {
                cameraItemView3.hideCameraPlaceholders();
            }
        } else {
            CameraItemView cameraItemView4 = this.a.a;
            if (cameraItemView4 != null) {
                cameraItemView4.showNoCameraPermissionPlaceholder();
            }
        }
        if (!booleanValue && (cameraItemView2 = this.a.a) != null) {
            cameraItemView2.showNoImagesFromGalleryAvailable();
        }
        if (!z && (cameraItemView = this.a.a) != null) {
            cameraItemView.setGalleryButtonHidden();
        }
        CameraItemView cameraItemView5 = this.a.a;
        if (cameraItemView5 != null) {
            cameraItemView5.setCameraControlsVisible(z);
        }
        CameraItemPresenterImpl.access$setPhotoSourcesChanged(this.a, z);
        return Unit.INSTANCE;
    }
}

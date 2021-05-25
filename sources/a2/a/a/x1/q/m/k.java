package a2.a.a.x1.q.m;

import android.view.View;
import com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl;
public final class k implements View.OnClickListener {
    public final /* synthetic */ CameraItemViewImpl a;

    public k(CameraItemViewImpl cameraItemViewImpl) {
        this.a = cameraItemViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.O.onAllowCameraAccessClicked();
    }
}

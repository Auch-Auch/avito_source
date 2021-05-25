package a2.a.a.x1;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.PhotoPickerActivity;
import com.avito.android.photo_picker.PhotoPickerViewModel;
public final class b<T> implements Observer<PhotoPickerViewModel.RoutingAction> {
    public final /* synthetic */ PhotoPickerActivity a;

    public b(PhotoPickerActivity photoPickerActivity) {
        this.a = photoPickerActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhotoPickerViewModel.RoutingAction routingAction) {
        PhotoPickerViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToGalleryScreen) {
            PhotoPickerActivity.access$startInAppGallery(this.a);
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToSystemGalleryScreen) {
            PhotoPickerActivity.access$showSystemGallery(this.a, ((PhotoPickerViewModel.RoutingAction.ToSystemGalleryScreen) routingAction2).getPickMultiple());
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToSystemSettings) {
            this.a.openAppSettings();
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToExit) {
            PhotoPickerActivity.access$setResultAndFinish(this.a);
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToExitWithSuccess) {
            this.a.onSubmit();
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToCameraScreen) {
            PhotoPickerActivity.access$showCameraFragment(this.a);
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToEditPhotoScreen) {
            PhotoPickerActivity.access$showPhotoEditFragment(this.a, ((PhotoPickerViewModel.RoutingAction.ToEditPhotoScreen) routingAction2).getPhotoId());
        } else if (routingAction2 instanceof PhotoPickerViewModel.RoutingAction.ToEdit) {
            PhotoPickerActivity.access$openEdit(this.a, ((PhotoPickerViewModel.RoutingAction.ToEdit) routingAction2).getPhotos());
        }
    }
}

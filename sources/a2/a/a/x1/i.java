package a2.a.a.x1;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import io.reactivex.functions.Action;
public final class i implements Action {
    public final /* synthetic */ PhotoPickerViewModel a;

    public i(PhotoPickerViewModel photoPickerViewModel) {
        this.a = photoPickerViewModel;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        PhotoPickerViewModel.access$onPhotosLoaded(this.a);
    }
}

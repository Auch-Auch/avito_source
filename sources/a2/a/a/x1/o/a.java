package a2.a.a.x1.o;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.edit.EditPhotoFragment;
import com.avito.android.photo_picker.edit.EditPhotoViewModel;
import com.avito.android.util.ToastsKt;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<EditPhotoViewModel.ViewState> {
    public final /* synthetic */ EditPhotoFragment a;

    public a(EditPhotoFragment editPhotoFragment) {
        this.a = editPhotoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(EditPhotoViewModel.ViewState viewState) {
        EditPhotoViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof EditPhotoViewModel.ViewState.ShowImage) {
            EditPhotoViewModel.ViewState.ShowImage showImage = (EditPhotoViewModel.ViewState.ShowImage) viewState2;
            EditPhotoFragment.access$setImage(this.a, showImage.getUri(), showImage.getState());
        } else if (viewState2 instanceof EditPhotoViewModel.ViewState.OpenError) {
            Context requireContext = this.a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ToastsKt.showToast$default(requireContext, R.string.photo_edit_open_error, 0, 2, (Object) null);
            EditPhotoFragment.access$closeScreen(this.a);
        } else if (viewState2 instanceof EditPhotoViewModel.ViewState.CloseScreen) {
            EditPhotoFragment.access$closeScreen(this.a);
        } else if (viewState2 instanceof EditPhotoViewModel.ViewState.SaveAndClosePhoto) {
            EditPhotoFragment.access$getPhotoPickerViewModel$p(this.a).editPhoto(((EditPhotoViewModel.ViewState.SaveAndClosePhoto) viewState2).getEditedPhoto());
            EditPhotoFragment.access$closeScreen(this.a);
        } else if (viewState2 instanceof EditPhotoViewModel.ViewState.SaveError) {
            Context requireContext2 = this.a.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            ToastsKt.showToast$default(requireContext2, R.string.photo_edit_save_result_error, 0, 2, (Object) null);
            EditPhotoFragment.access$closeScreen(this.a);
        } else if (viewState2 instanceof EditPhotoViewModel.ViewState.Rotate) {
            EditPhotoFragment.access$rotateImage(this.a, (float) ((EditPhotoViewModel.ViewState.Rotate) viewState2).getByAngle());
        }
    }
}

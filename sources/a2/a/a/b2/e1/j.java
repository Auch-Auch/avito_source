package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfilePresenterImpl;
import com.avito.android.profile.edit.EditProfileView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<Disposable> {
    public final /* synthetic */ EditProfilePresenterImpl a;

    public j(EditProfilePresenterImpl editProfilePresenterImpl) {
        this.a = editProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        EditProfileView editProfileView = this.a.b;
        if (editProfileView != null) {
            editProfileView.showSavingProgress();
        }
        EditProfileView editProfileView2 = this.a.b;
        if (editProfileView2 != null) {
            editProfileView2.setSaveEnabled(false);
        }
    }
}

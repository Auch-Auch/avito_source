package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfilePresenterImpl;
import com.avito.android.profile.edit.EditProfileView;
import io.reactivex.functions.Action;
public final class k implements Action {
    public final /* synthetic */ EditProfilePresenterImpl a;

    public k(EditProfilePresenterImpl editProfilePresenterImpl) {
        this.a = editProfilePresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        EditProfileView editProfileView = this.a.b;
        if (editProfileView != null) {
            editProfileView.showContent();
        }
        this.a.a();
    }
}

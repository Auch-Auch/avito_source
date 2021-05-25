package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.profile.edit.EditProfilePresenterImpl;
import com.avito.android.profile.edit.EditProfileView;
import com.avito.android.profile.edit.ProfileSavingResult;
import io.reactivex.functions.Consumer;
public final class l<T> implements Consumer<ProfileSavingResult> {
    public final /* synthetic */ EditProfilePresenterImpl a;

    public l(EditProfilePresenterImpl editProfilePresenterImpl) {
        this.a = editProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(ProfileSavingResult profileSavingResult) {
        EditProfileView editProfileView;
        ProfileSavingResult profileSavingResult2 = profileSavingResult;
        if (profileSavingResult2 instanceof ProfileSavingResult.Completed) {
            EditProfilePresenter.Router router = this.a.a;
            if (router != null) {
                router.close(true);
            }
        } else if ((profileSavingResult2 instanceof ProfileSavingResult.Failed) && (editProfileView = this.a.b) != null) {
            editProfileView.showSavingError(this.a.m.format(((ProfileSavingResult.Failed) profileSavingResult2).getError()));
        }
        if (profileSavingResult2 instanceof ProfileSavingResult.PhoneNotConfirmed) {
            EditProfilePresenter.Router router2 = this.a.a;
            if (router2 != null) {
                router2.openPhoneVerificationScreen(((ProfileSavingResult.PhoneNotConfirmed) profileSavingResult2).getPhoneNumber());
            }
        } else if (profileSavingResult2 instanceof ProfileSavingResult.Invalidate) {
            EditProfilePresenterImpl.access$applyErrors(this.a, ((ProfileSavingResult.Invalidate) profileSavingResult2).getErrors());
        } else if (profileSavingResult2 instanceof ProfileSavingResult.ItemsNotActual) {
            this.a.b(((ProfileSavingResult.ItemsNotActual) profileSavingResult2).getItems());
        }
    }
}

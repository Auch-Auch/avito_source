package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfileInteractorImpl;
import com.avito.android.profile.edit.ProfileSavingResult;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<ProfileSavingResult> {
    public final /* synthetic */ EditProfileInteractorImpl a;

    public h(EditProfileInteractorImpl editProfileInteractorImpl) {
        this.a = editProfileInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ProfileSavingResult profileSavingResult) {
        ProfileSavingResult profileSavingResult2 = profileSavingResult;
        if (profileSavingResult2 instanceof ProfileSavingResult.PhoneNotConfirmed) {
            this.a.a = ((ProfileSavingResult.PhoneNotConfirmed) profileSavingResult2).getPhoneNumber();
        }
    }
}

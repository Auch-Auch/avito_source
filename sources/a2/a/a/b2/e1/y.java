package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import io.reactivex.functions.Function;
public final class y<T, R> implements Function<Boolean, ProfileSavingResult> {
    public final /* synthetic */ String a;

    public y(SaveProfileInteractorImpl saveProfileInteractorImpl, String str, boolean z) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileSavingResult apply(Boolean bool) {
        if (bool.booleanValue()) {
            return new ProfileSavingResult.Completed();
        }
        return new ProfileSavingResult.PhoneNotConfirmed(this.a);
    }
}

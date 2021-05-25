package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.refactoring.adapter.item.AvatarItem;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<ProfileSavingResult> {
    public final /* synthetic */ AvatarItem a;

    public e(AvatarItem avatarItem) {
        this.a = avatarItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ProfileSavingResult profileSavingResult) {
        this.a.setChanged(false);
    }
}

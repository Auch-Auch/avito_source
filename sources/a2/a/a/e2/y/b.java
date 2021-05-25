package a2.a.a.e2.y;

import androidx.lifecycle.Observer;
import com.avito.android.publish.premoderation.PremoderationRequestFragment;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
public final class b<T> implements Observer<AdvertProactiveModerationResult> {
    public final /* synthetic */ PremoderationRequestFragment a;

    public b(PremoderationRequestFragment premoderationRequestFragment) {
        this.a = premoderationRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AdvertProactiveModerationResult advertProactiveModerationResult) {
        AdvertProactiveModerationResult advertProactiveModerationResult2 = advertProactiveModerationResult;
        if (advertProactiveModerationResult2 instanceof AdvertProactiveModerationResult.Duplicate) {
            PremoderationRequestFragment.access$showAdvertDuplicateScreen(this.a, ((AdvertProactiveModerationResult.Duplicate) advertProactiveModerationResult2).getDuplicateBody());
        } else if (advertProactiveModerationResult2 instanceof AdvertProactiveModerationResult.WrongCategory) {
            PremoderationRequestFragment.access$showAdvertWrongCategoryScreen(this.a, (AdvertProactiveModerationResult.WrongCategory) advertProactiveModerationResult2);
        }
    }
}

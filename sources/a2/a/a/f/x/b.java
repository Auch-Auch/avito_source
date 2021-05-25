package a2.a.a.f.x;

import androidx.lifecycle.Observer;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.LoadingState;
import java.util.List;
public final class b<T> implements Observer<LoadingState<? super List<? extends Phone>>> {
    public final /* synthetic */ AdvertDetailsFragment a;

    public b(AdvertDetailsFragment advertDetailsFragment) {
        this.a = advertDetailsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super List<? extends Phone>> loadingState) {
        this.a.getAdvertDetailsCreditInfoPresenter().updatePhoneChooser(loadingState);
    }
}

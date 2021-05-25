package a2.a.a.d2.c;

import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.ui.PublicProfilePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<DefaultPublicUserProfile> {
    public final /* synthetic */ PublicProfilePresenterImpl a;

    public c(PublicProfilePresenterImpl publicProfilePresenterImpl) {
        this.a = publicProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DefaultPublicUserProfile defaultPublicUserProfile) {
        this.a.v.updateSellersSubscription(defaultPublicUserProfile.getUser().getSubscribeInfo(), true);
    }
}

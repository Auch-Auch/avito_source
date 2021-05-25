package a2.a.a.y2;

import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.social_management.SocialManagementPresenterImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class d<T> implements Consumer<List<? extends SocialNetwork>> {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public d(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends SocialNetwork> list) {
        SocialManagementPresenterImpl.access$onSocialNetworkAdded(this.a);
    }
}

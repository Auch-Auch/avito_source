package a2.a.a.i3.c.a.i;

import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<CharityInteractor.Dialog> {
    public final /* synthetic */ ProfileHeaderViewModel a;

    public a(ProfileHeaderViewModel profileHeaderViewModel) {
        this.a = profileHeaderViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(CharityInteractor.Dialog dialog) {
        CharityInteractor.Dialog dialog2 = dialog;
        this.a.p.setValue(new ProfileHeaderViewModel.RouterAction.DetailsSheet(dialog2.getBody(), dialog2.getClickEvent()));
    }
}

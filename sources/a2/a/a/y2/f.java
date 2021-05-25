package a2.a.a.y2;

import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.adapter.SocialItem;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class f<T> implements Consumer<Unit> {
    public final /* synthetic */ SocialManagementPresenterImpl.b a;
    public final /* synthetic */ SocialItem b;

    public f(SocialManagementPresenterImpl.b bVar, SocialItem socialItem) {
        this.a = bVar;
        this.b = socialItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        SocialManagementPresenterImpl.access$removeSocialNetwork(this.a.a, ((SocialItem.Connected) this.b).getSocial().getType());
    }
}

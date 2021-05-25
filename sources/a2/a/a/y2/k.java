package a2.a.a.y2;

import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.konveyor.util.AdapterPresentersKt;
import io.reactivex.functions.Action;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class k implements Action {
    public final /* synthetic */ SocialManagementPresenterImpl a;
    public final /* synthetic */ SocialItem.Notification b;

    public k(SocialManagementPresenterImpl socialManagementPresenterImpl, SocialItem.Notification notification) {
        this.a = socialManagementPresenterImpl;
        this.b = notification;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        List mutableList;
        List list = this.a.e;
        if (list != null && (mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list)) != null) {
            mutableList.remove(mutableList.indexOf(this.b));
            this.a.e = mutableList;
            AdapterPresentersKt.updateItems(this.a.l, mutableList);
        }
    }
}

package a2.a.a.y2;

import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.social.SocialNotification;
import com.avito.android.social_management.SocialManagementContent;
import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.adapter.SocialItem;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class i<T, R> implements Function<SocialManagementContent, List<? extends SocialItem>> {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public i(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends SocialItem> apply(SocialManagementContent socialManagementContent) {
        Object obj;
        SocialManagementContent socialManagementContent2 = socialManagementContent;
        Intrinsics.checkNotNullParameter(socialManagementContent2, "result");
        List<SocialNetwork> socialNetworks = socialManagementContent2.getSocialNetworks();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(socialNetworks, 10));
        Iterator<T> it = socialNetworks.iterator();
        while (it.hasNext()) {
            SocialManagementPresenterImpl socialManagementPresenterImpl = this.a;
            int i = socialManagementPresenterImpl.i;
            socialManagementPresenterImpl.i = i + 1;
            arrayList.add(new SocialItem.Connected((long) i, it.next()));
        }
        List list = this.a.h;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t = next;
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it3.next();
                if (Intrinsics.areEqual(((SocialItem.Connected) obj).getSocial().getType(), t.getType())) {
                    break;
                }
            }
            if (obj != null) {
                z = false;
            }
            if (z) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(arrayList2, 10));
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            SocialManagementPresenterImpl socialManagementPresenterImpl2 = this.a;
            int i2 = socialManagementPresenterImpl2.i;
            socialManagementPresenterImpl2.i = i2 + 1;
            arrayList3.add(new SocialItem.Available((long) i2, (SocialNetwork) it4.next()));
        }
        SocialManagementPresenterImpl socialManagementPresenterImpl3 = this.a;
        int i3 = socialManagementPresenterImpl3.i;
        socialManagementPresenterImpl3.i = i3 + 1;
        SocialItem.Header header = new SocialItem.Header((long) i3, this.a.q.connectSocial());
        List<SocialNotification> notifications = socialManagementContent2.getNotifications();
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(notifications, 10));
        for (T t2 : notifications) {
            SocialManagementPresenterImpl socialManagementPresenterImpl4 = this.a;
            int i4 = socialManagementPresenterImpl4.i;
            socialManagementPresenterImpl4.i = i4 + 1;
            arrayList4.add(new SocialItem.Notification((long) i4, t2.getId(), t2.getNotification(), t2.getProvider()));
        }
        if (!arrayList3.isEmpty()) {
            return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection<? extends SocialItem.Header>) CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList), header), (Iterable) arrayList3);
        }
        return CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList);
    }
}

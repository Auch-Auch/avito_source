package a2.a.a.n2;

import com.avito.android.remote.model.SearchDescription;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.SerpWarning;
import com.avito.android.serp.SerpElementResultWithPageParams;
import com.avito.android.serp.SerpInteractorImpl;
import com.avito.android.serp.SerpPage;
import com.avito.android.serp.SerpPageParams;
import com.avito.android.serp.SerpParameters;
import com.avito.android.serp.warning.WarningState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class m<V> implements Callable<SerpPage> {
    public final /* synthetic */ SerpInteractorImpl a;
    public final /* synthetic */ SerpElementResultWithPageParams b;
    public final /* synthetic */ SerpDisplayType c;
    public final /* synthetic */ List d;
    public final /* synthetic */ int e;
    public final /* synthetic */ SerpParameters f;

    public m(SerpInteractorImpl serpInteractorImpl, SerpElementResultWithPageParams serpElementResultWithPageParams, SerpDisplayType serpDisplayType, List list, int i, SerpParameters serpParameters) {
        this.a = serpInteractorImpl;
        this.b = serpElementResultWithPageParams;
        this.c = serpDisplayType;
        this.d = list;
        this.e = i;
        this.f = serpParameters;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public SerpPage call() {
        List list;
        SerpElementResult serpElementResult = this.b.getSerpElementResult();
        SerpPageParams serpPageParams = this.b.getSerpPageParams();
        List<SerpElement> elements = serpElementResult.getElements();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            if (!(t instanceof SerpWarning) || this.a.w.getState(t.getId()) == WarningState.SHOW) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        SerpInteractorImpl.access$sendSearchResultEvent(this.a, arrayList);
        SerpDisplayType serpDisplayType = this.c;
        if (serpDisplayType == null) {
            serpDisplayType = serpElementResult.getSerpDisplayType();
        }
        List access$convertItems = SerpInteractorImpl.access$convertItems(this.a, arrayList, serpDisplayType);
        if (access$convertItems.isEmpty()) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = SerpInteractorImpl.access$sort(this.a, CollectionsKt___CollectionsKt.plus((Collection) this.d, (Iterable) access$convertItems), this.e);
        }
        int access$getAligningShiftIndexForLastItem = SerpInteractorImpl.access$getAligningShiftIndexForLastItem(this.a, list);
        SearchDescription searchDescription = this.b.getSerpElementResult().getSearchDescription();
        Boolean isSubscribed = serpElementResult.isSubscribed();
        return new SerpPage(list, serpPageParams, access$getAligningShiftIndexForLastItem, SerpInteractorImpl.access$getSearchHint(this.a, serpElementResult), isSubscribed != null ? isSubscribed.booleanValue() : false, serpElementResult.getSubscriptionId(), serpElementResult.getCount(), serpPageParams.hasNextPage(), serpDisplayType, serpElementResult.getFirebaseParams(), this.f, null, searchDescription, serpElementResult.getXHash());
    }
}

package a2.a.a.e2.u;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestViewModel;
import com.avito.android.publish.edit_advert_request.analytics.ItemEditCityChangeViaSupportEvent;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ItemBrief;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ EditAdvertRequestViewModel a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(EditAdvertRequestViewModel editAdvertRequestViewModel, Action action) {
        super(0);
        this.a = editAdvertRequestViewModel;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeepLink deepLink = this.b.getDeepLink();
        MutableLiveData mutableLiveData = this.a.f;
        ItemBrief item = EditAdvertRequestViewModel.access$getPublishViewModel$p(this.a).getItem();
        String str = null;
        EditAdvertRequestViewModel.ViewState.OpenDeepLinkAndFinish openDeepLinkAndFinish = new EditAdvertRequestViewModel.ViewState.OpenDeepLinkAndFinish(deepLink, item != null ? item.getId() : null);
        Analytics analytics = this.a.i;
        ItemBrief item2 = EditAdvertRequestViewModel.access$getPublishViewModel$p(this.a).getItem();
        if (item2 != null) {
            str = item2.getId();
        }
        if (str == null) {
            str = "";
        }
        analytics.track(new ItemEditCityChangeViaSupportEvent(str));
        Unit unit = Unit.INSTANCE;
        mutableLiveData.setValue(openDeepLinkAndFinish);
        return unit;
    }
}

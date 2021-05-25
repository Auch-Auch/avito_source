package a2.a.a.n2;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.SerpPresenterImpl;
import com.avito.android.serp.SerpPresenterState;
import com.avito.android.serp.SerpPresenterView;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class s<T> implements Consumer<List<? extends ViewTypeSerpItem>> {
    public final /* synthetic */ SerpPresenterImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SerpDisplayType c;

    public s(SerpPresenterImpl serpPresenterImpl, boolean z, SerpDisplayType serpDisplayType) {
        this.a = serpPresenterImpl;
        this.b = z;
        this.c = serpDisplayType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends ViewTypeSerpItem> list) {
        List<? extends ViewTypeSerpItem> list2 = list;
        if (!this.b) {
            this.a.h.clear();
            List list3 = this.a.h;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            list3.addAll(list2);
            if ((!this.a.h.isEmpty()) && (this.a.r)) {
                SerpPresenterImpl serpPresenterImpl = this.a;
                serpPresenterImpl.b(serpPresenterImpl.h);
            } else if (SerpPresenterImpl.access$loaderRequired(this.a)) {
                SerpPresenterImpl serpPresenterImpl2 = this.a;
                serpPresenterImpl2.a(serpPresenterImpl2.h);
            }
            this.a.l(list2, this.c);
        }
        this.a.f = 0;
        SerpPresenterView serpPresenterView = this.a.a;
        if (serpPresenterView != null) {
            serpPresenterView.enableScroll();
        }
        if (this.a.h.isEmpty()) {
            this.a.m(null);
            if ((!this.a.h.isEmpty()) && (this.a.j())) {
                SerpPresenterImpl.access$restoreView(this.a);
                return;
            }
            return;
        }
        SerpPresenterState serpPresenterState = this.a.s0;
        if (serpPresenterState == null || !serpPresenterState.getLoadDeepLinkForBackNavigation()) {
            SerpPresenterImpl.access$restoreView(this.a);
        }
    }
}

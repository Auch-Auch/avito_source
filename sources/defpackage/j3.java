package defpackage;

import com.avito.android.home.HomePageResult;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.remote.model.HomeTabItem;
import com.avito.android.remote.model.Location;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: j3  reason: default package */
public final class j3<T> implements Consumer<LoadingState<? super HomePageResult>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public j3(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(LoadingState<? super HomePageResult> loadingState) {
        int i = this.a;
        if (i == 0) {
            LoadingState<? super HomePageResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
                ((HomePresenterImpl) this.b).k = uuid;
                ((HomePresenterImpl) this.b).q.sendHomeLoad(((Location) this.c).getId());
                HomePresenterImpl homePresenterImpl = (HomePresenterImpl) this.b;
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                homePresenterImpl.g = homePresenterImpl.g.setSearchHint(((HomePageResult) loaded.getData()).getSearchHint());
                HomePresenterImpl homePresenterImpl2 = (HomePresenterImpl) this.b;
                homePresenterImpl2.g = homePresenterImpl2.g.setXhash(((HomePageResult) loaded.getData()).getXHash());
            }
        } else if (i == 1) {
            LoadingState<? super HomePageResult> loadingState3 = loadingState;
            Intrinsics.checkNotNullExpressionValue(loadingState3, "it");
            HomePresenterImpl.access$onHomePageAppendingElementsStateChanged((HomePresenterImpl) this.b, loadingState3, (HomeTabItem) this.c);
        } else {
            throw null;
        }
    }
}

package defpackage;

import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.analytics.SavedSearchBottomSheetCloseEvent;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: t3  reason: default package */
public final class t3<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public t3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v16, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX DEBUG: Multi-variable search result rejected for r3v26, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                SavedSearchView savedSearchView = ((SavedSearchesPresenterImpl) this.b).a;
                if (savedSearchView != null) {
                    savedSearchView.closeDialog();
                }
                ((SavedSearchesPresenterImpl) this.b).e.accept(Unit.INSTANCE);
            } else if (i == 2) {
                ((SavedSearchesPresenterImpl) this.b).n.track(new SavedSearchBottomSheetCloseEvent());
                SavedSearchesPresenterImpl.access$invalidateState((SavedSearchesPresenterImpl) this.b);
            } else {
                throw null;
            }
        } else if (!((SavedSearchesPresenterImpl) this.b).m.isAuthorized()) {
            ((SavedSearchesPresenterImpl) this.b).d.accept(Unit.INSTANCE);
            SavedSearchView savedSearchView2 = ((SavedSearchesPresenterImpl) this.b).a;
            if (savedSearchView2 != null) {
                savedSearchView2.closeDialog();
            }
        } else {
            SearchPushSubscription searchPushSubscription = ((SavedSearchesPresenterImpl) this.b).h;
            if (searchPushSubscription != null) {
                SavedSearchesPresenterImpl.access$saveSearch((SavedSearchesPresenterImpl) this.b, searchPushSubscription);
                SavedSearchView savedSearchView3 = ((SavedSearchesPresenterImpl) this.b).a;
                if (savedSearchView3 != null) {
                    savedSearchView3.closeDialog();
                }
                ((SavedSearchesPresenterImpl) this.b).g = false;
            }
        }
    }
}

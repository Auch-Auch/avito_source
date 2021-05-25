package defpackage;

import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: s5  reason: default package */
public final class s5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s5(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            SavedSearchView savedSearchView = ((SavedSearchesPresenterImpl) this.b).a;
            if (savedSearchView != null) {
                savedSearchView.showSubscriptionMessage();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            SavedSearchView savedSearchView2 = ((SavedSearchesPresenterImpl) this.b).a;
            if (savedSearchView2 != null) {
                savedSearchView2.showSubscriptionEditedMessage();
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

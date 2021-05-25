package a2.a.a.l2.f;

import com.avito.android.remote.model.Action;
import com.avito.android.section.SectionRouter;
import com.avito.android.section.action.SectionActionPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SectionActionPresenterImpl a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SectionActionPresenterImpl sectionActionPresenterImpl, Action action) {
        super(0);
        this.a = sectionActionPresenterImpl;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        SectionRouter sectionRouter = this.a.a;
        if (sectionRouter != null) {
            sectionRouter.followSectionDeepLink(this.b.getDeepLink());
        }
        return Unit.INSTANCE;
    }
}

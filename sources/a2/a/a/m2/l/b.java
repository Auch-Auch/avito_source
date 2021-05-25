package a2.a.a.m2.l;

import com.avito.android.select.group_select.GroupSelectPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ GroupSelectPresenter a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(GroupSelectPresenter groupSelectPresenter) {
        super(1);
        this.a = groupSelectPresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        GroupSelectPresenter groupSelectPresenter;
        int i;
        if (bool.booleanValue()) {
            groupSelectPresenter = this.a;
            i = groupSelectPresenter.c + 1;
        } else {
            groupSelectPresenter = this.a;
            i = groupSelectPresenter.c - 1;
        }
        groupSelectPresenter.c = i;
        GroupSelectPresenter.access$updateSelectionState(this.a);
        return Unit.INSTANCE;
    }
}

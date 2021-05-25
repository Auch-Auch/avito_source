package a2.a.a.m2.l;

import com.avito.android.select.group_select.GroupSelectPresenter;
import com.avito.android.select.group_select.models.SelectableOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ GroupSelectPresenter a;
    public final /* synthetic */ SelectableOption b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(GroupSelectPresenter groupSelectPresenter, SelectableOption selectableOption) {
        super(1);
        this.a = groupSelectPresenter;
        this.b = selectableOption;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        GroupSelectPresenter groupSelectPresenter;
        int i;
        boolean booleanValue = bool.booleanValue();
        this.b.setSelected(booleanValue);
        if (booleanValue) {
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

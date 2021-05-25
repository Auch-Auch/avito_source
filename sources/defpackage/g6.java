package defpackage;

import com.avito.android.tariff.edit_info.item.alert_dialog.TariffSheetActionItem;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter;
import com.avito.android.tariff.edit_info.item.tabs.TariffEditConvertInfo;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: g6  reason: default package */
public final class g6 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g6(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        boolean z;
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(unit, "it");
            EditInfoViewModelImpl.access$applyChanges((EditInfoViewModelImpl) this.b, (TariffSheetActionItem) this.c);
            return Unit.INSTANCE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
            TariffEditConvertInfo tariffEditConvertInfo = ((EditInfoViewModelImpl) this.b).q;
            if (tariffEditConvertInfo != null) {
                int index = tariffEditConvertInfo.getTariffEditInfo().getSelectedTab().getIndex();
                Iterator<T> it = tariffEditConvertInfo.getTariffEditInfo().getTabs().keySet().iterator();
                if (it.hasNext()) {
                    int index2 = it.next().getIndex();
                    while (it.hasNext()) {
                        int index3 = it.next().getIndex();
                        if (index2 < index3) {
                            index2 = index3;
                        }
                    }
                    if (index != index2) {
                        for (T t : tariffEditConvertInfo.getTariffEditInfo().getTabs().keySet()) {
                            int i2 = index + 1;
                            if (t.getIndex() == i2) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                tariffEditConvertInfo.getTariffEditInfo().setSelectedTab(t);
                                tariffEditConvertInfo.getTabsItem().setSelectedIndex(i2);
                                TabsItemPresenter tabsItemPresenter = ((EditInfoViewModelImpl) this.b).r;
                                if (tabsItemPresenter != null) {
                                    tabsItemPresenter.unbindListener();
                                }
                                ((EditInfoViewModelImpl) this.b).c(tariffEditConvertInfo);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                } else {
                    throw new NoSuchElementException();
                }
            }
            ((EditInfoViewModelImpl) this.b).p.postValue(new Object());
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

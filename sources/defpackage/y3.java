package defpackage;

import a2.a.a.z2.b.d;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetViewImpl;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: y3  reason: default package */
public final class y3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public y3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            d dVar = ((SparePartsBottomSheetViewImpl) this.b).e;
            dVar.K = ((SparePartsBottomSheetViewImpl) this.b).b.getHeight();
            dVar.J = true;
            RecyclerView.Adapter adapter = ((SparePartsBottomSheetViewImpl) this.b).b.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else if (i == 1) {
            ((SparePartsBottomSheetViewImpl) this.b).d = null;
            ((SparePartsBottomSheetViewImpl) this.b).c();
        } else {
            throw null;
        }
    }
}

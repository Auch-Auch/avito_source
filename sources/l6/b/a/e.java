package l6.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;
public class e extends ArrayAdapter<CharSequence> {
    public final /* synthetic */ AlertController.RecycleListView a;
    public final /* synthetic */ AlertController.AlertParams b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(AlertController.AlertParams alertParams, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.b = alertParams;
        this.a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.b.mCheckedItems;
        if (zArr != null && zArr[i]) {
            this.a.setItemChecked(i, true);
        }
        return view2;
    }
}

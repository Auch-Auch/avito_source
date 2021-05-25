package l6.b.a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
public class h implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController.RecycleListView a;
    public final /* synthetic */ AlertController b;
    public final /* synthetic */ AlertController.AlertParams c;

    public h(AlertController.AlertParams alertParams, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.c = alertParams;
        this.a = recycleListView;
        this.b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.c.mCheckedItems;
        if (zArr != null) {
            zArr[i] = this.a.isItemChecked(i);
        }
        this.c.mOnCheckboxClickListener.onClick(this.b.b, i, this.a.isItemChecked(i));
    }
}

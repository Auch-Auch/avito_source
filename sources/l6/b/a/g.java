package l6.b.a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
public class g implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController a;
    public final /* synthetic */ AlertController.AlertParams b;

    public g(AlertController.AlertParams alertParams, AlertController alertController) {
        this.b = alertParams;
        this.a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.mOnClickListener.onClick(this.a.b, i);
        if (!this.b.mIsSingleChoice) {
            this.a.b.dismiss();
        }
    }
}

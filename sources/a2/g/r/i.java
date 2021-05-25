package a2.g.r;

import android.view.View;
import com.facebook.internal.WebDialog;
public class i implements View.OnClickListener {
    public final /* synthetic */ WebDialog a;

    public i(WebDialog webDialog) {
        this.a = webDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.cancel();
    }
}

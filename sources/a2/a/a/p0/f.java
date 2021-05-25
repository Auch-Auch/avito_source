package a2.a.a.p0;

import android.view.View;
import com.avito.android.express_cv.ExpressCvActivity;
public final class f implements View.OnClickListener {
    public final /* synthetic */ ExpressCvActivity a;

    public f(ExpressCvActivity expressCvActivity) {
        this.a = expressCvActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}

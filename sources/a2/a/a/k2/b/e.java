package a2.a.a.k2.b;

import android.view.View;
import com.avito.android.remote.model.search.map.GoToSerpButton;
import com.avito.android.search.map.SearchMapViewImpl;
public final class e implements View.OnClickListener {
    public final /* synthetic */ GoToSerpButton a;
    public final /* synthetic */ SearchMapViewImpl b;

    public e(GoToSerpButton goToSerpButton, SearchMapViewImpl searchMapViewImpl) {
        this.a = goToSerpButton;
        this.b = searchMapViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.w.accept(this.a.getDeeplink());
    }
}

package a2.a.a.k2.b;

import android.view.View;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.search.map.NoVisibleObjectsAction;
import com.avito.android.remote.model.search.map.NoVisibleObjectsCurtain;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.SearchMapViewImpl;
public final class d implements View.OnClickListener {
    public final /* synthetic */ NoVisibleObjectsCurtain a;
    public final /* synthetic */ SearchMapViewImpl b;

    public d(NoVisibleObjectsCurtain noVisibleObjectsCurtain, SearchMapViewImpl searchMapViewImpl, SearchMapState searchMapState) {
        this.a = noVisibleObjectsCurtain;
        this.b = searchMapViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DeepLink uri;
        NoVisibleObjectsAction action = this.a.getAction();
        if (action != null && (uri = action.getUri()) != null) {
            this.b.v.accept(uri);
        }
    }
}

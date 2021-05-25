package a2.a.a.q0;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class b implements SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public b(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final void onRefresh() {
        this.a.v.loadData(true);
    }
}

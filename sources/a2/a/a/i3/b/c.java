package a2.a.a.i3.b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
public final class c implements View.OnClickListener {
    public final /* synthetic */ ProfileItemsSearchFragment a;

    public c(ProfileItemsSearchFragment profileItemsSearchFragment) {
        this.a = profileItemsSearchFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}

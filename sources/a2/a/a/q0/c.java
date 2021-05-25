package a2.a.a.q0;

import android.view.View;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class c implements View.OnClickListener {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public c(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.v.onBackClicked();
    }
}

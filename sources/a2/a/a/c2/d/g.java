package a2.a.a.c2.d;

import android.view.View;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
public final class g implements View.OnClickListener {
    public final /* synthetic */ PhoneActionFragment a;

    public g(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PhoneActionFragment.access$getViewModel$p(this.a).onSubmitButtonClick();
    }
}

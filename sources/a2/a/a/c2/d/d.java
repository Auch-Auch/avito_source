package a2.a.a.c2.d;

import android.view.View;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PhoneActionFragment.access$getViewModel$p(this.a.a).onInputClick();
    }
}

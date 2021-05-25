package a2.a.a.s.a.a;

import android.view.View;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
public final class e implements View.OnClickListener {
    public final /* synthetic */ BeduinFragment a;

    public e(BeduinFragment beduinFragment) {
        this.a = beduinFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.requireActivity().onBackPressed();
    }
}

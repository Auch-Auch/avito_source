package a7.a.a.h;

import android.view.View;
import ru.avito.component.switcher.SwitcherImpl;
public final class a implements View.OnClickListener {
    public final /* synthetic */ SwitcherImpl a;

    public a(SwitcherImpl switcherImpl) {
        this.a = switcherImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SwitcherImpl switcherImpl = this.a;
        switcherImpl.setChecked(!switcherImpl.d.isChecked());
    }
}

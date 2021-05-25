package a7.a.a.d;

import android.text.TextUtils;
import android.view.View;
import ru.avito.component.input.BasicInput;
public final class a implements View.OnFocusChangeListener {
    public final /* synthetic */ BasicInput a;

    public a(BasicInput basicInput) {
        this.a = basicInput;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.j.setKeyListener(this.a.h);
            this.a.j.setEllipsize(null);
            return;
        }
        this.a.j.setKeyListener(null);
        this.a.j.setEllipsize(TextUtils.TruncateAt.END);
    }
}

package a2.j.b.d.s;

import android.widget.AutoCompleteTextView;
public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        h hVar = this.a;
        hVar.i = true;
        hVar.k = System.currentTimeMillis();
        h.g(this.a, false);
    }
}

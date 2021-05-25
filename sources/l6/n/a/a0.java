package l6.n.a;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.Map;
public class a0 implements Runnable {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ Map b;

    public a0(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
        this.a = arrayList;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.a.get(i);
            ViewCompat.setTransitionName(view, (String) this.b.get(ViewCompat.getTransitionName(view)));
        }
    }
}

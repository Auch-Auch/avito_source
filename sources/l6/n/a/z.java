package l6.n.a;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
public class z implements Runnable {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ Map b;

    public z(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
        this.a = arrayList;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.a.get(i);
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                Iterator it = this.b.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (transitionName.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                ViewCompat.setTransitionName(view, str);
            }
        }
    }
}

package androidx.transition;

import a2.b.a.a.a;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class TransitionValues {
    public final ArrayList<Transition> a = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder L = a.L("TransitionValues@");
        L.append(Integer.toHexString(hashCode()));
        L.append(":\n");
        StringBuilder Q = a.Q(L.toString(), "    view = ");
        Q.append(this.view);
        Q.append("\n");
        String c3 = a.c3(Q.toString(), "    values:");
        for (String str : this.values.keySet()) {
            c3 = c3 + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return c3;
    }

    public TransitionValues(@NonNull View view2) {
        this.view = view2;
    }
}

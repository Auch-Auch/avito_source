package a2.j.b.d.j;

import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.LinkedHashSet;
public abstract class q<S> extends Fragment {
    public final LinkedHashSet<OnSelectionChangedListener<S>> onSelectionChangedListeners = new LinkedHashSet<>();

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }
}

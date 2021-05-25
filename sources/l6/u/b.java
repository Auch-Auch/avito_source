package l6.u;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
public class b implements Runnable {
    public final /* synthetic */ Preference a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PreferenceFragment c;

    public b(PreferenceFragment preferenceFragment, Preference preference, String str) {
        this.c = preferenceFragment;
        this.a = preference;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        RecyclerView.Adapter adapter = this.c.c.getAdapter();
        if (adapter instanceof PreferenceGroup.PreferencePositionCallback) {
            Preference preference = this.a;
            if (preference != null) {
                i = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference);
            } else {
                i = ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(this.b);
            }
            if (i != -1) {
                this.c.c.scrollToPosition(i);
            } else {
                adapter.registerAdapterDataObserver(new PreferenceFragment.d(adapter, this.c.c, this.a, this.b));
            }
        } else if (adapter != null) {
            throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
        }
    }
}

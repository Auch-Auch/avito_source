package l6.u;

import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
public class d implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ PreferenceGroup a;
    public final /* synthetic */ PreferenceGroupAdapter b;

    public d(PreferenceGroupAdapter preferenceGroupAdapter, PreferenceGroup preferenceGroup) {
        this.b = preferenceGroupAdapter;
        this.a = preferenceGroup;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.a.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
        this.b.onPreferenceHierarchyChange(preference);
        PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListener = this.a.getOnExpandButtonClickListener();
        if (onExpandButtonClickListener == null) {
            return true;
        }
        onExpandButtonClickListener.onExpandButtonClick();
        return true;
    }
}

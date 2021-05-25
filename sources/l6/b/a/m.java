package l6.b.a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;
public class m implements AdapterView.OnItemSelectedListener {
    public final ActionBar.OnNavigationListener a;

    public m(ActionBar.OnNavigationListener onNavigationListener) {
        this.a = onNavigationListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ActionBar.OnNavigationListener onNavigationListener = this.a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

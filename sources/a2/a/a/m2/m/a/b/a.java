package a2.a.a.m2.m.a.b;

import android.view.View;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemViewImpl;
public final class a implements View.OnClickListener {
    public final /* synthetic */ MetroSelectedStationsItemViewImpl a;
    public final /* synthetic */ String b;

    public a(MetroSelectedStationsItemViewImpl metroSelectedStationsItemViewImpl, String str) {
        this.a = metroSelectedStationsItemViewImpl;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.s.invoke(this.b);
    }
}

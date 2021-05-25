package a2.a.a.l3;

import android.view.View;
import com.avito.android.user_stats.UserStatsViewImpl;
import kotlin.Unit;
public final class b implements View.OnClickListener {
    public final /* synthetic */ UserStatsViewImpl a;

    public b(UserStatsViewImpl userStatsViewImpl) {
        this.a = userStatsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.e.accept(Unit.INSTANCE);
    }
}

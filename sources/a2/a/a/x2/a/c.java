package a2.a.a.x2.a;

import android.view.View;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity;
public final class c implements View.OnClickListener {
    public final /* synthetic */ SoaStatProfileSettingsActivity a;

    public c(SoaStatProfileSettingsActivity soaStatProfileSettingsActivity) {
        this.a = soaStatProfileSettingsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}

package l6.r.d;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b extends a {
    public final AppCompatActivity f;

    public b(@NonNull AppCompatActivity appCompatActivity, @NonNull AppBarConfiguration appBarConfiguration) {
        super(appCompatActivity.getDrawerToggleDelegate().getActionBarThemedContext(), appBarConfiguration);
        this.f = appCompatActivity;
    }

    @Override // l6.r.d.a
    public void a(Drawable drawable, @StringRes int i) {
        ActionBar supportActionBar = this.f.getSupportActionBar();
        if (drawable == null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            return;
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        this.f.getDrawerToggleDelegate().setActionBarUpIndicator(drawable, i);
    }

    @Override // l6.r.d.a
    public void b(CharSequence charSequence) {
        this.f.getSupportActionBar().setTitle(charSequence);
    }
}

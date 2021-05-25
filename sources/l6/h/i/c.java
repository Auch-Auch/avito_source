package l6.h.i;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
public class c extends ViewCompat.d<Boolean> {
    public c(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // androidx.core.view.ViewCompat.d
    @RequiresApi(28)
    public Boolean b(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // androidx.core.view.ViewCompat.d
    @RequiresApi(28)
    public void c(View view, Boolean bool) {
        view.setAccessibilityHeading(bool.booleanValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // androidx.core.view.ViewCompat.d
    public boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}

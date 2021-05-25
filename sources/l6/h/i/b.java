package l6.h.i;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
public class b extends ViewCompat.d<CharSequence> {
    public b(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // androidx.core.view.ViewCompat.d
    @RequiresApi(28)
    public CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // androidx.core.view.ViewCompat.d
    @RequiresApi(28)
    public void c(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // androidx.core.view.ViewCompat.d
    public boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}

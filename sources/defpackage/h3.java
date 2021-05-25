package defpackage;

import android.view.View;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
/* compiled from: java-style lambda group */
/* renamed from: h3  reason: default package */
public final class h3 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public h3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((ResidentialComplexActivity) this.b).setResult(0);
            ((ResidentialComplexActivity) this.b).finish();
        } else if (i == 1) {
            ResidentialComplexActivity.access$getSearchEditText$p((ResidentialComplexActivity) this.b).getText().clear();
        } else {
            throw null;
        }
    }
}

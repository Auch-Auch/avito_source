package a2.l.a;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ag;
import com.my.target.bo;
import com.my.target.fk;
import com.my.target.fn;
import com.my.target.ib;
import com.my.target.im;
import java.lang.ref.WeakReference;
import java.util.List;
public final class a implements fk.a, fn.a {
    @NonNull
    public final List<bo.a> a;
    @Nullable
    public ag.b b;
    @Nullable
    public WeakReference<fk> c;

    public a(@NonNull List<bo.a> list) {
        this.a = list;
    }

    @Override // com.my.target.fn.a
    public void a(@NonNull bo.a aVar, @NonNull Context context) {
        fk fkVar;
        ag.b bVar;
        String str = aVar.dn;
        if (!(str == null || str.length() == 0)) {
            im.o(str, context);
        }
        String str2 = aVar.B;
        if (!(str2 == null || str2.length() == 0)) {
            ib.m(str2, context);
        }
        if (aVar.f11do && (bVar = this.b) != null) {
            bVar.i(context);
        }
        WeakReference<fk> weakReference = this.c;
        if (weakReference != null && (fkVar = weakReference.get()) != null) {
            fkVar.dismiss();
        }
    }

    @Override // com.my.target.fk.a
    public void a(@NonNull fk fkVar, @NonNull FrameLayout frameLayout) {
        fn fnVar = new fn(frameLayout.getContext());
        frameLayout.addView(fnVar, -1, -1);
        fnVar.a(this.a, this);
        fnVar.dR();
    }

    @Override // com.my.target.fk.a
    public void a(boolean z) {
    }

    @Override // com.my.target.fk.a
    public void o() {
        WeakReference<fk> weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
            this.c = null;
        }
    }

    @Override // com.my.target.fn.a
    public void p() {
        fk fkVar;
        WeakReference<fk> weakReference = this.c;
        if (weakReference != null && (fkVar = weakReference.get()) != null) {
            fkVar.dismiss();
        }
    }
}

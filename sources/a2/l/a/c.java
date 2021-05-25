package a2.l.a;

import android.view.View;
import com.my.target.al;
import com.my.target.an;
import com.my.target.ci;
import java.util.Objects;
public class c implements View.OnClickListener {
    public final /* synthetic */ ci a;
    public final /* synthetic */ an b;

    public c(an anVar, ci ciVar) {
        this.b = anVar;
        this.a = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar = this.b;
        ci ciVar = this.a;
        Objects.requireNonNull(anVar);
        al a3 = al.a(ciVar);
        a3.a(anVar.c);
        a3.k(view.getContext());
    }
}

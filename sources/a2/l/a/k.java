package a2.l.a;

import androidx.annotation.Nullable;
import com.my.target.ab;
import com.my.target.ae;
import com.my.target.bj;
import com.my.target.cn;
import com.my.target.cu;
public class k implements ab.a {
    public final /* synthetic */ bj a;

    public k(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.my.target.b.AbstractC0305b
    public void onResult(@Nullable cn cnVar, @Nullable String str) {
        cu cuVar = (cu) cnVar;
        if (cuVar != null) {
            this.a.a(cuVar);
            return;
        }
        ae.a("No new ad");
        this.a.c();
    }
}

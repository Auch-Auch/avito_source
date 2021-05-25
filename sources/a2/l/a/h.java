package a2.l.a;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.my.target.au;
import com.my.target.cn;
import com.my.target.common.models.AudioData;
import com.my.target.cp;
import com.my.target.cr;
import com.my.target.i;
import java.util.Objects;
public class h implements i.b {
    public final /* synthetic */ cr a;
    public final /* synthetic */ au b;

    public h(au auVar, cr crVar) {
        this.b = auVar;
        this.a = crVar;
    }

    @Override // com.my.target.b.AbstractC0305b
    public void onResult(@Nullable cn cnVar, @Nullable String str) {
        cp cpVar = (cp) cnVar;
        au auVar = this.b;
        cr<AudioData> crVar = this.a;
        Objects.requireNonNull(auVar);
        if (cpVar == null) {
            if (str != null) {
                a.U0("loading doAfter service failed: ", str);
            }
            if (crVar == auVar.f) {
                auVar.h(crVar, auVar.l);
                return;
            }
            return;
        }
        cr<AudioData> w = cpVar.w(crVar.getName());
        if (w != null) {
            crVar.b(w);
        }
        if (crVar == auVar.f) {
            auVar.j = crVar.ca();
            auVar.g();
        }
    }
}

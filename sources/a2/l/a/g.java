package a2.l.a;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.my.target.at;
import com.my.target.cn;
import com.my.target.co;
import com.my.target.common.models.VideoData;
import com.my.target.cr;
import com.my.target.f;
import java.util.Objects;
public class g implements f.b {
    public final /* synthetic */ cr a;
    public final /* synthetic */ at b;

    public g(at atVar, cr crVar) {
        this.b = atVar;
        this.a = crVar;
    }

    @Override // com.my.target.b.AbstractC0305b
    public void onResult(@Nullable cn cnVar, @Nullable String str) {
        co coVar = (co) cnVar;
        at atVar = this.b;
        cr<VideoData> crVar = this.a;
        Objects.requireNonNull(atVar);
        if (coVar == null) {
            if (str != null) {
                a.U0("loading doAfter service failed: ", str);
            }
            if (crVar == atVar.f) {
                atVar.g(crVar, atVar.k);
                return;
            }
            return;
        }
        cr<VideoData> v = coVar.v(crVar.getName());
        if (v != null) {
            crVar.b(v);
        }
        if (crVar == atVar.f) {
            atVar.i = crVar.ca();
            atVar.f();
        }
    }
}

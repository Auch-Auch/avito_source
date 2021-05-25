package a2.l.a;

import com.my.target.ei;
import com.my.target.fu;
public class m implements fu.a {
    public final /* synthetic */ ei a;

    public m(ei eiVar) {
        this.a = eiVar;
    }

    @Override // com.my.target.fu.a
    public void onClose() {
        this.a.e();
    }
}

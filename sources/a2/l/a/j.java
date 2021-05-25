package a2.l.a;

import androidx.annotation.NonNull;
import com.my.target.as;
import com.my.target.bi;
import com.my.target.eu;
public class j implements eu.a {
    public final /* synthetic */ bi a;

    public j(bi biVar) {
        this.a = biVar;
    }

    @Override // com.my.target.eu.a
    public void onLoad() {
        as.a aVar = this.a.h;
        if (aVar != null) {
            aVar.onLoad();
        }
    }

    @Override // com.my.target.eu.a
    public void onNoAd(@NonNull String str) {
        as.a aVar = this.a.h;
        if (aVar != null) {
            aVar.onNoAd(str);
        }
    }
}

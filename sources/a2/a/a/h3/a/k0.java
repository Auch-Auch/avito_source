package a2.a.a.h3.a;

import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import java.util.concurrent.Callable;
import kotlin.collections.ArraysKt___ArraysKt;
public final class k0<V> implements Callable<Boolean> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ AnonymousNumber b;
    public final /* synthetic */ String c;

    public k0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, AnonymousNumber anonymousNumber, String str) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = anonymousNumber;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        if (!(this.a.p)) {
            return Boolean.FALSE;
        }
        AnonymousNumber anonymousNumber = this.b;
        boolean z = false;
        if (anonymousNumber != null && anonymousNumber.isValidContent()) {
            this.a.V.incrementAdvertsForCallsCreated();
            if (ArraysKt___ArraysKt.contains(new Integer[]{1, 3}, Integer.valueOf(this.a.V.getAdvertsForCallsCreated())) || this.a.V.getAdvertsForCallsCreated() % 5 == 0) {
                MyAdvertDetailsView myAdvertDetailsView = this.a.b;
                if (myAdvertDetailsView != null) {
                    myAdvertDetailsView.showPermissionForCallDialogIfNeeded(this.c, this.a.T.getWasMicPermissionForeverDenied());
                }
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}

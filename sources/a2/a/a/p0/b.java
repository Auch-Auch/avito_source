package a2.a.a.p0;

import androidx.lifecycle.Observer;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.MessageEvent;
import kotlin.jvm.functions.Function0;
public final class b<T> implements Observer<MessageEvent> {
    public final /* synthetic */ ExpressCvActivity a;

    public b(ExpressCvActivity expressCvActivity) {
        this.a = expressCvActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MessageEvent messageEvent) {
        String str;
        MessageEvent messageEvent2 = messageEvent;
        if (messageEvent2 != null && (str = (String) messageEvent2.getContentIfNotHandled()) != null) {
            Views.showSnackBar$default(ExpressCvActivity.access$getViewPager$p(this.a), str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }
}

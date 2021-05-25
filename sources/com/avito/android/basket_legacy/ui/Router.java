package com.avito.android.basket_legacy.ui;

import com.avito.android.vas_performance.VasCompletionListener;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/basket_legacy/ui/Router;", "Lcom/avito/android/vas_performance/VasCompletionListener;", "", "enableAppRater", "", "finishFlow", "(Z)V", "startVasSelection", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface Router extends VasCompletionListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void finishFlow$default(Router router, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                router.finishFlow(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishFlow");
        }
    }

    void finishFlow(boolean z);

    void startVasSelection();
}

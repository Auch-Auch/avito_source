package com.avito.android.user_adverts.root_screen.adverts_host;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsListHost;", "", "", "invalidate", "", "refresh", "(Z)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertsListHost {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void refresh$default(UserAdvertsListHost userAdvertsListHost, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                userAdvertsListHost.refresh(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
        }
    }

    void refresh(boolean z);
}

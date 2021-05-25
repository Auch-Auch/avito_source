package com.avito.android.user_adverts.tab_screens.advert_list.user_advert;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.user_adverts.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/UserAdvertItemResourceProviderImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/UserAdvertItemResourceProvider;", "", "type", "", "getServiceIcon", "(Ljava/lang/String;)I", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertItemResourceProviderImpl implements UserAdvertItemResourceProvider {
    @Override // com.avito.android.user_adverts.tab_screens.advert_list.user_advert.UserAdvertItemResourceProvider
    @DrawableRes
    public int getServiceIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        switch (str.hashCode()) {
            case -1494538294:
                if (str.equals(ServiceTypeKt.SERVICE_SINGLE_CV)) {
                    return R.drawable.lf_single;
                }
                break;
            case -681210700:
                if (str.equals(ServiceTypeKt.SERVICE_HIGHLIGHT)) {
                    return R.drawable.highlight;
                }
                break;
            case -318452137:
                if (str.equals(ServiceTypeKt.SERVICE_PREMIUM)) {
                    return R.drawable.premium;
                }
                break;
            case 3739:
                if (str.equals("up")) {
                    return R.drawable.bump_up;
                }
                break;
            case 116765:
                if (str.equals(ServiceTypeKt.SERVICE_VIP)) {
                    return R.drawable.vip;
                }
                break;
            case 913955599:
                if (str.equals(ServiceTypeKt.SERVICE_SINGLE_FEE)) {
                    return R.drawable.lf_single;
                }
                break;
        }
        return 0;
    }
}

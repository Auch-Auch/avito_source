package com.avito.android.autodeal_details;

import android.net.Uri;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\t\u001a\u00020\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "url", "", "callback", "setOpenThirdPartyUriCallBack", "(Lkotlin/jvm/functions/Function1;)V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutoDealDetailsInterceptor extends PowerWebViewInterceptor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.autodeal_details.AutoDealDetailsInterceptor */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setOpenThirdPartyUriCallBack$default(AutoDealDetailsInterceptor autoDealDetailsInterceptor, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = null;
                }
                autoDealDetailsInterceptor.setOpenThirdPartyUriCallBack(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOpenThirdPartyUriCallBack");
        }
    }

    void setOpenThirdPartyUriCallBack(@Nullable Function1<? super Uri, Unit> function1);
}

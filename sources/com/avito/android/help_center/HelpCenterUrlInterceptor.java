package com.avito.android.help_center;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "callBack", "", "setCallBack", "(Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;)V", "CallBack", "help-center_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterUrlInterceptor extends PowerWebViewInterceptor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "doesNotSupportUrl", "(Landroid/net/Uri;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
    public interface CallBack {
        void doesNotSupportUrl(@NotNull Uri uri);
    }

    void setCallBack(@NotNull CallBack callBack);
}

package com.avito.android.analytics_adjust;

import com.adjust.sdk.AdjustEvent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Initializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics_adjust/Adjust;", "Lcom/avito/android/util/Initializable;", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "", "setPushToken", "(Ljava/lang/String;)V", ChannelContext.Item.USER_ID, "setUserIdentifier", "Lcom/adjust/sdk/AdjustEvent;", "event", "trackEvent", "(Lcom/adjust/sdk/AdjustEvent;)V", "onPause", "()V", "onResume", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public interface Adjust extends Initializable {
    void onPause();

    void onResume();

    void setPushToken(@NotNull String str);

    void setUserIdentifier(@NotNull String str);

    void trackEvent(@NotNull AdjustEvent adjustEvent);
}

package com.avito.android.push;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/push/CallPushHandler;", "", "Lcom/avito/android/push/PushToken;", "pushToken", "", "updatePushToken", "(Lcom/avito/android/push/PushToken;)V", "Lcom/avito/android/push/Push;", "push", "", "handlePush", "(Lcom/avito/android/push/Push;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "handlePushDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "push_release"}, k = 1, mv = {1, 4, 2})
public interface CallPushHandler {
    boolean handlePush(@NotNull Push push);

    boolean handlePushDeepLink(@NotNull DeepLink deepLink);

    void updatePushToken(@NotNull PushToken pushToken);
}

package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/UserAdvertIntentFactory;", "", "", "draftId", "Landroid/content/Intent;", "myDraftAdvertDetailsIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "itemId", "statusMessage", "Lcom/avito/android/deep_linking/links/DeepLink;", "invokeActionLink", "", "isNewAdvert", "myAdvertDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Z)Landroid/content/Intent;", "myAdvertDetailsActivateIntent", "myAdvertDetailsRestoreIntent", "message", "myAdvertDetailsWithMessageIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent myAdvertDetailsIntent$default(UserAdvertIntentFactory userAdvertIntentFactory, String str, String str2, DeepLink deepLink, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    deepLink = null;
                }
                if ((i & 8) != 0) {
                    z = false;
                }
                return userAdvertIntentFactory.myAdvertDetailsIntent(str, str2, deepLink, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: myAdvertDetailsIntent");
        }
    }

    @NotNull
    Intent myAdvertDetailsActivateIntent(@NotNull String str);

    @NotNull
    Intent myAdvertDetailsIntent(@NotNull String str, @Nullable String str2, @Nullable DeepLink deepLink, boolean z);

    @NotNull
    Intent myAdvertDetailsRestoreIntent(@NotNull String str);

    @NotNull
    Intent myAdvertDetailsWithMessageIntent(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent myDraftAdvertDetailsIntent(@NotNull String str);
}

package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Intent;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "", "putPhoneRequestAnalyticsData", "(Landroid/content/Intent;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;)V", "getPhoneRequestAnalyticsData", "(Landroid/content/Intent;)Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "putPhoneRequestDeepLink", "(Landroid/content/Intent;Lcom/avito/android/deep_linking/links/PhoneRequestLink;)V", "getPhoneRequestDeepLink", "(Landroid/content/Intent;)Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneRequestDeepLinkIntentFactoryKt {
    @Nullable
    public static final PhoneRequestDeepLinkAnalyticsData getPhoneRequestAnalyticsData(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getPhoneRequestAnalyticsData");
        return (PhoneRequestDeepLinkAnalyticsData) intent.getParcelableExtra("PhoneRequestAnalyticsData");
    }

    @Nullable
    public static final PhoneRequestLink getPhoneRequestDeepLink(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getPhoneRequestDeepLink");
        return (PhoneRequestLink) intent.getParcelableExtra("PhoneRequestLink");
    }

    public static final void putPhoneRequestAnalyticsData(@NotNull Intent intent, @Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData) {
        Intrinsics.checkNotNullParameter(intent, "$this$putPhoneRequestAnalyticsData");
        intent.putExtra("PhoneRequestAnalyticsData", phoneRequestDeepLinkAnalyticsData);
    }

    public static final void putPhoneRequestDeepLink(@NotNull Intent intent, @NotNull PhoneRequestLink phoneRequestLink) {
        Intrinsics.checkNotNullParameter(intent, "$this$putPhoneRequestDeepLink");
        Intrinsics.checkNotNullParameter(phoneRequestLink, "link");
        intent.putExtra("PhoneRequestLink", phoneRequestLink);
    }
}

package com.avito.android.advert_core.phone_request;

import android.app.Application;
import android.content.Intent;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.PhoneRequestDeepLinkIntentFactory;
import com.avito.android.PhoneRequestDeepLinkIntentFactoryKt;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkIntentFactoryImpl;", "Lcom/avito/android/PhoneRequestDeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "Landroid/content/Intent;", "createPhoneRequestIntent", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneRequestDeepLinkIntentFactoryImpl implements PhoneRequestDeepLinkIntentFactory {
    public final Application a;

    @Inject
    public PhoneRequestDeepLinkIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "app");
        this.a = application;
    }

    @Override // com.avito.android.PhoneRequestDeepLinkIntentFactory
    @NotNull
    public Intent createPhoneRequestIntent(@NotNull PhoneRequestLink phoneRequestLink, @Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData) {
        Intrinsics.checkNotNullParameter(phoneRequestLink, "link");
        Intent intent = new Intent(this.a, PhoneRequestDeepLinkActivity.class);
        PhoneRequestDeepLinkIntentFactoryKt.putPhoneRequestDeepLink(intent, phoneRequestLink);
        PhoneRequestDeepLinkIntentFactoryKt.putPhoneRequestAnalyticsData(intent, phoneRequestDeepLinkAnalyticsData);
        return intent;
    }
}

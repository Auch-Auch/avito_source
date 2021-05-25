package com.avito.android.advert_core.phone_request.di;

import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Component(dependencies = {PhoneRequestDeepLinkDependencies.class}, modules = {PhoneRequestDeepLinkModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkActivityComponent;", "", "Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkActivity;", "activity", "", "inject", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkActivity;)V", "Factory", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneRequestDeepLinkActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JA\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkActivityComponent$Factory;", "", "Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkDependencies;", "deepLinkDependencies", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "asyncPhoneAuthRouter", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "analyticsData", "Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkActivityComponent;", "create", "(Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkDependencies;Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;)Lcom/avito/android/advert_core/phone_request/di/PhoneRequestDeepLinkActivityComponent;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        PhoneRequestDeepLinkActivityComponent create(@NotNull PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies, @BindsInstance @NotNull AsyncPhoneAuthRouter asyncPhoneAuthRouter, @BindsInstance @NotNull Screen screen, @BindsInstance @NotNull PhoneRequestLink phoneRequestLink, @BindsInstance @Nullable PhoneRequestDeepLinkAnalyticsData phoneRequestDeepLinkAnalyticsData);
    }

    void inject(@NotNull PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity);
}

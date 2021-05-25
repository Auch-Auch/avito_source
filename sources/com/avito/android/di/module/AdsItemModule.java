package com.avito.android.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenter;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/di/module/AdsItemModule;", "", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenterImpl;", "presenter", "Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenter;", "bindYandexContentItemPresenter", "(Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/yandex/content/YandexContentItemPresenter;", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", "bindYandexAppInstallItemPresenter", "(Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/yandex/app_install/YandexAppInstallItemPresenter;", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenter;", "bindMyTargetContentPresenter", "(Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetContentPresenter;", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallPresenter;", "bindMyTargetAppInstallPresenter", "(Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/mytarget/MyTargetAppInstallPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenter;", "bindDfUnifiedPresenter", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenter;", "bindDfpContentPresenter", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentPresenter;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenterImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenter;", "bindDfpAppInstallPresenter", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenterImpl;)Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallPresenter;", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenterImpl;", "Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenter;", "bindStubAdvertItemPresenter", "(Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenterImpl;)Lcom/avito/android/serp/adapter/adstub/EmptyAdStubItemPresenter;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DfpDebugModule.class, AdfoxModule.class})
public interface AdsItemModule {
    @PerFragment
    @Binds
    @NotNull
    DfpUnifiedPresenter bindDfUnifiedPresenter(@NotNull DfpUnifiedPresenterImpl dfpUnifiedPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    DfpAppInstallPresenter bindDfpAppInstallPresenter(@NotNull DfpAppInstallPresenterImpl dfpAppInstallPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    DfpContentPresenter bindDfpContentPresenter(@NotNull DfpContentPresenterImpl dfpContentPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    MyTargetAppInstallPresenter bindMyTargetAppInstallPresenter(@NotNull MyTargetAppInstallPresenterImpl myTargetAppInstallPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    MyTargetContentPresenter bindMyTargetContentPresenter(@NotNull MyTargetContentPresenterImpl myTargetContentPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    EmptyAdStubItemPresenter bindStubAdvertItemPresenter(@NotNull EmptyAdStubItemPresenterImpl emptyAdStubItemPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    YandexAppInstallItemPresenter bindYandexAppInstallItemPresenter(@NotNull YandexAppInstallItemPresenterImpl yandexAppInstallItemPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    YandexContentItemPresenter bindYandexContentItemPresenter(@NotNull YandexContentItemPresenterImpl yandexContentItemPresenterImpl);
}

package com.avito.android.user_advert.di;

import com.avito.android.design.ProgressLineColorProvider;
import com.avito.android.design.ProgressLineColorProviderImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.user_advert.advert.AdvertAddressFormatter;
import com.avito.android.user_advert.advert.AdvertAddressFormatterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsConverter;
import com.avito.android.user_advert.advert.MyAdvertDetailsConverterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractor;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractorImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenter;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider;
import com.avito.android.user_advert.advert.MyAdvertDetailsResourceProviderImpl;
import com.avito.android.user_advert.advert.MyAdvertStorage;
import com.avito.android.user_advert.advert.MyAdvertStorageImpl;
import com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractor;
import com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractorImpl;
import com.avito.android.user_advert.advert.verification.VerificationItemConverter;
import com.avito.android.user_advert.advert.verification.VerificationItemConverterImpl;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenterImpl;
import com.avito.android.user_advert.reject.RejectReasonConverter;
import com.avito.android.user_advert.reject.RejectReasonConverterImpl;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010#\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020,2\u0006\u0010\b\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u0002002\u0006\u0010\b\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H'¢\u0006\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/avito/android/user_advert/di/DetailsPresentationModule;", "", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenterImpl;", "presenter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "bindMyAdvertDetailsPresenter", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenterImpl;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverterImpl;", "converter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;", "bindMyAdvertDetailsConverter", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverterImpl;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractorImpl;", "interactor", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "bindMyAdvertDetailsInteractor", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractorImpl;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractorImpl;", "Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "bindMyDraftAdvertDetailsInteractor", "(Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractorImpl;)Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenterImpl;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "bindMyAdvertContactsPresenter", "(Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenterImpl;)Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "Lcom/avito/android/user_advert/advert/AdvertAddressFormatterImpl;", "Lcom/avito/android/user_advert/advert/AdvertAddressFormatter;", "bindAdvertAddressFormatter", "(Lcom/avito/android/user_advert/advert/AdvertAddressFormatterImpl;)Lcom/avito/android/user_advert/advert/AdvertAddressFormatter;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "bindMyAdvertDetailsResourceProvider", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProviderImpl;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "Lcom/avito/android/design/ProgressLineColorProviderImpl;", "Lcom/avito/android/design/ProgressLineColorProvider;", "bindProgressLineColorProvider", "(Lcom/avito/android/design/ProgressLineColorProviderImpl;)Lcom/avito/android/design/ProgressLineColorProvider;", "Lcom/avito/android/user_advert/reject/RejectReasonConverterImpl;", "Lcom/avito/android/user_advert/reject/RejectReasonConverter;", "bindRejectReasonConverter", "(Lcom/avito/android/user_advert/reject/RejectReasonConverterImpl;)Lcom/avito/android/user_advert/reject/RejectReasonConverter;", "Lcom/avito/android/user_advert/advert/verification/VerificationItemConverterImpl;", "Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;", "bindVerificationItemConverter", "(Lcom/avito/android/user_advert/advert/verification/VerificationItemConverterImpl;)Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;", "Lcom/avito/android/user_advert/advert/MyAdvertStorageImpl;", "storage", "Lcom/avito/android/user_advert/advert/MyAdvertStorage;", "bindMyAdvertStorage", "(Lcom/avito/android/user_advert/advert/MyAdvertStorageImpl;)Lcom/avito/android/user_advert/advert/MyAdvertStorage;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface DetailsPresentationModule {
    @PerActivity
    @Binds
    @NotNull
    AdvertAddressFormatter bindAdvertAddressFormatter(@NotNull AdvertAddressFormatterImpl advertAddressFormatterImpl);

    @PerActivity
    @Binds
    @NotNull
    ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertContactsPresenter bindMyAdvertContactsPresenter(@NotNull MyAdvertContactsPresenterImpl myAdvertContactsPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertDetailsConverter bindMyAdvertDetailsConverter(@NotNull MyAdvertDetailsConverterImpl myAdvertDetailsConverterImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertDetailsInteractor bindMyAdvertDetailsInteractor(@NotNull MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertDetailsPresenter bindMyAdvertDetailsPresenter(@NotNull MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertDetailsResourceProvider bindMyAdvertDetailsResourceProvider(@NotNull MyAdvertDetailsResourceProviderImpl myAdvertDetailsResourceProviderImpl);

    @PerActivity
    @Binds
    @NotNull
    MyAdvertStorage bindMyAdvertStorage(@NotNull MyAdvertStorageImpl myAdvertStorageImpl);

    @PerActivity
    @Binds
    @NotNull
    MyDraftAdvertDetailsInteractor bindMyDraftAdvertDetailsInteractor(@NotNull MyDraftAdvertDetailsInteractorImpl myDraftAdvertDetailsInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    ProgressLineColorProvider bindProgressLineColorProvider(@NotNull ProgressLineColorProviderImpl progressLineColorProviderImpl);

    @PerActivity
    @Binds
    @NotNull
    RejectReasonConverter bindRejectReasonConverter(@NotNull RejectReasonConverterImpl rejectReasonConverterImpl);

    @PerActivity
    @Binds
    @NotNull
    VerificationItemConverter bindVerificationItemConverter(@NotNull VerificationItemConverterImpl verificationItemConverterImpl);
}

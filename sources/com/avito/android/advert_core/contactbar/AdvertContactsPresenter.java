package com.avito.android.advert_core.contactbar;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.MainThread;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_core.sellerprofile.SellerProfileClickSource;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.advert_details.ContactBarData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001f\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'¢\u0006\u0004\b!\u0010 J1\u0010\"\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H&¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010,H&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020$H&¢\u0006\u0004\b0\u0010'J\u001f\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u0010/\u001a\u00020$H&¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0006H&¢\u0006\u0004\b5\u0010\u000eJ\u000f\u00106\u001a\u00020\u0006H&¢\u0006\u0004\b6\u0010\u000eJ\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H&¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H&¢\u0006\u0004\b;\u0010\u000eJ\u000f\u0010<\u001a\u00020\u0006H&¢\u0006\u0004\b<\u0010\u000eJ\u0019\u0010>\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u000101H&¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0006H&¢\u0006\u0004\b@\u0010\u000eJ\u000f\u0010A\u001a\u00020\u0006H&¢\u0006\u0004\bA\u0010\u000eJ\u000f\u0010B\u001a\u00020\u0006H&¢\u0006\u0004\bB\u0010\u000eJ\u000f\u0010C\u001a\u00020\u0006H&¢\u0006\u0004\bC\u0010\u000eJ\u000f\u0010D\u001a\u00020\u0006H&¢\u0006\u0004\bD\u0010\u000eJ\u0019\u0010F\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\bF\u0010'J\u0019\u0010I\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010GH&¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020KH&¢\u0006\u0004\bM\u0010NR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "Lcom/avito/android/advert_core/sellerprofile/SellerProfileClickSource;", "Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment$Callback;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "view", "", "attachStickyView", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "attachEmbeddedView", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "attachCoreView", "(Lcom/avito/android/advert_core/advert/AdvertCoreView;)V", "onResume", "()V", "detachView", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "routerAdvert", "setRouter", "(Lcom/avito/android/advert_core/advert/AdvertCoreRouter;)V", "Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "saveState", "()Landroid/os/Bundle;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "bindStickyData", "(Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "bindEmbeddedData", "bindSafeShowData", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "", "context", "setContext", "(Ljava/lang/String;)V", "", "online", "updateOnlineStatus", "(Z)V", "Lcom/avito/android/remote/model/AdvertActions;", "contactBarActions", "(Lcom/avito/android/remote/model/AdvertActions;)Ljava/util/List;", "source", "onPhoneCallShown", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "onPhoneCallConfirmed", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;)V", "onPhoneCallDismissed", "onPhoneCallCanceled", "", "duration", "onPhoneCallFinished", "(J)V", "notifySellerAboutCallIfNeeded", "showPhoneCallConfirmationIfNeeded", "phoneLinkFromExpressCvActivity", "showPhoneCallConfirmationAfterOnActivityResult", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "showAntiFraudCheckList", "onAcceptAntiFraudRule", "onShowMoreAntiFraudRule", "onCloseAntiFraudRule", "showFeedbackIfNeeded", "locationId", "userSelectedLocationId", "Landroid/os/Parcelable;", "authResultData", "onAuthSuccess", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "onMarketplaceWriteClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertContactsPresenter extends SellerProfileClickSource, AdvertCallMethodsDialogFragment.Callback, FeedbackDialog.Listener {
    void attachCoreView(@Nullable AdvertCoreView advertCoreView);

    void attachEmbeddedView(@Nullable AdvertContactsView advertContactsView);

    void attachStickyView(@Nullable AdvertContactsView advertContactsView);

    @MainThread
    void bindEmbeddedData(@NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData);

    void bindSafeShowData(@Nullable AdvertContactsView advertContactsView, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData);

    @MainThread
    void bindStickyData(@NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData);

    @NotNull
    List<ContactBar.Action> contactBarActions(@Nullable AdvertActions advertActions);

    void detachView();

    @NotNull
    List<ContactBar.Action> getActions();

    void notifySellerAboutCallIfNeeded();

    void onAcceptAntiFraudRule();

    void onAuthSuccess(@Nullable Parcelable parcelable);

    void onCloseAntiFraudRule();

    void onMarketplaceWriteClick(@NotNull DeepLink deepLink);

    void onPhoneCallCanceled();

    void onPhoneCallConfirmed(@NotNull PhoneLink phoneLink, @NotNull String str);

    void onPhoneCallDismissed();

    void onPhoneCallFinished(long j);

    void onPhoneCallShown(@NotNull String str);

    void onResume();

    void onShowMoreAntiFraudRule();

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();

    void setActions(@NotNull List<ContactBar.Action> list);

    void setContext(@Nullable String str);

    void setRouter(@NotNull AdvertCoreRouter advertCoreRouter);

    void showAntiFraudCheckList();

    void showFeedbackIfNeeded();

    void showPhoneCallConfirmationAfterOnActivityResult(@Nullable PhoneLink phoneLink);

    void showPhoneCallConfirmationIfNeeded();

    void updateOnlineStatus(boolean z);

    void userSelectedLocationId(@Nullable String str);
}

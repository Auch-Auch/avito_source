package com.avito.android.publish.details;

import android.os.Bundle;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00019J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J?\u00102\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000/H&¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u000fH&¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000fH&¢\u0006\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsPresenter;", "Lcom/avito/android/publish/view/ItemDetailsView$Presenter;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "router", "", "attachPublishRouter", "(Lcom/avito/android/publish/details/PublishDetailsRouter;)V", "Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;", "attachRouter", "(Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;)V", "Lcom/avito/android/publish/view/ItemDetailsView;", "view", "", "isFirstTime", "attachView", "(Lcom/avito/android/publish/view/ItemDetailsView;Z)V", "detachView", "()V", "detachRouter", "detachPublishRouter", "onDestroy", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "", "resultCode", "onAuthResult", "(I)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "value", "onResidentialComplexResult", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;)V", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "tagsViewModel", "setTagsViewModel", "(Lcom/avito/android/publish/details/tags/PublishTagsViewModel;)V", "", "updatedParamId", "isPrevalidationRequired", "scrollToErrors", "", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "flowContext", "showParameters", "(Ljava/lang/String;ZZ[Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "keyboardVisible", "handleKeyboard", "(Z)V", "enableComputerVisionIfNeeded", "()Z", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDetailsPresenter extends ItemDetailsView.Presenter, ItemDetailsSelectResultHandler, ButtonItemPresenter.Listener, PhotoUploadObserver.PhotoParameterProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onCancel(@NotNull PublishDetailsPresenter publishDetailsPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
            ItemDetailsSelectResultHandler.DefaultImpls.onCancel(publishDetailsPresenter, str);
        }

        public static /* synthetic */ void showParameters$default(PublishDetailsPresenter publishDetailsPresenter, String str, boolean z, boolean z2, PublishDetailsFlowTracker.FlowContext[] flowContextArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    z2 = false;
                }
                if ((i & 8) != 0) {
                    flowContextArr = new PublishDetailsFlowTracker.FlowContext[0];
                }
                publishDetailsPresenter.showParameters(str, z, z2, flowContextArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showParameters");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "", "navigateToAuth", "()V", "leaveScreen", "Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;", "phoneVerificationData", "showPhoneVerificationScreen", "(Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;)V", "", "url", "showHelpCenterScreen", "(Ljava/lang/String;)V", "", "categoryId", "showCpaTariffRequestScreen", "(I)V", "openWebUrl", "showResidentialComplexSuggestScreen", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends ItemDetailsParameterClickListener.Router, SelectParameterClickListener.Router {
        void leaveScreen();

        void navigateToAuth();

        void openWebUrl(@NotNull String str);

        void showCpaTariffRequestScreen(int i);

        void showHelpCenterScreen(@NotNull String str);

        void showPhoneVerificationScreen(@NotNull ContactInfoSlotWrapper.PhoneVerificationData phoneVerificationData);

        void showResidentialComplexSuggestScreen();
    }

    void attachPublishRouter(@Nullable PublishDetailsRouter publishDetailsRouter);

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ItemDetailsView itemDetailsView, boolean z);

    void detachPublishRouter();

    void detachRouter();

    void detachView();

    boolean enableComputerVisionIfNeeded();

    void handleKeyboard(boolean z);

    void onAuthResult(int i);

    void onDestroy();

    void onResidentialComplexResult(@NotNull SelectParameter.Value value);

    @NotNull
    Bundle onSaveState();

    void setPublishViewModel(@NotNull PublishViewModel publishViewModel);

    void setTagsViewModel(@NotNull PublishTagsViewModel publishTagsViewModel);

    void showParameters(@Nullable String str, boolean z, boolean z2, @NotNull PublishDetailsFlowTracker.FlowContext[] flowContextArr);
}

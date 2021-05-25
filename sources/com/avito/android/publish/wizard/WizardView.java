package com.avito.android.publish.wizard;

import androidx.annotation.DrawableRes;
import com.avito.android.ui.fragments.OnBackPressedListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.OnboardingData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/wizard/WizardView;", "", "", "title", "", "setAppBarTitle", "(Ljava/lang/String;)V", "", "backIcon", "setUpIcon", "(I)V", "dataChanged", "()V", "showParameters", "showContent", "error", "showError", "showRetry", "showProgress", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "Presenter", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WizardView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/wizard/WizardView$Presenter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "", "onRetryClick", "()V", "onCloseClick", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter extends OnBackPressedListener {
        void onCloseClick();

        void onRetryClick();
    }

    void dataChanged();

    void setAppBarTitle(@NotNull String str);

    void setUpIcon(@DrawableRes int i);

    void showActionOnboarding(@NotNull OnboardingData onboardingData);

    void showContent();

    void showError(@NotNull String str);

    void showParameters();

    void showProgress();

    void showRetry();
}

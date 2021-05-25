package com.avito.android.publish.wizard;

import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.wizard.WizardView;
import com.avito.android.util.BundlePersistable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u0018\u0010\u000fJ\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/wizard/WizardPresenter;", "Lcom/avito/android/util/BundlePersistable;", "Lcom/avito/android/publish/wizard/WizardView$Presenter;", "Lcom/avito/android/publish/PublishViewModel;", "viewModel", "", "attachPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "Lcom/avito/android/publish/wizard/WizardView;", "view", "", "stepIndex", "attachView", "(Lcom/avito/android/publish/wizard/WizardView;I)V", "detachView", "()V", "Lcom/avito/android/publish/wizard/WizardRouter;", "router", "attachWizardRouter", "(Lcom/avito/android/publish/wizard/WizardRouter;)V", "detachWizardRouter", "Lcom/avito/android/publish/wizard/WizardPresenter$Router;", "attachRouter", "(Lcom/avito/android/publish/wizard/WizardPresenter$Router;)V", "detachRouter", "requestCode", "resultCode", "", "onResult", "(II)Z", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WizardPresenter extends BundlePersistable, WizardView.Presenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/wizard/WizardPresenter$Router;", "", "", "navigateToAuth", "()V", "Result", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/wizard/WizardPresenter$Router$Result;", "", "", "REQ_LOGIN", "I", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Result {
            @NotNull
            public static final Result INSTANCE = new Result();
            public static final int REQ_LOGIN = 0;
        }

        void navigateToAuth();
    }

    void attachPublishViewModel(@NotNull PublishViewModel publishViewModel);

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull WizardView wizardView, int i);

    void attachWizardRouter(@Nullable WizardRouter wizardRouter);

    void detachRouter();

    void detachView();

    void detachWizardRouter();

    boolean onResult(int i, int i2);
}

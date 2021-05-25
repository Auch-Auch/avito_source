package com.avito.android.contact_access;

import android.os.Bundle;
import com.avito.android.legacy_mvp.Presenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "Lcom/avito/android/legacy_mvp/Presenter;", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "", "retry", "()V", "onContinueClicked", "Lcom/avito/android/contact_access/ContactAccessServiceRouter;", "router", "attachRouter", "(Lcom/avito/android/contact_access/ContactAccessServiceRouter;)V", "detachRouter", "close", "onIncompleteRegisterFinished", "Landroid/os/Bundle;", "bundle", "onSaveState", "(Landroid/os/Bundle;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface ContactAccessServicePresenter extends Presenter<ContactAccessServiceView> {
    void attachRouter(@Nullable ContactAccessServiceRouter contactAccessServiceRouter);

    void close();

    void detachRouter();

    void onContinueClicked();

    void onIncompleteRegisterFinished();

    void onSaveState(@NotNull Bundle bundle);

    void retry();
}

package com.avito.android.info.ui;

import android.os.Bundle;
import com.avito.android.info.ui.InfoView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/info/ui/InfoPresenter;", "Lcom/avito/android/info/ui/InfoView$Callback;", "Lcom/avito/android/info/ui/InfoView;", "infoView", "", "attachView", "(Lcom/avito/android/info/ui/InfoView;)V", "detachView", "()V", "Lcom/avito/android/info/ui/InfoRouter;", "router", "attachRouter", "(Lcom/avito/android/info/ui/InfoRouter;)V", "detachRouter", "Landroid/os/Bundle;", "bundle", "saveState", "(Landroid/os/Bundle;)V", "info_release"}, k = 1, mv = {1, 4, 2})
public interface InfoPresenter extends InfoView.Callback {
    void attachRouter(@NotNull InfoRouter infoRouter);

    void attachView(@NotNull InfoView infoView);

    void detachRouter();

    void detachView();

    void saveState(@NotNull Bundle bundle);
}

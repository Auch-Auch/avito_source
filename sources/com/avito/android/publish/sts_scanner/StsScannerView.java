package com.avito.android.publish.sts_scanner;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsScannerView;", "", "", "message", "", "showMessage", "(Ljava/lang/String;)V", "showContent", "()V", "showLoadingProgress", "Lio/reactivex/Observable;", "getCloseClicks", "()Lio/reactivex/Observable;", "closeClicks", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface StsScannerView {
    @NotNull
    Observable<Unit> getCloseClicks();

    void showContent();

    void showLoadingProgress();

    void showMessage(@NotNull String str);
}

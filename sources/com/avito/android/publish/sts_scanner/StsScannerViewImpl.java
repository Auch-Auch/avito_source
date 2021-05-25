package com.avito.android.publish.sts_scanner;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_button.FloatingButtonBehavior;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsScannerViewImpl;", "Lcom/avito/android/publish/sts_scanner/StsScannerView;", "", "message", "", "showMessage", "(Ljava/lang/String;)V", "showContent", "()V", "showLoadingProgress", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getCloseClicks", "()Lio/reactivex/Observable;", "closeClicks", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "cameraButtons", AuthSource.SEND_ABUSE, "closeButton", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StsScannerViewImpl implements StsScannerView {
    public final View a;
    public final View b;
    public final ProgressOverlay c;
    @NotNull
    public final Observable<Unit> d;

    public StsScannerViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        View findViewById = view.findViewById(R.id.close_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(com.avito.android.photo_picker.R.id.camera_buttons_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        this.c = new ProgressOverlay((ViewGroup) view, R.id.root_view, analytics, false, 0, 24, null);
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) (!(layoutParams instanceof CoordinatorLayout.LayoutParams) ? null : layoutParams);
        if (layoutParams2 != null) {
            layoutParams2.setBehavior(new FloatingButtonBehavior());
            findViewById2.setLayoutParams(layoutParams2);
        }
        this.d = RxView.clicks(findViewById);
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerView
    @NotNull
    public Observable<Unit> getCloseClicks() {
        return this.d;
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerView
    public void showContent() {
        this.c.showContent();
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerView
    public void showLoadingProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.b, str, 0, (String) null, 3, (Function0) null, (Function0) null, 0, 118, (Object) null);
    }
}

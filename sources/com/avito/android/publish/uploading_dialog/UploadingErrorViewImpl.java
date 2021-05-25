package com.avito.android.publish.uploading_dialog;

import android.view.View;
import android.widget.Button;
import com.avito.android.publish.R;
import com.avito.android.publish.uploading_dialog.UploadingErrorView;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/uploading_dialog/UploadingErrorViewImpl;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorView;", "Landroid/widget/Button;", AuthSource.SEND_ABUSE, "Landroid/widget/Button;", "retryButton", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorView$Presenter;", "c", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorView$Presenter;", "presenter", AuthSource.BOOKING_ORDER, "skipButton", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/publish/uploading_dialog/UploadingErrorView$Presenter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UploadingErrorViewImpl implements UploadingErrorView {
    public final Button a;
    public final Button b;
    public final UploadingErrorView.Presenter c;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((UploadingErrorViewImpl) this.b).c.onRetryClicked();
            } else if (i == 1) {
                ((UploadingErrorViewImpl) this.b).c.onSkipClicked();
            } else {
                throw null;
            }
        }
    }

    public UploadingErrorViewImpl(@NotNull View view, @NotNull UploadingErrorView.Presenter presenter) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.c = presenter;
        View findViewById = view.findViewById(R.id.retry_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById;
        this.a = button;
        View findViewById2 = view.findViewById(R.id.skip_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.Button");
        Button button2 = (Button) findViewById2;
        this.b = button2;
        button.setOnClickListener(new a(0, this));
        button2.setOnClickListener(new a(1, this));
    }
}

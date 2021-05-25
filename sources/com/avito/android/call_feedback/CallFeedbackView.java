package com.avito.android.call_feedback;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b`\u0018\u00002\u00020\u0001:\u0001\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackView;", "", "Lio/reactivex/Observable;", "", "getCancelDialogCallback", "()Lio/reactivex/Observable;", "getBackButtonCallbacks", "getRetryButtonCallback", "showProgress", "()V", "showContent", "showError", "", "error", "(Ljava/lang/String;)V", "notifyDataChanged", "hideDialog", "showDialog", "message", "showMessage", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u00100\u001a\u00020-\u0012\n\u0010,\u001a\u0006\u0012\u0002\b\u00030)\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR:\u0010$\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u0003 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u0003\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\u0006\u0012\u0002\b\u00030)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00067"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackView$Impl;", "Lcom/avito/android/call_feedback/CallFeedbackView;", "Lio/reactivex/Observable;", "", "getCancelDialogCallback", "()Lio/reactivex/Observable;", "getBackButtonCallbacks", "getRetryButtonCallback", "showProgress", "()V", "showContent", "showError", "", "error", "(Ljava/lang/String;)V", "notifyDataChanged", "hideDialog", "showDialog", "message", "showMessage", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "dialog", "Lru/avito/component/appbar/AppBar;", AuthSource.SEND_ABUSE, "Lru/avito/component/appbar/AppBar;", "appBar", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", g.a, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "recyclerViewAdapter", "Lcom/avito/android/util/DialogRouter;", "f", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/view/View;", "view", "<init>", "(Lcom/avito/android/util/DialogRouter;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/analytics/Analytics;Landroid/view/View;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements CallFeedbackView {
        public final AppBar a;
        public final PublishRelay<Unit> b = PublishRelay.create();
        public final ProgressOverlay c;
        public final RecyclerView d;
        public Dialog e;
        public final DialogRouter f;
        public final RecyclerView.Adapter<?> g;

        public static final class a implements DialogInterface.OnCancelListener {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ Dialog b;

            public a(Impl impl, Dialog dialog) {
                this.a = impl;
                this.b = dialog;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.b.setOnCancelListener(null);
                this.a.b.accept(Unit.INSTANCE);
                this.a.e = null;
            }
        }

        public Impl(@NotNull DialogRouter dialogRouter, @NotNull RecyclerView.Adapter<?> adapter, @NotNull Analytics analytics, @NotNull View view) {
            Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
            Intrinsics.checkNotNullParameter(adapter, "recyclerViewAdapter");
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(view, "view");
            this.f = dialogRouter;
            this.g = adapter;
            int i = R.id.content;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            this.d = recyclerView;
            AppBarImpl appBarImpl = new AppBarImpl(view, recyclerView, false, 4, null);
            this.a = appBarImpl;
            AppBar.DefaultImpls.setNavigationIcon$default(appBarImpl, R.drawable.ic_back_24_blue, null, 2, null);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.container);
            Intrinsics.checkNotNullExpressionValue(viewGroup, "containerView");
            this.c = new ProgressOverlay(viewGroup, i, analytics, false, 0, 24, null);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setAdapter(adapter);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        @NotNull
        public Observable<Unit> getBackButtonCallbacks() {
            return InteropKt.toV2(this.a.navigationCallbacks());
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        @NotNull
        public Observable<Unit> getCancelDialogCallback() {
            PublishRelay<Unit> publishRelay = this.b;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "dialogRelay");
            return publishRelay;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        @NotNull
        public Observable<Unit> getRetryButtonCallback() {
            return this.c.refreshes();
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void hideDialog() {
            Dialog dialog = this.e;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.e = null;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void notifyDataChanged() {
            this.g.notifyDataSetChanged();
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showContent() {
            this.c.showContent();
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showDialog() {
            if (this.e == null) {
                Dialog showSimpleWaitingDialog = this.f.showSimpleWaitingDialog();
                showSimpleWaitingDialog.setOnCancelListener(new a(this, showSimpleWaitingDialog));
                this.e = showSimpleWaitingDialog;
            }
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showError() {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            RecyclerView recyclerView = this.d;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            Context context = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
            ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showProgress() {
            this.c.showLoading();
        }

        @Override // com.avito.android.call_feedback.CallFeedbackView
        public void showError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            this.c.showLoadingProblem(str);
        }
    }

    @NotNull
    Observable<Unit> getBackButtonCallbacks();

    @NotNull
    Observable<Unit> getCancelDialogCallback();

    @NotNull
    Observable<Unit> getRetryButtonCallback();

    void hideDialog();

    void notifyDataChanged();

    void showContent();

    void showDialog();

    void showError();

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgress();
}

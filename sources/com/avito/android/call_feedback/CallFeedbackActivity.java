package com.avito.android.call_feedback;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.call_feedback.CallFeedbackView;
import com.avito.android.call_feedback.di.CallFeedbackComponent;
import com.avito.android.call_feedback.di.CallFeedbackDependencies;
import com.avito.android.call_feedback.di.DaggerCallFeedbackComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/call_feedback/CallFeedbackRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "onStop", "onDestroy", "close", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "recyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getRecyclerViewAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setRecyclerViewAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "presenter", "Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "getPresenter", "()Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "setPresenter", "(Lcom/avito/android/call_feedback/CallFeedbackPresenter;)V", "<init>", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public final class CallFeedbackActivity extends BaseActivity implements CallFeedbackRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public CallFeedbackPresenter presenter;
    @Inject
    public RecyclerView.Adapter<?> recyclerViewAdapter;

    @Override // com.avito.android.call_feedback.CallFeedbackRouter
    public void close() {
        finish();
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final CallFeedbackPresenter getPresenter() {
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return callFeedbackPresenter;
    }

    @NotNull
    public final RecyclerView.Adapter<?> getRecyclerViewAdapter() {
        RecyclerView.Adapter<?> adapter = this.recyclerViewAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        return adapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.growth_hacking_call_feedback);
        CallFeedbackDependencies callFeedbackDependencies = (CallFeedbackDependencies) ComponentDependenciesKt.getDependencies(CallFeedbackDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this));
        String stringExtra = getIntent().getStringExtra("key");
        Kundle kundle = bundle != null ? (Kundle) bundle.getParcelable("key") : null;
        CallFeedbackComponent.Builder withActivity = DaggerCallFeedbackComponent.builder().dependencies(callFeedbackDependencies).withActivity(this);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "callId");
        withActivity.withCallId(stringExtra).withPresenterState(kundle).build().inject(this);
        View findViewById = findViewById(16908290);
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        RecyclerView.Adapter<?> adapter = this.recyclerViewAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView");
        CallFeedbackView.Impl impl = new CallFeedbackView.Impl(dialogRouter2, adapter, analytics2, findViewById);
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        callFeedbackPresenter.attachView(impl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        callFeedbackPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key", callFeedbackPresenter.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        callFeedbackPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CallFeedbackPresenter callFeedbackPresenter = this.presenter;
        if (callFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        callFeedbackPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setPresenter(@NotNull CallFeedbackPresenter callFeedbackPresenter) {
        Intrinsics.checkNotNullParameter(callFeedbackPresenter, "<set-?>");
        this.presenter = callFeedbackPresenter;
    }

    public final void setRecyclerViewAdapter(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.recyclerViewAdapter = adapter;
    }
}

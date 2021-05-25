package com.avito.android.call_feedback;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CallFeedbackActivity_MembersInjector implements MembersInjector<CallFeedbackActivity> {
    public final Provider<Analytics> a;
    public final Provider<CallFeedbackPresenter> b;
    public final Provider<DialogRouter> c;
    public final Provider<RecyclerView.Adapter<?>> d;

    public CallFeedbackActivity_MembersInjector(Provider<Analytics> provider, Provider<CallFeedbackPresenter> provider2, Provider<DialogRouter> provider3, Provider<RecyclerView.Adapter<?>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<CallFeedbackActivity> create(Provider<Analytics> provider, Provider<CallFeedbackPresenter> provider2, Provider<DialogRouter> provider3, Provider<RecyclerView.Adapter<?>> provider4) {
        return new CallFeedbackActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.call_feedback.CallFeedbackActivity.analytics")
    public static void injectAnalytics(CallFeedbackActivity callFeedbackActivity, Analytics analytics) {
        callFeedbackActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.call_feedback.CallFeedbackActivity.dialogRouter")
    public static void injectDialogRouter(CallFeedbackActivity callFeedbackActivity, DialogRouter dialogRouter) {
        callFeedbackActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.call_feedback.CallFeedbackActivity.presenter")
    public static void injectPresenter(CallFeedbackActivity callFeedbackActivity, CallFeedbackPresenter callFeedbackPresenter) {
        callFeedbackActivity.presenter = callFeedbackPresenter;
    }

    @InjectedFieldSignature("com.avito.android.call_feedback.CallFeedbackActivity.recyclerViewAdapter")
    public static void injectRecyclerViewAdapter(CallFeedbackActivity callFeedbackActivity, RecyclerView.Adapter<?> adapter) {
        callFeedbackActivity.recyclerViewAdapter = adapter;
    }

    public void injectMembers(CallFeedbackActivity callFeedbackActivity) {
        injectAnalytics(callFeedbackActivity, this.a.get());
        injectPresenter(callFeedbackActivity, this.b.get());
        injectDialogRouter(callFeedbackActivity, this.c.get());
        injectRecyclerViewAdapter(callFeedbackActivity, this.d.get());
    }
}

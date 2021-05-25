package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.avito.android.messenger.conversation.mvi.deeplinks.ActivityResult;
import com.avito.android.util.ToastsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListenerImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorListener;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class RequestReviewLinkProcessorListenerImpl extends RequestReviewLinkProcessorListener {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.Context, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.LiveData] */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener
    public /* bridge */ /* synthetic */ void doAttach(RequestReviewLinkProcessor requestReviewLinkProcessor, Context context, LifecycleOwner lifecycleOwner, LiveData liveData) {
        doAttach(requestReviewLinkProcessor, (RequestReviewLinkProcessor) context, (Context) lifecycleOwner, (LiveData<ActivityResult>) liveData);
    }

    public <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull RequestReviewLinkProcessor requestReviewLinkProcessor, @NotNull C c, @NotNull F f, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(requestReviewLinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c, "context");
        Intrinsics.checkNotNullParameter(f, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        requestReviewLinkProcessor.getErrorMessageStream().observe(f, new Observer<T>(c) { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1
            public final /* synthetic */ Context a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ToastsKt.showToast$default(this.a, t, 0, 2, (Object) null);
                }
            }
        });
    }
}

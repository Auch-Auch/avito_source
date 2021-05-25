package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.RequestReviewLink;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/RequestReviewLink;", "Landroidx/lifecycle/LiveData;", "", "getReviewRequestedStream", "()Landroidx/lifecycle/LiveData;", "reviewRequestedStream", "", "getErrorMessageStream", "errorMessageStream", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class RequestReviewLinkProcessor extends AbstractDeeplinkProcessor<RequestReviewLink> {
    public RequestReviewLinkProcessor() {
        super(RequestReviewLink.class);
    }

    @NotNull
    public abstract LiveData<String> getErrorMessageStream();

    @NotNull
    public abstract LiveData<Unit> getReviewRequestedStream();
}

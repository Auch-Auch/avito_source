package com.avito.android.rating.review_details.upload;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "", "Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;", "observer", "", "resetState", "", "subscribe", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;Z)V", "unsubscribe", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewReplyProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void subscribe$default(ReviewReplyProvider reviewReplyProvider, ReviewReplyObserver reviewReplyObserver, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                reviewReplyProvider.subscribe(reviewReplyObserver, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }
    }

    void subscribe(@NotNull ReviewReplyObserver reviewReplyObserver, boolean z);

    void unsubscribe(@NotNull ReviewReplyObserver reviewReplyObserver);
}

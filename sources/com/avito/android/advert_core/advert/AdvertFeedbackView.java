package com.avito.android.advert_core.advert;

import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertFeedbackView;", "", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "state", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showFeedback", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;)V", "getFeedbackState", "()Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "", "isFeedbackSent", "clearFeedbackState", "(Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertFeedbackView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void clearFeedbackState$default(AdvertFeedbackView advertFeedbackView, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                advertFeedbackView.clearFeedbackState(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFeedbackState");
        }
    }

    void clearFeedbackState(boolean z);

    @Nullable
    FeedbackDialog.State getFeedbackState();

    void showFeedback(@NotNull FeedbackDialog.State state, @NotNull FeedbackDialog.Listener listener);
}

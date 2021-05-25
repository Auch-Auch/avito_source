package com.avito.android.advert_core.contactbar.feedback;

import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.advert_details.FeedbackResponse;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JE\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "", "", "feedback", BookingInfoActivity.EXTRA_ITEM_ID, ChannelContext.Item.USER_ID, "categoryId", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/advert_details/FeedbackResponse;", "sendFeedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)Lio/reactivex/rxjava3/core/Observable;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface FeedbackInteractor {
    @NotNull
    Observable<FeedbackResponse> sendFeedback(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable FeedbackDialog.Source source);
}

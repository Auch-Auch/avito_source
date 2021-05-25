package com.avito.android.advert_core.contactbar.feedback;

import a2.b.a.a.a;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.advert_details.FeedbackResponse;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractorImpl;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "", "feedback", BookingInfoActivity.EXTRA_ITEM_ID, ChannelContext.Item.USER_ID, "categoryId", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/advert_details/FeedbackResponse;", "sendFeedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackInteractorImpl implements FeedbackInteractor {
    public final AdvertDetailsApi a;
    public final SchedulersFactory3 b;

    @Inject
    public FeedbackInteractorImpl(@NotNull AdvertDetailsApi advertDetailsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = advertDetailsApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor
    @NotNull
    public Observable<FeedbackResponse> sendFeedback(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable FeedbackDialog.Source source) {
        Intrinsics.checkNotNullParameter(str, "feedback");
        Observable<TypedResult<FeedbackResponse>> subscribeOn = this.a.sendFeedback(str2, str3, a.I2("UUID.randomUUID().toString()"), str4, str, source != null ? source.getTextValue() : null).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.sendFeedback(\n      …scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}

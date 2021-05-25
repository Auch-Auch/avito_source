package com.avito.android.call_feedback;

import com.avito.android.remote.CallFeedbackApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CallFeedbackResult;
import com.avito.android.remote.model.CallFeedbackShow;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/CallFeedbackShow;", "getItems", "()Lio/reactivex/Observable;", "", "itemId", "Lcom/avito/android/remote/model/CallFeedbackResult;", "setItem", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackInteractor$Impl;", "Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/CallFeedbackShow;", "getItems", "()Lio/reactivex/Observable;", "", "itemId", "Lcom/avito/android/remote/model/CallFeedbackResult;", "setItem", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Scheduler;", AuthSource.SEND_ABUSE, "Lio/reactivex/Scheduler;", "ioScheduler", "c", "Ljava/lang/String;", "callId", "Lcom/avito/android/remote/CallFeedbackApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/CallFeedbackApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/CallFeedbackApi;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements CallFeedbackInteractor {
        public final Scheduler a;
        public final CallFeedbackApi b;
        public final String c;

        @Inject
        public Impl(@NotNull CallFeedbackApi callFeedbackApi, @NotNull String str, @NotNull SchedulersFactory schedulersFactory) {
            Intrinsics.checkNotNullParameter(callFeedbackApi, "api");
            Intrinsics.checkNotNullParameter(str, "callId");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
            this.b = callFeedbackApi;
            this.c = str;
            this.a = schedulersFactory.io();
        }

        @Override // com.avito.android.call_feedback.CallFeedbackInteractor
        @NotNull
        public Observable<CallFeedbackShow> getItems() {
            Observable<CallFeedbackShow> subscribeOn = TypedObservablesKt.toTyped(InteropKt.toV2(this.b.getItems(this.c))).subscribeOn(this.a);
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api\n                .get….subscribeOn(ioScheduler)");
            return subscribeOn;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackInteractor
        @NotNull
        public Observable<CallFeedbackResult> setItem(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Observable<CallFeedbackResult> subscribeOn = TypedObservablesKt.toTyped(InteropKt.toV2(this.b.setItem(this.c, str))).subscribeOn(this.a);
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api\n                .set….subscribeOn(ioScheduler)");
            return subscribeOn;
        }
    }

    @NotNull
    Observable<CallFeedbackShow> getItems();

    @NotNull
    Observable<CallFeedbackResult> setItem(@NotNull String str);
}

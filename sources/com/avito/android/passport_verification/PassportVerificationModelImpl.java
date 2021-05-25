package com.avito.android.passport_verification;

import a2.a.a.s1.a;
import a2.a.a.s1.b;
import a2.g.r.g;
import androidx.annotation.WorkerThread;
import com.avito.android.analytics.Analytics;
import com.avito.android.passport_verification.PassportVerificationModel;
import com.avito.android.passport_verification.SnsSdkNavigation;
import com.avito.android.passport_verification.analytics.PassportVerificationClickEvent;
import com.avito.android.passport_verification.di.IsFirstStart;
import com.avito.android.passport_verification.di.SumSubFlowName;
import com.avito.android.passport_verification.di.UrlForSumSubSdk;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.sumsub.sns.core.data.model.SNSSDKState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\b\u0012\b\b\u0001\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00103\u001a\u000202\u0012\b\b\u0001\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aRD\u0010#\u001a0\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00030\u0003 \u001f*\u0017\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001e¢\u0006\u0002\b 0\u001e¢\u0006\u0002\b 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*RD\u0010-\u001a0\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00060\u0006 \u001f*\u0017\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u001e¢\u0006\u0002\b 0\u001e¢\u0006\u0002\b 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00068"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModelImpl;", "Lcom/avito/android/passport_verification/PassportVerificationModel;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/passport_verification/SnsSdkNavigation;", "sdkLaunchData", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "navigationEvents", "", "onTokenExpired", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "newState", "", "onSdkStateChange", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "state", "onSdkError", "(Ljava/lang/Exception;Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "onSdkSuccess", "clear", "()V", "d", "Ljava/lang/String;", "urlForSdk", "e", "flowName", "Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "sdkNavigationData", "Lcom/avito/android/passport_verification/PassportVerificationInteractor;", "f", "Lcom/avito/android/passport_verification/PassportVerificationInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "c", "navigationData", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "isFirstStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/passport_verification/PassportVerificationInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Z)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public final class PassportVerificationModelImpl implements PassportVerificationModel {
    public Disposable a;
    public final BehaviorSubject<SnsSdkNavigation> b = BehaviorSubject.create();
    public final BehaviorSubject<PassportVerificationModel.Navigation> c = BehaviorSubject.create();
    public final String d;
    public final String e;
    public final PassportVerificationInteractor f;
    public final SchedulersFactory3 g;

    @Inject
    public PassportVerificationModelImpl(@UrlForSumSubSdk @NotNull String str, @SumSubFlowName @NotNull String str2, @NotNull PassportVerificationInteractor passportVerificationInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @IsFirstStart boolean z) {
        Intrinsics.checkNotNullParameter(str, "urlForSdk");
        Intrinsics.checkNotNullParameter(str2, "flowName");
        Intrinsics.checkNotNullParameter(passportVerificationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = str;
        this.e = str2;
        this.f = passportVerificationInteractor;
        this.g = schedulersFactory3;
        if (z) {
            analytics.track(new PassportVerificationClickEvent());
        }
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = passportVerificationInteractor.requestAccessToken().subscribeOn(schedulersFactory3.io()).subscribe(new a(this), new b(this));
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    public void clear() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    @NotNull
    public Observable<PassportVerificationModel.Navigation> navigationEvents() {
        Observable<PassportVerificationModel.Navigation> hide = this.c.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "navigationData.hide()");
        return hide;
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    public void onSdkError(@Nullable Exception exc, @NotNull SNSSDKState sNSSDKState) {
        Intrinsics.checkNotNullParameter(sNSSDKState, "state");
        if (!(sNSSDKState instanceof SNSSDKState.Initial) && !(sNSSDKState instanceof SNSSDKState.Incomplete)) {
            this.c.onNext(new PassportVerificationModel.Navigation.FinishWithError(true));
        } else {
            this.c.onNext(new PassportVerificationModel.Navigation.FinishWithError(false));
        }
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    public void onSdkStateChange(@NotNull SNSSDKState sNSSDKState) {
        Intrinsics.checkNotNullParameter(sNSSDKState, "newState");
        if ((sNSSDKState instanceof SNSSDKState.Failed) || (sNSSDKState instanceof SNSSDKState.Pending) || (sNSSDKState instanceof SNSSDKState.FinallyRejected) || (sNSSDKState instanceof SNSSDKState.Approved)) {
            this.b.onNext(SnsSdkNavigation.DismissSnsSdk.INSTANCE);
        }
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    public void onSdkSuccess(@NotNull SNSSDKState sNSSDKState) {
        Intrinsics.checkNotNullParameter(sNSSDKState, "state");
        boolean z = sNSSDKState instanceof SNSSDKState.Pending;
        if (z || (sNSSDKState instanceof SNSSDKState.FinallyRejected) || (sNSSDKState instanceof SNSSDKState.TemporarilyDeclined) || (sNSSDKState instanceof SNSSDKState.Approved)) {
            this.c.onNext(new PassportVerificationModel.Navigation.FinishWithChanges(z));
        } else {
            this.c.onNext(PassportVerificationModel.Navigation.FinishWithNoChanges.INSTANCE);
        }
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    @WorkerThread
    @NotNull
    public String onTokenExpired() {
        String blockingGet = this.f.requestAccessToken().blockingGet();
        BehaviorSubject<SnsSdkNavigation> behaviorSubject = this.b;
        Intrinsics.checkNotNullExpressionValue(blockingGet, "result");
        behaviorSubject.onNext(new SnsSdkNavigation.OpenSnsSdk(blockingGet, this.e, this.d));
        return blockingGet;
    }

    @Override // com.avito.android.passport_verification.PassportVerificationModel
    @NotNull
    public Observable<SnsSdkNavigation> sdkLaunchData() {
        Observable<SnsSdkNavigation> hide = this.b.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "sdkNavigationData.hide()");
        return hide;
    }
}

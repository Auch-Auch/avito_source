package com.avito.android.rating.publish;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002\u0017\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishPresenter;", "Lcom/avito/android/rating/publish/StepListener;", "Lcom/avito/android/rating/publish/RatingPublishView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/RatingPublishView;)V", "Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/ratings/RatingPublishConfig;", Navigation.CONFIG, "handleConfig", "(Lcom/avito/android/ratings/RatingPublishConfig;)V", "onPopScreen", "onActionSuccess", "Router", "StepHolder", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingPublishPresenter extends StepListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ7\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001a\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH&¢\u0006\u0004\b\u001f\u0010\u0017¨\u0006!"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;", "", "Lcom/avito/android/rating/publish/RatingPublishStep;", "ratingPublishStep", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "", "openScreen", "(Lcom/avito/android/rating/publish/RatingPublishStep;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "", "rawRatingPublishStep", "Lcom/avito/android/rating/publish/RatingPublishStepType;", "ratingPublishStepType", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", "(Ljava/lang/String;Lcom/avito/android/rating/publish/RatingPublishStepType;Lcom/avito/android/remote/model/publish/NextStagePayload;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "userKey", "message", "closeWithMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "onBackPressed", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "reqId", "(Lcom/avito/android/deep_linking/links/DeepLink;I)V", "onExit", "Result", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishPresenter$Router$Result;", "", "", "REQ_PHONE_ADD", "I", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
        public static final class Result {
            @NotNull
            public static final Result INSTANCE = new Result();
            public static final int REQ_PHONE_ADD = 0;
        }

        void closeWithMessage(@NotNull String str, @NotNull String str2);

        void followDeepLink(@NotNull DeepLink deepLink);

        void followDeepLink(@NotNull DeepLink deepLink, int i);

        void onBackPressed();

        void onExit();

        void openScreen(@NotNull RatingPublishStep ratingPublishStep, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData);

        void openScreen(@NotNull String str, @NotNull RatingPublishStepType ratingPublishStepType, @NotNull NextStagePayload nextStagePayload, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;", "", "", "", "errors", "", "proxyErrors", "(Ljava/util/Map;)V", "", "isLoading", "proxyLoadingState", "(Z)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface StepHolder {
        void proxyErrors(@NotNull Map<String, String> map);

        void proxyLoadingState(boolean z);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull RatingPublishView ratingPublishView);

    void detachRouter();

    void detachView();

    void handleConfig(@NotNull RatingPublishConfig ratingPublishConfig);

    void onActionSuccess();

    void onPopScreen();

    @NotNull
    Kundle onSaveState();
}

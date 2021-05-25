package com.avito.android.rating.publish.review_input;

import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.util.Kundle;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;", "", "Lcom/avito/android/rating/publish/review_input/ReviewInputView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/review_input/ReviewInputView;)V", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", AbuseSendingResult.COMMENT, "applyComment", "(Ljava/lang/String;)V", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "", "isLoading", "handleLoading", "(Z)V", "Router", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewInputPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;", "", "", "onBackPressed", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onBackPressed();
    }

    void applyComment(@NotNull String str);

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ReviewInputView reviewInputView);

    void detachRouter();

    void detachView();

    void handleErrors(@NotNull Map<String, String> map);

    void handleLoading(boolean z);

    @NotNull
    Kundle onSaveState();
}

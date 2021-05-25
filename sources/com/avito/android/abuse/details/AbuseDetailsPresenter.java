package com.avito.android.abuse.details;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "", "Lcom/avito/android/abuse/details/AbuseDetailsView;", "view", "", "attachView", "(Lcom/avito/android/abuse/details/AbuseDetailsView;)V", "detachView", "()V", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "onSendingAccepted", "Router", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseDetailsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;", "", "", "openAuthQueryScreen", "()V", "close", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "closeWithResult", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void closeWithResult$default(Router router, DeepLink deepLink, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        deepLink = null;
                    }
                    router.closeWithResult(deepLink);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeWithResult");
            }
        }

        void close();

        void closeWithResult(@Nullable DeepLink deepLink);

        void openAuthQueryScreen();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AbuseDetailsView abuseDetailsView);

    void detachRouter();

    void detachView();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();

    void onSendingAccepted();
}

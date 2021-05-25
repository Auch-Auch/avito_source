package com.avito.android.rating.user_contacts;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\fR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "", "Lcom/avito/android/rating/user_contacts/UserContactsView;", "view", "", "attachView", "(Lcom/avito/android/rating/user_contacts/UserContactsView;)V", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/user_contacts/UserContactsPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "userKey", "message", "onRatingPublished", "(Ljava/lang/String;Ljava/lang/String;)V", "resetScores", "Lio/reactivex/rxjava3/core/Observable;", "", "getChangesObservable", "()Lio/reactivex/rxjava3/core/Observable;", "changesObservable", "Router", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserContactsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull UserContactsView userContactsView);

    void detachRouter();

    @NotNull
    Observable<Boolean> getChangesObservable();

    void onRatingPublished(@NotNull String str, @Nullable String str2);

    @NotNull
    Kundle onSaveState();

    void resetScores();
}

package com.avito.android.saved_searches;

import com.avito.android.deep_linking.links.SearchPushSubscription;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\rH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\rH&¢\u0006\u0004\b\u0012\u0010\u000fJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchView;", "", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "", "selectedId", "", "pushEnabled", "", "show", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/Integer;Z)V", "closeDialog", "()V", "Lio/reactivex/rxjava3/core/Observable;", "applyAction", "()Lio/reactivex/rxjava3/core/Observable;", "deleteAction", "closeAction", "openSettingsAction", "frequencyChangedAction", "showSubscriptionMessage", "showSubscriptionEditedMessage", "showUnsubscriptionMessage", "", "message", "showMessage", "(Ljava/lang/String;)V", "showErrorMessage", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public interface SavedSearchView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void show$default(SavedSearchView savedSearchView, SearchPushSubscription searchPushSubscription, Integer num, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                savedSearchView.show(searchPushSubscription, num, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }

    @NotNull
    Observable<Unit> applyAction();

    @NotNull
    Observable<Unit> closeAction();

    void closeDialog();

    @NotNull
    Observable<Unit> deleteAction();

    @NotNull
    Observable<Integer> frequencyChangedAction();

    @NotNull
    Observable<Unit> openSettingsAction();

    void show(@NotNull SearchPushSubscription searchPushSubscription, @Nullable Integer num, boolean z);

    void showErrorMessage();

    void showMessage(@NotNull String str);

    void showSubscriptionEditedMessage();

    void showSubscriptionMessage();

    void showUnsubscriptionMessage();
}

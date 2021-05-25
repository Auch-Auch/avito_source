package a2.a.a.j2;

import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Ref;
public final class b<T> implements Consumer<LoadingState<? super Parcelable>> {
    public final /* synthetic */ SavedSearchesPresenterImpl a;
    public final /* synthetic */ Ref.ObjectRef b;

    public b(SavedSearchesPresenterImpl savedSearchesPresenterImpl, Ref.ObjectRef objectRef) {
        this.a = savedSearchesPresenterImpl;
        this.b = objectRef;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Parcelable> loadingState) {
        DeepLink deepLink;
        LoadingState<? super Parcelable> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            Parcelable parcelable = (Parcelable) loaded.getData();
            if (parcelable instanceof SearchSubscription) {
                Object data = loaded.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.SearchSubscription");
                deepLink = ((SearchSubscription) data).getEditAction();
            } else if (parcelable instanceof SubscriptionResult) {
                Object data2 = loaded.getData();
                Objects.requireNonNull(data2, "null cannot be cast to non-null type com.avito.android.remote.model.SubscriptionResult");
                deepLink = ((SubscriptionResult) data2).uri();
            } else {
                deepLink = new NoMatchLink();
            }
            if (!(deepLink instanceof SaveSearchLink)) {
                deepLink = null;
            }
            SaveSearchLink saveSearchLink = (SaveSearchLink) deepLink;
            if (saveSearchLink != null) {
                this.a.c.accept(TuplesKt.to(SearchSubscribeReason.SUBSCRIBE, saveSearchLink));
                this.b.element.invoke();
                SavedSearchesPresenterImpl.access$invalidateState(this.a);
            }
        }
    }
}

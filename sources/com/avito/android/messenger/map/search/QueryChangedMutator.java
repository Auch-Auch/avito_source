package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.StateModifier;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.util.CharSequencesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JD\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/map/search/QueryChangedMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/StateModifier;", "oldState", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "query", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "searchSuggests", "favoritePlaces", "copy", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/List;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "d", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "interactor", "c", "Ljava/lang/String;", "newQuery", "stateModifier", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/map/search/GeoSearchInteractor;Lcom/avito/android/messenger/map/search/StateModifier;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class QueryChangedMutator extends Mutator<GeoSearchPresenter.State> implements StateModifier {
    public final String c;
    public final GeoSearchInteractor d;
    public final /* synthetic */ StateModifier e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryChangedMutator(@NotNull String str, @NotNull GeoSearchInteractor geoSearchInteractor, @NotNull StateModifier stateModifier) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, "newQuery");
        Intrinsics.checkNotNullParameter(geoSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(stateModifier, "stateModifier");
        this.e = stateModifier;
        this.c = str;
        this.d = geoSearchInteractor;
    }

    @Override // com.avito.android.messenger.map.search.StateModifier
    @NotNull
    public GeoSearchPresenter.State copy(@NotNull GeoSearchPresenter.State state, @NotNull String str, @NotNull Loading<List<GeoSearchSuggestItem>> loading, @NotNull List<GeoSearchSuggestItem> list) {
        Intrinsics.checkNotNullParameter(state, "$this$copy");
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(loading, "searchSuggests");
        Intrinsics.checkNotNullParameter(list, "favoritePlaces");
        return this.e.copy(state, str, loading, list);
    }

    @NotNull
    public GeoSearchPresenter.State invoke(@NotNull GeoSearchPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        if (CharSequencesKt.getTrimmedLength(this.c) >= 3) {
            this.d.getSearchSuggests(this.c);
        }
        return StateModifier.DefaultImpls.copy$default(this, state, this.c, null, null, 6, null);
    }
}

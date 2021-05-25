package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.v2.Action;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.util.CharSequencesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/map/search/ReconnectedAction;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;)V", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "c", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "interactor", "<init>", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ReconnectedAction extends Action<GeoSearchPresenter.State> {
    public final GeoSearchInteractor c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReconnectedAction(@NotNull GeoSearchInteractor geoSearchInteractor) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(geoSearchInteractor, "interactor");
        this.c = geoSearchInteractor;
    }

    public void invoke(@NotNull GeoSearchPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "curState");
        if ((state.getConnectionErrorIndicatorState() instanceof ConnectionErrorIndicatorView.State.Shown) && CharSequencesKt.getTrimmedLength(state.getQuery()) >= 3) {
            this.c.getSearchSuggests(state.getQuery());
        }
    }
}

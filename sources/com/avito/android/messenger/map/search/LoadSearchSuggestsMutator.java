package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/map/search/LoadSearchSuggestsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;)Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "doLoadSearchSuggests", "", "c", "J", "requestId", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LoadSearchSuggestsMutator extends Mutator<GeoSearchInteractor.State> {
    public final long c;
    public final Function0<Unit> d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadSearchSuggestsMutator(long j, @NotNull Function0<Unit> function0) {
        super("LoadSearchSuggestsMutator(requestId = " + j + ')');
        Intrinsics.checkNotNullParameter(function0, "doLoadSearchSuggests");
        this.c = j;
        this.d = function0;
    }

    @NotNull
    public GeoSearchInteractor.State invoke(@NotNull GeoSearchInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        this.d.invoke();
        return GeoSearchInteractor.State.copy$default(state, null, new Loading.InProgress(this.c), 1, null);
    }
}

package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JD\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/map/search/NewInteractorStateMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/StateModifier;", "oldState", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "query", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "searchSuggests", "favoritePlaces", "copy", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/List;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "c", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "interactorState", "stateModifier", "<init>", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;Lcom/avito/android/messenger/map/search/StateModifier;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NewInteractorStateMutator extends Mutator<GeoSearchPresenter.State> implements StateModifier {
    public final GeoSearchInteractor.State c;
    public final /* synthetic */ StateModifier d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewInteractorStateMutator(@NotNull GeoSearchInteractor.State state, @NotNull StateModifier stateModifier) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(state, "interactorState");
        Intrinsics.checkNotNullParameter(stateModifier, "stateModifier");
        this.d = stateModifier;
        this.c = state;
    }

    @Override // com.avito.android.messenger.map.search.StateModifier
    @NotNull
    public GeoSearchPresenter.State copy(@NotNull GeoSearchPresenter.State state, @NotNull String str, @NotNull Loading<List<GeoSearchSuggestItem>> loading, @NotNull List<GeoSearchSuggestItem> list) {
        Intrinsics.checkNotNullParameter(state, "$this$copy");
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(loading, "searchSuggests");
        Intrinsics.checkNotNullParameter(list, "favoritePlaces");
        return this.d.copy(state, str, loading, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.messenger.map.search.GeoSearchPresenter.State invoke(@org.jetbrains.annotations.NotNull com.avito.android.messenger.map.search.GeoSearchPresenter.State r19) {
        /*
            r18 = this;
            r7 = r18
            java.lang.String r0 = "oldState"
            r1 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.avito.android.messenger.map.search.GeoSearchInteractor$State r0 = r7.c
            com.avito.android.messenger.channels.mvi.common.Loading r0 = r0.getSearchSuggests()
            boolean r2 = r0 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Empty
            r3 = 10
            if (r2 == 0) goto L_0x001d
            com.avito.android.messenger.channels.mvi.common.Loading$Empty r0 = new com.avito.android.messenger.channels.mvi.common.Loading$Empty
            r0.<init>()
        L_0x001a:
            r4 = r0
            goto L_0x008d
        L_0x001d:
            boolean r2 = r0 instanceof com.avito.android.messenger.channels.mvi.common.Loading.InProgress
            if (r2 == 0) goto L_0x002e
            com.avito.android.messenger.channels.mvi.common.Loading$InProgress r2 = new com.avito.android.messenger.channels.mvi.common.Loading$InProgress
            com.avito.android.messenger.channels.mvi.common.Loading$InProgress r0 = (com.avito.android.messenger.channels.mvi.common.Loading.InProgress) r0
            long r4 = r0.getId()
            r2.<init>(r4)
        L_0x002c:
            r4 = r2
            goto L_0x008d
        L_0x002e:
            boolean r2 = r0 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Success
            if (r2 == 0) goto L_0x007d
            com.avito.android.messenger.channels.mvi.common.Loading$Success r0 = (com.avito.android.messenger.channels.mvi.common.Loading.Success) r0
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = t6.n.e.collectionSizeOrDefault(r0, r3)
            r2.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0047:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r0.next()
            com.avito.android.remote.model.messenger.geo.GeoSearchSuggest r4 = (com.avito.android.remote.model.messenger.geo.GeoSearchSuggest) r4
            com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem r5 = new com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem
            double r9 = r4.getLatitude()
            double r11 = r4.getLongitude()
            java.lang.String r13 = r4.getKind()
            java.lang.String r14 = r4.getTitle()
            java.lang.String r15 = r4.getName()
            java.lang.String r16 = r4.getDescription()
            java.lang.String r17 = "search result"
            r8 = r5
            r8.<init>(r9, r11, r13, r14, r15, r16, r17)
            r2.add(r5)
            goto L_0x0047
        L_0x0077:
            com.avito.android.messenger.channels.mvi.common.Loading$Success r0 = new com.avito.android.messenger.channels.mvi.common.Loading$Success
            r0.<init>(r2)
            goto L_0x001a
        L_0x007d:
            boolean r2 = r0 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Error
            if (r2 == 0) goto L_0x00f1
            com.avito.android.messenger.channels.mvi.common.Loading$Error r2 = new com.avito.android.messenger.channels.mvi.common.Loading$Error
            com.avito.android.messenger.channels.mvi.common.Loading$Error r0 = (com.avito.android.messenger.channels.mvi.common.Loading.Error) r0
            java.lang.Throwable r0 = r0.getError()
            r2.<init>(r0)
            goto L_0x002c
        L_0x008d:
            com.avito.android.messenger.map.search.GeoSearchInteractor$State r0 = r7.c
            java.util.List r0 = r0.getFavoritePlaces()
            java.util.ArrayList r5 = new java.util.ArrayList
            int r2 = t6.n.e.collectionSizeOrDefault(r0, r3)
            r5.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x00a0:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00e1
            java.lang.Object r2 = r0.next()
            com.avito.android.remote.model.messenger.geo.GeoSearchSuggest r2 = (com.avito.android.remote.model.messenger.geo.GeoSearchSuggest) r2
            com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem r3 = new com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem
            double r9 = r2.getLatitude()
            double r11 = r2.getLongitude()
            java.lang.String r13 = r2.getKind()
            java.lang.String r14 = r2.getTitle()
            java.lang.String r15 = r2.getName()
            java.lang.String r16 = r2.getDescription()
            java.lang.Boolean r2 = r2.getFromItem()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)
            if (r2 == 0) goto L_0x00d5
            java.lang.String r2 = "item suggest"
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r2 = "previous geo suggest"
        L_0x00d7:
            r17 = r2
            r8 = r3
            r8.<init>(r9, r11, r13, r14, r15, r16, r17)
            r5.add(r3)
            goto L_0x00a0
        L_0x00e1:
            r6 = 1
            r8 = 0
            r2 = 0
            r0 = r18
            r1 = r19
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            com.avito.android.messenger.map.search.GeoSearchPresenter$State r0 = com.avito.android.messenger.map.search.StateModifier.DefaultImpls.copy$default(r0, r1, r2, r3, r4, r5, r6)
            return r0
        L_0x00f1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.search.NewInteractorStateMutator.invoke(com.avito.android.messenger.map.search.GeoSearchPresenter$State):com.avito.android.messenger.map.search.GeoSearchPresenter$State");
    }
}

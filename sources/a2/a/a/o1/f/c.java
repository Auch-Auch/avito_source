package a2.a.a.o1.f;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.api.entity.ChannelSearchItem;
import ru.avito.messenger.api.entity.ChannelsSearchResponse;
import ru.avito.messenger.api.entity.ChatMessage;
import t6.n.e;
public final class c<T, R> implements Function<ChannelsSearchResponse, ChannelsSearchInteractor.State> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.d a;
    public final /* synthetic */ ChannelsSearchInteractor.State b;

    public c(ChannelsSearchInteractorImpl.d dVar, ChannelsSearchInteractor.State state) {
        this.a = dVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelsSearchInteractor.State apply(ChannelsSearchResponse channelsSearchResponse) {
        ChannelsSearchResponse channelsSearchResponse2 = channelsSearchResponse;
        Intrinsics.checkNotNullParameter(channelsSearchResponse2, "results");
        List<ChannelSearchItem> items = channelsSearchResponse2.getItems();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        for (T t : items) {
            MessengerEntityConverter messengerEntityConverter = ChannelsSearchInteractorImpl.this.q;
            Channel channel = t.getChannel();
            ChatMessage message = t.getMessage();
            if (message == null) {
                message = t.getChannel().getLastMessage();
            }
            com.avito.android.remote.model.messenger.Channel convertChannel = messengerEntityConverter.convertChannel(Channel.copy$default(channel, null, null, message, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null));
            ChatMessage message2 = t.getMessage();
            arrayList.add(new ChannelsSearchInteractor.SearchResults.Result(convertChannel, message2 != null ? message2.getId() : null));
        }
        List<ChannelsSearchInteractor.SearchResults.Result> plus = CollectionsKt___CollectionsKt.plus((Collection) this.b.getResults().getItems(), (Iterable) arrayList);
        ChannelsSearchInteractor.State state = this.b;
        return ChannelsSearchInteractor.State.Loaded.copy$default((ChannelsSearchInteractor.State.Loaded) state, null, null, state.getResults().copy(plus, plus.size() != this.b.getResults().getItems().size() && channelsSearchResponse2.getHasMore()), ChannelsSearchInteractor.State.PaginationState.Idle.INSTANCE, 3, null);
    }
}

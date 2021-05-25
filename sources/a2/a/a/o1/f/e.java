package a2.a.a.o1.f;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import com.avito.android.messenger.search.SearchQuery;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.api.entity.ChannelSearchItem;
import ru.avito.messenger.api.entity.ChannelsSearchResponse;
import ru.avito.messenger.api.entity.ChatMessage;
public final class e<T, R> implements Function<ChannelsSearchResponse, ChannelsSearchInteractor.State> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.e a;
    public final /* synthetic */ ChannelsSearchInteractor.State b;

    public e(ChannelsSearchInteractorImpl.e eVar, ChannelsSearchInteractor.State state) {
        this.a = eVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChannelsSearchInteractor.State apply(ChannelsSearchResponse channelsSearchResponse) {
        ChannelsSearchResponse channelsSearchResponse2 = channelsSearchResponse;
        Intrinsics.checkNotNullParameter(channelsSearchResponse2, "results");
        String currentUserId = this.b.getCurrentUserId();
        SearchQuery searchQuery = this.a.c;
        List<ChannelSearchItem> items = channelsSearchResponse2.getItems();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
        for (T t : items) {
            MessengerEntityConverter messengerEntityConverter = this.a.d.q;
            Channel channel = t.getChannel();
            ChatMessage message = t.getMessage();
            if (message == null) {
                message = t.getChannel().getLastMessage();
            }
            com.avito.android.remote.model.messenger.Channel convertChannel = messengerEntityConverter.convertChannel(Channel.copy$default(channel, null, null, message, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null));
            ChatMessage message2 = t.getMessage();
            arrayList.add(new ChannelsSearchInteractor.SearchResults.Result(convertChannel, message2 != null ? message2.getId() : null));
        }
        return new ChannelsSearchInteractor.State.Loaded(currentUserId, searchQuery, new ChannelsSearchInteractor.SearchResults(arrayList, channelsSearchResponse2.getHasMore()), ChannelsSearchInteractor.State.PaginationState.Idle.INSTANCE);
    }
}

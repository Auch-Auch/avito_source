package a2.a.a.o1.g;

import com.avito.android.preferences.MessengerStorage;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<UnreadMessagesCounter> {
    public final /* synthetic */ MessengerStorage a;

    public d(MessengerStorage messengerStorage) {
        this.a = messengerStorage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UnreadMessagesCounter unreadMessagesCounter) {
        this.a.putUnreadMessagesCount(unreadMessagesCounter.getChannelsCount());
    }
}

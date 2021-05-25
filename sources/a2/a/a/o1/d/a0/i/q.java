package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;
public final /* synthetic */ class q extends MutablePropertyReference0Impl {
    public q(MessageListPresenterImpl messageListPresenterImpl) {
        super(messageListPresenterImpl, MessageListPresenterImpl.class, "listBottomState", "getListBottomState()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Bottom;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return ((MessageListPresenterImpl) this.receiver).s;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
    }
}

package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;
public final /* synthetic */ class o extends MutablePropertyReference0Impl {
    public o(MessageListPresenterImpl messageListPresenterImpl) {
        super(messageListPresenterImpl, MessageListPresenterImpl.class, "listTopState", "getListTopState()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Top;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return ((MessageListPresenterImpl) this.receiver).q;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
    }
}

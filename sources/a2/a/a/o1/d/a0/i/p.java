package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;
public final /* synthetic */ class p extends MutablePropertyReference0Impl {
    public p(MessageListPresenterImpl messageListPresenterImpl) {
        super(messageListPresenterImpl, MessageListPresenterImpl.class, "listMiddleState", "getListMiddleState()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState$List$Middle;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return ((MessageListPresenterImpl) this.receiver).r;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
    }
}

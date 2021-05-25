package a7.a.b.a;

import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ChatMessagesResponse;
public final /* synthetic */ class h extends PropertyReference1Impl {
    public static final KProperty1 a = new h();

    public h() {
        super(ChatMessagesResponse.class, "messages", "getMessages()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return ((ChatMessagesResponse) obj).getMessages();
    }
}

package a7.c.a.a.n.c;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponse;
import ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponseKt;
public final class a<T, R> implements Function<T, R> {
    public static final a a = new a();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        ChatProgressResponse chatProgressResponse = (ChatProgressResponse) obj;
        Intrinsics.checkParameterIsNotNull(chatProgressResponse, "chatProgress");
        return ChatProgressResponseKt.toChatProgressRepo(chatProgressResponse);
    }
}

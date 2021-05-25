package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChatListAdBannerInteractorImpl$logError$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ChatListAdBannerInteractorImpl a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerInteractorImpl$logError$1(ChatListAdBannerInteractorImpl chatListAdBannerInteractorImpl, String str) {
        super(1);
        this.a = chatListAdBannerInteractorImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        String tag = this.a.getTAG();
        Logs.error(tag, this.b + " subscription encountered an error!", th);
    }
}

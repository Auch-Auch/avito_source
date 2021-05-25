package com.avito.android.messenger.conversation.create;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "result", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CreateChannelInteractorImpl$getOrCreateChannelFromDb$1<T, R> implements Function<CreateChannelInteractor.Result, CreateChannelInteractor.Result> {
    public final /* synthetic */ CreateChannelInteractorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChannelActivityArguments.Create c;

    public CreateChannelInteractorImpl$getOrCreateChannelFromDb$1(CreateChannelInteractorImpl createChannelInteractorImpl, String str, ChannelActivityArguments.Create create) {
        this.a = createChannelInteractorImpl;
        this.b = str;
        this.c = create;
    }

    public final CreateChannelInteractor.Result apply(@NotNull CreateChannelInteractor.Result result) {
        T t;
        Intrinsics.checkNotNullParameter(result, "result");
        CreateChannelInteractorImpl createChannelInteractorImpl = this.a;
        String str = this.b;
        String messageDraft = ((ChannelActivityArguments.Create.ByItem) this.c).getMessageDraft();
        if (messageDraft != null && (result instanceof CreateChannelInteractor.Result.Success)) {
            CreateChannelInteractor.Result.Success success = (CreateChannelInteractor.Result.Success) result;
            Option<Channel> blockingFirst = CreateChannelInteractorImpl.access$getChannelRepoReader$p(createChannelInteractorImpl).getChannel(str, success.getChannelId()).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "channel");
            Channel channel = (Channel) OptionKt.getOrElse(blockingFirst, CreateChannelInteractorImpl$replaceDraftIfNeeded$users$1.INSTANCE);
            String str2 = null;
            List<User> users = channel != null ? channel.getUsers() : null;
            DraftRepoWriter access$getDraftRepoWriter$p = CreateChannelInteractorImpl.access$getDraftRepoWriter$p(createChannelInteractorImpl);
            String channelId = success.getChannelId();
            if (users != null) {
                Iterator<T> it = users.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (!Intrinsics.areEqual(t.getId(), str)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    str2 = t2.getId();
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            access$getDraftRepoWriter$p.putDraft(str, channelId, str2, messageDraft).blockingAwait();
        }
        return result;
    }
}

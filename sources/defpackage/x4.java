package defpackage;

import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.messages.LoadFirstPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.LoadPrevPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$2$$special$$inlined$plusAssign$1;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$4$$special$$inlined$plusAssign$1;
import com.avito.android.messenger.conversation.mvi.messages.StartLoadingFirstPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.StartLoadingPrevPageMutator;
import com.avito.android.messenger.conversation.mvi.messages.SyncLatestMessagesAction;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
/* compiled from: kotlin-style lambda group */
/* renamed from: x4  reason: default package */
public final class x4 extends Lambda implements Function2<String, String, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x4(int i, Object obj) {
        super(2);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(String str, String str2) {
        int i = this.a;
        if (i == 0) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str3, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str4, "channelId");
            Relay relay = ((MessageListInteractorImpl.a) this.b).a.getMutatorsRelay();
            StartLoadingFirstPageMutator startLoadingFirstPageMutator = new StartLoadingFirstPageMutator(str3, str4, ((MessageListInteractorImpl.a) this.b).a.c());
            relay.accept(new MutatorSingle(startLoadingFirstPageMutator.getName(), new MessageListInteractorImpl$deps$2$2$$special$$inlined$plusAssign$1(startLoadingFirstPageMutator)));
            return Unit.INSTANCE;
        } else if (i == 1) {
            String str5 = str;
            String str6 = str2;
            Intrinsics.checkNotNullParameter(str5, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str6, "channelId");
            ((MessageListInteractorImpl.a) this.b).a.getMutatorsRelay().accept(new LoadFirstPageMutator(str5, str6, ((MessageListInteractorImpl.a) this.b).a.n, ((MessageListInteractorImpl.a) this.b).a.c()));
            return Unit.INSTANCE;
        } else if (i == 2) {
            String str7 = str;
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str7, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str8, "channelId");
            Relay relay2 = ((MessageListInteractorImpl.a) this.b).a.getMutatorsRelay();
            StartLoadingPrevPageMutator startLoadingPrevPageMutator = new StartLoadingPrevPageMutator(str7, str8, ((MessageListInteractorImpl.a) this.b).a.c());
            relay2.accept(new MutatorSingle(startLoadingPrevPageMutator.getName(), new MessageListInteractorImpl$deps$2$4$$special$$inlined$plusAssign$1(startLoadingPrevPageMutator)));
            return Unit.INSTANCE;
        } else if (i == 3) {
            String str9 = str;
            String str10 = str2;
            Intrinsics.checkNotNullParameter(str9, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str10, "channelId");
            ((MessageListInteractorImpl.a) this.b).a.getMutatorsRelay().accept(new LoadPrevPageMutator(str9, str10, ((MessageListInteractorImpl.a) this.b).a.c()));
            return Unit.INSTANCE;
        } else if (i == 4) {
            String str11 = str;
            String str12 = str2;
            Intrinsics.checkNotNullParameter(str11, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str12, "channelId");
            Relay relay3 = ((MessageListInteractorImpl.a) this.b).a.getMutatorsRelay();
            SyncLatestMessagesAction syncLatestMessagesAction = new SyncLatestMessagesAction(str11, str12, ((MessageListInteractorImpl.a) this.b).a.c());
            relay3.accept(new MutatorSingle(syncLatestMessagesAction.getName(), new Function1<MessageListInteractor.State, Single<MessageListInteractor.State>>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$6$$special$$inlined$plusAssign$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Single<MessageListInteractor.State> invoke(@NotNull final MessageListInteractor.State state) {
                    Intrinsics.checkNotNullParameter(state, "oldState");
                    Single<MessageListInteractor.State> onErrorReturn = ((Single) ActionSingle.this.getBlock().invoke(state)).map(new Function<Object, MessageListInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$6$$special$$inlined$plusAssign$1.1
                        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$State] */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        @Override // io.reactivex.functions.Function
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "it"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                java.lang.Object r2 = r3
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$6$$special$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
                        }
                    }).onErrorReturn(new Function<Throwable, MessageListInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$6$$special$$inlined$plusAssign$1.2
                        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor$State] */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "it"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                java.lang.Object r2 = r3
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$deps$2$6$$special$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
                    return onErrorReturn;
                }
            }));
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

package com.avito.android.messenger.conversation.mvi.send;

import a2.g.r.g;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler;
import com.avito.android.messenger.di.ChannelId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BV\b\u0007\u0012\b\b\u0001\u0010?\u001a\u00020\u0002\u0012\u0011\u0010E\u001a\r\u0012\t\u0012\u00070A¢\u0006\u0002\bB0@\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\bJ\u0010KJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ;\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u0010J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\t\u0010\u0015J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\t\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0017¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00108\u001a\b\u0012\u0004\u0012\u000203028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R!\u0010E\u001a\r\u0012\t\u0012\u00070A¢\u0006\u0002\bB0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "", "currentUserId", "text", "", "templates", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "createMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "createMessages", "createReactionMessage", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "(Ljava/lang/String;Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "file", "Landroid/net/Uri;", "contentUri", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;Landroid/net/Uri;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "location", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Lio/reactivex/Single;", "operationId", "createImageMessages", "userIds", "Lio/reactivex/Completable;", "sendTypingEvent", "(Ljava/util/List;)Lio/reactivex/Completable;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "convertTextToMessageBodies", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/messenger/TextToChunkConverter;", "d", "Lcom/avito/android/messenger/TextToChunkConverter;", "textToChunkConverter", "Lcom/avito/android/server_time/TimeSource;", g.a, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "h", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "repo", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/jakewharton/rxrelay2/Relay;", "", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "getMessageSendAttemptsStream", "()Lcom/jakewharton/rxrelay2/Relay;", "messageSendAttemptsStream", "Lcom/avito/android/messenger/MessageLocalIdGenerator;", "f", "Lcom/avito/android/messenger/MessageLocalIdGenerator;", "localIdGenerator", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "channelId", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "c", "Lru/avito/messenger/MessengerClient;", "messenger", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "e", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "photoPickerResultHandler", "<init>", "(Ljava/lang/String;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/TextToChunkConverter;Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;Lcom/avito/android/messenger/MessageLocalIdGenerator;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendMessageInteractorImpl implements SendMessageInteractor {
    @NotNull
    public final Relay<Unit> a = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final String b;
    public final MessengerClient<AvitoMessengerApi> c;
    public final TextToChunkConverter d;
    public final PhotoPickerResultHandler e;
    public final MessageLocalIdGenerator f;
    public final TimeSource g;
    public final MessageRepo h;
    public final SchedulersFactory i;

    public static final class a<T, R> implements Function<List<? extends PhotoPickerResultHandler.Photo>, ObservableSource<? extends PhotoPickerResultHandler.Photo>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PhotoPickerResultHandler.Photo> apply(List<? extends PhotoPickerResultHandler.Photo> list) {
            List<? extends PhotoPickerResultHandler.Photo> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "photos");
            return Observable.fromIterable(list2);
        }
    }

    public static final class b<T, R> implements Function<PhotoPickerResultHandler.Photo, SingleSource<? extends LocalMessage>> {
        public final /* synthetic */ SendMessageInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(SendMessageInteractorImpl sendMessageInteractorImpl, String str, String str2) {
            this.a = sendMessageInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends LocalMessage> apply(PhotoPickerResultHandler.Photo photo) {
            PhotoPickerResultHandler.Photo photo2 = photo;
            Intrinsics.checkNotNullParameter(photo2, "photo");
            return SendMessageInteractorImpl.a(this.a, new MessageBody.LocalImage(photo2.getUri(), this.b, photo2.getUploadId()), this.c, 0, null, null, false, false, null, null, 508);
        }
    }

    public static final class c extends Lambda implements Function1<LocalMessage, Completable> {
        public final /* synthetic */ SendMessageInteractorImpl a;
        public final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SendMessageInteractorImpl sendMessageInteractorImpl, Uri uri) {
            super(1);
            this.a = sendMessageInteractorImpl;
            this.b = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Completable invoke(LocalMessage localMessage) {
            LocalMessage localMessage2 = localMessage;
            Intrinsics.checkNotNullParameter(localMessage2, "localMessage");
            MessageRepo messageRepo = this.a.h;
            String uri = this.b.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "contentUri.toString()");
            return messageRepo.createFileMessage(localMessage2, uri);
        }
    }

    public static final class d<T, R> implements Function<MessageBody, SingleSource<? extends LocalMessage>> {
        public final /* synthetic */ SendMessageInteractorImpl a;
        public final /* synthetic */ String b;

        public d(SendMessageInteractorImpl sendMessageInteractorImpl, String str) {
            this.a = sendMessageInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends LocalMessage> apply(MessageBody messageBody) {
            MessageBody messageBody2 = messageBody;
            Intrinsics.checkNotNullParameter(messageBody2, "messageBody");
            return SendMessageInteractorImpl.a(this.a, messageBody2, this.b, 0, null, null, false, false, null, null, 508);
        }
    }

    public static final class e<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Unit>> {
        public final /* synthetic */ SendMessageInteractorImpl a;
        public final /* synthetic */ List b;

        public e(SendMessageInteractorImpl sendMessageInteractorImpl, List list) {
            this.a = sendMessageInteractorImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            String str = this.a.b;
            List<T> list = this.b;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(Long.valueOf(Long.parseLong(t)));
            }
            return avitoMessengerApi2.sendTyping(str, arrayList).subscribeOn(this.a.i.io());
        }
    }

    @Inject
    public SendMessageInteractorImpl(@ChannelId @NotNull String str, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull TextToChunkConverter textToChunkConverter, @NotNull PhotoPickerResultHandler photoPickerResultHandler, @NotNull MessageLocalIdGenerator messageLocalIdGenerator, @NotNull TimeSource timeSource, @NotNull MessageRepo messageRepo, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(messengerClient, "messenger");
        Intrinsics.checkNotNullParameter(textToChunkConverter, "textToChunkConverter");
        Intrinsics.checkNotNullParameter(photoPickerResultHandler, "photoPickerResultHandler");
        Intrinsics.checkNotNullParameter(messageLocalIdGenerator, "localIdGenerator");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = str;
        this.c = messengerClient;
        this.d = textToChunkConverter;
        this.e = photoPickerResultHandler;
        this.f = messageLocalIdGenerator;
        this.g = timeSource;
        this.h = messageRepo;
        this.i = schedulersFactory;
    }

    public static Single a(SendMessageInteractorImpl sendMessageInteractorImpl, MessageBody messageBody, String str, long j, String str2, String str3, boolean z, boolean z2, Long l, Function1 function1, int i2) {
        long fromMillis = (i2 & 4) != 0 ? MessengerTimestamp.fromMillis(sendMessageInteractorImpl.g.now()) : j;
        String nextLocalId = (i2 & 8) != 0 ? sendMessageInteractorImpl.f.nextLocalId() : null;
        int i3 = i2 & 16;
        boolean z3 = (i2 & 32) != 0 ? true : z;
        boolean z4 = (i2 & 64) != 0 ? false : z2;
        int i4 = i2 & 128;
        Function1 bVar = (i2 & 256) != 0 ? new Function1<LocalMessage, Completable>(sendMessageInteractorImpl.h) { // from class: a2.a.a.o1.d.a0.m.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Completable invoke(LocalMessage localMessage) {
                LocalMessage localMessage2 = localMessage;
                Intrinsics.checkNotNullParameter(localMessage2, "p1");
                return ((MessageRepo) this.receiver).createMessage(localMessage2);
            }
        } : function1;
        Objects.requireNonNull(sendMessageInteractorImpl);
        LocalMessage localMessage = new LocalMessage(nextLocalId, null, sendMessageInteractorImpl.b, messageBody, str, str, fromMillis, z3, z4, null, null, false, null, 7168, null);
        Single andThen = ((Completable) bVar.invoke(localMessage)).subscribeOn(sendMessageInteractorImpl.i.io()).observeOn(sendMessageInteractorImpl.i.computation()).andThen(Single.just(localMessage));
        Intrinsics.checkNotNullExpressionValue(andThen, "messageFactory(message)\n…hen(Single.just(message))");
        return andThen;
    }

    public static final boolean access$typeEquals(SendMessageInteractorImpl sendMessageInteractorImpl, MessageBody.Text.Chunk chunk, MessageBody.Text.Chunk chunk2) {
        Objects.requireNonNull(sendMessageInteractorImpl);
        return ((chunk instanceof MessageBody.Text.Chunk.Plain) && (chunk2 instanceof MessageBody.Text.Chunk.Plain)) || ((chunk instanceof MessageBody.Text.Chunk.Link) && (chunk2 instanceof MessageBody.Text.Chunk.Link));
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @VisibleForTesting(otherwise = 2)
    @NotNull
    public List<MessageBody> convertTextToMessageBodies(@NotNull String str, @Nullable List<String> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "text");
        ArrayList arrayList = new ArrayList();
        List<MessageBody.Text.Chunk> convertToTextChunks = this.d.convertToTextChunks(str);
        boolean z = false;
        if (!(convertToTextChunks.size() == 1 && (convertToTextChunks.get(0) instanceof MessageBody.Text.Chunk.Link))) {
            if (convertToTextChunks.size() >= 2 && (!(convertToTextChunks.get(0) instanceof MessageBody.Text.Chunk.Plain) || !(a2.b.a.a.a.j2(convertToTextChunks, 1) instanceof MessageBody.Text.Chunk.Plain))) {
                MessageBody.Text.Chunk chunk = convertToTextChunks.get(0);
                int size = convertToTextChunks.size();
                int i2 = 1;
                int i3 = 0;
                boolean z2 = false;
                while (true) {
                    if (i2 < size) {
                        MessageBody.Text.Chunk chunk2 = convertToTextChunks.get(i2);
                        boolean z3 = chunk2 instanceof MessageBody.Text.Chunk.Plain;
                        if (z3) {
                            i3++;
                        }
                        if (!((z3 && (chunk instanceof MessageBody.Text.Chunk.Plain)) || ((chunk2 instanceof MessageBody.Text.Chunk.Link) && (chunk instanceof MessageBody.Text.Chunk.Link)))) {
                            z2 = true;
                        } else if (z2) {
                            break;
                        }
                        i2++;
                    } else if (i3 != convertToTextChunks.size()) {
                        z = true;
                    }
                }
            }
            if (!z) {
                arrayList.add(new MessageBody.Text.Regular(str, list, convertToTextChunks, false, 8, null));
                return arrayList;
            }
        }
        for (T t : convertToTextChunks) {
            if (t instanceof MessageBody.Text.Chunk.Plain) {
                T t2 = t;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(t2.getStart(), t2.getEnd() + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                obj = new MessageBody.Text.Regular(substring, list, null, false, 8, null);
            } else if (t instanceof MessageBody.Text.Chunk.Link) {
                T t3 = t;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring2 = str.substring(t3.getStart(), t3.getEnd() + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                obj = new MessageBody.Link(substring2, null, null, false, 8, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<List<LocalMessage>> createImageMessages(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(str2, "operationId");
        Single<List<R>> list = this.e.handlePhotoPickerResult(str2).flatMapObservable(a.a).flatMapSingle(new b(this, str2, str)).toList();
        Intrinsics.checkNotNullExpressionValue(list, "photoPickerResultHandler…  }\n            .toList()");
        return list;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<LocalMessage> createMessage(@NotNull String str, @NotNull String str2, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Single<LocalMessage> doAfterSuccess = a2.b.a.a.a.V1(this.i, a(this, new MessageBody.Text.Regular(str2, list, null, false, 12, null), str, 0, null, null, false, false, null, null, 508), "createLocalOutgoingMessa…scribeOn(schedulers.io())").doAfterSuccess(new SendMessageInteractorImpl$onMessageAdded$1(this));
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return doAfterSuccess;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<List<LocalMessage>> createMessages(@NotNull String str, @NotNull String str2, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Single list2 = Observables.toObservable(convertTextToMessageBodies(str2, list)).concatMapSingle(new d(this, str)).toList();
        Intrinsics.checkNotNullExpressionValue(list2, "convertTextToMessageBodi…  }\n            .toList()");
        Single doAfterSuccess = list2.doAfterSuccess(new Consumer<List<? extends LocalMessage>>() { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessageInteractorImpl$onMessagesAdded$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(List<? extends LocalMessage> list3) {
                accept((List<LocalMessage>) list3);
            }

            public final void accept(List<LocalMessage> list3) {
                SendMessageInteractorImpl.this.getMessageSendAttemptsStream().accept(Unit.INSTANCE);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return a2.b.a.a.a.V1(this.i, doAfterSuccess, "convertTextToMessageBodi…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<LocalMessage> createReactionMessage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Single<LocalMessage> doAfterSuccess = a2.b.a.a.a.V1(this.i, a(this, new MessageBody.Text.Reaction(str2, null, null, 6, null), str, 0, null, null, false, false, null, null, 508), "createLocalOutgoingMessa…scribeOn(schedulers.io())").doAfterSuccess(new SendMessageInteractorImpl$onMessageAdded$1(this));
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return doAfterSuccess;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Completable sendTypingEvent(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "userIds");
        Completable onErrorComplete = this.c.withMessengerApi().flatMap(new e(this, list)).ignoreElement().onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "messenger.withMessengerA…       .onErrorComplete()");
        return onErrorComplete;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Relay<Unit> getMessageSendAttemptsStream() {
        return this.a;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<LocalMessage> createMessage(@NotNull String str, @NotNull FeedbackAdvertItem feedbackAdvertItem) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(feedbackAdvertItem, "item");
        String stringId = feedbackAdvertItem.getStringId();
        String title = feedbackAdvertItem.getTitle();
        List<Image> images = feedbackAdvertItem.getImages();
        Single<LocalMessage> doAfterSuccess = a2.b.a.a.a.V1(this.i, a(this, new MessageBody.Item(stringId, str, title, images != null ? (Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) images) : null, feedbackAdvertItem.getPrice(), feedbackAdvertItem.getLocationName()), str, 0, null, null, false, false, null, null, 508), "createLocalOutgoingMessa…scribeOn(schedulers.io())").doAfterSuccess(new SendMessageInteractorImpl$onMessageAdded$1(this));
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return doAfterSuccess;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<LocalMessage> createMessage(@NotNull String str, @NotNull MessageBody.File file, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Single<LocalMessage> doAfterSuccess = a2.b.a.a.a.V1(this.i, a(this, file, str, 0, null, null, false, false, null, new c(this, uri), 252), "createLocalOutgoingMessa…scribeOn(schedulers.io())").doAfterSuccess(new SendMessageInteractorImpl$onMessageAdded$1(this));
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return doAfterSuccess;
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor
    @NotNull
    public Single<LocalMessage> createMessage(@NotNull String str, @NotNull MessageBody.Location location) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(location, "location");
        Single<LocalMessage> doAfterSuccess = a2.b.a.a.a.V1(this.i, a(this, location, str, 0, null, null, false, false, null, null, 508), "createLocalOutgoingMessa…scribeOn(schedulers.io())").doAfterSuccess(new SendMessageInteractorImpl$onMessageAdded$1(this));
        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "doAfterSuccess { message…dAttemptsStream += Unit }");
        return doAfterSuccess;
    }
}

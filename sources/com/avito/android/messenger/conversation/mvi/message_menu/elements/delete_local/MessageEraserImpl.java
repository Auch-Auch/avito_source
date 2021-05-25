package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local;

import a2.a.a.o1.d.a0.h.e.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraserImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lio/reactivex/Single;", "", "deleteLocalMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "e", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "fileUploadCanceller", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "c", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "photoStorage", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "repo", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageEraserImpl implements MessageEraser {
    public final MessageRepo a;
    public final PhotoInteractor b;
    public final MessengerPhotoStorage c;
    public final SchedulersFactory d;
    public final MessengerFileUploadCanceller e;

    @Inject
    public MessageEraserImpl(@NotNull MessageRepo messageRepo, @NotNull PhotoInteractor photoInteractor, @NotNull MessengerPhotoStorage messengerPhotoStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull MessengerFileUploadCanceller messengerFileUploadCanceller) {
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(messengerPhotoStorage, "photoStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerFileUploadCanceller, "fileUploadCanceller");
        this.a = messageRepo;
        this.b = photoInteractor;
        this.c = messengerPhotoStorage;
        this.d = schedulersFactory;
        this.e = messengerFileUploadCanceller;
    }

    public static final Completable access$deleteMessage(MessageEraserImpl messageEraserImpl, LocalMessage localMessage) {
        Objects.requireNonNull(messageEraserImpl);
        Completable andThen = messageEraserImpl.a.deleteMessageAndMetaInfo(localMessage.userId, localMessage.channelId, localMessage.localId).subscribeOn(messageEraserImpl.d.io()).observeOn(messageEraserImpl.d.io()).andThen(Completable.fromAction(new a(messageEraserImpl, localMessage.body, localMessage)));
        Intrinsics.checkNotNullExpressionValue(andThen, "repo.deleteMessageAndMet…          }\n            )");
        return andThen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser
    @NotNull
    public Single<Boolean> deleteLocalMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str3, "localId");
        Observable<Option<LocalMessage>> observeOn = this.a.getMessage(str, str2, str3).subscribeOn(this.d.io()).observeOn(this.d.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "repo.getMessage(\n       …schedulers.computation())");
        Single<Option<LocalMessage>> onErrorReturn = observeOn.firstOrError().onErrorReturn(MessageEraserImpl$deleteLocalMessage$$inlined$firstOrNone$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
        Single<R> flatMap = onErrorReturn.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(this) { // from class: com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraserImpl$deleteLocalMessage$$inlined$flatMapFold$1
            public final /* synthetic */ MessageEraserImpl a;

            {
                this.a = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: io.reactivex.Completable */
            /* JADX WARN: Multi-variable type inference failed */
            public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option) {
                Intrinsics.checkNotNullParameter(option, "it");
                if (option instanceof None) {
                    return Singles.toSingle(Boolean.FALSE);
                }
                if (option instanceof Some) {
                    LocalMessage localMessage = (LocalMessage) ((Some) option).getT();
                    if (localMessage.remoteId != null) {
                        return Singles.toSingle(Boolean.FALSE);
                    }
                    Single singleDefault = MessageEraserImpl.access$deleteMessage(this.a, localMessage).toSingleDefault(Boolean.TRUE);
                    Intrinsics.checkNotNullExpressionValue(singleDefault, "deleteMessage(message).toSingleDefault(true)");
                    return singleDefault;
                }
                throw new NoWhenBranchMatchedException();
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
        return flatMap;
    }
}

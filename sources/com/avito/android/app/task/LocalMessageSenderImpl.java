package com.avito.android.app.task;

import a2.a.a.j.a.h;
import a2.a.a.j.a.i;
import a2.a.a.j.a.j;
import a2.a.a.j.a.k;
import a2.a.a.j.a.l;
import a2.a.a.j.a.m;
import a2.a.a.j.a.o;
import a2.a.a.j.a.p;
import a2.g.r.g;
import android.net.Uri;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.Features;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.service.ImageUploadStarter;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.ErrorType;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerSender;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BW\u0012\u0006\u00100\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/app/task/LocalMessageSenderImpl;", "Lcom/avito/android/app/task/LocalMessageSender;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lio/reactivex/Single;", "sendMessage", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lio/reactivex/Single;", "", "operationId", "", "uploadId", "Lio/reactivex/Scheduler;", "scheduler", "Lio/reactivex/Observable;", "Larrow/core/Option;", "Lcom/avito/android/photo_picker/PhotoUpload;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;JLio/reactivex/Scheduler;)Lio/reactivex/Observable;", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/service/ImageUploadStarter;", "c", "Lcom/avito/android/messenger/service/ImageUploadStarter;", "imageUploadStarter", "Lcom/avito/android/messenger/MessengerEntityConverter;", "f", "Lcom/avito/android/messenger/MessengerEntityConverter;", "converter", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", g.a, "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "bodyResolver", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "e", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "photoStorage", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "fileUploadInteractor", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "j", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "canceller", "Lru/avito/messenger/MessengerSender;", "Lru/avito/messenger/MessengerSender;", "sender", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "d", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "<init>", "(Lru/avito/messenger/MessengerSender;Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;Lcom/avito/android/messenger/service/ImageUploadStarter;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocalMessageSenderImpl implements LocalMessageSender {
    public final MessengerSender a;
    public final FileUploadInteractor b;
    public final ImageUploadStarter c;
    public final PhotoInteractor d;
    public final MessengerPhotoStorage e;
    public final MessengerEntityConverter f;
    public final MessageBodyResolver g;
    public final SchedulersFactory h;
    public final Features i;
    public final MessengerFileUploadCanceller j;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, Option<? extends PhotoUpload>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "it");
            return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) CloseableDatasourcesKt.readAllAndClose(closeableDataSource2)));
        }
    }

    public LocalMessageSenderImpl(@NotNull MessengerSender messengerSender, @NotNull FileUploadInteractor fileUploadInteractor, @NotNull ImageUploadStarter imageUploadStarter, @NotNull PhotoInteractor photoInteractor, @NotNull MessengerPhotoStorage messengerPhotoStorage, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull MessageBodyResolver messageBodyResolver, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull MessengerFileUploadCanceller messengerFileUploadCanceller) {
        Intrinsics.checkNotNullParameter(messengerSender, "sender");
        Intrinsics.checkNotNullParameter(fileUploadInteractor, "fileUploadInteractor");
        Intrinsics.checkNotNullParameter(imageUploadStarter, "imageUploadStarter");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(messengerPhotoStorage, "photoStorage");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "converter");
        Intrinsics.checkNotNullParameter(messageBodyResolver, "bodyResolver");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(messengerFileUploadCanceller, "canceller");
        this.a = messengerSender;
        this.b = fileUploadInteractor;
        this.c = imageUploadStarter;
        this.d = photoInteractor;
        this.e = messengerPhotoStorage;
        this.f = messengerEntityConverter;
        this.g = messageBodyResolver;
        this.h = schedulersFactory;
        this.i = features;
        this.j = messengerFileUploadCanceller;
    }

    public static final void access$deletePhotoUpload(LocalMessageSenderImpl localMessageSenderImpl, PhotoUpload photoUpload) {
        Objects.requireNonNull(localMessageSenderImpl);
        try {
            localMessageSenderImpl.d.delete(String.valueOf(photoUpload.getId()));
            Uri contentUri = photoUpload.getContentUri();
            if (contentUri != null) {
                localMessageSenderImpl.e.delete(contentUri);
            }
        } catch (Throwable unused) {
            StringBuilder L = a2.b.a.a.a.L("Failed to delete data for upload: (");
            L.append(photoUpload.getId());
            L.append(", ");
            L.append(photoUpload.getContentUri());
            L.append(") ");
            Logs.error$default(L.toString(), null, 2, null);
        }
    }

    public static final boolean access$getDoesNotExist$p(LocalMessageSenderImpl localMessageSenderImpl, PhotoUpload photoUpload) {
        Objects.requireNonNull(localMessageSenderImpl);
        Uri contentUri = photoUpload.getContentUri();
        if (contentUri != null) {
            return true ^ localMessageSenderImpl.e.exists(contentUri);
        }
        return true;
    }

    public static final boolean access$isCompletedOrFailed$p(LocalMessageSenderImpl localMessageSenderImpl, PhotoUpload photoUpload) {
        Objects.requireNonNull(localMessageSenderImpl);
        return photoUpload.getUploadId() != null || !(photoUpload.getError() instanceof ErrorType.NoError);
    }

    public static final Single access$uploadAndSendMessage(LocalMessageSenderImpl localMessageSenderImpl, String str, String str2, String str3, PhotoUpload photoUpload, Scheduler scheduler) {
        Objects.requireNonNull(localMessageSenderImpl);
        Completable fromCallable = Completable.fromCallable(new Callable<Object>(photoUpload, str3) { // from class: com.avito.android.app.task.LocalMessageSenderImpl$resetPhotoUpload$1
            public final /* synthetic */ PhotoUpload b;
            public final /* synthetic */ String c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                if (LocalMessageSenderImpl.access$isCompletedOrFailed$p(LocalMessageSenderImpl.this, this.b)) {
                    LocalMessageSenderImpl.this.d.update(this.c, this.b.newBuilder().error(ErrorType.NoError.INSTANCE).uploadId(null).build());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…)\n            }\n        }");
        Completable fromCallable2 = Completable.fromCallable(new Callable<Object>(str3, photoUpload.getId()) { // from class: com.avito.android.app.task.LocalMessageSenderImpl$startPhotoUpload$1
            public final /* synthetic */ String b;
            public final /* synthetic */ long c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                LocalMessageSenderImpl.this.c.startImageUpload(this.b, Long.valueOf(this.c), false);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "Completable.fromCallable…eError = false)\n        }");
        Single flatMap = fromCallable.andThen(fromCallable2).andThen(com.avito.android.util.rx.arrow.OptionKt.filterDefined(localMessageSenderImpl.a(str3, photoUpload.getId(), scheduler)).filter(new l(localMessageSenderImpl)).firstOrError()).onErrorResumeNext(new m(str3, photoUpload)).flatMap(new o(localMessageSenderImpl, str, str2, scheduler, photoUpload, str3));
        Intrinsics.checkNotNullExpressionValue(flatMap, "resetPhotoUpload(operati…          }\n            }");
        return flatMap;
    }

    public final Observable<Option<PhotoUpload>> a(String str, long j2, Scheduler scheduler) {
        Observable<R> map = this.d.select(str, j2).subscribeOn(scheduler).observeOn(scheduler).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "photoInteractor.select(o…irstOrNull().toOption() }");
        return map;
    }

    @Override // com.avito.android.app.task.LocalMessageSender
    @NotNull
    public Single<LocalMessage> sendMessage(@NotNull LocalMessage localMessage) {
        Single<ChatMessage> single;
        long j2;
        Intrinsics.checkNotNullParameter(localMessage, "message");
        Scheduler io2 = this.h.io();
        MessageBody messageBody = localMessage.body;
        if (messageBody instanceof MessageBody.Text.Regular) {
            MessengerSender messengerSender = this.a;
            String str = localMessage.channelId;
            String str2 = localMessage.localId;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
            String text = ((MessageBody.Text.Regular) messageBody).getText();
            MessageBody messageBody2 = localMessage.body;
            Objects.requireNonNull(messageBody2, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
            single = messengerSender.sendTextMessage(str, str2, text, ((MessageBody.Text.Regular) messageBody2).getSuggestedTemplates());
        } else if (messageBody instanceof MessageBody.Text.Reaction) {
            MessengerSender messengerSender2 = this.a;
            String str3 = localMessage.channelId;
            String str4 = localMessage.localId;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Reaction");
            single = messengerSender2.sendReactionMessage(str3, str4, ((MessageBody.Text.Reaction) messageBody).getText());
        } else if (messageBody instanceof MessageBody.Item) {
            MessengerSender messengerSender3 = this.a;
            String str5 = localMessage.channelId;
            String str6 = localMessage.localId;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Item");
            single = messengerSender3.sendItemMessage(str5, str6, ((MessageBody.Item) messageBody).getId());
        } else if (messageBody instanceof MessageBody.Link) {
            MessengerSender messengerSender4 = this.a;
            String str7 = localMessage.channelId;
            String str8 = localMessage.localId;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Link");
            single = messengerSender4.sendLinkMessage(str7, str8, ((MessageBody.Link) messageBody).getUrl());
        } else if (messageBody instanceof MessageBody.Location) {
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Location");
            MessageBody.Location location = (MessageBody.Location) messageBody;
            single = this.a.sendLocationMessage(localMessage.channelId, localMessage.localId, location.getLatitude(), location.getLongitude(), location.getTitle(), location.getKind());
        } else if (messageBody instanceof MessageBody.LocalImage) {
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.LocalImage");
            MessageBody.LocalImage localImage = (MessageBody.LocalImage) messageBody;
            single = a(localImage.getOperationId(), localImage.getUploadId(), io2).debounce(500, TimeUnit.MILLISECONDS, this.h.computation()).observeOn(io2).firstOrError().onErrorResumeNext(new h(localImage)).flatMap(new i(this, localImage, localMessage, io2));
            Intrinsics.checkNotNullExpressionValue(single, "getPhotoUpload(body.oper…  )\n                    }");
        } else if (messageBody instanceof MessageBody.File) {
            if (this.i.getMessengerDynamicAttachMenu().invoke().booleanValue()) {
                FileUploadInteractor fileUploadInteractor = this.b;
                String str9 = localMessage.userId;
                String str10 = localMessage.channelId;
                String str11 = localMessage.localId;
                MessageBody messageBody3 = localMessage.body;
                Objects.requireNonNull(messageBody3, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.File");
                single = InteropKt.toV2(fileUploadInteractor.uploadFile(str9, str10, str11, (MessageBody.File) messageBody3)).flatMap(new j(this, localMessage)).onErrorResumeNext(new k(localMessage));
            } else {
                StringBuilder L = a2.b.a.a.a.L("File message ignored since feature is disabled: bodyClass=");
                L.append(localMessage.body.getClass().getName());
                single = Single.error(new NoRetryException(L.toString(), null, 2, null));
            }
            Intrinsics.checkNotNullExpressionValue(single, "if (features.messengerDy…ame}\"))\n                }");
        } else if (!(messageBody instanceof MessageBody.ItemReference) && !(messageBody instanceof MessageBody.ImageReference) && !(messageBody instanceof MessageBody.ImageBody) && !(messageBody instanceof MessageBody.Call) && !(messageBody instanceof MessageBody.Deleted) && !(messageBody instanceof MessageBody.AppCall) && !(messageBody instanceof MessageBody.Unknown) && !(messageBody instanceof MessageBody.SystemMessageBody)) {
            throw new NoWhenBranchMatchedException();
        } else {
            StringBuilder L2 = a2.b.a.a.a.L("Message ignored: bodyClass=");
            L2.append(localMessage.body.getClass().getName());
            single = Single.error(new NoRetryException(L2.toString(), null, 2, null));
            Intrinsics.checkNotNullExpressionValue(single, "Single.error(NoRetryExce…e.body.javaClass.name}\"))");
        }
        Single<ChatMessage> subscribeOn = single.subscribeOn(this.h.io());
        MessageBody messageBody4 = localMessage.body;
        if (messageBody4 instanceof MessageBody.LocalImage) {
            j2 = 65000;
        } else {
            j2 = messageBody4 instanceof MessageBody.File ? 1200000 : 30000;
        }
        Single<ChatMessage> observeOn = subscribeOn.timeout(j2, TimeUnit.MILLISECONDS, this.h.computation()).observeOn(this.h.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "sendMessageInternal(mess…schedulers.computation())");
        Single<ChatMessage> onErrorResumeNext = observeOn.onErrorResumeNext(new a2.a.a.j.a.g(this, localMessage));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "onErrorResumeNext {\n    …   Single.error(ex)\n    }");
        Single<LocalMessage> flatMap = onErrorResumeNext.map(new p(new Function1<ChatMessage, LocalMessage>(this.f) { // from class: com.avito.android.app.task.LocalMessageSenderImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public LocalMessage invoke(ChatMessage chatMessage) {
                ChatMessage chatMessage2 = chatMessage;
                Intrinsics.checkNotNullParameter(chatMessage2, "p1");
                return ((MessengerEntityConverter) this.receiver).convertMessage(chatMessage2);
            }
        })).flatMap(new p(new Function1<LocalMessage, Single<LocalMessage>>(this.g) { // from class: com.avito.android.app.task.LocalMessageSenderImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Single<LocalMessage> invoke(LocalMessage localMessage2) {
                LocalMessage localMessage3 = localMessage2;
                Intrinsics.checkNotNullParameter(localMessage3, "p1");
                return ((MessageBodyResolver) this.receiver).resolveMessageBody(localMessage3);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(flatMap, "sendMessageInternal(mess…lver::resolveMessageBody)");
        return flatMap;
    }
}

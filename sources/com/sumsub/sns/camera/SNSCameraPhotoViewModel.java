package com.sumsub.sns.camera;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.domain.AddDirectFileToCacheUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.vk.sdk.api.VKApiConst;
import java.io.File;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.q.e;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001f\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u001d8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraPhotoViewModel;", "Lcom/sumsub/sns/camera/SNSCameraViewModel;", "", "data", "", "onPictureTaken", "([B)V", "onGalleryClicked", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Ljava/io/File;", "tempFile", "onGalleryImagePicked", "(Landroid/net/Uri;Ljava/io/File;)V", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "", "u", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showGalleryActionLiveData", "Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;", VKApiConst.VERSION, "Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;", "addDirectFileToCacheUseCase", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "w", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "Landroidx/lifecycle/LiveData;", "getShowGallery", "()Landroidx/lifecycle/LiveData;", "showGallery", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "", "identityType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;)V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSCameraPhotoViewModel extends SNSCameraViewModel {
    public final ActionLiveData<Event<Object>> u;
    public final AddDirectFileToCacheUseCase v;
    public final SendLogUseCase w;

    @DebugMetadata(c = "com.sumsub.sns.camera.SNSCameraPhotoViewModel$onGalleryImagePicked$1", f = "SNSCameraPhotoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ SNSCameraPhotoViewModel b;
        public final /* synthetic */ Uri c;
        public final /* synthetic */ File d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSCameraPhotoViewModel sNSCameraPhotoViewModel, Uri uri, File file, Continuation continuation) {
            super(2, continuation);
            this.b = sNSCameraPhotoViewModel;
            this.c = uri;
            this.d = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.b, this.c, this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.b, this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            Uri uri = this.c;
            String path = uri != null ? uri.getPath() : null;
            if (path == null || path.length() == 0) {
                return Unit.INSTANCE;
            }
            try {
                Uri uri2 = this.c;
                Intrinsics.checkNotNull(uri2);
                String path2 = uri2.getPath();
                Intrinsics.checkNotNull(path2);
                e.copyTo$default(new File(path2), this.d, true, 0, 4, null);
                SNSCameraPhotoViewModel sNSCameraPhotoViewModel = this.b;
                File file = this.d;
                sNSCameraPhotoViewModel.finishWithResult(new DocumentPickerResult(file, file, null, null, this.b.getSide(), 12, null));
            } catch (Exception e) {
                Timber.e(e);
                SNSCameraPhotoViewModel.access$sendLog(this.b, "Can't copy gallery file", e);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.camera.SNSCameraPhotoViewModel$onPictureTaken$1", f = "SNSCameraPhotoViewModel.kt", i = {2}, l = {42, 50, 56}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object b;
        public int c;
        public final /* synthetic */ SNSCameraPhotoViewModel d;
        public final /* synthetic */ byte[] e;

        @DebugMetadata(c = "com.sumsub.sns.camera.SNSCameraPhotoViewModel$onPictureTaken$1$1", f = "SNSCameraPhotoViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Exception, ? extends Object>>, Object> {
            public int b;
            public final /* synthetic */ b c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, Continuation continuation) {
                super(2, continuation);
                this.c = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new a(this.c, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Exception, ? extends Object>> continuation) {
                Continuation<? super Either<? extends Exception, ? extends Object>> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                return new a(this.c, continuation2).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SendLogUseCase sendLogUseCase = this.c.d.w;
                    SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Error, new IllegalArgumentException("An image byte arrays is empty..."), null, 4, null);
                    this.b = 1;
                    obj = sendLogUseCase.run(params, (Continuation<? super Either<? extends Exception, ? extends Object>>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        @DebugMetadata(c = "com.sumsub.sns.camera.SNSCameraPhotoViewModel$onPictureTaken$1$2", f = "SNSCameraPhotoViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.sumsub.sns.camera.SNSCameraPhotoViewModel$b$b  reason: collision with other inner class name */
        public static final class C0315b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Exception, ? extends Object>>, Object> {
            public int b;
            public final /* synthetic */ b c;
            public final /* synthetic */ Exception d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0315b(b bVar, Exception exc, Continuation continuation) {
                super(2, continuation);
                this.c = bVar;
                this.d = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new C0315b(this.c, this.d, continuation);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Exception, ? extends Object>> continuation) {
                Continuation<? super Either<? extends Exception, ? extends Object>> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                return new C0315b(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SendLogUseCase sendLogUseCase = this.c.d.w;
                    SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Error, this.d, "An error while saving a photo...");
                    this.b = 1;
                    obj = sendLogUseCase.run(params, (Continuation<? super Either<? extends Exception, ? extends Object>>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSCameraPhotoViewModel sNSCameraPhotoViewModel, byte[] bArr, Continuation continuation) {
            super(2, continuation);
            this.d = sNSCameraPhotoViewModel;
            this.e = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.d, this.e, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Exception exc;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.e.length == 0) {
                    this.d.get_showProgressLiveData().setValue(Boxing.boxBoolean(false));
                    this.d.get_showTakePictureLiveData().setValue(Boxing.boxBoolean(true));
                    NonCancellable nonCancellable = NonCancellable.INSTANCE;
                    a aVar = new a(this, null);
                    this.c = 1;
                    if (BuildersKt.withContext(nonCancellable, aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i != 1) {
                if (i == 2) {
                    try {
                        ResultKt.throwOnFailure(obj);
                        File file = (File) obj;
                        this.d.finishWithResult(new DocumentPickerResult(file, file, null, null, this.d.getSide(), 12, null));
                    } catch (Exception e2) {
                        this.d.get_showProgressLiveData().setValue(Boxing.boxBoolean(false));
                        this.d.get_showTakePictureLiveData().setValue(Boxing.boxBoolean(true));
                        NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
                        C0315b bVar = new C0315b(this, e2, null);
                        this.b = e2;
                        this.c = 3;
                        if (BuildersKt.withContext(nonCancellable2, bVar, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        exc = e2;
                    }
                    return Unit.INSTANCE;
                } else if (i == 3) {
                    exc = (Exception) this.b;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Timber.e(exc, "An error while saving a photo...", new Object[0]);
                return Unit.INSTANCE;
            } else {
                ResultKt.throwOnFailure(obj);
            }
            AddDirectFileToCacheUseCase addDirectFileToCacheUseCase = this.d.v;
            AddDirectFileToCacheUseCase.Params params = new AddDirectFileToCacheUseCase.Params(UUID.randomUUID().toString() + ".jpg", this.e);
            this.c = 2;
            obj = addDirectFileToCacheUseCase.run(params, (Continuation<? super File>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            File file = (File) obj;
            this.d.finishWithResult(new DocumentPickerResult(file, file, null, null, this.d.getSide(), 12, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCameraPhotoViewModel(Applicant applicant, DocumentType documentType, String str, IdentitySide identitySide, AddDirectFileToCacheUseCase addDirectFileToCacheUseCase, SendLogUseCase sendLogUseCase, int i, j jVar) {
        this(applicant, documentType, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : identitySide, addDirectFileToCacheUseCase, sendLogUseCase);
    }

    public static final void access$sendLog(SNSCameraPhotoViewModel sNSCameraPhotoViewModel, String str, Exception exc) {
        Objects.requireNonNull(sNSCameraPhotoViewModel);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(sNSCameraPhotoViewModel), NonCancellable.INSTANCE, null, new a2.q.a.b.b(sNSCameraPhotoViewModel, exc, str, null), 2, null);
    }

    @NotNull
    public final LiveData<Event<Object>> getShowGallery() {
        return this.u;
    }

    public final void onGalleryClicked() {
        this.u.setValue(new Event<>(new Object()));
    }

    public final void onGalleryImagePicked(@Nullable Uri uri, @NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "tempFile");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, uri, file, null), 3, null);
    }

    @Override // com.sumsub.sns.camera.SNSCameraViewModel
    public void onPictureTaken(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        super.onPictureTaken(bArr);
        Timber.i("Picture is taken", new Object[0]);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(this, bArr, null), 3, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSCameraPhotoViewModel(@NotNull Applicant applicant, @NotNull DocumentType documentType, @Nullable String str, @Nullable IdentitySide identitySide, @NotNull AddDirectFileToCacheUseCase addDirectFileToCacheUseCase, @NotNull SendLogUseCase sendLogUseCase) {
        super(applicant, documentType, str, identitySide);
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(documentType, "type");
        Intrinsics.checkNotNullParameter(addDirectFileToCacheUseCase, "addDirectFileToCacheUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        this.v = addDirectFileToCacheUseCase;
        this.w = sendLogUseCase;
        this.u = new ActionLiveData<>();
    }
}

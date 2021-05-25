package com.sumsub.sns.camera.video.presentation;

import a2.g.r.g;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.domain.CreateNewFileUseCase;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u000289B\u000f\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b6\u00107J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u001f\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130!8F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001f\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130!8F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001f\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00130!8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010#R\u0019\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0!8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010#R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0016R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001f\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00130!8F@\u0006¢\u0006\u0006\u001a\u0004\b4\u0010#¨\u0006:"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "Landroid/content/Context;", "context", "Lcom/sumsub/sns/core/data/model/Document;", "value", "", "setPhrase", "(Landroid/content/Context;Lcom/sumsub/sns/core/data/model/Document;)V", "onCountdownFinished", "()V", "startCountdown", "onRecordingFinished", "onFileCreated", "", "l", "Ljava/lang/String;", "phrase", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Ljava/io/File;", "h", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_startRecordingActionLiveData", "Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel$State;", g.a, "_stateActionLiveData", "", "i", "_stopRecordingActionLiveData", "Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel$Result;", "j", "_resultActionLiveData", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "state", "getStartRecording", "startRecording", AuthSource.OPEN_CHANNEL_LIST, "Ljava/io/File;", "file", "getResult", "result", "getMessage", "message", "k", "_messageLiveData", "Lcom/sumsub/sns/core/domain/CreateNewFileUseCase;", "n", "Lcom/sumsub/sns/core/domain/CreateNewFileUseCase;", "createNewFileUseCase", "getStopRecording", "stopRecording", "<init>", "(Lcom/sumsub/sns/core/domain/CreateNewFileUseCase;)V", "Result", "State", "sns-camera-video-selfie_release"}, k = 1, mv = {1, 4, 2})
public final class SNSVideoSelfieViewModel extends SNSBaseViewModel {
    public final ActionLiveData<Event<State>> g = new ActionLiveData<>();
    public final ActionLiveData<Event<File>> h = new ActionLiveData<>();
    public final ActionLiveData<Event<Object>> i = new ActionLiveData<>();
    public final ActionLiveData<Event<Result>> j = new ActionLiveData<>();
    public final ActionLiveData<String> k = new ActionLiveData<>();
    public String l;
    public File m;
    public final CreateNewFileUseCase n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel$Result;", "", "Ljava/io/File;", "component1", "()Ljava/io/File;", "", "component2", "()Ljava/lang/String;", "file", "phrase", "copy", "(Ljava/io/File;Ljava/lang/String;)Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel$Result;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/io/File;", "getFile", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPhrase", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "sns-camera-video-selfie_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result {
        @NotNull
        public final File a;
        @NotNull
        public final String b;

        public Result(@NotNull File file, @NotNull String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(str, "phrase");
            this.a = file;
            this.b = str;
        }

        public static /* synthetic */ Result copy$default(Result result, File file, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                file = result.a;
            }
            if ((i & 2) != 0) {
                str = result.b;
            }
            return result.copy(file, str);
        }

        @NotNull
        public final File component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Result copy(@NotNull File file, @NotNull String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(str, "phrase");
            return new Result(file, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual(this.a, result.a) && Intrinsics.areEqual(this.b, result.b);
        }

        @NotNull
        public final File getFile() {
            return this.a;
        }

        @NotNull
        public final String getPhrase() {
            return this.b;
        }

        public int hashCode() {
            File file = this.a;
            int i = 0;
            int hashCode = (file != null ? file.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Result(file=");
            L.append(this.a);
            L.append(", phrase=");
            return a2.b.a.a.a.t(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Countdown", "Recording", "Done", "sns-camera-video-selfie_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        Idle,
        Countdown,
        Recording,
        Done
    }

    @DebugMetadata(c = "com.sumsub.sns.camera.video.presentation.SNSVideoSelfieViewModel$startCountdown$1", f = "SNSVideoSelfieViewModel.kt", i = {}, l = {74, 79}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object b;
        public int c;
        public final /* synthetic */ SNSVideoSelfieViewModel d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, Continuation continuation) {
            super(2, continuation);
            this.d = sNSVideoSelfieViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            SNSVideoSelfieViewModel sNSVideoSelfieViewModel;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.c = 1;
                if (DelayKt.delay(2000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                sNSVideoSelfieViewModel = (SNSVideoSelfieViewModel) this.b;
                try {
                    ResultKt.throwOnFailure(obj);
                    sNSVideoSelfieViewModel.m = (File) obj;
                    ActionLiveData actionLiveData = this.d.h;
                    File file = this.d.m;
                    Intrinsics.checkNotNull(file);
                    actionLiveData.setValue(new Event(file));
                } catch (Exception e) {
                    Timber.e(e, "An error while creating new video selfie file...", new Object[0]);
                    this.d.get_finishActionLiveData().setValue(new Event(new Object()));
                }
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = UUID.randomUUID().toString() + ".mp4";
            Timber.d(a2.b.a.a.a.c3("File name is ", str), new Object[0]);
            SNSVideoSelfieViewModel sNSVideoSelfieViewModel2 = this.d;
            CreateNewFileUseCase createNewFileUseCase = sNSVideoSelfieViewModel2.n;
            CreateNewFileUseCase.Params params = new CreateNewFileUseCase.Params(str);
            this.b = sNSVideoSelfieViewModel2;
            this.c = 2;
            obj = createNewFileUseCase.run(params, (Continuation<? super File>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            sNSVideoSelfieViewModel = sNSVideoSelfieViewModel2;
            sNSVideoSelfieViewModel.m = (File) obj;
            ActionLiveData actionLiveData = this.d.h;
            File file = this.d.m;
            Intrinsics.checkNotNull(file);
            actionLiveData.setValue(new Event(file));
            return Unit.INSTANCE;
        }
    }

    public SNSVideoSelfieViewModel(@NotNull CreateNewFileUseCase createNewFileUseCase) {
        Intrinsics.checkNotNullParameter(createNewFileUseCase, "createNewFileUseCase");
        this.n = createNewFileUseCase;
        Timber.d("Video Selfie is created", new Object[0]);
    }

    @NotNull
    public final LiveData<String> getMessage() {
        return this.k;
    }

    @NotNull
    public final LiveData<Event<Result>> getResult() {
        return this.j;
    }

    @NotNull
    public final LiveData<Event<File>> getStartRecording() {
        return this.h;
    }

    @NotNull
    public final LiveData<Event<State>> getState() {
        return this.g;
    }

    @NotNull
    public final LiveData<Event<Object>> getStopRecording() {
        return this.i;
    }

    public final void onCountdownFinished() {
        Timber.i("Countdown is finished", new Object[0]);
        this.g.setValue(new Event<>(State.Recording));
    }

    public final void onFileCreated() {
        StringBuilder L = a2.b.a.a.a.L("File is created. File - ");
        File file = this.m;
        L.append(file != null ? file.getAbsolutePath() : null);
        Timber.d(L.toString(), new Object[0]);
        ActionLiveData<Event<Result>> actionLiveData = this.j;
        File file2 = this.m;
        Intrinsics.checkNotNull(file2);
        String str = this.l;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phrase");
        }
        actionLiveData.setValue(new Event<>(new Result(file2, str)));
        get_finishActionLiveData().setValue(new Event<>(new Object()));
    }

    public final void onRecordingFinished() {
        Timber.i("Recording is finished", new Object[0]);
        this.g.setValue(new Event<>(State.Done));
        this.i.setValue(new Event<>(new Object()));
    }

    public final void setPhrase(@NotNull Context context, @NotNull Document document) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(document, "value");
        String stringResource$default = ExtensionsKt.getStringResource$default(context, "sns_step_" + document.getType().getValue() + "_recording_readAloudText", (String) null, 2, (Object) null);
        boolean z = true;
        if (stringResource$default.length() == 0) {
            stringResource$default = ExtensionsKt.getStringResource$default(context, "sns_step_SELFIE_recording_readAloudText", (String) null, 2, (Object) null);
        }
        if (stringResource$default.length() <= 0) {
            z = false;
        }
        String str = z ? (String) CollectionsKt___CollectionsKt.random(StringsKt__StringsKt.split$default((CharSequence) stringResource$default, new String[]{";"}, false, 0, 6, (Object) null), Random.Default) : "";
        this.l = str;
        ActionLiveData<String> actionLiveData = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phrase");
        }
        actionLiveData.setValue(str);
    }

    public final void startCountdown() {
        this.g.setValue(new Event<>(State.Countdown));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, null), 3, null);
    }
}

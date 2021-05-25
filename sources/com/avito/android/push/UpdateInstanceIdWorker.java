package com.avito.android.push;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.push.PushToken;
import com.avito.android.push.UpdateInstanceIdComponent;
import com.avito.android.push.UpdateInstanceIdWorker;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Logs;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdWorker;", "Landroidx/work/RxWorker;", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/Single;", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "Lcom/avito/android/push/provider/PushTokenProvider;", "getPushTokenProvider", "()Lcom/avito/android/push/provider/PushTokenProvider;", "setPushTokenProvider", "(Lcom/avito/android/push/provider/PushTokenProvider;)V", "Lcom/avito/android/push/UpdateInstanceIdInteractor;", "interactor", "Lcom/avito/android/push/UpdateInstanceIdInteractor;", "getInteractor", "()Lcom/avito/android/push/UpdateInstanceIdInteractor;", "setInteractor", "(Lcom/avito/android/push/UpdateInstanceIdInteractor;)V", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "push_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateInstanceIdWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String WORK_NAME = "UpdateInstanceIdWorker";
    @NotNull
    public static final String WORK_TAG = "Communications";
    @Inject
    public UpdateInstanceIdInteractor interactor;
    @Inject
    public PushTokenProvider pushTokenProvider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdWorker$Companion;", "", "Lcom/avito/android/push/PushToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Landroidx/work/Data;", "createInputData", "(Lcom/avito/android/push/PushToken;)Landroidx/work/Data;", "", "WORK_NAME", "Ljava/lang/String;", "WORK_TAG", "<init>", "()V", "push_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final PushToken access$parseInputDataToPushToken(Companion companion, Data data) {
            Objects.requireNonNull(companion);
            String string = data.getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            if (string == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(string, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            return new PushToken.GcmToken(string);
        }

        @NotNull
        public final Data createInputData(@Nullable PushToken pushToken) {
            Data build = new Data.Builder().putString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, pushToken != null ? pushToken.getToken() : null).build();
            Intrinsics.checkNotNullExpressionValue(build, "Data.Builder()\n         …\n                .build()");
            return build;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<Boolean, ListenableWorker.Result> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ListenableWorker.Result apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "success");
            if (bool2.booleanValue()) {
                return ListenableWorker.Result.success();
            }
            return ListenableWorker.Result.retry();
        }
    }

    public static final class b<T, R> implements Function<Throwable, ListenableWorker.Result> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ListenableWorker.Result apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error(UpdateInstanceIdWorker.WORK_NAME, "Failed to register token", th2);
            return ListenableWorker.Result.retry();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateInstanceIdWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        UpdateInstanceIdComponent.Factory factory = DaggerUpdateInstanceIdComponent.factory();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        factory.create((UpdateInstanceIdDependencies) ComponentDependenciesKt.getDependencies(UpdateInstanceIdDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(applicationContext)), new UpdateInstanceIdModule()).inject(this);
    }

    @Override // androidx.work.RxWorker
    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        Single<Option<PushToken>> single;
        Option option;
        Companion companion = Companion;
        Data inputData = getInputData();
        Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
        PushToken access$parseInputDataToPushToken = Companion.access$parseInputDataToPushToken(companion, inputData);
        if (access$parseInputDataToPushToken == null || (option = OptionKt.toOption(access$parseInputDataToPushToken)) == null || (single = Singles.toSingle(option)) == null) {
            PushTokenProvider pushTokenProvider2 = this.pushTokenProvider;
            if (pushTokenProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pushTokenProvider");
            }
            single = pushTokenProvider2.getPushToken(true);
        }
        Single flatMap = single.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(this) { // from class: com.avito.android.push.UpdateInstanceIdWorker$createWork$$inlined$flatMapFold$1
            public final /* synthetic */ UpdateInstanceIdWorker a;

            {
                this.a = r1;
            }

            public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option2) {
                Intrinsics.checkNotNullParameter(option2, "it");
                if (option2 instanceof None) {
                    return Singles.toSingle(ListenableWorker.Result.failure());
                }
                if (option2 instanceof Some) {
                    Single<R> map = this.a.getInteractor().update((PushToken) ((Some) option2).getT()).map(UpdateInstanceIdWorker.a.a);
                    Intrinsics.checkNotNullExpressionValue(map, "interactor.update(pushTo…  }\n                    }");
                    return map;
                }
                throw new NoWhenBranchMatchedException();
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Option) ((Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
        Single<ListenableWorker.Result> onErrorReturn = flatMap.onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "token.flatMapFold(\n     … Result.retry()\n        }");
        return onErrorReturn;
    }

    @NotNull
    public final UpdateInstanceIdInteractor getInteractor() {
        UpdateInstanceIdInteractor updateInstanceIdInteractor = this.interactor;
        if (updateInstanceIdInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return updateInstanceIdInteractor;
    }

    @NotNull
    public final PushTokenProvider getPushTokenProvider() {
        PushTokenProvider pushTokenProvider2 = this.pushTokenProvider;
        if (pushTokenProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushTokenProvider");
        }
        return pushTokenProvider2;
    }

    public final void setInteractor(@NotNull UpdateInstanceIdInteractor updateInstanceIdInteractor) {
        Intrinsics.checkNotNullParameter(updateInstanceIdInteractor, "<set-?>");
        this.interactor = updateInstanceIdInteractor;
    }

    public final void setPushTokenProvider(@NotNull PushTokenProvider pushTokenProvider2) {
        Intrinsics.checkNotNullParameter(pushTokenProvider2, "<set-?>");
        this.pushTokenProvider = pushTokenProvider2;
    }
}

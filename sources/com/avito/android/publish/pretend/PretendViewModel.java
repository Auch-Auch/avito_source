package com.avito.android.publish.pretend;

import a2.a.a.e2.z.c;
import a2.a.a.e2.z.d;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.util.Logs;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/publish/pretend/PretendViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/MultiStateLoading;", "Lcom/avito/android/remote/model/PretendResult;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;)V", "onRetryClicked", "()V", "onBackPressed", "onCleared", "c", "Lcom/avito/android/publish/pretend/PretendInteractor;", g.a, "Lcom/avito/android/publish/pretend/PretendInteractor;", "pretendInteractor", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "d", "Lcom/avito/android/publish/PublishViewModel;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/pretend/PretendInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PretendViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public PublishViewModel d;
    public final MutableLiveData<MultiStateLoading<PretendResult>> e = new MutableLiveData<>();
    public final SchedulersFactory f;
    public final PretendInteractor g;

    public static final class a extends Lambda implements Function1<MultiStateLoading<? super PretendResult>, Unit> {
        public final /* synthetic */ PretendViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PretendViewModel pretendViewModel) {
            super(1);
            this.a = pretendViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MultiStateLoading<? super PretendResult> multiStateLoading) {
            MultiStateLoading<? super PretendResult> multiStateLoading2 = multiStateLoading;
            this.a.e.setValue(multiStateLoading2);
            if (multiStateLoading2 instanceof MultiStateLoading.Loaded) {
                PretendViewModel.access$handlePretendResult(this.a, (PretendResult) ((MultiStateLoading.Loaded) multiStateLoading2).getData());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error("startValidation", th2);
            return Unit.INSTANCE;
        }
    }

    public PretendViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull PretendInteractor pretendInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(pretendInteractor, "pretendInteractor");
        this.f = schedulersFactory;
        this.g = pretendInteractor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handlePretendResult(com.avito.android.publish.pretend.PretendViewModel r3, com.avito.android.remote.model.PretendResult r4) {
        /*
            java.util.Objects.requireNonNull(r3)
            java.util.Map r4 = r4.getErrors()
            boolean r0 = r4.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "publishViewModel"
            if (r0 == 0) goto L_0x0020
            com.avito.android.publish.PublishViewModel r0 = r3.d
            if (r0 != 0) goto L_0x0018
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0018:
            boolean r4 = r0.handleServerValidationErrors(r4)
            if (r4 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r4 != 0) goto L_0x002e
            com.avito.android.publish.PublishViewModel r3 = r3.d
            if (r3 != 0) goto L_0x002a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x002a:
            r4 = 0
            com.avito.android.publish.PublishViewModel.goToNextStep$default(r3, r4, r1, r4)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.pretend.PretendViewModel.access$handlePretendResult(com.avito.android.publish.pretend.PretendViewModel, com.avito.android.remote.model.PretendResult):void");
    }

    public final void c() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        if (categoryParameters != null) {
            CompositeDisposable compositeDisposable = this.c;
            PublishViewModel publishViewModel2 = this.d;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            Observable<R> onErrorReturn = this.g.validateData(publishViewModel2.getNavigation(), categoryParameters).map(c.a).startWith((Observable<R>) ((R) MultiStateLoading.InitLoading.INSTANCE)).onErrorReturn(d.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "pretendInteractor.valida…(error.toErrorResult()) }");
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(a2.b.a.a.a.T1(this.f, onErrorReturn, "pretendRequest(publishVi…(schedulers.mainThread())"), b.a, (Function0) null, new a(this), 2, (Object) null));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
        if (this.e.getValue() == null) {
            c();
        }
    }

    public final void onBackPressed() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }

    public final void onRetryClicked() {
        c();
    }

    @NotNull
    public final LiveData<MultiStateLoading<PretendResult>> screenState() {
        return this.e;
    }
}

package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationResolution;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import com.avito.android.phone_confirmation.view.PhoneConfirmationInputView;
import com.avito.android.phone_confirmation.view.PhoneConfirmationOutputView;
import com.avito.android.phone_confirmation.view.VisibilityText;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a=\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/phone_confirmation/view/PhoneConfirmationInputView;", "inputView", "Lcom/avito/android/phone_confirmation/view/PhoneConfirmationOutputView;", "outputView", "Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "router", "Lcom/avito/android/util/BuildInfo;", "build", "Lio/reactivex/disposables/Disposable;", "bind", "(Lcom/avito/android/phone_confirmation/view/PhoneConfirmationInputView;Lcom/avito/android/phone_confirmation/view/PhoneConfirmationOutputView;Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;Lcom/avito/android/util/BuildInfo;)Lio/reactivex/disposables/Disposable;", "", "CODE_LENGTH", "I", "phone-confirmation_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneConfirmationBinderKt {
    public static final int CODE_LENGTH = 5;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                Intrinsics.checkNotNullParameter(bool2, "it");
                return bool2.booleanValue();
            } else if (i == 1) {
                Boolean bool3 = bool;
                Intrinsics.checkNotNullParameter(bool3, "it");
                return !bool3.booleanValue();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T, R> implements Function<PhoneConfirmationScreenState, PhoneConfirmationScreenState> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final PhoneConfirmationScreenState apply(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            int i = this.a;
            if (i == 0) {
                PhoneConfirmationScreenState phoneConfirmationScreenState2 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState2, "it");
                return PhoneConfirmationScreenState.copy$default(phoneConfirmationScreenState2, null, false, false, false, null, false, null, null, null, null, 991, null);
            } else if (i == 1) {
                PhoneConfirmationScreenState phoneConfirmationScreenState3 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState3, "it");
                return new PhoneConfirmationScreenState(phoneConfirmationScreenState3.getPhone(), phoneConfirmationScreenState3.isCompany(), false, false, null, false, null, null, null, null, 1020, null);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T, R> implements Function<PhoneConfirmationScreenState, String> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final String apply(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            int i = this.a;
            if (i == 0) {
                PhoneConfirmationScreenState phoneConfirmationScreenState2 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState2, "it");
                return phoneConfirmationScreenState2.getPhone();
            } else if (i == 1) {
                PhoneConfirmationScreenState phoneConfirmationScreenState3 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState3, "it");
                String codeRequestError = phoneConfirmationScreenState3.getCodeRequestError();
                return codeRequestError != null ? codeRequestError : "";
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class d<T, R> implements Function<PhoneConfirmationScreenState, ObservableSource<? extends PhoneConfirmationScreenState>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public d(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final ObservableSource<? extends PhoneConfirmationScreenState> apply(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            int i = this.a;
            if (i == 0) {
                PhoneConfirmationScreenState phoneConfirmationScreenState2 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState2, "state");
                return ((PhoneConfirmationInteractor) this.b).confirmPhone(phoneConfirmationScreenState2.getPhone(), phoneConfirmationScreenState2.getEnteredCode(), phoneConfirmationScreenState2.isCompany()).subscribeOn(((SchedulersFactory) this.c).io()).observeOn(((SchedulersFactory) this.c).computation()).map(new a2.a.a.v1.a(phoneConfirmationScreenState2)).onErrorReturn(new a2.a.a.v1.b(phoneConfirmationScreenState2));
            } else if (i == 1) {
                PhoneConfirmationScreenState phoneConfirmationScreenState3 = phoneConfirmationScreenState;
                Intrinsics.checkNotNullParameter(phoneConfirmationScreenState3, "state");
                return ((PhoneConfirmationInteractor) this.b).requestCode(phoneConfirmationScreenState3.getPhone(), phoneConfirmationScreenState3.isCompany()).subscribeOn(((SchedulersFactory) this.c).io()).observeOn(((SchedulersFactory) this.c).computation()).map(new a2.a.a.v1.f(phoneConfirmationScreenState3)).onErrorReturn(new a2.a.a.v1.g(phoneConfirmationScreenState3));
            } else {
                throw null;
            }
        }
    }

    public static final class e extends Lambda implements Function1<PhoneConfirmationResolution[], Observable<Boolean>> {
        public final /* synthetic */ PhoneConfirmationInteractor a;
        public final /* synthetic */ SchedulersFactory b;

        public static final class a<T, R> implements Function<PhoneConfirmationResolution, Boolean> {
            public final /* synthetic */ PhoneConfirmationResolution[] a;

            public a(PhoneConfirmationResolution[] phoneConfirmationResolutionArr) {
                this.a = phoneConfirmationResolutionArr;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Boolean apply(PhoneConfirmationResolution phoneConfirmationResolution) {
                PhoneConfirmationResolution phoneConfirmationResolution2 = phoneConfirmationResolution;
                Intrinsics.checkNotNullParameter(phoneConfirmationResolution2, "it");
                PhoneConfirmationResolution[] phoneConfirmationResolutionArr = this.a;
                int length = phoneConfirmationResolutionArr.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (phoneConfirmationResolutionArr[i] == phoneConfirmationResolution2) {
                        z = true;
                        break;
                    }
                    i++;
                }
                return Boolean.valueOf(z);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(PhoneConfirmationInteractor phoneConfirmationInteractor, SchedulersFactory schedulersFactory) {
            super(1);
            this.a = phoneConfirmationInteractor;
            this.b = schedulersFactory;
        }

        @NotNull
        /* renamed from: a */
        public final Observable<Boolean> invoke(@NotNull PhoneConfirmationResolution... phoneConfirmationResolutionArr) {
            Intrinsics.checkNotNullParameter(phoneConfirmationResolutionArr, "resolutions");
            return a2.b.a.a.a.T1(this.b, this.a.getStateResolution().map(new a(phoneConfirmationResolutionArr)).subscribeOn(this.b.computation()), "interactor.stateResoluti…(schedulers.mainThread())");
        }
    }

    public static final class f extends Lambda implements Function1<PhoneConfirmationResolution[], Observable<Boolean>> {
        public final /* synthetic */ e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(e eVar) {
            super(1);
            this.a = eVar;
        }

        @NotNull
        /* renamed from: a */
        public final Observable<Boolean> invoke(@NotNull PhoneConfirmationResolution... phoneConfirmationResolutionArr) {
            Intrinsics.checkNotNullParameter(phoneConfirmationResolutionArr, "resolutions");
            Observable<Boolean> distinctUntilChanged = this.a.invoke((PhoneConfirmationResolution[]) Arrays.copyOf(phoneConfirmationResolutionArr, phoneConfirmationResolutionArr.length)).distinctUntilChanged();
            Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "isOneOf(*resolutions).distinctUntilChanged()");
            return distinctUntilChanged;
        }
    }

    public static final class g<T, R> implements Function<Boolean, Unit> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Predicate<Pair<? extends String, ? extends PhoneConfirmationScreenState>> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Pair<? extends String, ? extends PhoneConfirmationScreenState> pair) {
            Pair<? extends String, ? extends PhoneConfirmationScreenState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return !Intrinsics.areEqual((String) pair2.getFirst(), ((PhoneConfirmationScreenState) pair2.getSecond()).getEnteredCode());
        }
    }

    public static final class i<T, R> implements Function<Pair<? extends String, ? extends PhoneConfirmationScreenState>, PhoneConfirmationScreenState> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PhoneConfirmationScreenState apply(Pair<? extends String, ? extends PhoneConfirmationScreenState> pair) {
            Pair<? extends String, ? extends PhoneConfirmationScreenState> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            if (((PhoneConfirmationScreenState) pair2.getSecond()).getTooManyValidations() != null) {
                Object first = pair2.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "it.first");
                return PhoneConfirmationScreenState.copy$default((PhoneConfirmationScreenState) pair2.getSecond(), null, false, false, false, null, false, null, null, null, (String) first, 383, null);
            }
            Object first2 = pair2.getFirst();
            Intrinsics.checkNotNullExpressionValue(first2, "it.first");
            return PhoneConfirmationScreenState.copy$default((PhoneConfirmationScreenState) pair2.getSecond(), null, false, false, false, null, false, null, null, null, (String) first2, 127, null);
        }
    }

    public static final class j<T, R> implements Function<Long, ObservableSource<? extends VisibilityText>> {
        public final /* synthetic */ SchedulersFactory a;
        public final /* synthetic */ PhoneConfirmationInteractor b;

        public j(SchedulersFactory schedulersFactory, PhoneConfirmationInteractor phoneConfirmationInteractor) {
            this.a = schedulersFactory;
            this.b = phoneConfirmationInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends VisibilityText> apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "untilTime");
            return Observable.interval(1, TimeUnit.SECONDS, this.a.computation()).startWith((Observable<Long>) 0L).map(new a2.a.a.v1.c(this, l2)).takeUntil(a2.a.a.v1.d.a).map(a2.a.a.v1.e.a);
        }
    }

    public static final class k<T, R> implements Function<Unit, Boolean> {
        public static final k a = new k();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Boolean.FALSE;
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public final /* synthetic */ BuildInfo a;
        public final /* synthetic */ PhoneConfirmationInputView b;

        public l(BuildInfo buildInfo, PhoneConfirmationInputView phoneConfirmationInputView) {
            this.a = buildInfo;
            this.b = phoneConfirmationInputView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (!this.a.isDebug()) {
                Logs.error("PhoneConfirmationBinder", "An undefined state in PhoneConfirmationBinder", th2);
                this.b.getUnknownError().accept(Unit.INSTANCE);
                return;
            }
            throw new OnErrorNotImplementedException(th2);
        }
    }

    public static final class m<T, R> implements Function<PhoneConfirmationScreenState, Boolean> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            Intrinsics.checkNotNullParameter(phoneConfirmationScreenState, "it");
            return Boolean.TRUE;
        }
    }

    public static final class n<T> implements Predicate<PhoneConfirmationResolution> {
        public static final n a = new n();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(PhoneConfirmationResolution phoneConfirmationResolution) {
            PhoneConfirmationResolution phoneConfirmationResolution2 = phoneConfirmationResolution;
            Intrinsics.checkNotNullParameter(phoneConfirmationResolution2, "it");
            return phoneConfirmationResolution2 != PhoneConfirmationResolution.EMPTY;
        }
    }

    @NotNull
    public static final Disposable bind(@NotNull PhoneConfirmationInputView phoneConfirmationInputView, @NotNull PhoneConfirmationOutputView phoneConfirmationOutputView, @NotNull PhoneConfirmationInteractor phoneConfirmationInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PhoneConfirmationRouter phoneConfirmationRouter, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(phoneConfirmationInputView, "inputView");
        Intrinsics.checkNotNullParameter(phoneConfirmationOutputView, "outputView");
        Intrinsics.checkNotNullParameter(phoneConfirmationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(phoneConfirmationRouter, "router");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        l lVar = new l(buildInfo, phoneConfirmationInputView);
        PhoneConfirmationBinderKt$bind$1 phoneConfirmationBinderKt$bind$1 = new Function1<PhoneConfirmationResolution, Observable<PhoneConfirmationScreenState>>(phoneConfirmationInteractor, schedulersFactory) { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1
            public final /* synthetic */ PhoneConfirmationInteractor a;
            public final /* synthetic */ SchedulersFactory b;

            public static final class a<T> implements Predicate<PhoneConfirmationResolution> {
                public final /* synthetic */ PhoneConfirmationResolution a;

                public a(PhoneConfirmationResolution phoneConfirmationResolution) {
                    this.a = phoneConfirmationResolution;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Predicate
                public boolean test(PhoneConfirmationResolution phoneConfirmationResolution) {
                    PhoneConfirmationResolution phoneConfirmationResolution2 = phoneConfirmationResolution;
                    Intrinsics.checkNotNullParameter(phoneConfirmationResolution2, "it");
                    return phoneConfirmationResolution2 == this.a;
                }
            }

            {
                this.a = r1;
                this.b = r2;
            }

            @NotNull
            /* renamed from: a */
            public final Observable<PhoneConfirmationScreenState> invoke(@NotNull PhoneConfirmationResolution phoneConfirmationResolution) {
                Intrinsics.checkNotNullParameter(phoneConfirmationResolution, "resolutions");
                Observable<PhoneConfirmationResolution> filter = this.a.getStateResolution().filter(new a(phoneConfirmationResolution));
                Intrinsics.checkNotNullExpressionValue(filter, "interactor.stateResoluti…ter { it == resolutions }");
                Observable<R> withLatestFrom = filter.withLatestFrom(this.a.getState(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  (r3v2 'withLatestFrom' io.reactivex.Observable<R>) = 
                      (r3v1 'filter' io.reactivex.Observable<com.avito.android.phone_confirmation.state.PhoneConfirmationResolution>)
                      (wrap: com.jakewharton.rxrelay2.Relay<com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState> : 0x001b: INVOKE  (r0v5 com.jakewharton.rxrelay2.Relay<com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState>) = 
                      (wrap: com.avito.android.phone_confirmation.PhoneConfirmationInteractor : 0x0019: IGET  (r0v4 com.avito.android.phone_confirmation.PhoneConfirmationInteractor) = (r2v0 'this' com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1 A[IMMUTABLE_TYPE, THIS]) com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1.a com.avito.android.phone_confirmation.PhoneConfirmationInteractor)
                     type: INTERFACE call: com.avito.android.phone_confirmation.PhoneConfirmationInteractor.getState():com.jakewharton.rxrelay2.Relay)
                      (wrap: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1 : 0x0021: CONSTRUCTOR  (r1v1 com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1) =  call: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1.<init>():void type: CONSTRUCTOR)
                     type: VIRTUAL call: io.reactivex.Observable.withLatestFrom(io.reactivex.ObservableSource, io.reactivex.functions.BiFunction):io.reactivex.Observable in method: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1.a(com.avito.android.phone_confirmation.state.PhoneConfirmationResolution):io.reactivex.Observable<com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState>, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: CONSTRUCTOR  (r1v1 com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1) =  call: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1.<init>():void type: CONSTRUCTOR in method: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1.a(com.avito.android.phone_confirmation.state.PhoneConfirmationResolution):io.reactivex.Observable<com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState>, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 15 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 21 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "resolutions"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    com.avito.android.phone_confirmation.PhoneConfirmationInteractor r0 = r2.a
                    io.reactivex.Observable r0 = r0.getStateResolution()
                    com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$a r1 = new com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$a
                    r1.<init>(r3)
                    io.reactivex.Observable r3 = r0.filter(r1)
                    java.lang.String r0 = "interactor.stateResoluti…ter { it == resolutions }"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    com.avito.android.phone_confirmation.PhoneConfirmationInteractor r0 = r2.a
                    com.jakewharton.rxrelay2.Relay r0 = r0.getState()
                    com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1 r1 = new com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1$filter$$inlined$withLatestFrom$1
                    r1.<init>()
                    io.reactivex.Observable r3 = r3.withLatestFrom(r0, r1)
                    java.lang.String r0 = "withLatestFrom(other, Bi… combiner.invoke(t, u) })"
                    kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                    com.avito.android.util.SchedulersFactory r0 = r2.b
                    io.reactivex.Scheduler r0 = r0.computation()
                    io.reactivex.Observable r3 = r3.subscribeOn(r0)
                    java.lang.String r0 = "interactor.stateResoluti…schedulers.computation())"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$1.invoke(com.avito.android.phone_confirmation.state.PhoneConfirmationResolution):io.reactivex.Observable");
            }
        };
        e eVar = new e(phoneConfirmationInteractor, schedulersFactory);
        f fVar = new f(eVar);
        Disposable subscribe = phoneConfirmationBinderKt$bind$1.invoke(PhoneConfirmationResolution.TOO_MANY_CODE_REQUESTS).map(c.c).observeOn(schedulersFactory.mainThread()).subscribe(phoneConfirmationInputView.getTerminateDialog(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe, "filter(TOO_MANY_CODE_REQ…alog, fatalErrorConsumer)");
        Disposable subscribe2 = phoneConfirmationInteractor.getState().map(c.b).first("").observeOn(schedulersFactory.mainThread()).subscribe(phoneConfirmationInputView.getSetTitleMessage(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.state.map { i…sage, fatalErrorConsumer)");
        Disposable subscribe3 = fVar.invoke(PhoneConfirmationResolution.NETWORK_ERROR).subscribe(phoneConfirmationInputView.getNetworkError(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "isOneOfDistinct(NETWORK_…rror, fatalErrorConsumer)");
        PhoneConfirmationResolution phoneConfirmationResolution = PhoneConfirmationResolution.TOO_MANY_VALIDATION_ERRORS;
        Observable<R> withLatestFrom = fVar.invoke(PhoneConfirmationResolution.VALIDATION_ERROR, phoneConfirmationResolution).withLatestFrom(phoneConfirmationInteractor.getState(), new BiFunction<Boolean, PhoneConfirmationScreenState, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(Boolean bool, PhoneConfirmationScreenState phoneConfirmationScreenState) {
                PhoneConfirmationScreenState phoneConfirmationScreenState2 = phoneConfirmationScreenState;
                boolean booleanValue = bool.booleanValue();
                String tooManyValidations = phoneConfirmationScreenState2.getTooManyValidations();
                if (tooManyValidations == null) {
                    tooManyValidations = phoneConfirmationScreenState2.getValidationError();
                }
                return (R) new VisibilityText(booleanValue, tooManyValidations);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe4 = withLatestFrom.subscribe(phoneConfirmationInputView.getValidationError(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "isOneOfDistinct(VALIDATI…rror, fatalErrorConsumer)");
        PhoneConfirmationResolution phoneConfirmationResolution2 = PhoneConfirmationResolution.EMPTY;
        Disposable subscribe5 = eVar.invoke(phoneConfirmationResolution, phoneConfirmationResolution2).filter(a.b).map(g.a).subscribe(phoneConfirmationInputView.getCleanText(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "isOneOf(TOO_MANY_VALIDAT…Text, fatalErrorConsumer)");
        PhoneConfirmationResolution phoneConfirmationResolution3 = PhoneConfirmationResolution.CODE_ENTERED;
        Disposable subscribe6 = fVar.invoke(phoneConfirmationResolution2, phoneConfirmationResolution3).subscribe(phoneConfirmationInputView.getShowLoader(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe6, "isOneOfDistinct(\n       …ader, fatalErrorConsumer)");
        Disposable subscribe7 = phoneConfirmationOutputView.getAlertDialogClicks().map(k.a).subscribe(phoneConfirmationRouter.getFinish(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe7, "outputView.alertDialogCl…nish, fatalErrorConsumer)");
        PhoneConfirmationResolution phoneConfirmationResolution4 = PhoneConfirmationResolution.DONE;
        Disposable subscribe8 = phoneConfirmationBinderKt$bind$1.invoke(phoneConfirmationResolution4).map(m.a).observeOn(schedulersFactory.mainThread()).subscribe(phoneConfirmationRouter.getFinish(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe8, "filter(DONE)\n        .ma…nish, fatalErrorConsumer)");
        Observable<Boolean> filter = eVar.invoke(phoneConfirmationResolution2, phoneConfirmationResolution4).filter(a.c);
        Intrinsics.checkNotNullExpressionValue(filter, "isOneOf(EMPTY, DONE)\n   …     .filter { it.not() }");
        Observable<R> withLatestFrom2 = filter.withLatestFrom(phoneConfirmationInteractor.getState(), new BiFunction<Boolean, PhoneConfirmationScreenState, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$2
            @Override // io.reactivex.functions.BiFunction
            public final R apply(Boolean bool, PhoneConfirmationScreenState phoneConfirmationScreenState) {
                PhoneConfirmationTime confirmationTime = phoneConfirmationScreenState.getConfirmationTime();
                return (R) Long.valueOf(confirmationTime != null ? confirmationTime.getTimeNextRequestAllowed() : 0);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom2, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe9 = withLatestFrom2.switchMap(new j(schedulersFactory, phoneConfirmationInteractor)).observeOn(schedulersFactory.mainThread()).subscribe(phoneConfirmationInputView.getCodeButtonStatus(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe9, "isOneOf(EMPTY, DONE)\n   …atus, fatalErrorConsumer)");
        Disposable subscribe10 = phoneConfirmationBinderKt$bind$1.invoke(phoneConfirmationResolution2).switchMap(new d(1, phoneConfirmationInteractor, schedulersFactory)).observeOn(schedulersFactory.computation()).subscribe(phoneConfirmationInteractor.getState(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe10, "filter(EMPTY)\n        .s…tate, fatalErrorConsumer)");
        Disposable subscribe11 = phoneConfirmationBinderKt$bind$1.invoke(phoneConfirmationResolution3).switchMap(new d(0, phoneConfirmationInteractor, schedulersFactory)).observeOn(schedulersFactory.computation()).subscribe(phoneConfirmationInteractor.getState(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe11, "filter(CODE_ENTERED)\n   …tate, fatalErrorConsumer)");
        Observable<R> withLatestFrom3 = phoneConfirmationOutputView.getRetry().withLatestFrom(phoneConfirmationInteractor.getState(), new BiFunction<Unit, PhoneConfirmationScreenState, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$3
            @Override // io.reactivex.functions.BiFunction
            public final R apply(Unit unit, PhoneConfirmationScreenState phoneConfirmationScreenState) {
                return (R) phoneConfirmationScreenState;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom3, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe12 = withLatestFrom3.map(b.b).observeOn(schedulersFactory.computation()).subscribe(phoneConfirmationInteractor.getState(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe12, "outputView.retry\n       …tate, fatalErrorConsumer)");
        Observable<String> debounce = phoneConfirmationOutputView.getEnteredCode().subscribeOn(schedulersFactory.computation()).debounce(300, TimeUnit.MILLISECONDS, schedulersFactory.computation());
        Intrinsics.checkNotNullExpressionValue(debounce, "outputView.enteredCode\n …schedulers.computation())");
        Observable<R> withLatestFrom4 = debounce.withLatestFrom(phoneConfirmationInteractor.getState(), new BiFunction<String, PhoneConfirmationScreenState, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$4
            @Override // io.reactivex.functions.BiFunction
            public final R apply(String str, PhoneConfirmationScreenState phoneConfirmationScreenState) {
                return (R) TuplesKt.to(str, phoneConfirmationScreenState);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom4, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe13 = withLatestFrom4.filter(h.a).map(i.a).subscribe(phoneConfirmationInteractor.getState(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe13, "outputView.enteredCode\n …tate, fatalErrorConsumer)");
        Observable<R> withLatestFrom5 = phoneConfirmationOutputView.getNewCodeClicks().withLatestFrom(phoneConfirmationInteractor.getStateResolution(), new BiFunction<Unit, PhoneConfirmationResolution, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$5
            @Override // io.reactivex.functions.BiFunction
            public final R apply(Unit unit, PhoneConfirmationResolution phoneConfirmationResolution5) {
                return (R) phoneConfirmationResolution5;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom5, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Observable<R> filter2 = withLatestFrom5.filter(n.a);
        Intrinsics.checkNotNullExpressionValue(filter2, "outputView.newCodeClicks…  .filter { it != EMPTY }");
        Observable<R> withLatestFrom6 = filter2.withLatestFrom(phoneConfirmationInteractor.getState(), new BiFunction<PhoneConfirmationResolution, PhoneConfirmationScreenState, R>() { // from class: com.avito.android.phone_confirmation.PhoneConfirmationBinderKt$bind$$inlined$withLatestFrom$6
            @Override // io.reactivex.functions.BiFunction
            public final R apply(PhoneConfirmationResolution phoneConfirmationResolution5, PhoneConfirmationScreenState phoneConfirmationScreenState) {
                return (R) phoneConfirmationScreenState;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom6, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe14 = withLatestFrom6.map(b.c).subscribe(phoneConfirmationInteractor.getState(), lVar);
        Intrinsics.checkNotNullExpressionValue(subscribe14, "outputView.newCodeClicks…tate, fatalErrorConsumer)");
        return new CompositeDisposable(subscribe9, subscribe, subscribe2, subscribe3, subscribe4, subscribe5, subscribe6, subscribe8, subscribe7, subscribe10, subscribe11, subscribe12, subscribe13, subscribe14);
    }
}

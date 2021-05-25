package com.avito.android.validation;

import a2.a.a.o3.p;
import a2.a.a.o3.q;
import a2.a.a.o3.r;
import a2.a.a.o3.t;
import a2.a.a.o3.u;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.RangeItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.SubmissionListener;
import com.avito.android.validation.ValidationResult;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00104\u001a\u000201\u0012\u0019\u0010:\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000306¢\u0006\u0002\b705\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010E\u001a\u00020\"¢\u0006\u0004\bd\u0010eJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010 J\u0013\u0010#\u001a\u00020\"*\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010(J$\u0010+\u001a\r\u0012\t\u0012\u00070)¢\u0006\u0002\b*0\u0010*\b\u0012\u0004\u0012\u00020\u001d0\u0010H\u0002¢\u0006\u0004\b+\u0010,J$\u0010.\u001a\r\u0012\t\u0012\u00070-¢\u0006\u0002\b*0\u0010*\b\u0012\u0004\u0012\u00020\u001d0\u0010H\u0002¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u00020\u0011*\u00020\u0011H\u0002¢\u0006\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R)\u0010:\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000306¢\u0006\u0002\b7058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR*\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110F0\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010G\u001a\u0004\bH\u0010IR$\u0010M\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110F0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR:\u0010U\u001a&\u0012\f\u0012\n S*\u0004\u0018\u00010\u00050\u0005 S*\u0012\u0012\f\u0012\n S*\u0004\u0018\u00010\u00050\u0005\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010TR\"\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010TR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010ZR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010]R(\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100_8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010`\u001a\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/avito/android/validation/ParametersListPresenterImpl;", "Lcom/avito/android/validation/ParametersListPresenter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "paramsToValidate", "paramsForConditionChecks", "", "sendParametersToValidator", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "subscribe", "()V", "unsubscribe", "", "paramId", "Lio/reactivex/Completable;", "validateParameter", "(Ljava/lang/String;)Lio/reactivex/Completable;", "", "Lcom/avito/conveyor_item/Item;", PlatformActions.ItemsList.TYPE, "Lio/reactivex/Single;", "Lcom/avito/android/validation/SubmissionListener$SubmissionState;", "onSubmissionRequested", "(Ljava/util/List;)Lio/reactivex/Single;", "Lio/reactivex/Observable;", "Lcom/avito/android/items/BasicInputItem;", "valueChangesObservable", "Lio/reactivex/disposables/Disposable;", a2.g.r.g.a, "(Lio/reactivex/Observable;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/validation/ValidationResult;", "result", "e", "(Lcom/avito/android/validation/ValidationResult;)V", "d", "", "f", "(Lcom/avito/conveyor_item/Item;)Z", "itemId", "", "c", "(Ljava/lang/String;)I", "Lcom/avito/android/validation/ValidationResult$Failure$Error;", "Lkotlin/internal/NoInfer;", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/validation/ValidationResult$Failure$WarningOnFlowFinish;", "h", AuthSource.SEND_ABUSE, "(Lcom/avito/conveyor_item/Item;)Lcom/avito/conveyor_item/Item;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "k", "Ljava/util/Set;", "itemPresentersSet", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/validation/ParametersListInteractor;", "i", "Lcom/avito/android/validation/ParametersListInteractor;", "validator", "n", "Z", "rangeParamEnabled", "Lcom/avito/konveyor/data_source/DataSource;", "Lio/reactivex/Observable;", "getAdapterDataChangeStream", "()Lio/reactivex/Observable;", "adapterDataChangeStream", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "adapterDataChangeRelay", "", "l", "J", "structuralChangeDurationMillis", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "initPassed", "dataRelay", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lio/reactivex/disposables/Disposable;", "dataSubscription", "", "Ljava/util/List;", "convertedItems", "Lio/reactivex/functions/Consumer;", "Lio/reactivex/functions/Consumer;", "getItemListConsumer", "()Lio/reactivex/functions/Consumer;", "itemListConsumer", "<init>", "(Lcom/avito/android/validation/ParametersListInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Ljava/util/Set;JLcom/avito/android/util/SchedulersFactory;Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersListPresenterImpl implements ParametersListPresenter {
    public final BehaviorRelay<List<Item>> a;
    public final PublishRelay<DataSource<? extends Item>> b;
    public List<Item> c = new ArrayList();
    public final BehaviorRelay<Unit> d = BehaviorRelay.create();
    public final CompositeDisposable e = new CompositeDisposable();
    public Disposable f;
    @NotNull
    public final Consumer<List<Item>> g;
    @NotNull
    public final Observable<DataSource<? extends Item>> h;
    public final ParametersListInteractor i;
    public final AdapterPresenter j;
    public final Set<ItemPresenter<?, ?>> k;
    public final long l;
    public final SchedulersFactory m;
    public final boolean n;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<ValidationResult> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(ValidationResult validationResult) {
            int i = this.a;
            if (i == 0) {
                ValidationResult validationResult2 = validationResult;
                Intrinsics.checkNotNullParameter(validationResult2, "it");
                return !(validationResult2 instanceof ValidationResult.Success);
            } else if (i == 1) {
                ValidationResult validationResult3 = validationResult;
                Intrinsics.checkNotNullParameter(validationResult3, "it");
                return !(validationResult3 instanceof ValidationResult.Failure.Warning);
            } else if (i == 2) {
                ValidationResult validationResult4 = validationResult;
                Intrinsics.checkNotNullParameter(validationResult4, "it");
                return !(validationResult4 instanceof ValidationResult.Info);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<List<? extends ValidationResult>, Iterable<? extends ValidationResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Iterable<? extends ValidationResult> apply(List<? extends ValidationResult> list) {
            List<? extends ValidationResult> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return list2;
        }
    }

    public static final class c<T> implements Consumer<ValidationResult> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public c(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ValidationResult validationResult) {
            ValidationResult validationResult2 = validationResult;
            ParametersListPresenterImpl parametersListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(validationResult2, "it");
            parametersListPresenterImpl.e(validationResult2);
        }
    }

    public static final class d<T> implements Consumer<List<ValidationResult>> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public d(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<ValidationResult> list) {
            ParametersListPresenterImpl.access$commitDataChange(this.a, new a2.a.a.o3.c(this));
        }
    }

    public static final class e<T, R> implements Function<List<ValidationResult>, SubmissionListener.SubmissionState> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public e(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SubmissionListener.SubmissionState apply(List<ValidationResult> list) {
            List<ValidationResult> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "warningsOnFlowAndErrors");
            if (list2.isEmpty()) {
                return new SubmissionListener.SubmissionState.Available();
            }
            return new SubmissionListener.SubmissionState.Unavailable(ParametersListPresenterImpl.access$hasErrors(this.a, list2), ParametersListPresenterImpl.access$hasWarningsOnFlow(this.a, list2), CollectionsKt___CollectionsKt.plus((Collection) this.a.b(list2), (Iterable) this.a.h(list2)));
        }
    }

    public static final class f<T> implements Consumer<SubmissionListener.SubmissionState> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public f(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SubmissionListener.SubmissionState submissionState) {
            ParametersListPresenterImpl.access$subscribeToItemEvents(this.a);
        }
    }

    public static final class g<T> implements Consumer<BasicInputItem> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public g(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BasicInputItem basicInputItem) {
            BasicInputItem basicInputItem2 = basicInputItem;
            this.a.i.applyNewValue(basicInputItem2.getStringId(), basicInputItem2);
        }
    }

    public static final class h<T, R> implements Function<BasicInputItem, CompletableSource> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public h(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(BasicInputItem basicInputItem) {
            Completable completable;
            BasicInputItem basicInputItem2 = basicInputItem;
            Intrinsics.checkNotNullParameter(basicInputItem2, "it");
            if (this.a.f(basicInputItem2)) {
                completable = ParametersListPresenterImpl.access$validateItemWithDependentEntities(this.a, basicInputItem2);
            } else {
                completable = ParametersListPresenterImpl.access$replaceItem(this.a, basicInputItem2);
            }
            return Completable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Completable[]{completable, ParametersListPresenterImpl.access$createAutoGeneratedValues(this.a, basicInputItem2)}));
        }
    }

    public static final class i implements Action {
        public static final i a = new i();

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("subscribeToInputValueChanges", th);
        }
    }

    public static final class k<T, R> implements Function<Unit, SingleSource<? extends List<? extends ValidationResult>>> {
        public final /* synthetic */ ParametersListPresenterImpl a;
        public final /* synthetic */ String b;

        public k(ParametersListPresenterImpl parametersListPresenterImpl, String str) {
            this.a = parametersListPresenterImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends ValidationResult>> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.i.validateWithDependentEntities(this.b);
        }
    }

    public static final class l<T, R> implements Function<List<? extends ValidationResult>, Iterable<? extends ValidationResult>> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Iterable<? extends ValidationResult> apply(List<? extends ValidationResult> list) {
            List<? extends ValidationResult> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return list2;
        }
    }

    public static final class m<T> implements Predicate<ValidationResult> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(ValidationResult validationResult) {
            ValidationResult validationResult2 = validationResult;
            Intrinsics.checkNotNullParameter(validationResult2, "it");
            return !(validationResult2 instanceof ValidationResult.Failure.Warning);
        }
    }

    public static final class n<T> implements Consumer<ValidationResult> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public n(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ValidationResult validationResult) {
            ValidationResult validationResult2 = validationResult;
            ParametersListPresenterImpl parametersListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(validationResult2, "it");
            parametersListPresenterImpl.e(validationResult2);
        }
    }

    public static final class o<T> implements Consumer<List<ValidationResult>> {
        public final /* synthetic */ ParametersListPresenterImpl a;

        public o(ParametersListPresenterImpl parametersListPresenterImpl) {
            this.a = parametersListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<ValidationResult> list) {
            ParametersListPresenterImpl.access$commitDataChange(this.a, new u(this));
        }
    }

    public ParametersListPresenterImpl(@NotNull ParametersListInteractor parametersListInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull Set<ItemPresenter<?, ?>> set, long j2, @NotNull SchedulersFactory schedulersFactory, boolean z) {
        Intrinsics.checkNotNullParameter(parametersListInteractor, "validator");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.i = parametersListInteractor;
        this.j = adapterPresenter;
        this.k = set;
        this.l = j2;
        this.m = schedulersFactory;
        this.n = z;
        BehaviorRelay<List<Item>> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
        PublishRelay<DataSource<? extends Item>> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
        this.g = create;
        this.h = create2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r1 == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e1, code lost:
        if ((r1.getState() instanceof com.avito.android.items.ItemWithState.State.Normal) == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ee, code lost:
        if ((r1.getState() instanceof com.avito.android.items.ItemWithState.State.Normal) == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f3, code lost:
        if (r1 == false) goto L_0x00fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$applyDeepValidationResult(com.avito.android.validation.ParametersListPresenterImpl r7, com.avito.conveyor_item.Item r8, com.avito.android.validation.ValidationResult r9) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.validation.ParametersListPresenterImpl.access$applyDeepValidationResult(com.avito.android.validation.ParametersListPresenterImpl, com.avito.conveyor_item.Item, com.avito.android.validation.ValidationResult):void");
    }

    public static final void access$commitDataChange(ParametersListPresenterImpl parametersListPresenterImpl, Function1 function1) {
        function1.invoke(parametersListPresenterImpl.c);
        parametersListPresenterImpl.j.onDataSourceChanged(new ListDataSource(new ArrayList(parametersListPresenterImpl.c)));
        PublishRelay<DataSource<? extends Item>> publishRelay = parametersListPresenterImpl.b;
        List<Item> list = parametersListPresenterImpl.c;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        publishRelay.accept(new ListDataSource(arrayList));
    }

    public static final Completable access$createAutoGeneratedValues(ParametersListPresenterImpl parametersListPresenterImpl, BasicInputItem basicInputItem) {
        Map<String, String> processAutogeneratedValues = parametersListPresenterImpl.i.processAutogeneratedValues(basicInputItem.getStringId());
        if (processAutogeneratedValues.isEmpty()) {
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        }
        Completable subscribeOn = Completable.fromCallable(new a2.a.a.o3.b(parametersListPresenterImpl, processAutogeneratedValues)).subscribeOn(parametersListPresenterImpl.m.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Completable.fromCallable…(schedulers.mainThread())");
        return subscribeOn;
    }

    public static final boolean access$hasErrors(ParametersListPresenterImpl parametersListPresenterImpl, List list) {
        return !((ArrayList) parametersListPresenterImpl.b(list)).isEmpty();
    }

    public static final boolean access$hasWarningsOnFlow(ParametersListPresenterImpl parametersListPresenterImpl, List list) {
        return !((ArrayList) parametersListPresenterImpl.h(list)).isEmpty();
    }

    public static final Completable access$replaceItem(ParametersListPresenterImpl parametersListPresenterImpl, Item item) {
        Objects.requireNonNull(parametersListPresenterImpl);
        return Completable.complete().observeOn(parametersListPresenterImpl.m.mainThread()).doOnComplete(new a2.a.a.o3.d(parametersListPresenterImpl, item));
    }

    public static final void access$subscribeToItemEvents(ParametersListPresenterImpl parametersListPresenterImpl) {
        for (T t : parametersListPresenterImpl.k) {
            if (t instanceof MultiStateSwitcherItemPresenter) {
                CompositeDisposable compositeDisposable = parametersListPresenterImpl.e;
                Disposable subscribe = t.getValueChangesObservable().subscribeOn(parametersListPresenterImpl.m.mainThread()).subscribe(new a2.a.a.o3.e(parametersListPresenterImpl), a2.a.a.o3.f.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "valueChangesObservable\n …          }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t instanceof MultiStateInputItemPresenter) {
                DisposableKt.plusAssign(parametersListPresenterImpl.e, parametersListPresenterImpl.g(t.getValueChangesObservable()));
            } else if (t instanceof VehicleRegNumberInputItemPresenter) {
                DisposableKt.plusAssign(parametersListPresenterImpl.e, parametersListPresenterImpl.g(t.getValueChangesObservable()));
            } else if (t instanceof MultiStateInputWithTagsItemPresenter) {
                DisposableKt.plusAssign(parametersListPresenterImpl.e, parametersListPresenterImpl.g(t.getValueChangesObservable()));
            } else if (t instanceof VideoItemPresenter) {
                DisposableKt.plusAssign(parametersListPresenterImpl.e, parametersListPresenterImpl.g(t.getValueChangesObservable()));
            } else if ((t instanceof CreRangePresenter) && parametersListPresenterImpl.n) {
                CompositeDisposable compositeDisposable2 = parametersListPresenterImpl.e;
                Disposable subscribe2 = t.getValueChangesObservable().doOnNext(new a2.a.a.o3.o(parametersListPresenterImpl)).debounce(300, TimeUnit.MILLISECONDS, parametersListPresenterImpl.m.computation()).toFlowable(BackpressureStrategy.LATEST).flatMapCompletable(new p(parametersListPresenterImpl)).subscribeOn(parametersListPresenterImpl.m.mainThread()).subscribe(q.a, r.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "valueChangesObservable\n …nge\", it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            }
        }
    }

    public static final Completable access$validateItemWithDependentEntities(ParametersListPresenterImpl parametersListPresenterImpl, Item item) {
        Single<List<ValidationResult>> single;
        Objects.requireNonNull(parametersListPresenterImpl);
        if (item instanceof BasicInputItem) {
            single = parametersListPresenterImpl.i.validateWithDependentEntitiesAndApplyValue(item.getStringId(), (BasicInputItem) item);
        } else if (!(item instanceof RangeItem)) {
            return null;
        } else {
            single = parametersListPresenterImpl.i.validateWithDependentEntities(item.getStringId());
        }
        return single.observeOn(parametersListPresenterImpl.m.mainThread()).doOnSuccess(new t(parametersListPresenterImpl, item)).ignoreElement();
    }

    public final Item a(Item item) {
        if (item instanceof ParameterElement.TaggedInput) {
            return ParameterElement.TaggedInput.copy$default((ParameterElement.TaggedInput) item, null, null, null, null, null, false, null, 0, 0, null, null, false, null, null, 16383, null);
        }
        if (item instanceof ParameterElement.Input) {
            return ParameterElement.Input.copy$default((ParameterElement.Input) item, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, false, null, 524287, null);
        }
        if (item instanceof RangeItem) {
            RangeItem rangeItem = (RangeItem) item;
            if (rangeItem instanceof RangeItem.CommonRangeItem) {
                return RangeItem.CommonRangeItem.copy$default((RangeItem.CommonRangeItem) rangeItem, null, null, null, null, null, 31, null);
            }
            if (rangeItem instanceof RangeItem.CreRangeItem) {
                return RangeItem.CreRangeItem.copy$default((RangeItem.CreRangeItem) rangeItem, null, null, null, null, null, 31, null);
            }
            throw new NoWhenBranchMatchedException();
        } else if (item instanceof ParameterElement.Video) {
            return ParameterElement.Video.copy$default((ParameterElement.Video) item, null, null, null, null, null, null, null, null, null, 511, null);
        } else {
            throw new IllegalArgumentException("Cannot copy " + item);
        }
    }

    public final List<ValidationResult.Failure.Error> b(List<? extends ValidationResult> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof ValidationResult.Failure.Error) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public final int c(String str) {
        Iterator<Item> it = this.c.iterator();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getStringId(), str)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            z = true;
        }
        if (z) {
            return i2;
        }
        throw new IllegalStateException(a2.b.a.a.a.e3("Notification for ", str, " is not found in the list").toString());
    }

    public final void d(ValidationResult validationResult) {
        ItemWithState.State state;
        if (!(validationResult instanceof ValidationResult.Success) && !(validationResult instanceof ValidationResult.Info)) {
            Item item = this.c.get(c(validationResult.getId()));
            if (item instanceof ItemWithState) {
                if (validationResult instanceof ValidationResult.Failure.Error) {
                    ValidationResult.Failure.Error error = (ValidationResult.Failure.Error) validationResult;
                    state = new ItemWithState.State.Error(error.getText(), error.getTextForInternalField());
                } else {
                    ValidationResult.Failure failure = (ValidationResult.Failure) validationResult;
                    state = new ItemWithState.State.Warning(failure.getText(), failure.getTextForInternalField());
                }
                ((ItemWithState) item).setState(state);
            }
        }
    }

    public final void e(ValidationResult validationResult) {
        if (validationResult instanceof ValidationResult.Success) {
            Item item = this.c.get(c(validationResult.getId()));
            if (item instanceof ItemWithState) {
                ((ItemWithState) item).setState(new ItemWithState.State.Normal(null, 1, null));
            }
        } else if ((validationResult instanceof ValidationResult.Failure) || (validationResult instanceof ValidationResult.Info)) {
            d(validationResult);
        }
    }

    public final boolean f(Item item) {
        if (item instanceof InputItem) {
            InputItem inputItem = (InputItem) item;
            if (inputItem.getState() instanceof ItemWithState.State.Normal) {
                String value = inputItem.getValue();
                if (value == null || value.length() == 0) {
                    return false;
                }
            }
        } else if (item instanceof ParameterElement.TaggedInput) {
            ParameterElement.TaggedInput taggedInput = (ParameterElement.TaggedInput) item;
            if (taggedInput.getState() instanceof ItemWithState.State.Normal) {
                String value2 = taggedInput.getValue();
                if (value2 == null || value2.length() == 0) {
                    return false;
                }
            }
        } else if (item instanceof ParameterElement.Video) {
            ParameterElement.Video video = (ParameterElement.Video) item;
            if (video.getState() instanceof ItemWithState.State.Normal) {
                String value3 = video.getValue();
                if (value3 == null || value3.length() == 0) {
                    return false;
                }
            }
        } else if (item instanceof RangeItem) {
            RangeItem rangeItem = (RangeItem) item;
            if ((rangeItem.getState() instanceof ItemWithState.State.Normal) && rangeItem.getFrom().getValue() == null && rangeItem.getTo().getValue() == null) {
                return false;
            }
        }
        return true;
    }

    public final Disposable g(Observable<BasicInputItem> observable) {
        Disposable subscribe = observable.doOnNext(new g(this)).debounce(300, TimeUnit.MILLISECONDS, this.m.computation()).toFlowable(BackpressureStrategy.LATEST).flatMapCompletable(new h(this)).subscribeOn(this.m.mainThread()).subscribe(i.a, j.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "valueChangesObservable\n …ges\", it) }\n            )");
        return subscribe;
    }

    @Override // com.avito.android.validation.ParametersListPresenter
    @NotNull
    public Observable<DataSource<? extends Item>> getAdapterDataChangeStream() {
        return this.h;
    }

    @Override // com.avito.android.validation.ParametersListPresenter
    @NotNull
    public Consumer<List<Item>> getItemListConsumer() {
        return this.g;
    }

    public final List<ValidationResult.Failure.WarningOnFlowFinish> h(List<? extends ValidationResult> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof ValidationResult.Failure.WarningOnFlowFinish) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.validation.SubmissionListener
    @NotNull
    public Single<SubmissionListener.SubmissionState> onSubmissionRequested(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, PlatformActions.ItemsList.TYPE);
        this.e.clear();
        this.c = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        Single<R> doOnSuccess = this.i.validateWholeStructure().observeOn(this.m.mainThread()).flattenAsObservable(b.a).filter(a.b).filter(a.c).doOnNext(new c(this)).filter(a.d).toList().doOnSuccess(new d(this)).map(new e(this)).doOnSuccess(new f(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "validator\n            .v…temEvents()\n            }");
        return doOnSuccess;
    }

    @Override // com.avito.android.validation.ParametersListPresenter
    public void sendParametersToValidator(@NotNull ParametersTree parametersTree, @Nullable ParametersTree parametersTree2) {
        Intrinsics.checkNotNullParameter(parametersTree, "paramsToValidate");
        this.i.setParameters(parametersTree, parametersTree2);
    }

    @Override // com.avito.android.validation.ParametersListPresenter
    public void subscribe() {
        Disposable subscribe = this.a.debounce(this.l, TimeUnit.MILLISECONDS, this.m.computation()).doOnNext(new a2.a.a.o3.g(this)).observeOn(this.m.single()).toFlowable(BackpressureStrategy.LATEST).doOnNext(new a2.a.a.o3.h(this)).switchMap(new a2.a.a.o3.j(this)).observeOn(this.m.mainThread()).doOnNext(new a2.a.a.o3.l(this)).ignoreElements().subscribe(a2.a.a.o3.m.a, a2.a.a.o3.n.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "dataRelay\n            .d…          }\n            )");
        this.f = subscribe;
    }

    @Override // com.avito.android.validation.ParametersListPresenter
    public void unsubscribe() {
        this.e.clear();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
    }

    @Override // com.avito.android.validation.SubmissionListener
    @NotNull
    public Completable validateParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "paramId");
        Completable ignoreElement = this.d.flatMapSingle(new k(this, str)).firstOrError().observeOn(this.m.mainThread()).flattenAsObservable(l.a).filter(m.a).doOnNext(new n(this)).toList().doOnSuccess(new o(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "initPassed.flatMapSingle…         .ignoreElement()");
        return ignoreElement;
    }

    public static final void access$replaceItem(ParametersListPresenterImpl parametersListPresenterImpl, int i2, Item item) {
        parametersListPresenterImpl.c.set(i2, item);
    }
}

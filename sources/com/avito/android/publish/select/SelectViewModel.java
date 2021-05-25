package com.avito.android.publish.select;

import a2.a.a.e2.c0.e;
import a2.a.a.e2.c0.f;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.SectionTitle;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.select.title.TitleItem;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u000267B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b4\u00105J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0019\u0010\r\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b¢\u0006\u0002\b\f0\n¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020 0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/avito/android/publish/select/SelectViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/select/SelectViewModel$RoutingAction;", "routingActions", "()Landroidx/lifecycle/LiveData;", "", "stepIndex", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenters", "", "initScreen", "(ILcom/avito/android/publish/PublishViewModel;Ljava/util/Set;)V", "onLeaveClicked", "()V", "onMainButtonClicked", "onDestroyView", "onCleared", "d", "Lcom/avito/android/publish/PublishViewModel;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "c", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "parameter", "", "Lcom/avito/conveyor_item/Item;", "getItems", "items", "Lcom/avito/android/publish/select/SelectViewModel$MainActionState;", "getMainActionState", "mainActionState", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "mutableItems", g.a, "mutableMainActionState", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "<init>", "(Lcom/avito/android/util/SchedulersFactory;)V", "MainActionState", "RoutingAction", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SelectViewModel extends ViewModel {
    public SelectParameter c;
    public PublishViewModel d;
    public final SingleLiveEvent<RoutingAction> e = new SingleLiveEvent<>();
    public final MutableLiveData<List<Item>> f = new MutableLiveData<>();
    public final MutableLiveData<MainActionState> g;
    public final CompositeDisposable h;
    public final SchedulersFactory i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/select/SelectViewModel$MainActionState;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum MainActionState {
        VISIBLE,
        HIDDEN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/select/SelectViewModel$RoutingAction;", "", "<init>", "()V", "ShowOnboarding", "Lcom/avito/android/publish/select/SelectViewModel$RoutingAction$ShowOnboarding;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/select/SelectViewModel$RoutingAction$ShowOnboarding;", "Lcom/avito/android/publish/select/SelectViewModel$RoutingAction;", "Lru/avito/component/toolbar/OnboardingData;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/OnboardingData;", "getOnboardingData", "()Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "<init>", "(Lru/avito/component/toolbar/OnboardingData;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowOnboarding extends RoutingAction {
            @NotNull
            public final OnboardingData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowOnboarding(@NotNull OnboardingData onboardingData) {
                super(null);
                Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
                this.a = onboardingData;
            }

            @NotNull
            public final OnboardingData getOnboardingData() {
                return this.a;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ SelectViewModel a;

        public a(SelectViewModel selectViewModel) {
            this.a = selectViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            OnboardingData onboardingData2 = onboardingData;
            SingleLiveEvent singleLiveEvent = this.a.e;
            Intrinsics.checkNotNullExpressionValue(onboardingData2, "it");
            singleLiveEvent.setValue(new RoutingAction.ShowOnboarding(onboardingData2));
        }
    }

    public SelectViewModel(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.i = schedulersFactory;
        MutableLiveData<MainActionState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(MainActionState.HIDDEN);
        Unit unit = Unit.INSTANCE;
        this.g = mutableLiveData;
        this.h = new CompositeDisposable();
    }

    public static final void access$onItemClick(SelectViewModel selectViewModel, String str) {
        SelectParameter selectParameter = selectViewModel.c;
        if (selectParameter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
        }
        selectParameter.setValue(str);
        PublishViewModel publishViewModel = selectViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishViewModel.goToNextStep$default(publishViewModel, null, 1, null);
    }

    @NotNull
    public final LiveData<List<Item>> getItems() {
        return this.f;
    }

    @NotNull
    public final LiveData<MainActionState> getMainActionState() {
        return this.g;
    }

    public final void initScreen(int i2, @NotNull PublishViewModel publishViewModel, @NotNull Set<ItemPresenter<?, ?>> set) {
        Object obj;
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(set, "itemPresenters");
        SelectParameter selectParameter = (SelectParameter) publishViewModel.getParamsForStep(i2).getFirstParameterOfType(SelectParameter.class);
        if (selectParameter != null) {
            this.c = selectParameter;
            this.d = publishViewModel;
            if (selectParameter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parameter");
            }
            List<ParcelableEntity<String>> listToShow = selectParameter.getListToShow();
            ArrayList arrayList = new ArrayList();
            for (T t : listToShow) {
                if (t instanceof SelectParameter.Value) {
                    String str = (String) t.getId();
                    String title = t.getTitle();
                    String str2 = (String) t.getId();
                    SelectParameter selectParameter2 = this.c;
                    if (selectParameter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("parameter");
                    }
                    obj = new CheckableItem(str, title, Intrinsics.areEqual(str2, (String) selectParameter2.getValue()));
                } else {
                    obj = t instanceof SectionTitle ? new TitleItem(t.getName()) : null;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            this.f.setValue(arrayList);
            MutableLiveData<MainActionState> mutableLiveData = this.g;
            SelectParameter selectParameter3 = this.c;
            if (selectParameter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parameter");
            }
            mutableLiveData.setValue(selectParameter3.getValue() != null ? MainActionState.VISIBLE : MainActionState.HIDDEN);
            for (T t2 : set) {
                if (t2 instanceof CheckableItemPresenter) {
                    CompositeDisposable compositeDisposable = this.h;
                    Disposable subscribe = t2.getItemClickObservable().subscribeOn(this.i.mainThread()).subscribe(new e(this), f.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "itemClickStream.subscrib…eam\", it) }\n            )");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            }
        } else {
            Logs.error$default("Cannot find parameter of type 'select'", null, 2, null);
            PublishViewModel.onUnexpectedErrorOccurred$default(publishViewModel, null, 1, null);
        }
        CompositeDisposable compositeDisposable2 = this.h;
        Disposable subscribe2 = publishViewModel.shouldShowDraftOnboardingForStep(i2).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "publishViewModel\n       …ion.ShowOnboarding(it)) }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.h.clear();
    }

    public final void onDestroyView() {
        this.h.clear();
    }

    public final void onLeaveClicked() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void onMainButtonClicked() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishViewModel.goToNextStep$default(publishViewModel, null, 1, null);
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.e;
    }
}

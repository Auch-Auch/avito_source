package com.avito.android.publish.objects;

import a2.a.a.e2.x.e;
import a2.a.a.e2.x.i;
import a2.a.a.e2.x.j;
import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.objects.DeleteObjectElement;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenter;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.select.SelectListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Throwables;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bu\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010q\u001a\u00020n\u0012\u0006\u0010[\u001a\u00020\u0003\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010u\u001a\u00020r\u0012\u0006\u0010y\u001a\u00020v\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010f\u001a\u00020c\u0012\u001a\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030|¢\u0006\u0002\b}0{¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010\u0015J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020&H\u0001¢\u0006\u0004\b\u000e\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0018H\u0001¢\u0006\u0004\b(\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010*H\u0001¢\u0006\u0004\b+\u0010,J<\u00105\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u0012H\u0001¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\u00042\u0006\u0010.\u001a\u000207H\u0001¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010.\u001a\u000207H\u0001¢\u0006\u0004\b:\u00109J*\u0010>\u001a\u00020\u00042\u0006\u0010.\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001c2\b\b\u0002\u0010=\u001a\u00020\u0012H\u0001¢\u0006\u0004\b>\u0010?J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010.\u001a\u00020@H\u0001¢\u0006\u0004\bA\u0010BJ\u0018\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010zR*\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030|¢\u0006\u0002\b}0{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010¨\u0006\u0001"}, d2 = {"Lcom/avito/android/publish/objects/ObjectsEditPresenterImpl;", "Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/view/ItemDetailsView;", "view", "attachView", "(Lcom/avito/android/publish/view/ItemDetailsView;)V", "Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;)V", "onRetryClick", "onMainButtonClicked", "", "success", "onAuthResult", "(Z)V", "isImmediatelyCancel", "onCancelClicked", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "onResultHandled", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "", "updatesFormForParamId", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "onParametersUpdated", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "detachView", "detachRouter", "keyboardVisible", "handleKeyboard", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "(Lcom/avito/android/publish/view/BasicParameterClickListener$Router;)V", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "element", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "dateTime", "", "timestamp", "presentTime", "updateDateTime", "onDateIntervalValueChanged", "(Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Lcom/avito/android/category_parameters/ParameterElement$DateTime;Ljava/lang/Long;ZZ)V", "Lcom/avito/conveyor_item/Item;", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "onElementErrorDismissed", "Lcom/avito/android/items/InputItem;", "newValue", "updateElement", "onElementValueChanged", "(Lcom/avito/android/items/InputItem;Ljava/lang/String;Z)V", "Lcom/avito/android/items/ItemWithAdditionalButton;", "onInputAdditionalButtonClick", "(Lcom/avito/android/items/ItemWithAdditionalButton;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/android/validation/ParametersListPresenter;", "f", "Lcom/avito/android/validation/ParametersListPresenter;", "paramsListPresenter", "c", "Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "j", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/ErrorFormatterImpl;", "d", "Lcom/avito/android/util/ErrorFormatterImpl;", "errorFormatter", "Landroid/content/res/Resources;", "n", "Landroid/content/res/Resources;", "resources", "i", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "paramsClickListener", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", g.a, "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "e", "Z", "scrollNeeded", "Ljava/util/Locale;", "o", "Ljava/util/Locale;", "locale", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "h", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "interactor", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "k", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "resultHandler", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "l", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/publish/view/ItemDetailsView;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "p", "Ljava/util/Set;", "itemPresentersSet", "<init>", "(Lcom/avito/android/validation/ParametersListPresenter;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Lcom/avito/android/publish/objects/ObjectsEditInteractor;Lcom/avito/android/publish/view/BasicParameterClickListener;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/SchedulersFactory;Landroid/content/res/Resources;Ljava/util/Locale;Ljava/util/Set;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsEditPresenterImpl implements ObjectsEditPresenter, ItemDetailsSelectResultHandler.ResultListener, BasicParameterClickListener {
    public final CompositeDisposable a = new CompositeDisposable();
    public ItemDetailsView b;
    public ObjectsEditPresenter.Router c;
    public final ErrorFormatterImpl d;
    public boolean e;
    public final ParametersListPresenter f;
    public final ObjectsParameter g;
    public final ObjectsEditInteractor h;
    public final BasicParameterClickListener i;
    public final DataAwareAdapterPresenter j;
    public final ItemDetailsSelectResultHandler k;
    public final CategoryParametersElementConverter l;
    public final SchedulersFactory m;
    public final Resources n;
    public final Locale o;
    public final Set<ItemPresenter<?, ?>> p;

    public static final class a<T> implements Consumer<DataSource<? extends Item>> {
        public final /* synthetic */ ObjectsEditPresenterImpl a;
        public final /* synthetic */ ItemDetailsView b;

        public a(ObjectsEditPresenterImpl objectsEditPresenterImpl, ItemDetailsView itemDetailsView) {
            this.a = objectsEditPresenterImpl;
            this.b = itemDetailsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataSource<? extends Item> dataSource) {
            DataSource<? extends Item> dataSource2 = dataSource;
            DataAwareAdapterPresenter dataAwareAdapterPresenter = this.a.j;
            Intrinsics.checkNotNullExpressionValue(dataSource2, "dataSource");
            dataAwareAdapterPresenter.onDataSourceChanged(dataSource2);
            Iterator<T> it = DataSources.toIterableDataSource(dataSource2).iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                T next = it.next();
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (ObjectsEditPresenterKt.access$notInNormalState(next)) {
                    break;
                }
                i++;
            }
            if (!this.a.e || i == -1) {
                this.a.e = false;
                return;
            }
            this.a.e = false;
            ItemDetailsView.DefaultImpls.scrollToItem$default(this.b, i, false, 2, null);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ObjectsEditPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
            super(0);
            this.a = objectsEditPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ItemDetailsView itemDetailsView = this.a.b;
            if (itemDetailsView != null) {
                itemDetailsView.hideKeyboard();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<PretendResult> {
        public final /* synthetic */ ObjectsEditPresenterImpl a;

        public c(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
            this.a = objectsEditPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            ObjectsEditPresenterImpl objectsEditPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(pretendResult2, "it");
            ObjectsEditPresenterImpl.access$onParametersValidated(objectsEditPresenterImpl, pretendResult2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ObjectsEditPresenterImpl a;

        public d(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
            this.a = objectsEditPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ObjectsEditPresenterImpl objectsEditPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ObjectsEditPresenterImpl.access$onFailedToValidateParameters(objectsEditPresenterImpl, th2);
        }
    }

    public ObjectsEditPresenterImpl(@NotNull ParametersListPresenter parametersListPresenter, @NotNull ObjectsParameter objectsParameter, @NotNull ObjectsEditInteractor objectsEditInteractor, @NotNull BasicParameterClickListener basicParameterClickListener, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Resources resources, @NotNull Locale locale, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(parametersListPresenter, "paramsListPresenter");
        Intrinsics.checkNotNullParameter(objectsParameter, "parameter");
        Intrinsics.checkNotNullParameter(objectsEditInteractor, "interactor");
        Intrinsics.checkNotNullParameter(basicParameterClickListener, "paramsClickListener");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemDetailsSelectResultHandler, "resultHandler");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        this.f = parametersListPresenter;
        this.g = objectsParameter;
        this.h = objectsEditInteractor;
        this.i = basicParameterClickListener;
        this.j = dataAwareAdapterPresenter;
        this.k = itemDetailsSelectResultHandler;
        this.l = categoryParametersElementConverter;
        this.m = schedulersFactory;
        this.n = resources;
        this.o = locale;
        this.p = set;
        this.d = new ErrorFormatterImpl(resources);
        basicParameterClickListener.setParametersSource(objectsEditInteractor);
        itemDetailsSelectResultHandler.attachResultListener(this);
        itemDetailsSelectResultHandler.attachParametersSource(objectsEditInteractor);
    }

    public static final void access$deleteParameters(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        objectsEditPresenterImpl.h.deleteParameters();
        ObjectsEditPresenter.Router router = objectsEditPresenterImpl.c;
        if (router != null) {
            router.leaveScreenWithChangedObject(objectsEditPresenterImpl.g);
        }
    }

    public static final void access$onDeleteObjectClicked(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        String string = objectsEditPresenterImpl.n.getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.delete)");
        String string2 = objectsEditPresenterImpl.n.getString(R.string.dismiss);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.dismiss)");
        String title = objectsEditPresenterImpl.g.getTitle();
        Locale locale = objectsEditPresenterImpl.o;
        Objects.requireNonNull(title, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = title.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        ItemDetailsView itemDetailsView = objectsEditPresenterImpl.b;
        if (itemDetailsView != null) {
            itemDetailsView.showDialog(null, string + ' ' + lowerCase + '?', string, string2, new e(objectsEditPresenterImpl));
        }
    }

    public static final void access$onFailedToValidateParameters(ObjectsEditPresenterImpl objectsEditPresenterImpl, Throwable th) {
        ItemDetailsView itemDetailsView = objectsEditPresenterImpl.b;
        if (itemDetailsView != null) {
            itemDetailsView.hideValidationProgress();
        }
        ItemDetailsView itemDetailsView2 = objectsEditPresenterImpl.b;
        if (itemDetailsView2 != null) {
            itemDetailsView2.showContent();
        }
        if (Throwables.isNetworkProblem(th)) {
            ItemDetailsView itemDetailsView3 = objectsEditPresenterImpl.b;
            if (itemDetailsView3 != null) {
                String string = objectsEditPresenterImpl.n.getString(com.avito.android.remote.R.string.network_unavailable_snack);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(remo…etwork_unavailable_snack)");
                itemDetailsView3.showError(string);
            }
        } else if (Throwables.isAuthProblem(th)) {
            ObjectsEditPresenter.Router router = objectsEditPresenterImpl.c;
            if (router != null) {
                router.navigateToAuth();
            }
        } else {
            ItemDetailsView itemDetailsView4 = objectsEditPresenterImpl.b;
            if (itemDetailsView4 != null) {
                itemDetailsView4.showError(objectsEditPresenterImpl.d.format(th));
            }
        }
    }

    public static final void access$onParametersValidated(ObjectsEditPresenterImpl objectsEditPresenterImpl, PretendResult pretendResult) {
        ItemDetailsView itemDetailsView = objectsEditPresenterImpl.b;
        if (itemDetailsView != null) {
            itemDetailsView.hideValidationProgress();
        }
        if (pretendResult.getSuccess()) {
            ObjectsEditPresenter.Router router = objectsEditPresenterImpl.c;
            if (router != null) {
                router.leaveScreenWithChangedObject(objectsEditPresenterImpl.g);
                return;
            }
            return;
        }
        if (!pretendResult.getSuccess()) {
            objectsEditPresenterImpl.e = true;
        }
        objectsEditPresenterImpl.a();
    }

    public static final void access$onValueSelected(ObjectsEditPresenterImpl objectsEditPresenterImpl, SelectedInfo selectedInfo) {
        ParameterSlot findParameter;
        Set set;
        T t;
        ParametersTree parametersTree = objectsEditPresenterImpl.getParametersTree();
        if (parametersTree != null && (findParameter = parametersTree.findParameter(selectedInfo.getSelectId())) != null) {
            if (findParameter instanceof SelectParameter.Flat) {
                Iterator<T> it = ((SelectParameter.Flat) findParameter).getValues().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getId(), selectedInfo.getItem().getStringId())) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    SelectListener.DefaultImpls.onSelected$default(objectsEditPresenterImpl.k, selectedInfo.getSelectId(), t6.n.d.listOf(t2), null, 4, null);
                }
            } else if (findParameter instanceof MultiselectParameter) {
                MultiselectParameter multiselectParameter = (MultiselectParameter) findParameter;
                List list = (List) multiselectParameter.getValue();
                if (list == null || (set = CollectionsKt___CollectionsKt.toMutableSet(list)) == null) {
                    set = new LinkedHashSet();
                }
                if (selectedInfo.getItem().isSelected()) {
                    set.add(selectedInfo.getItem().getStringId());
                } else {
                    set.remove(selectedInfo.getItem().getStringId());
                }
                List<MultiselectParameter.Value> values = multiselectParameter.getValues();
                ArrayList arrayList = new ArrayList();
                for (T t3 : values) {
                    if (set.contains(t3.getId())) {
                        arrayList.add(t3);
                    }
                }
                SelectListener.DefaultImpls.onSelected$default(objectsEditPresenterImpl.k, selectedInfo.getSelectId(), arrayList, null, 4, null);
            }
        }
    }

    public final void a() {
        ParametersTree parametersTree = this.h.getParametersTree();
        if (parametersTree != null) {
            List<Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CategoryParametersElementConverter.convert$default(this.l, parametersTree, null, null, 6, null));
            if (!this.h.isAdding()) {
                mutableList.add(new DeleteObjectElement() { // from class: com.avito.android.publish.objects.ObjectsEditPresenterImpl$showParameters$list$1$1
                    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
                    public long getId() {
                        return DeleteObjectElement.DefaultImpls.getId(this);
                    }

                    @Override // com.avito.conveyor_item.Item
                    @NotNull
                    public String getStringId() {
                        return "delete object element";
                    }
                });
            }
            ParametersListPresenter.DefaultImpls.sendParametersToValidator$default(this.f, parametersTree, null, 2, null);
            Consumer<List<Item>> itemListConsumer = this.f.getItemListConsumer();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(mutableList, 10));
            for (Item item : mutableList) {
                arrayList.add(item);
            }
            itemListConsumer.accept(arrayList);
        }
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter
    public void attachRouter(@NotNull ObjectsEditPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
        this.i.attachRouter(router);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void attachRouter(@NotNull BasicParameterClickListener.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.i.attachRouter(router);
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter
    public void attachView(@NotNull ItemDetailsView itemDetailsView) {
        Intrinsics.checkNotNullParameter(itemDetailsView, "view");
        this.b = itemDetailsView;
        String string = this.n.getString(com.avito.android.publish.R.string.add);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.add)");
        itemDetailsView.setMainButtonTitle(string);
        itemDetailsView.enableMainButton();
        itemDetailsView.setAppBarTitle(this.g.getTitle());
        itemDetailsView.setAppBarShortTitle(this.g.getTitle());
        itemDetailsView.setAppBarHomeIcon(R.drawable.ic_back_24_black);
        ItemDetailsView.DefaultImpls.setAppBarActionButton$default(itemDetailsView, null, ItemDetailsView.RightTopButtonStyle.NONE, 1, null);
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.f.getAdapterDataChangeStream().subscribe(new a(this, itemDetailsView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paramsListPresenter.adap…e\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        for (ItemPresenter itemPresenter : CollectionsKt___CollectionsKt.asSequence(this.p)) {
            if (itemPresenter instanceof MultiStateInputItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.a;
                Observable<U> ofType = ((MultiStateInputItemPresenter) itemPresenter).getValueChangesObservable().ofType(InputItem.class);
                Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
                Disposable subscribe2 = ofType.subscribe(new a2.a.a.e2.x.b(this), h.d);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "itemPresenter.valueChang…                        )");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (itemPresenter instanceof ChipsSelectItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.a;
                Disposable subscribe3 = ((ChipsSelectItemPresenter) itemPresenter).getItemSelectedObservable().subscribe(new u0(0, this), h.e);
                Intrinsics.checkNotNullExpressionValue(subscribe3, "itemPresenter.itemSelect…                        )");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            } else if (itemPresenter instanceof ChipsMultiselectItemPresenter) {
                CompositeDisposable compositeDisposable4 = this.a;
                Disposable subscribe4 = ((ChipsMultiselectItemPresenter) itemPresenter).getItemSelectedObservable().subscribe(new u0(1, this), h.f);
                Intrinsics.checkNotNullExpressionValue(subscribe4, "itemPresenter.itemSelect…                        )");
                DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            } else if (itemPresenter instanceof RadioGroupSelectItemPresenter) {
                CompositeDisposable compositeDisposable5 = this.a;
                Disposable subscribe5 = ((RadioGroupSelectItemPresenter) itemPresenter).getItemSelectedObservable().subscribe(new u0(2, this), h.g);
                Intrinsics.checkNotNullExpressionValue(subscribe5, "itemPresenter.itemSelect…                        )");
                DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            } else if (itemPresenter instanceof MultiStateSelectItemPresenter) {
                CompositeDisposable compositeDisposable6 = this.a;
                Observable<U> ofType2 = ((MultiStateSelectItemPresenter) itemPresenter).getClickEventObservable().ofType(ParameterElement.Select.class);
                Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
                Disposable subscribe6 = ofType2.subscribe(new a2.a.a.e2.x.c(this), h.b);
                Intrinsics.checkNotNullExpressionValue(subscribe6, "itemPresenter.clickEvent…                        )");
                DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            } else if (itemPresenter instanceof DeleteObjectButtonItemPresenter) {
                CompositeDisposable compositeDisposable7 = this.a;
                Disposable subscribe7 = ((DeleteObjectButtonItemPresenter) itemPresenter).getClicksObservable().subscribe(new a2.a.a.e2.x.d(this), h.c);
                Intrinsics.checkNotNullExpressionValue(subscribe7, "itemPresenter.clicksObse…                        )");
                DisposableKt.plusAssign(compositeDisposable7, subscribe7);
            } else if (itemPresenter instanceof DateIntervalItemPresenter) {
                DateIntervalItemPresenter dateIntervalItemPresenter = (DateIntervalItemPresenter) itemPresenter;
                CompositeDisposable compositeDisposable8 = this.a;
                Disposable subscribe8 = dateIntervalItemPresenter.getStartDateSelectClicks().subscribe(new a2.a.a.e2.x.g(this), z2.b);
                Intrinsics.checkNotNullExpressionValue(subscribe8, "itemPresenter.startDateS…observe\", it) }\n        )");
                DisposableKt.plusAssign(compositeDisposable8, subscribe8);
                CompositeDisposable compositeDisposable9 = this.a;
                Disposable subscribe9 = dateIntervalItemPresenter.getEndDateSelectClicks().subscribe(new i(this), z2.c);
                Intrinsics.checkNotNullExpressionValue(subscribe9, "itemPresenter.endDateSel…)\n            }\n        )");
                DisposableKt.plusAssign(compositeDisposable9, subscribe9);
                CompositeDisposable compositeDisposable10 = this.a;
                Disposable subscribe10 = dateIntervalItemPresenter.getPresentTimeCheckChanges().subscribe(new j(this), z2.d);
                Intrinsics.checkNotNullExpressionValue(subscribe10, "itemPresenter.presentTim…observe\", it) }\n        )");
                DisposableKt.plusAssign(compositeDisposable10, subscribe10);
            }
        }
        a();
    }

    public final void b() {
        ItemDetailsView itemDetailsView = this.b;
        if (itemDetailsView != null) {
            itemDetailsView.showValidationProgress();
        }
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.h.validateParameters().subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.validateParam…ValidateParameters(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter, com.avito.android.publish.view.BasicParameterClickListener
    public void detachRouter() {
        this.c = null;
        this.i.detachRouter();
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public CategoryParameters getCategoryParameters() {
        return this.i.getCategoryParameters();
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public ParametersTree getParametersTree() {
        return this.i.getParametersTree();
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter
    public void handleKeyboard(boolean z) {
        ParametersTree parametersTree = this.h.getParametersTree();
        if ((parametersTree != null ? parametersTree.getCount() : 0) <= 1) {
            ItemDetailsView itemDetailsView = this.b;
            if (itemDetailsView != null) {
                itemDetailsView.showMainButton();
            }
        } else if (z) {
            ItemDetailsView itemDetailsView2 = this.b;
            if (itemDetailsView2 != null) {
                itemDetailsView2.hideMainButton();
            }
            ItemDetailsView itemDetailsView3 = this.b;
            if (itemDetailsView3 != null) {
                itemDetailsView3.startScrollListening(new b(this));
            }
        } else {
            ItemDetailsView itemDetailsView4 = this.b;
            if (itemDetailsView4 != null) {
                itemDetailsView4.showMainButtonDelayed();
            }
            ItemDetailsView itemDetailsView5 = this.b;
            if (itemDetailsView5 != null) {
                itemDetailsView5.stopScrollListening();
            }
        }
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter
    public void onAuthResult(boolean z) {
        if (z) {
            b();
            return;
        }
        ObjectsEditPresenter.Router router = this.c;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onCancelClicked(boolean z) {
        ObjectsEditPresenter.Router router = this.c;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onDateIntervalValueChanged(@NotNull ParameterElement.DateInterval dateInterval, @NotNull ParameterElement.DateTime dateTime, @Nullable Long l2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(dateInterval, "element");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.i.onDateIntervalValueChanged(dateInterval, dateTime, l2, z, z2);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementClicked(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        this.i.onElementClicked(item);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementErrorDismissed(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        this.i.onElementErrorDismissed(item);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementValueChanged(@NotNull InputItem inputItem, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        this.i.onElementValueChanged(inputItem, str, z);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onInputAdditionalButtonClick(@NotNull ItemWithAdditionalButton itemWithAdditionalButton) {
        Intrinsics.checkNotNullParameter(itemWithAdditionalButton, "element");
        this.i.onInputAdditionalButtonClick(itemWithAdditionalButton);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onMainButtonClicked() {
        b();
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    public void onParametersUpdated(@Nullable String str, @Nullable ParameterSlot parameterSlot) {
        a();
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    public void onResultHandled(@NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(categoryParameters, "params");
        a();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onRetryClick() {
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    public void onUpdateAddress(@Nullable AddressParameter.Value value) {
        ItemDetailsSelectResultHandler.ResultListener.DefaultImpls.onUpdateAddress(this, value);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void setParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        this.i.setParametersSource(parametersSource);
    }
}

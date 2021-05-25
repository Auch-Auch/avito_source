package com.avito.android.publish.objects;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.DateTimeIntervalParameter;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.Bundles;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u00106\u001a\u000203\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0001\u0010?\u001a\u00020\u001b\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010@\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020'8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010,R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/avito/android/publish/objects/ObjectsEditInteractorImpl;", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "", "getCategoryParameters", "()Ljava/lang/Void;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateParameters", "()Lio/reactivex/Observable;", "", "deleteParameters", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "", "", "Lcom/avito/android/remote/model/PretendErrorValue;", AuthSource.SEND_ABUSE, "(Ljava/util/Map;)Lcom/avito/android/remote/model/PretendResult;", "Lcom/avito/android/remote/model/Navigation;", "j", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "", "d", "I", "objectIndex", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "c", "Ljava/util/List;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "f", "Z", "adding", "getHasOtherObjects", "()Z", "hasOtherObjects", "e", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "tree", g.a, "isAdding", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "i", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "h", "Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;", "api", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "objectsParameter", "savedState", "<init>", "(Lcom/avito/android/validate_advert/remote/ValidateAdvertApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;Landroid/os/Bundle;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsEditInteractorImpl implements ObjectsEditInteractor {
    public final ObjectsParameter a;
    public final CategoryParametersConverter b = new CategoryParametersConverter(null, null, null, 7, null);
    public final List<ParameterSlot> c;
    public final int d;
    public final SimpleParametersTree e;
    public final boolean f;
    public final boolean g;
    public final ValidateAdvertApi h;
    public final PublishAnalyticsDataProvider i;
    public final Navigation j;

    public static final class a<T, R> implements Function<PretendResult, ObservableSource<? extends PretendResult>> {
        public final /* synthetic */ ObjectsEditInteractorImpl a;

        public a(ObjectsEditInteractorImpl objectsEditInteractorImpl) {
            this.a = objectsEditInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PretendResult> apply(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            Intrinsics.checkNotNullParameter(pretendResult2, "it");
            if (pretendResult2.getSuccess()) {
                ObjectsEditInteractorImpl objectsEditInteractorImpl = this.a;
                ObjectsEditInteractorImpl.access$updateParameterValue(objectsEditInteractorImpl, objectsEditInteractorImpl.d);
                return InteropKt.toV2(this.a.h.validateNewAdvertParamsWithNavigation(this.a.b.convertToFieldMap(this.a.j), null, null, this.a.b.convertToFieldMap(d.listOf(this.a.a)), this.a.i.getSessionId())).map(new a2.a.a.e2.x.a(this));
            }
            Observable just = Observable.just(pretendResult2);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class b<T> implements Consumer<PretendResult> {
        public final /* synthetic */ ObjectsEditInteractorImpl a;

        public b(ObjectsEditInteractorImpl objectsEditInteractorImpl) {
            this.a = objectsEditInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PretendResult pretendResult) {
            this.a.e.applyPretendResult(pretendResult.getErrors());
        }
    }

    @Inject
    public ObjectsEditInteractorImpl(@NotNull ValidateAdvertApi validateAdvertApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @Named("navigation") @NotNull Navigation navigation, @Named("parameter") @NotNull ObjectsParameter objectsParameter, @Named("object_index") @Nullable Integer num, @Nullable Bundle bundle) {
        List<ParameterSlot> list;
        Integer num2;
        Intrinsics.checkNotNullParameter(validateAdvertApi, "api");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(objectsParameter, "objectsParameter");
        this.h = validateAdvertApi;
        this.i = publishAnalyticsDataProvider;
        this.j = navigation;
        this.a = objectsParameter;
        if (bundle == null || (list = Bundles.getParcelableList(bundle, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)) == null) {
            if (num != null) {
                List list2 = (List) objectsParameter.getValue();
                list = list2 != null ? (List) list2.get(num.intValue()) : null;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
            } else {
                list = objectsParameter.getParams();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
            }
        }
        this.c = list;
        if (num != null) {
            num2 = num;
        } else {
            num2 = (bundle == null || !bundle.containsKey(FirebaseAnalytics.Param.INDEX)) ? null : Integer.valueOf(bundle.getInt(FirebaseAnalytics.Param.INDEX));
        }
        if (num2 == null) {
            List list3 = (List) objectsParameter.getValue();
            num2 = list3 != null ? Integer.valueOf(list3.size()) : null;
        }
        boolean z = false;
        this.d = num2 != null ? num2.intValue() : 0;
        this.e = new SimpleParametersTree(list, null, 2, null);
        z = num == null ? true : z;
        this.f = z;
        this.g = z;
    }

    public static final void access$updateParameterValue(ObjectsEditInteractorImpl objectsEditInteractorImpl, int i2) {
        List list;
        List list2 = (List) objectsEditInteractorImpl.a.getValue();
        if (list2 == null || (list = CollectionsKt___CollectionsKt.toMutableList((Collection) list2)) == null) {
            list = CollectionsKt__CollectionsKt.mutableListOf(objectsEditInteractorImpl.c);
        }
        if (list.size() > i2) {
            list.remove(i2);
        }
        list.add(i2, objectsEditInteractorImpl.c);
        objectsEditInteractorImpl.a.setValue(list);
    }

    public final PretendResult a(Map<String, ? extends PretendErrorValue> map) {
        boolean isEmpty = map != null ? map.isEmpty() : true;
        if (map == null) {
            map = r.emptyMap();
        }
        return new PretendResult(isEmpty, map);
    }

    @Override // com.avito.android.publish.objects.ObjectsEditInteractor
    public void deleteParameters() {
        List list;
        List mutableList;
        if (!isAdding() && (list = (List) this.a.getValue()) != null && (mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list)) != null) {
            mutableList.remove(this.d);
            this.a.setValue(mutableList);
        }
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public Void getCategoryParameters() {
        return null;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditInteractor
    public boolean getHasOtherObjects() {
        return !this.f || this.d != 0;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditInteractor
    public boolean isAdding() {
        return this.g;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditInteractor
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundles.putParcelableList(bundle, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, this.c);
        bundle.putInt(FirebaseAnalytics.Param.INDEX, this.d);
        return bundle;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditInteractor
    @NotNull
    public Observable<PretendResult> validateParameters() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SimpleParametersTree simpleParametersTree = this.e;
        int count = simpleParametersTree.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            ParameterSlot parameterSlot = (ParameterSlot) simpleParametersTree.getItem(i2);
            boolean z = true;
            if (parameterSlot instanceof EditableParameter) {
                EditableParameter editableParameter = (EditableParameter) parameterSlot;
                if (!editableParameter.getRequired() || editableParameter.hasValue()) {
                    z = false;
                }
                if (z) {
                    PretendErrorValue pretendErrorValue = (PretendErrorValue) linkedHashMap.put(editableParameter.getId(), new PretendErrorValue.Message(editableParameter.getTitle()));
                }
            } else if (parameterSlot instanceof DateTimeIntervalParameter) {
                for (DateTimeParameter dateTimeParameter : ((DateTimeIntervalParameter) parameterSlot).getParameters()) {
                    if (dateTimeParameter.getRequired() && !dateTimeParameter.hasValue()) {
                        PretendErrorValue pretendErrorValue2 = (PretendErrorValue) linkedHashMap.put(dateTimeParameter.getId(), new PretendErrorValue.Message(dateTimeParameter.getTitle()));
                    }
                }
            }
        }
        Observable just = Observable.just(a(linkedHashMap));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        Observable<PretendResult> doOnNext = just.flatMap(new a(this)).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "validateLocally()\n      …retendResult(it.errors) }");
        return doOnNext;
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @NotNull
    public SimpleParametersTree getParametersTree() {
        return this.e;
    }
}

package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Draft;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ObservableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotState;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001sBc\u0012\u0006\u0010M\u001a\u00020?\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0006\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010Q\u001a\u00020\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010!\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0016H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u000b¢\u0006\u0004\b.\u0010+J-\u00100\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b0\u00101J\u0013\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0006¢\u0006\u0004\b3\u0010-J\u001e\u00105\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u000204H\b¢\u0006\u0004\b5\u00106J\u001f\u0010;\u001a\u00020:2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020%H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020%H\u0016¢\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?HÆ\u0003¢\u0006\u0004\b@\u0010AJ\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\bB\u0010-J\u0018\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bD\u0010-J\u0012\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\bG\u0010HJ\u0012\u0010J\u001a\u0004\u0018\u00010IHÆ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\bL\u0010$Jp\u0010R\u001a\u00020\u00002\b\b\u0002\u0010M\u001a\u00020?2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00062\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010Q\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bT\u0010FJ\u0010\u0010U\u001a\u00020%HÖ\u0001¢\u0006\u0004\bU\u0010>J\u001a\u0010X\u001a\u00020\u00162\b\u0010W\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bX\u0010YR\u001c\u0010M\u001a\u00020?8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bM\u0010Z\u001a\u0004\b[\u0010AR\u0016\u0010]\u001a\u00020%8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010>R\"\u0010^\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001e\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bP\u0010`\u001a\u0004\ba\u0010KR$\u0010N\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bN\u0010b\u001a\u0004\bc\u0010-R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010d\u001a\u0004\be\u0010HR\u0018\u0010f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u001c\u0010Q\u001a\u00020\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bQ\u0010h\u001a\u0004\bi\u0010$R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010b\u001a\u0004\bj\u0010-R\u001d\u0010n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100k8F@\u0006¢\u0006\u0006\u001a\u0004\bl\u0010mR\u001e\u0010O\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bO\u0010o\u001a\u0004\bp\u0010F¨\u0006t"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "getTree", "()Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "oldParams", "newParams", "", "", "changedIds", "updateParameters", "(Ljava/util/List;Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "createValueChangesRelay", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "pretendResult", "", "applyPretendResult", "(Ljava/util/Map;)Z", "deepCopy", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "", "iterator", "()Ljava/util/Iterator;", "T", "Ljava/lang/Class;", "type", "getFirstParameterOfType", "(Ljava/lang/Class;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "id", "findParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "getParametersExceptOwnedBySlots", "()Ljava/util/List;", "findParameterHolder", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "cloneWithNewParameters", "(Ljava/util/List;[Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "getSlotStates", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "getSingleParameter", "()Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Navigation;", "component1", "()Lcom/avito/android/remote/model/Navigation;", "component2", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "component3", "component4", "()Ljava/lang/String;", "component5", "()[Ljava/lang/String;", "Lcom/avito/android/remote/model/Draft;", "component6", "()Lcom/avito/android/remote/model/Draft;", "component7", "navigation", "steps", "targetStepId", AnalyticFieldsName.draft, "shouldSaveDraft", "copy", "(Lcom/avito/android/remote/model/Navigation;Ljava/util/List;Ljava/util/List;Ljava/lang/String;[Ljava/lang/String;Lcom/avito/android/remote/model/Draft;Z)Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "getCount", "count", "valueChangesRelay", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/remote/model/Draft;", "getDraft", "Ljava/util/List;", "getSteps", "[Ljava/lang/String;", "getChangedIds", "tree", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "Z", "getShouldSaveDraft", "getParameters", "Lio/reactivex/Observable;", "getValueChanges", "()Lio/reactivex/Observable;", "valueChanges", "Ljava/lang/String;", "getTargetStepId", "<init>", "(Lcom/avito/android/remote/model/Navigation;Ljava/util/List;Ljava/util/List;Ljava/lang/String;[Ljava/lang/String;Lcom/avito/android/remote/model/Draft;Z)V", "Companion", "api_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryParameters implements ParametersTree, Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CategoryParameters> CREATOR = Parcels.creator(CategoryParameters$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("changedIds")
    @Nullable
    private final String[] changedIds;
    @SerializedName(AnalyticFieldsName.draft)
    @Nullable
    private final Draft draft;
    @SerializedName("navigation")
    @NotNull
    private final Navigation navigation;
    @SerializedName("params")
    @NotNull
    private final List<ParameterSlot> parameters;
    @SerializedName("shouldSaveDraft")
    private final boolean shouldSaveDraft;
    @SerializedName("steps")
    @Nullable
    private final List<CategoryPublishStep> steps;
    @SerializedName("targetStepId")
    @Nullable
    private final String targetStepId;
    private SimpleParametersTree tree;
    private PublishRelay<EditableParameter<?>> valueChangesRelay;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryParameters$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.CategoryPublishStep> */
    /* JADX WARN: Multi-variable type inference failed */
    public CategoryParameters(@NotNull Navigation navigation2, @NotNull List<? extends ParameterSlot> list, @Nullable List<? extends CategoryPublishStep> list2, @Nullable String str, @Nullable String[] strArr, @Nullable Draft draft2, boolean z) {
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.navigation = navigation2;
        this.parameters = list;
        this.steps = list2;
        this.targetStepId = str;
        this.changedIds = strArr;
        this.draft = draft2;
        this.shouldSaveDraft = z;
    }

    public static /* synthetic */ CategoryParameters cloneWithNewParameters$default(CategoryParameters categoryParameters, List list, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = null;
        }
        return categoryParameters.cloneWithNewParameters(list, strArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.category_parameters.CategoryParameters */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryParameters copy$default(CategoryParameters categoryParameters, Navigation navigation2, List list, List list2, String str, String[] strArr, Draft draft2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            navigation2 = categoryParameters.navigation;
        }
        if ((i & 2) != 0) {
            list = categoryParameters.parameters;
        }
        if ((i & 4) != 0) {
            list2 = categoryParameters.steps;
        }
        if ((i & 8) != 0) {
            str = categoryParameters.targetStepId;
        }
        if ((i & 16) != 0) {
            strArr = categoryParameters.changedIds;
        }
        if ((i & 32) != 0) {
            draft2 = categoryParameters.draft;
        }
        if ((i & 64) != 0) {
            z = categoryParameters.shouldSaveDraft;
        }
        return categoryParameters.copy(navigation2, list, list2, str, strArr, draft2, z);
    }

    private final PublishRelay<EditableParameter<?>> createValueChangesRelay() {
        PublishRelay<EditableParameter<?>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        SimpleParametersTree tree2 = getTree();
        ArrayList<ObservableParameter> arrayList = new ArrayList();
        for (Object obj : tree2) {
            if (obj instanceof ObservableParameter) {
                arrayList.add(obj);
            }
        }
        for (ObservableParameter observableParameter : arrayList) {
            observableParameter.setValueChangesListener(new Function1<EditableParameter<?>, Unit>(create) { // from class: com.avito.android.remote.model.category_parameters.CategoryParameters$createValueChangesRelay$1$1
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EditableParameter<?> editableParameter) {
                    invoke(editableParameter);
                    return Unit.INSTANCE;
                }

                public final void invoke(EditableParameter<?> editableParameter) {
                    ((PublishRelay) this.receiver).accept(editableParameter);
                }
            });
        }
        return create;
    }

    private final SimpleParametersTree getTree() {
        SimpleParametersTree simpleParametersTree = this.tree;
        if (simpleParametersTree != null) {
            return simpleParametersTree;
        }
        SimpleParametersTree simpleParametersTree2 = new SimpleParametersTree(this.parameters, null, 2, null);
        this.tree = simpleParametersTree2;
        return simpleParametersTree2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot>, java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot>, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.avito.android.remote.model.category_parameters.base.ParameterSlot] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot> updateParameters(java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> r9, java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> r10, java.lang.String[] r11) {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.CategoryParameters.updateParameters(java.util.List, java.util.List, java.lang.String[]):java.util.List");
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    public boolean applyPretendResult(@Nullable Map<String, ? extends PretendErrorValue> map) {
        return getTree().applyPretendResult(map);
    }

    @NotNull
    public final CategoryParameters cloneWithNewParameters(@NotNull List<? extends ParameterSlot> list, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return new CategoryParameters(this.navigation, updateParameters(this.parameters, list, strArr), this.steps, null, null, null, false, 120, null);
    }

    @NotNull
    public final Navigation component1() {
        return this.navigation;
    }

    @NotNull
    public final List<ParameterSlot> component2() {
        return this.parameters;
    }

    @Nullable
    public final List<CategoryPublishStep> component3() {
        return this.steps;
    }

    @Nullable
    public final String component4() {
        return this.targetStepId;
    }

    @Nullable
    public final String[] component5() {
        return this.changedIds;
    }

    @Nullable
    public final Draft component6() {
        return this.draft;
    }

    public final boolean component7() {
        return this.shouldSaveDraft;
    }

    @NotNull
    public final CategoryParameters copy(@NotNull Navigation navigation2, @NotNull List<? extends ParameterSlot> list, @Nullable List<? extends CategoryPublishStep> list2, @Nullable String str, @Nullable String[] strArr, @Nullable Draft draft2, boolean z) {
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return new CategoryParameters(navigation2, list, list2, str, strArr, draft2, z);
    }

    @NotNull
    public final CategoryParameters deepCopy() {
        String[] strArr;
        List list = CollectionsKt___CollectionsKt.toList(this.parameters);
        List<CategoryPublishStep> list2 = this.steps;
        List list3 = list2 != null ? CollectionsKt___CollectionsKt.toList(list2) : null;
        String[] strArr2 = this.changedIds;
        if (strArr2 != null) {
            Object[] copyOf = Arrays.copyOf(strArr2, strArr2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            strArr = (String[]) copyOf;
        } else {
            strArr = null;
        }
        return copy$default(this, null, list, list3, null, strArr, null, false, 105, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryParameters)) {
            return false;
        }
        CategoryParameters categoryParameters = (CategoryParameters) obj;
        return Intrinsics.areEqual(this.navigation, categoryParameters.navigation) && Intrinsics.areEqual(this.parameters, categoryParameters.parameters) && Intrinsics.areEqual(this.steps, categoryParameters.steps) && Intrinsics.areEqual(this.targetStepId, categoryParameters.targetStepId) && Intrinsics.areEqual(this.changedIds, categoryParameters.changedIds) && Intrinsics.areEqual(this.draft, categoryParameters.draft) && this.shouldSaveDraft == categoryParameters.shouldSaveDraft;
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public ParameterSlot findParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return getTree().findParameter(str);
    }

    @Nullable
    public final ParameterSlot findParameterHolder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return getTree().findParameterHolder(str);
    }

    @Nullable
    public final String[] getChangedIds() {
        return this.changedIds;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return getTree().getCount();
    }

    @Nullable
    public final Draft getDraft() {
        return this.draft;
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public <T extends ParameterSlot> T getFirstParameterOfType(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) getTree().getFirstParameterOfType(cls);
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @NotNull
    public final List<ParameterSlot> getParameters() {
        return this.parameters;
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @NotNull
    public List<ParameterSlot> getParametersExceptOwnedBySlots() {
        return getTree().getParametersExceptOwnedBySlots();
    }

    public final boolean getShouldSaveDraft() {
        return this.shouldSaveDraft;
    }

    public final /* synthetic */ <T extends CategoryParameter> T getSingleParameter() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) ((CategoryParameter) getFirstParameterOfType(CategoryParameter.class));
    }

    @NotNull
    public final List<SlotState> getSlotStates() {
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this), CategoryParameters$getSlotStates$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(filter, CategoryParameters$getSlotStates$1.INSTANCE));
    }

    @Nullable
    public final List<CategoryPublishStep> getSteps() {
        return this.steps;
    }

    @Nullable
    public final String getTargetStepId() {
        return this.targetStepId;
    }

    @NotNull
    public final Observable<EditableParameter<?>> getValueChanges() {
        PublishRelay<EditableParameter<?>> publishRelay = this.valueChangesRelay;
        if (publishRelay != null) {
            return publishRelay;
        }
        PublishRelay<EditableParameter<?>> createValueChangesRelay = createValueChangesRelay();
        this.valueChangesRelay = createValueChangesRelay;
        return createValueChangesRelay;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Navigation navigation2 = this.navigation;
        int i = 0;
        int hashCode = (navigation2 != null ? navigation2.hashCode() : 0) * 31;
        List<ParameterSlot> list = this.parameters;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<CategoryPublishStep> list2 = this.steps;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.targetStepId;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String[] strArr = this.changedIds;
        int hashCode5 = (hashCode4 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        Draft draft2 = this.draft;
        if (draft2 != null) {
            i = draft2.hashCode();
        }
        int i2 = (hashCode5 + i) * 31;
        boolean z = this.shouldSaveDraft;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return getTree().isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<ParameterSlot> iterator() {
        return getTree().iterator();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryParameters(navigation=");
        L.append(this.navigation);
        L.append(", parameters=");
        L.append(this.parameters);
        L.append(", steps=");
        L.append(this.steps);
        L.append(", targetStepId=");
        L.append(this.targetStepId);
        L.append(", changedIds=");
        L.append(Arrays.toString(this.changedIds));
        L.append(", draft=");
        L.append(this.draft);
        L.append(", shouldSaveDraft=");
        return a.B(L, this.shouldSaveDraft, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.navigation, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.parameters, 0, 2, null);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.steps, 0, 2, null);
        parcel.writeString(this.targetStepId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryParameters(Navigation navigation2, List list, List list2, String str, String[] strArr, Draft draft2, boolean z, int i, j jVar) {
        this(navigation2, list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : strArr, (i & 32) != 0 ? null : draft2, (i & 64) != 0 ? true : z);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public ParameterSlot getItem(int i) {
        return getTree().getItem(i);
    }
}

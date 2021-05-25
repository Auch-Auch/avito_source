package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlot;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSelect;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlotConfig;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0002OPB\u001f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\b\b\u0002\u0010H\u001a\u00020G¢\u0006\u0004\bM\u0010NJ \u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\b\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\b¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r*\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0016\u0010\u001aJ!\u0010\u001c\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJB\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032'\u0010 \u001a#\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001e¢\u0006\u0002\b\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b'\u0010&J%\u0010\u000e\u001a\u00020*2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010(H\u0016¢\u0006\u0004\b\u000e\u0010+J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0015H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020*H\u0016¢\u0006\u0004\b2\u00103J)\u00107\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00104*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0015H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010@\u001a\u00020\r2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u0015H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0015H\u0016¢\u0006\u0004\bB\u0010<J\u001a\u0010E\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010JR\u0016\u0010L\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010<¨\u0006Q"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "id", "sameId", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "holder", "holderId", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/remote/model/category_parameters/base/HasError;", "Lcom/avito/android/remote/model/PretendErrorValue;", "result", "", "applyPretendResult", "(Lcom/avito/android/remote/model/category_parameters/base/HasError;Lcom/avito/android/remote/model/PretendErrorValue;)V", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "appendParameters", "(Ljava/util/List;Ljava/util/List;)V", "", "countParameters", "(Ljava/util/List;)I", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "select", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter;)I", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree$ParameterHolder;", "traverseDown", "(Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree$ParameterHolder;)V", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "comparator", "findParameter", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree$ParameterHolder;)V", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "findParameterHolder", "", "pretendResult", "", "(Ljava/util/Map;)Z", "", "iterator", "()Ljava/util/Iterator;", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "isEmpty", "()Z", "T", "Ljava/lang/Class;", "type", "getFirstParameterOfType", "(Ljava/lang/Class;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "getParametersExceptOwnedBySlots", "()Ljava/util/List;", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/server_time/TimeSource;", "Ljava/util/List;", "getCount", "count", "<init>", "(Ljava/util/List;Lcom/avito/android/server_time/TimeSource;)V", "Companion", "ParameterHolder", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleParametersTree implements ParametersTree {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SimpleParametersTree> CREATOR = Parcels.creator(SimpleParametersTree$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final List<ParameterSlot> parameters;
    private final TimeSource timeSource;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree$ParameterHolder;", "", "", "inTargetPosition", "()Z", "isValueFound", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", "tryConsume", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Z", "", "consumePosition", "()I", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "getParameter", "()Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "setParameter", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "counter", "I", "<init>", "(I)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ParameterHolder {
        private int counter;
        @Nullable
        private ParameterSlot parameter;

        public ParameterHolder(int i) {
            this.counter = i;
        }

        private final boolean inTargetPosition() {
            return this.counter == 0;
        }

        public final int consumePosition() {
            int i = this.counter;
            this.counter = i - 1;
            return i;
        }

        @Nullable
        public final ParameterSlot getParameter() {
            return this.parameter;
        }

        public final boolean isValueFound() {
            return this.parameter != null;
        }

        public final void setParameter(@Nullable ParameterSlot parameterSlot) {
            this.parameter = parameterSlot;
        }

        public final boolean tryConsume(@NotNull ParameterSlot parameterSlot) {
            Intrinsics.checkNotNullParameter(parameterSlot, "parameter");
            if (!inTargetPosition()) {
                return false;
            }
            this.parameter = parameterSlot;
            this.counter = -1;
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleParametersTree(@NotNull List<? extends ParameterSlot> list, @NotNull TimeSource timeSource2) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullParameter(timeSource2, "timeSource");
        this.parameters = list;
        this.timeSource = timeSource2;
    }

    private final void appendParameters(List<ParameterSlot> list, List<? extends ParameterSlot> list2) {
        List<ParameterSlot> parameters2;
        for (T t : list2) {
            list.add(t);
            if (t instanceof SelectParameter) {
                SelectParameter.Value selectedValue = t.getSelectedValue();
                if (!(selectedValue == null || (parameters2 = selectedValue.getParameters()) == null)) {
                    appendParameters(list, parameters2);
                }
            } else if (t instanceof GroupParameter) {
                appendParameters(list, t.getParameters());
            }
        }
    }

    private final int countParameters(SelectParameter selectParameter) {
        SelectParameter.Value selectedValue = selectParameter.getSelectedValue();
        if (selectedValue == null || selectedValue.getParameters() == null) {
            return 0;
        }
        List<ParameterSlot> parameters2 = selectedValue.getParameters();
        Intrinsics.checkNotNull(parameters2);
        if (!(!parameters2.isEmpty())) {
            return 0;
        }
        List<ParameterSlot> parameters3 = selectedValue.getParameters();
        Intrinsics.checkNotNull(parameters3);
        return countParameters(parameters3);
    }

    /* access modifiers changed from: private */
    public final ParameterSlot holderId(ParameterSlot parameterSlot, String str, ParameterSlot parameterSlot2) {
        if (Intrinsics.areEqual(parameterSlot != null ? parameterSlot.getId() : null, str)) {
            return parameterSlot2;
        }
        return null;
    }

    private final void offer(ParameterSlot parameterSlot, ParameterHolder parameterHolder) {
        List<ParameterSlot> parameters2;
        if (parameterSlot instanceof GroupParameter) {
            GroupParameter groupParameter = (GroupParameter) parameterSlot;
            offer(new GroupMarkerParameter(parameterSlot.getId(), groupParameter.getTitle(), true), parameterHolder);
            traverseDown(groupParameter.getParameters(), parameterHolder);
            offer(new GroupMarkerParameter(parameterSlot.getId(), groupParameter.getTitle(), false), parameterHolder);
        } else if (!parameterHolder.tryConsume(parameterSlot)) {
            parameterHolder.consumePosition();
            if (parameterSlot instanceof SelectParameter) {
                SelectParameter.Value selectedValue = ((SelectParameter) parameterSlot).getSelectedValue();
                if (selectedValue != null && (parameters2 = selectedValue.getParameters()) != null) {
                    traverseDown(parameters2, parameterHolder);
                }
            } else if (parameterSlot instanceof Slot) {
                traverseDown(((Slot) parameterSlot).getParameters(), parameterHolder);
            }
        }
    }

    /* access modifiers changed from: private */
    public final ParameterSlot sameId(ParameterSlot parameterSlot, String str) {
        if (Intrinsics.areEqual(parameterSlot != null ? parameterSlot.getId() : null, str)) {
            return parameterSlot;
        }
        return null;
    }

    private final void traverseDown(List<? extends ParameterSlot> list, ParameterHolder parameterHolder) {
        for (T t : list) {
            if (!parameterHolder.isValueFound()) {
                offer(t, parameterHolder);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077  */
    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean applyPretendResult(@org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, ? extends com.avito.android.remote.model.PretendErrorValue> r13) {
        /*
        // Method dump skipped, instructions count: 291
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.SimpleParametersTree.applyPretendResult(java.util.Map):boolean");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ParametersTree)) {
            return false;
        }
        ParametersTree parametersTree = (ParametersTree) obj;
        if (parametersTree.getCount() != getCount()) {
            return false;
        }
        int i = 0;
        for (Object obj2 : this) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual((ParameterSlot) obj2, (ParameterSlot) parametersTree.getItem(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public ParameterSlot findParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return findParameter(str, new Function3<ParameterSlot, String, ParameterSlot, ParameterSlot>(this) { // from class: com.avito.android.remote.model.category_parameters.SimpleParametersTree$findParameter$1
            public final /* synthetic */ SimpleParametersTree this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final ParameterSlot invoke(@Nullable ParameterSlot parameterSlot, @NotNull String str2, @NotNull ParameterSlot parameterSlot2) {
                Intrinsics.checkNotNullParameter(str2, "checkId");
                Intrinsics.checkNotNullParameter(parameterSlot2, "<anonymous parameter 1>");
                if (Intrinsics.areEqual(parameterSlot != null ? parameterSlot.getId() : null, str2)) {
                    return parameterSlot;
                }
                return null;
            }
        });
    }

    @Nullable
    public final ParameterSlot findParameterHolder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return findParameter(str, new Function3<ParameterSlot, String, ParameterSlot, ParameterSlot>(this) { // from class: com.avito.android.remote.model.category_parameters.SimpleParametersTree$findParameterHolder$1
            public final /* synthetic */ SimpleParametersTree this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final ParameterSlot invoke(@Nullable ParameterSlot parameterSlot, @NotNull String str2, @NotNull ParameterSlot parameterSlot2) {
                Intrinsics.checkNotNullParameter(str2, "checkId");
                Intrinsics.checkNotNullParameter(parameterSlot2, "holder");
                if (Intrinsics.areEqual(parameterSlot != null ? parameterSlot.getId() : null, str2)) {
                    return parameterSlot2;
                }
                return null;
            }
        });
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return countParameters(this.parameters);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public <T extends ParameterSlot> T getFirstParameterOfType(@NotNull Class<T> cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "type");
        Iterator it = iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (cls.isInstance((ParameterSlot) obj)) {
                break;
            }
        }
        return (T) ((ParameterSlot) obj);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @NotNull
    public List<ParameterSlot> getParametersExceptOwnedBySlots() {
        ArrayList arrayList = new ArrayList();
        appendParameters(arrayList, this.parameters);
        return arrayList;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((ParameterSlot) it.next()).hashCode();
        }
        return i;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<ParameterSlot> iterator() {
        return new ParametersTreeIterator(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList(parcel, this.parameters, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleParametersTree(List list, TimeSource timeSource2, int i, j jVar) {
        this(list, (i & 2) != 0 ? TimeSource.DEFAULT : timeSource2);
    }

    private final ParameterSlot findParameter(String str, Function3<? super ParameterSlot, ? super String, ? super ParameterSlot, ? extends ParameterSlot> function3) {
        ParameterSlot parameterSlot;
        ParameterSlot parameterSlot2;
        Iterator it = iterator();
        while (true) {
            ParameterSlot parameterSlot3 = null;
            if (!it.hasNext()) {
                return null;
            }
            ParameterSlot parameterSlot4 = (ParameterSlot) it.next();
            SimpleParametersTree$findParameter$$inlined$forEach$lambda$1 simpleParametersTree$findParameter$$inlined$forEach$lambda$1 = new Function2<ParameterSlot, String, ParameterSlot>(parameterSlot4, this, function3, str) { // from class: com.avito.android.remote.model.category_parameters.SimpleParametersTree$findParameter$$inlined$forEach$lambda$1
                public final /* synthetic */ Function3 $comparator$inlined;
                public final /* synthetic */ String $id$inlined;
                public final /* synthetic */ ParameterSlot $parameter;
                public final /* synthetic */ SimpleParametersTree this$0;

                {
                    this.$parameter = r1;
                    this.this$0 = r2;
                    this.$comparator$inlined = r3;
                    this.$id$inlined = r4;
                }

                @Nullable
                public final ParameterSlot invoke(@Nullable ParameterSlot parameterSlot5, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str2, "checkId");
                    return (ParameterSlot) this.$comparator$inlined.invoke(parameterSlot5, str2, this.$parameter);
                }
            };
            if (Intrinsics.areEqual(parameterSlot4 != null ? parameterSlot4.getId() : null, str)) {
                parameterSlot3 = parameterSlot4;
            }
            if (parameterSlot3 != null) {
                return parameterSlot3;
            }
            if (parameterSlot4 instanceof DateTimeIntervalParameter) {
                DateTimeIntervalParameter dateTimeIntervalParameter = (DateTimeIntervalParameter) parameterSlot4;
                DateTimeParameter start = dateTimeIntervalParameter.getStart();
                if (start != null && (parameterSlot2 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) start, (DateTimeParameter) str)) != null) {
                    return parameterSlot2;
                }
                DateTimeParameter end = dateTimeIntervalParameter.getEnd();
                if (!(end == null || (parameterSlot = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) end, (DateTimeParameter) str)) == null)) {
                    return parameterSlot;
                }
            } else if (parameterSlot4 instanceof ContactMethodSlot) {
                ParameterSlot parameterSlot5 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((ContactMethodSlotConfig) ((ContactMethodSlot) parameterSlot4).getWidget().getConfig()).getField(), (SelectParameter.Flat) str);
                if (parameterSlot5 != null) {
                    return parameterSlot5;
                }
            } else if (parameterSlot4 instanceof AutoSortPhotosSlot) {
                ParameterSlot parameterSlot6 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((AutoSortPhotosSlotConfig) ((AutoSortPhotosSlot) parameterSlot4).getWidget().getConfig()).getField(), (BooleanParameter) str);
                if (parameterSlot6 != null) {
                    return parameterSlot6;
                }
            } else if (parameterSlot4 instanceof ResidentialComplexSlot) {
                ResidentialComplexSlot residentialComplexSlot = (ResidentialComplexSlot) parameterSlot4;
                ParameterSlot parameterSlot7 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((ResidentialComplexSlotConfig) residentialComplexSlot.getWidget().getConfig()).getDevelopment(), (ResidentialComplexSelect) str);
                if (parameterSlot7 != null) {
                    return parameterSlot7;
                }
                ParameterSlot parameterSlot8 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((ResidentialComplexSlotConfig) residentialComplexSlot.getWidget().getConfig()).getBuildingQueue(), (CharParameter) str);
                if (parameterSlot8 != null) {
                    return parameterSlot8;
                }
                ParameterSlot parameterSlot9 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((ResidentialComplexSlotConfig) residentialComplexSlot.getWidget().getConfig()).getBuilding(), (SelectParameter.Flat) str);
                if (parameterSlot9 != null) {
                    return parameterSlot9;
                }
                ParameterSlot parameterSlot10 = (ParameterSlot) simpleParametersTree$findParameter$$inlined$forEach$lambda$1.invoke((SimpleParametersTree$findParameter$$inlined$forEach$lambda$1) ((ResidentialComplexSlotConfig) residentialComplexSlot.getWidget().getConfig()).getSpec(), (CharParameter) str);
                if (parameterSlot10 != null) {
                    return parameterSlot10;
                }
            } else {
                continue;
            }
        }
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public ParameterSlot getItem(int i) {
        if (i <= getCount() - 1) {
            ParameterHolder parameterHolder = new ParameterHolder(i);
            traverseDown(this.parameters, parameterHolder);
            ParameterSlot parameter = parameterHolder.getParameter();
            Intrinsics.checkNotNull(parameter);
            return parameter;
        }
        throw new IndexOutOfBoundsException();
    }

    private final int countParameters(List<? extends ParameterSlot> list) {
        int size;
        int i = 0;
        for (T t : list) {
            int i2 = 1;
            if (t instanceof SelectParameter) {
                T t2 = t;
                if (t2.hasValue()) {
                    size = countParameters((SelectParameter) t2);
                    i2 = 1 + size;
                    i += i2;
                }
            }
            if (t instanceof GroupParameter) {
                i2 = countParameters(t.getParameters()) + 2;
            } else if (t instanceof Slot) {
                size = t.getParameters().size();
                i2 = 1 + size;
            }
            i += i2;
        }
        return i;
    }

    private final void applyPretendResult(HasError hasError, PretendErrorValue pretendErrorValue) {
        hasError.setError(pretendErrorValue instanceof PretendErrorValue.Message ? ((PretendErrorValue.Message) pretendErrorValue).getMessage() : null);
    }
}

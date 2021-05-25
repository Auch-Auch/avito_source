package com.avito.android.select.new_metro.adapter.switcher;

import com.avito.android.lib.design.segmented_control.SegmentedControl;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeView;", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;", "newState", "", "setState", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "", "segmentPosition", "", "segmentText", "onSegmentClick", "(ILjava/lang/String;)V", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "t", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "getSwitcher", "()Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "switcher", "s", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lcom/avito/android/lib/design/segmented_control/SegmentedControl;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroListOutputTypeViewImpl extends BaseViewHolder implements MetroListOutputTypeView, SegmentedControl.OnSegmentClickListener {
    public Function1<? super MetroListOutputTypeItem.OutputType, Unit> s = a.a;
    @NotNull
    public final SegmentedControl t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MetroListOutputTypeItem.OutputType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function1<MetroListOutputTypeItem.OutputType, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MetroListOutputTypeItem.OutputType outputType) {
            Intrinsics.checkNotNullParameter(outputType, "it");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetroListOutputTypeViewImpl(@NotNull SegmentedControl segmentedControl) {
        super(segmentedControl);
        Intrinsics.checkNotNullParameter(segmentedControl, "switcher");
        this.t = segmentedControl;
        segmentedControl.setOnSegmentClickListener(this);
    }

    @NotNull
    public final SegmentedControl getSwitcher() {
        return this.t;
    }

    @Override // com.avito.android.lib.design.segmented_control.SegmentedControl.OnSegmentClickListener
    public void onSegmentClick(int i, @NotNull String str) {
        MetroListOutputTypeItem.OutputType outputType;
        Intrinsics.checkNotNullParameter(str, "segmentText");
        if (i == 0) {
            outputType = MetroListOutputTypeItem.OutputType.ByAlphabet;
        } else {
            outputType = MetroListOutputTypeItem.OutputType.ByLines;
        }
        this.s.invoke(outputType);
    }

    @Override // com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeView
    public void setState(@NotNull MetroListOutputTypeItem.OutputType outputType) {
        Intrinsics.checkNotNullParameter(outputType, "newState");
        int ordinal = outputType.ordinal();
        if (ordinal == 0) {
            this.t.setSelectedPosition(0, true);
        } else if (ordinal == 1) {
            this.t.setSelectedPosition(1, true);
        }
    }

    @Override // com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeView
    public void setStateChangedListener(@NotNull Function1<? super MetroListOutputTypeItem.OutputType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function1;
    }
}

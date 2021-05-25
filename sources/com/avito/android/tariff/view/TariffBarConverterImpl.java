package com.avito.android.tariff.view;

import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.tariff.bar.BarDescriptionState;
import com.avito.android.remote.tariff.bar.BarProgressState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tariff/view/TariffBarConverterImpl;", "Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/remote/tariff/bar/BarDescriptionState;", "barDescriptionState", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "convertDescriptionStatus", "(Lcom/avito/android/remote/tariff/bar/BarDescriptionState;)Lcom/avito/android/paid_services/routing/TariffCountStatus;", "Lcom/avito/android/remote/tariff/bar/BarProgressState;", "progressState", "Lcom/avito/android/paid_services/routing/ProgressState;", "convertProgressStatus", "(Lcom/avito/android/remote/tariff/bar/BarProgressState;)Lcom/avito/android/paid_services/routing/ProgressState;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffBarConverterImpl implements TariffBarConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            BarDescriptionState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            BarProgressState.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
        }
    }

    @Override // com.avito.android.tariff.view.TariffBarConverter
    @NotNull
    public TariffCountStatus convertDescriptionStatus(@Nullable BarDescriptionState barDescriptionState) {
        if (barDescriptionState != null && barDescriptionState.ordinal() == 0) {
            return TariffCountStatus.WARNING;
        }
        return TariffCountStatus.NORMAL;
    }

    @Override // com.avito.android.tariff.view.TariffBarConverter
    @NotNull
    public ProgressState convertProgressStatus(@Nullable BarProgressState barProgressState) {
        if (barProgressState != null && barProgressState.ordinal() == 0) {
            return ProgressState.WARNING;
        }
        return ProgressState.NORMAL;
    }
}

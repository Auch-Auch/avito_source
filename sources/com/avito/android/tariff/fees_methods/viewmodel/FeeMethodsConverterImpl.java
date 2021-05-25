package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.tariff.bar.BarDescriptionState;
import com.avito.android.remote.tariff.bar.BarProgressState;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverterImpl;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "Lcom/avito/android/util/LoadingState;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/FeeMethodsResult;", "Lcom/avito/android/remote/model/LimitsInfo;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenResponse;", CommonKt.EXTRA_RESPONSE, "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenState;", "convert", "(Lcom/avito/android/util/LoadingState;)Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/Features;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsConverterImpl implements FeeMethodsConverter {
    public final AttributedTextFormatter a;
    public final Features b;

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

    @Inject
    public FeeMethodsConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = attributedTextFormatter;
        this.b = features;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: com.avito.android.util.LoadingState<? super kotlin.Pair<com.avito.android.remote.model.FeeMethodsResult, com.avito.android.remote.model.LimitsInfo>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fe  */
    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.util.LoadingState<com.avito.android.tariff.fees_methods.viewmodel.FeesScreenState> convert(@org.jetbrains.annotations.NotNull com.avito.android.util.LoadingState<? super kotlin.Pair<com.avito.android.remote.model.FeeMethodsResult, com.avito.android.remote.model.LimitsInfo>> r24) {
        /*
        // Method dump skipped, instructions count: 465
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverterImpl.convert(com.avito.android.util.LoadingState):com.avito.android.util.LoadingState");
    }
}

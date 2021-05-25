package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/BenefitColoredIcon;", "", "Lcom/avito/android/remote/model/UniversalColor;", "color", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "()Lcom/avito/android/remote/model/UniversalColor;", "Lcom/avito/android/remote/model/BenefitIconName;", "icon", "Lcom/avito/android/remote/model/BenefitIconName;", "getIcon", "()Lcom/avito/android/remote/model/BenefitIconName;", "<init>", "(Lcom/avito/android/remote/model/BenefitIconName;Lcom/avito/android/remote/model/UniversalColor;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitColoredIcon {
    @NotNull
    private final UniversalColor color;
    @Nullable
    private final BenefitIconName icon;

    public BenefitColoredIcon(@Nullable BenefitIconName benefitIconName, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.icon = benefitIconName;
        this.color = universalColor;
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.color;
    }

    @Nullable
    public final BenefitIconName getIcon() {
        return this.icon;
    }
}

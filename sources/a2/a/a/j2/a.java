package a2.a.a.j2;

import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.PushFrequencyOption;
import com.avito.android.lib.design.chips.Chipable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements Chipable {
    @NotNull
    public final String a;
    @NotNull
    public final PushFrequencyOption b;

    public a(@NotNull PushFrequencyOption pushFrequencyOption) {
        Intrinsics.checkNotNullParameter(pushFrequencyOption, "pushOption");
        this.b = pushFrequencyOption;
        this.a = pushFrequencyOption.getTitle();
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    public boolean equalsAsChipable(@NotNull Object obj) {
        PushFrequencyOption pushFrequencyOption;
        Intrinsics.checkNotNullParameter(obj, "other");
        int id = this.b.getId();
        if (!(obj instanceof a)) {
            obj = null;
        }
        a aVar = (a) obj;
        return (aVar == null || (pushFrequencyOption = aVar.b) == null || id != pushFrequencyOption.getId()) ? false : true;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @NotNull
    public String getChipTitle() {
        return this.a;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getImageRes() {
        return Chipable.DefaultImpls.getImageRes(this);
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getLeftImageRes() {
        return Chipable.DefaultImpls.getLeftImageRes(this);
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getRightImageRes() {
        return Chipable.DefaultImpls.getRightImageRes(this);
    }
}

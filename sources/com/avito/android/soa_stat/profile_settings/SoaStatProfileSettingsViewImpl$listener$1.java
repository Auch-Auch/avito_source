package com.avito.android.soa_stat.profile_settings;

import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewImpl$listener$1", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "view", "", "isChecked", "", "onCheckedChanged", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;Z)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatProfileSettingsViewImpl$listener$1 implements CompoundButtonListItem.OnCheckedChangeListener {
    public final /* synthetic */ SoaStatProfileSettingsViewImpl a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SoaStatProfileSettingsViewImpl$listener$1(SoaStatProfileSettingsViewImpl soaStatProfileSettingsViewImpl) {
        this.a = soaStatProfileSettingsViewImpl;
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
    public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
        this.a.g.accept(Boolean.valueOf(z));
    }
}

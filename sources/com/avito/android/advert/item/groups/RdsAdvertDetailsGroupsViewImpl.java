package com.avito.android.advert.item.groups;

import android.view.View;
import com.avito.android.advert_core.advert.AdvertDetailsGroupView;
import com.avito.android.advert_core.advert.AdvertDetailsGroupViewImpl;
import com.avito.android.advert_core.advert.AdvertDetailsGroupsListener;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/groups/RdsAdvertDetailsGroupsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/groups/RdsAdvertDetailsGroupsView;", "", "Lcom/avito/android/remote/model/AdvertParameters$Group;", "groups", "", "setGroups", "(Ljava/util/List;)V", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupView;", "s", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupView;", "groupsView", "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class RdsAdvertDetailsGroupsViewImpl extends BaseViewHolder implements RdsAdvertDetailsGroupsView {
    public final AdvertDetailsGroupView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RdsAdvertDetailsGroupsViewImpl(@NotNull View view, @NotNull AdvertDetailsGroupsListener advertDetailsGroupsListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertDetailsGroupsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = new AdvertDetailsGroupViewImpl(view, advertDetailsGroupsListener, true);
    }

    @Override // com.avito.android.advert.item.groups.RdsAdvertDetailsGroupsView
    public void setGroups(@NotNull List<AdvertParameters.Group> list) {
        Intrinsics.checkNotNullParameter(list, "groups");
        this.s.bind(list);
    }
}

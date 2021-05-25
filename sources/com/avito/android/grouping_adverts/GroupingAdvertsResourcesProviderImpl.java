package com.avito.android.grouping_adverts;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProviderImpl;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;", "", "getColumnsCount", "()I", "", "canSwitchDisplayType", "()Z", "getColumnsCountForList", "", "getCallUnavailableMessage", "()Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsResourcesProviderImpl implements GroupingAdvertsResourcesProvider {
    public final Resources a;

    @Inject
    public GroupingAdvertsResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider
    public boolean canSwitchDisplayType() {
        return this.a.getBoolean(R.bool.can_switch_display_type);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider
    @NotNull
    public String getCallUnavailableMessage() {
        String string = this.a.getString(com.avito.android.ui_components.R.string.cant_do_call);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.cant_do_call)");
        return string;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider
    public int getColumnsCount() {
        return this.a.getInteger(com.avito.android.ui_components.R.integer.serp_columns);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider
    public int getColumnsCountForList() {
        return 1;
    }
}

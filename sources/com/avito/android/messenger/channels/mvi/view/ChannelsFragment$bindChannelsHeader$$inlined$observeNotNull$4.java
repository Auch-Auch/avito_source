package com.avito.android.messenger.channels.mvi.view;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.messenger.channels.black_list_popup.BlacklistPopup;
import com.avito.android.ui_components.R;
import com.avito.android.util.ToastsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsFragment$bindChannelsHeader$$inlined$observeNotNull$4<T> implements Observer<T> {
    public final /* synthetic */ ChannelsFragment a;

    public ChannelsFragment$bindChannelsHeader$$inlined$observeNotNull$4(ChannelsFragment channelsFragment) {
        this.a = channelsFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            ChannelsFragment channelsFragment = this.a;
            ArrayList<View> arrayList = new ArrayList<>();
            String string = channelsFragment.getResources().getString(R.string.action_overflow_menu_content_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…menu_content_description)");
            ChannelsFragment.access$getToolbar$p(channelsFragment).findViewsWithText(arrayList, string, 2);
            View view = (View) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            String string2 = channelsFragment.getResources().getString(com.avito.android.messenger.R.string.messenger_blacklist_popup_message);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_blacklist_popup_message)");
            if (view != null) {
                Context context = ChannelsFragment.access$getToolbar$p(channelsFragment).getContext();
                Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
                new BlacklistPopup(context).setText(string2).show(view, false);
                return;
            }
            Context context2 = channelsFragment.getContext();
            if (context2 != null) {
                ToastsKt.showToast(context2, string2, 0);
            }
        }
    }
}

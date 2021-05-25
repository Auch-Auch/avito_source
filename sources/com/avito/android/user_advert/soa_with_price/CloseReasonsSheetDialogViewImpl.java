package com.avito.android.user_advert.soa_with_price;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/CloseReasonsSheetDialogViewImpl;", "Lcom/avito/android/user_advert/soa_with_price/CloseReasonsSheetDialogView;", "", "onDataChanged", "()V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "variantList", "Landroid/view/ViewGroup;", "rootView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "<init>", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReasonsSheetDialogViewImpl implements CloseReasonsSheetDialogView {
    public final RecyclerView a;

    public CloseReasonsSheetDialogViewImpl(@NotNull ViewGroup viewGroup, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        View findViewById = viewGroup.findViewById(R.id.close_reasons_list);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
    }

    @Override // com.avito.android.user_advert.soa_with_price.CloseReasonsSheetDialogView
    public void onDataChanged() {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}

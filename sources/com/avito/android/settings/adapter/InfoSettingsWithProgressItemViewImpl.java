package com.avito.android.settings.adapter;

import android.view.View;
import android.widget.TextView;
import com.avito.android.settings.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "visible", "visibleProgress", "(Z)V", "Landroid/view/View;", "kotlin.jvm.PlatformType", "t", "Landroid/view/View;", "progressView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "u", "rootView", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class InfoSettingsWithProgressItemViewImpl extends BaseViewHolder implements InfoSettingsWithProgressItemView {
    public final TextView s;
    public final View t;
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoSettingsWithProgressItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.u = view;
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = view.findViewById(R.id.progress_bar);
    }

    @Override // com.avito.android.settings.adapter.InfoSettingsWithProgressItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.u);
    }

    @Override // com.avito.android.settings.adapter.InfoSettingsWithProgressItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        textView.setText(charSequence);
    }

    @Override // com.avito.android.settings.adapter.InfoSettingsWithProgressItemView
    public void visibleProgress(boolean z) {
        Views.setVisible(this.t, z);
    }
}

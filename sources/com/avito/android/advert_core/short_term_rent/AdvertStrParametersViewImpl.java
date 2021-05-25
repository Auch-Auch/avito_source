package com.avito.android.advert_core.short_term_rent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.avito.android.advert_core.KeyValue;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlock;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrParametersViewImpl;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrParametersView;", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "bindParameters", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "container", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "", "d", "I", "keyValueId", "Landroid/view/ViewStub;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewStub;", "viewStub", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrParametersViewImpl implements AdvertStrParametersView {
    public final LayoutInflater a;
    public final ViewStub b;
    public ViewGroup c;
    public final int d = R.layout.multiline_key_value;

    public AdvertStrParametersViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.str_stub);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.str_stub)");
        this.b = (ViewStub) findViewById;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrParametersView
    public void bindParameters(@Nullable List<AdvertStrBlock.Parameter> list) {
        if (list != null && (!list.isEmpty())) {
            this.b.setInflatedId(com.avito.android.ui_components.R.id.flat_container);
            ViewGroup viewGroup = this.c;
            if (viewGroup == null) {
                View inflate = this.b.inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                viewGroup = (ViewGroup) inflate;
            }
            this.c = viewGroup;
            Views.show(viewGroup);
            viewGroup.removeAllViews();
            for (AdvertStrBlock.Parameter parameter : list) {
                String description = parameter.getDescription();
                String title = parameter.getTitle();
                View inflate2 = this.a.inflate(this.d, viewGroup, false);
                Objects.requireNonNull(inflate2, "null cannot be cast to non-null type com.avito.android.advert_core.KeyValue");
                KeyValue keyValue = (KeyValue) inflate2;
                keyValue.setText(description);
                keyValue.setTitle(title);
                viewGroup.addView(keyValue);
            }
        }
    }
}

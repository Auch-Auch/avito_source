package com.avito.android.advert_core.specifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/specifications/BlockView;", "", "Lcom/avito/android/remote/model/ModelSpecifications$Block;", "block", "", "bindBlock$advert_core_release", "(Lcom/avito/android/remote/model/ModelSpecifications$Block;)V", "bindBlock", "", "Lcom/avito/android/advert_core/specifications/BlockView$Param;", "e", "Ljava/util/List;", "paramsView", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "title", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "paramsContainer", "", AuthSource.SEND_ABUSE, "I", "betweenLineOffset", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "d", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "Param", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class BlockView {
    public final int a;
    public final TextView b;
    public final LinearLayout c;
    public final LayoutInflater d;
    public final List<Param> e = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert_core/specifications/BlockView$Param;", "", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "getTitle$advert_core_release", "()Landroid/widget/TextView;", "title", AuthSource.BOOKING_ORDER, "getValue$advert_core_release", "value", "Landroid/view/View;", "c", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Param {
        @NotNull
        public final TextView a;
        @NotNull
        public final TextView b;
        @NotNull
        public final View c;

        public Param(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "root");
            this.c = view;
            View findViewById = view.findViewById(R.id.title);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.value);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.b = (TextView) findViewById2;
        }

        @NotNull
        public final View getRoot() {
            return this.c;
        }

        @NotNull
        public final TextView getTitle$advert_core_release() {
            return this.a;
        }

        @NotNull
        public final TextView getValue$advert_core_release() {
            return this.b;
        }
    }

    public BlockView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        this.a = view.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.rds_column_offset);
        View findViewById = view.findViewById(R.id.block_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.block_params_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.c = (LinearLayout) findViewById2;
        this.d = LayoutInflater.from(view.getContext());
    }

    public final void bindBlock$advert_core_release(@NotNull ModelSpecifications.Block block) {
        int childCount;
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        this.b.setText(block.getTitle());
        List<ModelSpecifications.Parameter> params = block.getParams();
        if (this.c.getChildCount() > params.size() && params.size() - 1 >= (childCount = this.c.getChildCount())) {
            while (true) {
                this.c.removeViewAt(i);
                this.e.remove(i);
                if (i == childCount) {
                    break;
                }
                i--;
            }
        }
        if (this.c.getChildCount() < params.size()) {
            int size = params.size();
            for (int childCount2 = this.c.getChildCount(); childCount2 < size; childCount2++) {
                View inflate = this.d.inflate(R.layout.block_parameter_item, (ViewGroup) this.c, false);
                this.c.addView(inflate);
                List<Param> list = this.e;
                Intrinsics.checkNotNullExpressionValue(inflate, "paramView");
                list.add(new Param(inflate));
            }
        }
        int i2 = 0;
        for (T t : params) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            Param param = this.e.get(i2);
            param.getTitle$advert_core_release().setText(t2.getName());
            param.getValue$advert_core_release().setText(t2.getValue());
            ViewGroup.LayoutParams layoutParams = param.getRoot().getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i2 == params.size() + -1 ? 0 : this.a;
            i2 = i3;
        }
    }
}

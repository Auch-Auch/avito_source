package a2.a.a.w.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.paragraph.ParagraphItemViewImpl;
import com.avito.android.brandspace.remote.model.BrandspaceAboutParagraphElement;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends ReuseChildrenHelper<BrandspaceAboutParagraphElement, View> {
    public final ViewGroup a;
    @NotNull
    public final View b;

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = view.findViewById(R.id.paragraph_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.paragraph_container)");
        this.a = (ViewGroup) findViewById;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public void bindData(View view, BrandspaceAboutParagraphElement brandspaceAboutParagraphElement, int i) {
        BrandspaceAboutParagraphElement brandspaceAboutParagraphElement2 = brandspaceAboutParagraphElement;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(brandspaceAboutParagraphElement2, "data");
        Object tag = view.getTag(R.id.brandspace_about_viewholder);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.avito.android.brandspace.items.paragraph.ParagraphItemViewImpl");
        ((ParagraphItemViewImpl) tag).bind(brandspaceAboutParagraphElement2.getTitle(), brandspaceAboutParagraphElement2.getText());
    }

    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    @NotNull
    public View createChild() {
        View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.brandspace_item_paragraph, this.a, false);
        Views.changeMargin$default(inflate, 0, 0, 0, 0, 10, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        inflate.setTag(R.id.brandspace_about_viewholder, new ParagraphItemViewImpl(inflate));
        return inflate;
    }
}

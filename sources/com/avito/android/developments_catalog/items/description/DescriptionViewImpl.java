package com.avito.android.developments_catalog.items.description;

import android.os.Parcelable;
import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.android.advert_core.advert.ExpandablePanelLayout;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/developments_catalog/items/description/DescriptionViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/description/DescriptionView;", "", "description", "Landroid/os/Parcelable;", "state", "Lcom/avito/android/advert_core/advert/DescriptionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDescription", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/avito/android/advert_core/advert/DescriptionListener;)V", "onSaveState", "()Landroid/os/Parcelable;", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "s", "Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "getDescriptionPanel", "()Lcom/avito/android/advert_core/advert/ExpandablePanelLayout;", "descriptionPanel", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionViewImpl extends BaseViewHolder implements DescriptionView {
    @NotNull
    public final ExpandablePanelLayout s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptionViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.description_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(advert…re_R.id.description_root)");
        this.s = (ExpandablePanelLayout) findViewById;
    }

    @NotNull
    public final ExpandablePanelLayout getDescriptionPanel() {
        return this.s;
    }

    @Override // com.avito.android.developments_catalog.items.description.DescriptionView
    @Nullable
    public Parcelable onSaveState() {
        return this.s.onSaveState();
    }

    @Override // com.avito.android.developments_catalog.items.description.DescriptionView
    public void showDescription(@NotNull String str, @Nullable Parcelable parcelable, @NotNull DescriptionListener descriptionListener) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(descriptionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (parcelable != null) {
            this.s.onRestoreState(parcelable);
        }
        this.s.setOnExpandListener(new ExpandablePanelLayout.ExpandLayoutListener(descriptionListener) { // from class: com.avito.android.developments_catalog.items.description.DescriptionViewImpl$showDescription$2
            public final /* synthetic */ DescriptionListener a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onCollapse(@Nullable View view, @NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "content");
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onCopyText() {
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onExpand(@Nullable View view, @NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "content");
                if (view != null) {
                    view.setVisibility(8);
                }
                this.a.onDescriptionExpanded(null);
            }

            @Override // com.avito.android.advert_core.advert.ExpandablePanelLayout.ExpandLayoutListener
            public void onExpandExist() {
            }
        });
        this.s.setText(str, true);
    }
}

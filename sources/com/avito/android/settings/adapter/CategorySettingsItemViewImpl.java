package com.avito.android.settings.adapter;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.component.subheader.Subheader;
import com.avito.android.component.subheader.SubheaderImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/settings/adapter/CategorySettingsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/settings/adapter/CategorySettingsItemView;", "Lcom/avito/android/component/subheader/Subheader;", "", "hide", "()V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class CategorySettingsItemViewImpl extends BaseViewHolder implements CategorySettingsItemView, Subheader {
    public final /* synthetic */ SubheaderImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategorySettingsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new SubheaderImpl(view);
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.s.hide();
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.s.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.s.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.s.show();
    }
}

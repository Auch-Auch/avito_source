package com.avito.android.component.clickable_info_block;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.component.clickable_info_block.ClickableInfoBlock;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010)\u001a\u00020$\u0012\b\b\u0002\u0010,\u001a\u00020\u0001¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0012\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0012\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u001b\u0010\nJ\u001a\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001d\u0010\u000fJ$\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0001¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010,\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010&¨\u00061"}, d2 = {"Lcom/avito/android/component/clickable_info_block/ProgressClickableInfoBlock;", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "", "enabled", "", "setEnabled", "(Z)V", "", "text", "bindText", "(Ljava/lang/CharSequence;)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "hide", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "drawableRes", "(I)V", "Landroid/content/res/ColorStateList;", "colorList", "setIconTintColor", "(Landroid/content/res/ColorStateList;)V", "setText", "textId", "show", "", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock$Action;", "actions", "Lio/reactivex/rxjava3/core/Maybe;", "showActions", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Maybe;", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "moreButton", "c", "view", "d", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "clickableInfoBlock", AuthSource.BOOKING_ORDER, "progress", "<init>", "(Landroid/view/View;Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressClickableInfoBlock implements ClickableInfoBlock {
    public final View a;
    public final View b;
    public final View c;
    public final ClickableInfoBlock d;

    public ProgressClickableInfoBlock(@NotNull View view, @NotNull ClickableInfoBlock clickableInfoBlock) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(clickableInfoBlock, "clickableInfoBlock");
        this.c = view;
        this.d = clickableInfoBlock;
        View findViewById = view.findViewById(R.id.more);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void bindText(@Nullable CharSequence charSequence) {
        this.d.bindText(charSequence);
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    @NotNull
    public Observable<Unit> clicks() {
        return this.d.clicks();
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.d.hide();
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    public void setEnabled(boolean z) {
        this.d.setEnabled(z);
        if (z) {
            Views.hide(this.b);
            Views.show(this.a);
            return;
        }
        Views.show(this.b);
        Views.hide(this.a);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@DrawableRes int i) {
        this.d.setIcon(i);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.d.setIcon(drawable);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIconTintColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorList");
        this.d.setIconTintColor(colorStateList);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.d.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.d.show();
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    @NotNull
    public Maybe<ClickableInfoBlock.Action> showActions(@NotNull List<ClickableInfoBlock.Action> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        return this.d.showActions(list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressClickableInfoBlock(View view, ClickableInfoBlock clickableInfoBlock, int i, j jVar) {
        this(view, (i & 2) != 0 ? new ClickableInfoBlockImpl(view) : clickableInfoBlock);
    }
}

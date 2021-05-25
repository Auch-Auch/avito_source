package com.avito.android.favorites;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/favorites/FavoriteResourceProviderImpl;", "Lcom/avito/android/favorites/FavoriteResourceProvider;", "", "text", "", "highlightPremium", "Landroid/text/SpannableString;", "getTitle", "(Ljava/lang/String;Z)Landroid/text/SpannableString;", "", "getActiveAlpha", "()F", "getInactiveAlpha", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/content/res/Resources;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteResourceProviderImpl implements FavoriteResourceProvider {
    public final Context a;
    public final Resources b;

    @Inject
    public FavoriteResourceProviderImpl(@NotNull Context context, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = context;
        this.b = resources;
    }

    @Override // com.avito.android.favorites.FavoriteResourceProvider
    public float getActiveAlpha() {
        TypedValue typedValue = new TypedValue();
        this.b.getValue(R.dimen.active_alpha, typedValue, true);
        return typedValue.getFloat();
    }

    @Override // com.avito.android.favorites.FavoriteResourceProvider
    public float getInactiveAlpha() {
        TypedValue typedValue = new TypedValue();
        this.b.getValue(R.dimen.inactive_alpha_old, typedValue, true);
        return typedValue.getFloat();
    }

    @Override // com.avito.android.favorites.FavoriteResourceProvider
    @NotNull
    public SpannableString getTitle(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        SpannableString spannableString = new SpannableString(str);
        if (z) {
            spannableString.setSpan(new BackgroundColorSpan(Contexts.getColorCompat(this.a, com.avito.android.lib.design.avito.R.color.expected_title_highlight)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Contexts.getColorCompat(this.a, com.avito.android.lib.design.avito.R.color.expected_title_color)), 0, str.length(), 33);
        }
        return spannableString;
    }
}

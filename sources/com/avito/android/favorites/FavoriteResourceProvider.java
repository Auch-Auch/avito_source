package com.avito.android.favorites;

import android.text.SpannableString;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/favorites/FavoriteResourceProvider;", "", "", "text", "", "highlightPremium", "Landroid/text/SpannableString;", "getTitle", "(Ljava/lang/String;Z)Landroid/text/SpannableString;", "", "getActiveAlpha", "()F", "getInactiveAlpha", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteResourceProvider {
    float getActiveAlpha();

    float getInactiveAlpha();

    @NotNull
    SpannableString getTitle(@NotNull String str, boolean z);
}

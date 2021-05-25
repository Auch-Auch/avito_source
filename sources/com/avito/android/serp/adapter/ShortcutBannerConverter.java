package com.avito.android.serp.adapter;

import com.avito.android.remote.model.ShortcutBanner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "", "Lcom/avito/android/remote/model/ShortcutBanner;", "shortcut", "", "stringId", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "convert", "(Lcom/avito/android/remote/model/ShortcutBanner;Ljava/lang/String;)Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutBannerConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ ShortcutBannerItem convert$default(ShortcutBannerConverter shortcutBannerConverter, ShortcutBanner shortcutBanner, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0 && (str = shortcutBanner.getId()) == null) {
                    str = "";
                }
                return shortcutBannerConverter.convert(shortcutBanner, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @NotNull
    ShortcutBannerItem convert(@NotNull ShortcutBanner shortcutBanner, @NotNull String str);
}

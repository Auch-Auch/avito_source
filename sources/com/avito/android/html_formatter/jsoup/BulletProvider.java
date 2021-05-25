package com.avito.android.html_formatter.jsoup;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Node;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/BulletProvider;", "", "Lorg/jsoup/nodes/Node;", "node", "", "populateBulletListIfNeeded", "(Lorg/jsoup/nodes/Node;)V", "truncateBulletListIfNeeded", "", "", "getCurrentBulletList", "()Ljava/util/List;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface BulletProvider {
    @NotNull
    List<String> getCurrentBulletList();

    void populateBulletListIfNeeded(@NotNull Node node);

    void truncateBulletListIfNeeded(@NotNull Node node);
}

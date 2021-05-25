package com.avito.android.advert.item.guide;

import android.content.Context;
import com.avito.android.remote.model.guide.GuideLink;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuideView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "showTitle", "(Ljava/lang/String;)V", "hideTitle", "()V", "showTopDivider", "hideTopDivider", "Lcom/avito/android/remote/model/guide/GuideLink;", "link", "Lkotlin/Function0;", "onClick", "showLink", "(Lcom/avito/android/remote/model/guide/GuideLink;Lkotlin/jvm/functions/Function0;)V", "hideLink", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsGuideView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsGuideView advertDetailsGuideView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsGuideView);
        }
    }

    @NotNull
    Context getContext();

    void hideLink();

    void hideTitle();

    void hideTopDivider();

    void showLink(@NotNull GuideLink guideLink, @NotNull Function0<Unit> function0);

    void showTitle(@NotNull String str);

    void showTopDivider();
}

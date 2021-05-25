package com.avito.android.developments_catalog;

import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.developments_catalog.items.contactbar.PhoneCallListener;
import com.avito.conveyor_item.Item;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "", "", "setupToolbar", "()V", "Lio/reactivex/Observable;", "upButtonClicks", "()Lio/reactivex/Observable;", "shareButtonClicks", "", "title", "initContactButton", "(Ljava/lang/String;)V", "contactButtonClicks", "showError", "", "Lcom/avito/conveyor_item/Item;", "items", "bindItems", "(Ljava/util/List;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "Lcom/avito/android/developments_catalog/items/contactbar/PhoneCallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showPhoneCallConfirmation", "(Lcom/avito/android/deep_linking/links/PhoneLink;Lcom/avito/android/developments_catalog/items/contactbar/PhoneCallListener;)V", "message", "Lkotlin/Function0;", "dismissCallback", "showLegalDisclaimerDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DevelopmentsCatalogView {
    void bindItems(@NotNull List<? extends Item> list);

    @NotNull
    Observable<Unit> contactButtonClicks();

    void initContactButton(@Nullable String str);

    void setupToolbar();

    @NotNull
    Observable<Unit> shareButtonClicks();

    void showError();

    void showLegalDisclaimerDialog(@NotNull String str, @NotNull Function0<Unit> function0);

    void showPhoneCallConfirmation(@NotNull PhoneLink phoneLink, @NotNull PhoneCallListener phoneCallListener);

    @NotNull
    Observable<Unit> upButtonClicks();
}

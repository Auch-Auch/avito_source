package com.avito.android.tariff.edit_info.item.button;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "", "<init>", "()V", "DeeplinkAction", "DiscardChangesAction", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction$DeeplinkAction;", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction$DiscardChangesAction;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public abstract class EditButtonAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction$DeeplinkAction;", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeeplinkAction extends EditButtonAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeeplinkAction(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction$DiscardChangesAction;", "Lcom/avito/android/tariff/edit_info/item/button/EditButtonAction;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class DiscardChangesAction extends EditButtonAction {
        @NotNull
        public static final DiscardChangesAction INSTANCE = new DiscardChangesAction();

        public DiscardChangesAction() {
            super(null);
        }
    }

    public EditButtonAction() {
    }

    public EditButtonAction(j jVar) {
    }
}

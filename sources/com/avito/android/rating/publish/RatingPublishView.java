package com.avito.android.rating.publish;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J+\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00020\bj\u0002`\tH&¢\u0006\u0004\b\u000b\u0010\fJU\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishView;", "", "", "showProgress", "()V", "hideProgress", "", "message", "Lkotlin/Function0;", "Lcom/avito/android/util/ActionHandler;", "dismissAction", "showSnackbar", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "title", "", "cancelable", "actionListener", "actionTitle", "closeListener", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingPublishView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a extends Lambda implements Function0<Unit> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                return Unit.INSTANCE;
            }
        }

        public static /* synthetic */ void showErrorDialog$default(RatingPublishView ratingPublishView, String str, String str2, boolean z, Function0 function0, String str3, Function0 function02, int i, Object obj) {
            if (obj == null) {
                boolean z2 = (i & 4) != 0 ? true : z;
                if ((i & 16) != 0) {
                    str3 = null;
                }
                ratingPublishView.showErrorDialog(str, str2, z2, function0, str3, function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorDialog");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.rating.publish.RatingPublishView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showSnackbar$default(RatingPublishView ratingPublishView, String str, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = a.a;
                }
                ratingPublishView.showSnackbar(str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSnackbar");
        }
    }

    void hideProgress();

    void showErrorDialog(@NotNull String str, @NotNull String str2, boolean z, @Nullable Function0<Unit> function0, @Nullable String str3, @Nullable Function0<Unit> function02);

    void showProgress();

    void showSnackbar(@NotNull String str, @NotNull Function0<Unit> function0);
}

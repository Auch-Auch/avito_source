package com.avito.android.dialog;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.UserDialog;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J?\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJC\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\rJ3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\n\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/dialog/DialogPresenter;", "", "", "title", "message", "positiveButtonText", "", "cancelable", "Lio/reactivex/Maybe;", "", "showDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "negativeButtonText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/deep_linking/links/DeepLink;", "(Lcom/avito/android/remote/model/UserDialog;)Lio/reactivex/Maybe;", "Lio/reactivex/rxjava3/core/Maybe;", "showDialog3", "(Lcom/avito/android/remote/model/UserDialog;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/model/Action;", "action", "wrapActionToDialog", "(Lcom/avito/android/remote/model/Action;)Lio/reactivex/rxjava3/core/Maybe;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface DialogPresenter {
    @NotNull
    Maybe<DeepLink> showDialog(@NotNull UserDialog userDialog);

    @NotNull
    Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z);

    @NotNull
    Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, @Nullable String str3, boolean z);

    @NotNull
    Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, boolean z);

    @NotNull
    io.reactivex.rxjava3.core.Maybe<DeepLink> showDialog3(@NotNull UserDialog userDialog);

    @NotNull
    io.reactivex.rxjava3.core.Maybe<DeepLink> wrapActionToDialog(@NotNull Action action);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Maybe showDialog$default(DialogPresenter dialogPresenter, String str, String str2, String str3, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    z = true;
                }
                return dialogPresenter.showDialog(str, str2, str3, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }

        public static /* synthetic */ Maybe showDialog$default(DialogPresenter dialogPresenter, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    z = true;
                }
                return dialogPresenter.showDialog(str, str2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
    }
}

package com.avito.android.select.group_select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J5\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectView;", "", "", "title", "", "isSelected", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addSelectOption", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/select/group_select/GroupSelectItemViewPresenter;", "presenter", "addSelectGroup", "(Lcom/avito/android/select/group_select/GroupSelectItemViewPresenter;)V", "Lkotlin/Function0;", "setApplyListener", "(Lkotlin/jvm/functions/Function0;)V", "clearSelection", "()V", "Companion", "select_release"}, k = 1, mv = {1, 4, 2})
public interface GroupSelectView {
    @NotNull
    public static final Companion Companion = Companion.c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectView$Companion;", "", "", AuthSource.BOOKING_ORDER, "I", "getLayoutOld", "()I", "layoutOld", AuthSource.SEND_ABUSE, "getLayout", "layout", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final int a = R.layout.group_select_dialog;
        public static final int b = R.layout.group_select_dialog_old;
        public static final /* synthetic */ Companion c = new Companion();

        public final int getLayout() {
            return a;
        }

        public final int getLayoutOld() {
            return b;
        }
    }

    void addSelectGroup(@NotNull GroupSelectItemViewPresenter groupSelectItemViewPresenter);

    void addSelectOption(@NotNull String str, boolean z, @Nullable Function1<? super Boolean, Unit> function1);

    void clearSelection();

    void setApplyListener(@Nullable Function0<Unit> function0);
}

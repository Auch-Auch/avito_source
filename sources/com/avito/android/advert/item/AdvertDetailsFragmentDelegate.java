package com.avito.android.advert.item;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "", "Landroidx/fragment/app/Fragment;", "fragment", "()Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function1;", "Landroid/content/Context;", "", "block", "runBlockWithContext", "(Lkotlin/jvm/functions/Function1;)V", "", "e", "", "showToast", "handleError", "(Ljava/lang/Throwable;Z)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFragmentDelegate {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void handleError$default(AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, Throwable th, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                advertDetailsFragmentDelegate.handleError(th, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleError");
        }
    }

    @NotNull
    FragmentManager childFragmentManager();

    @NotNull
    Fragment fragment();

    @Nullable
    FragmentManager fragmentManager();

    void handleError(@Nullable Throwable th, boolean z);

    void runBlockWithContext(@NotNull Function1<? super Context, Unit> function1);
}

package com.avito.android.user_advert.advert.switcher_block;

import a2.b.a.a.a;
import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", "", "<init>", "()V", "Progress", "Specified", HttpHeaders.WARNING, "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Progress;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Specified;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Warning;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public abstract class SwitcherState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Progress;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Progress extends SwitcherState {
        @NotNull
        public static final Progress INSTANCE = new Progress();

        public Progress() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Specified;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", "", "component1", "()Z", "isChecked", "copy", "(Z)Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Specified;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "<init>", "(Z)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Specified extends SwitcherState {
        public final boolean a;

        public Specified(boolean z) {
            super(null);
            this.a = z;
        }

        public static /* synthetic */ Specified copy$default(Specified specified, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = specified.a;
            }
            return specified.copy(z);
        }

        public final boolean component1() {
            return this.a;
        }

        @NotNull
        public final Specified copy(boolean z) {
            return new Specified(z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Specified) && this.a == ((Specified) obj).a;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isChecked() {
            return this.a;
        }

        @NotNull
        public String toString() {
            return a.B(a.L("Specified(isChecked="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B5\u0012,\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0002\b\t¢\u0006\u0004\b\u001d\u0010\u001eJ6\u0010\n\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0002\b\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\r\u001a\u00020\u00002.\b\u0002\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0002\b\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R?\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0002\b\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Warning;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", "Lkotlin/Function2;", "Lcom/avito/android/lib/design/dialog/Dialog$Config;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "", "Lkotlin/ExtensionFunctionType;", "component1", "()Lkotlin/jvm/functions/Function2;", Navigation.CONFIG, "copy", "(Lkotlin/jvm/functions/Function2;)Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState$Warning;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function2;", "getConfig", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Warning extends SwitcherState {
        @NotNull
        public final Function2<Dialog.Config, DialogInterface, Unit> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super com.avito.android.lib.design.dialog.Dialog$Config, ? super android.content.DialogInterface, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Warning(@NotNull Function2<? super Dialog.Config, ? super DialogInterface, Unit> function2) {
            super(null);
            Intrinsics.checkNotNullParameter(function2, Navigation.CONFIG);
            this.a = function2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_advert.advert.switcher_block.SwitcherState$Warning */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Warning copy$default(Warning warning, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                function2 = warning.a;
            }
            return warning.copy(function2);
        }

        @NotNull
        public final Function2<Dialog.Config, DialogInterface, Unit> component1() {
            return this.a;
        }

        @NotNull
        public final Warning copy(@NotNull Function2<? super Dialog.Config, ? super DialogInterface, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, Navigation.CONFIG);
            return new Warning(function2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Warning) && Intrinsics.areEqual(this.a, ((Warning) obj).a);
            }
            return true;
        }

        @NotNull
        public final Function2<Dialog.Config, DialogInterface, Unit> getConfig() {
            return this.a;
        }

        public int hashCode() {
            Function2<Dialog.Config, DialogInterface, Unit> function2 = this.a;
            if (function2 != null) {
                return function2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Warning(config=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public SwitcherState() {
    }

    public SwitcherState(j jVar) {
    }
}

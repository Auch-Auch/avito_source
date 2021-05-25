package com.avito.android.lib.util.inflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005()*+,B\t\b\u0002¢\u0006\u0004\b&\u0010'JL\u0010\r\u001a\u00020\f*\u00020\u000226\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u0017*\u00020\u00162\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f¨\u0006-"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater;", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Landroid/util/AttributeSet;", "attrs", "Landroid/view/View;", "func", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "create", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "baseContext", "", "themeOverrideRes", "Landroid/view/LayoutInflater$Factory2;", "factory", "createThemeContext", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/LayoutInflater$Factory2;)Landroid/content/Context;", "Landroidx/appcompat/app/AppCompatActivity;", "", "attachLayoutInflaterFactory", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/LayoutInflater$Factory2;)V", AuthSource.SEND_ABUSE, "(Landroid/content/Context;)Landroid/view/LayoutInflater$Factory2;", "c", "Ljava/lang/String;", "getTEXT_VIEW", "()Ljava/lang/String;", "TEXT_VIEW", "getAVITO_BUTTON", "AVITO_BUTTON", AuthSource.BOOKING_ORDER, "getINPUT", "INPUT", "<init>", "()V", "AppCompatDelegateAdapter", "CompositeFactory", "Factory", "FactoryData", "FactoryMerger", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoLayoutInflater {
    @NotNull
    public static final AvitoLayoutInflater INSTANCE = new AvitoLayoutInflater();
    @NotNull
    public static final String a;
    @NotNull
    public static final String b;
    @NotNull
    public static final String c = "TextView";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ3\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$AppCompatDelegateAdapter;", "Landroid/view/LayoutInflater$Factory2;", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Landroid/view/View;", "onCreateView", "(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "parent", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "Landroidx/appcompat/app/AppCompatDelegate;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatDelegate;", "delegate", "<init>", "(Landroidx/appcompat/app/AppCompatDelegate;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppCompatDelegateAdapter implements LayoutInflater.Factory2 {
        public final AppCompatDelegate a;

        public AppCompatDelegateAdapter(@NotNull AppCompatDelegate appCompatDelegate) {
            Intrinsics.checkNotNullParameter(appCompatDelegate, "delegate");
            this.a = appCompatDelegate;
        }

        @Override // android.view.LayoutInflater.Factory
        @Nullable
        public View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            return onCreateView(null, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory2
        @Nullable
        public View onCreateView(@Nullable View view, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            return this.a.createView(null, str, context, attributeSet);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$CompositeFactory;", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "", "name", "Landroid/view/LayoutInflater$Factory2;", "factory", "registerFactory", "(Ljava/lang/String;Landroid/view/LayoutInflater$Factory2;)Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$CompositeFactory;", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "factoryData", "(Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;)Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$CompositeFactory;", "", "isAllowed", "registerFactoryIf", "(Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;Z)Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$CompositeFactory;", "clearFactories", "()Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$CompositeFactory;", "Landroid/view/View;", "parent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "onCreateView", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "", "factories", "Ljava/util/Map;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class CompositeFactory implements Factory {
        private final Map<String, LayoutInflater.Factory2> factories = new LinkedHashMap();

        @NotNull
        public final CompositeFactory clearFactories() {
            this.factories.clear();
            return this;
        }

        @Override // com.avito.android.lib.util.inflater.AvitoLayoutInflater.Factory, android.view.LayoutInflater.Factory
        @Nullable
        public View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            return Factory.DefaultImpls.onCreateView(this, str, context, attributeSet);
        }

        @NotNull
        public final CompositeFactory registerFactory(@NotNull String str, @NotNull LayoutInflater.Factory2 factory2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(factory2, "factory");
            this.factories.put(str, factory2);
            return this;
        }

        @NotNull
        public final CompositeFactory registerFactoryIf(@NotNull FactoryData factoryData, boolean z) {
            Intrinsics.checkNotNullParameter(factoryData, "factoryData");
            if (z) {
                this.factories.put(factoryData.getName(), factoryData);
            }
            return this;
        }

        @Override // android.view.LayoutInflater.Factory2
        @Nullable
        public View onCreateView(@Nullable View view, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            LayoutInflater.Factory2 factory2 = this.factories.get(str);
            if (factory2 != null) {
                return factory2.onCreateView(view, str, context, attributeSet);
            }
            return null;
        }

        @NotNull
        public final CompositeFactory registerFactory(@NotNull FactoryData factoryData) {
            Intrinsics.checkNotNullParameter(factoryData, "factoryData");
            this.factories.put(factoryData.getName(), factoryData);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "Landroid/view/LayoutInflater$Factory2;", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Landroid/view/View;", "onCreateView", "(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface Factory extends LayoutInflater.Factory2 {
        @NotNull
        public static final Companion Companion = Companion.a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jv\u0010\u000e\u001a\u00020\r2d\u0010\f\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory$Companion;", "", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "parent", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "func", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "invoke", "(Lkotlin/jvm/functions/Function4;)Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public static final /* synthetic */ Companion a = new Companion();

            @NotNull
            public final Factory invoke(@NotNull Function4<? super View, ? super String, ? super Context, ? super AttributeSet, ? extends View> function4) {
                Intrinsics.checkNotNullParameter(function4, "func");
                return new AvitoLayoutInflater$Factory$Companion$invoke$1(function4);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            @Nullable
            public static View onCreateView(@NotNull Factory factory, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(attributeSet, "attrs");
                return factory.onCreateView(null, str, context, attributeSet);
            }
        }

        @Override // android.view.LayoutInflater.Factory
        @Nullable
        View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J`\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0010\b\u0001\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0010\b\u0001\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u0010\b\u0001\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u00072\u0010\b\u0001\u0010\n\u001a\n \u0003*\u0004\u0018\u00010\t0\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0010\b\u0001\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u0010\b\u0001\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00070\u00072\u0010\b\u0001\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\t0\tH\u0001¢\u0006\u0004\b\u000b\u0010\rR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "Landroid/view/LayoutInflater$Factory2;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "p0", "", "p1", "Landroid/content/Context;", "p2", "Landroid/util/AttributeSet;", "p3", "onCreateView", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "factory", "<init>", "(Ljava/lang/String;Landroid/view/LayoutInflater$Factory2;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class FactoryData implements LayoutInflater.Factory2 {
        @NotNull
        public final String a;
        public final /* synthetic */ LayoutInflater.Factory2 b;

        public FactoryData(@NotNull String str, @NotNull LayoutInflater.Factory2 factory2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(factory2, "factory");
            this.b = factory2;
            this.a = str;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        @Override // android.view.LayoutInflater.Factory2
        @RecentlyNullable
        public View onCreateView(@RecentlyNullable View view, @RecentlyNonNull String str, @RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
            return this.b.onCreateView(view, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        @RecentlyNullable
        public View onCreateView(@RecentlyNonNull String str, @RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
            return this.b.onCreateView(str, context, attributeSet);
        }
    }

    public static final class a extends Lambda implements Function4<View, String, Context, AttributeSet, View> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, Function2 function2) {
            super(4);
            this.a = str;
            this.b = function2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function4
        public View invoke(View view, String str, Context context, AttributeSet attributeSet) {
            String str2 = str;
            Context context2 = context;
            AttributeSet attributeSet2 = attributeSet;
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(attributeSet2, "attrs");
            if (Intrinsics.areEqual(str2, this.a)) {
                return (View) this.b.invoke(context2, attributeSet2);
            }
            return null;
        }
    }

    static {
        String name = Button.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Button::class.java.name");
        a = name;
        String name2 = Input.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "Input::class.java.name");
        b = name2;
    }

    public static /* synthetic */ void attachLayoutInflaterFactory$default(AvitoLayoutInflater avitoLayoutInflater, AppCompatActivity appCompatActivity, LayoutInflater.Factory2 factory2, int i, Object obj) {
        if ((i & 1) != 0) {
            factory2 = null;
        }
        avitoLayoutInflater.attachLayoutInflaterFactory(appCompatActivity, factory2);
    }

    public static /* synthetic */ Context createThemeContext$default(AvitoLayoutInflater avitoLayoutInflater, Context context, Integer num, LayoutInflater.Factory2 factory2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            factory2 = null;
        }
        return avitoLayoutInflater.createThemeContext(context, num, factory2);
    }

    public final LayoutInflater.Factory2 a(Context context) {
        String stringByAttr;
        if (!(context == null || (stringByAttr = Contexts.getStringByAttr(context, R.attr.layoutInflaterFactory)) == null)) {
            try {
                Class<?> cls = Class.forName(stringByAttr);
                Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(layoutInflaterFactoryClassName)");
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance != null) {
                    return (LayoutInflater.Factory2) newInstance;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final void attachLayoutInflaterFactory(@NotNull AppCompatActivity appCompatActivity, @Nullable LayoutInflater.Factory2 factory2) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$attachLayoutInflaterFactory");
        LayoutInflater from = LayoutInflater.from(appCompatActivity);
        if (factory2 != null) {
            Intrinsics.checkNotNullExpressionValue(from, "layoutInflater");
            if (from.getFactory2() != null) {
                throw new IllegalStateException("A factory has already been set on this LayoutInflater");
            }
        }
        Intrinsics.checkNotNullExpressionValue(from, "layoutInflater");
        if (from.getFactory2() == null) {
            LayoutInflater.Factory2 a3 = a(appCompatActivity);
            if (factory2 != null) {
                a3 = new FactoryMerger(factory2, factory2, a3, a3);
            }
            AppCompatDelegate delegate = appCompatActivity.getDelegate();
            Intrinsics.checkNotNullExpressionValue(delegate, "delegate");
            AppCompatDelegateAdapter appCompatDelegateAdapter = new AppCompatDelegateAdapter(delegate);
            from.setFactory2(new FactoryMerger(a3, a3, appCompatDelegateAdapter, appCompatDelegateAdapter));
        }
    }

    @NotNull
    public final FactoryData create(@NotNull String str, @NotNull Function2<? super Context, ? super AttributeSet, ? extends View> function2) {
        Intrinsics.checkNotNullParameter(str, "$this$create");
        Intrinsics.checkNotNullParameter(function2, "func");
        return new FactoryData(str, Factory.Companion.invoke(new a(str, function2)));
    }

    @NotNull
    public final Context createThemeContext(@NotNull Context context, @Nullable Integer num, @Nullable LayoutInflater.Factory2 factory2) {
        ContextThemeWrapper contextThemeWrapper;
        Intrinsics.checkNotNullParameter(context, "baseContext");
        if (num != null) {
            contextThemeWrapper = new ContextThemeWrapper(context, num.intValue());
        } else {
            contextThemeWrapper = new ContextThemeWrapper(context, 0);
        }
        LayoutInflater from = LayoutInflater.from(contextThemeWrapper);
        LayoutInflater.Factory2 a3 = a(contextThemeWrapper);
        Intrinsics.checkNotNullExpressionValue(from, "layoutInflater");
        from.setFactory2(new FactoryMerger(factory2, factory2, a3, a3));
        return contextThemeWrapper;
    }

    @NotNull
    public final String getAVITO_BUTTON() {
        return a;
    }

    @NotNull
    public final String getINPUT() {
        return b;
    }

    @NotNull
    public final String getTEXT_VIEW() {
        return c;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ3\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryMerger;", "Landroid/view/LayoutInflater$Factory2;", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Landroid/view/View;", "onCreateView", "(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "parent", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "Landroid/view/LayoutInflater$Factory;", "c", "Landroid/view/LayoutInflater$Factory;", "currentFactory", "d", "Landroid/view/LayoutInflater$Factory2;", "currentFactory2", AuthSource.SEND_ABUSE, "targetFactory", AuthSource.BOOKING_ORDER, "targetFactory2", "<init>", "(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class FactoryMerger implements LayoutInflater.Factory2 {
        public final LayoutInflater.Factory a;
        public final LayoutInflater.Factory2 b;
        public final LayoutInflater.Factory c;
        public final LayoutInflater.Factory2 d;

        public FactoryMerger(@Nullable LayoutInflater.Factory factory, @Nullable LayoutInflater.Factory2 factory2, @Nullable LayoutInflater.Factory factory3, @Nullable LayoutInflater.Factory2 factory22) {
            this.a = factory;
            this.b = factory2;
            this.c = factory3;
            this.d = factory22;
        }

        @Override // android.view.LayoutInflater.Factory
        @Nullable
        public View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            View onCreateView;
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            LayoutInflater.Factory factory = this.a;
            if (factory != null && (onCreateView = factory.onCreateView(str, context, attributeSet)) != null) {
                return onCreateView;
            }
            LayoutInflater.Factory factory2 = this.c;
            if (factory2 != null) {
                return factory2.onCreateView(str, context, attributeSet);
            }
            return null;
        }

        @Override // android.view.LayoutInflater.Factory2
        @Nullable
        public View onCreateView(@Nullable View view, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
            View view2;
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            LayoutInflater.Factory2 factory2 = this.b;
            if (factory2 == null || (view2 = factory2.onCreateView(view, str, context, attributeSet)) == null) {
                LayoutInflater.Factory factory = this.a;
                view2 = factory != null ? factory.onCreateView(str, context, attributeSet) : null;
            }
            if (view2 == null) {
                LayoutInflater.Factory2 factory22 = this.d;
                view2 = factory22 != null ? factory22.onCreateView(view, str, context, attributeSet) : null;
            }
            if (view2 != null) {
                return view2;
            }
            LayoutInflater.Factory factory3 = this.c;
            if (factory3 != null) {
                return factory3.onCreateView(str, context, attributeSet);
            }
            return null;
        }
    }
}

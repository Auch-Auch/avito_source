package com.avito.android.messenger.channels.mvi.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import dagger.Reusable;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Reusable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B,\b\u0007\u0012!\u0010\r\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\n0\b¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R1\u0010\r\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\n0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "viewModelProviderMap", "<init>", "(Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ViewModelFactory implements ViewModelProvider.Factory {
    public final Map<Class<?>, Provider<ViewModel>> a;

    @Inject
    public ViewModelFactory(@NotNull Map<Class<?>, Provider<ViewModel>> map) {
        Intrinsics.checkNotNullParameter(map, "viewModelProviderMap");
        this.a = map;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        T t;
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Provider<ViewModel> provider = this.a.get(cls);
        if (provider != null && (t = (T) provider.get()) != null) {
            return t;
        }
        throw new IllegalArgumentException("ViewModel Provider doesn't exist for " + cls + '!');
    }
}

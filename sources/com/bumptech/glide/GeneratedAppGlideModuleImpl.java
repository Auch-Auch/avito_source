package com.bumptech.glide;

import a2.d.a.a;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.RequestManagerRetriever;
import java.util.Collections;
import java.util.Set;
import ru.sravni.android.bankproduct.utils.svg.SvgModule;
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    public final SvgModule a = new SvgModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        this.a.applyOptions(context, glideBuilder);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public RequestManagerRetriever.RequestManagerFactory b() {
        return new a();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return this.a.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        this.a.registerComponents(context, glide, registry);
    }
}

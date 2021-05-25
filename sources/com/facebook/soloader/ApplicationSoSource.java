package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
public class ApplicationSoSource extends SoSource {
    public Context a;
    public int b;
    public DirectorySoSource c;

    public ApplicationSoSource(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            this.a = context;
        }
        this.b = i;
        this.c = new DirectorySoSource(new File(this.a.getApplicationInfo().nativeLibraryDir), i);
    }

    public static File getNativeLibDirFromContext(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        this.c.addToLdLibraryPath(collection);
    }

    public boolean checkAndMaybeUpdate() throws IOException {
        File file = this.c.soDirectory;
        Context updatedContext = getUpdatedContext();
        File nativeLibDirFromContext = getNativeLibDirFromContext(updatedContext);
        if (file.equals(nativeLibDirFromContext)) {
            return false;
        }
        String str = "Native library directory updated from " + file + " to " + nativeLibDirFromContext;
        int i = this.b | 1;
        this.b = i;
        DirectorySoSource directorySoSource = new DirectorySoSource(nativeLibDirFromContext, i);
        this.c = directorySoSource;
        directorySoSource.prepare(this.b);
        this.a = updatedContext;
        return true;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        return this.c.getLibraryDependencies(str);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        return this.c.getLibraryPath(str);
    }

    public Context getUpdatedContext() {
        try {
            Context context = this.a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.c.loadLibrary(str, i, threadPolicy);
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        this.c.prepare(i);
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return this.c.toString();
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        return this.c.unpackLibrary(str);
    }
}

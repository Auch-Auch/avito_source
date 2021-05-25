package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.e0;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;
public abstract class AssetPackLocation {
    public static final AssetPackLocation a = new e0(1, null, null);

    public abstract String assetsPath();

    @AssetPackStorageMethod
    public abstract int packStorageMethod();

    public abstract String path();
}

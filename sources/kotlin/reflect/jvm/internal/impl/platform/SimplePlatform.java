package kotlin.reflect.jvm.internal.impl.platform;

import org.jetbrains.annotations.NotNull;
public abstract class SimplePlatform {
    @NotNull
    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    @NotNull
    public TargetPlatformVersion getTargetPlatformVersion() {
        return null;
    }

    @NotNull
    public String toString() {
        String targetName = getTargetName();
        if (!(targetName.length() > 0)) {
            return null;
        }
        return ((String) null) + " (" + targetName + ')';
    }
}

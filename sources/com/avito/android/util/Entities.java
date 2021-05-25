package com.avito.android.util;

import com.avito.android.remote.model.Entity;
public class Entities {
    public static boolean areEqual(Entity entity, Entity entity2) {
        boolean z = true;
        if ((entity2 == null) || (entity == null)) {
            return false;
        }
        boolean z2 = entity2.getId() == null;
        if (entity.getId() != null) {
            z = false;
        }
        if (z || z2) {
            return false;
        }
        return entity2.getId().equals(entity.getId());
    }
}

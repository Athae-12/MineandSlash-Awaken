package com.awaken.mineandslash.registers.common;

import com.robertx22.library_of_exile.deferred.RegObj;
import com.awaken.mineandslash.summons.ZombieSummon;
import com.awaken.mineandslash.summons.WitherSkeletonSummon;
import com.robertx22.mine_and_slash.mmorpg.registers.deferred_wrapper.Def;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class SlashEntities {
    public static RegObj<EntityType<WitherSkeletonSummon>> WITHER_SKELETON = SlashEntities
            .mob(WitherSkeletonSummon::new, EntityType.WITHER_SKELETON, "wither_skeleton_summon");
    public static RegObj<EntityType<ZombieSummon>> ZOMBIE = SlashEntities.mob(ZombieSummon::new, EntityType.ZOMBIE,
            "zombie_summon");

    private static <T extends Entity> RegObj<EntityType<T>> mob(EntityType.EntityFactory<T> factory, EntityType like,
            String id) {
        RegObj<EntityType> def = Def.entity(id, () -> EntityType.Builder.of(factory, MobCategory.MISC)
                .sized(like.getWidth(), like.getHeight()).setTrackingRange(10).build(id));
        return def;
    }

    public static void init() {
    }
}

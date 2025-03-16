package com.awaken.mineandslash.spells.actions;

import com.robertx22.mine_and_slash.database.data.spells.components.SpellAction;
import com.robertx22.mine_and_slash.database.data.spells.spell_classes.SpellCtx;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;

public class SummonPetAction extends SpellAction {
    public static final String ENTITY_TYPE = "entity_type";
    public static final String DURATION = "duration";
    public static final String COUNT = "count";

    public static SummonPetAction create(EntityType<?> entityType, int duration, int count) {
        SummonPetAction action = new SummonPetAction();
        action.addData(ENTITY_TYPE, entityType.getRegistryName().toString());
        action.addData(DURATION, duration);
        action.addData(COUNT, count);
        return action;
    }

    @Override
    public void activate(SpellCtx ctx) {
        Level world = ctx.caster.level;
        EntityType<?> entityType = EntityType.byString(ctx.data.getString(ENTITY_TYPE)).orElse(null);
        int duration = ctx.data.getInt(DURATION);
        int count = ctx.data.getInt(COUNT);

        if (entityType != null) {
            for (int i = 0; i < count; i++) {
                Mob entity = (Mob) entityType.create(world);
                if (entity != null) {
                    entity.setPos(ctx.caster.getX(), ctx.caster.getY(), ctx.caster.getZ());
                    entity.finalizeSpawn(world, world.getCurrentDifficultyAt(entity.blockPosition()),
                            MobSpawnType.MOB_SUMMONED, null, null);
                    world.addFreshEntity(entity);
                }
            }
        }
    }

    @Override
    public String GUID() {
        return "summon_pet";
    }
}

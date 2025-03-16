package com.awaken.mineandslash.aoe_data.database.spells;

import com.robertx22.library_of_exile.registry.ExileRegistryInit;
import com.robertx22.mine_and_slash.aoe_data.database.spells.SpellBuilder;
import com.robertx22.mine_and_slash.aoe_data.database.spells.SpellCalcs;
import com.robertx22.mine_and_slash.aoe_data.database.spells.schools.PetSpells;
import com.robertx22.mine_and_slash.aoe_data.database.spells.schools.SummonSpells;
import com.robertx22.mine_and_slash.database.data.spells.components.SpellConfiguration;
import com.robertx22.mine_and_slash.database.data.spells.components.actions.SpellAction;
import com.robertx22.mine_and_slash.database.data.spells.components.selectors.TargetSelector;
import com.robertx22.mine_and_slash.database.data.stats.types.summon.SummonHealth;
import com.robertx22.mine_and_slash.mmorpg.registers.common.SlashEntities;
import com.robertx22.mine_and_slash.tags.all.SpellTags;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.PlayStyle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;

import java.util.Arrays;

public class Spells implements ExileRegistryInit {
    public void registerAll() {
        // Register the new summon zombie spell with level-based effects
        SpellBuilder.of(SummonSpells.SUMMON_ZOMBIE, PlayStyle.INT, SpellConfiguration.Builder.nonInstant(40, 1200, 30)
                .setSummonBasicAttack(PetSpells.ZOMBIE).setSummonType(SummonType.UNDEAD), "Summon Zombie",
                Arrays.asList(SpellTags.summon, SpellTags.damage, SpellTags.has_pet_ability, SpellTags.PHYSICAL))
                .manualDesc("Summon a Zombie to aid you in combat.")
                .summons((EntityType) SlashEntities.ZOMBIE.get(), 2400, 1, SummonType.UNDEAD)
                .levelReq(1)
                .addStat(OffenseStats.SUMMON_DAMAGE.get().mod(10.0f, 50.0f))
                .addStat(new SummonHealth().mod(10.0f, 100.0f))
                .addLevelBasedEffect(5, SpellAction.createSummonCountModifier(1))
                .addLevelBasedEffect(10, SpellAction.createSummonCountModifier(2))
                .addLevelBasedEffect(15, SpellAction.createSummonCountModifier(3))
                .build();

        // Register the new summon wither skeleton spell with level-based effects
        SpellBuilder
                .of(SummonSpells.SUMMON_WITHER_SKELETON, PlayStyle.INT,
                        SpellConfiguration.Builder.nonInstant(40, 1200, 30)
                                .setSummonBasicAttack(PetSpells.WITHER_SKELETON).setSummonType(SummonType.UNDEAD),
                        "Summon Wither Skeleton",
                        Arrays.asList(SpellTags.summon, SpellTags.damage, SpellTags.has_pet_ability,
                                SpellTags.PHYSICAL))
                .manualDesc("Summon a Wither Skeleton wearing armor and holding a sword to aid you in combat.")
                .summons((EntityType) SlashEntities.WITHER_SKELETON.get(), 3600, 1, SummonType.UNDEAD)
                .levelReq(20)
                .addStat(OffenseStats.SUMMON_DAMAGE.get().mod(10.0f, 50.0f))
                .addStat(new SummonHealth().mod(10.0f, 100.0f))
                .addLevelBasedEffect(5, SpellAction.createSummonCountModifier(1))
                .addLevelBasedEffect(10, SpellAction.createSummonCountModifier(2))
                .addLevelBasedEffect(15, SpellAction.createSummonCountModifier(3))
                .build();
    }
}

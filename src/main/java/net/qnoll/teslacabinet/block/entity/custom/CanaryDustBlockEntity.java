package net.qnoll.teslacabinet.block.entity.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.qnoll.teslacabinet.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CanaryDustBlockEntity extends BlockEntity {

    private static final int RADIUS = 2;
    private static final int EFFECT_DURATION = 200;
    private static final int EFFECT_AMPLIFIER = 0;

    public CanaryDustBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CANARY_DUST_BE.get(), pos, state);
    }

    public void tickServer() {
        if (this.level == null) return;

        AABB area = new AABB(worldPosition).inflate(RADIUS);
        List<LivingEntity> entities = this.level.getEntitiesOfClass(LivingEntity.class, area);

        for (LivingEntity entity : entities) {
            if (!entity.isDeadOrDying()) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.WITHER,
                        EFFECT_DURATION,
                        EFFECT_AMPLIFIER,
                        true,
                        true
                ));
            }
        }
    }

    public void tickClient() {
        if (this.level == null) return;

        // Only if a player is nearby
        AABB area = new AABB(worldPosition).inflate(2);
        List<Player> players = this.level.getEntitiesOfClass(Player.class, area);

        if (!players.isEmpty()) {
            RandomSource random = this.level.random;

            if (random.nextFloat() < 0.02f) {
                this.level.playLocalSound(
                        worldPosition.getX() + 0.5,
                        worldPosition.getY() + 0.5,
                        worldPosition.getZ() + 0.5,
                        SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS.value(),
                        SoundSource.BLOCKS,
                        0.5f,
                        1.0f,
                        false
                );
            }
        }
    }


}
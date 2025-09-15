package net.qnoll.teslacabinet.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class CanaryDustBlockItem extends BlockItem {

    private static final int EFFECT_DURATION = 40;
    private static final int EFFECT_AMPLIFIER = 0;

    public CanaryDustBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, net.minecraft.world.level.Level level,
                              net.minecraft.world.entity.Entity entity, int slot, boolean isSelected) {
        if (level.isClientSide) return;

        if (entity instanceof Player player) {
            boolean holdingMain = player.getMainHandItem() == stack;
            boolean holdingOff = player.getOffhandItem() == stack;

            if (holdingMain || holdingOff) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.WITHER,
                        EFFECT_DURATION,
                        EFFECT_AMPLIFIER,
                        true,
                        true
                ));
            }
        }
    }
}
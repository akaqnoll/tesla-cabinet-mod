package net.qnoll.teslacabinet.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CanaryDustItem extends Item {
    public CanaryDustItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!(pEntity instanceof LivingEntity living)) return;

        boolean inMainHand = living.getMainHandItem() == pStack;
        boolean inOffHand = living.getOffhandItem() == pStack;

        if (inMainHand || inOffHand) {
            living.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 0, true, false));
        }
    }
}

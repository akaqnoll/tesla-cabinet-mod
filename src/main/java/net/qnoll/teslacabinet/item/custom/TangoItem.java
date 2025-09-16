package net.qnoll.teslacabinet.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.qnoll.teslacabinet.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TangoItem extends Item {
    public TangoItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player == null) return InteractionResult.PASS;

        if (level.getBlockState(pos).getBlock() instanceof SaplingBlock) {
            if (!level.isClientSide) {
                level.removeBlock(pos, false);

                player.getFoodData().eat(4, 0.3F); // 4 hunger points, 0.3 saturation

                level.playSound(null, pos, ModSounds.TANGO_TREE_SOUND.get(), SoundSource.PLAYERS, 0.3F, 1.0F);
                level.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 1.0F, 1.0F);

                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20 * 20, 0));

                stack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, net.minecraft.world.InteractionHand hand) {
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.tango.lore")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        } else {
            pTooltip.add(Component.translatable("tooltip.teslacabinet.shift_hint")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }


        super.appendHoverText(pStack, pLevel, pTooltip, pIsAdvanced);
    }
}

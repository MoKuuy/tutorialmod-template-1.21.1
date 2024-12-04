package com.bession.tutorialmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Prospector extends Item {
    public Prospector(Settings settings) {
        super(new Settings().maxDamage(127));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient()) {
            boolean foundBlock = false;
            if (!Screen.hasShiftDown()) {
                //模糊搜索
                for (int i = 0; i <= pos.getY() + 64; i++) {
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            BlockPos pos1 = pos.down(i).north(j).east(k);
                            BlockState blockState = world.getBlockState(pos1);
                            String name = blockState.getBlock().getName().getString();

                            if (isRightBlock(blockState)) {
                                player.sendMessage(Text.of("Found" + name + "!"));
                                foundBlock = true;
                                break;
                            }
                        }
                    }
                }
                if (!foundBlock) {
                    player.sendMessage(Text.of("No Ore found!"));
                }
            } else {
                //精确查找
                for (int i = 0; i <= pos.getY() + 64; i++) {
                    BlockPos pos1 = pos.down(i);
                    BlockState blockState = world.getBlockState(pos1);
                    String name = blockState.getBlock().getName().getString();
                    if (isRightBlock(blockState)) {
                        player.sendMessage(Text.of("Found" + name + "!"));
                        foundBlock = true;
                        break;

                    }
                    if (!foundBlock) {
                        player.sendMessage(Text.of("No Ore found!"));
                    }
                }
            }
        context.getStack().damage(1, player ,EquipmentSlot.MAINHAND);
        return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean isRightBlock(BlockState blockState){
        if (blockState.getBlock() == Blocks.DIAMOND_ORE || blockState.isOf(Blocks.IRON_ORE)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.tutorialmod.prospector.shift_tooltip"));
        }else {
            tooltip.add(Text.translatable("item.tutorialmod.prospector.tooltip"));
        }
    }
}

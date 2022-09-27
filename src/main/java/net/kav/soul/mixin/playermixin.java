package net.kav.soul.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(PlayerEntity.class)
public abstract class playermixin extends LivingEntity {


    protected playermixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
}

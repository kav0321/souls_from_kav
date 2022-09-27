package net.kav.soul.mixin;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.kav.soul.networking.ModMessages;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntity extends Entity {
    public LivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at =@At("HEAD"))
    public void onDeath(DamageSource source, CallbackInfo info)
    {
        Entity attacker = source.getAttacker();
        if(attacker instanceof PlayerEntity)
        {
            ClientPlayNetworking.send(ModMessages.PLAYER_SOUL, PacketByteBufs.create());
        }
    }

}

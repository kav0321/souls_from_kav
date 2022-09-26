package net.kav.soul.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.kav.soul.networking.ModMessages;
import net.kav.soul.networking.packet.PlayerStatsClient;
import net.kav.soul.networking.packet.PlayerStatsServer;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

import static net.kav.soul.networking.ModMessages.PLAYER_SOUL;

public class EntityDeath implements ServerEntityCombatEvents.AfterKilledOtherEntity{
    @Override
    public void afterKilledOtherEntity(ServerWorld world, Entity entity, LivingEntity killedEntity) {

        if(!world.isClient())
        {
            PlayerStatsClient.GET_HEALTH_OF_DEAD_ENTITY(killedEntity);
            SoulData.synSoul(((IEntityDataSaver) entity).getPersistentData().getInt("soul"), (ServerPlayerEntity) entity);
        }

    }
}

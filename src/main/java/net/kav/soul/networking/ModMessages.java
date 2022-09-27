package net.kav.soul.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.Soul;


import net.kav.soul.event.EntityDeath;
import net.kav.soul.networking.packet.PlayerStatsClient;
import net.kav.soul.networking.packet.PlayerStatsServer;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier PLAYER_SOUL = new Identifier(Soul.MOD_ID, "soul");
    public static final Identifier EXAMPLE_ID = new Identifier(Soul.MOD_ID,"example");
    public static final Identifier Soul_ID = new Identifier(Soul.MOD_ID,"soul");

    public static void registerC2SPackets(){
       ServerPlayNetworking.registerGlobalReceiver(PLAYER_SOUL, PlayerStatsClient::receive);
       // ServerPlayNetworking.registerGlobalReceiver(GAINING_SOUL_ID, SoulingC2SPacket::receiver);


    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(Soul_ID, PlayerStatsServer::receive);
        ClientPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, (client,handler,buf, respondSender)->
        {
           (((IEntityDataSaver) client.player)).getPersistentData().putInt("soul",buf.readInt());

          int a=SoulData.addNbtPoints(((IEntityDataSaver) client.player), EntityDeath.getSoulincrease(),"soul");
          GlobalSoul.setGlobalSoul(a);
          // SoulData.addNbtPoints(((IEntityDataSaver) client.player), EntityDeath.getSoulincrease(),"soul");
        });
    }
}

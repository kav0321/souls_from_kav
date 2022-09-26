package net.kav.soul.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.Soul;


import net.kav.soul.networking.packet.PlayerStatsClient;
import net.kav.soul.networking.packet.PlayerStatsServer;
import net.kav.soul.util.SoulData;
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
    }
}

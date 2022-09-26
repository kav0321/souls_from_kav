package net.kav.soul.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;

public class PlayerStatsServer {




    public static void receive(MinecraftClient client , ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {
        (((IEntityDataSaver) client.player)).getPersistentData().putInt("soul",buf.readInt());
        (((IEntityDataSaver) client.player)).getPersistentData().putInt("Intimidation_factor",buf.readInt());
        (((IEntityDataSaver) client.player)).getPersistentData().putInt("Insanity",buf.readInt());


    }




}

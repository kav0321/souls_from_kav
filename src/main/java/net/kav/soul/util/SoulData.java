package net.kav.soul.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.mixin.ModEntityDataSaverMixin;
//import net.kav.soul.networking.ModMessages;
import net.kav.soul.networking.ModMessages;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class SoulData {

    private static int soul;
    private static int Intimidation_factor;
    private static int Insanity;


    public static int addNbtPoints(IEntityDataSaver player, int amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getInt("soul");
        Intimidation_factor = nbt.getInt("Intimidation_factor");
        Insanity= nbt.getInt("Insanity");

        switch (string)
        {
            case "soul":

                if (soul >= 9999999) {
                    soul = 9999999;
                } else {
                    soul = soul + amount;
                }
                nbt.putInt("soul", soul);
                return soul;
            case "Intimidation_factor" :
                if (Intimidation_factor >= 100) {
                    Intimidation_factor = 100;
                } else {
                    Intimidation_factor = Intimidation_factor + amount;
                }
                nbt.putInt("Intimidation_factor",Intimidation_factor);
                return Intimidation_factor;
            case "Insanity":
                if (Insanity >= 100) {
                    Insanity = 100;
                } else {
                    Insanity = Insanity + amount;
                }
                nbt.putInt("Insanity",Insanity);
                return Insanity;
                //do nothing for now
            default:
                return 0;
        }
    }


    public static int removeNbtPoints(IEntityDataSaver player, int amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        soul=nbt.getInt("soul");
        Intimidation_factor = nbt.getInt("Intimidation_factor");
        Insanity= nbt.getInt("Insanity");

        switch (string)
        {
            case "soul":

                if (soul < 0) {
                    soul = 0;
                } else {
                    soul = soul - amount;
                }
                nbt.putInt("soul", soul);
                return soul;
            case "Intimidation_factor" :
                if (Intimidation_factor <0) {
                    Intimidation_factor = 0;
                } else {
                    Intimidation_factor = Intimidation_factor - amount;
                }
                nbt.putInt("Intimidation_factor",Intimidation_factor);
                return Intimidation_factor;
            case "Insanity":
                if (Insanity <0) {
                    Insanity = 0;
                } else {
                    Insanity = Insanity - amount;
                }
                nbt.putInt("Insanity",Insanity);
                return Insanity;
            //do nothing for now
            default:
                return 0;
        }
    }


   // public static int addsoul(IEntityDataSaver player, int amount) {
    //        NbtCompound nbt = player.getPersistentData();
    //        int soul = nbt.getInt("soul");
    //
    //        if (soul >= 9999999) {
    //            soul = 9999999;
    //        } else {
    //            soul = soul + amount;
    //        }
    //        synSoul(soul, ((ServerPlayerEntity) player));
    //        nbt.putInt("soul", soul);
    //
    //        return soul;
    //
    //    }

    //public static void setsoul(IEntityDataSaver player,int a)
    //    {
    //        NbtCompound nbt = player.getPersistentData();
    //        int soul = nbt.getInt("soul");
    //        soul=0;
    //
    //
    //
    //
    //        synSoul(soul, ((ServerPlayerEntity) player));
    //        nbt.putInt("soul", soul);
    //    }

    public static void synSoul(int soul, ServerPlayerEntity player)
    {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(soul);
       ServerPlayNetworking.send(player, ModMessages.Soul_ID, buffer);
    }




   //public static void setsoul(IEntityDataSaver player,int a)
    //    {
    //        NbtCompound nbt = player.getPersistentData();
    //        int soul = nbt.getInt("soul");
    //        soul=0;
    //
    //
    //
    //
    //        synSoul(soul, ((ServerPlayerEntity) player));
    //        nbt.putInt("soul", soul);
    //    }

}
package net.blay09.mods.inventoryessentials;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = InventoryEssentials.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InventoryEssentialsConfig {

    public static class Client {
        public final ForgeConfigSpec.BooleanValue forceClientImplementation;
        public final ForgeConfigSpec.BooleanValue enableSingleTransfer;
        public final ForgeConfigSpec.BooleanValue enableBulkTransfer;
        public final ForgeConfigSpec.BooleanValue enableBulkTransferAll;
        public final ForgeConfigSpec.BooleanValue enableShiftDrag;
        public final ForgeConfigSpec.BooleanValue enableBulkDrop;
        public final ForgeConfigSpec.BooleanValue allowBulkTransferAllOnEmptySlot;

        Client(ForgeConfigSpec.Builder builder) {
            builder.comment("Configuration for Inventory Essentials").push("client");

            forceClientImplementation = builder
                    .comment("Use the client implementation even on servers that have the mod installed - only useful for development purposes.")
                    .translation("config.inventoryessentials.forgeClientImplementation")
                    .define("forceClientImplementation", false);

            enableSingleTransfer = builder
                    .comment("Should ctrl-clicking only move one item at a time instead of the full stack?")
                    .translation("config.inventoryessentials.enableSingleTransfer")
                    .define("enableSingleTransfer", true);

            enableBulkTransfer = builder
                    .comment("Should shift-ctrl-clicking move all items of the same type at once?")
                    .translation("config.inventoryessentials.enableBulkTransfer")
                    .define("enableBulkTransfer", true);

            enableBulkTransferAll = builder
                    .comment("Should space-clicking an item move all items from that inventory at once?")
                    .translation("config.inventoryessentials.enableBulkTransferAll")
                    .define("enableBulkTransferAll", true);

            enableBulkDrop = builder
                    .comment("Should shift-ctrl-drop-clicking drop all items of the same type at once?")
                    .translation("config.inventoryessentials.enableBulkDrop")
                    .define("enableBulkDrop", true);

            allowBulkTransferAllOnEmptySlot = builder
                    .comment("Should space-clicking move all items even if an empty slot was clicked?")
                    .translation("config.inventoryessentials.allowBulkTransferAllOnEmptySlot")
                    .define("allowBulkTransferAllOnEmptySlot", false);

            enableShiftDrag = builder
                    .comment("Should holding shift and moving your mouse over items quick-transfer them without requiring each to be clicked?")
                    .translation("config.inventoryessentials.enableShiftDrag")
                    .define("enableShiftDrag", true);
        }
    }

    static final ForgeConfigSpec clientSpec;
    public static final Client CLIENT;

    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    private static ModConfig config;

    @SubscribeEvent
    public static void onConfigLoad(ModConfig.ModConfigEvent event) {
        config = event.getConfig();
    }

    public static void save() {
        config.save();
    }

}


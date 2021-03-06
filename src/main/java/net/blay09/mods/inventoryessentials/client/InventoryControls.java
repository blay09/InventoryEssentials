package net.blay09.mods.inventoryessentials.client;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.inventory.container.Slot;

public interface InventoryControls {
    boolean singleTransfer(ContainerScreen<?> screen, Slot clickedSlot);
    boolean bulkTransferByType(ContainerScreen<?> screen, Slot clickedSlot);
    boolean bulkTransferAll(ContainerScreen<?> screen, Slot clickedSlot);
    void dragTransfer(ContainerScreen<?> screen, Slot clickedSlot);
    boolean dropByType(ContainerScreen<?> screen, Slot hoverSlot);
}

package com.github.kayladillo.spelunkeries;

import com.github.kayladillo.spelunkeries.SpelunkeriesMod;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class ItemRegistration {
  public static ItemEntry<Item> R_ICON;

  public ItemRegistration () {
  }

  public static void registerItems (Registrate reg) {
    reg.creativeModeTab(()->ITEM_GROUP, "Spelunkeries");

    R_ICON = reg.item("test_item", Item::new)
    .properties(p->p.rarity(Rarity.EPIC))
    .lang("Spelunkeries Test Item")
    .register();

  }

  static InventoryChangeTrigger.TriggerInstance fromItem (Item item) {
    return InventoryChangeTrigger.TriggerInstance.hasItems(item);
  }

  public static class SpelunkeriesCreativeModeTab extends CreativeModeTab {
    private final Supplier<ItemStack> sup;
    public SpelunkeriesCreativeModeTab (final String name, final Supplier<ItemStack> supplier) {
      super(name);
      sup = supplier;
    }
    @Override
    public @NotNull ItemStack makeIcon () {
      return sup.get();
    }
  }
  public static final CreativeModeTab ITEM_GROUP = new SpelunkeriesCreativeModeTab(SpelunkeriesMod.MODID, () -> R_ICON.asStack());
}

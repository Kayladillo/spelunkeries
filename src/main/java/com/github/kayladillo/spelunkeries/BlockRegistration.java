package com.github.kayladillo.spelunkeries;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class BlockRegistration {
  public static BlockEntry<Block> R_TEST;

  public BlockRegistration () {
  }

  public static void registerBlocks (Registrate reg) {
    reg.creativeModeTab(()->ItemRegistration.ITEM_GROUP);

    R_TEST = reg.block("test_block", Block::new)
    .properties(p-> p.strength(1,4))
    .lang("Test Block")
    .simpleItem()
    .recipe((ctx,prov)-> ShapedRecipeBuilder.shaped(ctx.get())
      .pattern(" n ")
      .pattern(" c ")
      .define('n', Items.IRON_NUGGET)
      .define('c', Items.CRAFTING_TABLE)
      .unlockedBy("has_item", ItemRegistration.fromItem(Items.CRAFTING_TABLE))
      .save(prov))
    .register();
  }
}

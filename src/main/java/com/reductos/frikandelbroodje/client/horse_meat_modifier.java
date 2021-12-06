package com.reductos.frikandelbroodje.client;

import com.google.gson.JsonObject;
import com.reductos.frikandelbroodje.*;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class horse_meat_modifier extends LootModifier {

    private final Item itemReward;

    public horse_meat_modifier(LootItemCondition[] conditionsIn, Item reward) {
        super(conditionsIn);
        frikandelbroodje.LOGGER.info("constructor");
        for (LootItemCondition condition : conditionsIn) {
            frikandelbroodje.LOGGER.info(condition.toString());
        }
        itemReward = reward;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {

        int lootmodifier = context.getLootingModifier();

        if (lootmodifier > 0) {
            for (int i = 0; i < lootmodifier; i++)
                if (context.getRandom().nextInt() % 2 == 0) {
                    generatedLoot.add(new ItemStack(itemReward));
                }
        }
        if (context.getRandom().nextInt() % 2 == 0) {
            generatedLoot.add(new ItemStack(itemReward));
        }

        boolean onfire = Objects.requireNonNull(context.getParamOrNull(LootContextParams.THIS_ENTITY)).isOnFire();
        generatedLoot.add(new ItemStack(itemReward));
//        generatedLoot.forEach((e) -> frikandelbroodje.LOGGER.info(e.toString()));
        if (onfire) {
            ArrayList<ItemStack> ret = new ArrayList<>();
            generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
            return ret;
        } else {
            return generatedLoot;
        }
    }

    private static ItemStack smelt(ItemStack stack, LootContext context) {
        return context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
                .map(SmeltingRecipe::getResultItem)
                .filter(itemStack -> !itemStack.isEmpty())
                .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                .orElse(stack);
    }

    public static class Serializer extends GlobalLootModifierSerializer<horse_meat_modifier> {

        @Override
        public horse_meat_modifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            Item horse_meat = ForgeRegistries.ITEMS.getValue(new ResourceLocation((GsonHelper.getAsString(object, "item"))));
            return new horse_meat_modifier(conditionsIn, horse_meat);
        }

        @Override
        public JsonObject write(horse_meat_modifier instance) {
            return null;
        }


    }
}
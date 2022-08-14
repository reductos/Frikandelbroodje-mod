package com.reductos.frikandelbroodje.client;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.reductos.frikandelbroodje.*;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings("SpellCheckingInspection")
public class horse_meat_modifier extends LootModifier {

    public static final Supplier<Codec<horse_meat_modifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.itemReward)).apply(inst, horse_meat_modifier::new)));

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
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

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
            ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
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

    @Override
    public Codec<horse_meat_modifier> codec() {
        return CODEC.get();
    }
}
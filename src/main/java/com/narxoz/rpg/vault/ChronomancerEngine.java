package com.narxoz.rpg.vault;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.artifact.*;

public class ChronomancerEngine {
    public VaultRunResult runVault(Hero hero, Inventory inventory, Caretaker caretaker) {
        int rewinds = 0;

        System.out.println("\n--- ENTERING THE CHRONOMANCER's VAULT ---");
        hero.printStatus();

        System.out.println("\n[Saving State...] Time Crystal Activated");
        caretaker.save(hero.createMemento());

        System.out.println("\n[Trap Triggered!] A mimic attacks!");
        hero.takeDamage(45);
        hero.spendMana(20);
        hero.loseGold(150);
        hero.printStatus();

        System.out.println("\n[Rewinding Time...] Shattering Time Crystal!");
        hero.restoreFromMemento(caretaker.undo());
        rewinds++;
        hero.printStatus();

        System.out.println("\n--- APPRAISAL PHASE ---");

        GoldAppraiser goldAppraiser = new GoldAppraiser();
        EnchantmentScanner scanner = new EnchantmentScanner();
        CurseDetector detector = new CurseDetector();
        WeightCalculator weightCalc = new WeightCalculator();

        System.out.println("\n>> Enchantment Scan:");
        inventory.accept(scanner);

        System.out.println("\n>> Curse Detection:");
        inventory.accept(detector);

        System.out.println("\n>> Gold Valuation:");
        inventory.accept(goldAppraiser);
        System.out.println("Total Vault Value: " + goldAppraiser.getTotalValue() + "G");

        System.out.println("\n>> Physical Weight Analysis:");
        inventory.accept(weightCalc);
        System.out.println("Total Carry Weight: " + weightCalc.getTotalWeight() + " kg");

        return new VaultRunResult(true, rewinds);
    }
}
package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.List;

public class PartyComposite implements CombatNode {
    private String groupName;
    private List<CombatNode> members = new ArrayList<>();

    public PartyComposite(String groupName) {
        this.groupName = groupName;
    }

    public void addMember(CombatNode node) {
        members.add(node);
    }

    @Override
    public String getName() { return groupName; }

    @Override
    public int getAttackPower() {

        return members.stream().mapToInt(CombatNode::getAttackPower).sum();
    }

    @Override
    public void takeDamage(int amount) {
        System.out.println("Group " + groupName + " hit for " + amount);
        long aliveCount = members.stream().filter(CombatNode::isAlive).count();
        if (aliveCount > 0) {
            int damagePerUnit = amount / (int) aliveCount;
            for (CombatNode member : members) {
                if (member.isAlive()) {
                    member.takeDamage(damagePerUnit);
                }
            }
        }
    }

    @Override
    public boolean isAlive() {

        return members.stream().anyMatch(CombatNode::isAlive);
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ Group: " + groupName);
        for (CombatNode member : members) {
            member.printTree(indent + "  ");
        }
    }
}
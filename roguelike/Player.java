// Player.java
import java.io.PrintWriter;
import ansi_terminal.*;

public class Player extends Character {
    private Inventory items;

    public Player(Position start) {
        // our starting details
        super(start.getRow(), start.getCol(), '@', Color.CYAN, 50);

        // we can carry 100 pounds of items
        items = new Inventory(100);
	/**
	 * Creates default items of type Weapon, Armor, and Other
	 */
        items.addAndEquip(new Item(ItemType.Weapon, "Sword of Baulr", 5, 12, 7));
        items.addAndEquip(new Item(ItemType.Armor, "Steel Strapped boots", 15, 20, 3));
	items.addAndEquip(new Item(ItemType.Weapon, "Draglet Spear", 10, 10, 4));
	items.addAndEquip(new Item(ItemType.Other, "Wonder Cape", 5, 15, 2)); 
    }

    @Override
    public int getDamage() {
        Item weapon = items.getEquippedWeapon();
        if (weapon != null) {
            return weapon.getStrength();
        } else {
            // if we have no weapon, our fists are pretty weak...
            return 1;
        }
    }

    @Override
    public String getName() {
        return "Player";
    }

    @Override
    public int getProtection() {
        Item armor = items.getEquippedArmor();
        if (armor != null) {
            return armor.getStrength();
        } else {
            // without armor, we have no protection
            return 0;
        }
    }

    public Inventory getInventory() {
        return items;
    }
	/**
	 * Saves player HP, row, and column onto a separate file
	 */
    public void savePlayer (PrintWriter pw) {
	    super.save(pw);
	    pw.print(hp);
	    pw.print(row);
	    pw.print(col);
    }


}


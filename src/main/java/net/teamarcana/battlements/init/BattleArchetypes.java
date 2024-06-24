package net.teamarcana.battlements.init;

import net.neoforged.neoforge.common.ToolActions;
import net.teamarcana.battlements.api.weapon_type.Archetype;

import java.util.Set;

public class BattleArchetypes {
    public static final Archetype DAGGER = new Archetype(
            "dagger",2.5f, 1.0f, 2.5f,
            true, Set.of()
    );
    public static final Archetype LONGSWORD = new Archetype(
            "longsword",4.5f, 1.5f, 1.4f,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype GREATSWORD = new Archetype(
            "greatsword",5.0f, 1.5f, 1.3f,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype KATANA = new Archetype(
            "katana",3.5f, 0.5f, 2.0f,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype RAPIER = new Archetype(
            "rapier",2, 0.5f, 2.4f,
            true, Set.of()
    );
    public static final Archetype SABER = new Archetype(
            "saber",3.5f, 0.5f, 1.6f,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype CUTLASS = new Archetype(
            "cutlass",3f ,0.5f, 1.6f,
            true, Set.of()
    );
    public static final Archetype SICKLE = new Archetype(
            "sickle",2, 1.0f, 1.9f,
            true, ToolActions.DEFAULT_HOE_ACTIONS
    );
    public static final Archetype CLAW = new Archetype(
            "claw",2.0f, 0.5f, 3.5f,
            true, Set.of(ToolActions.SHOVEL_DIG, ToolActions.SHOVEL_FLATTEN)
    );
    public static final Archetype CLUB = new Archetype(
            "club",4.0f, 1.0f, 1.3f,
            false, Set.of()
    );
    public static final Archetype GREATCLUB = new Archetype(
            "greatclub",4.5f, 1.5f, 0.9f,
            false, Set.of()
    );
    public static final Archetype HAMMER = new Archetype(
            "hammer",4.2f, 1.5f, 1.0f,
            false, Set.of()
    );
    public static final Archetype WARHAMMER = new Archetype(
            "warhammer",4.0f, 1.5f, 1.1f,
            false, Set.of()
    );
    public static final Archetype MAUL = new Archetype(
            "maul",5.0f, 2.0f, 0.75f,
            false, Set.of()
    );
    public static final Archetype MACE = new Archetype(
            "mace",3.0f, 1.5f,1.2f,
            false, Set.of()
    );
    public static final Archetype ANCHOR = new Archetype(
            "anchor", 4.1f, 1.6f, 1.0f,
            false, Set.of()
    );
    public static final Archetype WARPICK = new Archetype(
            "warpick", 3.0f, 1.0f, 1.5f,
            true, ToolActions.DEFAULT_PICKAXE_ACTIONS
    );
    public static final Archetype BATTLEAXE = new Archetype(
            "battleaxe",4.0f, 2.0f, 1.0f,
            true, ToolActions.DEFAULT_AXE_ACTIONS
    );
    public static final Archetype GREATAXE = new Archetype(
            "greataxe",4.2f, 2.1f, 0.8f,
            true, ToolActions.DEFAULT_AXE_ACTIONS
    );
    public static final Archetype SPEAR = new Archetype(
            "spear",5.5f, 0.5f, 1.4f,
            true, Set.of()
    );
    public static final Archetype PIKE = new Archetype(
            "pike",4.0f, 1.0f, 1.4f,
            true, Set.of()
    );
    public static final Archetype HALBERD = new Archetype(
            "halberd",5.0f, 1.5f, 1.2f,
            true, Set.of()
    );
    public static final Archetype GLAIVE = new Archetype(
            "glaive",4.0f, 1.5f, 1.0f,
            true, Set.of()
    );
    public static final Archetype QUARTERSTAFF = new Archetype(
            "quarterstaff", 3.0f, 1.5f, 1.4f,
            false, Set.of()
    );
    public static final Archetype PITCHFORK = new Archetype(
            "pitchfork",5, 0.5f, 1.2f,
            true, Set.of()
    );
    public static final Archetype SCYTHE = new Archetype(
            "scythe",5.0f, 1.0f, 1.0f,
            true, ToolActions.DEFAULT_HOE_ACTIONS
    );
    public static final Archetype BOOMERANG = new Archetype(
            "boomerang", 4, 1, 2,
            false, Set.of()
    );
    public static final Archetype JAVELIN = new Archetype(
            "javelin",1.5f, 1.0f, 1.2f,
            false, Set.of()
    );
    public static final Archetype KUNAI = new Archetype(
            "kunai",1.3f, 1.3f, 2.8f,
            true, Set.of()
    );
    public static final Archetype TOMAHAWK = new Archetype(
            "tomahawk",2.0f, 1.5f, 0.9f,
            true, Set.of()
    );
    public static final Archetype THROWING_KNIFE = new Archetype(
            "throwing_knife",1.5f, 1.0f, 2.5f,
            true, Set.of()
    );
}

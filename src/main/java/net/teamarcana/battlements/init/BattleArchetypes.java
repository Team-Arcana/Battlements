package net.teamarcana.battlements.init;

import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.ToolActions;
import net.teamarcana.battlements.Battlements;
import net.teamarcana.battlements.api.archetype.Archetype;
import java.util.Set;

public class BattleArchetypes {
    public static final Archetype DAGGER = new Archetype(
            "dagger", Battlements.MOD_ID,2.5f, 1.0f, 2.5f, 0,
            true, Set.of()
    );
    public static final Archetype LONGSWORD = new Archetype(
            "longsword", Battlements.MOD_ID,4.5f, 1.5f, 1.4f, 0.3f,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype GREATSWORD = new Archetype(
            "greatsword", Battlements.MOD_ID,5.0f, 1.5f, 1.3f, 1,
            true, Set.of(ToolActions.SWORD_DIG)
    ).setTwoHanded(2);
    public static final Archetype KATANA = new Archetype(
            "katana", Battlements.MOD_ID,3.5f, 0.5f, 2.0f, 0.5f,
            true, Set.of(ToolActions.SWORD_DIG)
    ).setTwoHanded(1);
    public static final Archetype RAPIER = new Archetype(
            "rapier", Battlements.MOD_ID,2, 0.5f, 2.4f, 0,
            true, Set.of()
    );
    public static final Archetype SABER = new Archetype(
            "saber", Battlements.MOD_ID,3.5f, 0.5f, 1.6f,0,
            true, Set.of(ToolActions.SWORD_DIG)
    );
    public static final Archetype CUTLASS = new Archetype(
            "cutlass", Battlements.MOD_ID,3f ,0.5f, 1.6f,0,
            true, Set.of()
    );
    public static final Archetype SICKLE = new Archetype(
            "sickle", Battlements.MOD_ID,2, 1.0f, 1.9f,0,
            true, ToolActions.DEFAULT_HOE_ACTIONS
    );
    public static final Archetype CLAW = new Archetype(
            "claw", Battlements.MOD_ID,2.0f, 0.5f, 3.5f,0,
            true, Set.of(ToolActions.SHOVEL_DIG, ToolActions.SHOVEL_FLATTEN), BlockTags.MINEABLE_WITH_SHOVEL
    );
    public static final Archetype CLUB = new Archetype(
            "club", Battlements.MOD_ID,4.0f, 1.0f, 1.3f,0,
            false, Set.of()
    );
    public static final Archetype GREATCLUB = new Archetype(
            "greatclub", Battlements.MOD_ID,4.5f, 1.5f, 0.9f,1,
            false, Set.of()
    ).setTwoHanded(1);
    public static final Archetype HAMMER = new Archetype(
            "hammer", Battlements.MOD_ID,4.2f, 1.5f, 1.0f,0,
            false, Set.of()
    );
    public static final Archetype WARHAMMER = new Archetype(
            "warhammer", Battlements.MOD_ID,4.0f, 1.5f, 1.1f,0.2f,
            false, Set.of()
    ).setTwoHanded(1);
    public static final Archetype MAUL = new Archetype(
            "maul", Battlements.MOD_ID,5.0f, 2.0f, 0.75f,1,
            false, Set.of()
    ).setTwoHanded(2);
    public static final Archetype ANCHOR = new Archetype(
            "anchor", Battlements.MOD_ID, 4.1f, 1.6f, 1.0f,0.5f,
            false, Set.of()
    );
    public static final Archetype WARPICK = new Archetype(
            "warpick", Battlements.MOD_ID, 3.0f, 1.0f, 1.5f, 0,
            true, ToolActions.DEFAULT_PICKAXE_ACTIONS, BlockTags.MINEABLE_WITH_PICKAXE
    );
    public static final Archetype BATTLEAXE = new Archetype(
            "battleaxe", Battlements.MOD_ID,4.0f, 2.0f, 1.0f, 0,
            true, ToolActions.DEFAULT_AXE_ACTIONS, BlockTags.MINEABLE_WITH_AXE
    );
    public static final Archetype GREATAXE = new Archetype(
            "greataxe", Battlements.MOD_ID,4.8f, 2.1f, 0.8f, 0.5f,
            true, ToolActions.DEFAULT_AXE_ACTIONS, BlockTags.MINEABLE_WITH_AXE
    ).setTwoHanded(1);
    public static final Archetype SPEAR = new Archetype(
            "spear", Battlements.MOD_ID,5.5f, 0.5f, 1.4f, 1f,
            true, Set.of()
    );
    public static final Archetype PIKE = new Archetype(
            "pike", Battlements.MOD_ID,4.0f, 1.0f, 1.4f, 2,
            true, Set.of()
    ).setTwoHanded(1);
    public static final Archetype HALBERD = new Archetype(
            "halberd", Battlements.MOD_ID,5.0f, 1.5f, 1.2f, 1f,
            true, Set.of()
    ).setTwoHanded(2);
    public static final Archetype GLAIVE = new Archetype(
            "glaive", Battlements.MOD_ID,4.0f, 1.5f, 1.0f, 1f,
            true, Set.of()
    );
    public static final Archetype QUARTERSTAFF = new Archetype(
            "quarterstaff", Battlements.MOD_ID, 3.0f, 1.5f, 1.4f, 1f,
            false, Set.of()
    );
    public static final Archetype PITCHFORK = new Archetype(
            "pitchfork", Battlements.MOD_ID,5, 0.5f, 1.2f, 1f,
            true, Set.of()
    );
    public static final Archetype SCYTHE = new Archetype(
            "scythe", Battlements.MOD_ID,5.0f, 1.0f, 1.0f, 1,
            true, ToolActions.DEFAULT_HOE_ACTIONS
    ).setTwoHanded(1);
    public static final Archetype BOOMERANG = new Archetype(
            "boomerang", Battlements.MOD_ID, 4, 1, 2, 0,
            false, Set.of()
    );
    public static final Archetype JAVELIN = new Archetype(
            "javelin", Battlements.MOD_ID,1.5f, 1.0f, 1.2f, 0.5f,
            false, Set.of()
    );
    public static final Archetype KUNAI = new Archetype(
            "kunai", Battlements.MOD_ID,1.3f, 1.3f, 2.8f, 0,
            true, Set.of()
    );
    public static final Archetype TOMAHAWK = new Archetype(
            "tomahawk", Battlements.MOD_ID,2.0f, 1.5f, 0.9f, 0,
            true, Set.of()
    );
    public static final Archetype THROWING_KNIFE = new Archetype(
            "throwing_knife", Battlements.MOD_ID,1.5f, 1.0f, 2.5f, 0,
            true, Set.of()
    );
}

package net.teamarcana.battlements.api;

import java.util.ArrayList;
import java.util.List;


/**
 * Handler for getting the stuff to reload
 */
public class ReloadHandler {
    private static List<IReloadable> reloadList = new ArrayList<IReloadable>(768);
    public static void addToReloadables(IReloadable reloadable){ reloadList.add(reloadable); }
    public static List<IReloadable> getReloadList(){ return reloadList; }

}

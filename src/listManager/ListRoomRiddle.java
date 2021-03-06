
package listManager;

import java.io.Serializable;
import java.util.ArrayList;
import objects.RoomRiddle;

/**
 *
 * @author Pedro Rodriguez
 */
public class ListRoomRiddle implements Cloneable, Serializable{

    private static final ListRoomRiddle INSTANCE = new ListRoomRiddle();
    private ArrayList<RoomRiddle> listRiddle;

    public static ListRoomRiddle getInstance() {
        return INSTANCE;
    }

    private ListRoomRiddle() {
        listRiddle = new ArrayList<>();
    }

    public void addRiddle(RoomRiddle riddle) {
        listRiddle.add(riddle);
    }

    @Override
    public String toString() {
        return "ManagerRiddle{" + "listRiddle=" + listRiddle + '}';
    }

    public ArrayList<RoomRiddle> getListRiddle() {
        return listRiddle;
    }

    public void setListRiddle(ArrayList<RoomRiddle> listRiddle) {
        this.listRiddle = listRiddle;
    }

    public ArrayList<RoomRiddle> copy() throws CloneNotSupportedException {
        ArrayList<RoomRiddle> aux = new ArrayList<>();
        for (int i = 0; i < listRiddle.size(); i++) {
            aux.add((RoomRiddle) listRiddle.get(i).clone());
        }
        return aux;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return copy();
    }

}
